package me.tofaa.entitylib.meta.mobs.cuboid;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.MobMeta;

public class SlimeMeta extends MobMeta {
    public static final byte OFFSET = MobMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 1;

    public SlimeMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    public int getSize() {
        return super.metadata.getIndex(OFFSET, 0);
    }

    public void setSize(int value) {
        super.metadata.setIndex(OFFSET, EntityDataTypes.INT, value);
    }

}
