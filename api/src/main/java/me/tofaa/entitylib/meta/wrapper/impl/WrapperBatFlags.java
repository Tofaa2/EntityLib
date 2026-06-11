package me.tofaa.entitylib.meta.wrapper.impl;

import me.tofaa.entitylib.meta.EntityMetadata;
import me.tofaa.entitylib.meta.types.BatMetaProperties;
import me.tofaa.entitylib.meta.wrapper.WrapperBitmask;
import org.jetbrains.annotations.NotNull;

/**
 * Represents {@link BatMetaProperties#FLAGS}
 */
public class WrapperBatFlags extends WrapperBitmask {

    // https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Bat
    private static final int MASK_IS_HANGING = 0x01;
    // rest is unused, nice and efficient mojang

    public WrapperBatFlags(@NotNull EntityMetadata store) {
        super(store, BatMetaProperties.FLAGS);
    }

    public boolean isHanging() {
        return hasMask(MASK_IS_HANGING);
    }

    public void setHanging(boolean hanging) {
        setMask(MASK_IS_HANGING, hanging);
    }
}
