package me.tofaa.entitylib.meta.mobs.minecart;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.EntityMeta;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.ObjectData;

public abstract class BaseMinecartMeta extends EntityMeta implements ObjectData {

    public static final byte OFFSET = EntityMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 6;

    protected BaseMinecartMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    public int getShakingPower() {
        return super.metadata.getIndex(OFFSET, 0);
    }

    public void setShakingPower(int value) {
        super.metadata.setIndex(OFFSET, EntityDataTypes.INT, value);
    }

    public int getShakingDirection() {
        return super.metadata.getIndex(offset(OFFSET, 1), 1);
    }

    public void setShakingDirection(int value) {
        super.metadata.setIndex(offset(OFFSET, 1), EntityDataTypes.INT, value);
    }

    public float getShakingMultiplier() {
        return super.metadata.getIndex(offset(OFFSET, 2), 0F);
    }

    public void setShakingMultiplier(float value) {
        super.metadata.setIndex(offset(OFFSET, 2), EntityDataTypes.FLOAT, value);
    }

    public int getCustomBlockIdAndDamage() {
        return super.metadata.getIndex(offset(OFFSET, 3), 0);
    }

    public void setCustomBlockIdAndDamage(int value) {
        super.metadata.setIndex(offset(OFFSET, 3), EntityDataTypes.INT, value);
    }

    // in 16th of a block
    public int getCustomBlockYPosition() {
        return super.metadata.getIndex(offset(OFFSET, 4), 6);
    }

    public void setCustomBlockYPosition(int value) {
        super.metadata.setIndex(offset(OFFSET, 4), EntityDataTypes.INT, value);
    }

    @Override
    public boolean requiresVelocityPacketAtSpawn() {
        return true;
    }
}
