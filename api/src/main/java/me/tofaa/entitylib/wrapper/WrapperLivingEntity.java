package me.tofaa.entitylib.wrapper;

import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.protocol.world.Location;
import me.tofaa.entitylib.spawn.SpawnPacketProvider;
import me.tofaa.entitylib.spawn.SpawnPacketProviders;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class WrapperLivingEntity extends WrapperEntity {

    private int experience;

    public WrapperLivingEntity(int entityId, @NotNull UUID uuid, @NotNull EntityType entityType, @NotNull Location location) {
        super(entityId, uuid, entityType, location);
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    protected @NotNull SpawnPacketProvider getSpawnProvider() {
        return SpawnPacketProviders.forEntity(getEntityType());
    }

}
