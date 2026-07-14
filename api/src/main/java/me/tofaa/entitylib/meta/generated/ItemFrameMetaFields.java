package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Item Frame.
 */
public final class ItemFrameMetaFields {
    public static final MetaField<Object> ITEM = MetaField.builder("ITEM")
    .versionRange(498, 751, 7, EntityDataTypes.ITEMSTACK)
    .versionRange(755, 770, 8, EntityDataTypes.ITEMSTACK)
    .versionRange(771, 2147483647, 9, EntityDataTypes.ITEMSTACK)
    .build();

    public static final MetaField<Integer> ROTATION = MetaField.intBuilder("ROTATION")
    .defaultValue(0)
    .versionRange(498, 751, 8, EntityDataTypes.INT)
    .versionRange(755, 770, 9, EntityDataTypes.INT)
    .versionRange(771, 2147483647, 10, EntityDataTypes.INT)
    .build();

    private ItemFrameMetaFields() {
    }
}
