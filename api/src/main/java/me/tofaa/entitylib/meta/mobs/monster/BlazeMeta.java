package me.tofaa.entitylib.meta.mobs.monster;

import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.MobMeta;

public class BlazeMeta extends MobMeta {

    public static final byte OFFSET = MobMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 1;

    private final static byte ON_FIRE_BIT = 0x01;

    public BlazeMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    public boolean isOnFire() {
        return getMaskBit(OFFSET, ON_FIRE_BIT);
    }

    public void setOnFire(boolean value) {
        setMaskBit(OFFSET, ON_FIRE_BIT, value);
    }


}
