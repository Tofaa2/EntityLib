package me.tofaa.entitylib.meta.mobs;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.AgeableMeta;

public class BeeMeta extends AgeableMeta {

    public static final byte OFFSET = AgeableMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 2;

    private final static byte ANGRY_BIT = 0x02;
    private final static byte HAS_STUNG_BIT = 0x04;
    private final static byte HAS_NECTAR_BIT = 0x08;

    public BeeMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    public boolean isAngry() {
        return getMaskBit(OFFSET, ANGRY_BIT);
    }

    public void setAngry(boolean value) {
        setMaskBit(OFFSET, ANGRY_BIT, value);
    }

    public boolean hasStung() {
        return getMaskBit(OFFSET, HAS_STUNG_BIT);
    }

    public void setHasStung(boolean value) {
        setMaskBit(OFFSET, HAS_STUNG_BIT, value);
    }

    public boolean hasNectar() {
        return getMaskBit(OFFSET, HAS_NECTAR_BIT);
    }

    public void setHasNectar(boolean value) {
        setMaskBit(OFFSET, HAS_NECTAR_BIT, value);
    }

    public int getAngerTicks() {
        return super.metadata.getIndex(offset(OFFSET,1), 0);
    }

    public void setAngerTicks(int value) {
        super.metadata.setIndex(offset(OFFSET,1), EntityDataTypes.INT, value);
    }

}
