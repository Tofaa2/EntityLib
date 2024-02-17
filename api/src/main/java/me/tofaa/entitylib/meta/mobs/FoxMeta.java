package me.tofaa.entitylib.meta.mobs;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.AgeableMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.UUID;

public class FoxMeta extends AgeableMeta {

    public static final byte OFFSET = AgeableMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET+ 4;

    private final static byte SITTING_BIT = 0x01;
    private final static byte CROUCHING_BIT = 0x04;
    private final static byte INTERESTED_BIT = 0x08;
    private final static byte POUNCING_BIT = 0x10;
    private final static byte SLEEPING_BIT = 0x20;
    private final static byte FACEPLANTED_BIT = 0x40;
    private final static byte DEFENDING_BIT = (byte) 0x80;


    public FoxMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    @NotNull
    public Type getType() {
        return Type.VALUES[super.metadata.getIndex(OFFSET, 0)];
    }

    public void setType(@NotNull Type type) {
        super.metadata.setIndex(OFFSET, EntityDataTypes.INT, type.ordinal());
    }

    public boolean isSitting() {
        return getMaskBit(offset(OFFSET, 1), SITTING_BIT);
    }

    public void setSitting(boolean value) {
        setMaskBit(offset(OFFSET, 1), SITTING_BIT, value);
    }

    public boolean isFoxSneaking() {
        return getMaskBit(offset(OFFSET, 1), CROUCHING_BIT);
    }

    public void setFoxSneaking(boolean value) {
        setMaskBit(offset(OFFSET, 1), CROUCHING_BIT, value);
    }

    public boolean isInterested() {
        return getMaskBit(offset(OFFSET, 1), INTERESTED_BIT);
    }

    public void setInterested(boolean value) {
        setMaskBit(offset(OFFSET, 1), INTERESTED_BIT, value);
    }

    public boolean isPouncing() {
        return getMaskBit(offset(OFFSET, 1), POUNCING_BIT);
    }

    public void setPouncing(boolean value) {
        setMaskBit(offset(OFFSET, 1), POUNCING_BIT, value);
    }

    public boolean isSleeping() {
        return getMaskBit(offset(OFFSET, 1), SLEEPING_BIT);
    }

    public void setSleeping(boolean value) {
        setMaskBit(offset(OFFSET, 1), SLEEPING_BIT, value);
    }

    public boolean isFaceplanted() {
        return getMaskBit(offset(OFFSET, 1), FACEPLANTED_BIT);
    }

    public void setFaceplanted(boolean value) {
        setMaskBit(offset(OFFSET, 1), FACEPLANTED_BIT, value);
    }

    public boolean isDefending() {
        return getMaskBit(offset(OFFSET, 1), DEFENDING_BIT);
    }

    public void setDefending(boolean value) {
        setMaskBit(offset(OFFSET, 1), DEFENDING_BIT, value);
    }

    public Optional<UUID> getFirstUUID() {
        return super.metadata.getIndex(offset(OFFSET, 2), Optional.empty());
    }

    public void setFirstUUID(@Nullable UUID value) {
        super.metadata.setIndex(offset(OFFSET, 2), EntityDataTypes.OPTIONAL_UUID, Optional.of(value));
    }

    public Optional<UUID> getSecondUUID() {
        return super.metadata.getIndex(offset(OFFSET, 3), Optional.empty());
    }

    public void setSecondUUID(@Nullable UUID value) {
        super.metadata.setIndex(offset(OFFSET, 3), EntityDataTypes.OPTIONAL_UUID, Optional.of(value));
    }

    public enum Type {
        RED,
        SNOW;

        private final static Type[] VALUES = values();
    }


}
