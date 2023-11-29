package me.tofaa.entitylib.meta.other;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.EntityMeta;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.ObjectData;

import java.util.Optional;

public class FishingHookMeta extends EntityMeta implements ObjectData {

    public static final byte OFFSET = EntityMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 2;

    private int shooterId;
    private int hookedId;

    public FishingHookMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    public boolean isCatchable() {
        return super.metadata.getIndex(offset(OFFSET, 1), false);
    }

    public void setCatchable(boolean value) {
        super.metadata.setIndex(offset(OFFSET, 1), EntityDataTypes.BOOLEAN, value);
    }

    public int getHookedEntity() {
        return hookedId;
    }

    public void setShooter(int entityId) {
        this.shooterId = entityId;
    }

    public void setHookedEntity(int entityId) {
        this.hookedId = entityId;
        super.metadata.setIndex(OFFSET, EntityDataTypes.INT, entityId == -1 ? 0 : entityId + 1);
    }

    @Override
    public int getObjectData() {
        return shooterId != -1 ? shooterId : 0;
    }

    @Override
    public boolean requiresVelocityPacketAtSpawn() {
        return false;
    }

}
