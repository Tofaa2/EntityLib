package me.tofaa.entitylib.meta.mobs.minecart;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.Metadata;

public class FurnaceMinecartMeta extends BaseMinecartMeta {

    public static final byte OFFSET = BaseMinecartMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 1;

    public FurnaceMinecartMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    public boolean isHasFuel() {
        return super.metadata.getIndex(OFFSET, false);
    }

    public void setHasFuel(boolean value) {
        super.metadata.setIndex(OFFSET, EntityDataTypes.BOOLEAN, value);
    }

    @Override
    public int getObjectData() {
        return 2;    }
}
