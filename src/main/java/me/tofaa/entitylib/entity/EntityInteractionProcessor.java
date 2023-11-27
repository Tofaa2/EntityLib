package me.tofaa.entitylib.entity;

import com.github.retrooper.packetevents.protocol.player.InteractionHand;
import com.github.retrooper.packetevents.protocol.player.User;
import com.github.retrooper.packetevents.wrapper.play.client.WrapperPlayClientInteractEntity;
import org.jetbrains.annotations.NotNull;

@FunctionalInterface
public interface EntityInteractionProcessor {

    void process(
        @NotNull WrapperEntity entity,
        @NotNull WrapperPlayClientInteractEntity.InteractAction action,
        @NotNull InteractionHand hand,
        @NotNull User user
    );

}
