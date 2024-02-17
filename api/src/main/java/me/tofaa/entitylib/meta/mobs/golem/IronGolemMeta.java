package me.tofaa.entitylib.meta.mobs.golem;

import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.MobMeta;

public class IronGolemMeta extends MobMeta {

    public static final byte OFFSET = MobMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 1;

    private final static byte PLAYER_CREATED_BIT = 0x01;

    public IronGolemMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    public boolean isPlayerCreated() {
        return getMaskBit(OFFSET, PLAYER_CREATED_BIT);
    }

    public void setPlayerCreated(boolean value) {
        setMaskBit(OFFSET, PLAYER_CREATED_BIT, value);
    }


}
