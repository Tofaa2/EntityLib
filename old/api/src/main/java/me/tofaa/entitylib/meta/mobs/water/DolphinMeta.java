package me.tofaa.entitylib.meta.mobs.water;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.util.Vector3i;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.WaterMobMeta;
import org.jetbrains.annotations.NotNull;

public class DolphinMeta extends WaterMobMeta {

    public static final byte OFFSET = WaterMobMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 3;

    public DolphinMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    @NotNull
    public Vector3i getTreasurePosition() {
        return super.metadata.getIndex(OFFSET, Vector3i.zero());
    }

    public void setTreasurePosition(@NotNull Vector3i value) {
        super.metadata.setIndex(OFFSET, EntityDataTypes.BLOCK_POSITION, value);
    }

    public boolean isCanFindTreasure() {
        return super.metadata.getIndex(offset(OFFSET, 1), false);
    }

    public void setCanFindTreasure(boolean value) {
        super.metadata.setIndex(offset(OFFSET, 1), EntityDataTypes.BOOLEAN, value);
    }

    public boolean isHasFish() {
        return super.metadata.getIndex(offset(OFFSET, 2), false);
    }

    public void setHasFish(boolean value) {
        super.metadata.setIndex(offset(OFFSET, 2), EntityDataTypes.BOOLEAN, value);
    }

}
