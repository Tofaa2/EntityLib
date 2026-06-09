package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.VersionedMetadataKey;

/**
 * Supported versions: All versions
 */
public class HorseDataKeys extends AbstractHorseDataKeys {

    /**
     * Supported versions: All versions
     */
    public static final VersionedMetadataKey<Integer> TYPE_VARIANT = VersionedMetadataKey.<Integer>builder()
            .add(ClientVersion.V_1_14_4, 17, EntityDataTypes.INT)
            .add(ClientVersion.V_1_15, 18, EntityDataTypes.INT)
            .add(ClientVersion.V_1_16, 18, EntityDataTypes.INT)
            .add(ClientVersion.V_1_16_2, 18, EntityDataTypes.INT)
            .add(ClientVersion.V_1_17, 19, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19, 19, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19_1, 19, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19_3, 19, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19_4, 18, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_2, 18, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_3, 18, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_5, 18, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21, 18, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_2, 18, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_4, 18, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_5, 18, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_6, 18, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_9, 18, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_11, 18, EntityDataTypes.INT)
            .add(ClientVersion.V_26_1, 19, EntityDataTypes.INT)
            .build();

}
