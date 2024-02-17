package me.tofaa.entitylib.event.types;

import com.github.retrooper.packetevents.protocol.player.User;
import me.tofaa.entitylib.event.EntityLibEvent;
import me.tofaa.entitylib.wrapper.WrapperEntity;

public class UserRefreshEntityEvent implements EntityLibEvent {

    private final User user;
    private final WrapperEntity entity;
    private boolean cancelled;

    public UserRefreshEntityEvent(User user, WrapperEntity entity) {
        this.user = user;
        this.entity = entity;
    }

    public User getUser() {
        return user;
    }


    public WrapperEntity getEntity() {
        return entity;
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
