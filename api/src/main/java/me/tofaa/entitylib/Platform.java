package me.tofaa.entitylib;

import me.tofaa.entitylib.event.EventHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 * A generic representation of a platform that EntityLib is running on.
 * @param <P> The platform handle, for Spigot this would be a JavaPlugin. etc etc.
 */
public interface Platform<P> {


    /**
     * Queries a stream of platform specific entities if the platform supports
     * @throws UnsupportedOperationException if the platform does not support querying entities.
     * @return a stream of platform specific entities. The stream is not guaranteed to be synchronized.
     */
    @NotNull Stream<TrackedEntity> queryPlatformEntities();

    /**
     * Finds a platform specific entity by its entityId.
     * @param entityId the entityId of the entity.
     * @return a future that completes with the entity if found, or null if not found.
     * @throws UnsupportedOperationException if the platform does not support querying entities.
     */
    @Nullable TrackedEntity findPlatformEntity(int entityId);

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
     * Gets the event handler for the platform.
     * @return
     */
    @NotNull EventHandler getEventHandler();

    /**
     * Sets up the API for the platform. This method should be called automatically by the platform. Don't call it yourself.
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

    default void logIfNeeded(String message) {
        if (getAPI().getSettings().isDebugMode()) {
            getLogger().info(message);
        }
    }

}
