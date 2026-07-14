package me.tofaa.entitylib.meta.projectile;

import com.github.retrooper.packetevents.protocol.item.ItemStack;
import com.github.retrooper.packetevents.protocol.item.type.ItemTypes;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.ItemContainerMeta;

public class ThrownEnderPearlMeta extends ItemContainerMeta {

    public static final byte OFFSET = ItemContainerMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 0;

    private static final ItemStack ENDER_PEARL = ItemStack.builder().type(ItemTypes.ENDER_PEARL).build();

    public ThrownEnderPearlMeta(int entityId, Metadata metadata) {
        super(entityId, metadata, ENDER_PEARL);
    }

}
