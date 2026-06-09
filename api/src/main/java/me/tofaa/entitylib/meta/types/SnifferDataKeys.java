// Auto-generated file. Do not edit manually.
package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.entity.sniffer.SnifferState;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.EntityDataKey;

/**
 * Supported versions: 1.19.4+
 */
public class SnifferDataKeys extends AnimalDataKeys {

    /**
     * Supported versions: 1.19.4+
     */
    public static final EntityDataKey<Integer> DROP_SEED_AT_TICK = EntityDataKey.<Integer>builder(SnifferDataKeys.class)
            .addVersion(ClientVersion.V_1_19_4, 18, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_20_2, 18, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_20_3, 18, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_20_5, 18, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21, 18, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_2, 18, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_4, 18, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_5, 18, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_6, 18, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_9, 18, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_11, 18, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_26_1, 19, EntityDataTypes.INT)
            .build();

    /**
     * Supported versions: 1.19.4+
     */
    public static final EntityDataKey<SnifferState> STATE = EntityDataKey.<SnifferState>builder(SnifferDataKeys.class)
            .addVersion(ClientVersion.V_1_19_4, 17, EntityDataTypes.SNIFFER_STATE)
            .addVersion(ClientVersion.V_1_20_2, 17, EntityDataTypes.SNIFFER_STATE)
            .addVersion(ClientVersion.V_1_20_3, 17, EntityDataTypes.SNIFFER_STATE)
            .addVersion(ClientVersion.V_1_20_5, 17, EntityDataTypes.SNIFFER_STATE)
            .addVersion(ClientVersion.V_1_21, 17, EntityDataTypes.SNIFFER_STATE)
            .addVersion(ClientVersion.V_1_21_2, 17, EntityDataTypes.SNIFFER_STATE)
            .addVersion(ClientVersion.V_1_21_4, 17, EntityDataTypes.SNIFFER_STATE)
            .addVersion(ClientVersion.V_1_21_5, 17, EntityDataTypes.SNIFFER_STATE)
            .addVersion(ClientVersion.V_1_21_6, 17, EntityDataTypes.SNIFFER_STATE)
            .addVersion(ClientVersion.V_1_21_9, 17, EntityDataTypes.SNIFFER_STATE)
            .addVersion(ClientVersion.V_1_21_11, 17, EntityDataTypes.SNIFFER_STATE)
            .addVersion(ClientVersion.V_26_1, 18, EntityDataTypes.SNIFFER_STATE)
            .build();

}
