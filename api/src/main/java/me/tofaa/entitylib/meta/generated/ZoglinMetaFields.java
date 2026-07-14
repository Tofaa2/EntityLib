package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Zoglin.
 */
public final class ZoglinMetaFields {
    public static final MetaField<Boolean> BABY = MetaField.booleanBuilder("BABY")
    .defaultValue(false)
    .versionRange(735, 751, 15, EntityDataTypes.BOOLEAN)
    .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
    .build();

    private ZoglinMetaFields() {
    }
}
