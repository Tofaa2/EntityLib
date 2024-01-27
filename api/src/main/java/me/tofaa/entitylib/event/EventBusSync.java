package me.tofaa.entitylib.event;


import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

@SuppressWarnings("unchecked")
class EventBusSync implements EventBus {

    private final Map listeners = new ConcurrentHashMap();

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
        if (!listeners.containsKey(event.getClass())) return event;
        HashSet<EventListener<T>> consumers = (HashSet<EventListener<T>>) listeners.get(event.getClass());
        consumers.forEach(consumer -> consumer.handle(event));
        return event;
    }
}
