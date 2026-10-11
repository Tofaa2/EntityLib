package me.tofaa.entitylib.spawn;

import com.github.retrooper.packetevents.protocol.entity.data.EntityData;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.protocol.world.Direction;
import com.github.retrooper.packetevents.protocol.world.Location;
import com.github.retrooper.packetevents.protocol.world.PaintingType;
import com.github.retrooper.packetevents.protocol.world.painting.PaintingVariant;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import com.github.retrooper.packetevents.wrapper.play.server.*;
import me.tofaa.entitylib.meta.MetaFields;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import me.tofaa.entitylib.wrapper.WrapperExperienceOrbEntity;
import me.tofaa.entitylib.wrapper.WrapperPaintingEntity;
import me.tofaa.entitylib.wrapper.WrapperLivingEntity;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public final class SpawnPacketProviders {

    public static final int MODERN_SPAWN_PROTOCOL = 761;
    public static final int LIVING_SPAWN_REMOVED_PROTOCOL = 759;
    public static final int PAINTING_SPAWN_REMOVED_PROTOCOL = 759;
    public static final int WEATHER_SPAWN_REMOVED_PROTOCOL = 735;
    public static final int EXPERIENCE_ORB_SPAWN_REMOVED_PROTOCOL = 770;
    public static final int PLAYER_SPAWN_REMOVED_PROTOCOL = 764;
    private static final byte LIGHTNING_BOLT_WEATHER_TYPE = 1;

    private static final Map<EntityType, SpawnPacketProvider> REGISTRY = new ConcurrentHashMap<>();

    private static int experienceOf(WrapperEntity entity) {
        if (entity instanceof WrapperExperienceOrbEntity) {
            return ((WrapperExperienceOrbEntity) entity).getExperience();
        }
        if (entity instanceof WrapperLivingEntity) {
            return ((WrapperLivingEntity) entity).getExperience();
        }
        Integer value = entity.getMetadata().get(MetaFields.ExperienceOrb.VALUE);
        return value == null ? 0 : value;
    }

    public static @NotNull List<EntityData<?>> spawnMetadata(@NotNull WrapperEntity entity, int protocolVersion) {
        List<EntityData<?>> entries = entity.getMetadata().encode(protocolVersion);
        if (entries.isEmpty()) {
            entries.add(new EntityData<>(0, EntityDataTypes.BYTE, (byte) 0));
        }
        return entries;
    }

    private static final SpawnPacketProvider EXPERIENCE_ORB = (entity, proto) -> {
        if (proto >= EXPERIENCE_ORB_SPAWN_REMOVED_PROTOCOL) {
            return objectModernProvider(entity.getEntityType()).provide(entity, proto);
        }
        int exp = experienceOf(entity);
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
        Direction direction = entity instanceof WrapperPaintingEntity
            ? ((WrapperPaintingEntity) entity).getPaintingDirection()
            : entity.getDirection();
        if (proto >= PAINTING_SPAWN_REMOVED_PROTOCOL) {
            return new WrapperPlayServerSpawnEntity(
                entity.getEntityId(),
                Optional.of(entity.getUuid()),
                entity.getEntityType(),
                loc.getPosition(),
                loc.getPitch(),
                loc.getYaw(),
                loc.getYaw(),
                direction.ordinal(),
                Optional.of(entity.getVelocity())
            );
        }
        PaintingVariant variant = entity.getMetadata().get(MetaFields.Painting.PAINTING_VARIANT);
        return new WrapperPlayServerSpawnPainting(
            entity.getEntityId(),
            entity.getUuid(),
            variant == null ? PaintingType.KEBAB : WrapperPaintingEntity.legacyType(variant),
            loc.getPosition().toVector3i(),
            direction
        );
    };

    private static final SpawnPacketProvider WEATHER = (entity, proto) -> {
        if (proto >= WEATHER_SPAWN_REMOVED_PROTOCOL) {
            return objectModernProvider(entity.getEntityType()).provide(entity, proto);
        }
        return new WrapperPlayServerSpawnWeatherEntity(
            entity.getEntityId(),
            LIGHTNING_BOLT_WEATHER_TYPE,
            entity.getLocation().getX(),
            entity.getLocation().getY(),
            entity.getLocation().getZ()
        );
    };

    public static final SpawnPacketProvider PLAYER = (entity, proto) -> {
        if (proto >= PLAYER_SPAWN_REMOVED_PROTOCOL) {
            return livingModernProvider(EntityTypes.PLAYER).provide(entity, proto);
        }
        return new WrapperPlayServerSpawnPlayer(
            entity.getEntityId(),
            entity.getUuid(),
            entity.getLocation(),
            spawnMetadata(entity, proto)
        );
    };

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
                spawnMetadata(entity, proto)
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
        REGISTRY.put(EntityTypes.PLAYER, PLAYER);
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
                if (proto >= LIVING_SPAWN_REMOVED_PROTOCOL) {
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
