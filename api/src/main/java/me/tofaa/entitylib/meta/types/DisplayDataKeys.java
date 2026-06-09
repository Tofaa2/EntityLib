package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import com.github.retrooper.packetevents.util.Quaternion4f;
import com.github.retrooper.packetevents.util.Vector3f;
import me.tofaa.entitylib.meta.VersionedMetadataKey;

/**
 * Supported versions: 1.19.4+
 */
public class DisplayDataKeys extends EntityDataKeys {

    /**
     * Supported versions: 1.19.4+
     */
    public static final VersionedMetadataKey<Byte> BILLBOARD_RENDER_CONSTRAINTS = VersionedMetadataKey.<Byte>builder()
            .add(ClientVersion.V_1_19_4, 14, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_20_2, 15, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_20_3, 15, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_20_5, 15, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21, 15, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21_2, 15, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21_4, 15, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21_5, 15, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21_6, 15, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21_9, 15, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21_11, 15, EntityDataTypes.BYTE)
            .add(ClientVersion.V_26_1, 15, EntityDataTypes.BYTE)
            .build();

    /**
     * Supported versions: 1.19.4+
     */
    public static final VersionedMetadataKey<Integer> BRIGHTNESS_OVERRIDE = VersionedMetadataKey.<Integer>builder()
            .add(ClientVersion.V_1_19_4, 15, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_2, 16, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_3, 16, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_5, 16, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21, 16, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_2, 16, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_4, 16, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_5, 16, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_6, 16, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_9, 16, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_11, 16, EntityDataTypes.INT)
            .add(ClientVersion.V_26_1, 16, EntityDataTypes.INT)
            .build();

    /**
     * Supported versions: 1.19.4+
     */
    public static final VersionedMetadataKey<Integer> GLOW_COLOR_OVERRIDE = VersionedMetadataKey.<Integer>builder()
            .add(ClientVersion.V_1_19_4, 21, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_2, 22, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_3, 22, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_5, 22, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21, 22, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_2, 22, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_4, 22, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_5, 22, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_6, 22, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_9, 22, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_11, 22, EntityDataTypes.INT)
            .add(ClientVersion.V_26_1, 22, EntityDataTypes.INT)
            .build();

    /**
     * Supported versions: 1.19.4+
     */
    public static final VersionedMetadataKey<Float> HEIGHT = VersionedMetadataKey.<Float>builder()
            .add(ClientVersion.V_1_19_4, 20, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_20_2, 21, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_20_3, 21, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_20_5, 21, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21, 21, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_2, 21, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_4, 21, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_5, 21, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_6, 21, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_9, 21, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_11, 21, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_26_1, 21, EntityDataTypes.FLOAT)
            .build();

    /**
     * Supported versions: 1.19.4
     */
    public static final VersionedMetadataKey<Integer> INTERPOLATION_DURATION = VersionedMetadataKey.<Integer>builder()
            .add(ClientVersion.V_1_19_4, 9, EntityDataTypes.INT)
            .build();

    /**
     * Supported versions: 1.19.4
     */
    public static final VersionedMetadataKey<Integer> INTERPOLATION_START_DELTA_TICKS = VersionedMetadataKey.<Integer>builder()
            .add(ClientVersion.V_1_19_4, 8, EntityDataTypes.INT)
            .build();

    /**
     * Supported versions: 1.19.4+
     */
    public static final VersionedMetadataKey<Quaternion4f> LEFT_ROTATION = VersionedMetadataKey.<Quaternion4f>builder()
            .add(ClientVersion.V_1_19_4, 12, EntityDataTypes.QUATERNION)
            .add(ClientVersion.V_1_20_2, 13, EntityDataTypes.QUATERNION)
            .add(ClientVersion.V_1_20_3, 13, EntityDataTypes.QUATERNION)
            .add(ClientVersion.V_1_20_5, 13, EntityDataTypes.QUATERNION)
            .add(ClientVersion.V_1_21, 13, EntityDataTypes.QUATERNION)
            .add(ClientVersion.V_1_21_2, 13, EntityDataTypes.QUATERNION)
            .add(ClientVersion.V_1_21_4, 13, EntityDataTypes.QUATERNION)
            .add(ClientVersion.V_1_21_5, 13, EntityDataTypes.QUATERNION)
            .add(ClientVersion.V_1_21_6, 13, EntityDataTypes.QUATERNION)
            .add(ClientVersion.V_1_21_9, 13, EntityDataTypes.QUATERNION)
            .add(ClientVersion.V_1_21_11, 13, EntityDataTypes.QUATERNION)
            .add(ClientVersion.V_26_1, 13, EntityDataTypes.QUATERNION)
            .build();

    /**
     * Supported versions: 1.20.2+
     */
    public static final VersionedMetadataKey<Integer> POS_ROT_INTERPOLATION_DURATION = VersionedMetadataKey.<Integer>builder()
            .add(ClientVersion.V_1_20_2, 10, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_3, 10, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_5, 10, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21, 10, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_2, 10, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_4, 10, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_5, 10, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_6, 10, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_9, 10, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_11, 10, EntityDataTypes.INT)
            .add(ClientVersion.V_26_1, 10, EntityDataTypes.INT)
            .build();

