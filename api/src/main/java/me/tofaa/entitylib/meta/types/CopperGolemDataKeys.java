package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.entity.data.struct.CopperGolemState;
import com.github.retrooper.packetevents.protocol.entity.data.struct.WeatheringCopperState;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.VersionedMetadataKey;

/**
 * Supported versions: 1.21.9+
 */
public class CopperGolemDataKeys extends AbstractGolemDataKeys {

    /**
     * Supported versions: 1.21.9+
     */
    public static final VersionedMetadataKey<CopperGolemState> COPPER_GOLEM_STATE = VersionedMetadataKey.<CopperGolemState>builder()
            .add(ClientVersion.V_1_21_9, 17, EntityDataTypes.COPPER_GOLEM_STATE)
            .add(ClientVersion.V_1_21_11, 17, EntityDataTypes.COPPER_GOLEM_STATE)
            .add(ClientVersion.V_26_1, 17, EntityDataTypes.COPPER_GOLEM_STATE)
            .build();

    /**
     * Supported versions: 1.21.9+
     */
    public static final VersionedMetadataKey<WeatheringCopperState> WEATHER_STATE = VersionedMetadataKey.<WeatheringCopperState>builder()
            .add(ClientVersion.V_1_21_9, 16, EntityDataTypes.WEATHERING_COPPER_STATE)
            .add(ClientVersion.V_1_21_11, 16, EntityDataTypes.WEATHERING_COPPER_STATE)
            .add(ClientVersion.V_26_1, 16, EntityDataTypes.WEATHERING_COPPER_STATE)
            .build();

}
