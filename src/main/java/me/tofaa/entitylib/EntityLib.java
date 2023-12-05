package me.tofaa.entitylib;

import com.github.retrooper.packetevents.PacketEventsAPI;
import com.github.retrooper.packetevents.event.PacketListenerAbstract;
import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import com.github.retrooper.packetevents.manager.server.ServerVersion;
import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.protocol.packettype.PacketType;
import com.github.retrooper.packetevents.protocol.packettype.PacketTypeCommon;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import com.github.retrooper.packetevents.wrapper.play.client.WrapperPlayClientInteractEntity;
import me.tofaa.entitylib.entity.EntityInteractionProcessor;
import me.tofaa.entitylib.entity.WrapperEntity;
import me.tofaa.entitylib.entity.WrapperLivingEntity;
import me.tofaa.entitylib.exception.InvalidVersionException;
import me.tofaa.entitylib.meta.EntityMeta;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.LivingEntityMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;

/**
 * Base API class for EntityLib, contains all the methods to interact with the library.
 * <p>
 *     Initialization should be done before PacketEvents. After PE is initialized, call {@link EntityLib#init(PacketEventsAPI)} to initialize EntityLib.
 *     <br>
 *     To enable entity interactions, call {@link EntityLib#enableEntityInteractions()}. these will help you interact with a {@link WrapperEntity} object.
 *     <br>
 *     By default, EntityLib does not persistently store data, this is planned for a future feature but for now you must store your own data if you want it to persist after restart.
 * <p>
 */
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
        WrapperEntity entity;
        if (meta instanceof LivingEntityMeta) {
            entity = new WrapperLivingEntity(uuid, entityType, meta);
        }
        else {
            entity = new WrapperEntity(uuid, entityType, meta);
        }
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

    public static void verifyVersion(ServerVersion supported, String msg) {
        if (packetEvents.getServerManager().getVersion().isOlderThan(supported)) {
            throw new InvalidVersionException(msg);
        }
    }

    private static void checkInit() {
        if (!initialized) {
            throw new IllegalStateException("EntityLib is not initialized");
        }
    }
}
