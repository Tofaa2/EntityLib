package me.tofaa.entitylib.meta.wrapper;

import me.tofaa.entitylib.meta.EntityMetadata;
import me.tofaa.entitylib.meta.property.WrapperProperty;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a {@link WrapperEnum} whose {@link ProtocolEnum#getProtocolValue()} is serialized as varint
 */
public class WrapperVarIntEnum<E extends Enum<E> & ProtocolEnum> extends WrapperEnum<E, Integer> {

    public WrapperVarIntEnum(@NotNull EntityMetadata store, @NotNull WrapperProperty<Integer, ? extends WrapperEnum<E, Integer>> key, @NotNull Class<E> enumType, @NotNull E defaultValue) {
        super(store, key, enumType, defaultValue);
    }

    @Override
    protected int toInt(@NotNull Integer raw) {
        return raw;
    }

    @Override
    protected @NotNull Integer fromInt(int protocolValue) {
        return protocolValue;
    }

}
