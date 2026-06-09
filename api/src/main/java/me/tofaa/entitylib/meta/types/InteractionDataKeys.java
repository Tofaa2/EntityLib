package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.VersionedMetadataKey;

/**
 * Supported versions: 1.19.4+
 */
public class InteractionDataKeys extends EntityDataKeys {

    /**
     * Supported versions: 1.19.4+
     */
    public static final VersionedMetadataKey<Float> HEIGHT = VersionedMetadataKey.<Float>builder()
            .add(ClientVersion.V_1_19_4, 9, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_20_2, 9, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_20_3, 9, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_20_5, 9, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21, 9, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_2, 9, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_4, 9, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_5, 9, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_6, 9, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_9, 9, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_11, 9, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_26_1, 9, EntityDataTypes.FLOAT)
            .build();

    /**
     * Supported versions: 1.19.4+
     */
    public static final VersionedMetadataKey<Boolean> RESPONSE = VersionedMetadataKey.<Boolean>builder()
            .add(ClientVersion.V_1_19_4, 10, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_20_2, 10, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_20_3, 10, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_20_5, 10, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21, 10, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_2, 10, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_4, 10, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_5, 10, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_6, 10, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_9, 10, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_11, 10, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_26_1, 10, EntityDataTypes.BOOLEAN)
            .build();

    /**
     * Supported versions: 1.19.4+
     */
    public static final VersionedMetadataKey<Float> WIDTH = VersionedMetadataKey.<Float>builder()
            .add(ClientVersion.V_1_19_4, 8, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_20_2, 8, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_20_3, 8, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_20_5, 8, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21, 8, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_2, 8, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_4, 8, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_5, 8, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_6, 8, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_9, 8, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_11, 8, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_26_1, 8, EntityDataTypes.FLOAT)
            .build();

}
