package me.tofaa.entitylib.meta.wrapper.impl;

import me.tofaa.entitylib.meta.EntityMetadata;
import me.tofaa.entitylib.meta.types.AbstractHorseMetaProperties;
import me.tofaa.entitylib.meta.wrapper.WrapperBitmask;

public class WrapperAbstractHorseFlags extends WrapperBitmask {

    // https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Abstract_Horse
    // 0x01 unused
    private static final int MASK_IS_TAMED = 0x02;
    // 0x04 unused
    private static final int MASK_HAS_BRED = 0x08;
    private static final int MASK_IS_EATING = 0x10;
    private static final int MASK_IS_REARING = 0x20;
    private static final int MASK_IS_MOUTH_OPEN = 0x40;
    // 0x80 unused

    public WrapperAbstractHorseFlags(EntityMetadata store) {
        super(store, AbstractHorseMetaProperties.FLAGS);
    }

    public boolean isTamed() {
        return hasMask(MASK_IS_TAMED);
    }

    public void setIsTamed(boolean value) {
        setMask(MASK_IS_TAMED, value);
    }

    public boolean hasBred() {
        return hasMask(MASK_HAS_BRED);
    }

    public void setHasBred(boolean value) {
        setMask(MASK_HAS_BRED, value);
    }

    public boolean isEating() {
        return hasMask(MASK_IS_EATING);
    }

    public void setIsEating(boolean value) {
        setMask(MASK_IS_EATING, value);
    }

    public boolean isRearing() {
        return hasMask(MASK_IS_REARING);
    }

    public void setIsRearing(boolean value) {
        setMask(MASK_IS_REARING, value);
    }

    public boolean isMouthOpen() {
        return hasMask(MASK_IS_MOUTH_OPEN);
    }

    public void setIsMouthOpen(boolean value) {
        setMask(MASK_IS_MOUTH_OPEN, value);
    }

}
