package me.tofaa.entitylib.wrapper;

import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.protocol.player.User;
import com.github.retrooper.packetevents.protocol.world.Location;
import com.github.retrooper.packetevents.util.Vector3d;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import com.github.retrooper.packetevents.wrapper.play.server.*;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.container.EntityContainer;
import me.tofaa.entitylib.meta.EntityMeta;
import me.tofaa.entitylib.meta.types.ObjectData;
import me.tofaa.entitylib.tick.Tickable;
import me.tofaa.entitylib.ve.ViewerRule;
import me.tofaa.entitylib.wrapper.spawning.SpawnPacketProvider;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnmodifiableView;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

public class WrapperEntity implements Tickable {

    private final UUID uuid;
    private final int entityId;
    private EntityType entityType;
    private EntityMeta entityMeta;
    private boolean ticking;
    protected Location location;
    private Location preRidingLocation;
    protected final Set<UUID> viewers;
    private boolean onGround;
    private boolean spawned;
    private Vector3d velocity;
    private int riding = -1;
    private final Set<Integer> passengers;
    private EntityContainer parent;
    private final List<ViewerRule> viewerRules;

    public WrapperEntity(int entityId, UUID uuid, EntityType entityType, EntityMeta entityMeta) {
        this.entityId = entityId;
        this.uuid = uuid;
        this.entityType = entityType;
        this.entityMeta = entityMeta;
        this.ticking = true;
        this.viewers = ConcurrentHashMap.newKeySet();
        this.passengers = ConcurrentHashMap.newKeySet();
        this.location = new Location(0, 0, 0, 0, 0);
        this.viewerRules = new CopyOnWriteArrayList<>();
    }

    public WrapperEntity(int entityId, EntityType entityType) {
        this(entityId, EntityLib.getPlatform().getEntityUuidProvider().provide(entityType), entityType);
    }

    public WrapperEntity(UUID uuid, EntityType entityType) {
        this(EntityLib.getPlatform().getEntityIdProvider().provide(uuid, entityType), uuid, entityType);
    }
    public WrapperEntity(EntityType entityType) {
        this(EntityLib.getPlatform().getEntityUuidProvider().provide(entityType), entityType);
    }

    public WrapperEntity(int entityId, UUID uuid, EntityType entityType) {
        this(entityId, uuid, entityType, EntityMeta.createMeta(entityId, entityType));
    }

    public boolean spawn(Location location, EntityContainer parent) {
        if (spawned) return false;
        this.location = location;
        this.spawned = true;
        sendPacketsToViewers(
                new WrapperPlayServerSpawnEntity(
                        entityId,
                        Optional.of(this.uuid),
                        entityType,
                        location.getPosition(),
                        location.getPitch(),
                        location.getYaw(),
                        location.getYaw(),
                        getObjectData(),
                        createVeloPacket()
                ),
                entityMeta.createPacket()
        );
        if (this instanceof WrapperLivingEntity) {
            sendPacketsToViewers(((WrapperLivingEntity)this).getAttributes().createPacket());
        }
        this.parent = parent;
        parent.addEntity(this);
        return true;
    }

    public PacketWrapper<?> getSpawnPacket(User user) {
        // TODO: Version/EntityType compatibility
        return SpawnPacketProvider.GENERAL.provide(this);
    }

    public boolean spawn(Location location) {
        return spawn(location, EntityLib.getApi().getDefaultContainer());
    }

    @ApiStatus.Internal
    public int getObjectData() {
        if (entityMeta instanceof ObjectData) {
            return ((ObjectData) entityMeta).getObjectData();
        }
        return 0;
    }

