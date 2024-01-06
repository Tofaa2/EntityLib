package me.tofaa.entitylib.entity;

import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import me.tofaa.entitylib.meta.EntityMeta;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class WrapperLivingEntity extends WrapperEntity{

    private final WrapperEntityEquipment equipment;

    public WrapperLivingEntity(int entityId, @NotNull UUID uuid, EntityType entityType, EntityMeta meta) {
        super(entityId, uuid, entityType, meta);
        this.equipment = new WrapperEntityEquipment(this);
    }

    public WrapperEntityEquipment getEquipment() {
        return equipment;
    }

}
