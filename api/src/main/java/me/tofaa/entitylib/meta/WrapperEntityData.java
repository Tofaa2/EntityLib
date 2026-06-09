package me.tofaa.entitylib.meta;

import com.github.retrooper.packetevents.protocol.entity.data.EntityData;
import com.github.retrooper.packetevents.protocol.entity.data.EntityMetadataProvider;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityMetadata;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.meta.types.EntityDataKeys;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Stores <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata">entity metadata</a> and resolves it to PacketEvents metadata when needed.
 */
public class WrapperEntityData implements EntityMetadataProvider {

    private final int entityId;
    private final Class<? extends EntityDataKeys> dataKeysClass;
    private volatile boolean notifyAboutChanges = true;

    private final Map<EntityDataKey<?>, Object> metadata = new ConcurrentHashMap<>();
    private final Set<EntityDataKey<?>> dirtyKeys = Collections.synchronizedSet(new HashSet<>());

    public WrapperEntityData(int entityId, Class<? extends EntityDataKeys> dataKeysClass) {
        if (dataKeysClass == null) throw new IllegalArgumentException("DataKeys class cannot be null");
        this.entityId = entityId;
        this.dataKeysClass = dataKeysClass;
    }

    /**
     * Copies this metadata state into another instance.
     */
    public void copyTo(WrapperEntityData other) {
        other.clear();
        other.metadata.putAll(this.metadata);
        other.dirtyKeys.addAll(this.dirtyKeys);
    }

    /**
     * Copies metadata from another instance into this one.
     */
    public void copyFrom(WrapperEntityData other) {
        other.copyTo(this);
    }

    /**
     * Removes all stored metadata and pending changes.
     */
    public void clear() {
        this.metadata.clear();
        this.dirtyKeys.clear();
    }

    /**
     * Sets a metadata value for the current server version.
     *
     * @param key the metadata key
     * @param value the value to store
     * @throws IllegalStateException if the current server version is not supported by the key
     */
    public <T> void set(@NotNull EntityDataKey<T> key, T value) {
        this.metadata.put(key, value);

        if (this.notifyAboutChanges) {
            this.dirtyKeys.add(key);
        }
    }

    /**
     * Returns the current logical value for a metadata key.
     * Mappings are done using the server version.
     * @param key key the metadata key
     * @return the stored value, or {@code null} if the key is not present
     */
    @SuppressWarnings("unchecked")
    public <T> @Nullable T get(@NotNull EntityDataKey<T> key) {
        return (T) this.metadata.get(key);
    }

    /**
     * Loads metadata from an incoming entity metadata packet.
     *
     * @param wrapper the received packet
     */
    public void setMetaFromPacket(WrapperPlayServerEntityMetadata wrapper) {
        ClientVersion serverVersion = EntityLib.getApi().getPacketEvents().getServerManager().getVersion().toClientVersion();

        for (EntityData<?> data : wrapper.getEntityMetadata()) {
            EntityDataKey<?> key = EntityDataRegistry.get(this.dataKeysClass, serverVersion, data.getIndex());

            if (key != null) {
                Object logicalValue = key.parse(serverVersion, data);
                if (logicalValue != null) {
                    this.metadata.put(key, logicalValue);
                }
            }
        }
    }

    /**
     * Enables or disables automatic change notifications for calls to {@link #set(EntityDataKey, Object)}.
     *
     * @param notifyAboutChanges whether changes should be queued for broadcast
     */
    public void setNotifyAboutChanges(boolean notifyAboutChanges) {
        if (this.notifyAboutChanges == notifyAboutChanges) return;

        this.notifyAboutChanges = notifyAboutChanges;
        if (notifyAboutChanges && !this.dirtyKeys.isEmpty()) {
            flushChanges();
        }
    }

    /**
     * Resolves all stored metadata into PacketEvents entries for the given client version.
     *
     * @param version the target version
     * @return the resolved metadata entries, sorted by index
     */
    @Override
    public @NotNull List<EntityData<?>> entityData(@NotNull ClientVersion version) {
        List<EntityData<?>> resolvedData = new ArrayList<>();

        for (Map.Entry<EntityDataKey<?>, Object> entry : this.metadata.entrySet()) {
            EntityDataKey<?> key = entry.getKey();
            EntityData<?> data = key.createData(version, cast(entry.getValue()));
            if (data != null) {
                resolvedData.add(data);
            }
        }

        resolvedData.sort(Comparator.comparingInt(EntityData::getIndex));
        return resolvedData;
    }

    @SuppressWarnings("unchecked")
    private <T> T cast(Object value) {
        return (T) value;
    }

    /**
     * Sends all pending metadata changes to the entity's viewers.
     */
    private void flushChanges() {
        final WrapperEntity entity = EntityLib.getApi().getEntity(this.entityId);
        if (entity == null || !entity.isSpawned()) {
            this.dirtyKeys.clear();
            return;
        }

        Set<EntityDataKey<?>> pending;
        synchronized (this.dirtyKeys) {
            pending = new HashSet<>(this.dirtyKeys);
            this.dirtyKeys.clear();
        }

        ClientVersion serverVersion = EntityLib.getApi().getPacketEvents().getServerManager().getVersion().toClientVersion();
        List<EntityData<?>> entries = new ArrayList<>();

        for (EntityDataKey<?> key : pending) {
            Object value = this.metadata.get(key);
            if (value != null) {
                EntityData<?> data = key.createData(serverVersion, cast(value));
                if (data != null) {
                    entries.add(data);
                }
            }
        }

        if (!entries.isEmpty()) {
            WrapperPlayServerEntityMetadata packet = new WrapperPlayServerEntityMetadata(this.entityId, entries);
            entity.sendPacketsToViewers(packet);
        }
    }

    /**
     * Returns whether calls to {@link #set(EntityDataKey, Object)} are queued for broadcast.
     */
    public boolean isNotifyingChanges() {
        return this.notifyAboutChanges;
    }

    /**
     * Starts a batch update for multiple metadata changes.
     */
    public BatchApplier batch() {
        return new BatchApplier();
    }

    /**
     * Groups multiple metadata updates and applies them together.
     */
    public class BatchApplier {
        private final Map<EntityDataKey<?>, Object> pendingChanges = new HashMap<>();

        private BatchApplier() {
        }

        /**
         * Adds a metadata value to the batch.
         *
         * @param key the metadata key
         * @param value the value to store
         */
        public <T> BatchApplier set(@NotNull EntityDataKey<T> key, T value) {
            this.pendingChanges.put(key, value);
            return this;
        }

        /**
         * Applies the collected changes to the metadata store and marks them as dirty.
         */
        public void apply() {
            if (this.pendingChanges.isEmpty()) return;

            WrapperEntityData.this.metadata.putAll(this.pendingChanges);

            if (WrapperEntityData.this.notifyAboutChanges) {
                WrapperEntityData.this.dirtyKeys.addAll(this.pendingChanges.keySet());
            }
        }
    }

}
