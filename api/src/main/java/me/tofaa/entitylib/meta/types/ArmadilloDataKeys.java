package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.armadillo.ArmadilloState;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.VersionedMetadataKey;

/**
 * Supported versions: 1.20.5+
 */
public class ArmadilloDataKeys extends AnimalDataKeys {

    /**
     * Supported versions: 1.20.5+
     */
    public static final VersionedMetadataKey<ArmadilloState> ARMADILLO_STATE = VersionedMetadataKey.<ArmadilloState>builder()
            .add(ClientVersion.V_1_20_5, 17, EntityDataTypes.ARMADILLO_STATE)
            .add(ClientVersion.V_1_21, 17, EntityDataTypes.ARMADILLO_STATE)
            .add(ClientVersion.V_1_21_2, 17, EntityDataTypes.ARMADILLO_STATE)
            .add(ClientVersion.V_1_21_4, 17, EntityDataTypes.ARMADILLO_STATE)
            .add(ClientVersion.V_1_21_5, 17, EntityDataTypes.ARMADILLO_STATE)
            .add(ClientVersion.V_1_21_6, 17, EntityDataTypes.ARMADILLO_STATE)
            .add(ClientVersion.V_1_21_9, 17, EntityDataTypes.ARMADILLO_STATE)
            .add(ClientVersion.V_1_21_11, 17, EntityDataTypes.ARMADILLO_STATE)
            .add(ClientVersion.V_26_1, 18, EntityDataTypes.ARMADILLO_STATE)
            .build();

}
