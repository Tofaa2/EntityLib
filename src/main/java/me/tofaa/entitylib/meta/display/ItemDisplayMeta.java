package me.tofaa.entitylib.meta.display;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.item.ItemStack;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.DisplayMeta;

public class ItemDisplayMeta extends DisplayMeta {

    public static final byte OFFSET = DisplayMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 1;

    public ItemDisplayMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    public ItemStack getItem() {
        return super.metadata.getIndex(OFFSET, ItemStack.EMPTY);
    }

    public void setItem(ItemStack itemStack) {
        super.metadata.setIndex(OFFSET, EntityDataTypes.ITEMSTACK, itemStack);
    }

    public DisplayType getDisplayType() {
        return DisplayType.VALUES[super.metadata.getIndex(offset(OFFSET, 1), 0)];
    }

    public void setDisplayType(DisplayType displayType) {
        super.metadata.setIndex(offset(OFFSET, 1), EntityDataTypes.BYTE, (byte) displayType.ordinal());
    }

    public enum DisplayType {
        NONE,
        THIRD_PERSON_LEFT_HAND,
        THIRD_PERSON_RIGHT_HAND,
        FIRST_PERSON_LEFT_HAND,
        FIRST_PERSON_RIGHT_HAND,
        HEAD,
        GUI,
        GROUND,
        FIXED;

        private static final DisplayType[] VALUES = values();
    }

}
