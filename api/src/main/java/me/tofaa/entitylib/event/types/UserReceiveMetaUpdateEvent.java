package me.tofaa.entitylib.event.types;

import com.github.retrooper.packetevents.protocol.player.User;
import me.tofaa.entitylib.event.CancellableEntityLibEvent;
import me.tofaa.entitylib.event.EntityLibEvent;
import me.tofaa.entitylib.meta.EntityMeta;

public final class UserReceiveMetaUpdateEvent implements CancellableEntityLibEvent {

    private final User user;
    private boolean cancelled;
    private EntityMeta meta;

    public UserReceiveMetaUpdateEvent(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
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
