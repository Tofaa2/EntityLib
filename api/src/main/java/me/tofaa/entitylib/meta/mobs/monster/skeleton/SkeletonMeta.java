package me.tofaa.entitylib.meta.mobs.monster.skeleton;

import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.MobMeta;

public class SkeletonMeta extends MobMeta {

    public static final byte OFFSET = MobMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 0;

    public SkeletonMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }
}
