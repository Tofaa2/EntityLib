package me.tofaa.entitylib.meta;

import com.github.retrooper.packetevents.protocol.entity.data.EntityData;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataType;
import org.jetbrains.annotations.NotNull;

public final class MetaBinding<T, W> {

    private final int fromProtocol;
    private final int toProtocol;
    private final int index;
    private final EntityDataType<W> wireType;
    private final MetaConverter<T, W> converter;

    MetaBinding(int fromProtocol, int toProtocol, int index, EntityDataType<W> wireType, MetaConverter<T, W> converter) {
        this.fromProtocol = fromProtocol;
        this.toProtocol = toProtocol;
        this.index = index;
        this.wireType = wireType;
        this.converter = converter;
    }

    public int fromProtocol() {
        return fromProtocol;
    }

    public int toProtocol() {
        return toProtocol;
    }

    public boolean matches(int protocolVersion) {
        return protocolVersion >= fromProtocol && protocolVersion < toProtocol;
    }

    public int index() {
        return index;
    }

    public @NotNull EntityDataType<W> wireType() {
        return wireType;
    }

    public @NotNull MetaConverter<T, W> converter() {
        return converter;
    }

    public @NotNull EntityData<W> encode(T value) {
        return new EntityData<>(index, wireType, converter.toWire(value));
    }

    @SuppressWarnings("unchecked")
    public T decode(Object wireValue) {
        return converter.fromWire((W) wireValue);
    }

    @Override
    public String toString() {
        return "MetaBinding{" + fromProtocol + ".." + (toProtocol == Integer.MAX_VALUE ? "" : String.valueOf(toProtocol))
                + " index=" + index + " type=" + wireType.getName() + "}";
    }
}
