package me.tofaa.entitylib.meta.mobs.horse;

import me.tofaa.entitylib.meta.Metadata;

public class MuleMeta extends ChestedHorseMeta{

    public static final byte OFFSET = ChestedHorseMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 0;

    public MuleMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }
}
