package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Display.
 */
public final class DisplayMetaFields {
    public static final MetaField<Integer> INTERPOLATION_START_DELTA_TICKS = MetaField.intBuilder("INTERPOLATION_START_DELTA_TICKS")
    .defaultValue(0)
    .versionRange(762, 2147483647, 8, EntityDataTypes.INT)
    .build();

    public static final MetaField<Integer> INTERPOLATION_DURATION = MetaField.intBuilder("INTERPOLATION_DURATION")
    .defaultValue(0)
    .versionRange(762, 2147483647, 9, EntityDataTypes.INT)
    .build();

    public static final MetaField<Object> TRANSLATION = MetaField.builder("TRANSLATION")
    .versionRange(762, 762, 10, EntityDataTypes.VECTOR3F)
    .versionRange(764, 772, 11, EntityDataTypes.VECTOR3F)
    .versionRange(773, 2147483647, 11, EntityDataTypes.BYTE)
    .build();

    public static final MetaField<Object> SCALE = MetaField.builder("SCALE")
    .versionRange(762, 762, 11, EntityDataTypes.VECTOR3F)
    .versionRange(764, 772, 12, EntityDataTypes.VECTOR3F)
    .versionRange(773, 2147483647, 12, EntityDataTypes.BYTE)
    .build();

    public static final MetaField<Object> LEFT_ROTATION = MetaField.builder("LEFT_ROTATION")
    .versionRange(762, 762, 12, EntityDataTypes.QUATERNION)
    .versionRange(764, 772, 13, EntityDataTypes.QUATERNION)
    .versionRange(773, 2147483647, 13, EntityDataTypes.BYTE)
    .build();

    public static final MetaField<Object> RIGHT_ROTATION = MetaField.builder("RIGHT_ROTATION")
    .versionRange(762, 762, 13, EntityDataTypes.QUATERNION)
    .versionRange(764, 772, 14, EntityDataTypes.QUATERNION)
    .versionRange(773, 2147483647, 14, EntityDataTypes.BYTE)
    .build();

    public static final MetaField<Byte> BILLBOARD_RENDER_CONSTRAINTS = MetaField.byteBuilder("BILLBOARD_RENDER_CONSTRAINTS")
    .defaultValue((byte) 0)
    .versionRange(762, 762, 14, EntityDataTypes.BYTE)
    .versionRange(764, 2147483647, 15, EntityDataTypes.BYTE)
    .build();

    public static final MetaField<Integer> BRIGHTNESS_OVERRIDE = MetaField.intBuilder("BRIGHTNESS_OVERRIDE")
    .defaultValue(0)
    .versionRange(762, 762, 15, EntityDataTypes.INT)
    .versionRange(764, 2147483647, 16, EntityDataTypes.INT)
    .build();

    public static final MetaField<Float> VIEW_RANGE = MetaField.floatBuilder("VIEW_RANGE")
    .defaultValue(0.0f)
    .versionRange(762, 762, 16, EntityDataTypes.FLOAT)
    .versionRange(764, 2147483647, 17, EntityDataTypes.FLOAT)
    .build();

    public static final MetaField<Float> SHADOW_RADIUS = MetaField.floatBuilder("SHADOW_RADIUS")
    .defaultValue(0.0f)
    .versionRange(762, 762, 17, EntityDataTypes.FLOAT)
    .versionRange(764, 2147483647, 18, EntityDataTypes.FLOAT)
    .build();

    public static final MetaField<Float> SHADOW_STRENGTH = MetaField.floatBuilder("SHADOW_STRENGTH")
    .defaultValue(0.0f)
    .versionRange(762, 762, 18, EntityDataTypes.FLOAT)
    .versionRange(764, 2147483647, 19, EntityDataTypes.FLOAT)
    .build();

    public static final MetaField<Float> WIDTH = MetaField.floatBuilder("WIDTH")
    .defaultValue(0.0f)
    .versionRange(762, 762, 19, EntityDataTypes.FLOAT)
    .versionRange(764, 2147483647, 20, EntityDataTypes.FLOAT)
    .build();

    public static final MetaField<Float> HEIGHT = MetaField.floatBuilder("HEIGHT")
    .defaultValue(0.0f)
    .versionRange(762, 762, 20, EntityDataTypes.FLOAT)
    .versionRange(764, 2147483647, 21, EntityDataTypes.FLOAT)
    .build();

    public static final MetaField<Integer> GLOW_COLOR_OVERRIDE = MetaField.intBuilder("GLOW_COLOR_OVERRIDE")
    .defaultValue(0)
    .versionRange(762, 762, 21, EntityDataTypes.INT)
    .versionRange(764, 2147483647, 22, EntityDataTypes.INT)
    .build();

    public static final MetaField<Integer> TRANSFORMATION_INTERPOLATION_START_DELTA_TICKS = MetaField.intBuilder("TRANSFORMATION_INTERPOLATION_START_DELTA_TICKS")
    .defaultValue(0)
    .versionRange(764, 2147483647, 8, EntityDataTypes.INT)
    .build();

    public static final MetaField<Integer> TRANSFORMATION_INTERPOLATION_DURATION = MetaField.intBuilder("TRANSFORMATION_INTERPOLATION_DURATION")
    .defaultValue(0)
    .versionRange(764, 2147483647, 9, EntityDataTypes.INT)
    .build();

    public static final MetaField<Integer> POS_ROT_INTERPOLATION_DURATION = MetaField.intBuilder("POS_ROT_INTERPOLATION_DURATION")
    .defaultValue(0)
    .versionRange(764, 2147483647, 10, EntityDataTypes.INT)
    .build();

    private DisplayMetaFields() {
    }
}
