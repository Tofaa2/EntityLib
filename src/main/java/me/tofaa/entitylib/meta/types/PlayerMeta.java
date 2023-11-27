package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.manager.server.ServerVersion;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.nbt.NBTCompound;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.meta.EntityMeta;
import me.tofaa.entitylib.meta.Metadata;
import org.jetbrains.annotations.Nullable;

public class PlayerMeta extends LivingEntityMeta {

    public static final byte OFFSET = LivingEntityMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 1;

    private final static byte CAPE_BIT = 0x01;
    private final static byte JACKET_BIT = 0x02;
    private final static byte LEFT_SLEEVE_BIT = 0x04;
    private final static byte RIGHT_SLEEVE_BIT = 0x08;
    private final static byte LEFT_LEG_BIT = 0x10;
    private final static byte RIGHT_LEG_BIT = 0x20;
    private final static byte HAT_BIT = 0x40;

    public PlayerMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    public float getAdditionalHearts() {
        return super.metadata.getIndex(OFFSET, 0F);
    }

    public void setAdditionalHearts(float value) {
        super.metadata.setIndex(OFFSET, EntityDataTypes.FLOAT, value);
    }

    public int getScore() {
        return super.metadata.getIndex(EntityMeta.offset(1), 0);
    }

    public void setScore(int value) {
        super.metadata.setIndex(EntityMeta.offset(1), EntityDataTypes.INT, value);
    }

    public boolean isCapeEnabled() {
        EntityMeta.isVersionNewer(ServerVersion.V_1_9);
        return getMaskBit(EntityMeta.offset(2), CAPE_BIT);
    }

    public void setCapeEnabled(boolean value) {
        EntityMeta.isVersionNewer(ServerVersion.V_1_9);
        setMaskBit(EntityMeta.offset(2), CAPE_BIT, value);
    }

    public boolean isJacketEnabled() {
        EntityMeta.isVersionNewer(ServerVersion.V_1_9);
        return getMaskBit(EntityMeta.offset(2), JACKET_BIT);
    }

    public void setJacketEnabled(boolean value) {
        EntityMeta.isVersionNewer(ServerVersion.V_1_9);
        setMaskBit(EntityMeta.offset(2), JACKET_BIT, value);
    }

    public boolean isLeftSleeveEnabled() {
        EntityMeta.isVersionNewer(ServerVersion.V_1_9);
        return getMaskBit(EntityMeta.offset(2), LEFT_SLEEVE_BIT);
    }

    public void setLeftSleeveEnabled(boolean value) {
        EntityMeta.isVersionNewer(ServerVersion.V_1_9);
        setMaskBit(EntityMeta.offset(2), LEFT_SLEEVE_BIT, value);
    }

    public boolean isRightSleeveEnabled() {
        EntityMeta.isVersionNewer(ServerVersion.V_1_9);
        return getMaskBit(EntityMeta.offset(2), RIGHT_SLEEVE_BIT);
    }

    public void setRightSleeveEnabled(boolean value) {
        EntityMeta.isVersionNewer(ServerVersion.V_1_9);
        setMaskBit(EntityMeta.offset(2), RIGHT_SLEEVE_BIT, value);
    }

    public boolean isLeftLegEnabled() {
        EntityMeta.isVersionNewer(ServerVersion.V_1_9);
        return getMaskBit(EntityMeta.offset(2), LEFT_LEG_BIT);
    }

    public void setLeftLegEnabled(boolean value) {
        EntityMeta.isVersionNewer(ServerVersion.V_1_9);
        setMaskBit(EntityMeta.offset(2), LEFT_LEG_BIT, value);
    }

    public boolean isRightLegEnabled() {
        EntityMeta.isVersionNewer(ServerVersion.V_1_9);
        return getMaskBit(EntityMeta.offset(2), RIGHT_LEG_BIT);
    }

    public void setRightLegEnabled(boolean value) {
        EntityMeta.isVersionNewer(ServerVersion.V_1_9);
        setMaskBit(EntityMeta.offset(2), RIGHT_LEG_BIT, value);
    }

    public boolean isHatEnabled() {
        EntityMeta.isVersionNewer(ServerVersion.V_1_9);
        return getMaskBit(EntityMeta.offset(2), HAT_BIT);
    }

    public void setHatEnabled(boolean value) {
        EntityMeta.isVersionNewer(ServerVersion.V_1_9);
        setMaskBit(EntityMeta.offset(2), HAT_BIT, value);
    }

    public boolean isRightHandMain() {
        if (EntityLib.getPacketEvents().getServerManager().getVersion().isOlderThan(ServerVersion.V_1_9)) {
            return true;
        }
        return super.metadata.getIndex(EntityMeta.offset(3), (byte) 1) == (byte) 1;
    }

    public void setRightHandMain(boolean value) {
        if (EntityLib.getPacketEvents().getServerManager().getVersion().isOlderThan(ServerVersion.V_1_9)) {
            return;
        }
        super.metadata.setIndex(EntityMeta.offset(3), EntityDataTypes.BYTE, (byte) (value ? 1 : 0));
    }

    public @Nullable NBTCompound getLeftShoulderData() {
        EntityMeta.isVersionNewer(ServerVersion.V_1_11);
        return super.metadata.getIndex(EntityMeta.offset(4), null);
    }

    public void setLeftShoulderData(@Nullable NBTCompound value) {
        if (value == null) value = new NBTCompound();
        super.metadata.setIndex(EntityMeta.offset(4), EntityDataTypes.NBT, value);
    }

    public @Nullable NBTCompound getRightShoulderData() {
        EntityMeta.isVersionNewer(ServerVersion.V_1_11);
        return super.metadata.getIndex(EntityMeta.offset(5), null);
    }

    public void setRightShoulderData(@Nullable NBTCompound value) {
        if (value == null) value = new NBTCompound();
        super.metadata.setIndex(EntityMeta.offset(5), EntityDataTypes.NBT, value);
    }

}
