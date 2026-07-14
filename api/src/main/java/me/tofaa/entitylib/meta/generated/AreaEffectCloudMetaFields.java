package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Area Effect Cloud.
 */
public final class AreaEffectCloudMetaFields {
    public static final MetaField<Float> RADIUS = MetaField.floatBuilder("RADIUS")
    .defaultValue(0.0f)
    .versionRange(498, 751, 7, EntityDataTypes.FLOAT)
    .versionRange(755, 2147483647, 8, EntityDataTypes.FLOAT)
    .build();

    public static final MetaField<Integer> COLOR = MetaField.intBuilder("COLOR")
    .defaultValue(0)
    .versionRange(498, 751, 8, EntityDataTypes.INT)
    .versionRange(755, 2147483647, 9, EntityDataTypes.INT)
    .build();

    public static final MetaField<Boolean> WAITING = MetaField.booleanBuilder("WAITING")
    .defaultValue(false)
    .versionRange(498, 751, 9, EntityDataTypes.BOOLEAN)
    .versionRange(755, 765, 10, EntityDataTypes.BOOLEAN)
    .versionRange(766, 2147483647, 9, EntityDataTypes.BOOLEAN)
    .build();

    public static final MetaField<Object> PARTICLE = MetaField.builder("PARTICLE")
    .versionRange(498, 751, 10, EntityDataTypes.INT)
    .versionRange(755, 765, 11, EntityDataTypes.INT)
    .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
    .build();

    private AreaEffectCloudMetaFields() {
    }
}
