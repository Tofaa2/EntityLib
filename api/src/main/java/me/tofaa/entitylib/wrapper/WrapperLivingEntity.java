package me.tofaa.entitylib.wrapper;

import com.github.retrooper.packetevents.manager.server.ServerVersion;
import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.protocol.nbt.NBTCompound;
import com.github.retrooper.packetevents.protocol.potion.PotionType;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityAnimation;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityEffect;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerHurtAnimation;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.meta.EntityMeta;
import me.tofaa.entitylib.utils.VersionUtil;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class WrapperLivingEntity extends WrapperEntity{

    private final WrapperEntityEquipment equipment;
    private final WrapperEntityAttributes attributes;

    public WrapperLivingEntity(int entityId, UUID uuid, EntityType entityType, EntityMeta entityMeta) {
        super(entityId, uuid, entityType, entityMeta);
        this.equipment = new WrapperEntityEquipment(this);
        this.attributes = new WrapperEntityAttributes(this);
    }

    public WrapperLivingEntity(int entityId, UUID uuid, EntityType entityType) {
        this(entityId, uuid, entityType, EntityMeta.createMeta(entityId, entityType));
    }

    public WrapperLivingEntity(int entityId, EntityType entityType) {
        this(entityId, EntityLib.getPlatform().getEntityUuidProvider().provide(entityType), entityType);
    }

    public WrapperLivingEntity(UUID uuid, EntityType entityType) {
        this(EntityLib.getPlatform().getEntityIdProvider().provide(uuid, entityType), uuid, entityType);
    }
    public WrapperLivingEntity(EntityType entityType) {
        this(EntityLib.getPlatform().getEntityUuidProvider().provide(entityType), entityType);
    }

    @Override
    public void refresh() {
        super.refresh();
        equipment.refresh();
        attributes.refresh();
    }

    public WrapperEntityAttributes getAttributes() {
        return attributes;
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

    /**
     * Plays the hurt animation of the entity.
     * This method is deprecated and should use {@link #playHurtAnimation(int)} instead.
     */
    @Deprecated
    public void playHurtAnimation() {
        playHurtAnimation(0);
    }

    /**
     * Plays the hurt animation of the entity.
     * @param yaw The yaw of the entity when the hurt animation is played.
     *            For any entity other than a player it's safe to simply put 0, as it's not used.
     *            The yaw is only used on 1.19.4+.
     */
    public void playHurtAnimation(int yaw) {
        // 1.19.4+ uses a different packet for hurt animation than previous versions
        if (VersionUtil.isNewerThan(ServerVersion.V_1_19_4)) {
            sendPacketToViewers(
                    new WrapperPlayServerHurtAnimation(getEntityId(), yaw)
            );
            return;
        }
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
