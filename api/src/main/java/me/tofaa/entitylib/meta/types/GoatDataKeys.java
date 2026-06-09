package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.VersionedMetadataKey;

/**
 * Supported versions: 1.17+
 */
public class GoatDataKeys extends AnimalDataKeys {

    /**
     * Supported versions: 1.19+
     */
    public static final VersionedMetadataKey<Boolean> HAS_LEFT_HORN = VersionedMetadataKey.<Boolean>builder()
            .add(ClientVersion.V_1_19, 18, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_19_1, 18, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_19_3, 18, EntityDataTypes.BOOLEAN)
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
     * Supported versions: 1.19+
     */
    public static final VersionedMetadataKey<Boolean> HAS_RIGHT_HORN = VersionedMetadataKey.<Boolean>builder()
            .add(ClientVersion.V_1_19, 19, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_19_1, 19, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_19_3, 19, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_19_4, 19, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_20_2, 19, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_20_3, 19, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_20_5, 19, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21, 19, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_2, 19, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_4, 19, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_5, 19, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_6, 19, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_9, 19, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_11, 19, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_26_1, 20, EntityDataTypes.BOOLEAN)
            .build();

    /**
     * Supported versions: 1.17+
     */
    public static final VersionedMetadataKey<Boolean> IS_SCREAMING_GOAT = VersionedMetadataKey.<Boolean>builder()
            .add(ClientVersion.V_1_17, 17, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_19, 17, EntityDataTypes.BOOLEAN)
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
            .add(ClientVersion.V_26_1, 18, EntityDataTypes.BOOLEAN)
            .build();

}
