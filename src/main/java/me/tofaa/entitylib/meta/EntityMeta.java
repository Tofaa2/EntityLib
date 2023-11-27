package me.tofaa.entitylib.meta;

import com.github.retrooper.packetevents.manager.server.ServerVersion;
import com.github.retrooper.packetevents.manager.server.VersionComparison;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.entity.pose.EntityPose;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityMetadata;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.exception.InvalidVersionException;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;

public class EntityMeta {

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

    public short getAirTicks() {
        return this.metadata.getIndex((byte) 1, (short) 300);
    }

    public void setAirTicks(short value) {
        this.metadata.setIndex((byte) 1, EntityDataTypes.SHORT, value);
    }

    public Component getCustomName() {
        return this.metadata.getIndex((byte) 2, null);
    }

    public boolean hasGlowingEffect() {
        return getMaskBit(OFFSET, HAS_GLOWING_EFFECT_BIT);
    }
    public boolean isSwimming() {
        return getMaskBit(OFFSET, SWIMMING_BIT);
    }

    public void setSwimming(boolean value) {
        setMaskBit(OFFSET, SWIMMING_BIT, value);
    }

    public void setHasGlowingEffect(boolean value) {
        setMaskBit(OFFSET, HAS_GLOWING_EFFECT_BIT, value);
    }

    public boolean isFlyingWithElytra() {
        return getMaskBit(OFFSET, FLYING_WITH_ELYTRA_BIT);
    }

    public void setFlyingWithElytra(boolean value) {
        setMaskBit(OFFSET, FLYING_WITH_ELYTRA_BIT, value);
    }

    public void setCustomName(Component value) {
        this.metadata.setIndex((byte) 2, EntityDataTypes.COMPONENT, GsonComponentSerializer.gson().serialize(value));
    }

    public boolean isCustomNameVisible() {
        return this.metadata.getIndex((byte) 3, false);
    }

    public void setCustomNameVisible(boolean value) {
        this.metadata.setIndex((byte) 3, EntityDataTypes.BOOLEAN, value);
    }

    public boolean isSilent() {
        return this.metadata.getIndex((byte) 4, false);
    }

    public void setSilent(boolean value) {
        this.metadata.setIndex((byte) 4, EntityDataTypes.BOOLEAN, value);
    }

    public boolean isHasNoGravity() {
        return this.metadata.getIndex(offset(5), true);
    }

    public void setHasNoGravity(boolean value) {
        this.metadata.setIndex(offset(5), EntityDataTypes.BOOLEAN, value);
    }

    public EntityPose getPose() {
        return this.metadata.getIndex(offset(6), EntityPose.STANDING);
    }

    public void setPose(EntityPose value) {
        this.metadata.setIndex(offset(6), EntityDataTypes.ENTITY_POSE, value);
    }

    public WrapperPlayServerEntityMetadata createPacket() {
        return metadata.createPacket();
    }


    protected static void isVersion(ServerVersion version) {
        if (!EntityLib.getPacketEvents().getServerManager().getVersion().is(VersionComparison.EQUALS, version)) {
            throw new InvalidVersionException("This method is only available for " + version.name() + " and above.");
        }
    }

    protected static void isVersionOlder(ServerVersion version) {
        if (!EntityLib.getPacketEvents().getServerManager().getVersion().is(VersionComparison.OLDER_THAN, version)) {
            throw new InvalidVersionException("This method is only available for versions older than " + version.name() + ".");
        }
    }

    protected static void isVersionNewer(ServerVersion version) {
        if (!EntityLib.getPacketEvents().getServerManager().getVersion().is(VersionComparison.NEWER_THAN, version)) {
            throw new InvalidVersionException("This method is only available for versions newer than " + version.name() + ".");
        }
    }

    protected static byte offset(int amount) {
        return (byte) (OFFSET + amount);
    }

    protected byte getMask(byte index) {
        return this.metadata.getIndex(index, (byte) 0);
    }

    protected void setMask(byte index, byte mask) {
        this.metadata.setIndex(index, EntityDataTypes.BYTE, mask);
    }

    protected boolean getMaskBit(byte index, byte bit) {
        return (getMask(index) & bit) == bit;
    }

    protected void setMaskBit(int index, byte bit, boolean value) {
        byte mask = getMask((byte)index);
        boolean currentValue = (mask & bit) == bit;
        if (currentValue == value) {
            return;
        }
        if (value) {
            mask |= bit;
        } else {
            mask &= ~bit;
        }
        setMask((byte)index, mask);
    }

}
