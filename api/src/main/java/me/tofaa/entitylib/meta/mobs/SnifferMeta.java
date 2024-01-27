package me.tofaa.entitylib.meta.mobs;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.entity.sniffer.SnifferState;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.AgeableMeta;

public class SnifferMeta extends AgeableMeta {

    public static final byte OFFSET = AgeableMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 1;

    public SnifferMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    public SnifferState getState() {
        return metadata.getIndex(OFFSET, SnifferState.IDLING);
    }

    public void setState(SnifferState state) {
        super.metadata.setIndex(OFFSET, EntityDataTypes.SNIFFER_STATE, state);
    }

    public int getDropSeedAtTick() {
        return metadata.getIndex(offset(OFFSET, 1), 0);
    }

    public void setDropSeedAtTick(int tick) {
        super.metadata.setIndex(offset(OFFSET, 1), EntityDataTypes.INT, tick);
    }

}
