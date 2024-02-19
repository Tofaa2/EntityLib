package me.tofaa.entitylib.event.types;

import com.github.retrooper.packetevents.protocol.player.User;
import me.tofaa.entitylib.TrackedEntity;

import me.tofaa.entitylib.event.EntityLibEvent;
import org.jetbrains.annotations.NotNull;

public class UserStopTrackingEntityEvent extends GeneralTrackingEvent implements EntityLibEvent {


    public UserStopTrackingEntityEvent(@NotNull User user, @NotNull TrackedEntity entity) {
        super(user, entity);
    }


}
