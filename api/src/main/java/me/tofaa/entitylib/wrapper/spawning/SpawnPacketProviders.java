package me.tofaa.entitylib.wrapper.spawning;

import com.github.retrooper.packetevents.protocol.world.Location;
import com.github.retrooper.packetevents.wrapper.play.server.*;
import me.tofaa.entitylib.meta.other.PaintingMeta;
import me.tofaa.entitylib.utils.Check;
import me.tofaa.entitylib.wrapper.WrapperExperienceOrbEntity;
import org.jetbrains.annotations.NotNull;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.*;
import java.util.Optional;

interface SpawnPacketProviders {

    @NotNull SpawnPacketProvider<WrapperPlayServerSpawnExperienceOrb> EXPERIENCE_ORB = (user, entity) -> {
        Check.stateCondition(!(entity instanceof WrapperExperienceOrbEntity), "Attempted to use spawn packet provider for Experience orbs on a non ExperienceOrb entity. Please use an instance of WrapperExperienceOrbEntity.");
        WrapperExperienceOrbEntity expEntity = (WrapperExperienceOrbEntity) entity;
        return new WrapperPlayServerSpawnExperienceOrb(
                entity.getEntityId(),
                entity.getX(),
                entity.getY(),
                entity.getZ(),
                expEntity.getExperience()
        );
    };

    @NotNull SpawnPacketProvider<WrapperPlayServerSpawnEntity> GENERAL = (user, entity) -> {
        Location location = entity.getLocation();
        return new WrapperPlayServerSpawnEntity(
                entity.getEntityId(),
                Optional.of(entity.getUuid()),
                entity.getEntityType(),
                location.getPosition(),
                location.getPitch(),
                location.getYaw(),
                location.getYaw(),
                entity.getObjectData(),
                entity.createVeloPacket()
        );
    };

    @NotNull SpawnPacketProvider<WrapperPlayServerSpawnWeatherEntity> LEGACY_WEATHER_ENTITY = (user, entity) -> {
        throw new NotImplementedException();
    };
    @NotNull SpawnPacketProvider<WrapperPlayServerSpawnPainting> LEGACY_PAINTING = (user, entity) -> {
        Check.stateCondition(!(entity.getEntityMeta() instanceof PaintingMeta), "Attempted to use spawn packet provider for paintings but not using an entity with PaintingMeta.");
        PaintingMeta meta = entity.getEntityMeta(PaintingMeta.class);
        return new WrapperPlayServerSpawnPainting(
                entity.getEntityId(),
                entity.getUuid(),
                meta.getType().asProtocolType(),
                entity.getLocation().getPosition().toVector3i(),
                meta.getDirection()
        );
    };

    @NotNull SpawnPacketProvider<WrapperPlayServerSpawnLivingEntity> PRE_1_19_LIVING = (user, entity) -> {
        Location location = entity.getLocation();
        return new WrapperPlayServerSpawnLivingEntity(
                entity.getEntityId(),
                entity.getUuid(),
                entity.getEntityType(),
                location,
                location.getPitch(),
                entity.getVelocity(),
                entity.getEntityMeta()
        );
    };

}
