package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Living Entity.
 */
public final class LivingEntityMetaFields {
    public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
    .defaultValue((byte) 0)
    .versionRange(498, 751, 7, EntityDataTypes.BYTE)
    .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
    .build();

    public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
    .defaultValue(0.0f)
    .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
    .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
    .build();

    public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
    .defaultValue(0)
    .versionRange(498, 751, 9, EntityDataTypes.INT)
    .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
    .build();

    public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
    .defaultValue(false)
    .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
    .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
    .build();

    public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
    .defaultValue(0)
    .versionRange(498, 751, 11, EntityDataTypes.INT)
    .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
    .build();

    public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
    .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
    .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
    .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
    .build();

    public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
    .defaultValue(0)
    .versionRange(573, 751, 12, EntityDataTypes.INT)
    .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
    .build();

    public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
    .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
    .build();

    private LivingEntityMetaFields() {
    }
}
