package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.VersionedMetadataKey;

/**
 * Supported versions: 1.19.3+
 */
public class CamelDataKeys extends AbstractHorseDataKeys {

    /**
     * Supported versions: 1.19.3+
     */
    public static final VersionedMetadataKey<Boolean> DASH = VersionedMetadataKey.<Boolean>builder()
            .add(ClientVersion.V_1_19_3, 19, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_19_4, 18, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_20_2, 18, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_20_3, 18, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_20_5, 18, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21, 18, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_2, 18, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_4, 18, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_5, 18, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_6, 18, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_9, 18, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_11, 18, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_26_1, 19, EntityDataTypes.BOOLEAN)
            .build();

    /**
     * Supported versions: 1.19.3+
     */
    public static final VersionedMetadataKey<Long> LAST_POSE_CHANGE_TICK = VersionedMetadataKey.<Long>builder()
            .add(ClientVersion.V_1_19_3, 20, EntityDataTypes.LONG)
            .add(ClientVersion.V_1_19_4, 19, EntityDataTypes.LONG)
            .add(ClientVersion.V_1_20_2, 19, EntityDataTypes.LONG)
            .add(ClientVersion.V_1_20_3, 19, EntityDataTypes.LONG)
            .add(ClientVersion.V_1_20_5, 19, EntityDataTypes.LONG)
            .add(ClientVersion.V_1_21, 19, EntityDataTypes.LONG)
            .add(ClientVersion.V_1_21_2, 19, EntityDataTypes.LONG)
            .add(ClientVersion.V_1_21_4, 19, EntityDataTypes.LONG)
            .add(ClientVersion.V_1_21_5, 19, EntityDataTypes.LONG)
            .add(ClientVersion.V_1_21_6, 19, EntityDataTypes.LONG)
            .add(ClientVersion.V_1_21_9, 19, EntityDataTypes.LONG)
            .add(ClientVersion.V_1_21_11, 19, EntityDataTypes.LONG)
            .add(ClientVersion.V_26_1, 20, EntityDataTypes.LONG)
            .build();

}