    @ApiStatus.Internal
    public Optional<Vector3d> createVeloPacket() {
        Optional<Vector3d> velocity;
        double veloX = 0, veloY = 0, veloZ = 0;
        if (entityMeta instanceof ObjectData) {
            ObjectData od = (ObjectData) entityMeta;
            if (od.requiresVelocityPacketAtSpawn()) {
                final WrapperPlayServerEntityVelocity veloPacket = getVelocityPacket();
                veloX = veloPacket.getVelocity().getX();
                veloY = veloPacket.getVelocity().getY();
                veloZ = veloPacket.getVelocity().getZ();
            }
        }
        if (veloX == 0 && veloY == 0 && veloZ == 0) {
            velocity = Optional.of(Vector3d.zero());
        } else {
            velocity = Optional.of(new Vector3d(veloX, veloY, veloZ));
        }
        return velocity;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void remove() {
        if (parent != null) {
            parent.removeEntity(this, true);
        }
        else {
            despawn();
        }
    }

    public void despawn() {
        if (!spawned) return;
        spawned = false;
        if (this instanceof WrapperPlayer) {
            WrapperPlayer p = (WrapperPlayer) this;
            sendPacketsToViewers(p.tabListRemovePacket());
        }
        sendPacketToViewers(new WrapperPlayServerDestroyEntities(entityId));
    }

    public void teleport(@NotNull Location location, boolean onGround) {
        if (!spawned) {
            return;
        }
        this.location = location;
        this.onGround = onGround;
        sendPacketToViewers(
                new WrapperPlayServerEntityTeleport(
                        entityId,
                        location.getPosition(),
                        location.getYaw(),
                        location.getPitch(),
                        onGround
                )
        );
    }

    public void teleport(@NotNull Location location) {
        teleport(location, onGround);
    }

    /**
     * Adds a viewer to the viewers set. The viewer will receive all packets and be informed of this addition
     * @param uuid the uuid of the user to add
     */
    public void addViewer(UUID uuid) {
        if (!viewers.add(uuid)) {
            return;
        }
        if (location == null) {
            if (EntityLib.getApi().getSettings().isDebugMode()) {
                EntityLib.getPlatform().getLogger().warning("Location is null for entity " + entityId + ". Cannot spawn.");
            }
            return;
        }
        if (spawned) {
            if (this instanceof WrapperPlayer) {
                WrapperPlayer p = (WrapperPlayer) this;
                sendPacket(uuid, p.tabListPacket());
            }
            sendPacket(uuid, createSpawnPacket());
            sendPacket(uuid, entityMeta.createPacket());
            sendPacket(uuid, createPassengerPacket());
            if (this instanceof WrapperLivingEntity) {
                sendPacket(uuid, ((WrapperLivingEntity)this).getAttributes().createPacket());
            }
        }
        if (EntityLib.getApi().getSettings().isDebugMode()) {
            EntityLib.getPlatform().getLogger().info("Added viewer " + uuid + " to entity " + entityId);
        }
    }

    public EntityContainer getParentContainer() {
        return parent;
    }

    public void sendMessageToViewers(Component message) {
        sendPacketToViewers(new WrapperPlayServerSystemChatMessage(false, message));
    }

    public void sendActionbarToViewers(Component message) {
        sendPacketToViewers(new WrapperPlayServerSystemChatMessage(true, message));
    }

    protected WrapperPlayServerSpawnEntity createSpawnPacket() {
        return new WrapperPlayServerSpawnEntity(
                entityId,
                Optional.of(this.uuid),
                entityType,
                location.getPosition(),
                location.getPitch(),
                location.getYaw(),
                location.getYaw(),
                getObjectData(),
                createVeloPacket()
        );
    }

    public void addViewer(User user) {
        addViewer(user.getUUID());
    }

    /**
     * Adds a viewer silently into the viewers set. The viewer will not receive any packets or be informed of this addition
     * @param uuid the uuid of the user to add
     */
    public void addViewerSilently(UUID uuid) {
        viewers.add(uuid);
    }

    /**
     * Adds a viewer silently into the viewers set. The viewer will not receive any packets or be informed of this addition
     * @param user the user to add
     */
    public void addViewerSilently(User user) {
        addViewerSilently(user.getUUID());
    }

    /**
     * Removes a viewer from the viewers set of this entity. The viewer will be informed of this removal and will no longer receive any packets
     * @param uuid the uuid of the user to remove
     */
    public void removeViewer(UUID uuid) {
        if (!viewers.remove(uuid)) {
            return;
        }
        if (this instanceof WrapperPlayer) {
            WrapperPlayer p = (WrapperPlayer) this;
            sendPacket(uuid, p.tabListRemovePacket());
        }
        sendPacket(uuid, new WrapperPlayServerDestroyEntities(entityId));
    }

    /**
     * Removes a viewer from the viewers set of this entity. The viewer will be informed of this removal and will no longer receive any packets
     * @param user the user to remove
     */
    public void removeViewer(User user) {
        removeViewer(user.getUUID());
    }

    /**
     * removes a viewer silently into the viewers set. The viewer will not receive any packets or be informed of this removal
     * @param uuid of the user to remove
     */
    public void removeViewerSilently(UUID uuid) {
        viewers.remove(uuid);
    }

    /**
     * removes a viewer silently into the viewers set. The viewer will not receive any packets or be informed of this removal
     * @param user the user to remove
     */
    public void removeViewerSilently(User user) {
        removeViewerSilently(user.getUUID());
    }

    public boolean isOnGround() {
        return onGround;
    }

    public Vector3d getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector3d velocity) {
        this.velocity = velocity;
        sendPacketToViewers(getVelocityPacket());
    }

    public double getX() {
        return location.getX();
    }

    public double getY() {
        return location.getY();
    }

    public double getZ() {
        return location.getZ();
    }

    public float getYaw() {
        return location.getYaw();
    }

    public float getPitch() {
        return location.getPitch();
    }

    public int getEntityId() {
        return entityId;
    }

