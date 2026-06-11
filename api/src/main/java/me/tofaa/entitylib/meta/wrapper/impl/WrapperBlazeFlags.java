package me.tofaa.entitylib.meta.wrapper.impl;

import me.tofaa.entitylib.meta.EntityMetadata;
import me.tofaa.entitylib.meta.types.BlazeMetaProperties;
import me.tofaa.entitylib.meta.wrapper.WrapperBitmask;
import org.jetbrains.annotations.NotNull;

/**
 * Represents {@link BlazeMetaProperties#FLAGS}
 */
public class WrapperBlazeFlags extends WrapperBitmask {

    // https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Blaze
    private static final int MASK_IS_ON_FIRE = 0x01;
    // rest is unused, nice and efficient mojang

    public WrapperBlazeFlags(@NotNull EntityMetadata store) {
        super(store, BlazeMetaProperties.FLAGS);
    }

    public boolean isOnFire() {
        return hasMask(MASK_IS_ON_FIRE);
    }

    public void setOnFire(boolean onFire) {
        setMask(MASK_IS_ON_FIRE, onFire);
    }

}
