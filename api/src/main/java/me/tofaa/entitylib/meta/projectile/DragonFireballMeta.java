package me.tofaa.entitylib.meta.projectile;

import me.tofaa.entitylib.meta.EntityMeta;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.ObjectData;
import me.tofaa.entitylib.meta.types.ProjectileMeta;

public class DragonFireballMeta extends EntityMeta implements ProjectileMeta, ObjectData {

    public static final byte OFFSET = EntityMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 0;

    private int shooter = -1;

    public DragonFireballMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    @Override
    public int getObjectData() {
        return this.shooter == -1 ? 0 : this.shooter;
    }

    @Override
    public boolean requiresVelocityPacketAtSpawn() {
        return true;
    }

    @Override
    public int getShooter() {
        return shooter;
    }

    @Override
    public void setShooter(int entityId) {
        this.shooter = entityId;
    }
}
