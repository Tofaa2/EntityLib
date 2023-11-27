package me.tofaa.entitylib.entity;

import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.protocol.player.User;
import com.github.retrooper.packetevents.protocol.world.Location;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerDestroyEntities;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityRotation;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityTeleport;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerSpawnEntity;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.meta.EntityMeta;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

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

    public WrapperEntity(@NotNull UUID uuid, EntityType entityType, EntityMeta meta) {
        this.uuid = Optional.of(uuid);
        this.entityType = entityType;
        this.entityId = ID_PROVIDER.provide();
        this.meta = meta;
    }

    public boolean spawn(Location location) {
        if (spawned) return false;
        this.location = location;
        this.spawned = true;
        sendPacketToViewers(
                new WrapperPlayServerSpawnEntity(
                        entityId,
                        this.uuid,
                        entityType,
                        location.getPosition(),
                        location.getPitch(),
                        location.getYaw(),
                        location.getYaw(),
                        0,
                        Optional.empty()
                )
        );
        return true;
    }

    public void rotateHead(float yaw, float pitch) {
        sendPacketToViewers(
                new WrapperPlayServerEntityRotation(entityId, yaw, pitch, onGround)
        );
    }


    private static double distance(Location to, Location from) {
        double x = to.getX() - from.getX();
        double y = to.getY() - from.getY();
        double z = to.getZ() - from.getZ();
        return Math.sqrt(x * x + y * y + z * z);
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

    public void teleport(Location location) {
        teleport(location, true);
    }

    public void sendPacketToViewers(PacketWrapper<?> packet) {
        viewers.forEach(uuid -> {
            Object user = EntityLib.getPacketEvents().getProtocolManager().getChannel(uuid);
            EntityLib.getPacketEvents().getProtocolManager().sendPacket(user, packet);
        });
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

}
