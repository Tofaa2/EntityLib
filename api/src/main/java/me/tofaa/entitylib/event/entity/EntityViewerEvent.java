package me.tofaa.entitylib.event.entity;

import me.tofaa.entitylib.wrapper.WrapperEntity;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public abstract class EntityViewerEvent extends EntityEvent {

    private final UUID viewer;

    protected EntityViewerEvent(@NotNull WrapperEntity entity, @NotNull UUID viewer) {
        super(entity);
        this.viewer = viewer;
    }

    public @NotNull UUID getViewer() {
        return viewer;
    }

}
