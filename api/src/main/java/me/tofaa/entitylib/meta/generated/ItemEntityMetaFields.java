package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Item Entity.
 */
public final class ItemEntityMetaFields {
    public static final MetaField<Object> ITEM = MetaField.builder("ITEM")
    .versionRange(498, 751, 7, EntityDataTypes.ITEMSTACK)
    .versionRange(755, 2147483647, 8, EntityDataTypes.ITEMSTACK)
    .build();

    private ItemEntityMetaFields() {
    }
}
