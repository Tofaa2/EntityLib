package me.tofaa.entitylib.event;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.stream.Stream;

/**
 * Represents an element which can have {@link EntityLibEvent} listeners assigned to it.
 */
public interface EventHandler {

    static @NotNull EventHandler create() {
        return new EventHandlerImpl();
    }

    /**
     * Gets a {@link Map} containing all the listeners assigned to a specific {@link EntityLibEvent} type.
     *
     * @return a {@link Map} with all the listeners
     */
    @NotNull
    Map<Class<? extends EntityLibEvent>, Collection<EventCallback>> getEventCallbacksMap();

    /**
     * Adds a new event callback for the specified type {@code eventClass}.
     *
     * @param eventClass    the event class
     * @param eventCallback the event callback
     * @param <E>           the event type
     * @return true if the callback collection changed as a result of the call
     */
    default <E extends EntityLibEvent> boolean addEventCallback(@NotNull Class<E> eventClass, @NotNull EventCallback<E> eventCallback) {
        Collection<EventCallback> callbacks = getEventCallbacks(eventClass);
        return callbacks.add(eventCallback);
    }

    /**
     * Removes an event callback.
     *
     * @param eventClass    the event class
     * @param eventCallback the event callback
     * @param <E>           the event type
     * @return true if the callback was removed as a result of this call
     */
    default <E extends EntityLibEvent> boolean removeEventCallback(@NotNull Class<E> eventClass, @NotNull EventCallback<E> eventCallback) {
        Collection<EventCallback> callbacks = getEventCallbacks(eventClass);
        return callbacks.remove(eventCallback);
    }

    /**
     * Gets the event callbacks of a specific event type.
     *
     * @param eventClass the event class
     * @param <E>        the event type
     * @return all event callbacks for the specified type {@code eventClass}
     */
    @NotNull
    default <E extends EntityLibEvent> Collection<EventCallback> getEventCallbacks(@NotNull Class<E> eventClass) {
        return getEventCallbacksMap().computeIfAbsent(eventClass, clazz -> new CopyOnWriteArraySet<>());
    }

    /**
     * Gets a {@link Stream} containing all the {@link EventCallback}, no matter to which {@link EntityLibEvent} they are linked.
     *
     * @return a {@link Stream} containing all the callbacks
     */
    @NotNull
    default Stream<EventCallback> getEventCallbacks() {
        return getEventCallbacksMap().values().stream().flatMap(Collection::stream);
    }

    /**
     * Calls the specified {@link EntityLibEvent} with all the assigned {@link EventCallback}.
     * <p>
     * Events are always called in the current thread.
     *
     * @param eventClass the event class
     * @param event      the event object
     * @param <E>        the event type
     */
    default <E extends EntityLibEvent> void callEvent(@NotNull Class<E> eventClass, @NotNull E event) {
        final Collection<EventCallback> eventCallbacks = getEventCallbacks(eventClass);
        runEvent(eventCallbacks, event);
    }

    /**
     * Calls a {@link CancellableEntityLibEvent} and execute {@code successCallback} if the {@link EntityLibEvent} is not cancelled.
     * <p>
     * Does call {@link #callEvent(Class, EntityLibEvent)} internally.
     *
     * @param eventClass      the event class
     * @param event           the event object
     * @param successCallback the callback called when the event is not cancelled
     * @param <E>             the event type
     * @see #callEvent(Class, EntityLibEvent)
     */
    default <E extends EntityLibEvent & CancellableEntityLibEvent> void callCancellableEvent(@NotNull Class<E> eventClass,
                                                                           @NotNull E event,
                                                                           @NotNull Runnable successCallback) {
        callEvent(eventClass, event);
        if (!event.isCancelled()) {
            successCallback.run();
        }
    }

    default <E extends EntityLibEvent> void runEvent(@NotNull Collection<EventCallback> eventCallbacks, @NotNull E event) {
        for (EventCallback<E> eventCallback : eventCallbacks) {
            eventCallback.run(event);
        }
    }

}