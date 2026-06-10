package me.tofaa.entitylib.meta.property;

import com.github.retrooper.packetevents.protocol.entity.data.EntityData;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataType;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.MetaPropertiesRegistry;
import me.tofaa.entitylib.meta.EntityMetadata;
import me.tofaa.entitylib.meta.wrapper.WrapperMetadataValue;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.function.Function;

public abstract class MetadataProperty<R, W> {

    private final Class<? extends IMetaProperties> metaPropertiesClass;
    private final NavigableMap<ClientVersion, VersionedMapping<R, ?>> versions;

    @SuppressWarnings("unchecked")
    protected MetadataProperty(Class<? extends IMetaProperties> metaPropertiesClass, NavigableMap<ClientVersion, ? extends VersionedMapping<R, ?>> versions) {
        this.metaPropertiesClass = metaPropertiesClass;
        this.versions = (NavigableMap<ClientVersion, VersionedMapping<R, ?>>) versions;
    }

    /**
     * Returns the target entity class this property is registered to.
     */
    public Class<? extends IMetaProperties> getMetaPropertiesClass() {
        return this.metaPropertiesClass;
    }

    /**
     * Returns the metadata index for the given client version.
     *
     * @param version the client version to resolve
     * @return the metadata index, or {@code -1} if no mapping exists
     */
    public int getIndex(ClientVersion version) {
        Map.Entry<ClientVersion, VersionedMapping<R, ?>> entry = this.versions.floorEntry(version);
        return entry != null ? entry.getValue().index : -1;
    }

    /**
     * Converts a PacketEvents metadata value back into the logical value used by the plugin.
     *
     * @param version the version the metadata was received for
     * @param data the raw metadata entry
     * @return the converted value, or {@code null} if the version is unsupported or parsing fails
     */
    public R parse(ClientVersion version, EntityData<?> data) {
        if (data == null) return null;
        Map.Entry<ClientVersion, VersionedMapping<R, ?>> entry = this.versions.floorEntry(version);
        if (entry == null) return null;
        return entry.getValue().deserialize(data.getValue());
    }

    /**
     * Converts a logical value into a PacketEvents metadata entry for the given client version.
     *
     * @param version the target client version
     * @param rawValue the value to serialize
     * @return the serialized metadata entry, or {@code null} if the version is unsupported
     */
    public EntityData<?> createData(ClientVersion version, R rawValue) {
        Map.Entry<ClientVersion, VersionedMapping<R, ?>> entry = this.versions.floorEntry(version);
        if (entry == null) return null;
        return entry.getValue().createData(rawValue);
    }

    public abstract boolean isWrapper();

    /**
     * Creates a builder for defining version-specific mappings.
     * @param entityClass the wrapper class this property belongs to
     */
    public static <R> Builder<R> builder(Class<? extends IMetaProperties> entityClass) {
        return new Builder<>(entityClass);
    }

    public static class Builder<R> {
        protected final Class<? extends IMetaProperties> metaPropertiesClass;
        protected final NavigableMap<ClientVersion, VersionedMapping<R, ?>> versions = new TreeMap<>();

        public Builder(Class<? extends IMetaProperties> metaPropertiesClass) {
            this.metaPropertiesClass = metaPropertiesClass;
        }

        public Builder<R> addVersion(ClientVersion version, int index, EntityDataType<R> type) {
            this.versions.put(version, new VersionedMapping<>(index, type, Function.identity(), Function.identity()));
            return this;
        }

        public <N> Builder<R> addVersion(ClientVersion version, int index, EntityDataType<N> type, Function<R, N> serializer, Function<N, R> deserializer) {
            this.versions.put(version, new VersionedMapping<>(index, type, serializer, deserializer));
            return this;
        }

        public SimpleProperty<R> build() {
            SimpleProperty<R> property = new SimpleProperty<>(this.metaPropertiesClass, this.versions);
            MetaPropertiesRegistry.register(property);
            return property;
        }

        public <W extends WrapperMetadataValue<R>> WrapperBuilder<R, W> wrapped(Function<EntityMetadata, W> factory) {
            return new WrapperBuilder<>(this, factory);
        }
    }

    public static class WrapperBuilder<R, W extends WrapperMetadataValue<R>> {
        private final Builder<R> base;
        private final Function<EntityMetadata, W> factory;

        public WrapperBuilder(Builder<R> base, Function<EntityMetadata, W> factory) {
            this.base = base;
            this.factory = factory;
        }

        /**
         * Builds the configured property and registers it to the EntityDataRegistry.
         */
        public WrapperProperty<R, W> build() {
            WrapperProperty<R, W> property = new WrapperProperty<>(this.base.metaPropertiesClass, this.base.versions, this.factory);
            MetaPropertiesRegistry.register(property);
            return property;
        }
    }

    /**
     * Stores the metadata definition for a specific version range.
     *
     * @param <L> the logical (plugin-side) value type
     * @param <W> the wire (network PacketEvents-side) protocol type
     */
    protected static class VersionedMapping<L, W> {
        private final int index;
        private final EntityDataType<W> type;
        private final Function<L, W> serializer;
        private final Function<W, L> deserializer;

        VersionedMapping(int index, EntityDataType<W> type, Function<L, W> serializer, Function<W, L> deserializer) {
            this.index = index;
            this.type = type;
            this.serializer = serializer;
            this.deserializer = deserializer;
        }

        EntityData<W> createData(L logicalValue) {
            return new EntityData<>(this.index, this.type, this.serializer.apply(logicalValue));
        }

        @SuppressWarnings("unchecked")
        L deserialize(Object packetEventsValue) {
            return this.deserializer.apply((W) packetEventsValue);
        }
    }
}