package me.tofaa.entitylib.meta.wrapper.impl;

import me.tofaa.entitylib.meta.EntityMetadata;
import me.tofaa.entitylib.meta.types.DisplayMetaProperties;
import me.tofaa.entitylib.meta.wrapper.WrapperEnumValue;
import org.jetbrains.annotations.NotNull;

/**
 * Represents {@link DisplayMetaProperties#BILLBOARD_RENDER_CONSTRAINTS}
 */
public class WrapperBillboardValue extends WrapperEnumValue<WrapperBillboardValue.Constraints, Byte> {

    /**
     * How a display renders to the clients
     */
    public enum Constraints {
        /**
         * No automatic rotation, orientation is fully manual
         */
        FIXED,
        /**
         * The display rotates freely on both axes to always face the camera.
         */
        CENTER,
        /**
         * Rotates only around the vertical (Y) axis to face the camera.
         */
        VERTICAL,
        /**
         * Rotates only around the horizontal axis to face the camera.
         */
        HORIZONTAL
    }

    public WrapperBillboardValue(@NotNull EntityMetadata store) {
        super(store, DisplayMetaProperties.BILLBOARD_RENDER_CONSTRAINTS, Constraints.class, Encoding.BYTE);
    }


    public boolean isFixed() {
        return get() == Constraints.FIXED;
    }

    public boolean isCenter() {
        return get() == Constraints.CENTER;
    }

    public boolean isVertical() {
        return get() == Constraints.VERTICAL;
    }
    public boolean isHorizontal() {
        return get() == Constraints.HORIZONTAL;
    }
}