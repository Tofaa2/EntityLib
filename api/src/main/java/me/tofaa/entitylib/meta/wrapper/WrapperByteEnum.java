package me.tofaa.entitylib.meta.wrapper;

import me.tofaa.entitylib.meta.EntityMetadata;
import me.tofaa.entitylib.meta.property.WrapperProperty;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a {@link WrapperEnum} whose {@link ProtocolEnum#getProtocolValue()} is serialized as a byte
 */
public class WrapperByteEnum<E extends Enum<E> & ProtocolEnum> extends WrapperEnum<E, Byte> {

    public WrapperByteEnum(@NotNull EntityMetadata store, @NotNull WrapperProperty<Byte, ? extends WrapperEnum<E, Byte>> key, @NotNull Class<E> enumType, @NotNull E defaultValue) {
        super(store, key, enumType, defaultValue);
    }

    @Override
    protected int toInt(@NotNull Byte raw) {
        return raw.intValue() & 0xFF;
    }

    @Override
    protected @NotNull Byte fromInt(int protocolValue) {
        if (protocolValue < -128 || protocolValue > 255) { // both unsigned and signed supported
            throw new IllegalArgumentException("Protocol value " + protocolValue + " out of valid byte range");
        }
        return (byte) protocolValue;
    }

}
