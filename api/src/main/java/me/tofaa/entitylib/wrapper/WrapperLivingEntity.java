package me.tofaa.entitylib.wrapper;

import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import me.tofaa.entitylib.meta.EntityMeta;

import java.util.UUID;

public class WrapperLivingEntity extends WrapperEntity{

    private final WrapperEntityEquipment equipment;

    public WrapperLivingEntity(int entityId, UUID uuid, EntityType entityType, EntityMeta entityMeta) {
        super(entityId, uuid, entityType, entityMeta);
        this.equipment = new WrapperEntityEquipment(this);
    }


    public WrapperEntityEquipment getEquipment() {
        return equipment;
    }
}
