package me.tofaa.entitylib.meta.mobs.villager;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.AgeableMeta;

public class BaseVillagerMeta extends AgeableMeta {

    public static final byte OFFSET = AgeableMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 1;

    public BaseVillagerMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    public int getHeadShakeTimer() {
        return super.metadata.getIndex(OFFSET, 0);
    }

    public void setHeadShakeTimer(int value) {
        super.metadata.setIndex(OFFSET, EntityDataTypes.INT, value);
    }

}
