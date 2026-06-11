package me.tofaa.entitylib.meta.wrapper.impl;

import me.tofaa.entitylib.meta.EntityMetadata;
import me.tofaa.entitylib.meta.types.AvatarMetaProperties;
import me.tofaa.entitylib.meta.wrapper.WrapperBitmask;
import org.jetbrains.annotations.NotNull;

/**
 * Represents {@link AvatarMetaProperties#PLAYER_MODE_CUSTOMISATION}
 */
public class WrapperAvatarPlayerModeCustomizationFlags extends WrapperBitmask {

    // https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Avatar
    private static final int MASK_CAPE = 0x01;
    private static final int MASK_JACKET = 0x02;
    private static final int MASK_LEFT_SLEEVE = 0x04;
    private static final int MASK_RIGHT_SLEEVE = 0x08;
    private static final int MASK_LEFT_PANTS_LEG = 0x10;
    private static final int MASK_RIGHT_PANTS_LEG = 0x20;
    private static final int MASK_HAT = 0x40;
    // 0x80 unused

    public WrapperAvatarPlayerModeCustomizationFlags(@NotNull EntityMetadata store) {
        super(store, AvatarMetaProperties.PLAYER_MODE_CUSTOMISATION);
    }

    public boolean isCapeEnabled() {
        return hasMask(MASK_CAPE);
    }

    public void setCapeEnabled(boolean value) {
        setMask(MASK_CAPE, value);
    }

    public boolean isJacketEnabled() {
        return hasMask(MASK_JACKET);
    }

    public void setJacketEnabled(boolean value) {
        setMask(MASK_JACKET, value);
    }

    public boolean isLeftSleeveEnabled() {
        return hasMask(MASK_LEFT_SLEEVE);
    }

    public void setLeftSleeveEnabled(boolean value) {
        setMask(MASK_LEFT_SLEEVE, value);
    }

    public boolean isRightSleeveEnabled() {
        return hasMask(MASK_RIGHT_SLEEVE);
    }

    public void setRightSleeveEnabled(boolean value) {
        setMask(MASK_RIGHT_SLEEVE, value);
    }

    public boolean isLeftPantsLegEnabled() {
        return hasMask(MASK_LEFT_PANTS_LEG);
    }

    public void setLeftPantsLegEnabled(boolean value) {
        setMask(MASK_LEFT_PANTS_LEG, value);
    }

    public boolean isRightPantsLegEnabled() {
        return hasMask(MASK_RIGHT_PANTS_LEG);
    }

    public void setRightPantsLegEnabled(boolean value) {
        setMask(MASK_RIGHT_PANTS_LEG, value);
    }

    public boolean isHatEnabled() {
        return hasMask(MASK_HAT);
    }

    public void setHatEnabled(boolean value) {
        setMask(MASK_HAT, value);
    }

}
