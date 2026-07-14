package me.tofaa.entitylib.meta.mobs.water;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.WaterMobMeta;

public class BaseFishMeta extends WaterMobMeta {

    public static final byte OFFSET = WaterMobMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 1;

    public BaseFishMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }


    public boolean isFromBucket() {
        return super.metadata.getIndex(OFFSET, false);
    }

    public void setFromBucket(boolean value) {
        super.metadata.setIndex(OFFSET, EntityDataTypes.BOOLEAN, value);
    }

}
