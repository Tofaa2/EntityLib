package me.tofaa.entitylib.meta.projectile;

import com.github.retrooper.packetevents.manager.server.ServerVersion;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.EntityMeta;
import me.tofaa.entitylib.meta.Metadata;

public class BaseArrowMeta extends EntityMeta {

    public static final byte OFFSET = EntityMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 2;

    private final static byte CRITICAL_BIT = 0x01;
    private final static byte NO_CLIP_BIT = 0x02;

    public BaseArrowMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    public boolean isCritical() {
        return getMaskBit(OFFSET, CRITICAL_BIT);
    }

    public void setCritical(boolean value) {
        setMaskBit(OFFSET, CRITICAL_BIT, value);
    }

    public boolean isNoClip() {
        isVersionNewer(ServerVersion.V_1_9);
        return getMaskBit(OFFSET, NO_CLIP_BIT);
    }

    public void setNoClip(boolean value) {
        isVersionNewer(ServerVersion.V_1_9);
        setMaskBit(OFFSET, NO_CLIP_BIT, value);
    }

    public int getPierceLevel() {
        isVersionNewer(ServerVersion.V_1_14);
        return super.metadata.getIndex(offset(OFFSET,1), 0);
    }

    public void setPierceLevel(int value) {
        isVersionNewer(ServerVersion.V_1_14);
        super.metadata.setIndex(offset(OFFSET,1), EntityDataTypes.INT, value);
    }

}
