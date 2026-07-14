package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Ender Dragon.
 */
public final class EnderDragonMetaFields {
    public static final MetaField<Integer> PHASE = MetaField.intBuilder("PHASE")
    .defaultValue(0)
    .versionRange(498, 498, 14, EntityDataTypes.INT)
    .versionRange(573, 751, 15, EntityDataTypes.INT)
    .versionRange(755, 2147483647, 16, EntityDataTypes.INT)
    .build();

    private EnderDragonMetaFields() {
    }
}
