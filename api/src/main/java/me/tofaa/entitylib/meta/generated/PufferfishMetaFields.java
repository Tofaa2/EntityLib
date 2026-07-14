package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Pufferfish.
 */
public final class PufferfishMetaFields {
    public static final MetaField<Integer> PUFF_STATE = MetaField.intBuilder("PUFF_STATE")
    .defaultValue(0)
    .versionRange(498, 498, 15, EntityDataTypes.INT)
    .versionRange(573, 751, 16, EntityDataTypes.INT)
    .versionRange(755, 2147483647, 17, EntityDataTypes.INT)
    .build();

    private PufferfishMetaFields() {
    }
}
