package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.Metadata;

import java.util.Optional;
import java.util.UUID;

public class TameableMeta extends AgeableMeta{

    public static final byte OFFSET = AgeableMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 2;

    private final static byte SITTING_BIT = 0x01;
    private final static byte TAMED_BIT = 0x04;

    public TameableMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }


    public boolean isSitting() {
        return getMaskBit(OFFSET, SITTING_BIT);
    }

    public void setSitting(boolean value) {
        setMaskBit(OFFSET, SITTING_BIT, value);
    }

    public boolean isTamed() {
        return getMaskBit(OFFSET, TAMED_BIT);
    }

    public void setTamed(boolean value) {
        setMaskBit(OFFSET, TAMED_BIT, value);
    }

    public Optional<UUID> getOwner() {
        return super.metadata.getIndex(offset(OFFSET, 1), Optional.empty());
    }

    public void setOwner(UUID value) {
        super.metadata.setIndex(offset(OFFSET, 1), EntityDataTypes.OPTIONAL_UUID, Optional.ofNullable(value));
    }

}
