package me.tofaa.entitylib.wrapper;

import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.protocol.player.User;
import com.github.retrooper.packetevents.protocol.world.Location;
import com.github.retrooper.packetevents.util.Vector3d;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerDestroyEntities;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityRotation;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityVelocity;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerSpawnEntity;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.meta.EntityMeta;
import me.tofaa.entitylib.tick.Tickable;
import org.jetbrains.annotations.NotNull;

import javax.swing.text.html.parser.Entity;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public class WrapperEntity implements Tickable {

    private final UUID uuid;
    private final int entityId;

    private EntityType entityType;
    private EntityMeta entityMeta;
    private Location location;
    private Set<UUID> viewers;
    private boolean onGround;
    private boolean spawned;
    private Vector3d velocity;


    public WrapperEntity(int entityId, UUID uuid, EntityType entityType, EntityMeta entityMeta) {
        this.entityId = entityId;
        this.uuid = uuid;
        this.entityType = entityType;
        this.entityMeta = entityMeta;
    }

    public void spawn() {}

    public void despawn() {}

    public void teleport(@NotNull Location location) {
        this.location = location;

    }

    public boolean addViewer(UUID uuid) {
        if (!viewers.add(uuid)) {
            return false;
        }
        if (!spawned) return false;
        WrapperPlayServerSpawnEntity packet = new WrapperPlayServerSpawnEntity(
                entityId,
                Optional.of(this.uuid),
                entityType,
                location.getPosition(),
                location.getPitch(),
                location.getYaw(),
                location.getYaw(),
                0,
                Optional.empty()
        );
        sendPacket(uuid, packet);
        sendPacket(uuid, entityMeta.createPacket());
        return true;
    }

    public void addViewer(User user) {
        addViewer(user.getUUID());
    }

    public void removeViewer(UUID uuid) {
        if (!viewers.remove(uuid)) {
            return;
        }
        sendPacket(uuid, new WrapperPlayServerDestroyEntities(entityId));
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

    public UUID getUuid() {
        return uuid;
    }

    public EntityType getEntityType() {
        return entityType;
    }


    private WrapperPlayServerEntityVelocity getVelocityPacket() {
        Vector3d velocity = this.velocity.multiply(8000.0f / 20.0f);
        return new WrapperPlayServerEntityVelocity(entityId, velocity);
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
        sendPacketToViewers(
                new WrapperPlayServerEntityRotation(entityId, yaw, pitch, onGround)
        );
    }

    public void rotateHead(Location location) {
        rotateHead(location.getYaw(), location.getPitch());
    }

    public void rotateHead(WrapperEntity entity) {
        rotateHead(entity.getLocation());
    }

    public void refresh() {
        if (!spawned) return;
        sendPacketToViewers(entityMeta.createPacket());
    }

    public void sendPacketToViewers(PacketWrapper<?> packet) {
        viewers.forEach(uuid -> sendPacket(uuid, packet));
    }

    public void sendPacketsToViewers(PacketWrapper<?>... wrappers) {
        for (PacketWrapper<?> wrapper : wrappers) {
            sendPacketToViewers(wrapper);
        }
    }

    private static void sendPacket(UUID user, PacketWrapper<?> wrapper) {
        EntityLib.getApi().getPacketEvents().getProtocolManager().sendPacket(EntityLib.getApi().getPacketEvents().getProtocolManager().getChannel(user), wrapper);
    }

    public boolean hasNoGravity() {
        return entityMeta.isHasNoGravity();
    }

    public void setHasNoGravity(boolean hasNoGravity) {
        entityMeta.setHasNoGravity(hasNoGravity);
        refresh();
    }

    public @NotNull Set<UUID> getViewers() {
        return Collections.unmodifiableSet(viewers);
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public void tick(long time) {

    }
}
