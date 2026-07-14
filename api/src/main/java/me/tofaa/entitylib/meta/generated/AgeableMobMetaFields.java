package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Ageable Mob.
 */
public final class AgeableMobMetaFields {
    public static final MetaField<Boolean> BABY = MetaField.booleanBuilder("BABY")
    .defaultValue(false)
    .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
    .build();

    public static final MetaField<Boolean> AGE_LOCKED = MetaField.booleanBuilder("AGE_LOCKED")
    .defaultValue(false)
    .versionRange(774, 2147483647, 17, EntityDataTypes.BOOLEAN)
    .build();

    private AgeableMobMetaFields() {
    }
}
