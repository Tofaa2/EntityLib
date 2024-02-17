package me.tofaa.entitylib.meta.mobs.water;

import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.WaterMobMeta;

public class SquidMeta extends WaterMobMeta {

    public static final byte OFFSET = WaterMobMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 0;

    public SquidMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }
}
