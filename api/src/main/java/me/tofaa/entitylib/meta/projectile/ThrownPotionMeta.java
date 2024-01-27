package me.tofaa.entitylib.meta.projectile;

import com.github.retrooper.packetevents.protocol.item.ItemStack;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.ItemContainerMeta;

public class ThrownPotionMeta extends ItemContainerMeta {

    public static final byte OFFSET = ItemContainerMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 0;

    public ThrownPotionMeta(int entityId, Metadata metadata) {
        super(entityId, metadata, ItemStack.EMPTY);
    }


}
