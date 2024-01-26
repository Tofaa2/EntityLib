package me.tofaa.entitylib.event;

import com.github.retrooper.packetevents.protocol.player.User;
import me.tofaa.entitylib.meta.EntityMeta;

public final class UserReceiveMetaUpdateEvent implements EntityLibEvent {

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
        return false;
    }

    @Override
    public void setCancelled(boolean cancelled) {

    }
}
