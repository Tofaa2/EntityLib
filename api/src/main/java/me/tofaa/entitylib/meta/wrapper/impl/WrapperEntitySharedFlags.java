package me.tofaa.entitylib.meta.wrapper.impl;

import me.tofaa.entitylib.meta.EntityMetadata;
import me.tofaa.entitylib.meta.types.EntityMetaProperties;
import me.tofaa.entitylib.meta.wrapper.WrapperBitmask;
import org.jetbrains.annotations.NotNull;

/**
 * Represents {@link EntityMetaProperties#SHARED_FLAGS}
 */
public class WrapperEntitySharedFlags extends WrapperBitmask {

    // https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Entity
    private static final int MASK_ON_FIRE = 0x01;
    private static final int MASK_SNEAKING = 0x02;
    // 0x04 is unused/reserved (irrelevant to 1.14.4+)
    private static final int MASK_SPRINTING = 0x08;
    private static final int MASK_SWIMMING = 0x10;
    private static final int MASK_INVISIBLE = 0x20;
    private static final int MASK_GLOWING = 0x40;
    private static final int MASK_FALL_FLYING = 0x80;

    public WrapperEntitySharedFlags(@NotNull EntityMetadata store) {
        super(store, EntityMetaProperties.SHARED_FLAGS);
    }

    /**
     * Returns {@code true} if the entity is on fire.
     */
    public boolean isOnFire() {
        return hasMask(MASK_ON_FIRE);
    }

    /**
     * Sets whether the entity is on fire.
     */
    public WrapperEntitySharedFlags setOnFire(boolean value) {
        setMask(MASK_ON_FIRE, value);
        return this;
    }

    /**
     * Returns {@code true} if the entity is sneaking/crouching.
     */
    public boolean isSneaking() {
        return hasMask(MASK_SNEAKING);
    }

    /**
     * Sets whether the entity is sneaking/crouching.
     */
    public WrapperEntitySharedFlags setSneaking(boolean value) {
        setMask(MASK_SNEAKING, value);
        return this;
    }

    /**
     * Returns {@code true} if the entity is sprinting.
     */
    public boolean isSprinting() {
        return hasMask(MASK_SPRINTING);
    }

    /**
     * Sets whether the entity is sprinting.
     */
    public WrapperEntitySharedFlags setSprinting(boolean value) {
        setMask(MASK_SPRINTING, value);
        return this;
    }

    /**
     * Returns {@code true} if the entity is swimming.
     */
    public boolean isSwimming() {
        return hasMask(MASK_SWIMMING);
    }

    /**
     * Sets whether the entity is swimming.
     */
    public WrapperEntitySharedFlags setSwimming(boolean value) {
        setMask(MASK_SWIMMING, value);
        return this;
    }

    /**
     * Returns {@code true} if the entity is invisible.
     */
    public boolean isInvisible() {
        return hasMask(MASK_INVISIBLE);
    }

    /**
     * Sets whether the entity is invisible.
     */
    public WrapperEntitySharedFlags setInvisible(boolean value) {
        setMask(MASK_INVISIBLE, value);
        return this;
    }

    /**
     * Returns {@code true} if the entity has the glowing effect.
     */
    public boolean isGlowing() {
        return hasMask(MASK_GLOWING);
    }

    /**
     * Sets whether the entity has the glowing effect.
     */
    public WrapperEntitySharedFlags setGlowing(boolean value) {
        setMask(MASK_GLOWING, value);
        return this;
    }

    /**
     * Returns {@code true} if the entity is elytra flying (fall flying).
     */
    public boolean isFallFlying() {
        return hasMask(MASK_FALL_FLYING);
    }

    /**
     * Sets whether the entity is elytra flying (fall flying).
     */
    public WrapperEntitySharedFlags setFallFlying(boolean value) {
        setMask(MASK_FALL_FLYING, value);
        return this;
    }

}
