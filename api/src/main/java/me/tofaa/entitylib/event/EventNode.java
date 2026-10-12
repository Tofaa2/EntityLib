package me.tofaa.entitylib.event;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class EventNode<T extends EntityLibEvent> {

    private static final Logger LOGGER = Logger.getLogger("EntityLib");
    private static final Object LOCK = new Object();
    private static final Consumer<Object>[] EMPTY = newArray(0);
    private static final VarHandle COMPILED;

    static {
        try {
            COMPILED = MethodHandles.lookup().findVarHandle(Handle.class, "compiled", Consumer[].class);
        } catch (ReflectiveOperationException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    private static final class Handle {
        final Class<?> type;
        @SuppressWarnings("unused")
        private Consumer<Object>[] compiled;

        Handle(Class<?> type) {
            this.type = type;
        }
    }

    private static final class Entry {
        final int priority;
        final Consumer<Object> consumer;

        Entry(int priority, Consumer<Object> consumer) {
            this.priority = priority;
            this.consumer = consumer;
        }
    }

    private final String name;
    private final Class<T> eventType;
    private final Predicate<T> filter;
    private final List<EventNode<? extends T>> children = new ArrayList<>();
    private final List<EventListener<? extends T>> listeners = new ArrayList<>();
    private final List<Handle> created = new ArrayList<>();
    private final ClassValue<Handle> handles = new ClassValue<Handle>() {
        @Override
        protected Handle computeValue(@NotNull Class<?> type) {
            synchronized (LOCK) {
                Handle handle = new Handle(type);
                created.add(handle);
                return handle;
            }
        }
    };
    private EventNode<?> parent;
    private int priority;

    private EventNode(String name, Class<T> eventType, Predicate<T> filter) {
        this.name = name;
        this.eventType = eventType;
        this.filter = filter;
    }

    public static @NotNull EventNode<EntityLibEvent> all(@NotNull String name) {
        return new EventNode<>(name, EntityLibEvent.class, null);
    }

    public static <E extends EntityLibEvent> @NotNull EventNode<E> type(@NotNull String name, @NotNull Class<E> eventType) {
        return new EventNode<>(name, eventType, null);
    }

    public static <E extends EntityLibEvent> @NotNull EventNode<E> type(@NotNull String name, @NotNull Class<E> eventType,
                                                                      @NotNull Predicate<E> filter) {
        return new EventNode<>(name, eventType, filter);
    }

    public @NotNull String getName() {
        return name;
    }

    public @NotNull Class<T> getEventType() {
        return eventType;
    }

    public int getPriority() {
        return priority;
    }

    public @NotNull EventNode<T> setPriority(int priority) {
        synchronized (LOCK) {
            this.priority = priority;
            if (parent != null) {
                parent.invalidate();
            }
        }
        return this;
    }

    public @Nullable EventNode<?> getParent() {
        return parent;
    }

    public <E extends T> @NotNull EventNode<T> addListener(@NotNull Class<E> eventType, @NotNull Consumer<E> handler) {
        return addListener(EventListener.of(eventType, handler));
    }

    public <E extends T> @NotNull EventNode<T> addListener(@NotNull EventListener<E> listener) {
        synchronized (LOCK) {
            listeners.add(listener);
            invalidate();
        }
        return this;
    }

    public @NotNull EventNode<T> removeListener(@NotNull EventListener<? extends T> listener) {
        synchronized (LOCK) {
            if (listeners.remove(listener)) {
                invalidate();
            }
        }
        return this;
    }

    public @NotNull EventNode<T> addChild(@NotNull EventNode<? extends T> child) {
        synchronized (LOCK) {
            if (child.parent != null) {
                throw new IllegalStateException("Event node " + child.name + " already has a parent");
            }
            for (EventNode<?> node = this; node != null; node = node.parent) {
                if (node == child) {
                    throw new IllegalStateException("Event node " + child.name + " cannot be its own descendant");
                }
            }
            child.parent = this;
            children.add(child);
            invalidate();
        }
        return this;
    }

    public @NotNull EventNode<T> removeChild(@NotNull EventNode<? extends T> child) {
        synchronized (LOCK) {
            if (children.remove(child)) {
                child.parent = null;
                invalidate();
            }
        }
        return this;
    }

    public <E extends T> @NotNull E call(@NotNull E event) {
        dispatch(event);
        return event;
    }

    public <E extends T> void callCancellable(@NotNull E event, @NotNull Runnable whenNotCancelled) {
        dispatch(event);
        if (!(event instanceof Cancellable) || !((Cancellable) event).isCancelled()) {
            whenNotCancelled.run();
        }
    }

    public boolean hasListener(@NotNull Class<? extends T> eventType) {
        return compiled(handles.get(eventType)).length != 0;
    }

    private void dispatch(Object event) {
        for (Consumer<Object> consumer : compiled(handles.get(event.getClass()))) {
            consumer.accept(event);
        }
    }

    @SuppressWarnings("unchecked")
    private Consumer<Object>[] compiled(Handle handle) {
        Consumer<Object>[] compiled = (Consumer<Object>[]) COMPILED.getAcquire(handle);
        return compiled != null ? compiled : compile(handle);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private Consumer<Object>[] compile(Handle handle) {
        synchronized (LOCK) {
            Consumer<Object>[] existing = (Consumer<Object>[]) COMPILED.getAcquire(handle);
            if (existing != null) {
                return existing;
            }
            List<Entry> entries = new ArrayList<>();
            for (EventListener<? extends T> listener : listeners) {
                if (listener.eventType().isAssignableFrom(handle.type)) {
                    entries.add(new Entry(listener.priority(), listenerConsumer((EventListener) listener)));
                }
            }
            for (EventNode<? extends T> child : children) {
                if (!child.eventType.isAssignableFrom(handle.type)) {
                    continue;
                }
                EventNode raw = child;
                if (raw.compiled((Handle) raw.handles.get(handle.type)).length == 0) {
                    continue;
                }
                Predicate<Object> childFilter = (Predicate<Object>) (Predicate) child.filter;
                entries.add(new Entry(child.priority, childFilter == null
                    ? raw::dispatch
                    : event -> {
                        if (childFilter.test(event)) {
                            raw.dispatch(event);
                        }
                    }));
            }
            entries.sort((a, b) -> Integer.compare(a.priority, b.priority));
            Consumer<Object>[] result = entries.isEmpty() ? EMPTY : newArray(entries.size());
            for (int i = 0; i < result.length; i++) {
                result[i] = entries.get(i).consumer;
            }
            COMPILED.setRelease(handle, result);
            return result;
        }
    }

    private Consumer<Object> listenerConsumer(EventListener<EntityLibEvent> listener) {
        return event -> {
            try {
                if (listener.run((EntityLibEvent) event) == EventListener.Result.EXPIRED) {
                    removeExpired(listener);
                }
            } catch (Throwable throwable) {
                LOGGER.log(Level.SEVERE, "A listener of " + event.getClass().getSimpleName() + " in event node " + name
                    + " threw an exception", throwable);
            }
        };
    }

    private void removeExpired(EventListener<?> listener) {
        synchronized (LOCK) {
            if (listeners.remove(listener)) {
                invalidate();
            }
        }
    }

    private void invalidate() {
        for (EventNode<?> node = this; node != null; node = node.parent) {
            for (Handle handle : node.created) {
                COMPILED.setRelease(handle, (Consumer<Object>[]) null);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private static Consumer<Object>[] newArray(int size) {
        return new Consumer[size];
    }

    @Override
    public String toString() {
        return "EventNode{" + name + "}";
    }

}
