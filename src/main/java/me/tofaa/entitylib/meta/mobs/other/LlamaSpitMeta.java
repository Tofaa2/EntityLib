package me.tofaa.entitylib.meta.mobs.other;

import me.tofaa.entitylib.meta.EntityMeta;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.ObjectData;

public class LlamaSpitMeta extends EntityMeta implements ObjectData {
    public static final byte OFFSET = EntityMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 0;

    public LlamaSpitMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }


    @Override
    public int getObjectData() {
        return 0;
    }

    @Override
    public boolean requiresVelocityPacketAtSpawn() {
        return true;
    }
}
