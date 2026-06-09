// Auto-generated file. Do not edit manually.
package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.EntityDataKey;

/**
 * Supported versions: 1.16.2-
 */
public class AgableMobDataKeys extends PathfinderMobDataKeys {

    /**
     * Supported versions: 1.16.2-
     */
    public static final EntityDataKey<Boolean> BABY = EntityDataKey.<Boolean>builder(AgableMobDataKeys.class)
            .addVersion(ClientVersion.V_1_14_4, 14, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_15, 15, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_16, 15, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_16_2, 15, EntityDataTypes.BOOLEAN)
            .build();

}
