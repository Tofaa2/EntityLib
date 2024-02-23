package me.tofaa.entitylib.wrapper;

import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.protocol.nbt.NBTCompound;
import com.github.retrooper.packetevents.protocol.player.HumanoidArm;
import com.github.retrooper.packetevents.protocol.potion.PotionType;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityAnimation;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityEffect;
import me.tofaa.entitylib.meta.EntityMeta;
import me.tofaa.entitylib.meta.types.LivingEntityMeta;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class WrapperLivingEntity extends WrapperEntity{

    private final WrapperEntityEquipment equipment;

    public WrapperLivingEntity(int entityId, UUID uuid, EntityType entityType, EntityMeta entityMeta) {
        super(entityId, uuid, entityType, entityMeta);
        this.equipment = new WrapperEntityEquipment(this);
    }

    @Override
    public void refresh() {
        super.refresh();
        equipment.refresh();
    }

    /**
     * Adds a potion effect to the entity.
     * EntityLib will not keep track of the potions you give or what you do with them,
     * this simply sends the packet to the viewers of the entity.
     * @param type The type of the potion effect {@link com.github.retrooper.packetevents.protocol.potion.PotionTypes}
     * @param amplifier The amplifier of the potion effect. The notchian client displays the number as (amplifier + 1)
     * @param duration The duration of the potion effect in ticks, if set to -1 the client will display the effect as infinite
     * @param flags The bit flags of the potion effect see: https://wiki.vg/Protocol#Entity_Effect
     * @param hasFactorData Whether the potion effect has factor data
     * @param factorData The factor data of the potion effect, if hasFactorData is false this will be ignored
     */
    public void addPotionEffect(
        PotionType type,
        int amplifier,
        int duration,
        byte flags,
        boolean hasFactorData,
        @Nullable NBTCompound factorData
    ) {
        sendPacketToViewers(
                new WrapperPlayServerEntityEffect(
                        getEntityId(),
                        type,
                        amplifier,
                        duration,
                        flags
                )
        );
    }

    /**
     * Adds a potion effect to the entity.
     * EntityLib will not keep track of the potions you give or what you do with them,
     * this simply sends the packet to the viewers of the entity.
     * @param type The type of the potion effect {@link com.github.retrooper.packetevents.protocol.potion.PotionTypes}
     * @param amplifier The amplifier of the potion effect. The notchian client displays the number as (amplifier + 1)
     * @param duration The duration of the potion effect in ticks, if set to -1 the client will display the effect as infinite
     * @param flags The bit flags of the potion effect see: https://wiki.vg/Protocol#Entity_Effect
     */
    public void addPotionEffect(
        PotionType type,
        int amplifier,
        int duration,
        byte flags
    ) {
        addPotionEffect(type, amplifier, duration, flags, false, null);
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
