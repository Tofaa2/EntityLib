package me.tofaa.entitylib.meta;

import com.github.retrooper.packetevents.protocol.entity.data.EntityData;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataType;

public class MetadataKey<T> {
    private final int index;
    private final EntityDataType<T> dataType;

    public MetadataKey(int index, EntityDataType<T> dataType) {
        this.index = index;
        this.dataType = dataType;
    }

    public int getIndex() { return index; }
    public EntityDataType<T> getDataType() { return dataType; }

    public EntityData<T> createData(T value) {
        return new EntityData<>(index, dataType, value);
    }

    @SuppressWarnings("unchecked")
    public T parseData(EntityData<?> data) {
        if (data == null) return null;
        return (T) data.getValue();
    }
}