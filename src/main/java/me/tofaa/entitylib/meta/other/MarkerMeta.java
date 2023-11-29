package me.tofaa.entitylib.meta.other;

import me.tofaa.entitylib.meta.EntityMeta;
import me.tofaa.entitylib.meta.Metadata;

public class MarkerMeta extends EntityMeta {

    public static final byte OFFSET = EntityMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 0;

    public MarkerMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }
}
