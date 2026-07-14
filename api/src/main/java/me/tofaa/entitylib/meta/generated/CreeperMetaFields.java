package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Creeper.
 */
public final class CreeperMetaFields {
    public static final MetaField<Integer> SWELL_DIR = MetaField.intBuilder("SWELL_DIR")
    .defaultValue(0)
    .versionRange(498, 498, 14, EntityDataTypes.INT)
    .versionRange(573, 751, 15, EntityDataTypes.INT)
    .versionRange(755, 2147483647, 16, EntityDataTypes.INT)
    .build();

    public static final MetaField<Boolean> IS_POWERED = MetaField.booleanBuilder("IS_POWERED")
    .defaultValue(false)
    .versionRange(498, 498, 15, EntityDataTypes.BOOLEAN)
    .versionRange(573, 751, 16, EntityDataTypes.BOOLEAN)
    .versionRange(755, 2147483647, 17, EntityDataTypes.BOOLEAN)
    .build();

    public static final MetaField<Boolean> IS_IGNITED = MetaField.booleanBuilder("IS_IGNITED")
    .defaultValue(false)
    .versionRange(498, 498, 16, EntityDataTypes.BOOLEAN)
    .versionRange(573, 751, 17, EntityDataTypes.BOOLEAN)
    .versionRange(755, 2147483647, 18, EntityDataTypes.BOOLEAN)
    .build();

    private CreeperMetaFields() {
    }
}
