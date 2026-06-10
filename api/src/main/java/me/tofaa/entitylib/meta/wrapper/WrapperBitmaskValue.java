package me.tofaa.entitylib.meta.wrapper;

import me.tofaa.entitylib.meta.EntityMetadata;
import me.tofaa.entitylib.meta.property.WrapperProperty;
import org.jetbrains.annotations.NotNull;

public abstract class WrapperBitmaskValue extends WrapperMetadataValue<Byte> {

    protected WrapperBitmaskValue(@NotNull EntityMetadata store, @NotNull WrapperProperty<Byte, ? extends WrapperBitmaskValue> property) {
        super(store, property);
    }

    @Override
    protected @NotNull Byte defaultRaw() {
        return (byte) 0;
    }

    /**
     * Returns whether the flag at {@code bitIndex} is set in the current raw byte.
     *
     * @param bitIndex zero-based bit position (0 = LSB)
     * @throws IllegalArgumentException if {@code bitIndex} is not in [0, 7]
     */
    protected final boolean getFlag(int bitIndex) {
        assertBitIndex(bitIndex);
        return (getRaw() & (1 << bitIndex)) != 0;
    }

    /**
     * Sets or clears the flag at {@code bitIndex} and writes the result back to the
     * store. All other bits are preserved.
     *
     * @param bitIndex zero-based bit position (0 = LSB)
     * @param value    {@code true} to set the bit, {@code false} to clear it
     * @throws IllegalArgumentException if {@code bitIndex} is not in [0, 7]
     */
    protected final void setFlag(int bitIndex, boolean value) {
        assertBitIndex(bitIndex);
        byte current = getRaw();
        byte updated = value ? (byte) (current | (1 << bitIndex))
                : (byte) (current & ~(1 << bitIndex));
        setRaw(updated);
    }

    /**
     * Returns a copy of the current raw byte with the specified bit set or cleared,
     * without writing it back. Useful for computing a combined value before a single
     * {@link #setRaw} call.
     *
     * @param raw      the base byte to modify
     * @param bitIndex zero-based bit position
     * @param value    whether to set or clear the bit
     */
    protected static byte withFlag(byte raw, int bitIndex, boolean value) {
        assertBitIndex(bitIndex);
        return value ? (byte) (raw | (1 << bitIndex))
                : (byte) (raw & ~(1 << bitIndex));
    }

    private static void assertBitIndex(int bitIndex) {
        if (bitIndex < 0 || bitIndex > 7) {
            throw new IllegalArgumentException("Bit index must be in [0, 7], got: " + bitIndex);
        }
    }
}