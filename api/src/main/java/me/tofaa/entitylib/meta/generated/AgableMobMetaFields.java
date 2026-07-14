package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Agable Mob.
 */
public final class AgableMobMetaFields {
    public static final MetaField<Boolean> BABY = MetaField.booleanBuilder("BABY")
    .defaultValue(false)
    .versionRange(498, 498, 14, EntityDataTypes.BOOLEAN)
    .versionRange(573, 2147483647, 15, EntityDataTypes.BOOLEAN)
    .build();

    private AgableMobMetaFields() {
    }
}
