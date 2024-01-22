package me.tofaa.entitylib;

import me.tofaa.entitylib.entity.WrapperEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

/**
 * A platform independent wrapper for a "world" object.
 * @param <W> The generic takes the actual world handle used by the platform.
 */
public interface WrapperWorld<W> {

    @NotNull UUID getUuid();

    @NotNull String getName();

    @Nullable WrapperEntity getEntity(@NotNull UUID uuid);

    @Nullable WrapperEntity getEntity(int entityId);

    @NotNull W getHandle();

}
