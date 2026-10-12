package me.tofaa.entitylib.event.entity;

import me.tofaa.entitylib.wrapper.WrapperEntity;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public final class EntityViewerRemoveEvent extends EntityViewerEvent {

    private final boolean disconnected;

    public EntityViewerRemoveEvent(@NotNull WrapperEntity entity, @NotNull UUID viewer, boolean disconnected) {
        super(entity, viewer);
        this.disconnected = disconnected;
    }

    public boolean isDisconnected() {
        return disconnected;
    }

}
