package me.tofaa.entitylib;

import com.github.retrooper.packetevents.PacketEventsAPI;
import com.github.retrooper.packetevents.event.PacketListenerAbstract;
import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import com.github.retrooper.packetevents.manager.server.ServerVersion;
import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.protocol.packettype.PacketType;
import com.github.retrooper.packetevents.protocol.player.InteractionHand;
import com.github.retrooper.packetevents.protocol.player.User;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import com.github.retrooper.packetevents.wrapper.play.client.WrapperPlayClientInteractEntity;
import me.tofaa.entitylib.entity.*;
import me.tofaa.entitylib.exception.InvalidVersionException;
import me.tofaa.entitylib.meta.EntityMeta;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.LivingEntityMeta;
import org.jetbrains.annotations.ApiStatus;
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
    private static EntityIdProvider entityIdProvider = EntityIdProvider.simple();

    /**
     * Initialize EntityLib.
     * <p>
     *     This method should be called after PacketEvents is initialized.
     *     Loads the internal metadata converter registry and sets the library usable
     * </p>
     * @param packetEvents PacketEventsAPI instance
     */
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

    /**
     * Enable entity interactions.
     * <p>
     *     Enables entity interactions to be handled by EntityLib, rather than the developer.
     *     <br>
     *     This will register a PacketEvents listener for {@link PacketType.Play.Client#INTERACT_ENTITY} and call {@link EntityInteractionProcessor#process(WrapperEntity, WrapperPlayClientInteractEntity.InteractAction, InteractionHand, User)}.
     *     <br>
     *     To set the interaction processor, call {@link EntityLib#setInteractionProcessor(EntityInteractionProcessor)}.
     * </p>
     */
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

    /**
     * @param entityId the entity id
     * @return the entity with the given id, or null if an entity with that id does not exist
     */
    public static @Nullable WrapperEntity getEntity(int entityId) {
        checkInit();
        return entitiesById.get(entityId);
    }

    /**
     * Removes the entity completely from EntityLib and the platform.
     * The viewer will no longer be able to see the entity.
     */
    public static boolean removeEntity(int entityId) {
        checkInit();
        WrapperEntity e = entitiesById.get(entityId);
        if (e == null) return false;
        entities.remove(e.getUuid());
        entitiesById.remove(entityId);
        e.remove();
        return true;
    }

    /**
     * Removes the entity completely from EntityLib and the platform.
     * The viewer will no longer be able to see the entity.
     */
    public static boolean removeEntity(WrapperEntity entity) {
        return removeEntity(entity.getEntityId());
    }

    /**
     * @param uuid the entity uuid
     * @return the entity with the given uuid, or null if an entity with that uuid does not exist
     */
    public static @Nullable WrapperEntity getEntity(UUID uuid) {
        checkInit();
        return entities.get(uuid);
    }

    /**
     * Registers a custom entity to EntityLib. This exists to allow developers to extend {@link WrapperEntity} and its subclasses simply and define their own logic.
     * <p>
     *     This method DOES NOT create a new entity, it simply registers the entity to EntityLib.
     *     To construct a {@link WrapperEntity} you need to call {@link EntityLib#createMeta(int, EntityType)} and pass the created metadata to the constructor of the entity.
     *     <br>
     *     This method will throw a RuntimeException if an entity with the given uuid or id already exists.
     *     <br>
     *     The entity is not modified in any way, simply stored internally for it to be accessible thru {@link EntityLib#getEntity(UUID)} and {@link EntityLib#getEntity(int)}.
     *     </p>
     * @param entity the entity to register
     * @return the same entity passed.
     * @param <T> instance of WrapperEntity, used to infer its type.
     */
    public static @NotNull <T extends WrapperEntity> T register(@NotNull T entity) {
        checkInit();
        if (entities.containsKey(entity.getUuid())) throw new RuntimeException("An entity with that uuid already exists");
        if (entitiesById.containsKey(entity.getEntityId())) throw new RuntimeException("An entity with that id already exists");
        entities.put(entity.getUuid(), entity);
        entitiesById.put(entity.getEntityId(), entity);
        return entity;
    }

    /**
     * Creates a new WrapperEntity with the given UUID and EntityType.
     * This method will automatically create a new EntityMeta for the entity and keeps track of it internally.
     * To get the entity, use {@link EntityLib#getEntity(UUID)} or {@link EntityLib#getEntity(int)}.
     * <p>
     * In theoretically impossible cases, this method may return null.
     * @param uuid the entity uuid
     * @param entityType the entity type
     * @return the created entity, or null if the entity could not be created
     */
    public static @NotNull WrapperEntity createEntity(int entityId, UUID uuid, EntityType entityType) {
        checkInit();
        if (entities.containsKey(uuid)) throw new RuntimeException("An entity with that uuid already exists");
        if (entitiesById.containsKey(entityId)) throw new RuntimeException("An entity with that id already exists");
        EntityMeta meta = createMeta(entityId, entityType);
        WrapperEntity entity;
        if (meta instanceof LivingEntityMeta) {
            entity = new WrapperLivingEntity(entityId, uuid, entityType, meta);
        }
        else if (entityType == EntityTypes.EXPERIENCE_ORB) {
            entity = new WrapperExperienceOrbEntity(entityId, uuid, entityType, meta);
        }
        else {
            entity = new WrapperEntity(entityId, uuid, entityType, meta);
        }
        entities.put(uuid, entity);
        entitiesById.put(entityId, entity);
        return entity;
    }

    public static @NotNull WrapperEntity createEntity(@NotNull UUID uuid, EntityType entityType) {
        return createEntity(entityIdProvider.provide(), uuid, entityType);
    }

    public static @NotNull WrapperEntityCreature createEntityCreature(int entityId, @NotNull UUID uuid, @NotNull EntityType entityType) {
        checkInit();
        if (entities.containsKey(uuid)) throw new RuntimeException("An entity with that uuid already exists");
        if (entitiesById.containsKey(entityId)) throw new RuntimeException("An entity with that id already exists");
        EntityMeta meta = createMeta(entityId, entityType);
        if (!(meta instanceof LivingEntityMeta)) {
            throw new RuntimeException("Entity type " + entityType + " is not a living entity, EntityCreature requires a living entity");
        }
        WrapperEntityCreature entity = new WrapperEntityCreature(entityId, uuid, entityType, meta);
        entities.put(uuid, entity);
        entitiesById.put(entityId, entity);
        return entity;
    }

    public static @NotNull WrapperEntityCreature createEntityCreature(@NotNull UUID uuid, @NotNull EntityType entityType) {
        return createEntityCreature(entityIdProvider.provide(), uuid, entityType);
    }

    /**
     * @param entityId the entity id
     * @return the metadata of the entity with the given id. If the entity does not exist, this method will return null.
     */
    public static @Nullable EntityMeta getMeta(int entityId) {
        checkInit();
        return metadata.get(entityId);
    }

    /**
     * @param entityId the entity id
     * @param metaClass the metadata class to cast to
     * @return the metadata of the entity with the given id, cast to the given class. If the entity does not exist, this method will return null.
     * @param <T> the metadata class
     */
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

    /**
     * Creates a new EntityMeta for the given entity id and type, these are stored internally and can be retrieved using {@link EntityLib#getMeta(int)}.
     * @param entityId the entity id
     * @param entityType the entity type
     * @return the created EntityMeta
     */
    public static @NotNull EntityMeta createMeta(int entityId, EntityType entityType) {
        checkInit();
        Metadata m = new Metadata(entityId);
        BiFunction<Integer, Metadata, EntityMeta> function = metaRegistry.get(entityType);
        EntityMeta meta = function.apply(entityId, m);
        metadata.put(entityId, meta);
        return meta;
    }

    /**
     * Creates a new EntityMeta for an entity, these are stored internally and can be retrieved using {@link EntityLib#getMeta(int)}.
     * @param entity the entity
     * @return the created EntityMeta
     */
    public static EntityMeta createMeta(WrapperEntity entity) {
        return createMeta(entity.getEntityId(), entity.getEntityType());
    }

    /**
     * @param entityType the entity type
     * @return the metadata class of the given entity type
     * @param <T> gets the appropriate metadata class for the given entity type
     */
    public static <T extends EntityMeta> Class<T> getMetaClassOf(EntityType entityType) {
        return metaRegistry.getMetaClass(entityType);
    }

    /**
     * @return the packet events api instance that was used to initialize EntityLib
     */
    public static PacketEventsAPI<?> getPacketEvents() {
        checkInit();
        return packetEvents;
    }

    /**
     * @return the specified interaction processor, or null if none is specified
     */
    public static @Nullable EntityInteractionProcessor getInteractionProcessor() {
        return interactionProcessor;
    }

    /**
     * Sets the interaction processor to the given one.
     * @param interactionProcessor the interaction processor
     */
    public static void setInteractionProcessor(EntityInteractionProcessor interactionProcessor) {
        EntityLib.interactionProcessor = interactionProcessor;
    }

    /**
     * @return the entity id provider
     */
    public static EntityIdProvider getEntityIdProvider() {
        return entityIdProvider;
    }

    /**
     * Sets the entity id provider to the given one.
     * @param entityIdProvider the entity id provider. The default implementation can be found at {@link EntityIdProvider#simple()}
     */
    public static void setEntityIdProvider(EntityIdProvider entityIdProvider) {
        EntityLib.entityIdProvider = entityIdProvider;
    }

    /**
     * Another internal method to verify the server version is supported. Safe to use externally as its purpose is simple and to avoid code duplication
     */
    @ApiStatus.Internal
    public static void verifyVersion(ServerVersion supported, String msg) {
        if (packetEvents.getServerManager().getVersion().isOlderThan(supported)) {
            throw new InvalidVersionException(msg);
        }
    }

    /**
     * A primarily internal method to send a packet wrapper to a User from the users UUID. This is useful for methods in {@link WrapperEntity}. Safe to use externally as its purpose is simple and to avoid code duplication
     * @param user the user uuid
     * @param wrapper  the packet wrapper
     */
    @ApiStatus.Internal
    public static void sendPacket(UUID user, PacketWrapper<?> wrapper) {
        checkInit();
        Object channel = packetEvents.getProtocolManager().getChannel(user);
        if (channel == null) {
            System.out.println("EntityLib could not send packet to user " + user);
            return;
        }
        packetEvents.getProtocolManager().sendPacket(channel, wrapper);
    }

    private static void checkInit() {
        if (!initialized) {
            throw new IllegalStateException("EntityLib is not initialized");
        }
    }
}