    /**
     * Supported versions: 1.19.4+
     */
    public static final VersionedMetadataKey<Quaternion4f> RIGHT_ROTATION = VersionedMetadataKey.<Quaternion4f>builder()
            .add(ClientVersion.V_1_19_4, 13, EntityDataTypes.QUATERNION)
            .add(ClientVersion.V_1_20_2, 14, EntityDataTypes.QUATERNION)
            .add(ClientVersion.V_1_20_3, 14, EntityDataTypes.QUATERNION)
            .add(ClientVersion.V_1_20_5, 14, EntityDataTypes.QUATERNION)
            .add(ClientVersion.V_1_21, 14, EntityDataTypes.QUATERNION)
            .add(ClientVersion.V_1_21_2, 14, EntityDataTypes.QUATERNION)
            .add(ClientVersion.V_1_21_4, 14, EntityDataTypes.QUATERNION)
            .add(ClientVersion.V_1_21_5, 14, EntityDataTypes.QUATERNION)
            .add(ClientVersion.V_1_21_6, 14, EntityDataTypes.QUATERNION)
            .add(ClientVersion.V_1_21_9, 14, EntityDataTypes.QUATERNION)
            .add(ClientVersion.V_1_21_11, 14, EntityDataTypes.QUATERNION)
            .add(ClientVersion.V_26_1, 14, EntityDataTypes.QUATERNION)
            .build();

    /**
     * Supported versions: 1.19.4+
     */
    public static final VersionedMetadataKey<Vector3f> SCALE = VersionedMetadataKey.<Vector3f>builder()
            .add(ClientVersion.V_1_19_4, 11, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_20_2, 12, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_20_3, 12, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_20_5, 12, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21, 12, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21_2, 12, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21_4, 12, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21_5, 12, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21_6, 12, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21_9, 12, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21_11, 12, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_26_1, 12, EntityDataTypes.VECTOR3F)
            .build();

    /**
     * Supported versions: 1.19.4+
     */
    public static final VersionedMetadataKey<Float> SHADOW_RADIUS = VersionedMetadataKey.<Float>builder()
            .add(ClientVersion.V_1_19_4, 17, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_20_2, 18, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_20_3, 18, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_20_5, 18, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21, 18, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_2, 18, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_4, 18, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_5, 18, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_6, 18, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_9, 18, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_11, 18, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_26_1, 18, EntityDataTypes.FLOAT)
            .build();

    /**
     * Supported versions: 1.19.4+
     */
    public static final VersionedMetadataKey<Float> SHADOW_STRENGTH = VersionedMetadataKey.<Float>builder()
            .add(ClientVersion.V_1_19_4, 18, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_20_2, 19, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_20_3, 19, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_20_5, 19, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21, 19, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_2, 19, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_4, 19, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_5, 19, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_6, 19, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_9, 19, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_11, 19, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_26_1, 19, EntityDataTypes.FLOAT)
            .build();

    /**
     * Supported versions: 1.20.2+
     */
    public static final VersionedMetadataKey<Integer> TRANSFORMATION_INTERPOLATION_DURATION = VersionedMetadataKey.<Integer>builder()
            .add(ClientVersion.V_1_20_2, 9, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_3, 9, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_5, 9, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21, 9, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_2, 9, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_4, 9, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_5, 9, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_6, 9, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_9, 9, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_11, 9, EntityDataTypes.INT)
            .add(ClientVersion.V_26_1, 9, EntityDataTypes.INT)
            .build();

    /**
     * Supported versions: 1.20.2+
     */
    public static final VersionedMetadataKey<Integer> TRANSFORMATION_INTERPOLATION_START_DELTA_TICKS = VersionedMetadataKey.<Integer>builder()
            .add(ClientVersion.V_1_20_2, 8, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_3, 8, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_5, 8, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21, 8, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_2, 8, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_4, 8, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_5, 8, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_6, 8, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_9, 8, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_11, 8, EntityDataTypes.INT)
            .add(ClientVersion.V_26_1, 8, EntityDataTypes.INT)
            .build();

    /**
     * Supported versions: 1.19.4+
     */
    public static final VersionedMetadataKey<Vector3f> TRANSLATION = VersionedMetadataKey.<Vector3f>builder()
            .add(ClientVersion.V_1_19_4, 10, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_20_2, 11, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_20_3, 11, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_20_5, 11, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21, 11, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21_2, 11, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21_4, 11, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21_5, 11, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21_6, 11, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21_9, 11, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21_11, 11, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_26_1, 11, EntityDataTypes.VECTOR3F)
            .build();

    /**
     * Supported versions: 1.19.4+
     */
    public static final VersionedMetadataKey<Float> VIEW_RANGE = VersionedMetadataKey.<Float>builder()
            .add(ClientVersion.V_1_19_4, 16, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_20_2, 17, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_20_3, 17, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_20_5, 17, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21, 17, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_2, 17, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_4, 17, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_5, 17, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_6, 17, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_9, 17, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_11, 17, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_26_1, 17, EntityDataTypes.FLOAT)
            .build();

    /**
     * Supported versions: 1.19.4+
     */
    public static final VersionedMetadataKey<Float> WIDTH = VersionedMetadataKey.<Float>builder()
            .add(ClientVersion.V_1_19_4, 19, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_20_2, 20, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_20_3, 20, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_20_5, 20, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21, 20, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_2, 20, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_4, 20, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_5, 20, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_6, 20, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_9, 20, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_11, 20, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_26_1, 20, EntityDataTypes.FLOAT)
            .build();

}
