package me.tofaa.entitylib.wrapper;

import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.protocol.world.Location;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.meta.MetaFields;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class WrapperExperienceOrbEntity extends WrapperEntity {

    private short experience;

    public WrapperExperienceOrbEntity(int entityId, @NotNull UUID uuid, @NotNull Location location) {
        super(entityId, uuid, EntityTypes.EXPERIENCE_ORB, location);
    }

    public WrapperExperienceOrbEntity(@NotNull Location location) {
        this(EntityLib.get().getPlatform().nextEntityId(), UUID.randomUUID(), location);
    }

    public WrapperExperienceOrbEntity() {
        this(new Location(0, 0, 0, 0, 0));
    }

    public short getExperience() {
        return experience;
    }

    public void setExperience(short experience) {
        this.experience = experience;
        metadata.set(MetaFields.ExperienceOrb.VALUE, (int) experience);
        respawn();
    }

}
