package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Happy Ghast.
 */
public final class HappyGhastMetaFields {
    public static final MetaField<Boolean> IS_LEASH_HOLDER = MetaField.booleanBuilder("IS_LEASH_HOLDER")
    .defaultValue(false)
    .versionRange(771, 773, 17, EntityDataTypes.BOOLEAN)
    .versionRange(774, 2147483647, 18, EntityDataTypes.BOOLEAN)
    .build();

    public static final MetaField<Boolean> STAYS_STILL = MetaField.booleanBuilder("STAYS_STILL")
    .defaultValue(false)
    .versionRange(771, 773, 18, EntityDataTypes.BOOLEAN)
    .versionRange(774, 2147483647, 19, EntityDataTypes.BOOLEAN)
    .build();

    private HappyGhastMetaFields() {
    }
}
