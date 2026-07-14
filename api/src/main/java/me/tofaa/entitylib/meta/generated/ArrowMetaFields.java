package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Arrow.
 */
public final class ArrowMetaFields {
    public static final MetaField<Integer> ID_EFFECT_COLOR = MetaField.intBuilder("ID_EFFECT_COLOR")
    .defaultValue(0)
    .versionRange(498, 573, 10, EntityDataTypes.INT)
    .versionRange(735, 751, 9, EntityDataTypes.INT)
    .versionRange(755, 767, 10, EntityDataTypes.INT)
    .versionRange(768, 2147483647, 11, EntityDataTypes.INT)
    .build();

    private ArrowMetaFields() {
    }
}
