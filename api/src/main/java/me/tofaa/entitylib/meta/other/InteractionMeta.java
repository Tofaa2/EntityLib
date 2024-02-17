package me.tofaa.entitylib.meta.other;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.EntityMeta;
import me.tofaa.entitylib.meta.Metadata;

public class InteractionMeta extends EntityMeta {

    public static final byte OFFSET = EntityMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 3;

    public InteractionMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    public float getWidth() {
        return super.metadata.getIndex(OFFSET, 1.0F);
    }

    public void setWidth(float value) {
        super.metadata.setIndex(OFFSET, EntityDataTypes.FLOAT, value);
    }

    public float getHeight() {
        return super.metadata.getIndex(offset(OFFSET, 1), 1.0F);
    }

    public void setHeight(float value) {
        super.metadata.setIndex(offset(OFFSET, 1), EntityDataTypes.FLOAT, value);
    }

    public boolean isResponsive() {
        return super.metadata.getIndex(offset(OFFSET, 2), false);
    }

    public void setResponsive(boolean value) {
        super.metadata.setIndex(offset(OFFSET, 2), EntityDataTypes.BOOLEAN, value);
    }


}
