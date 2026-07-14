package me.tofaa.entitylib.meta;

import com.github.retrooper.packetevents.protocol.entity.data.EntityData;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public final class EntityMetadata {

    private final int entityId;
    private final Map<MetaField<?>, Object> values;

    EntityMetadata(int entityId, Map<MetaField<?>, Object> values) {
        this.entityId = entityId;
        this.values = values;
    }

    public int entityId() {
        return entityId;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public @NotNull WrapperPlayServerEntityMetadata createPacket(int protocolVersion) {
        return createPacket(protocolVersion, false);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public @NotNull WrapperPlayServerEntityMetadata createPacket(int protocolVersion, boolean strict) {
        List<EntityData<?>> entries = new ArrayList<>();
        for (Map.Entry<MetaField<?>, Object> entry : values.entrySet()) {
            MetaField field = entry.getKey();
            Object value = entry.getValue();
            VersionedField resolved = strict ? field.forVersionOrNull(protocolVersion) : field.forVersion(protocolVersion);
            if (resolved == null) continue;
            entries.add(new EntityData((byte) resolved.index(), resolved.wireType(), value));
        }
        return new WrapperPlayServerEntityMetadata(entityId, entries);
    }

    public static @NotNull Builder builder(int entityId) {
        return new Builder(entityId);
    }

    public static final class Builder {

        private final int entityId;
        private final Map<MetaField<?>, Object> values = new LinkedHashMap<>();

        Builder(int entityId) {
            this.entityId = entityId;
        }

        @SuppressWarnings("unchecked")
        public <T> @NotNull Builder with(@NotNull MetaField<T> field, @Nullable T value) {
            values.put(field, value);
            return this;
        }

        public @NotNull EntityMetadata build() {
            return new EntityMetadata(entityId, new LinkedHashMap<>(values));
        }
    }
}
