package me.tofaa.entitylib.wrapper;

import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.protocol.player.HumanoidArm;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityAnimation;
import me.tofaa.entitylib.meta.EntityMeta;
import me.tofaa.entitylib.meta.types.LivingEntityMeta;

import java.util.UUID;

public class WrapperLivingEntity extends WrapperEntity{

    private final WrapperEntityEquipment equipment;

    public WrapperLivingEntity(int entityId, UUID uuid, EntityType entityType, EntityMeta entityMeta) {
        super(entityId, uuid, entityType, entityMeta);
        this.equipment = new WrapperEntityEquipment(this);
    }

    public void playCriticalHitAnimation() {
        sendAnimation(WrapperPlayServerEntityAnimation.EntityAnimationType.CRITICAL_HIT);
    }

    public void playMagicCriticalHitAnimation() {
        sendAnimation(WrapperPlayServerEntityAnimation.EntityAnimationType.MAGIC_CRITICAL_HIT);
    }

    public void playWakeupAnimation() {
        sendAnimation(WrapperPlayServerEntityAnimation.EntityAnimationType.WAKE_UP);
    }

    public void playHurtAnimation() {
        sendAnimation(WrapperPlayServerEntityAnimation.EntityAnimationType.HURT);
    }

    public void swingMainHand() {
        sendAnimation(WrapperPlayServerEntityAnimation.EntityAnimationType.SWING_MAIN_ARM);
    }

    public void swingOffHand() {
        sendAnimation(WrapperPlayServerEntityAnimation.EntityAnimationType.SWING_OFF_HAND);
    }

    public void sendAnimation(WrapperPlayServerEntityAnimation.EntityAnimationType type) {
        sendPacketToViewers(
                new WrapperPlayServerEntityAnimation(getEntityId(), type)
        );
    }

    public WrapperEntityEquipment getEquipment() {
        return equipment;
    }
}
