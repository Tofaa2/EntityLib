package me.tofaa.entitylib;

import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.protocol.world.Dimension;
import com.github.retrooper.packetevents.protocol.world.Location;
import com.github.retrooper.packetevents.protocol.world.states.WrappedBlockState;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.UUID;

/**
 * Represents a platform specific world.
 * These are not needed at all times, and should exclusively be used when an Entity needs to be
 * aware of its surroundings.
 * @param <W> The platform specific World type.
 */
public interface WorldWrapper<W> {

    @NotNull <T extends WrapperEntity> T spawnEntity(@NotNull Class<T> wrapperClass, @NotNull EntityType entityType, @NotNull Location location);

    @NotNull WrapperEntity spawnEntity(@NotNull EntityType entityType, @NotNull Location location);

    @NotNull <T extends WrapperEntity> T spawnEntity(@NotNull T entity, @NotNull Location location);

    @NotNull <T extends WrapperEntity> T cloneEntity(@NotNull Object platformEntity, @NotNull Location location);

    @NotNull Collection<WrapperEntity> getEntities();

    @Nullable WrapperEntity getEntity(int id);

    @Nullable WrapperEntity getEntity(@NotNull UUID uuid);


    /**
     * Gets the block at the specified coordinates. Depending on the platforms implementation, this method may be slow.
     * @param x The x coordinate.
     * @param y The y coordinate.
     * @param z The z coordinate.
     * @return The packetevents WrappedBlockState at the specified coordinates.
     */
    WrappedBlockState getBlock(int x, int y, int z);

    /**
     * @return the packetevents Dimension of the world.
     */
    @NotNull Dimension getDimension();

    /**
     * @return the world's UUID.
     */
    @NotNull UUID getUuid();

    /**
     * @return the platform specific World.
     */
    @NotNull W getHandle();
}
