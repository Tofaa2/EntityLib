package me.tofaa.entitylib.meta.mobs;

import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.AgeableMeta;

public class CowMeta extends AgeableMeta {

    public static final byte OFFSET = AgeableMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 0;

    public CowMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }
}
