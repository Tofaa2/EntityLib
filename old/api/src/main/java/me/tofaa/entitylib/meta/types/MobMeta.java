package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.manager.server.ServerVersion;
import me.tofaa.entitylib.meta.EntityMeta;
import me.tofaa.entitylib.meta.Metadata;

public class MobMeta extends LivingEntityMeta {

    public static final byte OFFSET = LivingEntityMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 1;

    private final static byte NO_AI_BIT = 0x01;
    private final static byte IS_LEFT_HANDED_BIT = 0x02;
    private final static byte IS_AGGRESSIVE_BIT = 0x04;


    public MobMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    public boolean isNoAi() {
        return getMaskBit(OFFSET, NO_AI_BIT);
    }

    public void setNoAi(boolean value) {
        setMaskBit(OFFSET, NO_AI_BIT, value);
    }

    public boolean isLeftHanded() {
        EntityMeta.isVersionNewer(ServerVersion.V_1_9);
        return getMaskBit(OFFSET, IS_LEFT_HANDED_BIT);
    }

    public void setLeftHanded(boolean value) {
        EntityMeta.isVersionNewer(ServerVersion.V_1_9);
        setMaskBit(OFFSET, IS_LEFT_HANDED_BIT, value);
    }

    public boolean isAggressive() {
        EntityMeta.isVersionNewer(ServerVersion.V_1_14);
        return getMaskBit(OFFSET, IS_AGGRESSIVE_BIT);
    }

    public void setAggressive(boolean value) {
        EntityMeta.isVersionNewer(ServerVersion.V_1_14);
        setMaskBit(OFFSET, IS_AGGRESSIVE_BIT, value);
    }

}
