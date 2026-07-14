package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Fishing Hook.
 */
public final class FishingHookMetaFields {
    public static final MetaField<Integer> HOOKED_ENTITY = MetaField.intBuilder("HOOKED_ENTITY")
    .defaultValue(0)
    .versionRange(498, 751, 7, EntityDataTypes.INT)
    .versionRange(755, 2147483647, 8, EntityDataTypes.INT)
    .build();

    public static final MetaField<Boolean> BITING = MetaField.booleanBuilder("BITING")
    .defaultValue(false)
    .versionRange(735, 751, 8, EntityDataTypes.BOOLEAN)
    .versionRange(755, 2147483647, 9, EntityDataTypes.BOOLEAN)
    .build();

    private FishingHookMetaFields() {
    }
}
