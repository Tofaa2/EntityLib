package me.tofaa.entitylib.meta.wrapper.impl;

import me.tofaa.entitylib.meta.EntityMetadata;
import me.tofaa.entitylib.meta.types.DisplayMetaProperties;
import me.tofaa.entitylib.meta.wrapper.ChronologicalProtocolEnum;
import me.tofaa.entitylib.meta.wrapper.WrapperByteEnum;
import org.jetbrains.annotations.NotNull;

/**
 * Represents {@link DisplayMetaProperties#BILLBOARD_RENDER_CONSTRAINTS}
 */
public class WrapperDisplayBillboard extends WrapperByteEnum<WrapperDisplayBillboard.Constraints> {

    // https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Display
    public enum Constraints implements ChronologicalProtocolEnum {
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

    public WrapperDisplayBillboard(@NotNull EntityMetadata store) {
        super(store, DisplayMetaProperties.BILLBOARD_RENDER_CONSTRAINTS, Constraints.class, Constraints.FIXED);
    }

}
