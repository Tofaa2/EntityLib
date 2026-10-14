package me.tofaa.entitylib.wrapper;

import com.github.retrooper.packetevents.protocol.entity.data.EntityData;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.protocol.world.Direction;
import com.github.retrooper.packetevents.protocol.world.Location;
import com.github.retrooper.packetevents.util.Vector3d;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import com.github.retrooper.packetevents.wrapper.play.server.*;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.event.EntityLibEvent;
import me.tofaa.entitylib.event.EventNode;
import me.tofaa.entitylib.event.entity.EntityRemoveEvent;
import me.tofaa.entitylib.event.entity.EntitySpawnEvent;
import me.tofaa.entitylib.event.entity.EntityViewerAddEvent;
import me.tofaa.entitylib.event.entity.EntityViewerRemoveEvent;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.MissingPolicy;
import me.tofaa.entitylib.meta.MetaField;
import me.tofaa.entitylib.meta.MetaFields;
import me.tofaa.entitylib.meta.MetaFlag;
import me.tofaa.entitylib.meta.MetaOwnershipException;
import me.tofaa.entitylib.meta.OwnershipCheck;
import me.tofaa.entitylib.spawn.SpawnPacketProvider;
import me.tofaa.entitylib.spawn.SpawnPacketProviders;
import me.tofaa.entitylib.utils.PacketBundles;
import me.tofaa.entitylib.ve.ViewerRule;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.translation.GlobalTranslator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

public class WrapperEntity {

    public static final int BUNDLE_PROTOCOL = PacketBundles.BUNDLE_PROTOCOL;
    public static final int NO_LEASH = -1;

    private static final double MAX_RELATIVE_MOVE = 7.9;

    private static final Set<String> OWNERSHIP_WARNINGS = ConcurrentHashMap.newKeySet();

    protected final int entityId;
    protected final UUID uuid;
    protected final EntityType entityType;
    protected final Set<UUID> viewers;
    protected final Metadata metadata;
    protected final List<ViewerRule> viewerRules;
    protected final EntityTriggers triggers;
    protected final Set<Integer> passengers;
    protected final Object lock = new Object();
    private final Map<UUID, Metadata> viewerMetadata = new ConcurrentHashMap<>();
    protected volatile Location location;
    protected volatile boolean spawned;
    protected volatile boolean onGround;
    protected volatile boolean notifyAboutChanges = true;
    protected volatile Vector3d velocity;
    protected volatile int spawnData;
    private volatile WrapperEntity riding;
    private volatile Location preRidingLocation;
    private volatile String world;
    private volatile int leashHolder = NO_LEASH;

    public WrapperEntity(int entityId, @NotNull UUID uuid, @NotNull EntityType entityType, @NotNull Location location) {
        this.entityId = entityId;
        this.uuid = uuid;
        this.entityType = entityType;
        this.location = location;
        this.viewers = ConcurrentHashMap.newKeySet();
        this.viewerRules = new CopyOnWriteArrayList<>();
        this.triggers = new EntityTriggers();
        this.passengers = ConcurrentHashMap.newKeySet();
        this.velocity = new Vector3d();
        this.metadata = new Metadata();
    }

    public WrapperEntity(int entityId, @NotNull UUID uuid, @NotNull EntityType entityType) {
        this(entityId, uuid, entityType, new Location(0, 0, 0, 0, 0));
    }

    public WrapperEntity(@NotNull UUID uuid, @NotNull EntityType entityType) {
        this(EntityLib.get().getPlatform().nextEntityId(), uuid, entityType);
    }

    public WrapperEntity(@NotNull EntityType entityType, @NotNull Location location) {
        this(EntityLib.get().getPlatform().nextEntityId(), UUID.randomUUID(), entityType, location);
    }

    public WrapperEntity(@NotNull EntityType entityType) {
        this(UUID.randomUUID(), entityType);
    }

    public int getEntityId() {
        return entityId;
    }

    public @NotNull UUID getUuid() {
        return uuid;
    }

    public @NotNull EntityType getEntityType() {
        return entityType;
    }

