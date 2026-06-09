package me.tofaa.entitylib.meta;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataType;
import java.util.function.Function;

public class MappedMetadataKey<L, N> extends MetadataKey<N> {
    private final Function<L, N> serializer;
    private final Function<N, L> deserializer;

    public MappedMetadataKey(int index, EntityDataType<N> dataType,
                             Function<L, N> serializer, Function<N, L> deserializer) {
        super(index, dataType);
        this.serializer = serializer;
        this.deserializer = deserializer;
    }

    public Function<L, N> getSerializer() { return serializer; }
    public Function<N, L> getDeserializer() { return deserializer; }
}