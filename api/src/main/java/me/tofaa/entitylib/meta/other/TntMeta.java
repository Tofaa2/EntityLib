package me.tofaa.entitylib.meta.other;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.world.states.type.StateTypes;
import me.tofaa.entitylib.meta.EntityMeta;
import me.tofaa.entitylib.meta.Metadata;

public class TntMeta extends EntityMeta {
    public static final byte OFFSET = EntityMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 2;

    public TntMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    public int getFuseTime() {
        return super.metadata.getIndex(OFFSET, 80);
    }

    public void setFuseTime(int value) {
        super.metadata.setIndex(OFFSET, EntityDataTypes.INT, value);
    }

    public int getBlockData() {
        return super.metadata.getIndex(offset(OFFSET, 1), StateTypes.TNT.createBlockState().getGlobalId());
    }

    public void setBlockData(int blockData) {
        super.metadata.setIndex(offset(OFFSET, 1), EntityDataTypes.BLOCK_STATE, blockData);
    }
}
