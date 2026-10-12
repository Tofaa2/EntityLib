package me.tofaa.entitylib.wrapper;

import com.github.retrooper.packetevents.protocol.entity.pose.EntityPose;
import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.protocol.nbt.NBTCompound;
import com.github.retrooper.packetevents.protocol.potion.PotionType;
import com.github.retrooper.packetevents.protocol.world.Location;
import com.github.retrooper.packetevents.util.Vector3i;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityAnimation;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerHurtAnimation;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.meta.MetaFields;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class WrapperLivingEntity extends WrapperEntity {

    private static final int HURT_ANIMATION_PROTOCOL = 762;
    private static final int STATUS_DEATH = 3;
    private static final int STATUS_TOTEM = 35;

    private final WrapperEntityEquipment equipment;
    private final WrapperEntityAttributes attributes;
    private final WrapperEntityPotionEffect potionEffect;
    private int experience;

    public WrapperLivingEntity(int entityId, @NotNull UUID uuid, @NotNull EntityType entityType, @NotNull Location location) {
        super(entityId, uuid, entityType, location);
        this.equipment = new WrapperEntityEquipment(this);
        this.attributes = new WrapperEntityAttributes(this);
        this.potionEffect = new WrapperEntityPotionEffect(this);
    }

    public WrapperLivingEntity(int entityId, @NotNull UUID uuid, @NotNull EntityType entityType) {
        this(entityId, uuid, entityType, new Location(0, 0, 0, 0, 0));
    }

    public WrapperLivingEntity(@NotNull UUID uuid, @NotNull EntityType entityType) {
        this(EntityLib.get().getPlatform().nextEntityId(), uuid, entityType);
    }

    public WrapperLivingEntity(@NotNull EntityType entityType, @NotNull Location location) {
        this(EntityLib.get().getPlatform().nextEntityId(), UUID.randomUUID(), entityType, location);
    }

    public WrapperLivingEntity(@NotNull EntityType entityType) {
        this(UUID.randomUUID(), entityType);
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public @NotNull WrapperEntityAttributes getAttributes() {
        return attributes;
    }

    public @NotNull WrapperEntityEquipment getEquipment() {
        return equipment;
    }

    public @NotNull WrapperEntityPotionEffect getPotionEffect() {
        return potionEffect;
    }

    @Override
    public void refresh() {
        super.refresh();
        equipment.refresh();
        potionEffect.refresh();
        attributes.refresh();
    }

    public @NotNull List<PacketWrapper<?>> createSpawnPackets() {
        List<PacketWrapper<?>> packets = new ArrayList<>();
        if (!attributes.getProperties().isEmpty()) {
            packets.add(attributes.createPacket());
        }
        if (!equipment.isEmpty()) {
            packets.add(equipment.createPacket());
        }
        packets.addAll(potionEffect.createEffectPackets());
        return packets;
    }

    @Override
    protected void collectSpawnPackets(@NotNull UUID user, int protocolVersion, @NotNull List<PacketWrapper<?>> packets) {
        super.collectSpawnPackets(user, protocolVersion, packets);
        packets.addAll(createSpawnPackets());
    }

    public void addPotionEffect(@NotNull PotionType type, int amplifier, int duration, byte flags,
                                boolean hasFactorData, @Nullable NBTCompound factorData) {
        potionEffect.addPotionEffect(type, amplifier, duration, flags, hasFactorData, factorData);
    }

    public void addPotionEffect(@NotNull PotionType type, int amplifier, int duration, byte flags) {
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
        playHurtAnimation(0);
    }

    public void playHurtAnimation(int yaw) {
        if (!spawned) return;
        var platform = EntityLib.get().getPlatform();
        for (UUID viewer : viewers) {
            if (platform.getProtocolVersion(viewer) >= HURT_ANIMATION_PROTOCOL) {
                sendPacket(viewer, new WrapperPlayServerHurtAnimation(entityId, yaw));
            } else {
                sendPacket(viewer, new WrapperPlayServerEntityAnimation(entityId,
                    WrapperPlayServerEntityAnimation.EntityAnimationType.HURT));
            }
        }
    }

    public void playDeathAnimation() {
        sendStatus(STATUS_DEATH);
    }

    public void playTotemAnimation() {
        sendStatus(STATUS_TOTEM);
    }

    public void sleep(@NotNull Vector3i bed) {
        consumeMetadata(metadata -> {
            metadata.set(MetaFields.LivingEntity.SLEEPING_POS, Optional.of(bed));
            metadata.set(MetaFields.Entity.POSE, EntityPose.SLEEPING);
        });
    }

    public void wakeUp() {
        consumeMetadata(metadata -> {
            metadata.set(MetaFields.LivingEntity.SLEEPING_POS, Optional.empty());
            metadata.set(MetaFields.Entity.POSE, EntityPose.STANDING);
        });
    }

    public void swingMainHand() {
        sendAnimation(WrapperPlayServerEntityAnimation.EntityAnimationType.SWING_MAIN_ARM);
    }

    public void swingOffHand() {
        sendAnimation(WrapperPlayServerEntityAnimation.EntityAnimationType.SWING_OFF_HAND);
    }

    public void sendAnimation(@NotNull WrapperPlayServerEntityAnimation.EntityAnimationType type) {
        sendPacketToViewersIfSpawned(new WrapperPlayServerEntityAnimation(entityId, type));
    }

}
