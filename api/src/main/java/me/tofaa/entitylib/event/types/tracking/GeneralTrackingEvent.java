package me.tofaa.entitylib.event.types.tracking;

import com.github.retrooper.packetevents.protocol.player.User;
import me.tofaa.entitylib.TrackedEntity;
import me.tofaa.entitylib.event.EntityLibEvent;
import org.jetbrains.annotations.NotNull;

public class GeneralTrackingEvent implements EntityLibEvent {

    private final User user;
    private final TrackedEntity entity;

    public GeneralTrackingEvent(@NotNull User user, @NotNull TrackedEntity entity) {
        this.user = user;
        this.entity = entity;
    }

    public User getUser() {
        return user;
    }

    public TrackedEntity getEntity() {
        return entity;
    }

}
