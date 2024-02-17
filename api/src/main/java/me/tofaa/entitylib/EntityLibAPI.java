package me.tofaa.entitylib;

import com.github.retrooper.packetevents.PacketEventsAPI;
import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.protocol.player.UserProfile;
import com.github.retrooper.packetevents.protocol.world.Location;
import me.tofaa.entitylib.tick.TickContainer;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import me.tofaa.entitylib.wrapper.WrapperPlayer;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.UUID;

/**
 * Represents the API for EntityLib.
 * Handles the loading, enabling, and disabling of the API. And handles platform specific creation of EntityLib content.
 * @param <T> The {@link TickContainer}'s param type for the platform specific TickContainer.
 */
public interface EntityLibAPI<T> {

    /**
     * @return The {@link PacketEventsAPI} that EntityLib uses.
     */
    PacketEventsAPI<?> getPacketEvents();

    void onLoad();

    void onEnable();

    @NotNull WrapperPlayer spawnPlayer(UserProfile profile, Location location);

    @NotNull <T extends WrapperEntity> T spawnEntity(@NotNull Class<T> wrapperClass, @NotNull EntityType entityType, @NotNull Location location);

    @NotNull WrapperEntity spawnEntity(@NotNull EntityType entityType, @NotNull Location location);

    @NotNull <T extends WrapperEntity> T spawnEntity(@NotNull T entity, @NotNull Location location);

    @NotNull <T extends WrapperEntity> T cloneEntity(@NotNull Object platformEntity, @NotNull Location location);

    @Nullable WrapperEntity getEntity(int id);

    @Nullable WrapperEntity getEntity(@NotNull UUID uuid);

    void removeEntity(WrapperEntity entity);

    @NotNull Collection<WrapperEntity> getAllEntities();

    /**
     * @return The {@link APIConfig} for the API.
     */
    @NotNull APIConfig getSettings();

    /**
     * @return An unmodifiable collection of TickContainers.
     */
    @NotNull Collection<TickContainer<?, T>> getTickContainers();

    /**
     * Adds a TickContainer to the API. Automatically starts ticking it.
     * @param tickContainer the TickContainer to add.
     */
    void addTickContainer(@NotNull TickContainer<?, T> tickContainer);
}
