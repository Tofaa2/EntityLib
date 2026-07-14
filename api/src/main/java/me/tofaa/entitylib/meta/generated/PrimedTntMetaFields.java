package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Primed Tnt.
 */
public final class PrimedTntMetaFields {
    public static final MetaField<Integer> FUSE = MetaField.intBuilder("FUSE")
    .defaultValue(0)
    .versionRange(498, 751, 7, EntityDataTypes.INT)
    .versionRange(755, 2147483647, 8, EntityDataTypes.INT)
    .build();

    public static final MetaField<Object> BLOCK_STATE = MetaField.builder("BLOCK_STATE")
    .versionRange(765, 2147483647, 9, EntityDataTypes.BLOCK_STATE)
    .build();

    private PrimedTntMetaFields() {
    }
}
