package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.VersionedMetadataKey;

/**
 * Supported versions: 1.19.4+
 */
public class BlockDisplayDataKeys extends DisplayDataKeys {

    /**
     * Supported versions: 1.19.4+
     */
    public static final VersionedMetadataKey<Integer> BLOCK_STATE = VersionedMetadataKey.<Integer>builder()
            .add(ClientVersion.V_1_19_4, 22, EntityDataTypes.BLOCK_STATE)
            .add(ClientVersion.V_1_20_2, 23, EntityDataTypes.BLOCK_STATE)
            .add(ClientVersion.V_1_20_3, 23, EntityDataTypes.BLOCK_STATE)
            .add(ClientVersion.V_1_20_5, 23, EntityDataTypes.BLOCK_STATE)
            .add(ClientVersion.V_1_21, 23, EntityDataTypes.BLOCK_STATE)
            .add(ClientVersion.V_1_21_2, 23, EntityDataTypes.BLOCK_STATE)
            .add(ClientVersion.V_1_21_4, 23, EntityDataTypes.BLOCK_STATE)
            .add(ClientVersion.V_1_21_5, 23, EntityDataTypes.BLOCK_STATE)
            .add(ClientVersion.V_1_21_6, 23, EntityDataTypes.BLOCK_STATE)
            .add(ClientVersion.V_1_21_9, 23, EntityDataTypes.BLOCK_STATE)
            .add(ClientVersion.V_1_21_11, 23, EntityDataTypes.BLOCK_STATE)
            .add(ClientVersion.V_26_1, 23, EntityDataTypes.BLOCK_STATE)
            .build();

}
