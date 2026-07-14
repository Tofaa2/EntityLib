package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Wolf.
 */
public final class WolfMetaFields {
    public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
    .defaultValue(0.0f)
    .versionRange(498, 2147483647, 17, EntityDataTypes.FLOAT)
    .build();

    public static final MetaField<Boolean> INTERESTED = MetaField.booleanBuilder("INTERESTED")
    .defaultValue(false)
    .versionRange(498, 751, 18, EntityDataTypes.BOOLEAN)
    .versionRange(755, 773, 19, EntityDataTypes.BOOLEAN)
    .versionRange(774, 2147483647, 20, EntityDataTypes.BOOLEAN)
    .build();

    public static final MetaField<Integer> COLLAR_COLOR = MetaField.intBuilder("COLLAR_COLOR")
    .defaultValue(0)
    .versionRange(498, 751, 19, EntityDataTypes.INT)
    .versionRange(755, 773, 20, EntityDataTypes.INT)
    .versionRange(774, 2147483647, 21, EntityDataTypes.INT)
    .build();

    public static final MetaField<Integer> REMAINING_ANGER_TIME = MetaField.intBuilder("REMAINING_ANGER_TIME")
    .defaultValue(0)
    .versionRange(735, 751, 20, EntityDataTypes.INT)
    .versionRange(755, 2147483647, 21, EntityDataTypes.INT)
    .build();

    public static final MetaField<Object> VARIANT = MetaField.builder("VARIANT")
    .versionRange(766, 773, 22, EntityDataTypes.INT)
    .versionRange(774, 2147483647, 23, EntityDataTypes.INT)
    .build();

    public static final MetaField<Object> SOUND_VARIANT = MetaField.builder("SOUND_VARIANT")
    .versionRange(770, 773, 23, EntityDataTypes.INT)
    .versionRange(774, 2147483647, 24, EntityDataTypes.INT)
    .build();

    public static final MetaField<Long> ANGER_END_TIME = MetaField.longBuilder("ANGER_END_TIME")
    .defaultValue(0L)
    .versionRange(773, 773, 21, EntityDataTypes.LONG)
    .versionRange(774, 2147483647, 22, EntityDataTypes.LONG)
    .build();

    private WolfMetaFields() {
    }
}
