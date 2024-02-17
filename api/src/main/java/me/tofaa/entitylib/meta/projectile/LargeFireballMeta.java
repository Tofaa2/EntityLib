package me.tofaa.entitylib.meta.projectile;

import com.github.retrooper.packetevents.protocol.item.ItemStack;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.ItemContainerMeta;
import me.tofaa.entitylib.meta.types.ObjectData;
import me.tofaa.entitylib.meta.types.ProjectileMeta;

public class LargeFireballMeta extends ItemContainerMeta implements ObjectData, ProjectileMeta {
    public static final byte OFFSET = ItemContainerMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 0;

    private int shooterId = -1;

    public LargeFireballMeta(int entityId, Metadata meta) {
        super(entityId, meta, ItemStack.EMPTY);
    }

    @Override
    public int getObjectData() {
        return this.shooterId == -1 ? 0 : this.shooterId;
    }

    @Override
    public boolean requiresVelocityPacketAtSpawn() {
        return true;
    }

    @Override
    public int getShooter() {
        return shooterId;
    }

    @Override
    public void setShooter(int entityId) {
        this.shooterId = entityId;
    }

}
