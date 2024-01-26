package me.tofaa.entitylib;

import me.tofaa.entitylib.event.EntityLibEvent;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;
import java.util.logging.Logger;

/**
 * A generic representation of a platform that EntityLib is running on.
 * @param <P> The platform handle, for Spigot this would be a JavaPlugin. etc etc.
 */
public interface Platform<P> {


    /**
     * @return the logger EntityLib uses internally.
     */
    @NotNull Logger getLogger();

    /**
     * Sends an event to the platform. Platform implementations should handle the event accordingly.
     * @param event the event to send.
     */
    void sendEvent(EntityLibEvent event);

    /**
     * Registers a listener for the given event class, the handle will be called when the event is sent.
     * @param eventClass the event class to listen for.
     * @param handle the handle to call when the event is sent.
     * @param <T> the event type.
     */
    <T extends EntityLibEvent> void registerListener(Class<T> eventClass, Consumer<T> handle);

    /**
     * Sets up the API for the platform. This method should be called automatically by the platform. Don't call it yourself.
     * @param settings
     */
    void setupApi(@NotNull APISettings settings);

    /**
     * @return The API instance.
     */
    EntityLibAPI<?, ?> getAPI();

    /**
     * @return the platforms name.
     */
    String getName();

    @NotNull P getHandle();

}
