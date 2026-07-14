package me.tofaa.entitylib.packetconversion;

import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import me.tofaa.entitylib.wrapper.WrapperEntity;

public interface EntitySpawningMethod {

    EntitySpawningMethod EXPERIENCE_ORB = new CommonSpawningMethods.ExperienceOrb();


    PacketWrapper<?> getSpawnPacket(WrapperEntity entity);

}
