package me.tofaa.entitylib.meta.wrapper;

import com.github.retrooper.packetevents.PacketEvents;
import me.tofaa.entitylib.meta.EntityMetadata;
import me.tofaa.entitylib.meta.property.WrapperProperty;
import org.jetbrains.annotations.NotNull;

/**
 * Represents an enum in the protocol which can either be serialized as byte or integer.
 * @see WrapperByteEnum
 * @see WrapperVarIntEnum
 */
public abstract class WrapperEnum<E extends Enum<E> & ProtocolEnum, T extends Number> extends WrapperMetadataValue<T> {

    private final E[] enumConstants;
    private final E defaultValue;

    protected WrapperEnum(@NotNull EntityMetadata store, @NotNull WrapperProperty<T, ? extends WrapperEnum<E, T>> key, @NotNull Class<E> enumType, @NotNull E defaultValue) {
        super(store, key);
        this.enumConstants = enumType.getEnumConstants();
        this.defaultValue = defaultValue;
    }

    @Override
    protected final @NotNull T defaultRaw() {
        return fromInt(this.defaultValue.getProtocolValue());
    }

    /**
     * Gets the constant in this wrapper or the default if no value present
     * @throws IllegalStateException if no enum can be mapped on this protocol version,
     * if this happens on the latest protocol version, please report it as a bug.
     */
    public @NotNull E get() {
        T raw = getRaw();
        int protocolValue = toInt(raw);

        for (E constant : this.enumConstants) {
            if (constant.getProtocolValue() == protocolValue) {
                return constant;
            }
        }

        throw new IllegalStateException("Failed to find protocol enum with value " + protocolValue + " on version server protocol "
                + PacketEvents.getAPI().getServerManager().getVersion().getProtocolVersion());
    }

    /**
     * Sets the enum constant in this wrapper
     */
    public void set(@NotNull E value) {
        setRaw(fromInt(value.getProtocolValue()));
    }

    /**
     * Converts the raw metadata type (byte or varint) to {@link ProtocolEnum#getProtocolValue()}.
     */
    protected abstract int toInt(@NotNull T raw);

    /**
     * Converts {@link ProtocolEnum#getProtocolValue()} to the raw metadata type (byte or varint).
     */
    protected abstract @NotNull T fromInt(int protocolValue);

}
