package me.tofaa.entitylib.meta.projectile;

import com.github.retrooper.packetevents.protocol.item.ItemStack;
import com.github.retrooper.packetevents.protocol.item.type.ItemTypes;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.ItemContainerMeta;

public class EyeOfEnderMeta extends ItemContainerMeta {


    public static final byte OFFSET = ItemContainerMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 0;

    public static final ItemStack EYE_OF_ENDER = ItemStack.builder().type(ItemTypes.ENDER_EYE).build();

    public EyeOfEnderMeta(int entityId, Metadata metadata) {
        super(entityId, metadata, EYE_OF_ENDER);
    }

}
