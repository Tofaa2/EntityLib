package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Creaking.
 */
public final class CreakingMetaFields {
    public static final MetaField<Boolean> CAN_MOVE = MetaField.booleanBuilder("CAN_MOVE")
    .defaultValue(false)
    .versionRange(768, 2147483647, 16, EntityDataTypes.BOOLEAN)
    .build();

    public static final MetaField<Boolean> IS_ACTIVE = MetaField.booleanBuilder("IS_ACTIVE")
    .defaultValue(false)
    .versionRange(768, 2147483647, 17, EntityDataTypes.BOOLEAN)
    .build();

    public static final MetaField<Boolean> IS_TEARING_DOWN = MetaField.booleanBuilder("IS_TEARING_DOWN")
    .defaultValue(false)
    .versionRange(769, 2147483647, 18, EntityDataTypes.BOOLEAN)
    .build();

    public static final MetaField<Object> HOME_POS = MetaField.builder("HOME_POS")
    .versionRange(769, 2147483647, 19, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
    .build();

    private CreakingMetaFields() {
    }
}
