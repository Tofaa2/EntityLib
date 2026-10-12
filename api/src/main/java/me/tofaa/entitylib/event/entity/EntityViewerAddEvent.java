package me.tofaa.entitylib.event.entity;

import me.tofaa.entitylib.event.Cancellable;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public final class EntityViewerAddEvent extends EntityViewerEvent implements Cancellable {

    private boolean cancelled;

    public EntityViewerAddEvent(@NotNull WrapperEntity entity, @NotNull UUID viewer) {
        super(entity, viewer);
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

}
