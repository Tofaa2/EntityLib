package me.tofaa.entitylib.packetconversion;

import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerSpawnExperienceOrb;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import me.tofaa.entitylib.wrapper.WrapperExperienceOrbEntity;

final class CommonSpawningMethods {

    static final class ExperienceOrb implements EntitySpawningMethod {

        @Override
        public PacketWrapper<?> getSpawnPacket(WrapperEntity entity) {
            short experience = entity instanceof WrapperExperienceOrbEntity ? ((WrapperExperienceOrbEntity) entity).getExperience() : 0;
            return new WrapperPlayServerSpawnExperienceOrb(
                    entity.getEntityId(),
                    entity.getLocation().getX(),
                    entity.getLocation().getY(),
                    entity.getLocation().getZ(),
                    experience
            );
        }
    }


}
