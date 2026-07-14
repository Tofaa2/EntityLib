package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Piglin.
 */
public final class PiglinMetaFields {
    public static final MetaField<Boolean> BABY = MetaField.booleanBuilder("BABY")
    .defaultValue(false)
    .versionRange(735, 735, 15, EntityDataTypes.BOOLEAN)
    .versionRange(751, 751, 16, EntityDataTypes.BOOLEAN)
    .versionRange(755, 2147483647, 17, EntityDataTypes.BOOLEAN)
    .build();

    public static final MetaField<Boolean> IMMUNE_TO_ZOMBIFICATION = MetaField.booleanBuilder("IMMUNE_TO_ZOMBIFICATION")
    .defaultValue(false)
    .versionRange(735, 2147483647, 16, EntityDataTypes.BOOLEAN)
    .build();

    public static final MetaField<Boolean> IS_CHARGING_CROSSBOW = MetaField.booleanBuilder("IS_CHARGING_CROSSBOW")
    .defaultValue(false)
    .versionRange(735, 751, 17, EntityDataTypes.BOOLEAN)
    .versionRange(755, 2147483647, 18, EntityDataTypes.BOOLEAN)
    .build();

    public static final MetaField<Boolean> IS_DANCING = MetaField.booleanBuilder("IS_DANCING")
    .defaultValue(false)
    .versionRange(735, 751, 18, EntityDataTypes.BOOLEAN)
    .versionRange(755, 2147483647, 19, EntityDataTypes.BOOLEAN)
    .build();

    private PiglinMetaFields() {
    }
}
