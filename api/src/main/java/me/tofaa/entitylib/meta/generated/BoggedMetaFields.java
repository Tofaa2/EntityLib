package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Bogged.
 */
public final class BoggedMetaFields {
    public static final MetaField<Boolean> SHEARED = MetaField.booleanBuilder("SHEARED")
    .defaultValue(false)
    .versionRange(766, 2147483647, 16, EntityDataTypes.BOOLEAN)
    .build();

    private BoggedMetaFields() {
    }
}