    public EntityMeta getEntityMeta() {
        return entityMeta;
    }

    public <T extends EntityMeta> T getEntityMeta(@NotNull Class<T> metaClass) {
        return metaClass.cast(entityMeta);
    }

    public <T extends EntityMeta> void consumeEntityMeta(@NotNull Class<T> metaClass, Consumer<T> consumer) {
        T meta = getEntityMeta(metaClass);
        consumer.accept(meta);
    }

    public void consumeMeta(Consumer<EntityMeta> consumer) {
        consumer.accept(entityMeta);
    }

    public @NotNull UUID getUuid() {
        return uuid;
    }

    public EntityType getEntityType() {
        return entityType;
    }

    /**
     * Returns an unmodifiable set of the passengers of the entity.
     * @return the passengers of the entity
     */
    public Set<Integer> getPassengers() {
        return Collections.unmodifiableSet(passengers);
    }

    public WrapperEntity getRiding() {
        return EntityLib.getApi().getEntity(riding);
    }

    protected WrapperPlayServerSetPassengers createPassengerPacket() {
        if (passengers.isEmpty()) return null;
        return new WrapperPlayServerSetPassengers(entityId, passengers.stream().mapToInt(i -> i).toArray());
    }

    public @UnmodifiableView Collection<ViewerRule> getViewerRules() {
        return Collections.unmodifiableCollection(viewerRules);
    }

    public void addViewerRule(@NotNull ViewerRule rule) {
        this.viewerRules.add(rule);
    }

    public void removeViewerRule(@NotNull ViewerRule rule) {
        this.viewerRules.remove(rule);
    }

    public void removeViewerRule(int index) {
        this.viewerRules.remove(index);
    }

    public void clearViewerRules() {
        this.viewerRules.clear();
    }

    public @Nullable ViewerRule getViewerRule(int index) {
        if (this.viewerRules.size() >= index - 1) return null;
        if (index < 0) return null;
        return viewerRules.get(index);
    }

    public WrapperPlayServerEntityVelocity getVelocityPacket() {
        Vector3d velocity = this.velocity.multiply(8000.0f / 20.0f);
        return new WrapperPlayServerEntityVelocity(entityId, velocity);
    }

    public boolean isSpawned() {
        return spawned;
    }

    @Override
    public boolean isTicking() {
        return ticking;
    }

    @Override
    public void setTicking(boolean ticking) {
        this.ticking = ticking;
    }

    public boolean hasVelocity() {
        if (isOnGround()) {
            // if the entity is on the ground and only "moves" downwards, it does not have a velocity.
            return Double.compare(velocity.x, 0) != 0 || Double.compare(velocity.z, 0) != 0 || velocity.y > 0;
        } else {
            // The entity does not have velocity if the velocity is zero
            return !velocity.equals(Vector3d.zero());
        }
    }

    public void rotateHead(float yaw, float pitch) {
        sendPacketsToViewersIfSpawned(
                new WrapperPlayServerEntityRotation(entityId, yaw, pitch, onGround),
                new WrapperPlayServerEntityHeadLook(entityId, yaw)
        );
        this.location.setYaw(yaw);
        this.location.setPitch(pitch);
    }

    public void rotateHead(Location location) {
        rotateHead(location.getYaw(), location.getPitch());
    }

    public void rotateHead(WrapperEntity entity) {
        rotateHead(entity.getLocation());
    }

    public void refresh() {
        if (!spawned) return;
        sendPacketsToViewers(entityMeta.createPacket(), createPassengerPacket());
    }

    public void sendPacketToViewers(PacketWrapper<?> packet) {
        if (EntityLib.getApi().getSettings().shouldForceBundles()) {
            viewers.forEach(uuid -> {
                sendPacket(uuid, new WrapperPlayServerBundle());
                sendPacket(uuid, packet);
                sendPacket(uuid, new WrapperPlayServerBundle());
            });
        }
        else {
            viewers.forEach(uuid -> sendPacket(uuid, packet));
        }
    }

    public void sendPacketsToViewers(PacketWrapper<?>... wrappers) {
        for (PacketWrapper<?> wrapper : wrappers) {
            sendPacketToViewers(wrapper);
        }
    }

    public void sendPacketToViewersIfSpawned(PacketWrapper<?> packet) {
        if (spawned) {
            sendPacketToViewers(packet);
        }
    }

    public void sendPacketsToViewersIfSpawned(PacketWrapper<?>... wrappers) {
        if (spawned) {
            sendPacketsToViewers(wrappers);
        }
    }