    public @NotNull Location getLocation() {
        return location;
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

    public void setLocation(@NotNull Location location) {
        this.location = location;
        if (spawned) {
            var packet = new WrapperPlayServerEntityTeleport(entityId, location, isOnGround());
            sendPacketToViewers(packet);
        }
    }

    public void setLocationSilently(@NotNull Location location) {
        this.location = location;
    }

    public void teleport(@NotNull Location location, boolean onGround) {
        this.onGround = onGround;
        setLocation(location);
    }

    public void teleport(@NotNull Location location) {
        teleport(location, onGround);
    }

    public void teleport(@NotNull Location location, int interpolationTicks) {
        if (MetaFields.owns(entityType, MetaFields.Display.POS_ROT_INTERPOLATION_DURATION)) {
            setMetadata(MetaFields.Display.POS_ROT_INTERPOLATION_DURATION, interpolationTicks);
        }
        teleport(location, onGround);
    }

    public void move(@NotNull Location target) {
        move(target, onGround);
    }

    public void move(@NotNull Location target, boolean onGround) {
        Location previous = this.location;
        double dx = target.getX() - previous.getX();
        double dy = target.getY() - previous.getY();
        double dz = target.getZ() - previous.getZ();
        if (Math.abs(dx) > MAX_RELATIVE_MOVE || Math.abs(dy) > MAX_RELATIVE_MOVE || Math.abs(dz) > MAX_RELATIVE_MOVE) {
            teleport(target, onGround);
            return;
        }
        this.location = target;
        this.onGround = onGround;
        if (!spawned) {
            return;
        }
        boolean rotated = target.getYaw() != previous.getYaw() || target.getPitch() != previous.getPitch();
        if (rotated) {
            sendPacketsToViewers(
                new WrapperPlayServerEntityRelativeMoveAndRotation(entityId, dx, dy, dz, target.getYaw(), target.getPitch(), onGround),
                new WrapperPlayServerEntityHeadLook(entityId, target.getYaw())
            );
        } else {
            sendPacketToViewers(new WrapperPlayServerEntityRelativeMove(entityId, dx, dy, dz, onGround));
        }
    }

    public void move(@NotNull Vector3d delta) {
        Location current = this.location;
        move(new Location(current.getX() + delta.getX(), current.getY() + delta.getY(), current.getZ() + delta.getZ(),
            current.getYaw(), current.getPitch()));
    }

    public void setHeadYaw(float yaw) {
        sendPacketToViewersIfSpawned(new WrapperPlayServerEntityHeadLook(entityId, yaw));
    }

    public void setBodyRotation(float yaw, float pitch) {
        this.location = new Location(location.getPosition(), yaw, pitch);
        sendPacketToViewersIfSpawned(new WrapperPlayServerEntityRotation(entityId, yaw, pitch, onGround));
    }

    public @Nullable String getWorld() {
        return world;
    }

    public void setWorld(@Nullable String world) {
        this.world = world;
    }

    public void sendStatus(int status) {
        sendPacketToViewersIfSpawned(new WrapperPlayServerEntityStatus(entityId, status));
    }

    public int getLeashHolder() {
        return leashHolder;
    }

    public void setLeashHolder(int holderEntityId) {
        this.leashHolder = holderEntityId;
        sendPacketToViewersIfSpawned(new WrapperPlayServerAttachEntity(entityId, holderEntityId, true));
    }

    public void setLeashHolder(@NotNull WrapperEntity holder) {
        setLeashHolder(holder.getEntityId());
    }

    public void removeLeash() {
        setLeashHolder(NO_LEASH);
    }

    public <T> void setViewerMetadata(@NotNull UUID viewer, @NotNull MetaField<T> field, @Nullable T value) {
        if (!checkOwnership(field)) {
            return;
        }
        Metadata overlay = viewerMetadata.computeIfAbsent(viewer, key -> new Metadata());
        overlay.set(field, value);
        overlay.takeDirty();
        sendFields(viewer, Collections.singleton(field));
    }

    public @Nullable Metadata getViewerMetadata(@NotNull UUID viewer) {
        return viewerMetadata.get(viewer);
    }

    public void clearViewerMetadata(@NotNull UUID viewer) {
        Metadata removed = viewerMetadata.remove(viewer);
        if (removed != null) {
            sendFields(viewer, new ArrayList<>(removed.fields()));
        }
    }

    public @Nullable PacketWrapper<?> createMetadataPacket(@NotNull UUID viewer, @NotNull Collection<MetaField<?>> fields) {
        int proto = EntityLib.get().getPlatform().getProtocolVersion(viewer);
        List<EntityData<?>> entries = encodeFor(viewer, proto, fields);
        if (entries.isEmpty()) {
            return null;
        }
        render(viewer, entries);
        return new WrapperPlayServerEntityMetadata(entityId, entries);
    }

    private void sendFields(UUID viewer, Collection<MetaField<?>> fields) {
        if (!spawned || !viewers.contains(viewer)) {
            return;
        }
        int proto = EntityLib.get().getPlatform().getProtocolVersion(viewer);
        List<EntityData<?>> entries = encodeFor(viewer, proto, fields);
        if (!entries.isEmpty()) {
            render(viewer, entries);
            sendPacket(viewer, new WrapperPlayServerEntityMetadata(entityId, entries));
        }
    }

    private List<EntityData<?>> encodeFor(UUID viewer, int protocolVersion, @Nullable Collection<MetaField<?>> fields) {
        MissingPolicy policy = EntityLib.get().getConfig().isStrictVersionCheck() ? MissingPolicy.THROW : MissingPolicy.SKIP;
        List<EntityData<?>> entries = fields == null
            ? metadata.encode(protocolVersion, policy)
            : metadata.encode(protocolVersion, policy, fields);
        Metadata overlay = viewerMetadata.get(viewer);
        if (overlay == null) {
            return entries;
        }
        List<EntityData<?>> overrides = fields == null
            ? overlay.encode(protocolVersion, policy)
            : overlay.encode(protocolVersion, policy, fields);
        for (EntityData<?> override : overrides) {
            entries.removeIf(entry -> entry.getIndex() == override.getIndex());
            entries.add(override);
        }
        entries.sort((a, b) -> Integer.compare(a.getIndex(), b.getIndex()));
        return entries;
    }

    public void rotateHead(float yaw, float pitch) {
        this.location = new Location(location.getPosition(), yaw, pitch);
        if (spawned) {
            sendPacketsToViewers(
                new WrapperPlayServerEntityRotation(entityId, yaw, pitch, onGround),
                new WrapperPlayServerEntityHeadLook(entityId, yaw)
            );
        }
    }

    public void rotateHead(@NotNull Location location) {
        rotateHead(location.getYaw(), location.getPitch());
    }

    public void rotateHead(@NotNull WrapperEntity entity) {
        rotateHead(entity.getLocation());
    }

    public boolean isSpawned() {
        return spawned;
    }

    public boolean isOnGround() {
        return onGround;
    }

    public void setOnGround(boolean onGround) {
        this.onGround = onGround;
    }

    public @NotNull Vector3d getVelocity() {
        return velocity;
    }

    public void setVelocity(@NotNull Vector3d velocity) {
        this.velocity = velocity;
        if (spawned) {
            sendPacketToViewers(new WrapperPlayServerEntityVelocity(entityId, velocity));
        }
    }

    public boolean hasVelocity() {
        if (isOnGround()) {
            return Double.compare(velocity.x, 0) != 0 || Double.compare(velocity.z, 0) != 0 || velocity.y > 0;
        }
        return !velocity.equals(Vector3d.zero());
    }

    public boolean hasNoGravity() {
        return Boolean.TRUE.equals(metadata.get(MetaFields.Entity.NO_GRAVITY));
    }

    public void setHasNoGravity(boolean hasNoGravity) {
        setMetadata(MetaFields.Entity.NO_GRAVITY, hasNoGravity);
    }

    public int getSpawnData() {
        return spawnData;
    }

    public void setSpawnData(int spawnData) {
        this.spawnData = spawnData;
    }

    public void respawn() {
        if (!spawned) return;
        for (UUID viewer : viewers) {
            sendDespawnPackets(viewer);
            sendSpawnPackets(viewer);
        }
    }

    public @NotNull Direction getDirection() {
        float yaw = location.getYaw();
        if (yaw < 0) yaw += 360;
        if (yaw < 45 || yaw >= 315) return Direction.SOUTH;
        if (yaw < 135) return Direction.WEST;
        if (yaw < 225) return Direction.NORTH;
        return Direction.EAST;
    }

    public @NotNull EntityTriggers getTriggers() {
        return triggers;
    }

    public @NotNull List<ViewerRule> getViewerRules() {
        return viewerRules;
    }

    public void addViewerRule(@NotNull ViewerRule rule) {
        viewerRules.add(rule);
    }

    public void removeViewerRule(@NotNull ViewerRule rule) {
        viewerRules.remove(rule);
    }

    public void clearViewerRules() {
        viewerRules.clear();
    }

    public boolean hasViewer(@NotNull UUID user) {
        return viewers.contains(user);
    }

    public @NotNull Set<UUID> getViewers() {
        return Collections.unmodifiableSet(viewers);
    }

    public boolean addViewer(@NotNull UUID user) {
        if (viewers.contains(user)) {
            return false;
        }
        EventNode<EntityLibEvent> bus = EntityLib.get().getEventNode();
        if (bus.hasListener(EntityViewerAddEvent.class) && bus.call(new EntityViewerAddEvent(this, user)).isCancelled()) {
            return false;
        }
        synchronized (lock) {
            if (!viewers.add(user)) {
                return false;
            }
            EntityLib.get().registerEntity(this);
            if (spawned) {
                sendSpawnPackets(user);
            }
        }
        triggers.fireViewerAdd(user);
        return true;
    }

    public boolean addViewerSilently(@NotNull UUID user) {
        EntityLib.get().registerEntity(this);
        return viewers.add(user);
    }

    public void handleViewerDisconnect(@NotNull UUID user) {
        viewerMetadata.remove(user);
        if (viewers.remove(user)) {
            triggers.fireViewerRemove(user);
            fireViewerRemove(user, true);
        }
    }

    private void fireViewerRemove(UUID user, boolean disconnected) {
        EventNode<EntityLibEvent> bus = EntityLib.get().getEventNode();
        if (bus.hasListener(EntityViewerRemoveEvent.class)) {
            bus.call(new EntityViewerRemoveEvent(this, user, disconnected));
        }
    }

    public boolean removeViewer(@NotNull UUID user) {
        synchronized (lock) {
            if (!viewers.remove(user)) {
                return false;
            }
            if (spawned) {
                sendDespawnPackets(user);
            }
        }
        triggers.fireViewerRemove(user);
        fireViewerRemove(user, false);
        return true;
    }

    public boolean removeViewerSilently(@NotNull UUID user) {
        return viewers.remove(user);
    }

    public void spawn(@NotNull Location location) {
        synchronized (lock) {
            this.location = location;
            this.spawned = true;
            EntityLib.get().registerEntity(this);
            broadcastSpawnPackets();
        }
        triggers.fireSpawn(this);
        EventNode<EntityLibEvent> spawnBus = EntityLib.get().getEventNode();
        if (spawnBus.hasListener(EntitySpawnEvent.class)) {
            spawnBus.call(new EntitySpawnEvent(this));
        }
    }

    public void despawn() {
        synchronized (lock) {
            if (!spawned) return;
            this.spawned = false;
            for (UUID viewer : viewers) {
                sendDespawnPackets(viewer);
            }
        }
    }

    public void remove() {
        despawn();
        viewers.clear();
        viewerMetadata.clear();
        EntityLib.get().unregisterEntity(this);
        triggers.fireRemove(this);
        EventNode<EntityLibEvent> removeBus = EntityLib.get().getEventNode();
        if (removeBus.hasListener(EntityRemoveEvent.class)) {
            removeBus.call(new EntityRemoveEvent(this));
        }
    }

    public void refresh() {
        if (!spawned) return;
        broadcastMetadata();
        if (!passengers.isEmpty()) {
            sendPacketToViewers(createPassengerPacket());
        }
    }

    public <T> void setMetadata(@NotNull MetaField<T> field, @Nullable T value) {
        if (!checkOwnership(field)) {
            return;
        }
        metadata.set(field, value);
        if (notifyAboutChanges) {
            flushMetadata();
        }
    }

    public void setFlag(@NotNull MetaFlag flag, boolean value) {
        if (!checkOwnership(flag.field())) {
            return;
        }
        metadata.setFlag(flag, value);
        if (notifyAboutChanges) {
            flushMetadata();
        }
    }

    public void setMetaFromPacket(@NotNull WrapperPlayServerEntityMetadata packet) {
        setMetaFromPacket(packet, packet.getServerVersion().getProtocolVersion());
    }

    public void setMetaFromPacket(@NotNull WrapperPlayServerEntityMetadata packet, int protocolVersion) {
        metadata.setMetaFromPacket(packet, entityType, protocolVersion);
        if (notifyAboutChanges) {
            flushMetadata();
        }
    }

    private boolean checkOwnership(MetaField<?> field) {
        OwnershipCheck check = EntityLib.get().getConfig().getOwnershipCheck();
        if (check == OwnershipCheck.OFF || MetaFields.owns(entityType, field)) {
            return true;
        }
        if (check == OwnershipCheck.THROW) {
            throw new MetaOwnershipException(field, entityType);
        }
        if (OWNERSHIP_WARNINGS.add(entityType.getName() + ":" + field)) {
            EntityLib.get().getPlatform().getLogger().warning("Metadata field " + field + " does not belong to entity type "
                + entityType.getName() + " and was not set");
        }
        return false;
    }

    public @NotNull Metadata getMetadata() {
        return metadata;
    }

    public @NotNull Set<Integer> getPassengers() {
        return Collections.unmodifiableSet(passengers);
    }

    public boolean hasPassenger(int passenger) {
        return passengers.contains(passenger);
    }

    public boolean hasPassenger(@NotNull WrapperEntity passenger) {
        return hasPassenger(passenger.getEntityId());
    }

    public void addPassenger(int passenger) {
        if (passengers.add(passenger) && spawned) {
            sendPacketToViewers(createPassengerPacket());
        }
    }

    public void addPassenger(@NotNull WrapperEntity passenger) {
        passenger.riding = this;
        passenger.preRidingLocation = passenger.location;
        addPassenger(passenger.getEntityId());
    }

    public void addPassengers(int @NotNull ... passengers) {
        for (int passenger : passengers) {
            addPassenger(passenger);
        }
    }

    public void addPassengers(WrapperEntity @NotNull ... passengers) {
        for (WrapperEntity passenger : passengers) {
            addPassenger(passenger);
        }
    }

    public void removePassenger(int passenger) {
        if (passengers.remove(passenger) && spawned) {
            sendPacketToViewers(createPassengerPacket());
        }
    }

    public void removePassenger(@NotNull WrapperEntity passenger) {
        removePassenger(passenger.getEntityId());
        if (passenger.riding == this) {
            passenger.riding = null;
            if (passenger.preRidingLocation != null) {
                passenger.teleport(passenger.preRidingLocation);
            }
        }
    }

    public void removePassengers(int @NotNull ... passengers) {
        for (int passenger : passengers) {
            removePassenger(passenger);
        }
    }

    public void removePassengers(WrapperEntity @NotNull ... passengers) {
        for (WrapperEntity passenger : passengers) {
            removePassenger(passenger);
        }
    }

    public boolean isRiding() {
        return riding != null;
    }

    public @Nullable WrapperEntity getRiding() {
        return riding;
    }

    public @Nullable Location getPreRidingLocation() {
        return preRidingLocation;
    }

    protected @NotNull WrapperPlayServerSetPassengers createPassengerPacket() {
        return new WrapperPlayServerSetPassengers(entityId, passengers.stream().mapToInt(Integer::intValue).toArray());
    }

    public boolean isNotifyingChanges() {
        return notifyAboutChanges;
    }

    public void setNotifyAboutChanges(boolean notifyAboutChanges) {
        this.notifyAboutChanges = notifyAboutChanges;
        if (notifyAboutChanges) {
            flushMetadata();
        }
    }

    public void consumeMetadata(@NotNull Consumer<Metadata> consumer) {
        consumer.accept(metadata);
        if (notifyAboutChanges) {
            flushMetadata();
        }
    }

    public void flushMetadata() {
        if (!spawned || !metadata.hasDirty()) {
            return;
        }
        Set<MetaField<?>> changed = metadata.takeDirty();
        for (UUID viewer : viewers) {
            int proto = EntityLib.get().getPlatform().getProtocolVersion(viewer);
            List<EntityData<?>> entries = encodeFor(viewer, proto, changed);
            if (entries.isEmpty()) {
                continue;
            }
            render(viewer, entries);
            sendPacket(viewer, new WrapperPlayServerEntityMetadata(entityId, entries));
        }
    }

    protected void broadcastMetadata() {
        metadata.takeDirty();
        for (UUID viewer : viewers) {
            sendMetadata(viewer);
        }
    }

    protected void sendMetadata(@NotNull UUID user) {
        int proto = EntityLib.get().getConfig().getPlatform().getProtocolVersion(user);
        PacketWrapper<?> packet = createMetadataPacket(user, proto);
        if (packet != null) {
            sendPacket(user, packet);
        }
    }

    protected @Nullable PacketWrapper<?> createMetadataPacket(@NotNull UUID user, int protocolVersion) {
        List<EntityData<?>> entries = encodeFor(user, protocolVersion, null);
        if (entries.isEmpty()) {
            return null;
        }
        render(user, entries);
        return new WrapperPlayServerEntityMetadata(entityId, entries);
    }

    @SuppressWarnings("unchecked")
    private void render(UUID user, List<EntityData<?>> entries) {
        Locale locale = null;
        for (EntityData<?> entry : entries) {
            if (entry.getType() == EntityDataTypes.ADV_COMPONENT) {
                if (locale == null) locale = EntityLib.get().getPlatform().getUserLocaleProvider().locale(user);
                EntityData<Component> data = (EntityData<Component>) entry;
                data.setValue(GlobalTranslator.render(data.getValue(), locale));
            } else if (entry.getType() == EntityDataTypes.OPTIONAL_ADV_COMPONENT) {
                EntityData<Optional<Component>> data = (EntityData<Optional<Component>>) entry;
                if (data.getValue().isPresent()) {
                    if (locale == null) locale = EntityLib.get().getPlatform().getUserLocaleProvider().locale(user);
                    data.setValue(Optional.of(GlobalTranslator.render(data.getValue().get(), locale)));
                }
            }
        }
    }

    protected void broadcastSpawnPackets() {
        metadata.takeDirty();
        for (UUID viewer : viewers) {
            sendSpawnPackets(viewer);
        }
    }

    protected void sendSpawnPackets(@NotNull UUID user) {
        int proto = EntityLib.get().getConfig().getPlatform().getProtocolVersion(user);
        List<PacketWrapper<?>> packets = new ArrayList<>();
        collectSpawnPackets(user, proto, packets);
        sendBundled(user, proto, packets);
    }

    protected void collectSpawnPackets(@NotNull UUID user, int protocolVersion, @NotNull List<PacketWrapper<?>> packets) {
        packets.add(getSpawnProvider().provide(this, protocolVersion));
        packets.add(new WrapperPlayServerEntityHeadLook(entityId, location.getYaw()));
        PacketWrapper<?> metadataPacket = createMetadataPacket(user, protocolVersion);
        if (metadataPacket != null) {
            packets.add(metadataPacket);
        }
        if (!passengers.isEmpty()) {
            packets.add(createPassengerPacket());
        }
        WrapperEntity vehicle = riding;
        if (vehicle != null && vehicle.isSpawned() && vehicle.hasViewer(user)) {
            packets.add(vehicle.createPassengerPacket());
        }
        if (leashHolder != NO_LEASH) {
            packets.add(new WrapperPlayServerAttachEntity(entityId, leashHolder, true));
        }
    }

    protected void sendDespawnPackets(@NotNull UUID user) {
        int proto = EntityLib.get().getConfig().getPlatform().getProtocolVersion(user);
        List<PacketWrapper<?>> packets = new ArrayList<>();
        collectDespawnPackets(user, proto, packets);
        sendBundled(user, proto, packets);
    }

    protected void collectDespawnPackets(@NotNull UUID user, int protocolVersion, @NotNull List<PacketWrapper<?>> packets) {
        packets.add(new WrapperPlayServerDestroyEntities(entityId));
    }

    protected void sendBundled(@NotNull UUID user, int protocolVersion, @NotNull List<PacketWrapper<?>> packets) {
        PacketBundles.send(user, protocolVersion, packets);
    }

    protected @NotNull SpawnPacketProvider getSpawnProvider() {
        return SpawnPacketProviders.forEntity(entityType);
    }

    public void sendPacketToViewers(@NotNull PacketWrapper<?> packet) {
        var platform = EntityLib.get().getConfig().getPlatform();
        for (UUID viewer : viewers) {
            platform.sendPacket(viewer, packet);
        }
    }

    public void sendPacketsToViewers(PacketWrapper<?> @NotNull ... packets) {
        for (PacketWrapper<?> packet : packets) {
            sendPacketToViewers(packet);
        }
    }

    public void sendPacketToViewersIfSpawned(@NotNull PacketWrapper<?> packet) {
        if (spawned) {
            sendPacketToViewers(packet);
        }
    }

    protected void sendPacket(@NotNull UUID user, @NotNull PacketWrapper<?> packet) {
        EntityLib.get().getConfig().getPlatform().sendPacket(user, packet);
    }

}
