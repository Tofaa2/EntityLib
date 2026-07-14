package me.tofaa.entitylib.packetconversion;

import com.github.retrooper.packetevents.manager.server.ServerVersion;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerSpawnEntity;
import me.tofaa.entitylib.meta.types.ObjectData;
import me.tofaa.entitylib.utils.VersionUtil;
import me.tofaa.entitylib.wrapper.WrapperEntity;

import java.util.Optional;

final class ModernSpawningMethods {

    private ModernSpawningMethods() {}

    static class Generic implements EntitySpawningMethod  {

        @Override
        public PacketWrapper<?> getSpawnPacket(WrapperEntity entity) {
            if (VersionUtil.isOlderThan(ServerVersion.V_1_19_3)) throw new UnsupportedOperationException("This method is not supported in this version.");
            return new WrapperPlayServerSpawnEntity(
                    entity.getEntityId(),
                    Optional.of(entity.getUuid()),
                    entity.getEntityType(),
                    entity.getLocation().getPosition(),
                    entity.getLocation().getPitch(),
                    entity.getLocation().getYaw(),
                    entity.getLocation().getYaw(),
                    entity.getEntityMeta() instanceof ObjectData ? (((ObjectData) entity.getEntityMeta()).getObjectData()) : 0,
                    entity.createVeloPacket()
            );
        }
    }

}
