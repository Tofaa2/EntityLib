package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Abstract Chested Horse.
 */
public final class AbstractChestedHorseMetaFields {
    public static final MetaField<Boolean> CHEST = MetaField.booleanBuilder("CHEST")
    .defaultValue(false)
    .versionRange(498, 498, 17, EntityDataTypes.BOOLEAN)
    .versionRange(573, 751, 18, EntityDataTypes.BOOLEAN)
    .versionRange(755, 761, 19, EntityDataTypes.BOOLEAN)
    .versionRange(762, 773, 18, EntityDataTypes.BOOLEAN)
    .versionRange(774, 2147483647, 19, EntityDataTypes.BOOLEAN)
    .build();

    private AbstractChestedHorseMetaFields() {
    }
}
