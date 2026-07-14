package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Hoglin.
 */
public final class HoglinMetaFields {
    public static final MetaField<Boolean> IMMUNE_TO_ZOMBIFICATION = MetaField.booleanBuilder("IMMUNE_TO_ZOMBIFICATION")
    .defaultValue(false)
    .versionRange(735, 751, 16, EntityDataTypes.BOOLEAN)
    .versionRange(755, 773, 17, EntityDataTypes.BOOLEAN)
    .versionRange(774, 2147483647, 18, EntityDataTypes.BOOLEAN)
    .build();

    private HoglinMetaFields() {
    }
}
