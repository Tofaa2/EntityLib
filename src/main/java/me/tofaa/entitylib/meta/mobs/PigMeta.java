package me.tofaa.entitylib.meta.mobs;

import com.github.retrooper.packetevents.manager.server.ServerVersion;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.AgeableMeta;

public class PigMeta extends AgeableMeta {

    public static final byte OFFSET = AgeableMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 2;

    public PigMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    public boolean hasSaddle() {
        return super.metadata.getIndex(OFFSET, false);
    }

    public void setHasSaddle(boolean value) {
        super.metadata.setIndex(OFFSET, EntityDataTypes.BOOLEAN, value);
    }

    public int getTimeToBoost() {
        isVersionNewer(ServerVersion.V_1_16);
        return super.metadata.getIndex(offset(OFFSET,1), 0);
    }

    public void setTimeToBoost(int value) {
        isVersionNewer(ServerVersion.V_1_16);
        super.metadata.setIndex(offset(OFFSET,1), EntityDataTypes.INT, value);
    }
}
