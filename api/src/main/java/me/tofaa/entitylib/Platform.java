package me.tofaa.entitylib;

import me.tofaa.entitylib.event.EventBus;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Logger;

/**
 * A generic representation of a platform that EntityLib is running on.
 * @param <P> The platform handle, for Spigot this would be a JavaPlugin. etc etc.
 */
public interface Platform<P> {

    /**
     * Gets the entityId integer provider. This can be provided by a platform if needed.
     * @return the entityId integer provider.
     */
    @NotNull EntityIdProvider getEntityIdProvider();

    /**
     * Gets the UUID provider for entities. This can be provided by a platform if needed.
     * @return the UUID provider for entities.
     */
    @NotNull EntityUuidProvider getEntityUuidProvider();

    /**
     * Sets the entityId integer provider. This can be provided by a platform if needed.
     * @param provider the entityId integer provider.
     */
    void setEntityIdProvider(@NotNull EntityIdProvider provider);

    /**
     * Sets the UUID provider for entities. This can be provided by a platform if needed.
     * @param provider
     */
    void setEntityUuidProvider(@NotNull EntityUuidProvider provider);


    /**
     * @return the logger EntityLib uses internally.
     */
    @NotNull Logger getLogger();

    /**
     * Gets the event bus for the platform.
     * WARNING: If you have {@link APIConfig#shouldUseAsyncEvents()} set to true, cast this to {@link EventBus.Async} when handling cancelled events.
     * @return
     */
    @NotNull EventBus getEventBus();

    /**
     * Sets up the API for the platform. This method should be called automatically by the platform. Don't call it yourself.
     * @param settings
     */
    void setupApi(@NotNull APIConfig settings);

    /**
     * @return The API instance.
     */
    EntityLibAPI<?> getAPI();

    /**
     * @return the platforms name.
     */
    String getName();

    @NotNull P getHandle();

}
