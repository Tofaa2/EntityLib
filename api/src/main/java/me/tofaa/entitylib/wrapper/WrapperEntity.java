package me.tofaa.entitylib.wrapper;

import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.protocol.world.Location;
import com.github.retrooper.packetevents.util.Vector3d;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import com.github.retrooper.packetevents.wrapper.play.server.*;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.meta.EntityMetadata;
import me.tofaa.entitylib.meta.MetaField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public abstract class WrapperEntity {

    protected final int entityId;
    protected final UUID uuid;
    protected final EntityType entityType;
    protected final Set<UUID> viewers;
    protected final EntityMetadata.Builder metadataBuilder;
    protected Location location;
    protected boolean spawned;
    protected Vector3d velocity;

    public WrapperEntity(int entityId, @NotNull UUID uuid, @NotNull EntityType entityType, @NotNull Location location) {
        this.entityId = entityId;
        this.uuid = uuid;
        this.entityType = entityType;
        this.location = location;
        this.viewers = ConcurrentHashMap.newKeySet();
        this.velocity = new Vector3d();
        this.metadataBuilder = EntityMetadata.builder(entityId);
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

    public void setLocation(@NotNull Location location) {
        this.location = location;
        if (spawned) {
            var packet = new WrapperPlayServerEntityTeleport(entityId, location, isOnGround());
            sendPacketToViewers(packet);
        }
    }

    public boolean isSpawned() {
        return spawned;
    }

    public boolean isOnGround() {
        return false;
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

    public @NotNull Set<UUID> getViewers() {
        return Collections.unmodifiableSet(viewers);
    }

    public boolean addViewer(@NotNull UUID user) {
        if (viewers.add(user)) {
            sendSpawnPackets(user);
            return true;
        }
        return false;
    }

    public boolean removeViewer(@NotNull UUID user) {
        if (viewers.remove(user)) {
            if (spawned) {
                sendPacket(user, new WrapperPlayServerDestroyEntities(entityId));
            }
            return true;
        }
        return false;
    }

    public void spawn(@NotNull Location location) {
        this.location = location;
        this.spawned = true;
        broadcastSpawnPackets();
    }

    public void remove() {
        if (!spawned) return;
        this.spawned = false;
        var packet = new WrapperPlayServerDestroyEntities(entityId);
        sendPacketToViewers(packet);
        viewers.clear();
    }

    public <T> void setMetadata(@NotNull MetaField<T> field, @Nullable T value) {
        metadataBuilder.with(field, value);
        if (spawned) {
            broadcastMetadata();
        }
    }

    protected void broadcastMetadata() {
        for (UUID viewer : viewers) {
            sendMetadata(viewer);
        }
    }

    protected void sendMetadata(@NotNull UUID user) {
        int proto = EntityLib.get().getConfig().getPlatform().getProtocolVersion(user);
        var meta = metadataBuilder.build();
        var packet = meta.createPacket(proto);
        sendPacket(user, packet);
    }

    protected void broadcastSpawnPackets() {
        for (UUID viewer : viewers) {
            sendSpawnPackets(viewer);
        }
    }

    protected void sendSpawnPackets(@NotNull UUID user) {
        sendPacket(user, createSpawnPacket());
        sendPacket(user, new WrapperPlayServerEntityHeadLook(entityId, location.getYaw()));
        sendMetadata(user);
    }

    protected abstract @NotNull WrapperPlayServerSpawnEntity createSpawnPacket();

    protected void sendPacketToViewers(@NotNull PacketWrapper<?> packet) {
        var platform = EntityLib.get().getConfig().getPlatform();
        for (UUID viewer : viewers) {
            platform.sendPacket(viewer, packet);
        }
    }

    protected void sendPacket(@NotNull UUID user, @NotNull PacketWrapper<?> packet) {
        EntityLib.get().getConfig().getPlatform().sendPacket(user, packet);
    }

}
