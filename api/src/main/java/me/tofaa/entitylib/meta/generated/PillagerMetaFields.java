package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Pillager.
 */
public final class PillagerMetaFields {
    public static final MetaField<Boolean> IS_CHARGING_CROSSBOW = MetaField.booleanBuilder("IS_CHARGING_CROSSBOW")
    .defaultValue(false)
    .versionRange(498, 498, 15, EntityDataTypes.BOOLEAN)
    .versionRange(573, 751, 16, EntityDataTypes.BOOLEAN)
    .versionRange(755, 2147483647, 17, EntityDataTypes.BOOLEAN)
    .build();

    private PillagerMetaFields() {
    }
}
