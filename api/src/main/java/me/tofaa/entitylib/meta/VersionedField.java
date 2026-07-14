package me.tofaa.entitylib.meta;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataType;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.function.Function;

public final class VersionedField<T> {

    private final int index;
    private final EntityDataType<?> wireType;
    private final T defaultValue;
    final Function<T, Object> encoder;
    final Function<Object, T> decoder;

    VersionedField(
            int index,
            @NotNull EntityDataType<?> wireType,
            T defaultValue,
            @NotNull Function<T, Object> encoder,
            @NotNull Function<Object, T> decoder
    ) {
        this.index = index;
        this.wireType = wireType;
        this.defaultValue = defaultValue;
        this.encoder = encoder;
        this.decoder = decoder;
    }

    public int index() {
        return index;
    }

    public @NotNull EntityDataType<?> wireType() {
        return wireType;
    }

    public T defaultValue() {
        return defaultValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VersionedField<?> that)) return false;
        return index == that.index && wireType.equals(that.wireType) && defaultValue.equals(that.defaultValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, wireType, defaultValue);
    }

    @Override
    public String toString() {
        return "VersionedField{index=" + index + ", wireType=" + wireType + ", defaultValue=" + defaultValue + "}";
    }
}
