package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Horse.
 */
public final class HorseMetaFields {
    public static final MetaField<Integer> TYPE_VARIANT = MetaField.intBuilder("TYPE_VARIANT")
    .defaultValue(0)
    .versionRange(498, 498, 17, EntityDataTypes.INT)
    .versionRange(573, 751, 18, EntityDataTypes.INT)
    .versionRange(755, 761, 19, EntityDataTypes.INT)
    .versionRange(762, 773, 18, EntityDataTypes.INT)
    .versionRange(774, 2147483647, 19, EntityDataTypes.INT)
    .build();

    private HorseMetaFields() {
    }
}
