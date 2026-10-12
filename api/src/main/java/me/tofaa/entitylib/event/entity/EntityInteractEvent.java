package me.tofaa.entitylib.event.entity;

import com.github.retrooper.packetevents.protocol.player.InteractionHand;
import com.github.retrooper.packetevents.protocol.player.User;
import com.github.retrooper.packetevents.wrapper.play.client.WrapperPlayClientInteractEntity;
import me.tofaa.entitylib.event.Cancellable;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import org.jetbrains.annotations.NotNull;

public final class EntityInteractEvent extends EntityEvent implements Cancellable {

    private final User user;
    private final WrapperPlayClientInteractEntity.InteractAction action;
    private final InteractionHand hand;
    private boolean cancelled;

    public EntityInteractEvent(@NotNull WrapperEntity entity, @NotNull User user,
                               @NotNull WrapperPlayClientInteractEntity.InteractAction action, @NotNull InteractionHand hand) {
        super(entity);
        this.user = user;
        this.action = action;
        this.hand = hand;
    }

    public @NotNull User getUser() {
        return user;
    }

    public @NotNull WrapperPlayClientInteractEntity.InteractAction getAction() {
        return action;
    }

    public @NotNull InteractionHand getHand() {
        return hand;
    }

    public boolean isAttack() {
        return action == WrapperPlayClientInteractEntity.InteractAction.ATTACK;
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
