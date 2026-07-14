package me.tofaa.entitylib.meta;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataType;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public final class VersionedField<T> {

    private final int index;
    private final EntityDataType<T> wireType;

    VersionedField(int index, @NotNull EntityDataType<T> wireType) {
        this.index = index;
        this.wireType = wireType;
    }

    public int index() {
        return index;
    }

    public @NotNull EntityDataType<T> wireType() {
        return wireType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VersionedField<?> that)) return false;
        return index == that.index && wireType.equals(that.wireType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, wireType);
    }

    @Override
    public String toString() {
        return "VersionedField{index=" + index + ", wireType=" + wireType + "}";
    }
}
