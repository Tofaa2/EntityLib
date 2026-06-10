package me.tofaa.entitylib.meta.wrapper;

import me.tofaa.entitylib.meta.EntityMetadata;
import me.tofaa.entitylib.meta.property.WrapperProperty;
import org.jetbrains.annotations.NotNull;

public class WrapperEnumValue<E extends Enum<E>, T> extends WrapperMetadataValue<T> {

    private final E[] enumConstants;
    private final Encoding encoding;

    /**
     * @param encoding how the {@link Enum#ordinal()} should be encoded into the metadata
     */
    public WrapperEnumValue(@NotNull EntityMetadata store, @NotNull WrapperProperty<T, ? extends WrapperEnumValue<E, T>> key, @NotNull Class<E> enumType, Encoding encoding) {
        super(store, key);
        this.enumConstants = enumType.getEnumConstants();
        this.encoding = encoding;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected @NotNull T defaultRaw() {
        return this.encoding == Encoding.BYTE ? (T) Byte.valueOf((byte) 0) : (T) Integer.valueOf(0);
    }

    /**
     * Returns the current enum value, resolved from the stored raw ordinal.
     * Falls back to the first enum constant (ordinal 0) if out of range.
     */
    public @NotNull E get() {
        T raw = getRaw();
        int ordinal = 0;

        if (raw instanceof Number) {
            ordinal = ((Number) raw).intValue();
            if (this.encoding == Encoding.BYTE) {
                ordinal &= 0xFF;
            }
        }

        if (ordinal < 0 || ordinal >= this.enumConstants.length) {
            return this.enumConstants[0];
        }
        return this.enumConstants[ordinal];
    }

    @SuppressWarnings("unchecked")
    public void set(@NotNull E value) {
        int ordinal = value.ordinal();
        if (this.encoding == Encoding.BYTE) {
            if (ordinal > 255) {
                throw new IllegalArgumentException("Enum ordinal " + ordinal + " exceeds byte range for " + value);
            }
            setRaw((T) Byte.valueOf((byte) ordinal));
        } else {
            setRaw((T) Integer.valueOf(ordinal));
        }
    }

    public int enumSize() {
        return this.enumConstants.length;
    }

    public enum Encoding {
        BYTE,
        VARINT;
    }
}