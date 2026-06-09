package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.VersionedMetadataKey;

/**
 * Supported versions: All versions
 */
public class AbstractMinecartDataKeys extends EntityDataKeys {

    /**
     * Supported versions: 1.21.4-
     */
    public static final VersionedMetadataKey<Boolean> CUSTOM_DISPLAY = VersionedMetadataKey.<Boolean>builder()
            .add(ClientVersion.V_1_14_4, 12, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_15, 12, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_16, 12, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_16_2, 12, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_17, 13, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_19, 13, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_19_1, 13, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_19_3, 13, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_19_4, 13, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_20_2, 13, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_20_3, 13, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_20_5, 13, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21, 13, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_2, 13, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_4, 13, EntityDataTypes.BOOLEAN)
            .build();

    /**
     * Supported versions: 1.21.5+
     */
    public static final VersionedMetadataKey<Integer> CUSTOM_DISPLAY_BLOCK = VersionedMetadataKey.<Integer>builder()
            .add(ClientVersion.V_1_21_5, 11, EntityDataTypes.OPTIONAL_BLOCK_STATE)
            .add(ClientVersion.V_1_21_6, 11, EntityDataTypes.OPTIONAL_BLOCK_STATE)
            .add(ClientVersion.V_1_21_9, 11, EntityDataTypes.OPTIONAL_BLOCK_STATE)
            .add(ClientVersion.V_1_21_11, 11, EntityDataTypes.OPTIONAL_BLOCK_STATE)
            .add(ClientVersion.V_26_1, 11, EntityDataTypes.OPTIONAL_BLOCK_STATE)
            .build();

    /**
     * Supported versions: 1.20.2-
     */
    public static final VersionedMetadataKey<Float> DAMAGE = VersionedMetadataKey.<Float>builder()
            .add(ClientVersion.V_1_14_4, 9, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_15, 9, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_16, 9, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_16_2, 9, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_17, 10, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_19, 10, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_19_1, 10, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_19_3, 10, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_19_4, 10, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_20_2, 10, EntityDataTypes.FLOAT)
            .build();

    /**
     * Supported versions: 1.21.4-
     */
    public static final VersionedMetadataKey<Integer> DISPLAY_BLOCK = VersionedMetadataKey.<Integer>builder()
            .add(ClientVersion.V_1_14_4, 10, EntityDataTypes.INT)
            .add(ClientVersion.V_1_15, 10, EntityDataTypes.INT)
            .add(ClientVersion.V_1_16, 10, EntityDataTypes.INT)
            .add(ClientVersion.V_1_16_2, 10, EntityDataTypes.INT)
            .add(ClientVersion.V_1_17, 11, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19, 11, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19_1, 11, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19_3, 11, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19_4, 11, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_2, 11, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_3, 11, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_5, 11, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21, 11, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_2, 11, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_4, 11, EntityDataTypes.INT)
            .build();

    /**
     * Supported versions: All versions
     */
    public static final VersionedMetadataKey<Integer> DISPLAY_OFFSET = VersionedMetadataKey.<Integer>builder()
            .add(ClientVersion.V_1_14_4, 11, EntityDataTypes.INT)
            .add(ClientVersion.V_1_15, 11, EntityDataTypes.INT)
            .add(ClientVersion.V_1_16, 11, EntityDataTypes.INT)
            .add(ClientVersion.V_1_16_2, 11, EntityDataTypes.INT)
            .add(ClientVersion.V_1_17, 12, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19, 12, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19_1, 12, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19_3, 12, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19_4, 12, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_2, 12, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_3, 12, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_5, 12, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21, 12, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_2, 12, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_4, 12, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_5, 12, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_6, 12, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_9, 12, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_11, 12, EntityDataTypes.INT)
            .add(ClientVersion.V_26_1, 12, EntityDataTypes.INT)
            .build();

    /**
     * Supported versions: 1.20.2-
     */
    public static final VersionedMetadataKey<Integer> HURT = VersionedMetadataKey.<Integer>builder()
            .add(ClientVersion.V_1_14_4, 7, EntityDataTypes.INT)
            .add(ClientVersion.V_1_15, 7, EntityDataTypes.INT)
            .add(ClientVersion.V_1_16, 7, EntityDataTypes.INT)
            .add(ClientVersion.V_1_16_2, 7, EntityDataTypes.INT)
            .add(ClientVersion.V_1_17, 8, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19, 8, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19_1, 8, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19_3, 8, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19_4, 8, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_2, 8, EntityDataTypes.INT)
            .build();

    /**
     * Supported versions: 1.20.2-
     */
    public static final VersionedMetadataKey<Integer> HURTDIR = VersionedMetadataKey.<Integer>builder()
            .add(ClientVersion.V_1_14_4, 8, EntityDataTypes.INT)
            .add(ClientVersion.V_1_15, 8, EntityDataTypes.INT)
            .add(ClientVersion.V_1_16, 8, EntityDataTypes.INT)
            .add(ClientVersion.V_1_16_2, 8, EntityDataTypes.INT)
            .add(ClientVersion.V_1_17, 9, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19, 9, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19_1, 9, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19_3, 9, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19_4, 9, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_2, 9, EntityDataTypes.INT)
            .build();

}
