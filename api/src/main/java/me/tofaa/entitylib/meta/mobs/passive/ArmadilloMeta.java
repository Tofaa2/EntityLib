package me.tofaa.entitylib.meta.mobs.passive;

import com.github.retrooper.packetevents.protocol.entity.armadillo.ArmadilloState;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.AgeableMeta;

public class ArmadilloMeta extends AgeableMeta {

    public static final byte OFFSET = AgeableMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 1;

    public ArmadilloMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    public ArmadilloState getState() {
        return metadata.getIndex(OFFSET, ArmadilloState.IDLE);
    }

    public void setState(ArmadilloState state) {
        super.metadata.setIndex(OFFSET, EntityDataTypes.ARMADILLO_STATE, state);
    }
}
