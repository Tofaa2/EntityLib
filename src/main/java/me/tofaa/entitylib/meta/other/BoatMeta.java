package me.tofaa.entitylib.meta.other;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.EntityMeta;
import me.tofaa.entitylib.meta.Metadata;
import org.jetbrains.annotations.NotNull;

public class BoatMeta extends EntityMeta {

    public static final byte OFFSET = EntityMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 7;

    public BoatMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    public int getTimeSinceLastHit() {
        return super.metadata.getIndex(OFFSET, 0);
    }

    public void setTimeSinceLastHit(int value) {
        super.metadata.setIndex(OFFSET, EntityDataTypes.INT, value);
    }

    public int getForwardDirection() {
        return super.metadata.getIndex(offset(OFFSET, 1), 1);
    }

    public void setForwardDirection(int value) {
        super.metadata.setIndex(offset(OFFSET, 1), EntityDataTypes.INT, value);
    }

    public float getDamageTaken() {
        return super.metadata.getIndex(offset(OFFSET, 2), 0);
    }

    public void setDamageTaken(float value) {
        super.metadata.setIndex(offset(OFFSET, 2), EntityDataTypes.FLOAT, value);
    }

    @NotNull
    public Type getType() {
        return Type.VALUES[super.metadata.getIndex(offset(OFFSET, 3), 0)];
    }

    public void setType(@NotNull Type value) {
        super.metadata.setIndex(offset(OFFSET, 3), EntityDataTypes.INT, value.ordinal());
    }

    public boolean isLeftPaddleTurning() {
        return super.metadata.getIndex(offset(OFFSET, 4), false);
    }

    public void setLeftPaddleTurning(boolean value) {
        super.metadata.setIndex(offset(OFFSET, 4), EntityDataTypes.BOOLEAN, value);
    }

    public boolean isRightPaddleTurning() {
        return super.metadata.getIndex(offset(OFFSET, 5), false);
    }

    public void setRightPaddleTurning(boolean value) {
        super.metadata.setIndex(offset(OFFSET, 5), EntityDataTypes.BOOLEAN, value);
    }

    public int getSplashTimer() {
        return super.metadata.getIndex(offset(OFFSET, 6), 0);
    }

    public void setSplashTimer(int value) {
        super.metadata.setIndex(offset(OFFSET, 6), EntityDataTypes.INT, value);
    }

    public enum Type {
        OAK,
        SPRUCE,
        BIRCH,
        JUNGLE,
        ACACIA,
        DARK_OAK;

        private final static Type[] VALUES = values();
    }


}
