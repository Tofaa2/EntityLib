package me.tofaa.entitylib.event.entity;

import me.tofaa.entitylib.event.EntityLibEvent;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import org.jetbrains.annotations.NotNull;

public abstract class EntityEvent implements EntityLibEvent {

    private final WrapperEntity entity;

    protected EntityEvent(@NotNull WrapperEntity entity) {
        this.entity = entity;
    }

    public @NotNull WrapperEntity getEntity() {
        return entity;
    }

}
