package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Item Display.
 */
public final class ItemDisplayMetaFields {
    public static final MetaField<Object> ITEM_STACK = MetaField.builder("ITEM_STACK")
    .versionRange(762, 762, 22, EntityDataTypes.ITEMSTACK)
    .versionRange(764, 2147483647, 23, EntityDataTypes.ITEMSTACK)
    .build();

    public static final MetaField<Byte> ITEM_DISPLAY = MetaField.byteBuilder("ITEM_DISPLAY")
    .defaultValue((byte) 0)
    .versionRange(762, 762, 23, EntityDataTypes.BYTE)
    .versionRange(764, 2147483647, 24, EntityDataTypes.BYTE)
    .build();

    private ItemDisplayMetaFields() {
    }
}
