package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Polar Bear.
 */
public final class PolarBearMetaFields {
    public static final MetaField<Boolean> STANDING = MetaField.booleanBuilder("STANDING")
    .defaultValue(false)
    .versionRange(498, 498, 15, EntityDataTypes.BOOLEAN)
    .versionRange(573, 751, 16, EntityDataTypes.BOOLEAN)
    .versionRange(755, 773, 17, EntityDataTypes.BOOLEAN)
    .versionRange(774, 2147483647, 18, EntityDataTypes.BOOLEAN)
    .build();

    private PolarBearMetaFields() {
    }
}
