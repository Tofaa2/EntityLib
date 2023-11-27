package me.tofaa.entitylib.meta.mobs.other;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.EntityMeta;
import me.tofaa.entitylib.meta.Metadata;

public class AreaEffectCloudMeta extends EntityMeta {

    public static final byte OFFSET = EntityMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 4;

    public AreaEffectCloudMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    public float getRadius() {
        return super.metadata.getIndex(OFFSET, .5F);
    }

    public void setRadius(float value) {
        super.metadata.setIndex(OFFSET, EntityDataTypes.FLOAT, value);
    }

    public int getColor() {
        return super.metadata.getIndex(offset(OFFSET, 1), 0);
    }

    public void setColor(int value) {
        super.metadata.setIndex(offset(OFFSET, 1), EntityDataTypes.INT, value);
    }

    public boolean isSinglePoint() {
        return super.metadata.getIndex(offset(OFFSET, 2), false);
    }

    public void setSinglePoint(boolean value) {
        super.metadata.setIndex(offset(OFFSET, 2), EntityDataTypes.BOOLEAN, value);
    }

}
