package me.tofaa.entitylib.event;

import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

final class EventBusAsync implements EventBus.Async {

    private final Map listeners = new ConcurrentHashMap();
    private final ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 4, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

    @Override
    public <T extends EntityLibEvent> void addListener(@NotNull EventListener<T> listener) {
        if (listeners.containsKey(listener.getEventClass())) {
            listeners.put(listener.getEventClass(), new HashSet<>());
        }
        ((HashSet) listeners.get(listener.getEventClass())).add(listener);
    }

    @Override
    public <T extends EntityLibEvent> void addListener(@NotNull Class<T> eventClass, @NotNull Consumer<T> consumer) {
        addListener(EventListener.generateListener(eventClass, consumer));

    }

    @Override
    public <T extends EntityLibEvent> void removeListener(@NotNull EventListener<T> listener) {
        if (listeners.containsKey(listener.getEventClass())) {
            ((HashSet) listeners.get(listener.getEventClass())).remove(listener);
        }
    }

    @Override
    public <T extends EntityLibEvent> @NotNull T call(@NotNull T event) {
        executor.execute(() -> dispatchEvent(event));
        return event;
    }


    private <T extends EntityLibEvent> void dispatchEvent(T event) {
        if (!listeners.containsKey(event.getClass())) return;
        HashSet<EventListener<T>> consumers = (HashSet<EventListener<T>>) listeners.get(event.getClass());
        consumers.forEach(consumer -> consumer.handle(event));
    }


    @Override
    public <T extends EntityLibEvent> void call(@NotNull T event, @NotNull Consumer<T> completionCallback) {
        executor.execute(() -> {
            dispatchEvent(event);
            completionCallback.accept(event);
        });
    }
}
