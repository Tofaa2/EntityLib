package me.tofaa.entitylib.meta.mobs.monster;

import me.tofaa.entitylib.meta.Metadata;

public class ElderGuardianMeta extends GuardianMeta{

    public static final byte OFFSET = GuardianMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 0;

    public ElderGuardianMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }
}
