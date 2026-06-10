// Auto-generated file. Do not edit manually.
package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.armadillo.ArmadilloState;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.property.MetadataProperty;
import me.tofaa.entitylib.meta.property.SimpleProperty;

/**
 * Supported versions: 1.20.5+
 */
public class ArmadilloMetaProperties extends AnimalMetaProperties {

    /**
     * Supported versions: 1.20.5+
     */
    public static final SimpleProperty<ArmadilloState> ARMADILLO_STATE = MetadataProperty.<ArmadilloState>builder(ArmadilloMetaProperties.class)
            .addVersion(ClientVersion.V_1_20_5, 17, EntityDataTypes.ARMADILLO_STATE)
            .addVersion(ClientVersion.V_1_21, 17, EntityDataTypes.ARMADILLO_STATE)
            .addVersion(ClientVersion.V_1_21_2, 17, EntityDataTypes.ARMADILLO_STATE)
            .addVersion(ClientVersion.V_1_21_4, 17, EntityDataTypes.ARMADILLO_STATE)
            .addVersion(ClientVersion.V_1_21_5, 17, EntityDataTypes.ARMADILLO_STATE)
            .addVersion(ClientVersion.V_1_21_6, 17, EntityDataTypes.ARMADILLO_STATE)
            .addVersion(ClientVersion.V_1_21_9, 17, EntityDataTypes.ARMADILLO_STATE)
            .addVersion(ClientVersion.V_1_21_11, 17, EntityDataTypes.ARMADILLO_STATE)
            .addVersion(ClientVersion.V_26_1, 18, EntityDataTypes.ARMADILLO_STATE)
            .build();

}
