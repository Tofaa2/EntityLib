package me.tofaa.entitylib.meta.mobs.water;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.Metadata;

public class PufferFishMeta extends BaseFishMeta {

    public static final byte OFFSET = BaseFishMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 1;

    public PufferFishMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    public State getState() {
        return State.VALUES[super.metadata.getIndex(OFFSET, 0)];
    }

    public void setState(State state) {
        super.metadata.setIndex(OFFSET, EntityDataTypes.INT, state.ordinal());
    }


    public enum State {
        UNPUFFED,
        SEMI_PUFFED,
        FULLY_PUFFED;

        private final static State[] VALUES = values();
    }

}
