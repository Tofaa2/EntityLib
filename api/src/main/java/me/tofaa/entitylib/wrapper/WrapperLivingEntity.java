package me.tofaa.entitylib.wrapper;

import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import me.tofaa.entitylib.meta.EntityMeta;

import java.util.UUID;

public class WrapperLivingEntity extends WrapperEntity{




    public WrapperLivingEntity(int entityId, UUID uuid, EntityType entityType, EntityMeta entityMeta) {
        super(entityId, uuid, entityType, entityMeta);
    }
}
