package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.VersionedMetadataKey;

/**
 * Supported versions: 1.21.2+
 */
public class AbstractBoatDataKeys extends VehicleEntityDataKeys {

    /**
     * Supported versions: 1.21.2+
     */
    public static final VersionedMetadataKey<Integer> BUBBLE_TIME = VersionedMetadataKey.<Integer>builder()
            .add(ClientVersion.V_1_21_2, 13, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_4, 13, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_5, 13, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_6, 13, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_9, 13, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_11, 13, EntityDataTypes.INT)
            .add(ClientVersion.V_26_1, 13, EntityDataTypes.INT)
            .build();

    /**
     * Supported versions: 1.21.2+
     */
    public static final VersionedMetadataKey<Boolean> PADDLE_LEFT = VersionedMetadataKey.<Boolean>builder()
            .add(ClientVersion.V_1_21_2, 11, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_4, 11, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_5, 11, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_6, 11, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_9, 11, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_11, 11, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_26_1, 11, EntityDataTypes.BOOLEAN)
            .build();

    /**
     * Supported versions: 1.21.2+
     */
    public static final VersionedMetadataKey<Boolean> PADDLE_RIGHT = VersionedMetadataKey.<Boolean>builder()
            .add(ClientVersion.V_1_21_2, 12, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_4, 12, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_5, 12, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_6, 12, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_9, 12, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_11, 12, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_26_1, 12, EntityDataTypes.BOOLEAN)
            .build();

}
