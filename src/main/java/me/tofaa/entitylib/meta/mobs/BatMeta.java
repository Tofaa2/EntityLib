package me.tofaa.entitylib.meta.mobs;

import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.MobMeta;

public class BatMeta extends MobMeta {

    public static final byte OFFSET = MobMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 0;

    private final static byte IS_HANGING_BIT = 0x01;

    public BatMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    public boolean isHanging() {
        return getMaskBit(OFFSET, IS_HANGING_BIT);
    }

    public void setHanging(boolean value) {
        setMaskBit(OFFSET, IS_HANGING_BIT, value);
    }


}
