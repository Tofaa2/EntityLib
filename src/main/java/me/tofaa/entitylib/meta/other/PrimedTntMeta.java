package me.tofaa.entitylib.meta.other;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.EntityMeta;
import me.tofaa.entitylib.meta.Metadata;

public class PrimedTntMeta extends EntityMeta {
    public static final byte OFFSET = EntityMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 1;


    public PrimedTntMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    public int getFuseTime() {
        return super.metadata.getIndex(OFFSET, 80);
    }

    public void setFuseTime(int value) {
        super.metadata.setIndex(OFFSET, EntityDataTypes.INT, value);
    }
}
