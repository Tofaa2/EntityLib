package me.tofaa.entitylib.event.types.tracking;

import com.github.retrooper.packetevents.protocol.player.User;
import me.tofaa.entitylib.TrackedEntity;

import org.jetbrains.annotations.NotNull;

public class UserStopTrackingEntityEvent extends GeneralTrackingEvent {


    public UserStopTrackingEntityEvent(@NotNull User user, @NotNull TrackedEntity entity) {
        super(user, entity);
    }


}
