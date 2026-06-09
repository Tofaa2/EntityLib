package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.VersionedMetadataKey;

/**
 * Supported versions: 1.17+
 */
public class GlowSquidDataKeys extends SquidDataKeys {

    /**
     * Supported versions: 1.17+
     */
    public static final VersionedMetadataKey<Integer> DARK_TICKS_REMAINING = VersionedMetadataKey.<Integer>builder()
            .add(ClientVersion.V_1_17, 16, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19, 16, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19_1, 16, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19_3, 16, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19_4, 16, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_2, 16, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_3, 16, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_5, 16, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21, 16, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_2, 17, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_4, 17, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_5, 17, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_6, 17, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_9, 17, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_11, 17, EntityDataTypes.INT)
            .add(ClientVersion.V_26_1, 18, EntityDataTypes.INT)
            .build();

}
