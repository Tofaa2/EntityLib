package me.tofaa.entitylib.spawn;

import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.protocol.world.Location;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import com.github.retrooper.packetevents.wrapper.play.server.*;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import me.tofaa.entitylib.wrapper.WrapperLivingEntity;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public final class SpawnPacketProviders {

    public static final int MODERN_SPAWN_PROTOCOL = 761;

    private static final Map<EntityType, SpawnPacketProvider> REGISTRY = new ConcurrentHashMap<>();

    private static final SpawnPacketProvider EXPERIENCE_ORB = (entity, proto) -> {
        int exp = entity instanceof WrapperLivingEntity
            ? ((WrapperLivingEntity) entity).getExperience()
            : 0;
        return new WrapperPlayServerSpawnExperienceOrb(
            entity.getEntityId(),
            entity.getLocation().getX(),
            entity.getLocation().getY(),
            entity.getLocation().getZ(),
            (short) exp
        );
    };

    private static final SpawnPacketProvider PAINTING = (entity, proto) -> {
        Location loc = entity.getLocation();
        return new WrapperPlayServerSpawnPainting(
            entity.getEntityId(),
            entity.getUuid(),
            loc.getPosition().toVector3i(),
            entity.getDirection()
        );
    };

    private static final SpawnPacketProvider WEATHER = (entity, proto) ->
        new WrapperPlayServerSpawnWeatherEntity(
            entity.getEntityId(),
            (byte) 0,
            entity.getLocation().getX(),
            entity.getLocation().getY(),
            entity.getLocation().getZ()
        );

    private static final SpawnPacketProvider PLAYER = (entity, proto) ->
        new WrapperPlayServerSpawnPlayer(
            entity.getEntityId(),
            entity.getUuid(),
            entity.getLocation(),
            List.of()
        );

    private static SpawnPacketProvider livingModernProvider(EntityType entityType) {
        return (entity, proto) -> {
            Location loc = entity.getLocation();
            return new WrapperPlayServerSpawnEntity(
                entity.getEntityId(),
                Optional.of(entity.getUuid()),
                entityType,
                loc.getPosition(),
                loc.getPitch(),
                loc.getYaw(),
                loc.getYaw(),
                entity.getSpawnData(),
                Optional.of(entity.getVelocity())
            );
        };
    }

    private static SpawnPacketProvider livingLegacyProvider(EntityType entityType) {
        return (entity, proto) -> {
            Location loc = entity.getLocation();
            return new WrapperPlayServerSpawnLivingEntity(
                entity.getEntityId(),
                entity.getUuid(),
                entityType,
                loc.getPosition(),
                loc.getYaw(),
                loc.getPitch(),
                loc.getPitch(),
                entity.getVelocity(),
                List.of()
            );
        };
    }

    private static SpawnPacketProvider objectModernProvider(EntityType entityType) {
        return (entity, proto) -> {
            Location loc = entity.getLocation();
            return new WrapperPlayServerSpawnEntity(
                entity.getEntityId(),
                Optional.of(entity.getUuid()),
                entityType,
                loc.getPosition(),
                loc.getPitch(),
                loc.getYaw(),
                loc.getYaw(),
                entity.getSpawnData(),
                Optional.of(entity.getVelocity())
            );
        };
    }

    private static SpawnPacketProvider objectLegacyProvider(EntityType entityType) {
        return (entity, proto) -> new WrapperPlayServerSpawnEntity(
            entity.getEntityId(),
            entity.getUuid(),
            entityType,
            entity.getLocation(),
            entity.getLocation().getYaw(),
            entity.getSpawnData(),
            entity.getVelocity()
        );
    }

    static {
        REGISTRY.put(EntityTypes.EXPERIENCE_ORB, EXPERIENCE_ORB);
        REGISTRY.put(EntityTypes.PAINTING, PAINTING);
        REGISTRY.put(EntityTypes.LIGHTNING_BOLT, WEATHER);
    }

    private SpawnPacketProviders() {}

    public static @NotNull SpawnPacketProvider forEntity(@NotNull EntityType entityType) {
        SpawnPacketProvider provider = REGISTRY.get(entityType);
        if (provider != null) return provider;
        return defaultFor(entityType);
    }

    public static void register(@NotNull EntityType entityType, @NotNull SpawnPacketProvider provider) {
        REGISTRY.put(entityType, provider);
    }

    public static void unregister(@NotNull EntityType entityType) {
        REGISTRY.remove(entityType);
    }

    private static SpawnPacketProvider defaultFor(EntityType entityType) {
        boolean isLiving = entityType.isInstanceOf(EntityTypes.LIVINGENTITY);
        if (isLiving) {
            return (entity, proto) -> {
                if (proto >= MODERN_SPAWN_PROTOCOL) {
                    return livingModernProvider(entityType).provide(entity, proto);
                }
                return livingLegacyProvider(entityType).provide(entity, proto);
            };
        }
        return (entity, proto) -> {
            if (proto >= MODERN_SPAWN_PROTOCOL) {
                return objectModernProvider(entityType).provide(entity, proto);
            }
            return objectLegacyProvider(entityType).provide(entity, proto);
        };
    }
}
