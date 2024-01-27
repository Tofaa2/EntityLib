package me.tofaa.entitylib.event;

import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

/**
 * A basic EventBus for scheduling and handling {@link EntityLibEvent}
 */
public interface EventBus {

    static @NotNull EventBus newBus(boolean async) {
        return async ? new EventBusAsync() : new EventBusSync();
    }

    /**
     * Adds a listener to the EventBus.
     * @param listener The listener object
     * @param <T> The type of {@link EntityLibEvent}
     */
    <T extends EntityLibEvent> void addListener(@NotNull EventListener<T> listener);

    /**
     * Adds a listener to the EventBus.
     * @param eventClass The events class
     * @param consumer The consumer for the event.
     * @param <T> The type of {@link EntityLibEvent}
     */
    <T extends EntityLibEvent> void addListener(@NotNull Class<T> eventClass, @NotNull Consumer<T> consumer);

    /**
     * Removes a listener from the EventBus.
     * @param listener the listener object.
     * @param <T> The type of {@link EntityLibEvent}
     */
    <T extends EntityLibEvent> void removeListener(@NotNull EventListener<T> listener);

    /**
     * Calls the event and processes all the attached {@link EventListener} for the event.
     * If your bus is async, rather than using this, use {@link Async#call(EntityLibEvent, Consumer)} to avoid any race conditions.
     * @param event the event object to process handlers for.
     * @return the same event object, but already modified.
     * @param <T> The type of {@link EntityLibEvent}
     */
    <T extends EntityLibEvent> @NotNull T call(@NotNull T event);


    interface Async extends EventBus {

        /**
         * A safer way to handle and process an event. Does exactly what {@link EventBus#call(EntityLibEvent)} does but allows you to attach a callback, rather than working with it yourself,
         * the callback is executed on the thread this is called, and not the main thread.
         * @param event the event object to process handlers for.
         * @param completionCallback the callback handled after the event is consumed async
         * @param <T> The type of {@link EntityLibEvent}
         */
        <T extends EntityLibEvent> void call(@NotNull T event, @NotNull Consumer<T> completionCallback);

    }

}
