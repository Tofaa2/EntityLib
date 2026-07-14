package me.tofaa.entitylib.meta.mobs.monster;

import me.tofaa.entitylib.meta.Metadata;

public class CaveSpiderMeta extends SpiderMeta{

    public static final byte OFFSET = SpiderMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 0;

    public CaveSpiderMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }
}
