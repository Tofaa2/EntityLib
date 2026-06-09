package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import com.github.retrooper.packetevents.util.Vector3f;
import me.tofaa.entitylib.meta.VersionedMetadataKey;

/**
 * Supported versions: All versions
 */
public class ArmorStandDataKeys extends LivingEntityDataKeys {

    /**
     * Supported versions: All versions
     */
    public static final VersionedMetadataKey<Vector3f> BODY_POSE = VersionedMetadataKey.<Vector3f>builder()
            .add(ClientVersion.V_1_14_4, 15, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_15, 16, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_16, 16, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_16_2, 16, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_17, 17, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_19, 17, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_19_1, 17, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_19_3, 17, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_19_4, 17, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_20_2, 17, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_20_3, 17, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_20_5, 17, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21, 17, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21_2, 17, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21_4, 17, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21_5, 17, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21_6, 17, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21_9, 17, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21_11, 17, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_26_1, 17, EntityDataTypes.VECTOR3F)
            .build();

    /**
     * Supported versions: All versions
     */
    public static final VersionedMetadataKey<Byte> CLIENT_FLAGS = VersionedMetadataKey.<Byte>builder()
            .add(ClientVersion.V_1_14_4, 13, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_15, 14, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_16, 14, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_16_2, 14, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_17, 15, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_19, 15, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_19_1, 15, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_19_3, 15, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_19_4, 15, EntityDataTypes.BYTE)
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
     * Supported versions: All versions
     */
    public static final VersionedMetadataKey<Vector3f> HEAD_POSE = VersionedMetadataKey.<Vector3f>builder()
            .add(ClientVersion.V_1_14_4, 14, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_15, 15, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_16, 15, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_16_2, 15, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_17, 16, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_19, 16, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_19_1, 16, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_19_3, 16, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_19_4, 16, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_20_2, 16, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_20_3, 16, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_20_5, 16, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21, 16, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21_2, 16, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21_4, 16, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21_5, 16, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21_6, 16, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21_9, 16, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21_11, 16, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_26_1, 16, EntityDataTypes.VECTOR3F)
            .build();

    /**
     * Supported versions: All versions
     */
    public static final VersionedMetadataKey<Vector3f> LEFT_ARM_POSE = VersionedMetadataKey.<Vector3f>builder()
            .add(ClientVersion.V_1_14_4, 16, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_15, 17, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_16, 17, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_16_2, 17, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_17, 18, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_19, 18, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_19_1, 18, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_19_3, 18, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_19_4, 18, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_20_2, 18, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_20_3, 18, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_20_5, 18, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21, 18, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21_2, 18, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21_4, 18, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21_5, 18, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21_6, 18, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21_9, 18, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21_11, 18, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_26_1, 18, EntityDataTypes.VECTOR3F)
            .build();

    /**
     * Supported versions: All versions
     */
    public static final VersionedMetadataKey<Vector3f> LEFT_LEG_POSE = VersionedMetadataKey.<Vector3f>builder()
            .add(ClientVersion.V_1_14_4, 18, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_15, 19, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_16, 19, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_16_2, 19, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_17, 20, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_19, 20, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_19_1, 20, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_19_3, 20, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_19_4, 20, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_20_2, 20, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_20_3, 20, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_20_5, 20, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21, 20, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21_2, 20, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21_4, 20, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21_5, 20, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21_6, 20, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21_9, 20, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21_11, 20, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_26_1, 20, EntityDataTypes.VECTOR3F)
            .build();

    /**
     * Supported versions: All versions
     */
    public static final VersionedMetadataKey<Vector3f> RIGHT_ARM_POSE = VersionedMetadataKey.<Vector3f>builder()
            .add(ClientVersion.V_1_14_4, 17, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_15, 18, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_16, 18, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_16_2, 18, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_17, 19, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_19, 19, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_19_1, 19, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_19_3, 19, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_19_4, 19, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_20_2, 19, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_20_3, 19, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_20_5, 19, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21, 19, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21_2, 19, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21_4, 19, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21_5, 19, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21_6, 19, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21_9, 19, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21_11, 19, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_26_1, 19, EntityDataTypes.VECTOR3F)
            .build();

    /**
     * Supported versions: All versions
     */
    public static final VersionedMetadataKey<Vector3f> RIGHT_LEG_POSE = VersionedMetadataKey.<Vector3f>builder()
            .add(ClientVersion.V_1_14_4, 19, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_15, 20, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_16, 20, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_16_2, 20, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_17, 21, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_19, 21, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_19_1, 21, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_19_3, 21, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_19_4, 21, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_20_2, 21, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_20_3, 21, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_20_5, 21, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21, 21, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21_2, 21, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21_4, 21, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21_5, 21, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21_6, 21, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21_9, 21, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_1_21_11, 21, EntityDataTypes.VECTOR3F)
            .add(ClientVersion.V_26_1, 21, EntityDataTypes.VECTOR3F)
            .build();

}
