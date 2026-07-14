package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Camel.
 */
public final class CamelMetaFields {
    public static final MetaField<Boolean> DASH = MetaField.booleanBuilder("DASH")
    .defaultValue(false)
    .versionRange(761, 761, 19, EntityDataTypes.BOOLEAN)
    .versionRange(762, 773, 18, EntityDataTypes.BOOLEAN)
    .versionRange(774, 2147483647, 19, EntityDataTypes.BOOLEAN)
    .build();

    public static final MetaField<Long> LAST_POSE_CHANGE_TICK = MetaField.longBuilder("LAST_POSE_CHANGE_TICK")
    .defaultValue(0L)
    .versionRange(761, 761, 20, EntityDataTypes.LONG)
    .versionRange(762, 773, 19, EntityDataTypes.LONG)
    .versionRange(774, 2147483647, 20, EntityDataTypes.LONG)
    .build();

    private CamelMetaFields() {
    }
}
