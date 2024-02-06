package me.tofaa.entitylib.meta;

import com.github.retrooper.packetevents.protocol.entity.data.EntityData;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataType;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityMetadata;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@SuppressWarnings("unchecked")
public class Metadata {

    private final int entityId;
    private EntityData[] entries = new EntityData[0];
    private volatile Map<Integer, EntityData> entryMap = null;
    private volatile boolean notifyChanges = true;
    private final Map<Byte, EntityData> notNotifiedChanges = new HashMap<>();

    public Metadata(int entityId) {
        this.entityId = entityId;
    }

    public <T> T getIndex(byte index, @Nullable T defaultValue) {
        final EntityData[] entries = this.entries;
        if (index < 0 || index >= entries.length) {
            return defaultValue;
        }
        final EntityData entry = entries[index];
        if (entry == null) return defaultValue;
        if (entry.getValue() == null) return defaultValue;
        return (T) entry.getValue();
    }

    public <T> void setIndex(byte index, @NotNull EntityDataType<T> dataType, T value) {

        EntityData[] entries = this.entries;
        if (index >= entries.length) {
            final int newLength = Math.max(entries.length * 2, index + 1);
            this.entries = entries = Arrays.copyOf(entries, newLength);
        }

        EntityData data = new EntityData(index, dataType, value);
        entries[index] = data;
        this.entryMap = null;

        final WrapperEntity entity = EntityLib.getApi().findEntity(entityId);
        if (entity == null || entity.isSpawned()) return; // Not EntityLib entity then, the user must send the packet manually. OR not spawned.
        if (!this.notifyChanges) {
            synchronized (this.notNotifiedChanges) {
                this.notNotifiedChanges.put(index, data);
            }
        }
        else {
            entity.sendPacketToViewers(createPacket());
        }
    }

    public void setNotifyAboutChanges(boolean value) {
        if (this.notifyChanges == value) {
            return;
        }
        if (!notifyChanges) {
            return; // cache;
        }
        final WrapperEntity entity = EntityLib.getApi().findEntity(entityId);
        if (entity == null || entity.isSpawned()) return;
        Map<Byte, EntityData> entries;
        synchronized (this.notNotifiedChanges) {
            Map<Byte, EntityData> awaitingChanges = this.notNotifiedChanges;
            if (awaitingChanges.isEmpty()) return;
            entries = Collections.unmodifiableMap(awaitingChanges);
            awaitingChanges.clear();
        }
        entity.sendPacketsToViewers(new WrapperPlayServerEntityMetadata(entityId, new ArrayList<>(entries.values())));
    }


    public boolean isNotifyingChanges() {
        return notifyChanges;
    }

    @NotNull List<EntityData> getEntries() {
        return Collections.unmodifiableList(Arrays.asList(entries));
    }

    public WrapperPlayServerEntityMetadata createPacket() {
        return new WrapperPlayServerEntityMetadata(entityId, getEntries());
    }

}