    private static void sendPacket(UUID user, PacketWrapper<?> wrapper) {
        if (wrapper == null) return;
        Object channel = EntityLib.getApi().getPacketEvents().getProtocolManager().getChannel(user);
        if (channel == null) {
            if (EntityLib.getApi().getSettings().isDebugMode()) {
                EntityLib.getPlatform().getLogger().warning("Failed to send packet to " + user + " because the channel was null. They may be disconnected/not online.");
            }
            return;
        }
        EntityLib.getApi().getPacketEvents().getProtocolManager().sendPacket(channel, wrapper);
    }

    public boolean hasNoGravity() {
        return entityMeta.hasNoGravity();
    }

    public void setHasNoGravity(boolean hasNoGravity) {
        entityMeta.setHasNoGravity(hasNoGravity);
        refresh();
    }

    /**
     * Adds a passenger to the entity. The passenger will be visible to all viewers of the entity.
     * @param passenger the entity id of the passenger
     */
    public void addPassenger(int passenger) {
        if (passengers.contains(passenger)) {
            throw new IllegalArgumentException("Passenger already exists");
        }
        passengers.add(passenger);
        sendPacketToViewers(createPassengerPacket());
        WrapperEntity e = EntityLib.getApi().getEntity(passenger);
        if (e != null) {
            e.riding = this.entityId;
            e.preRidingLocation = e.location;
        }
    }

    public @Nullable Location getPreRidingLocation() {
        return preRidingLocation;
    }

    /**
     * @return the entity id of the entity that the entity is riding, -1 if the entity is not riding
     */
    public int getRidingId() {
        return riding;
    }


    /**
     * Adds multiple passengers to the entity. The passengers will be visible to all viewers of the entity.
     * @param passengers the entity ids of the passengers
     */
    public void addPassengers(int... passengers) {
        for (int passenger : passengers) {
            addPassenger(passenger);
        }
    }

    /**
     * Adds a passenger to the entity. The passenger will be visible to all viewers of the entity.
     * @param passenger the wrapper entity passenger
     */
    public void addPassenger(WrapperEntity passenger) {
        addPassenger(passenger.getEntityId());
    }

    /**
     * Adds multiple passengers to the entity. The passengers will be visible to all viewers of the entity.
     * @param passengers the wrapper entity passengers
     */
    public void addPassengers(WrapperEntity... passengers) {
        for (WrapperEntity passenger : passengers) {
            addPassenger(passenger);
        }
    }

    /**
     * Removes a passenger from the entity. The passenger will be removed from the view of all viewers of the entity.
     * @param passenger the entity id of the passenger
     */
    public void removePassenger(int passenger) {
        if (!passengers.contains(passenger)) {
            throw new IllegalArgumentException("Passenger does not exist");
        }
        passengers.remove(passenger);
        sendPacketToViewers(createPassengerPacket());
        WrapperEntity e = EntityLib.getApi().getEntity(passenger);
        if (e != null) {
            e.riding = -1;
            e.teleport(e.preRidingLocation, e.onGround);
        }
    }

    /**
     * @param passenger the entity id of the passenger
     * @return true if the entity has the passenger, false otherwise
     */
    public boolean hasPassenger(int passenger) {
        return passengers.contains(passenger);
    }

    /**
     * @param passenger the passenger wrapper entity
     * @return true if the entity has the passenger, false otherwise
     */
    public boolean hasPassenger(WrapperEntity passenger) {
        return hasPassenger(passenger.getEntityId());
    }

    /**
     * Removes multiple passengers from the entity. The passengers will be removed from the view of all viewers of the entity.
     * @param passengers the entity ids of the passengers
     */
    public void removePassengers(int... passengers) {
        for (int passenger : passengers) {
            removePassenger(passenger);
        }
    }

    /**
     * Removes a passenger from the entity. The passenger will be removed from the view of all viewers of the entity.
     * @param passenger the wrapper entity passenger
     */
    public void removePassenger(WrapperEntity passenger) {
        removePassenger(passenger.getEntityId());
    }

    /**
     * Removes multiple passengers from the entity. The passengers will be removed from the view of all viewers of the entity.
     * @param passengers the wrapper entity passengers
     */
    public void removePassengers(WrapperEntity... passengers) {
        for (WrapperEntity passenger : passengers) {
            removePassenger(passenger);
        }
    }

    /**
     * @return true if the entity has passengers, false otherwise
     */
    public boolean isRiding() {
        return riding != -1;
    }

    public @NotNull Set<UUID> getViewers() {
        return Collections.unmodifiableSet(viewers);
    }

    public boolean hasViewer(UUID uuid) {
        return viewers.contains(uuid);
    }

    public boolean hasViewer(User user) {
        return hasViewer(user.getUUID());
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public void tick(long time) {
        if (isRiding()) {
            WrapperEntity riding = getRiding();
            if (riding != null) {
                Location l = riding.getLocation();
                location = new Location(
                        l.getX(),
                        l.getY() + 1,
                        l.getZ(),
                        l.getYaw(),
                        l.getPitch()
                );
            }
        }
    }
}
