package me.tofaa.entitylib.meta;

import com.github.retrooper.packetevents.protocol.entity.data.EntityData;
import com.github.retrooper.packetevents.protocol.entity.data.EntityMetadataProvider;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityMetadata;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.meta.property.IMetaProperties;
import me.tofaa.entitylib.meta.property.MetadataProperty;
import me.tofaa.entitylib.meta.property.SimpleProperty;
import me.tofaa.entitylib.meta.property.WrapperProperty;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import me.tofaa.entitylib.meta.wrapper.WrapperMetadataValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Stores <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata">entity metadata</a> and resolves it to PacketEvents metadata when needed.
 */
public class EntityMetadata implements EntityMetadataProvider {

    private final int entityId;
    private final Class<? extends IMetaProperties> metaPropertyClass;
    private volatile boolean notifyAboutChanges = true;

    private final Map<MetadataProperty<?, ?>, Object> metadata = new ConcurrentHashMap<>();
    private final Map<MetadataProperty<?, ?>, Object> wrapperCache = new ConcurrentHashMap<>();
    private final Set<MetadataProperty<?, ?>> dirtyProperties = Collections.synchronizedSet(new HashSet<>());

    public EntityMetadata(int entityId, Class<? extends IMetaProperties> metaPropertyClass) {
        if (metaPropertyClass == null) throw new IllegalArgumentException("IMetaProperty class cannot be null");
        this.entityId = entityId;
        this.metaPropertyClass = metaPropertyClass;
    }

    /**
     * Copies this metadata state into another instance.
     */
    public void copyTo(EntityMetadata other) {
        other.clear();
        other.metadata.putAll(this.metadata);
        other.dirtyProperties.addAll(this.dirtyProperties);
    }

    /**
     * Copies metadata from another instance into this one.
     */
    public void copyFrom(EntityMetadata other) {
        other.copyTo(this);
    }

    /**
     * Removes all stored metadata and pending changes.
     */
    public void clear() {
        this.metadata.clear();
        this.dirtyProperties.clear();
    }

    /**
     * Sets a metadata value for a raw data property.
     *
     * @param property the metadata property
     * @param value the value to store
     */
    public <R> void set(@NotNull SimpleProperty<R> property, R value) {
        setRawValue(property, value);
    }

    /**
     * Returns the current logical value for a raw metadata property.
     *
     * @param property the metadata property
     * @return the stored value, or {@code null} if the property is not present
     */
    @SuppressWarnings("unchecked")
    public <R> @Nullable R get(@NotNull SimpleProperty<R> property) {
        return (R) this.metadata.get(property);
    }

    /**
     * Returns the wrapper instance associated with a wrapped metadata property.
     * Clearly acts as a factory/cache operation to avoid side effects in regular getters.
     *
     * @param property the metadata property
     * @return the wrapper instance
     */
    @SuppressWarnings("unchecked")
    public <R, W extends WrapperMetadataValue<R>> @NotNull W get(@NotNull WrapperProperty<R, W> property) {
        return (W) this.wrapperCache.computeIfAbsent(property, k -> property.createWrapper(this));
    }

    @SuppressWarnings("unchecked")
    public <R> @Nullable R getRawValue(@NotNull MetadataProperty<R, ?> property) {
        return (R) this.metadata.get(property);
    }

    public <R> void setRawValue(@NotNull MetadataProperty<R, ?> property, R value) {
        this.metadata.put(property, value);

        if (this.notifyAboutChanges) {
            this.dirtyProperties.add(property);
        }
    }

    /**
     * Loads metadata from an incoming entity metadata packet.
     *
     * @param wrapper the received packet
     */
    public void setMetaFromPacket(WrapperPlayServerEntityMetadata wrapper) {
        ClientVersion serverVersion = EntityLib.getApi().getPacketEvents().getServerManager().getVersion().toClientVersion();

        for (EntityData<?> data : wrapper.getEntityMetadata()) {
            MetadataProperty<?, ?> property = MetaPropertiesRegistry.get(this.metaPropertyClass, serverVersion, data.getIndex());

            if (property != null) {
                Object logicalValue = property.parse(serverVersion, data);
                if (logicalValue != null) {
                    this.metadata.put(property, logicalValue);
                }
            }
        }
    }

    /**
     * Enables or disables automatic change notifications for calls to {@link #set(SimpleProperty, Object)}.
     *
     * @param notifyAboutChanges whether changes should be queued for broadcast
     */
    public void setNotifyAboutChanges(boolean notifyAboutChanges) {
        if (this.notifyAboutChanges == notifyAboutChanges) return;

        this.notifyAboutChanges = notifyAboutChanges;
        if (notifyAboutChanges && !this.dirtyProperties.isEmpty()) {
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

        for (Map.Entry<MetadataProperty<?, ?>, Object> entry : this.metadata.entrySet()) {
            MetadataProperty<?, ?> property = entry.getKey();
            EntityData<?> data = property.createData(version, cast(entry.getValue()));
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
            this.dirtyProperties.clear();
            return;
        }

        Set<MetadataProperty<?, ?>> pending;
        synchronized (this.dirtyProperties) {
            pending = new HashSet<>(this.dirtyProperties);
            this.dirtyProperties.clear();
        }

        ClientVersion serverVersion = EntityLib.getApi().getPacketEvents().getServerManager().getVersion().toClientVersion();
        List<EntityData<?>> entries = new ArrayList<>();

        for (MetadataProperty<?, ?> property : pending) {
            Object value = this.metadata.get(property);
            if (value != null) {
                EntityData<?> data = property.createData(serverVersion, cast(value));
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
     * Returns whether updates are queued for broadcast.
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
        private final Map<MetadataProperty<?, ?>, Object> pendingChanges = new HashMap<>();

        private BatchApplier() {
        }

        /**
         * Adds a metadata value to the batch.
         *
         * @param property the metadata property
         * @param value the value to store
         */
        public <R> BatchApplier set(@NotNull MetadataProperty<R, ?> property, R value) {
            this.pendingChanges.put(property, value);
            return this;
        }

        /**
         * Applies the collected changes to the metadata store and marks them as dirty.
         */
        public void apply() {
            if (this.pendingChanges.isEmpty()) return;

            EntityMetadata.this.metadata.putAll(this.pendingChanges);

            if (EntityMetadata.this.notifyAboutChanges) {
                EntityMetadata.this.dirtyProperties.addAll(this.pendingChanges.keySet());
            }
        }
    }

}
