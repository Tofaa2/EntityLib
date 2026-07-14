package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Zombie.
 */
public final class ZombieMetaFields {
    public static final MetaField<Boolean> BABY = MetaField.booleanBuilder("BABY")
    .defaultValue(false)
    .versionRange(498, 498, 14, EntityDataTypes.BOOLEAN)
    .versionRange(573, 751, 15, EntityDataTypes.BOOLEAN)
    .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
    .build();

    public static final MetaField<Integer> SPECIAL_TYPE = MetaField.intBuilder("SPECIAL_TYPE")
    .defaultValue(0)
    .versionRange(498, 498, 15, EntityDataTypes.INT)
    .versionRange(573, 751, 16, EntityDataTypes.INT)
    .versionRange(755, 2147483647, 17, EntityDataTypes.INT)
    .build();

    public static final MetaField<Boolean> DROWNED_CONVERSION = MetaField.booleanBuilder("DROWNED_CONVERSION")
    .defaultValue(false)
    .versionRange(498, 498, 16, EntityDataTypes.BOOLEAN)
    .versionRange(573, 751, 17, EntityDataTypes.BOOLEAN)
    .versionRange(755, 2147483647, 18, EntityDataTypes.BOOLEAN)
    .build();

    private ZombieMetaFields() {
    }
}
