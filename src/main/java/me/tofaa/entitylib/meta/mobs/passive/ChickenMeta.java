package me.tofaa.entitylib.meta.mobs.passive;

import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.AgeableMeta;

public class ChickenMeta extends AgeableMeta {

    public static final byte OFFSET = AgeableMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 0;

    public ChickenMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }
}
