package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Ender Man.
 */
public final class EnderManMetaFields {
    public static final MetaField<Object> CARRY_STATE = MetaField.builder("CARRY_STATE")
    .versionRange(498, 498, 14, EntityDataTypes.INT)
    .versionRange(573, 751, 15, EntityDataTypes.INT)
    .versionRange(755, 2147483647, 16, EntityDataTypes.INT)
    .build();

    public static final MetaField<Boolean> CREEPY = MetaField.booleanBuilder("CREEPY")
    .defaultValue(false)
    .versionRange(498, 498, 15, EntityDataTypes.BOOLEAN)
    .versionRange(573, 751, 16, EntityDataTypes.BOOLEAN)
    .versionRange(755, 2147483647, 17, EntityDataTypes.BOOLEAN)
    .build();

    public static final MetaField<Boolean> STARED_AT = MetaField.booleanBuilder("STARED_AT")
    .defaultValue(false)
    .versionRange(573, 751, 17, EntityDataTypes.BOOLEAN)
    .versionRange(755, 2147483647, 18, EntityDataTypes.BOOLEAN)
    .build();

    private EnderManMetaFields() {
    }
}
