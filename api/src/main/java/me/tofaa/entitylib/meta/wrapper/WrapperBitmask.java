package me.tofaa.entitylib.meta.wrapper;

import me.tofaa.entitylib.meta.EntityMetadata;
import me.tofaa.entitylib.meta.property.WrapperProperty;
import org.jetbrains.annotations.NotNull;

public abstract class WrapperBitmask extends WrapperMetadataValue<Byte> {

    protected WrapperBitmask(@NotNull EntityMetadata store, @NotNull WrapperProperty<Byte, ? extends WrapperBitmask> property) {
        super(store, property);
    }

    @Override
    protected @NotNull Byte defaultRaw() {
        return (byte) 0;
    }

    /**
     * Returns whether the bitmask is present in the current raw byte.
     *
     * @param mask the bitmask to check (e.g., 0x02)
     */
    protected final boolean hasMask(int mask) {
        assertMask(mask);
        return (getRaw() & mask) != 0;
    }

    /**
     * Sets or clears the bits defined by the mask.
     *
     * @param mask  the bitmask to modify
     * @param value {@code true} to set the bits, {@code false} to clear them
     */
    protected final void setMask(int mask, boolean value) {
        assertMask(mask);
        byte current = getRaw();
        byte updated = value ? (byte) (current | mask)
                : (byte) (current & ~mask);
        setRaw(updated);
    }

    /**
     * Returns a copy of the current raw byte with the specified mask set or cleared.
     */
    protected static byte withMask(byte raw, int mask, boolean value) {
        assertMask(mask);
        return value ? (byte) (raw | mask)
                : (byte) (raw & ~mask);
    }

    private static void assertMask(int mask) {
        // ensures the mask doesn't exceed a single byte's capacity (0x00 - 0xFF)
        if ((mask & ~0xFF) != 0) {
            throw new IllegalArgumentException(
                    String.format("Mask must fit within a single byte (0x00 - 0xFF), got: 0x%02X", mask)
            );
        }
    }

}
