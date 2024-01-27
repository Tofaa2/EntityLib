package me.tofaa.entitylib.meta.mobs.horse;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.Metadata;

public class ChestedHorseMeta extends BaseHorseMeta {

    public static final byte OFFSET = BaseHorseMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 1;

    public ChestedHorseMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    public boolean isHasChest() {
        return super.metadata.getIndex(OFFSET, false);
    }

    public void setHasChest(boolean value) {
        super.metadata.setIndex(OFFSET, EntityDataTypes.BOOLEAN, value);
    }


}
