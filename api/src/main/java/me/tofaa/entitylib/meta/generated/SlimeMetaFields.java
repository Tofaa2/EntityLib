package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Slime.
 */
public final class SlimeMetaFields {
    public static final MetaField<Integer> ID_SIZE = MetaField.intBuilder("ID_SIZE")
    .defaultValue(0)
    .versionRange(498, 498, 14, EntityDataTypes.INT)
    .versionRange(573, 751, 15, EntityDataTypes.INT)
    .versionRange(755, 2147483647, 16, EntityDataTypes.INT)
    .build();

    private SlimeMetaFields() {
    }
}
