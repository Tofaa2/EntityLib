package me.tofaa.entitylib.meta.projectile;

import com.github.retrooper.packetevents.protocol.item.ItemStack;
import com.github.retrooper.packetevents.protocol.item.type.ItemTypes;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.ItemContainerMeta;

public class ThrownExpBottleMeta extends ItemContainerMeta {

    public static final byte OFFSET = ItemContainerMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 0;

    private static final ItemStack EXP_BOTTLE = ItemStack.builder().type(ItemTypes.EXPERIENCE_BOTTLE).build();

    public ThrownExpBottleMeta(int entityId, Metadata metadata) {
        super(entityId, metadata, EXP_BOTTLE);
    }

}
