package me.tofaa.entitylib.meta.projectile;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.ObjectData;
import me.tofaa.entitylib.meta.types.ProjectileMeta;

public class ArrowMeta extends BaseArrowMeta implements ProjectileMeta, ObjectData {

    public static final byte OFFSET = BaseArrowMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 1;

    private int shooterId = -1;

    public ArrowMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    public int getColor() {
        return super.metadata.getIndex(OFFSET, -1);
    }

    public void setColor(int value) {
        super.metadata.setIndex(OFFSET, EntityDataTypes.INT, value);
    }

    @Override
    public int getShooter() {
        return shooterId;
    }

    @Override
    public void setShooter(int entityId) {
        this.shooterId = entityId;
    }


    @Override
    public int getObjectData() {
        return this.shooterId == -1 ? 0 : this.shooterId + 1;
    }

    @Override
    public boolean requiresVelocityPacketAtSpawn() {
        return true;
    }
}
