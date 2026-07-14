package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Raider.
 */
public final class RaiderMetaFields {
    public static final MetaField<Boolean> IS_CELEBRATING = MetaField.booleanBuilder("IS_CELEBRATING")
    .defaultValue(false)
    .versionRange(498, 498, 14, EntityDataTypes.BOOLEAN)
    .versionRange(573, 751, 15, EntityDataTypes.BOOLEAN)
    .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
    .build();

    private RaiderMetaFields() {
    }
}
