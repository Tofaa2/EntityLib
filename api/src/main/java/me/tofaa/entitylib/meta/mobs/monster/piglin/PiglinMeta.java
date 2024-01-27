package me.tofaa.entitylib.meta.mobs.monster.piglin;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.Metadata;

public class PiglinMeta extends BasePiglinMeta{

    public static final byte OFFSET = BasePiglinMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 3;

    public PiglinMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    public boolean isBaby() {
        return super.metadata.getIndex(OFFSET, false);
    }

    public void setBaby(boolean value) {
        if (isBaby() == value) {
            return;
        }
        super.metadata.setIndex(OFFSET, EntityDataTypes.BOOLEAN, value);
    }

    public boolean isChargingCrossbow() {
        return super.metadata.getIndex(offset(OFFSET, 1), false);
    }

    public void setChargingCrossbow(boolean value) {
        super.metadata.setIndex(offset(OFFSET, 1), EntityDataTypes.BOOLEAN, value);
    }

    public boolean isDancing() {
        return super.metadata.getIndex(offset(OFFSET, 2), false);
    }

    public void setDancing(boolean value) {
        super.metadata.setIndex(offset(OFFSET, 2), EntityDataTypes.BOOLEAN, value);
    }


}
