package me.tofaa.entitylib.meta.mobs.horse;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.Metadata;

public class CamelMeta extends BaseHorseMeta {

    public static final byte OFFSET = BaseHorseMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 2;

    public CamelMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    public boolean isDashing() {
        return super.metadata.getIndex(OFFSET, false);
    }

    public void setDashing(boolean value) {
        super.metadata.setIndex(OFFSET, EntityDataTypes.BOOLEAN, value);
    }

    public long getLastPoseChangeTick() {
        return super.metadata.getIndex(offset(OFFSET, 1), 0L);
    }

    public void setLastPoseChangeTick(long value) {
        super.metadata.setIndex(offset(OFFSET, 1), EntityDataTypes.LONG, value);
    }
}
