package me.tofaa.entitylib.meta;

import com.github.retrooper.packetevents.protocol.entity.data.EntityData;
import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class Metadata {

    private final Map<MetaField<?>, Object> values = new ConcurrentHashMap<>();
    private final Map<MetaFlag, Boolean> flags = new ConcurrentHashMap<>();

    public Metadata() {
    }

    @SuppressWarnings("unchecked")
    public <T> @Nullable T get(@NotNull MetaField<T> field) {
        return (T) values.get(field);
    }

    public <T> T getOrDefault(@NotNull MetaField<T> field, T defaultValue) {
        T value = get(field);
        return value != null ? value : defaultValue;
    }

    public <T> @NotNull Metadata set(@NotNull MetaField<T> field, @Nullable T value) {
        if (value == null) {
            values.remove(field);
        } else {
            values.put(field, value);
        }
        return this;
    }

    public boolean has(@NotNull MetaField<?> field) {
        return values.containsKey(field);
    }

    public void remove(@NotNull MetaField<?> field) {
        values.remove(field);
        flags.keySet().removeIf(flag -> flag.field() == field);
    }

    public boolean getFlag(@NotNull MetaFlag flag) {
        Boolean explicit = flags.get(flag);
        if (explicit != null) {
            return explicit;
        }
        Byte raw = get(flag.field());
        int mask = flag.mask();
        return raw != null && (raw & mask) == mask;
    }

    public @NotNull Metadata setFlag(@NotNull MetaFlag flag, boolean value) {
        flags.put(flag, value);
        return this;
    }

    public @NotNull Set<MetaField<?>> fields() {
        return Collections.unmodifiableSet(values.keySet());
    }

    public boolean isEmpty() {
        return values.isEmpty() && flags.isEmpty();
    }

    public void clear() {
        values.clear();
        flags.clear();
    }

    public @NotNull Metadata copy() {
        Metadata copy = new Metadata();
        copy.values.putAll(values);
        copy.flags.putAll(flags);
        return copy;
    }

    public @NotNull List<EntityData<?>> encode(int protocolVersion) {
        return encode(protocolVersion, MissingPolicy.SKIP);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public @NotNull List<EntityData<?>> encode(int protocolVersion, @NotNull MissingPolicy missingPolicy) {
        Set<MetaField<?>> fields = new LinkedHashSet<>(values.keySet());
        for (MetaFlag flag : flags.keySet()) {
            fields.add(flag.field());
        }
        List<EntityData<?>> entries = new ArrayList<>(fields.size());
        for (MetaField field : fields) {
            Object value = values.get(field);
            if (!field.flags().isEmpty()) {
                value = applyFlags(field, value, protocolVersion);
            }
            if (value == null) {
                continue;
            }
            EntityData<?> data = field.encode(value, protocolVersion);
            if (data != null) {
                entries.add(data);
            } else if (missingPolicy == MissingPolicy.THROW) {
                throw new MetaVersionException(field, protocolVersion);
            }
        }
        entries.sort((a, b) -> Integer.compare(a.getIndex(), b.getIndex()));
        return entries;
    }

    private Object applyFlags(MetaField<?> field, Object value, int protocolVersion) {
        boolean any = value != null;
        int bits = value instanceof Byte ? (Byte) value : 0;
        for (MetaFlag flag : field.flags()) {
            Boolean set = flags.get(flag);
            if (set == null) {
                continue;
            }
            any = true;
            int mask = flag.maskAt(protocolVersion);
            bits = set ? bits | mask : bits & ~mask;
        }
        return any ? (Object) (byte) bits : null;
    }

    public @NotNull WrapperPlayServerEntityMetadata createPacket(int entityId, int protocolVersion) {
        return createPacket(entityId, protocolVersion, MissingPolicy.SKIP);
    }

    public @NotNull WrapperPlayServerEntityMetadata createPacket(int entityId, int protocolVersion,
                                                                 @NotNull MissingPolicy missingPolicy) {
        return new WrapperPlayServerEntityMetadata(entityId, encode(protocolVersion, missingPolicy));
    }

    public @NotNull Metadata setMetaFromPacket(@NotNull WrapperPlayServerEntityMetadata packet, @NotNull MetaClass metaClass,
                                               int protocolVersion) {
        return decode(metaClass, protocolVersion, packet.getEntityMetadata());
    }

    public @NotNull Metadata setMetaFromPacket(@NotNull WrapperPlayServerEntityMetadata packet, @NotNull EntityType entityType,
                                               int protocolVersion) {
        MetaClass metaClass = MetaFields.metaClass(entityType, protocolVersion);
        if (metaClass != null) {
            decode(metaClass, protocolVersion, packet.getEntityMetadata());
        }
        return this;
    }

    public @NotNull Metadata setMetaFromPacket(@NotNull WrapperPlayServerEntityMetadata packet, @NotNull EntityType entityType) {
        return setMetaFromPacket(packet, entityType, packet.getServerVersion().getProtocolVersion());
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public @NotNull Metadata decode(@NotNull MetaClass metaClass, int protocolVersion, @NotNull List<EntityData<?>> entityData) {
        for (EntityData<?> data : entityData) {
            MetaField field = metaClass.fieldAt(protocolVersion, data.getIndex());
            if (field == null) {
                continue;
            }
            MetaBinding binding = field.resolve(protocolVersion);
            Object value = binding.decode(data.getValue());
            set(field, value);
            if (value instanceof Byte) {
                for (Object flag : field.flags()) {
                    int mask = ((MetaFlag) flag).maskAt(protocolVersion);
                    if (mask != 0) {
                        flags.put((MetaFlag) flag, ((Byte) value & mask) == mask);
                    }
                }
            }
        }
        return this;
    }

    @Override
    public String toString() {
        return "Metadata" + values + (flags.isEmpty() ? "" : flags.toString());
    }
}
