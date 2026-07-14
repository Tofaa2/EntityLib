package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Abstract Minecart.
 */
public final class AbstractMinecartMetaFields {
    public static final MetaField<Integer> HURT = MetaField.intBuilder("HURT")
    .defaultValue(0)
    .versionRange(498, 751, 7, EntityDataTypes.INT)
    .versionRange(755, 2147483647, 8, EntityDataTypes.INT)
    .build();

    public static final MetaField<Integer> HURTDIR = MetaField.intBuilder("HURTDIR")
    .defaultValue(0)
    .versionRange(498, 751, 8, EntityDataTypes.INT)
    .versionRange(755, 2147483647, 9, EntityDataTypes.INT)
    .build();

    public static final MetaField<Float> DAMAGE = MetaField.floatBuilder("DAMAGE")
    .defaultValue(0.0f)
    .versionRange(498, 751, 9, EntityDataTypes.FLOAT)
    .versionRange(755, 2147483647, 10, EntityDataTypes.FLOAT)
    .build();

    public static final MetaField<Integer> DISPLAY_BLOCK = MetaField.intBuilder("DISPLAY_BLOCK")
    .defaultValue(0)
    .versionRange(498, 751, 10, EntityDataTypes.INT)
    .versionRange(755, 2147483647, 11, EntityDataTypes.INT)
    .build();

    public static final MetaField<Integer> DISPLAY_OFFSET = MetaField.intBuilder("DISPLAY_OFFSET")
    .defaultValue(0)
    .versionRange(498, 751, 11, EntityDataTypes.INT)
    .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
    .build();

    public static final MetaField<Boolean> CUSTOM_DISPLAY = MetaField.booleanBuilder("CUSTOM_DISPLAY")
    .defaultValue(false)
    .versionRange(498, 751, 12, EntityDataTypes.BOOLEAN)
    .versionRange(755, 2147483647, 13, EntityDataTypes.BOOLEAN)
    .build();

    public static final MetaField<Object> CUSTOM_DISPLAY_BLOCK = MetaField.builder("CUSTOM_DISPLAY_BLOCK")
    .versionRange(770, 2147483647, 11, EntityDataTypes.INT)
    .build();

    private AbstractMinecartMetaFields() {
    }
}
