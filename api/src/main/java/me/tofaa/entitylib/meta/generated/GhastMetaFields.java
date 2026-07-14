package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Ghast.
 */
public final class GhastMetaFields {
    public static final MetaField<Boolean> IS_CHARGING = MetaField.booleanBuilder("IS_CHARGING")
    .defaultValue(false)
    .versionRange(498, 498, 14, EntityDataTypes.BOOLEAN)
    .versionRange(573, 751, 15, EntityDataTypes.BOOLEAN)
    .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
    .build();

    private GhastMetaFields() {
    }
}
