package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.VersionedMetadataKey;

/**
 * Supported versions: 1.15+
 */
public class BeeDataKeys extends AnimalDataKeys {

    /**
     * Supported versions: 1.21.11+
     */
    public static final VersionedMetadataKey<Long> ANGER_END_TIME = VersionedMetadataKey.<Long>builder()
            .add(ClientVersion.V_1_21_11, 18, EntityDataTypes.LONG)
            .add(ClientVersion.V_26_1, 19, EntityDataTypes.LONG)
            .build();

    /**
     * Supported versions: 1.15
     */
    public static final VersionedMetadataKey<Integer> ANGER_TIME = VersionedMetadataKey.<Integer>builder()
            .add(ClientVersion.V_1_15, 17, EntityDataTypes.INT)
            .build();

    /**
     * Supported versions: 1.15+
     */
    public static final VersionedMetadataKey<Byte> FLAGS = VersionedMetadataKey.<Byte>builder()
            .add(ClientVersion.V_1_15, 16, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_16, 16, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_16_2, 16, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_17, 17, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_19, 17, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_19_1, 17, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_19_3, 17, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_19_4, 17, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_20_2, 17, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_20_3, 17, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_20_5, 17, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21, 17, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21_2, 17, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21_4, 17, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21_5, 17, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21_6, 17, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21_9, 17, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21_11, 17, EntityDataTypes.BYTE)
            .add(ClientVersion.V_26_1, 18, EntityDataTypes.BYTE)
            .build();

    /**
     * Supported versions: 1.16 - 1.21.9
     */
    public static final VersionedMetadataKey<Integer> REMAINING_ANGER_TIME = VersionedMetadataKey.<Integer>builder()
            .add(ClientVersion.V_1_16, 17, EntityDataTypes.INT)
            .add(ClientVersion.V_1_16_2, 17, EntityDataTypes.INT)
            .add(ClientVersion.V_1_17, 18, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19, 18, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19_1, 18, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19_3, 18, EntityDataTypes.INT)
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
            .build();

}
