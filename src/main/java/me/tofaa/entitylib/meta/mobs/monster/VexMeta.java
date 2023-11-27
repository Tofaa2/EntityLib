package me.tofaa.entitylib.meta.mobs.monster;

import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.MobMeta;

public class VexMeta extends MobMeta {

    public static final byte OFFSET = MobMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 1;

    private final static byte ATTACKING_BIT = 0x01;

    public VexMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    public boolean isAttacking() {
        return getMaskBit(OFFSET, ATTACKING_BIT);
    }

    public void setAttacking(boolean value) {
        setMaskBit(OFFSET, ATTACKING_BIT, value);
    }

}
