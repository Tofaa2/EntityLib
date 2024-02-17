package me.tofaa.entitylib.meta.mobs;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.AgeableMeta;

public class GoatMeta extends AgeableMeta {

    public static final byte OFFSET = AgeableMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 1;


    public GoatMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    public boolean isScreaming() {
        return metadata.getIndex(OFFSET, false);
    }

    public void setScreaming(boolean screaming) {
        metadata.setIndex(OFFSET, EntityDataTypes.BOOLEAN, screaming);
    }

}
