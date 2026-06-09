package me.tofaa.entitylib.meta;

import com.github.retrooper.packetevents.protocol.entity.data.EntityData;
import com.github.retrooper.packetevents.protocol.entity.data.EntityMetadataProvider;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityMetadata;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jspecify.annotations.NonNull;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Metadata implements EntityMetadataProvider {
    private final int entityId;
    private volatile boolean notifyAboutChanges = true;
    private final Map<Integer, EntityData<?>> notNotifiedChanges = new HashMap<>();
    private final Map<Integer, EntityData<?>> metadataMap = new ConcurrentHashMap<>();

    public Metadata(int entityId) {
        this.entityId = entityId;
    }

    public void copyTo(Metadata other) {
        other.clear();
        synchronized (other.notNotifiedChanges) {
            other.notNotifiedChanges.putAll(notNotifiedChanges);
        }
        other.metadataMap.putAll(metadataMap);
    }

    public void copyFrom(Metadata other) {
        other.copyTo(this); // Scuffed pepelaugh
    }

    /**
     * Clears the internal metadata map, is not responsible for informing the clients entity view with the newly reset information
     */
    public void clear() {
        this.metadataMap.clear();
        synchronized (notNotifiedChanges) {
            this.notNotifiedChanges.clear();
        }
    }

    public <T> void set(@NotNull MetadataKey<T> key, T value) {
        EntityData<T> data = key.createData(value);
        metadataMap.put(key.getIndex(), data);

        if (notifyAboutChanges) {
            synchronized (notNotifiedChanges) {
                notNotifiedChanges.put(key.getIndex(), data);
            }
        }
    }

    @Nullable
    public <T> T get(@NotNull MetadataKey<T> key) {
        EntityData<?> data = metadataMap.get(key.getIndex());
        return key.parseData(data);
    }

    public <L, N> void setLogical(@NotNull MappedMetadataKey<L, N> key, L logicalValue) {
        set(key, key.getSerializer().apply(logicalValue));
    }

    @Nullable
    public <L, N> L getLogical(@NotNull MappedMetadataKey<L, N> key) {
        EntityData<?> data = metadataMap.get(key.getIndex());
        if (data == null) return null;
        return key.getDeserializer().apply(key.parseData(data));
    }

    public void setNotifyAboutChanges(boolean notifyAboutChanges) {
        if (this.notifyAboutChanges == notifyAboutChanges) {
            return;
        }

        List<EntityData<?>> entries = null;
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

    public void setMetaFromPacket(WrapperPlayServerEntityMetadata wrapper) {
        for (EntityData<?> data : wrapper.getEntityMetadata()) {
            metadataMap.put(data.getIndex(), data);
        }
    }

    public boolean isNotifyingChanges() { return notifyAboutChanges; }

    @NotNull
    List<EntityData<?>> getEntries() {
        return Collections.unmodifiableList(new ArrayList<>(metadataMap.values()));
    }

    public WrapperPlayServerEntityMetadata createPacket() {
        return new WrapperPlayServerEntityMetadata(entityId, getEntries());
    }

    @Override
    public @NonNull List<EntityData<?>> entityData(@NonNull ClientVersion version) {
        if (this.metadataMap.isEmpty()) {
            return new ArrayList<>();
        }

        List<EntityData<?>> sortedData = new ArrayList<>(this.metadataMap.values());
        sortedData.sort(Comparator.comparingInt(EntityData::getIndex));

        return sortedData;
    }
}