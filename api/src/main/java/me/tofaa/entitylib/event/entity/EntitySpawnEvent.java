package me.tofaa.entitylib.event.entity;

import me.tofaa.entitylib.wrapper.WrapperEntity;
import org.jetbrains.annotations.NotNull;

public final class EntitySpawnEvent extends EntityEvent {

    public EntitySpawnEvent(@NotNull WrapperEntity entity) {
        super(entity);
    }

}
