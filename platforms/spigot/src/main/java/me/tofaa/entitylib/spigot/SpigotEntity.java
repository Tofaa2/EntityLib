package me.tofaa.entitylib.spigot;

import me.tofaa.entitylib.common.AbstractTrackedEntity;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class SpigotEntity extends AbstractTrackedEntity<Entity> {

    public SpigotEntity(@NotNull Entity platformEntity) {
        super(platformEntity);
    }

    @Override
    public int getEntityId() {
        return getPlatformEntity().getEntityId();
    }

    @Override
    public @NotNull UUID getUuid() {
        return getPlatformEntity().getUniqueId();
    }
}
