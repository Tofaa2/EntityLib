package me.tofaa.entitylib.meta;

import com.github.retrooper.packetevents.protocol.entity.data.EntityData;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataType;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityMetadata;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.EntityLibAPI;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.Wrapper;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@SuppressWarnings("unchecked")
public class Metadata {

    private final int entityId;
    private volatile boolean notifyAboutChanges = true;
    private final Map<Byte, EntityData> notNotifiedChanges = new HashMap<>();
    private final Map<Byte, EntityData> metadataMap = new ConcurrentHashMap<>();

    public Metadata(int entityId) {
        this.entityId = entityId;
    }

    public <T> T getIndex(byte index, @Nullable T defaultValue) {
        EntityData value = this.metadataMap.get(index);
        return value != null ? (T) value.getValue() : defaultValue;
    }

    public <T> void setIndex(byte index, @NotNull EntityDataType<T> dataType, T value) {

        final EntityData entry = new EntityData(index, dataType, value);
        this.metadataMap.put(index, entry);

        final Optional<EntityLibAPI<?>> optionalApi = EntityLib.getOptionalApi();
        if (!optionalApi.isPresent()) return;
        final WrapperEntity entity = optionalApi.get().getEntity(entityId);
        if (entity == null || !entity.isSpawned()) return; // Not EntityLib entity then, the user must send the packet manually. OR not spawned.
        if (!this.notifyAboutChanges) {
            synchronized (this.notNotifiedChanges) {
                this.notNotifiedChanges.put(index, entry);
            }
        }
        else {
            entity.sendPacketToViewers(createPacket());
        }
    }

    public void setNotifyAboutChanges(boolean notifyAboutChanges) {
        if (this.notifyAboutChanges == notifyAboutChanges) {
            return;
        }

        List<EntityData> entries = null;
        synchronized (this.notNotifiedChanges) {
            this.notifyAboutChanges = notifyAboutChanges;
            if (notifyAboutChanges) {
                entries = new ArrayList<>(this.notNotifiedChanges.values());
                if (entries.isEmpty()) {
                    return;
                }
                this.notNotifiedChanges.clear();
            }
        }
        final WrapperEntity entity = EntityLib.getApi().getEntity(entityId);
        if (entries == null || entity == null || !entity.isSpawned()) {
            return;
        }

        WrapperPlayServerEntityMetadata packet = new WrapperPlayServerEntityMetadata(entityId, entries);
        entity.sendPacketsToViewers(packet);
    }


    public boolean isNotifyingChanges() {
        return notifyAboutChanges;
    }

    @NotNull List<EntityData> getEntries() {
        return Collections.unmodifiableList(new ArrayList<>(metadataMap.values()));
    }

    public WrapperPlayServerEntityMetadata createPacket() {
        return new WrapperPlayServerEntityMetadata(entityId, getEntries());
    }

}