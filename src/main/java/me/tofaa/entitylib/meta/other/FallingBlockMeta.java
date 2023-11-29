package me.tofaa.entitylib.meta.other;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.util.Vector3i;
import me.tofaa.entitylib.meta.EntityMeta;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.ObjectData;

public class FallingBlockMeta extends EntityMeta implements ObjectData {

    public static final byte OFFSET = EntityMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 1;

    private int blockStateId;

    public FallingBlockMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    public Vector3i getSpawnPosition() {
        return super.metadata.getIndex(OFFSET, Vector3i.zero());
    }

    public void setSpawnPosition(Vector3i value) {
        super.metadata.setIndex(OFFSET, EntityDataTypes.BLOCK_POSITION, value);
    }


    public int getBlockStateId() {
        return blockStateId;
    }

    public void setBlockStateId(int blockStateId) {
        this.blockStateId = blockStateId;
    }

    @Override
    public int getObjectData() {
        return blockStateId;
    }

    @Override
    public boolean requiresVelocityPacketAtSpawn() {
        return false;
    }
}
