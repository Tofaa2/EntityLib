package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Entity.
 */
public final class EntityMetaFields {
    public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
    .defaultValue((byte) 0)
    .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
    .build();

    public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
    .defaultValue(0)
    .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
    .build();

    public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
    .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
    .build();

    public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
    .defaultValue(false)
    .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
    .build();

    public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
    .defaultValue(false)
    .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
    .build();

    public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
    .defaultValue(false)
    .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
    .build();

    public static final MetaField<Object> POSE = MetaField.builder("POSE")
    .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
    .build();

    public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
    .defaultValue(0)
    .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
    .build();

    private EntityMetaFields() {
    }
}
