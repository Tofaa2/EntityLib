package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.VersionedMetadataKey;

/**
 * Supported versions: All versions
 */
public class FishingHookDataKeys extends EntityDataKeys {

    /**
     * Supported versions: 1.16+
     */
    public static final VersionedMetadataKey<Boolean> BITING = VersionedMetadataKey.<Boolean>builder()
            .add(ClientVersion.V_1_16, 8, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_16_2, 8, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_17, 9, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_19, 9, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_19_1, 9, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_19_3, 9, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_19_4, 9, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_20_2, 9, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_20_3, 9, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_20_5, 9, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21, 9, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_2, 9, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_4, 9, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_5, 9, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_6, 9, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_9, 9, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_11, 9, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_26_1, 9, EntityDataTypes.BOOLEAN)
            .build();

    /**
     * Supported versions: All versions
     */
    public static final VersionedMetadataKey<Integer> HOOKED_ENTITY = VersionedMetadataKey.<Integer>builder()
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

}
