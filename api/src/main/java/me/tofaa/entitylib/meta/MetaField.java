package me.tofaa.entitylib.meta;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public final class MetaField<T> {

    private final String name;
    private final T defaultValue;
    private final List<VersionMapping<T>> mappings;
    private final int hash;

    private MetaField(String name, T defaultValue, List<VersionMapping<T>> mappings) {
        this.name = name;
        this.defaultValue = defaultValue;
        this.mappings = List.copyOf(mappings);
        this.hash = Objects.hash(name, mappings);
    }

    public @NotNull String name() {
        return name;
    }

    public @Nullable T defaultValue() {
        return defaultValue;
    }

    @SuppressWarnings("rawtypes")
    public @NotNull VersionedField<?> forVersion(int protocolVersion) {
        for (VersionMapping<T> mapping : mappings) {
            if (protocolVersion >= mapping.minProtocol && protocolVersion <= mapping.maxProtocol) {
                return mapping.resolved;
            }
        }
        return mappings.get(mappings.size() - 1).resolved;
    }

    @SuppressWarnings("rawtypes")
    public @Nullable VersionedField<?> forVersionOrNull(int protocolVersion) {
        for (VersionMapping<T> mapping : mappings) {
            if (protocolVersion >= mapping.minProtocol && protocolVersion <= mapping.maxProtocol) {
                return mapping.resolved;
            }
        }
        return null;
    }

    @SuppressWarnings("rawtypes")
    public @NotNull VersionedField<?> forVersion(int protocolVersion, @NotNull VersionedField<?> fallback) {
        for (VersionMapping<T> mapping : mappings) {
            if (protocolVersion >= mapping.minProtocol && protocolVersion <= mapping.maxProtocol) {
                return mapping.resolved;
            }
        }
        return fallback;
    }

    public static <T> @NotNull Builder<T> builder(@NotNull String name) {
        return new Builder<>(name);
    }

    public static @NotNull Builder<Byte> byteBuilder(@NotNull String name) {
        return new Builder<>(name);
    }

    public static @NotNull Builder<Integer> intBuilder(@NotNull String name) {
        return new Builder<>(name);
    }

    public static @NotNull Builder<Boolean> booleanBuilder(@NotNull String name) {
        return new Builder<>(name);
    }

    public static @NotNull Builder<Float> floatBuilder(@NotNull String name) {
        return new Builder<>(name);
    }

    public static @NotNull Builder<String> stringBuilder(@NotNull String name) {
        return new Builder<>(name);
    }

    public static @NotNull Builder<Long> longBuilder(@NotNull String name) {
        return new Builder<>(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MetaField<?> metaField)) return false;
        return name.equals(metaField.name) && mappings.equals(metaField.mappings);
    }

    @Override
    public int hashCode() {
        return hash;
    }

    @Override
    public String toString() {
        return "MetaField{name='" + name + "', mappings=" + mappings + "}";
    }

    record VersionMapping<T>(int minProtocol, int maxProtocol, VersionedField<T> resolved) {}

    public static final class Builder<T> {

        private final String name;
        private T defaultValue;
        private final List<VersionMapping<T>> mappings = new ArrayList<>();

        Builder(String name) {
            this.name = name;
        }

        public @NotNull Builder<T> defaultValue(@Nullable T defaultValue) {
            this.defaultValue = defaultValue;
            return this;
        }

        @SuppressWarnings("unchecked")
        public @NotNull Builder<T> versionRange(
                int minProtocol,
                int maxProtocol,
                int index,
                @NotNull EntityDataType<?> wireType
        ) {
            VersionedField<T> resolved = new VersionedField<>(index, (EntityDataType<T>) wireType);
            mappings.add(new VersionMapping<>(minProtocol, maxProtocol, resolved));
            return this;
        }

        public @NotNull MetaField<T> build() {
            mappings.sort(Comparator.comparingInt(a -> a.minProtocol));
            return new MetaField<>(name, defaultValue, List.copyOf(mappings));
        }
    }
}
