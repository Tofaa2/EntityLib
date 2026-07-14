package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for End Crystal.
 */
public final class EndCrystalMetaFields {
    public static final MetaField<Object> BEAM_TARGET = MetaField.builder("BEAM_TARGET")
    .versionRange(498, 751, 7, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
    .versionRange(755, 2147483647, 8, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
    .build();

    public static final MetaField<Boolean> SHOW_BOTTOM = MetaField.booleanBuilder("SHOW_BOTTOM")
    .defaultValue(false)
    .versionRange(498, 751, 8, EntityDataTypes.BOOLEAN)
    .versionRange(755, 2147483647, 9, EntityDataTypes.BOOLEAN)
    .build();

    private EndCrystalMetaFields() {
    }
}
