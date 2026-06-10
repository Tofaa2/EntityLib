package me.tofaa.entitylib.meta.wrapper.impl;

import me.tofaa.entitylib.meta.EntityMetadata;
import me.tofaa.entitylib.meta.types.EntityMetaProperties;
import me.tofaa.entitylib.meta.wrapper.WrapperBitmaskValue;
import org.jetbrains.annotations.NotNull;

/**
 * Represents {@link EntityMetaProperties#SHARED_FLAGS}
 */
public class WrapperSharedFlagsValue extends WrapperBitmaskValue {

    // Bit positions as documented in the Minecraft protocol wiki.
    // https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Entity
    private static final int BIT_ON_FIRE = 0;
    private static final int BIT_SNEAKING = 1;
    // bit 2 is unused/reserved
    private static final int BIT_SPRINTING = 3;
    private static final int BIT_SWIMMING = 4;
    private static final int BIT_INVISIBLE = 5;
    private static final int BIT_GLOWING = 6;
    private static final int BIT_FALL_FLYING = 7;

    public WrapperSharedFlagsValue(@NotNull EntityMetadata store) {
        super(store, EntityMetaProperties.SHARED_FLAGS);
    }

    /**
     * Returns {@code true} if the entity is on fire.
     */
    public boolean isOnFire() {
        return getFlag(BIT_ON_FIRE);
    }

    /**
     * Sets whether the entity is on fire.
     */
    public WrapperSharedFlagsValue setOnFire(boolean value) {
        setFlag(BIT_ON_FIRE, value);
        return this;
    }

    /**
     * Returns {@code true} if the entity is sneaking/crouching.
     */
    public boolean isSneaking() {
        return getFlag(BIT_SNEAKING);
    }

    /**
     * Sets whether the entity is sneaking/crouching.
     */
    public WrapperSharedFlagsValue setSneaking(boolean value) {
        setFlag(BIT_SNEAKING, value);
        return this;
    }

    /**
     * Returns {@code true} if the entity is sprinting.
     */
    public boolean isSprinting() {
        return getFlag(BIT_SPRINTING);
    }

    /**
     * Sets whether the entity is sprinting.
     */
    public WrapperSharedFlagsValue setSprinting(boolean value) {
        setFlag(BIT_SPRINTING, value);
        return this;
    }

    /**
     * Returns {@code true} if the entity is swimming.
     */
    public boolean isSwimming() {
        return getFlag(BIT_SWIMMING);
    }

    /**
     * Sets whether the entity is swimming.
     */
    public WrapperSharedFlagsValue setSwimming(boolean value) {
        setFlag(BIT_SWIMMING, value);
        return this;
    }

    /**
     * Returns {@code true} if the entity is invisible.
     */
    public boolean isInvisible() {
        return getFlag(BIT_INVISIBLE);
    }

    /**
     * Sets whether the entity is invisible.
     */
    public WrapperSharedFlagsValue setInvisible(boolean value) {
        setFlag(BIT_INVISIBLE, value);
        return this;
    }

    /**
     * Returns {@code true} if the entity has the glowing effect.
     */
    public boolean isGlowing() {
        return getFlag(BIT_GLOWING);
    }

    /**
     * Sets whether the entity has the glowing effect.
     */
    public WrapperSharedFlagsValue setGlowing(boolean value) {
        setFlag(BIT_GLOWING, value);
        return this;
    }

    /**
     * Returns {@code true} if the entity is elytra flying (fall flying).
     */
    public boolean isFallFlying() {
        return getFlag(BIT_FALL_FLYING);
    }

    /**
     * Sets whether the entity is elytra flying (fall flying).
     */
    public WrapperSharedFlagsValue setFallFlying(boolean value) {
        setFlag(BIT_FALL_FLYING, value);
        return this;
    }
}