package me.tofaa.entitylib.meta.projectile;

import com.github.retrooper.packetevents.protocol.item.ItemStack;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.ItemContainerMeta;
import me.tofaa.entitylib.meta.types.ObjectData;

public class ItemEntityMeta extends ItemContainerMeta implements ObjectData {

    public static final byte OFFSET = ItemContainerMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 0;

    public ItemEntityMeta(int entityId, Metadata metadata) {
        super(entityId, metadata, ItemStack.EMPTY);
    }

    @Override
    public int getObjectData() {
        return 1;
    }

    @Override
    public boolean requiresVelocityPacketAtSpawn() {
        return true;
    }
}
