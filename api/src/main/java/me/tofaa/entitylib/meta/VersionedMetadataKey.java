package me.tofaa.entitylib.meta;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataType;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class VersionedMetadataKey<T> {

    private final NavigableMap<ClientVersion, MetadataKey<T>> versions = new TreeMap<>();

    public void add(ClientVersion version, MetadataKey<T> key) {
        versions.put(version, key);
    }

    /**
     * Retrieves the correct MetadataKey for the specified ClientVersion.
     * If the exact version is not mapped, it falls back to the nearest older version.
     */
    public MetadataKey<T> forVersion(ClientVersion version) {
        Map.Entry<ClientVersion, MetadataKey<T>> entry = versions.floorEntry(version);
        return entry != null ? entry.getValue() : null;
    }

    public static <T> Builder<T> builder() {
        return new Builder<>();
    }

    public static class Builder<T> {
        private final VersionedMetadataKey<T> key = new VersionedMetadataKey<>();

        public Builder<T> add(ClientVersion version, int index, EntityDataType<T> type) {
            key.add(version, new MetadataKey<>(index, type));
            return this;
        }

        public VersionedMetadataKey<T> build() {
            return key;
        }
    }
}