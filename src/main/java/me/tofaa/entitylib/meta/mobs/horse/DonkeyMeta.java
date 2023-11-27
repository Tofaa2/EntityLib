package me.tofaa.entitylib.meta.mobs.horse;

import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.MobMeta;

public class DonkeyMeta  extends ChestedHorseMeta{

    public static final byte OFFSET = MobMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 0;

    public DonkeyMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }
}
