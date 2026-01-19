package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.manager.server.ServerVersion;
import com.github.retrooper.packetevents.manager.server.VersionComparison;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.nbt.NBTCompound;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.meta.Metadata;
import org.jetbrains.annotations.Nullable;

public class PlayerMeta extends LivingEntityMeta {

    public static final byte OFFSET = LivingEntityMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 6;

    private static final byte AVATAR_MAIN_HAND_INDEX = OFFSET;
    private static final byte AVATAR_SKIN_LAYERS_INDEX = (byte) (OFFSET + 1);

    private static final byte PLAYER_ADDITIONAL_HEARTS_INDEX = (byte) (OFFSET + 2);
    private static final byte PLAYER_SCORE_INDEX = (byte) (OFFSET + 3);
    private static final byte PLAYER_LEFT_SHOULDER_INDEX = (byte) (OFFSET + 4);
    private static final byte PLAYER_RIGHT_SHOULDER_INDEX = (byte) (OFFSET + 5);

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
        if (isVersion(ServerVersion.V_1_21_10, VersionComparison.NEWER_THAN_OR_EQUALS)) {
            return super.metadata.getIndex(PLAYER_ADDITIONAL_HEARTS_INDEX, 0F);
        }
        return super.metadata.getIndex(OFFSET, 0F);
    }

    public void setAdditionalHearts(float value) {
        if (isVersion(ServerVersion.V_1_21_10, VersionComparison.NEWER_THAN_OR_EQUALS)) {
            super.metadata.setIndex(PLAYER_ADDITIONAL_HEARTS_INDEX, EntityDataTypes.FLOAT, value);
        } else {
            super.metadata.setIndex(OFFSET, EntityDataTypes.FLOAT, value);
        }
    }

    public int getScore() {
        if (isVersion(ServerVersion.V_1_21_10, VersionComparison.NEWER_THAN_OR_EQUALS)) {
            return super.metadata.getIndex(PLAYER_SCORE_INDEX, 0);
        }
        return super.metadata.getIndex(offset(OFFSET,1), 0);
    }

    public void setScore(int value) {
        if (isVersion(ServerVersion.V_1_21_10, VersionComparison.NEWER_THAN_OR_EQUALS)) {
            super.metadata.setIndex(PLAYER_SCORE_INDEX, EntityDataTypes.INT, value);
        } else {
            super.metadata.setIndex(offset(OFFSET,1), EntityDataTypes.INT, value);
        }
    }

    public boolean isCapeEnabled() {
        isVersionNewer(ServerVersion.V_1_9);
        if (isVersion(ServerVersion.V_1_21_10, VersionComparison.NEWER_THAN_OR_EQUALS)) {
            return getMaskBit(AVATAR_SKIN_LAYERS_INDEX, CAPE_BIT);
        }
        return getMaskBit(offset(OFFSET,2), CAPE_BIT);
    }

    public void setCapeEnabled(boolean value) {
        isVersionNewer(ServerVersion.V_1_9);
        if (isVersion(ServerVersion.V_1_21_10, VersionComparison.NEWER_THAN_OR_EQUALS)) {
            setMaskBit(AVATAR_SKIN_LAYERS_INDEX, CAPE_BIT, value);
        } else {
            setMaskBit(offset(OFFSET,2), CAPE_BIT, value);
        }
    }

    public boolean isJacketEnabled() {
        isVersionNewer(ServerVersion.V_1_9);
        if (isVersion(ServerVersion.V_1_21_10, VersionComparison.NEWER_THAN_OR_EQUALS)) {
            return getMaskBit(AVATAR_SKIN_LAYERS_INDEX, JACKET_BIT);
        }
        return getMaskBit(offset(OFFSET,2), JACKET_BIT);
    }

    public void setJacketEnabled(boolean value) {
        isVersionNewer(ServerVersion.V_1_9);
        if (isVersion(ServerVersion.V_1_21_10, VersionComparison.NEWER_THAN_OR_EQUALS)) {
            setMaskBit(AVATAR_SKIN_LAYERS_INDEX, JACKET_BIT, value);
        } else {
            setMaskBit(offset(OFFSET,2), JACKET_BIT, value);
        }
    }

    public boolean isLeftSleeveEnabled() {
        isVersionNewer(ServerVersion.V_1_9);
        if (isVersion(ServerVersion.V_1_21_10, VersionComparison.NEWER_THAN_OR_EQUALS)) {
            return getMaskBit(AVATAR_SKIN_LAYERS_INDEX, LEFT_SLEEVE_BIT);
        }
        return getMaskBit(offset(OFFSET,2), LEFT_SLEEVE_BIT);
    }

    public void setLeftSleeveEnabled(boolean value) {
        isVersionNewer(ServerVersion.V_1_9);
        if (isVersion(ServerVersion.V_1_21_10, VersionComparison.NEWER_THAN_OR_EQUALS)) {
            setMaskBit(AVATAR_SKIN_LAYERS_INDEX, LEFT_SLEEVE_BIT, value);
        } else {
            setMaskBit(offset(OFFSET,2), LEFT_SLEEVE_BIT, value);
        }
    }

    public boolean isRightSleeveEnabled() {
        isVersionNewer(ServerVersion.V_1_9);
        if (isVersion(ServerVersion.V_1_21_10, VersionComparison.NEWER_THAN_OR_EQUALS)) {
            return getMaskBit(AVATAR_SKIN_LAYERS_INDEX, RIGHT_SLEEVE_BIT);
        }
        return getMaskBit(offset(OFFSET,2), RIGHT_SLEEVE_BIT);
    }

    public void setRightSleeveEnabled(boolean value) {
        isVersionNewer(ServerVersion.V_1_9);
        if (isVersion(ServerVersion.V_1_21_10, VersionComparison.NEWER_THAN_OR_EQUALS)) {
            setMaskBit(AVATAR_SKIN_LAYERS_INDEX, RIGHT_SLEEVE_BIT, value);
        } else {
            setMaskBit(offset(OFFSET,2), RIGHT_SLEEVE_BIT, value);
        }
    }

    public boolean isLeftLegEnabled() {
        isVersionNewer(ServerVersion.V_1_9);
        if (isVersion(ServerVersion.V_1_21_10, VersionComparison.NEWER_THAN_OR_EQUALS)) {
            return getMaskBit(AVATAR_SKIN_LAYERS_INDEX, LEFT_LEG_BIT);
        }
        return getMaskBit(offset(OFFSET,2), LEFT_LEG_BIT);
    }

    public void setLeftLegEnabled(boolean value) {
        isVersionNewer(ServerVersion.V_1_9);
        if (isVersion(ServerVersion.V_1_21_10, VersionComparison.NEWER_THAN_OR_EQUALS)) {
            setMaskBit(AVATAR_SKIN_LAYERS_INDEX, LEFT_LEG_BIT, value);
        } else {
            setMaskBit(offset(OFFSET,2), LEFT_LEG_BIT, value);
        }
    }

    public boolean isRightLegEnabled() {
        isVersionNewer(ServerVersion.V_1_9);
        if (isVersion(ServerVersion.V_1_21_10, VersionComparison.NEWER_THAN_OR_EQUALS)) {
            return getMaskBit(AVATAR_SKIN_LAYERS_INDEX, RIGHT_LEG_BIT);
        }
        return getMaskBit(offset(OFFSET,2), RIGHT_LEG_BIT);
    }

    public void setRightLegEnabled(boolean value) {
        isVersionNewer(ServerVersion.V_1_9);
        if (isVersion(ServerVersion.V_1_21_10, VersionComparison.NEWER_THAN_OR_EQUALS)) {
            setMaskBit(AVATAR_SKIN_LAYERS_INDEX, RIGHT_LEG_BIT, value);
        } else {
            setMaskBit(offset(OFFSET,2), RIGHT_LEG_BIT, value);
        }
    }

    public boolean isHatEnabled() {
        isVersionNewer(ServerVersion.V_1_9);
        if (isVersion(ServerVersion.V_1_21_10, VersionComparison.NEWER_THAN_OR_EQUALS)) {
            return getMaskBit(AVATAR_SKIN_LAYERS_INDEX, HAT_BIT);
        }
        return getMaskBit(offset(OFFSET,2), HAT_BIT);
    }

    public void setHatEnabled(boolean value) {
        isVersionNewer(ServerVersion.V_1_9);
        if (isVersion(ServerVersion.V_1_21_10, VersionComparison.NEWER_THAN_OR_EQUALS)) {
            setMaskBit(AVATAR_SKIN_LAYERS_INDEX, HAT_BIT, value);
        } else {
            setMaskBit(offset(OFFSET,2), HAT_BIT, value);
        }
    }

    public boolean isRightHandMain() {
        if (EntityLib.getApi().getPacketEvents().getServerManager().getVersion().isOlderThan(ServerVersion.V_1_9)) {
            return true;
        }
        if (isVersion(ServerVersion.V_1_21_10, VersionComparison.NEWER_THAN_OR_EQUALS)) {
            return super.metadata.getIndex(AVATAR_MAIN_HAND_INDEX, (byte) 1) == (byte) 1;
        }
        return super.metadata.getIndex(offset(OFFSET,3), (byte) 1) == (byte) 1;
    }

    public void setRightHandMain(boolean value) {
        if (EntityLib.getApi().getPacketEvents().getServerManager().getVersion().isOlderThan(ServerVersion.V_1_9)) {
            return;
        }
        if (isVersion(ServerVersion.V_1_21_10, VersionComparison.NEWER_THAN_OR_EQUALS)) {
            super.metadata.setIndex(AVATAR_MAIN_HAND_INDEX, EntityDataTypes.BYTE, (byte) (value ? 1 : 0));
        } else {
            super.metadata.setIndex(offset(OFFSET,3), EntityDataTypes.BYTE, (byte) (value ? 1 : 0));
        }
    }

    public @Nullable NBTCompound getLeftShoulderData() {
        isVersionNewer(ServerVersion.V_1_11);
        if (isVersion(ServerVersion.V_1_21_10, VersionComparison.NEWER_THAN_OR_EQUALS)) {
            return super.metadata.getIndex(PLAYER_LEFT_SHOULDER_INDEX, null);
        }
        return super.metadata.getIndex(offset(OFFSET,4), null);
    }

    public void setLeftShoulderData(@Nullable NBTCompound value) {
        if (value == null) value = new NBTCompound();
        if (isVersion(ServerVersion.V_1_21_10, VersionComparison.NEWER_THAN_OR_EQUALS)) {
            super.metadata.setIndex(PLAYER_LEFT_SHOULDER_INDEX, EntityDataTypes.NBT, value);
        } else {
            super.metadata.setIndex(offset(OFFSET,4), EntityDataTypes.NBT, value);
        }
    }

    public @Nullable NBTCompound getRightShoulderData() {
        isVersionNewer(ServerVersion.V_1_11);
        if (isVersion(ServerVersion.V_1_21_10, VersionComparison.NEWER_THAN_OR_EQUALS)) {
            return super.metadata.getIndex(PLAYER_RIGHT_SHOULDER_INDEX, null);
        }
        return super.metadata.getIndex(offset(OFFSET,5), null);
    }

    public void setRightShoulderData(@Nullable NBTCompound value) {
        if (value == null) value = new NBTCompound();
        if (isVersion(ServerVersion.V_1_21_10, VersionComparison.NEWER_THAN_OR_EQUALS)) {
            super.metadata.setIndex(PLAYER_RIGHT_SHOULDER_INDEX, EntityDataTypes.NBT, value);
        } else {
            super.metadata.setIndex(offset(OFFSET,5), EntityDataTypes.NBT, value);
        }
    }

}
