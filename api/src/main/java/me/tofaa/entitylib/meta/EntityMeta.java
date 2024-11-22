package me.tofaa.entitylib.meta;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.manager.server.ServerVersion;
import com.github.retrooper.packetevents.manager.server.VersionComparison;
import com.github.retrooper.packetevents.protocol.entity.data.EntityData;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataType;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.entity.data.EntityMetadataProvider;
import com.github.retrooper.packetevents.protocol.entity.pose.EntityPose;
import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityMetadata;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.extras.InvalidVersionException;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;

import static me.tofaa.entitylib.meta.MetaOffsetConverter.EntityMetaOffsets.*;

public class EntityMeta implements EntityMetadataProvider {

    private static final MetaConverterRegistry registry = new MetaConverterRegistry();

    public static @NotNull BiFunction<Integer, Metadata, EntityMeta> getConverter(EntityType entityType) {
        return registry.get(entityType);
    }

    public static @NotNull Class<? extends EntityMeta> getMetaClass(EntityType entityType) {
        return registry.getMetaClass(entityType);
    }

    public static @NotNull EntityMeta createMeta(int entityId, EntityType entityType) {
        Metadata metadata = new Metadata(entityId);
        BiFunction<Integer, Metadata, EntityMeta> converter = getConverter(entityType);
        return converter.apply(entityId, metadata);
    }

    public static final byte OFFSET = 0;
    public static final byte MAX_OFFSET = OFFSET + 8;

    private final static byte ON_FIRE_BIT = 0x01;
    private final static byte CROUCHING_BIT = 0x02;
    private final static byte SPRINTING_BIT = 0x08;
    private final static byte SWIMMING_BIT = 0x10;
    private final static byte INVISIBLE_BIT = 0x20;
    private final static byte HAS_GLOWING_EFFECT_BIT = 0x40;
    private final static byte FLYING_WITH_ELYTRA_BIT = (byte) 0x80;

    protected final int entityId;
    protected final Metadata metadata;

    public EntityMeta(int entityId, Metadata metadata) {
        this.entityId = entityId;
        this.metadata = metadata;
    }

    public EntityMeta(EntityMeta other) {
        this(other.entityId, new Metadata(other.entityId));
        metadata.setMetaFromPacket(other.createPacket());
    }

    public EntityMeta(int entityId) {
        this(entityId, new Metadata(entityId));
    }

    public void setNotifyAboutChanges(boolean notifyAboutChanges) {
        metadata.setNotifyAboutChanges(notifyAboutChanges);
    }

    public boolean isNotifyingChanges() {
        return metadata.isNotifyingChanges();
    }

    public boolean isOnFire() {
        return getMaskBit(OFFSET, ON_FIRE_BIT);
    }

    public void setOnFire(boolean value) {
        setMaskBit(OFFSET, ON_FIRE_BIT, value);
    }

    public boolean isSneaking() {
        return getMaskBit(OFFSET, CROUCHING_BIT);
    }

    public void setSneaking(boolean value) {
        setMaskBit(OFFSET, CROUCHING_BIT, value);
    }

    public boolean isSprinting() {
        return getMaskBit(OFFSET, SPRINTING_BIT);
    }

    public void setSprinting(boolean value) {
        setMaskBit(OFFSET, SPRINTING_BIT, value);
    }

    public boolean isInvisible() {
        return getMaskBit(OFFSET, INVISIBLE_BIT);
    }

    public void setInvisible(boolean value) {
        setMaskBit(OFFSET, INVISIBLE_BIT, value);
    }

    public boolean hasGlowingEffect() {
        return getMaskBit(OFFSET, HAS_GLOWING_EFFECT_BIT);
    }

    public boolean isGlowing() {
        return hasGlowingEffect();
    }

    public void setHasGlowingEffect(boolean value) {
        setMaskBit(OFFSET, HAS_GLOWING_EFFECT_BIT, value);
    }

    public void setGlowing(boolean value) {
        setHasGlowingEffect(value);
    }

    public boolean isSwimming() {
        return getMaskBit(OFFSET, SWIMMING_BIT);
    }

    public void setSwimming(boolean value) {
        setMaskBit(OFFSET, SWIMMING_BIT, value);
    }

    public boolean isFlyingWithElytra() {
        return getMaskBit(OFFSET, FLYING_WITH_ELYTRA_BIT);
    }

    public void setFlyingWithElytra(boolean value) {
        setMaskBit(OFFSET, FLYING_WITH_ELYTRA_BIT, value);
    }

    public short getAirTicks() {
        return this.metadata.getIndex(airTicksOffset(), (short) 300);
    }

    public void setAirTicks(short value) {
        this.metadata.setIndex(airTicksOffset(), EntityDataTypes.SHORT, value);
    }

