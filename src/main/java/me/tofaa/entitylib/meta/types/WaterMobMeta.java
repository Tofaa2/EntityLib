package me.tofaa.entitylib.meta.types;

import me.tofaa.entitylib.meta.Metadata;

public class WaterMobMeta extends MobMeta {

    public static final byte OFFSET = MobMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 0;

    public WaterMobMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }
}
