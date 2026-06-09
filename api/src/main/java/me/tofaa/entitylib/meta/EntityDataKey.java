package me.tofaa.entitylib.meta;

import com.github.retrooper.packetevents.protocol.entity.data.EntityData;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataType;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.types.EntityDataKeys;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.function.Function;

/**
 * Maps a logical entity metadata value to the protocol-specific index and type used by each
 * supported client version. This key is also multi-version.
 *
 * @param <T> the value type used by the plugin
 */
public class EntityDataKey<T> {

    private final Class<? extends EntityDataKeys> dataKeysClass;
    private final NavigableMap<ClientVersion, KeyDefinition<T, ?>> versions = new TreeMap<>();

    private EntityDataKey(Class<? extends EntityDataKeys> dataKeysClass) {
        this.dataKeysClass = dataKeysClass;
    }

    /**
     * Returns the target entity class this key is registered to.
     */
    public Class<? extends EntityDataKeys> getDataKeysClass() {
        return this.dataKeysClass;
    }

    /**
     * Returns the metadata index for the given client version.
     *
     * @param version the client version to resolve
     * @return the metadata index, or {@code -1} if no mapping exists
     */
    public int getIndex(ClientVersion version) {
        Map.Entry<ClientVersion, KeyDefinition<T, ?>> entry = this.versions.floorEntry(version);
        return entry != null ? entry.getValue().index : -1;
    }

    /**
     * Converts a PacketEvents metadata value back into the logical value used by the plugin.
     *
     * @param version the version the metadata was received for
     * @param data the raw metadata entry
     * @return the converted value, or {@code null} if the version is unsupported or parsing fails
     */
    public T parse(ClientVersion version, EntityData<?> data) {
        if (data == null) return null;
        Map.Entry<ClientVersion, KeyDefinition<T, ?>> entry = this.versions.floorEntry(version);
        if (entry == null) return null;
        return entry.getValue().deserialize(data.getValue());
    }

    /**
     * Converts a logical value into a PacketEvents metadata entry for the given client version.
     *
     * @param version the target client version
     * @param logicalValue the value to serialize
     * @return the serialized metadata entry, or {@code null} if the version is unsupported
     */
    public EntityData<?> createData(ClientVersion version, T logicalValue) {
        Map.Entry<ClientVersion, KeyDefinition<T, ?>> entry = this.versions.floorEntry(version);
        if (entry == null) return null;
        return entry.getValue().createData(logicalValue);
    }

    /**
     * Creates a builder for defining version-specific mappings.
     * * @param entityClass the wrapper class this key belongs to
     */
    public static <T> Builder<T> builder(Class<? extends EntityDataKeys> entityClass) {
        return new Builder<>(entityClass);
    }

    /**
     * Builder used to register metadata mappings for multiple Minecraft versions.
     */
    public static class Builder<T> {

        private final EntityDataKey<T> key;

        public Builder(Class<? extends EntityDataKeys> entityClass) {
            this.key = new EntityDataKey<>(entityClass);
        }

        /**
         * Adds a mapping where the logical value and PacketEvents value are the same type.
         *
         * @param version the minimum version this mapping applies to
         * @param index the metadata index for that version
         * @param type the PacketEvents metadata type
         */
        public Builder<T> addVersion(ClientVersion version, int index, EntityDataType<T> type) {
            this.key.versions.put(version, new KeyDefinition<>(index, type, Function.identity(), Function.identity()));
            return this;
        }

        /**
         * Adds a mapping that converts between the logical type used by the plugin and the
         * underlying PacketEvents type.
         *
         * @param version the minimum version this mapping applies to
         * @param index the metadata index for that version
         * @param type the PacketEvents metadata type
         * @param serializer converts the logical value into the PacketEvents value
         * @param deserializer converts the PacketEvents value back into the logical value
         * @param <N> the PacketEvents value type
         */
        public <N> Builder<T> addMappedVersion(
                ClientVersion version,
                int index,
                EntityDataType<N> type,
                Function<T, N> serializer,
                Function<N, T> deserializer
        ) {
            this.key.versions.put(version, new KeyDefinition<>(index, type, serializer, deserializer));
            return this;
        }

        /**
         * Builds the configured key and registers it to the EntityDataRegistry.
         */
        public EntityDataKey<T> build() {
            EntityDataRegistry.register(this.key);
            return this.key;
        }
    }

    /**
     * Stores the metadata definition for a specific version range.
     */
    private static class KeyDefinition<T, N> {
        private final int index;
        private final EntityDataType<N> type;
        private final Function<T, N> serializer;
        private final Function<N, T> deserializer;

        KeyDefinition(int index, EntityDataType<N> type, Function<T, N> serializer, Function<N, T> deserializer) {
            this.index = index;
            this.type = type;
            this.serializer = serializer;
            this.deserializer = deserializer;
        }

        EntityData<N> createData(T logicalValue) {
            return new EntityData<>(this.index, this.type, serializer.apply(logicalValue));
        }

        @SuppressWarnings("unchecked")
        T deserialize(Object packetEventsValue) {
            return deserializer.apply((N) packetEventsValue);
        }
    }
}