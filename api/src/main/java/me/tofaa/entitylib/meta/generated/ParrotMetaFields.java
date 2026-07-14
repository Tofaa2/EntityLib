package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Parrot.
 */
public final class ParrotMetaFields {
    public static final MetaField<Integer> VARIANT = MetaField.intBuilder("VARIANT")
    .defaultValue(0)
    .versionRange(498, 498, 17, EntityDataTypes.INT)
    .versionRange(573, 751, 18, EntityDataTypes.INT)
    .versionRange(755, 773, 19, EntityDataTypes.INT)
    .versionRange(774, 2147483647, 20, EntityDataTypes.INT)
    .build();

    private ParrotMetaFields() {
    }
}
