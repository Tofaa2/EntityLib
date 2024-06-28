package me.tofaa.entitylib.packetconversion;

import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import me.tofaa.entitylib.wrapper.WrapperEntity;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class EntitySpawningPacketConversion {

    private static Map<EntityType, EntitySpawningMethod> methods = new ConcurrentHashMap<>();

    static {

    }

    public PacketWrapper<?> getSpawnPacket(WrapperEntity entity) {
        EntityType type = entity.getEntityType();
        EntitySpawningMethod method = methods.get(type);
        return method.getSpawnPacket(entity);
    }

    private EntitySpawningPacketConversion() {}

}
