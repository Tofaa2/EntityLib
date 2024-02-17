package me.tofaa.entitylib.meta.projectile;

import me.tofaa.entitylib.meta.EntityMeta;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.ObjectData;

public class ShulkerBulletMeta extends EntityMeta implements ObjectData {

    public static final byte OFFSET = EntityMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 0;

    public ShulkerBulletMeta(int entityId, Metadata metadata) {
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
