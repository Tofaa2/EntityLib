package me.tofaa.entitylib.meta.mobs;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.AgeableMeta;

public class StriderMeta extends AgeableMeta {

    public static final byte OFFSET = AgeableMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 3;

    public StriderMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }


    public int getTimeToBoost() {
        return super.metadata.getIndex(OFFSET, 0);
    }

    public void setTimeToBoost(int value) {
        super.metadata.setIndex(OFFSET, EntityDataTypes.INT, value);
    }

    public boolean isShaking() {
        return super.metadata.getIndex(offset(OFFSET,1), false);
    }

    public void setShaking(boolean value) {
        super.metadata.setIndex(offset(OFFSET, 1), EntityDataTypes.BOOLEAN, value);
    }

    public boolean isHasSaddle() {
        return super.metadata.getIndex(offset(OFFSET, 2), false);
    }

    public void setHasSaddle(boolean value) {
        super.metadata.setIndex(offset(OFFSET, 2), EntityDataTypes.BOOLEAN, value);
    }

}
