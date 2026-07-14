package me.tofaa.entitylib.meta.mobs.passive;

import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.AgeableMeta;

public class SheepMeta extends AgeableMeta {

    public static final byte OFFSET = AgeableMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 1;


    private final static byte COLOR_BITS = 0x0F;
    private final static byte SHEARED_BIT = 0x10;

    public SheepMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    public int getColor() {
        return getMask(OFFSET) & COLOR_BITS;
    }

    public void setColor(byte color) {
        byte before = getMask(OFFSET);
        byte mask = before;
        mask &= ~COLOR_BITS;
        mask |= (color & COLOR_BITS);
        if (mask != before) {
            setMask(OFFSET, mask);
        }
    }

    public boolean isSheared() {
        return getMaskBit(OFFSET, SHEARED_BIT);
    }

    public void setSheared(boolean value) {
        setMaskBit(OFFSET, SHEARED_BIT, value);
    }



}
