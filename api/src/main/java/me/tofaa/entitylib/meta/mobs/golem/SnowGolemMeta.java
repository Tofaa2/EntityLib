package me.tofaa.entitylib.meta.mobs.golem;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.MobMeta;

public class SnowGolemMeta extends MobMeta {

    public static final byte OFFSET = MobMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 1;

    public SnowGolemMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    public boolean isHasPumpkinHat() {
        return super.metadata.getIndex(OFFSET, (byte) 0x10) == (byte) 0x10;
    }

    public void setHasPumpkinHat(boolean value) {
        byte var = value ? (byte) 0x10 : (byte) 0x00;
        super.metadata.setIndex(OFFSET, EntityDataTypes.BYTE, var);
    }

}
