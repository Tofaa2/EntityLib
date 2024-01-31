package me.tofaa.entitylib.meta;

import com.github.retrooper.packetevents.protocol.entity.data.EntityData;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataType;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@SuppressWarnings("unchecked")
public class Metadata {

    private final Map<Byte, EntityData> metadataMap = new ConcurrentHashMap<>();
    private final int entityId;

    public Metadata(int entityId) {
        this.entityId = entityId;
    }

    public <T> T getIndex(byte index, @Nullable T defaultValue) {
        EntityData entityData = metadataMap.get(index);
        if (entityData == null) return defaultValue;
        if (entityData.getValue() == null) return defaultValue;
        return (T) entityData.getValue();
    }

    public <T> void setIndex(byte index, @NotNull EntityDataType<T> dataType, T value) {
        EntityData data = new EntityData(index, dataType, value);
        this.metadataMap.put(index, data);
    }

    @NotNull List<EntityData> getEntries() {
        return new ArrayList<>(metadataMap.values());
    }

    public WrapperPlayServerEntityMetadata createPacket() {
        return new WrapperPlayServerEntityMetadata(entityId, getEntries());
    }

}