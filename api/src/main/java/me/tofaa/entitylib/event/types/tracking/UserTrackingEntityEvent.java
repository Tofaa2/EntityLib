package me.tofaa.entitylib.event.types.tracking;

import com.github.retrooper.packetevents.protocol.player.User;
import me.tofaa.entitylib.TrackedEntity;
import org.jetbrains.annotations.NotNull;

public final class UserTrackingEntityEvent extends GeneralTrackingEvent {


    public UserTrackingEntityEvent(@NotNull User user, @NotNull TrackedEntity entity) {
        super(user, entity);
    }
}
