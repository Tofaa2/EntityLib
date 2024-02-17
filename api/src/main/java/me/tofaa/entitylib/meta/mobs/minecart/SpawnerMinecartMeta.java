package me.tofaa.entitylib.meta.mobs.minecart;

import me.tofaa.entitylib.meta.Metadata;

public class SpawnerMinecartMeta extends BaseMinecartMeta {

    public static final byte OFFSET = BaseMinecartMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 0;

    public SpawnerMinecartMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    @Override
    public int getObjectData() {
        return 4;
    }

}
