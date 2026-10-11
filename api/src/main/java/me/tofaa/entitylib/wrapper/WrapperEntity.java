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
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.MissingPolicy;
import me.tofaa.entitylib.meta.MetaField;
import me.tofaa.entitylib.meta.MetaFields;
import me.tofaa.entitylib.meta.MetaFlag;
import me.tofaa.entitylib.meta.MetaOwnershipException;
import me.tofaa.entitylib.meta.OwnershipCheck;
import me.tofaa.entitylib.spawn.SpawnPacketProvider;
import me.tofaa.entitylib.spawn.SpawnPacketProviders;
import me.tofaa.entitylib.ve.ViewerRule;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.translation.GlobalTranslator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class WrapperEntity {

    private static final Set<String> OWNERSHIP_WARNINGS = ConcurrentHashMap.newKeySet();

    protected final int entityId;
    protected final UUID uuid;
    protected final EntityType entityType;
    protected final Set<UUID> viewers;
    protected final Metadata metadata;
    protected final List<ViewerRule> viewerRules;
    protected final EntityTriggers triggers;
    protected final Set<Integer> passengers;
    protected Location location;
    protected boolean spawned;
    protected boolean onGround;
    protected Vector3d velocity;
    protected int spawnData;
    private WrapperEntity riding;
    private Location preRidingLocation;

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

    public void teleport(@NotNull Location location, boolean onGround) {
        this.onGround = onGround;
        setLocation(location);
    }

    public void teleport(@NotNull Location location) {
        teleport(location, onGround);
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
        if (viewers.add(user)) {
            triggers.fireViewerAdd(user);
            if (spawned) {
                sendSpawnPackets(user);
            }
            return true;
        }
        return false;
    }

    public boolean addViewerSilently(@NotNull UUID user) {
        return viewers.add(user);
    }

    public boolean removeViewer(@NotNull UUID user) {
        if (viewers.remove(user)) {
            if (spawned) {
                sendDespawnPackets(user);
            }
            triggers.fireViewerRemove(user);
            return true;
        }
        return false;
    }

    public boolean removeViewerSilently(@NotNull UUID user) {
        return viewers.remove(user);
    }

    public void spawn(@NotNull Location location) {
        this.location = location;
        this.spawned = true;
        broadcastSpawnPackets();
        triggers.fireSpawn(this);
    }

    public void despawn() {
        if (!spawned) return;
        this.spawned = false;
        for (UUID viewer : viewers) {
            sendDespawnPackets(viewer);
        }
    }

    public void remove() {
        if (!spawned) return;
        despawn();
        viewers.clear();
        triggers.fireRemove(this);
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
        if (spawned) {
            broadcastMetadata();
        }
    }

    public void setFlag(@NotNull MetaFlag flag, boolean value) {
        if (!checkOwnership(flag.field())) {
            return;
        }
        metadata.setFlag(flag, value);
        if (spawned) {
            broadcastMetadata();
        }
    }

    public void setMetaFromPacket(@NotNull WrapperPlayServerEntityMetadata packet) {
        setMetaFromPacket(packet, packet.getServerVersion().getProtocolVersion());
    }

    public void setMetaFromPacket(@NotNull WrapperPlayServerEntityMetadata packet, int protocolVersion) {
        metadata.setMetaFromPacket(packet, entityType, protocolVersion);
        if (spawned) {
            broadcastMetadata();
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

    protected void broadcastMetadata() {
        for (UUID viewer : viewers) {
            sendMetadata(viewer);
        }
    }

    protected void sendMetadata(@NotNull UUID user) {
        int proto = EntityLib.get().getConfig().getPlatform().getProtocolVersion(user);
        boolean strict = EntityLib.get().getConfig().isStrictVersionCheck();
        List<EntityData<?>> entries = metadata.encode(proto, strict ? MissingPolicy.THROW : MissingPolicy.SKIP);
        if (entries.isEmpty()) {
            return;
        }
        render(user, entries);
        sendPacket(user, new WrapperPlayServerEntityMetadata(entityId, entries));
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
        for (UUID viewer : viewers) {
            sendSpawnPackets(viewer);
        }
    }

    protected void sendSpawnPackets(@NotNull UUID user) {
        int proto = EntityLib.get().getConfig().getPlatform().getProtocolVersion(user);
        var packet = getSpawnProvider().provide(this, proto);
        sendPacket(user, packet);
        sendPacket(user, new WrapperPlayServerEntityHeadLook(entityId, location.getYaw()));
        sendMetadata(user);
        if (!passengers.isEmpty()) {
            sendPacket(user, createPassengerPacket());
        }
        if (riding != null && riding.isSpawned() && riding.hasViewer(user)) {
            sendPacket(user, riding.createPassengerPacket());
        }
    }

    protected void sendDespawnPackets(@NotNull UUID user) {
        sendPacket(user, new WrapperPlayServerDestroyEntities(entityId));
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
