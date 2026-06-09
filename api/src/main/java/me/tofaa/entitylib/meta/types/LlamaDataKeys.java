package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.VersionedMetadataKey;

/**
 * Supported versions: All versions
 */
public class LlamaDataKeys extends AbstractChestedHorseDataKeys {

    /**
     * Supported versions: All versions
     */
    public static final VersionedMetadataKey<Integer> STRENGTH = VersionedMetadataKey.<Integer>builder()
            .add(ClientVersion.V_1_14_4, 18, EntityDataTypes.INT)
            .add(ClientVersion.V_1_15, 19, EntityDataTypes.INT)
            .add(ClientVersion.V_1_16, 19, EntityDataTypes.INT)
            .add(ClientVersion.V_1_16_2, 19, EntityDataTypes.INT)
            .add(ClientVersion.V_1_17, 20, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19, 20, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19_1, 20, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19_3, 20, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19_4, 19, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_2, 19, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_3, 19, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_5, 19, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21, 19, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_2, 19, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_4, 19, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_5, 19, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_6, 19, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_9, 19, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_11, 19, EntityDataTypes.INT)
            .add(ClientVersion.V_26_1, 20, EntityDataTypes.INT)
            .build();

    /**
     * Supported versions: 1.20.3-
     */
    public static final VersionedMetadataKey<Integer> SWAG = VersionedMetadataKey.<Integer>builder()
            .add(ClientVersion.V_1_14_4, 19, EntityDataTypes.INT)
            .add(ClientVersion.V_1_15, 20, EntityDataTypes.INT)
            .add(ClientVersion.V_1_16, 20, EntityDataTypes.INT)
            .add(ClientVersion.V_1_16_2, 20, EntityDataTypes.INT)
            .add(ClientVersion.V_1_17, 21, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19, 21, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19_1, 21, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19_3, 21, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19_4, 20, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_2, 20, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_3, 20, EntityDataTypes.INT)
            .build();

    /**
     * Supported versions: All versions
     */
    public static final VersionedMetadataKey<Integer> VARIANT = VersionedMetadataKey.<Integer>builder()
            .add(ClientVersion.V_1_14_4, 20, EntityDataTypes.INT)
            .add(ClientVersion.V_1_15, 21, EntityDataTypes.INT)
            .add(ClientVersion.V_1_16, 21, EntityDataTypes.INT)
            .add(ClientVersion.V_1_16_2, 21, EntityDataTypes.INT)
            .add(ClientVersion.V_1_17, 22, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19, 22, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19_1, 22, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19_3, 22, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19_4, 21, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_2, 21, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_3, 21, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_5, 20, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21, 20, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_2, 20, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_4, 20, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_5, 20, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_6, 20, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_9, 20, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_11, 20, EntityDataTypes.INT)
            .add(ClientVersion.V_26_1, 21, EntityDataTypes.INT)
            .build();

}