    public Component getCustomName() {
        Optional<Component> component = this.metadata.getIndex(customNameOffset(), Optional.empty());
        return component.orElse(null);
    }

    public void setCustomName(Component value) {
        this.metadata.setIndex(customNameOffset(), EntityDataTypes.OPTIONAL_ADV_COMPONENT, Optional.ofNullable(value));
    }

    public boolean isCustomNameVisible() {
        return this.metadata.getIndex(customNameVisibleOffset(), false);
    }

    public void setCustomNameVisible(boolean value) {
        this.metadata.setIndex(customNameVisibleOffset(), EntityDataTypes.BOOLEAN, value);
    }

    public boolean isSilent() {
        return this.metadata.getIndex(silentOffset(), false);
    }

    public void setSilent(boolean value) {
        this.metadata.setIndex(silentOffset(), EntityDataTypes.BOOLEAN, value);
    }

    public boolean hasNoGravity() {
        return this.metadata.getIndex(hasNoGravityOffset(), true);
    }

    public void setHasNoGravity(boolean value) {
        this.metadata.setIndex(hasNoGravityOffset(), EntityDataTypes.BOOLEAN, value);
    }

    public EntityPose getPose() {
        return this.metadata.getIndex(poseOffset(), EntityPose.STANDING);
    }

    public void setPose(EntityPose value) {
        this.metadata.setIndex(poseOffset(), EntityDataTypes.ENTITY_POSE, value);
    }

    public int getTicksFrozenInPowderedSnow() {
        return this.metadata.getIndex(ticksFrozenInPowderedSnowOffset(), 0);
    }

    public void setTicksFrozenInPowderedSnow(int value) {
        this.metadata.setIndex(ticksFrozenInPowderedSnowOffset(), EntityDataTypes.INT, value);
    }

    public WrapperPlayServerEntityMetadata createPacket() {
        return metadata.createPacket();
    }

    protected static void isVersionNewer(ServerVersion version) {
        if (EntityLib.getOptionalApi().isPresent()) {
            if (!EntityLib.getApi().getPacketEvents().getServerManager().getVersion().is(VersionComparison.NEWER_THAN, version)) {
                throw new InvalidVersionException("This method is only available for versions newer than " + version.name() + ".");
            }
        }
        if (!PacketEvents.getAPI().getServerManager().getVersion().is(VersionComparison.NEWER_THAN, version)) {
            throw new InvalidVersionException("This method is only available for versions newer than " + version.name() + ".");
        }
    }

    protected static boolean isVersion(ServerVersion version, VersionComparison comparison) {
        if (EntityLib.getOptionalApi().isPresent()) {

            return EntityLib.getApi().getPacketEvents().getServerManager().getVersion().is(comparison, version);
        }
        return PacketEvents.getAPI().getServerManager().getVersion().is(comparison, version);
    }

    protected static boolean isVersion(ServerVersion version) {
        if (EntityLib.getOptionalApi().isPresent()) {
            return EntityLib.getApi().getPacketEvents().getServerManager().getVersion().is(VersionComparison.EQUALS, version);
        }
        return PacketEvents.getAPI().getServerManager().getVersion().is(VersionComparison.EQUALS, version);
    }

    /**
     * Annoying java 8 not letting me do OFFSET + amount in the method call so this is a workaround
     * @param value the value to offset
     * @param amount the amount to offset by
     * @return the offset value
     */
    protected static byte offset(byte value, int amount) {
        return (byte) (value + amount);
    }

    public <T> void setIndex(byte index, @NotNull EntityDataType<T> dataType, T value) {
        this.metadata.setIndex(index, dataType, value);
    }

    public <T> T getIndex(byte index, @Nullable T defaultValue) {
        return this.metadata.getIndex(index, defaultValue);
    }

    public byte getMask(byte index) {
        return this.metadata.getIndex(index, (byte) 0);
    }

    public void setMask(byte index, byte mask) {
        this.metadata.setIndex(index, EntityDataTypes.BYTE, mask);
    }

    public boolean getMaskBit(byte index, byte bit) {
        return (getMask(index) & bit) == bit;
    }

    public void setMaskBit(int index, byte bit, boolean value) {
        byte mask = getMask((byte)index);
        boolean currentValue = (mask & bit) == bit;
        if (currentValue == value) {
            return;
        }
        if (value) {
            mask |= bit;
        } else {
            mask &= (byte) ~bit;
        }
        setMask((byte)index, mask);
    }

    @Override
    public List<EntityData> entityData(ClientVersion clientVersion) {
        return metadata.getEntries(); // TODO: Atm this is useless cause of the way the api works. Might change in the future
    }

    @Override
    public List<EntityData> entityData() {
        return metadata.getEntries();
    }

    public Metadata getMetadata() {
        return metadata;
    }
}
