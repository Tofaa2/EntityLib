package me.tofaa.entitylib.meta.mobs;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.AgeableMeta;

public class HoglinMeta extends AgeableMeta {

    public static final byte OFFSET = AgeableMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 1;

    public HoglinMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }


    public boolean isImmuneToZombification() {
        return super.metadata.getIndex(OFFSET, false);
    }

    public void setImmuneToZombification(boolean value) {
        super.metadata.setIndex(OFFSET, EntityDataTypes.BOOLEAN, value);
    }


}
