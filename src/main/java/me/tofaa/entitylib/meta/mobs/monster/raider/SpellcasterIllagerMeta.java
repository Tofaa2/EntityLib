package me.tofaa.entitylib.meta.mobs.monster.raider;

import me.tofaa.entitylib.meta.Metadata;

public class SpellcasterIllagerMeta extends RaiderMeta{

    public static final byte OFFSET = RaiderMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 1;

    public SpellcasterIllagerMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }
}
