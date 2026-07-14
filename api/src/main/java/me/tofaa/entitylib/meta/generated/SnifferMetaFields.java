package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Sniffer.
 */
public final class SnifferMetaFields {
    public static final MetaField<Object> STATE = MetaField.builder("STATE")
    .versionRange(762, 773, 17, EntityDataTypes.INT)
    .versionRange(774, 2147483647, 18, EntityDataTypes.INT)
    .build();

    public static final MetaField<Integer> DROP_SEED_AT_TICK = MetaField.intBuilder("DROP_SEED_AT_TICK")
    .defaultValue(0)
    .versionRange(762, 773, 18, EntityDataTypes.INT)
    .versionRange(774, 2147483647, 19, EntityDataTypes.INT)
    .build();

    private SnifferMetaFields() {
    }
}
