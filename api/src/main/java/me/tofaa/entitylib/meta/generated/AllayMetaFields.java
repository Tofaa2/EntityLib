package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Allay.
 */
public final class AllayMetaFields {
    public static final MetaField<Boolean> DANCING = MetaField.booleanBuilder("DANCING")
    .defaultValue(false)
    .versionRange(760, 2147483647, 16, EntityDataTypes.BOOLEAN)
    .build();

    public static final MetaField<Boolean> CAN_DUPLICATE = MetaField.booleanBuilder("CAN_DUPLICATE")
    .defaultValue(false)
    .versionRange(760, 2147483647, 17, EntityDataTypes.BOOLEAN)
    .build();

    private AllayMetaFields() {
    }
}
