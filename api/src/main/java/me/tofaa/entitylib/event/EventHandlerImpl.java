package me.tofaa.entitylib.event;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

final class EventHandlerImpl implements EventHandler {

    // Events
    private final Map<Class<? extends EntityLibEvent>, Collection<EventCallback>> eventCallbacks = new ConcurrentHashMap<>();

    EventHandlerImpl() {
    }

    public <T extends EntityLibEvent> void  registerListener(EventListener<T> listener) {
        addEventCallback(listener.getEventClass(), EventListener.createEventCallback(listener));
    }

    @NotNull
    @Override
    public Map<Class<? extends EntityLibEvent>, Collection<EventCallback>> getEventCallbacksMap() {
        return eventCallbacks;
    }

}
