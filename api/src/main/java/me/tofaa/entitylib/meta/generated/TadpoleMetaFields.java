package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Tadpole.
 */
public final class TadpoleMetaFields {
    public static final MetaField<Boolean> AGE_LOCKED = MetaField.booleanBuilder("AGE_LOCKED")
    .defaultValue(false)
    .versionRange(774, 2147483647, 17, EntityDataTypes.BOOLEAN)
    .build();

    private TadpoleMetaFields() {
    }
}
