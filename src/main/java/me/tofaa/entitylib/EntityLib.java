package me.tofaa.entitylib;

import com.github.retrooper.packetevents.PacketEventsAPI;
import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import me.tofaa.entitylib.meta.EntityMeta;
import me.tofaa.entitylib.meta.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.function.BiFunction;

public final class EntityLib {

    private EntityLib() {}
    private static final HashMap<Integer, EntityMeta> metadata = new HashMap<>();
    private static boolean initialized = false;
    private static PacketEventsAPI<?> packetEvents;
    private static MetaConverterRegistry metaRegistry;

    public static void init(@NotNull PacketEventsAPI<?> packetEvents) {
        if (initialized) {
            throw new IllegalStateException("EntityLib is already initialized");
        }
        initialized = true;
        EntityLib.packetEvents = packetEvents;
        if (!packetEvents.isInitialized()) {
            initialized = false;
            throw new IllegalStateException("PacketEvents is not initialized");
        }
        metaRegistry = new MetaConverterRegistry();
    }


    public static @Nullable EntityMeta getMeta(int entityId) {
        checkInit();
        return metadata.get(entityId);
    }

    public static <T extends EntityMeta> @Nullable T getMeta(int entityId, Class<T> metaClass) {
        checkInit();
        EntityMeta meta = metadata.get(entityId);
        if (meta == null) {
            return null;
        }
        if (metaClass.isAssignableFrom(meta.getClass())) {
            return (T) meta;
        }
        return null;
    }

    public static EntityMeta createMeta(int entityId, EntityType entityType) {
        checkInit();
        Metadata m = new Metadata(entityId);
        BiFunction<Integer, Metadata, EntityMeta> function = metaRegistry.get(entityType);
        if (function == null) {
            throw new IllegalArgumentException("No meta converter for entity type " + entityType);
        }
        EntityMeta meta =  function.apply(entityId, m);
        metadata.put(entityId, meta);
        return meta;
    }

    public static PacketEventsAPI<?> getPacketEvents() {
        checkInit();
        return packetEvents;
    }

    private static void checkInit() {
        if (!initialized) {
            throw new IllegalStateException("EntityLib is not initialized");
        }
    }
}
