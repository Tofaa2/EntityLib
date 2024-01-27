package me.tofaa.entitylib.meta.mobs.monster.raider;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.MobMeta;

public class RaiderMeta extends MobMeta {

    public static final byte OFFSET = MobMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 1;

    public RaiderMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    public boolean isCelebrating() {
        return super.metadata.getIndex(OFFSET, false);
    }

    public void setCelebrating(boolean value) {
        super.metadata.setIndex(OFFSET, EntityDataTypes.BOOLEAN, value);
    }


}
