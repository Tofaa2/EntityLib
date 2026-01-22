package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.manager.server.ServerVersion;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.meta.Metadata;

public class AvatarMeta extends LivingEntityMeta {

    public static final byte OFFSET = LivingEntityMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 2;

    private static final byte CAPE_BIT = 0x01;
    private static final byte JACKET_BIT = 0x02;
    private static final byte LEFT_SLEEVE_BIT = 0x04;
    private static final byte RIGHT_SLEEVE_BIT = 0x08;
    private static final byte LEFT_LEG_BIT = 0x10;
    private static final byte RIGHT_LEG_BIT = 0x20;
    private static final byte HAT_BIT = 0x40;

    public AvatarMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    public boolean isRightHandMain() {
        if (EntityLib.getApi().getPacketEvents().getServerManager().getVersion().isOlderThan(ServerVersion.V_1_9)) {
            return true;
        }
        return super.metadata.getIndex(OFFSET, (byte) 1) == (byte) 1;
    }

    public void setRightHandMain(boolean value) {
        if (EntityLib.getApi().getPacketEvents().getServerManager().getVersion().isOlderThan(ServerVersion.V_1_9)) {
            return;
        }
        super.metadata.setIndex(OFFSET, EntityDataTypes.BYTE, (byte) (value ? 1 : 0));
    }

    public boolean isCapeEnabled() {
        isVersionNewer(ServerVersion.V_1_9);
        return getMaskBit(offset(OFFSET, 1), CAPE_BIT);
    }

    public void setCapeEnabled(boolean value) {
        isVersionNewer(ServerVersion.V_1_9);
        setMaskBit(offset(OFFSET, 1), CAPE_BIT, value);
    }

    public boolean isJacketEnabled() {
        isVersionNewer(ServerVersion.V_1_9);
        return getMaskBit(offset(OFFSET, 1), JACKET_BIT);
    }

    public void setJacketEnabled(boolean value) {
        isVersionNewer(ServerVersion.V_1_9);
        setMaskBit(offset(OFFSET, 1), JACKET_BIT, value);
    }

    public boolean isLeftSleeveEnabled() {
        isVersionNewer(ServerVersion.V_1_9);
        return getMaskBit(offset(OFFSET, 1), LEFT_SLEEVE_BIT);
    }

    public void setLeftSleeveEnabled(boolean value) {
        isVersionNewer(ServerVersion.V_1_9);
        setMaskBit(offset(OFFSET, 1), LEFT_SLEEVE_BIT, value);
    }

    public boolean isRightSleeveEnabled() {
        isVersionNewer(ServerVersion.V_1_9);
        return getMaskBit(offset(OFFSET, 1), RIGHT_SLEEVE_BIT);
    }

    public void setRightSleeveEnabled(boolean value) {
        isVersionNewer(ServerVersion.V_1_9);
        setMaskBit(offset(OFFSET, 1), RIGHT_SLEEVE_BIT, value);
    }

    public boolean isLeftLegEnabled() {
        isVersionNewer(ServerVersion.V_1_9);
        return getMaskBit(offset(OFFSET, 1), LEFT_LEG_BIT);
    }

    public void setLeftLegEnabled(boolean value) {
        isVersionNewer(ServerVersion.V_1_9);
        setMaskBit(offset(OFFSET, 1), LEFT_LEG_BIT, value);
    }

    public boolean isRightLegEnabled() {
        isVersionNewer(ServerVersion.V_1_9);
        return getMaskBit(offset(OFFSET, 1), RIGHT_LEG_BIT);
    }

    public void setRightLegEnabled(boolean value) {
        isVersionNewer(ServerVersion.V_1_9);
        setMaskBit(offset(OFFSET, 1), RIGHT_LEG_BIT, value);
    }

    public boolean isHatEnabled() {
        isVersionNewer(ServerVersion.V_1_9);
        return getMaskBit(offset(OFFSET, 1), HAT_BIT);
    }

    public void setHatEnabled(boolean value) {
        isVersionNewer(ServerVersion.V_1_9);
        setMaskBit(offset(OFFSET, 1), HAT_BIT, value);
    }
}
