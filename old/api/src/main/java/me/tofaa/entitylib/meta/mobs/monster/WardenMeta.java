package me.tofaa.entitylib.meta.mobs.monster;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.MobMeta;

public class WardenMeta extends MobMeta {

    public static final byte OFFSET = MobMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 1;

    public WardenMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    public int getAngerLevel() {
        return super.metadata.getIndex(OFFSET, 0);
    }

    public void setAngerLevel(int value) {
        if (getAngerLevel() == value) {
            return;
        }
        super.metadata.setIndex(OFFSET, EntityDataTypes.INT, value);
    }
}
