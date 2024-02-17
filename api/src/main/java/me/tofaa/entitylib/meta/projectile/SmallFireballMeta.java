package me.tofaa.entitylib.meta.projectile;

import com.github.retrooper.packetevents.protocol.item.ItemStack;
import com.github.retrooper.packetevents.protocol.item.type.ItemTypes;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.ItemContainerMeta;
import me.tofaa.entitylib.meta.types.ObjectData;
import me.tofaa.entitylib.meta.types.ProjectileMeta;

public class SmallFireballMeta extends ItemContainerMeta implements ObjectData, ProjectileMeta {


    public static final byte OFFSET = ItemContainerMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 0;

    public static final ItemStack SMALL_FIREBALL = ItemStack.builder().type(ItemTypes.FIRE_CHARGE).build();

    private int shooterId = -1;

    public SmallFireballMeta(int entityId, Metadata meta) {
        super(entityId, meta, SMALL_FIREBALL);
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
