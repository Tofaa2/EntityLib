package me.tofaa.entitylib.packetconversion;

import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerSpawnLivingEntity;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerSpawnPainting;
import me.tofaa.entitylib.meta.other.PaintingMeta;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import me.tofaa.entitylib.wrapper.WrapperLivingEntity;

final class LegacySpawningMethods {

    private LegacySpawningMethods() {}

    static class Generic implements EntitySpawningMethod {
        @Override
        public PacketWrapper<?> getSpawnPacket(WrapperEntity entity) {
            return null;
        }
    }

    static class LivingEntity implements EntitySpawningMethod {

        @Override
        public PacketWrapper<?> getSpawnPacket(WrapperEntity entity) {
            if (!(entity instanceof WrapperLivingEntity)) {
                throw new IllegalArgumentException("Entity is not an instance of WrapperLivingEntity");
            }
            return new WrapperPlayServerSpawnLivingEntity(
                    entity.getEntityId(),
                    entity.getUuid(),
                    entity.getEntityType(),
                    entity.getLocation().getPosition(),
                    entity.getLocation().getYaw(),
                    entity.getLocation().getPitch(),
                    entity.getLocation().getPitch(),
                    entity.createVeloPacket().get(),
                    entity.getEntityMeta().entityData()
            );
        }
    }

    static class Painting implements EntitySpawningMethod {

        @Override
        public PacketWrapper<?> getSpawnPacket(WrapperEntity entity) {
            if (entity.getEntityMeta() instanceof PaintingMeta) {
                PaintingMeta paintingMeta = (PaintingMeta) entity.getEntityMeta();
                return new WrapperPlayServerSpawnPainting(
                        entity.getEntityId(),
                        entity.getUuid(),
                        entity.getLocation().getPosition().toVector3i(),
                        paintingMeta.getDirection()
                );
            }
            throw new IllegalArgumentException("EntityMeta is not an instance of PaintingMeta");
        }
    }

}
