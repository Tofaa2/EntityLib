package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.VersionedMetadataKey;

/**
 * Supported versions: 1.20.3+
 */
public class VehicleEntityDataKeys extends EntityDataKeys {

    /**
     * Supported versions: 1.20.3+
     */
    public static final VersionedMetadataKey<Float> DAMAGE = VersionedMetadataKey.<Float>builder()
            .add(ClientVersion.V_1_20_3, 10, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_20_5, 10, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21, 10, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_2, 10, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_4, 10, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_5, 10, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_6, 10, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_9, 10, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_11, 10, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_26_1, 10, EntityDataTypes.FLOAT)
            .build();

    /**
     * Supported versions: 1.20.3+
     */
    public static final VersionedMetadataKey<Integer> HURT = VersionedMetadataKey.<Integer>builder()
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
     * Supported versions: 1.20.3+
     */
    public static final VersionedMetadataKey<Integer> HURTDIR = VersionedMetadataKey.<Integer>builder()
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

}
