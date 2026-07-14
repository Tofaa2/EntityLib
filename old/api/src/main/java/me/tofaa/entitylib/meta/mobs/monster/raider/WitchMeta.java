package me.tofaa.entitylib.meta.mobs.monster.raider;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.Metadata;

public class WitchMeta extends RaiderMeta {

    public static final byte OFFSET = RaiderMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 1;

    public WitchMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    public boolean isDrinkingPotion() {
        return super.metadata.getIndex(OFFSET, false);
    }

    public void setDrinkingPotion(boolean value) {
        super.metadata.setIndex(OFFSET, EntityDataTypes.BOOLEAN, value);
    }

}
