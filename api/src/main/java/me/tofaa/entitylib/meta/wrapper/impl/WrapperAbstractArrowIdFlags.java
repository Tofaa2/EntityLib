package me.tofaa.entitylib.meta.wrapper.impl;

import me.tofaa.entitylib.meta.EntityMetadata;
import me.tofaa.entitylib.meta.types.AbstractArrowMetaProperties;
import me.tofaa.entitylib.meta.wrapper.WrapperBitmask;
import org.jetbrains.annotations.NotNull;

/**
 * Represents {@link AbstractArrowMetaProperties#ID_FLAGS}
 */
public class WrapperAbstractArrowIdFlags extends WrapperBitmask {

    // https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Abstract_Arrow
    private static final int MASK_IS_CRITICAL = 0x01;
    private static final int MASK_IS_NOCLIP = 0x02;
    // rest unused

    public WrapperAbstractArrowIdFlags(@NotNull EntityMetadata store) {
        super(store, AbstractArrowMetaProperties.ID_FLAGS);
    }

    public boolean isCritical() {
        return hasMask(MASK_IS_CRITICAL);
    }

    public void setIsCritical(boolean value) {
        setMask(MASK_IS_CRITICAL, value);
    }

    /**
     * used by loyalty tridents when returning
     */
    public boolean isNoClip() {
        return hasMask(MASK_IS_NOCLIP);
    }

    /**
     * used by loyalty tridents when returning
     */
    public void setNoClip(boolean value) {
        setMask(MASK_IS_NOCLIP, value);
    }

}
