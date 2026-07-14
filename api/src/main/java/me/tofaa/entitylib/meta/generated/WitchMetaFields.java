package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Witch.
 */
public final class WitchMetaFields {
    public static final MetaField<Boolean> USING_ITEM = MetaField.booleanBuilder("USING_ITEM")
    .defaultValue(false)
    .versionRange(498, 498, 15, EntityDataTypes.BOOLEAN)
    .versionRange(573, 751, 16, EntityDataTypes.BOOLEAN)
    .versionRange(755, 2147483647, 17, EntityDataTypes.BOOLEAN)
    .build();

    private WitchMetaFields() {
    }
}
