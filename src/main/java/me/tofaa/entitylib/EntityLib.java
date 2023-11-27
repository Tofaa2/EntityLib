package me.tofaa.entitylib;

import com.github.retrooper.packetevents.PacketEventsAPI;
import com.github.retrooper.packetevents.event.PacketListenerAbstract;
import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.protocol.packettype.PacketType;
import com.github.retrooper.packetevents.protocol.packettype.PacketTypeCommon;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import com.github.retrooper.packetevents.wrapper.play.client.WrapperPlayClientInteractEntity;
import me.tofaa.entitylib.entity.EntityInteractionProcessor;
import me.tofaa.entitylib.entity.WrapperEntity;
import me.tofaa.entitylib.meta.EntityMeta;
import me.tofaa.entitylib.meta.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;

public final class EntityLib {

    private EntityLib() {}
    private static final HashMap<Integer, EntityMeta> metadata = new HashMap<>();
    private static final Map<UUID, WrapperEntity> entities = new ConcurrentHashMap<>();
    private static final Map<Integer, WrapperEntity> entitiesById = new ConcurrentHashMap<>();
    private static EntityInteractionProcessor interactionProcessor;
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

    public static void enableEntityInteractions() {
        checkInit();
        packetEvents.getEventManager().registerListener(new PacketListenerAbstract() {
            @Override
            public void onPacketReceive(PacketReceiveEvent event) {
                if (interactionProcessor == null) return;
                if (event.getPacketType() != PacketType.Play.Client.INTERACT_ENTITY) return;
                WrapperPlayClientInteractEntity packet = new WrapperPlayClientInteractEntity(event);
                WrapperEntity entity = getEntity(packet.getEntityId());
                if (entity == null) return;
                interactionProcessor.process(
                        entity, packet.getAction(), packet.getHand(), event.getUser()
                );
            }
        });
    }

    public static @Nullable WrapperEntity getEntity(int entityId) {
        checkInit();
        return entitiesById.get(entityId);
    }

    public static @Nullable WrapperEntity getEntity(UUID uuid) {
        checkInit();
        return entities.get(uuid);
    }

    public static @Nullable WrapperEntity createEntity(UUID uuid, EntityType entityType) {
        checkInit();
        int id = WrapperEntity.ID_PROVIDER.provide();
        EntityMeta meta = createMeta(id, entityType);
        if (meta == null) return null;
        WrapperEntity entity = new WrapperEntity(uuid, entityType, meta);
        entities.put(uuid, entity);
        entitiesById.put(id, entity);
        return entity;
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

    public static EntityMeta createMeta(WrapperEntity entity) {
        return createMeta(entity.getEntityId(), entity.getEntityType());
    }

    public static <T extends EntityMeta> Class<T> getMetaClassOf(EntityType entityType) {
        return metaRegistry.getMetaClass(entityType);
    }

    public static PacketEventsAPI<?> getPacketEvents() {
        checkInit();
        return packetEvents;
    }

    public static void sendPacket(UUID user, PacketWrapper<?> wrapper) {
        checkInit();
        packetEvents.getProtocolManager().sendPacket(packetEvents.getProtocolManager().getChannel(user), wrapper);
    }

    public static @Nullable EntityInteractionProcessor getInteractionProcessor() {
        return interactionProcessor;
    }

    public static void setInteractionProcessor(EntityInteractionProcessor interactionProcessor) {
        EntityLib.interactionProcessor = interactionProcessor;
    }

    private static void checkInit() {
        if (!initialized) {
            throw new IllegalStateException("EntityLib is not initialized");
        }
    }
}
