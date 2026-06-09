package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.VersionedMetadataKey;

/**
 * Supported versions: 1.16+
 */
public class PiglinDataKeys extends MonsterDataKeys {

    /**
     * Supported versions: 1.16+
     */
    public static final VersionedMetadataKey<Boolean> BABY = VersionedMetadataKey.<Boolean>builder()
            .add(ClientVersion.V_1_16, 15, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_16_2, 16, EntityDataTypes.BOOLEAN)
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
            .add(ClientVersion.V_26_1, 17, EntityDataTypes.BOOLEAN)
            .build();

    /**
     * Supported versions: 1.16
     */
    public static final VersionedMetadataKey<Boolean> IMMUNE_TO_ZOMBIFICATION = VersionedMetadataKey.<Boolean>builder()
            .add(ClientVersion.V_1_16, 16, EntityDataTypes.BOOLEAN)
            .build();

    /**
     * Supported versions: 1.16+
     */
    public static final VersionedMetadataKey<Boolean> IS_CHARGING_CROSSBOW = VersionedMetadataKey.<Boolean>builder()
            .add(ClientVersion.V_1_16, 17, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_16_2, 17, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_17, 18, EntityDataTypes.BOOLEAN)
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
            .add(ClientVersion.V_26_1, 18, EntityDataTypes.BOOLEAN)
            .build();

    /**
     * Supported versions: 1.16+
     */
    public static final VersionedMetadataKey<Boolean> IS_DANCING = VersionedMetadataKey.<Boolean>builder()
            .add(ClientVersion.V_1_16, 18, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_16_2, 18, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_17, 19, EntityDataTypes.BOOLEAN)
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
            .add(ClientVersion.V_26_1, 19, EntityDataTypes.BOOLEAN)
            .build();

}
