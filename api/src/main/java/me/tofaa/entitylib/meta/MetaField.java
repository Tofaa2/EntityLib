package me.tofaa.entitylib.meta;

import com.github.retrooper.packetevents.protocol.entity.data.EntityData;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class MetaField<T> {

    private final String owner;
    private final String name;
    private final MetaBinding<T, ?>[] bindings;
    private final Map<String, MetaFlag> flags;

    @SuppressWarnings("unchecked")
    private MetaField(String owner, String name, List<MetaBinding<T, ?>> bindings) {
        this.owner = owner;
        this.name = name;
        this.bindings = bindings.toArray(new MetaBinding[0]);
        this.flags = new LinkedHashMap<>();
    }

    public @NotNull String owner() {
        return owner;
    }

    public @NotNull String name() {
        return name;
    }

    public @Nullable MetaBinding<T, ?> resolve(int protocolVersion) {
        for (MetaBinding<T, ?> binding : bindings) {
            if (binding.matches(protocolVersion)) {
                return binding;
            }
        }
        return null;
    }

    public boolean existsIn(int protocolVersion) {
        return resolve(protocolVersion) != null;
    }

    public @NotNull List<MetaBinding<T, ?>> bindings() {
        return Collections.unmodifiableList(java.util.Arrays.asList(bindings));
    }

    public @Nullable EntityData<?> encode(T value, int protocolVersion) {
        MetaBinding<T, ?> binding = resolve(protocolVersion);
        return binding == null ? null : binding.encode(value, protocolVersion);
    }

    public @NotNull MetaFlag flag(@NotNull String flagName) {
        MetaFlag flag = flags.get(flagName);
        if (flag == null) {
            throw new IllegalArgumentException("Unknown flag " + flagName + " on " + this);
        }
        return flag;
    }

    public @NotNull Collection<MetaFlag> flags() {
        return Collections.unmodifiableCollection(flags.values());
    }

    @Override
    public String toString() {
        return owner + "." + name;
    }

    public static <T> @NotNull Builder<T> builder(@NotNull String owner, @NotNull String name) {
        return new Builder<>(owner, name);
    }

    public static final class Builder<T> {
        private final String owner;
        private final String name;
        private final List<MetaBinding<T, ?>> bindings = new ArrayList<>();
        private final List<Object[]> flags = new ArrayList<>();

        Builder(String owner, String name) {
            this.owner = owner;
            this.name = name;
        }

        public @NotNull Builder<T> bind(int fromProtocol, int toProtocol, int index, @NotNull EntityDataType<T> wireType) {
            return bind(fromProtocol, toProtocol, index, wireType, MetaConverter.<T>identity());
        }

        public <W> @NotNull Builder<T> bind(int fromProtocol, int toProtocol, int index,
                                            @NotNull EntityDataType<W> wireType, @NotNull MetaConverter<T, W> converter) {
            if (fromProtocol >= toProtocol) {
                throw new IllegalArgumentException("Empty protocol range for " + owner + "." + name);
            }
            for (MetaBinding<T, ?> other : bindings) {
                if (fromProtocol < other.toProtocol() && other.fromProtocol() < toProtocol) {
                    throw new IllegalArgumentException("Overlapping protocol ranges for " + owner + "." + name);
                }
            }
            bindings.add(new MetaBinding<>(fromProtocol, toProtocol, index, wireType, converter));
            return this;
        }

        public @NotNull Builder<T> flag(@NotNull String flagName, int fromProtocol, int toProtocol, int mask) {
            flags.add(new Object[]{flagName, fromProtocol, toProtocol, mask});
            return this;
        }

        @SuppressWarnings("unchecked")
        public @NotNull MetaField<T> build() {
            bindings.sort((a, b) -> Integer.compare(a.fromProtocol(), b.fromProtocol()));
            MetaField<T> field = new MetaField<>(owner, name, bindings);
            for (Object[] flag : flags) {
                field.flags.computeIfAbsent((String) flag[0], n -> new MetaFlag((MetaField<Byte>) field, n))
                        .addRange((Integer) flag[1], (Integer) flag[2], (Integer) flag[3]);
            }
            return field;
        }
    }
}
