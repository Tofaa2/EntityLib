package me.tofaa.entitylib.wrapper.spawning;

import com.github.retrooper.packetevents.protocol.world.Location;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerSpawnEntity;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerSpawnLivingEntity;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerSpawnWeatherEntity;
import me.tofaa.entitylib.utils.Check;
import org.jetbrains.annotations.NotNull;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Optional;

interface SpawnPacketProviders {

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

    @NotNull SpawnPacketProvider<WrapperPlayServerSpawnWeatherEntity> WEATHER_ENTITY = (user, entity) -> {
        throw new NotImplementedException();
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
