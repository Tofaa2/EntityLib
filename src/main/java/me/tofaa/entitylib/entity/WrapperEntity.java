package me.tofaa.entitylib.entity;

import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.protocol.player.User;
import com.github.retrooper.packetevents.protocol.world.Location;
import com.github.retrooper.packetevents.util.Vector3d;
import com.github.retrooper.packetevents.util.Vector3f;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import com.github.retrooper.packetevents.wrapper.play.server.*;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.meta.EntityMeta;
import me.tofaa.entitylib.meta.types.ObjectData;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class WrapperEntity {

    public static EntityIdProvider ID_PROVIDER = EntityIdProvider.simple();

    private final EntityType entityType;
    private final int entityId;
    private final Optional<UUID> uuid;
    private final EntityMeta meta;
    private final Set<UUID> viewers = new HashSet<>();
    private Location location;
    private boolean onGround;
    private boolean spawned;
    private Vector3d velocity = Vector3d.zero();

    public WrapperEntity(@NotNull UUID uuid, EntityType entityType, EntityMeta meta) {
        this.uuid = Optional.of(uuid);
        this.entityType = entityType;
        this.entityId = ID_PROVIDER.provide();
        this.meta = meta;
    }

    public void refresh() {
        if (!spawned) return;
        sendPacketToViewers(meta.createPacket());
    }

    public boolean spawn(Location location) {
        if (spawned) return false;
        this.location = location;
        this.spawned = true;

        int data = 0;
        Optional<Vector3d> velocity;
        double veloX = 0, veloY = 0, veloZ = 0;
        if (meta instanceof ObjectData) {
            ObjectData od = (ObjectData) meta;

            data = od.getObjectData();
            if (od.requiresVelocityPacketAtSpawn()) {
                final WrapperPlayServerEntityVelocity veloPacket = getVelocityPacket();
                veloX = veloPacket.getVelocity().getX();
                veloY = veloPacket.getVelocity().getY();
                veloZ = veloPacket.getVelocity().getZ();
            }
        }
        if (veloX == 0 && veloY == 0 && veloZ == 0) {
            velocity = Optional.empty();
        } else {
            velocity = Optional.of(new Vector3d(veloX, veloY, veloZ));
        }
        sendPacketToViewers(
                new WrapperPlayServerSpawnEntity(
                        entityId,
                        this.uuid,
                        entityType,
                        location.getPosition(),
                        location.getPitch(),
                        location.getYaw(),
                        location.getYaw(),
                        data,
                        velocity
                )
        );
        sendPacketToViewers(meta.createPacket());
        return true;
    }

    public void rotateHead(float yaw, float pitch) {
        sendPacketToViewers(
                new WrapperPlayServerEntityRotation(entityId, yaw, pitch, onGround)
        );
    }

    public void rotateHead(Location location) {
        rotateHead(location.getYaw(), location.getPitch());
    }

    public void remove() {
        if (!spawned) return;
        spawned = false;
        sendPacketToViewers(new WrapperPlayServerDestroyEntities(entityId));
    }

    public void teleport(Location location, boolean onGround) {
        this.location = location;
        this.onGround = onGround;
        sendPacketToViewers(
                new WrapperPlayServerEntityTeleport(entityId, location, onGround)
        );
    }

    public @NotNull Collection<UUID> getViewers() {
        return Collections.unmodifiableCollection(viewers);
    }

    public void teleport(Location location) {
        teleport(location, true);
    }

    public void sendPacketToViewers(PacketWrapper<?> packet) {
        viewers.forEach(uuid -> EntityLib.sendPacket(uuid, packet));
    }

    public void sendPacketsToViewers(PacketWrapper<?>... wrappers) {
        for (PacketWrapper<?> wrapper : wrappers) {
            sendPacketToViewers(wrapper);
        }
    }

    public boolean addViewer(UUID uuid) {
        if (!viewers.add(uuid)) {
            return false;
        }
        if (!spawned) return false;
        WrapperPlayServerSpawnEntity packet = new WrapperPlayServerSpawnEntity(
                entityId,
                this.uuid,
                entityType,
                location.getPosition(),
                location.getPitch(),
                location.getYaw(),
                location.getYaw(),
                0,
                Optional.empty()
        );
        EntityLib.sendPacket(uuid, packet);
        EntityLib.sendPacket(uuid, meta.createPacket());
        return true;
    }

    public void addViewer(User user) {
        addViewer(user.getUUID());
    }

    public void removeViewer(UUID uuid) {
        if (!viewers.remove(uuid)) {
            return;
        }
        EntityLib.sendPacket(uuid, new WrapperPlayServerDestroyEntities(entityId));
    }

    public EntityMeta getMeta() {
        return meta;
    }

    public UUID getUuid() {
        return uuid.get();
    }

    public EntityType getEntityType() {
        return entityType;
    }

    public int getEntityId() {
        return entityId;
    }

    public <T extends EntityMeta> Class<T> getMetaClass() {
        return EntityLib.getMetaClassOf(entityType);
    }

    public boolean hasSpawned() {
        return spawned;
    }

    public Vector3d getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector3d velocity) {
        this.velocity = velocity;
    }

    private WrapperPlayServerEntityVelocity getVelocityPacket() {
        Vector3d velocity = this.velocity.multiply(8000.0f / 20.0f);
        return new WrapperPlayServerEntityVelocity(entityId, velocity);
    }

}
