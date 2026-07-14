package me.tofaa.entitylib.meta.mobs;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.AgeableMeta;
import org.jetbrains.annotations.NotNull;

public class PandaMeta extends AgeableMeta {

    public static final byte OFFSET = AgeableMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 6;

    private final static byte SNEEZING_BIT = 0x02;
    private final static byte ROLLING_BIT = 0x04;
    private final static byte SITTING_BIT = 0x08;
    private final static byte ON_BACK_BIT = 0x10;

    public PandaMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    public int getBreedTimer() {
        return super.metadata.getIndex(OFFSET, 0);
    }

    public void setBreedTimer(int value) {
        super.metadata.setIndex(OFFSET, EntityDataTypes.INT, value);
    }

    public int getSneezeTimer() {
        return super.metadata.getIndex(offset(OFFSET,1), 0);
    }

    public void setSneezeTimer(int value) {
        super.metadata.setIndex(offset(OFFSET,1), EntityDataTypes.INT, value);
    }

    public int getEatTimer() {
        return super.metadata.getIndex(offset(OFFSET,2), 0);
    }

    public void setEatTimer(int value) {
        super.metadata.setIndex(offset(OFFSET,2), EntityDataTypes.INT, value);
    }

    @NotNull
    public Gene getMainGene() {
        return Gene.VALUES[super.metadata.getIndex(offset(OFFSET,3), (byte) 0)];
    }

    public void setMainGene(@NotNull Gene value) {
        super.metadata.setIndex(offset(OFFSET,3), EntityDataTypes.BYTE, (byte) value.ordinal());
    }

    @NotNull
    public Gene getHiddenGene() {
        return Gene.VALUES[super.metadata.getIndex(offset(OFFSET,4), (byte) 0)];
    }

    public void setHiddenGene(@NotNull Gene value) {
        super.metadata.setIndex(offset(OFFSET,4), EntityDataTypes.BYTE, (byte) value.ordinal());
    }

    public boolean isSneezing() {
        return getMaskBit(offset(OFFSET,5), SNEEZING_BIT);
    }

    public void setSneezing(boolean value) {
        setMaskBit(offset(OFFSET,5), SNEEZING_BIT, value);
    }

    public boolean isRolling() {
        return getMaskBit(offset(OFFSET,5), ROLLING_BIT);
    }

    public void setRolling(boolean value) {
        setMaskBit(offset(OFFSET,5), ROLLING_BIT, value);
    }

    public boolean isSitting() {
        return getMaskBit(offset(OFFSET,5), SITTING_BIT);
    }

    public void setSitting(boolean value) {
        setMaskBit(offset(OFFSET,5), SITTING_BIT, value);
    }

    public boolean isOnBack() {
        return getMaskBit(offset(OFFSET,5), ON_BACK_BIT);
    }

    public void setOnBack(boolean value) {
        setMaskBit(offset(OFFSET,5), ON_BACK_BIT, value);
    }

    public enum Gene {
        NORMAL,
        AGGRESSIVE,
        LAZY,
        WORRIED,
        PLAYFUL,
        WEAK,
        BROWN;

        private final static Gene[] VALUES = values();
    }


}
