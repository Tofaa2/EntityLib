package me.tofaa.entitylib.meta.mobs.monster.raider;

import me.tofaa.entitylib.meta.Metadata;

public class IllusionerMeta extends SpellcasterIllagerMeta {

    public static final byte OFFSET = SpellcasterIllagerMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 0;

    public IllusionerMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }
}
