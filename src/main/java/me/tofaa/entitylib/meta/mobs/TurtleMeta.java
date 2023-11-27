package me.tofaa.entitylib.meta.mobs;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.util.Vector3i;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.AgeableMeta;

public class TurtleMeta extends AgeableMeta {

    public static final byte OFFSET = AgeableMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 6;

    public TurtleMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }


    public Vector3i getHomePosition() {
        return super.metadata.getIndex(OFFSET, Vector3i.zero());
    }

    public void setBlockPosition(Vector3i value) {
        super.metadata.setIndex(OFFSET, EntityDataTypes.BLOCK_POSITION, value);
    }

    public boolean hasEgg() {
        return super.metadata.getIndex(offset(OFFSET,1), false);
    }

    public void setHasEgg(boolean value) {
        super.metadata.setIndex(offset(OFFSET,1), EntityDataTypes.BOOLEAN, value);
    }

    public boolean isLayingEgg() {
        return super.metadata.getIndex(offset(OFFSET,2), false);
    }

    public void setLayingEgg(boolean value) {
        super.metadata.setIndex(offset(OFFSET,2), EntityDataTypes.BOOLEAN, value);
    }

    public  Vector3i getTravelPosition() {
        return super.metadata.getIndex(offset(OFFSET,3), Vector3i.zero());
    }

    public void setTravelPosition(Vector3i value) {
        super.metadata.setIndex(offset(OFFSET,3), EntityDataTypes.BLOCK_POSITION, value);
    }

    public boolean isGoingHome() {
        return super.metadata.getIndex(offset(OFFSET,4), false);
    }

    public void setGoingHome(boolean value) {
        super.metadata.setIndex(offset(OFFSET,4), EntityDataTypes.BOOLEAN, value);
    }

    public boolean isTravelling() {
        return super.metadata.getIndex(offset(OFFSET,5), false);
    }

    public void setTravelling(boolean value) {
        super.metadata.setIndex(offset(OFFSET,4), EntityDataTypes.BOOLEAN, value);
    }

}
