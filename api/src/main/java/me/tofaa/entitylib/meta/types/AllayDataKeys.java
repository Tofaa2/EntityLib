package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.VersionedMetadataKey;

/**
 * Supported versions: 1.19+
 */
public class AllayDataKeys extends PathfinderMobDataKeys {

    /**
     * Supported versions: 1.19.1+
     */
    public static final VersionedMetadataKey<Boolean> CAN_DUPLICATE = VersionedMetadataKey.<Boolean>builder()
            .add(ClientVersion.V_1_19_1, 17, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_19_3, 17, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_19_4, 17, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_20_2, 17, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_20_3, 17, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_20_5, 17, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21, 17, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_2, 17, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_4, 17, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_5, 17, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_6, 17, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_9, 17, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_11, 17, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_26_1, 17, EntityDataTypes.BOOLEAN)
            .build();

    /**
     * Supported versions: 1.19.1+
     */
    public static final VersionedMetadataKey<Boolean> DANCING = VersionedMetadataKey.<Boolean>builder()
            .add(ClientVersion.V_1_19_1, 16, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_19_3, 16, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_19_4, 16, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_20_2, 16, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_20_3, 16, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_20_5, 16, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21, 16, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_2, 16, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_4, 16, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_5, 16, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_6, 16, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_9, 16, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_11, 16, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_26_1, 16, EntityDataTypes.BOOLEAN)
            .build();

}
