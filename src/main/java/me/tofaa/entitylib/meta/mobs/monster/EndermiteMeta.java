package me.tofaa.entitylib.meta.mobs.monster;

import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.MobMeta;

public class EndermiteMeta extends MobMeta {

    public static final byte OFFSET = MobMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 0;

    public EndermiteMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }
}
