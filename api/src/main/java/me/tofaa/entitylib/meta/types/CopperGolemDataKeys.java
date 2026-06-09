// Auto-generated file. Do not edit manually.
package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.entity.data.struct.CopperGolemState;
import com.github.retrooper.packetevents.protocol.entity.data.struct.WeatheringCopperState;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.EntityDataKey;

/**
 * Supported versions: 1.21.9+
 */
public class CopperGolemDataKeys extends AbstractGolemDataKeys {

    /**
     * Supported versions: 1.21.9+
     */
    public static final EntityDataKey<CopperGolemState> COPPER_GOLEM_STATE = EntityDataKey.<CopperGolemState>builder(CopperGolemDataKeys.class)
            .addVersion(ClientVersion.V_1_21_9, 17, EntityDataTypes.COPPER_GOLEM_STATE)
            .addVersion(ClientVersion.V_1_21_11, 17, EntityDataTypes.COPPER_GOLEM_STATE)
            .addVersion(ClientVersion.V_26_1, 17, EntityDataTypes.COPPER_GOLEM_STATE)
            .build();

    /**
     * Supported versions: 1.21.9+
     */
    public static final EntityDataKey<WeatheringCopperState> WEATHER_STATE = EntityDataKey.<WeatheringCopperState>builder(CopperGolemDataKeys.class)
            .addVersion(ClientVersion.V_1_21_9, 16, EntityDataTypes.WEATHERING_COPPER_STATE)
            .addVersion(ClientVersion.V_1_21_11, 16, EntityDataTypes.WEATHERING_COPPER_STATE)
            .addVersion(ClientVersion.V_26_1, 16, EntityDataTypes.WEATHERING_COPPER_STATE)
            .build();

}
