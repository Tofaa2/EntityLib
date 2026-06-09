// Auto-generated file. Do not edit manually.
package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.EntityDataKey;

/**
 * Supported versions: 1.21.6+
 */
public class HappyGhastDataKeys extends AnimalDataKeys {

    /**
     * Supported versions: 1.21.6+
     */
    public static final EntityDataKey<Boolean> IS_LEASH_HOLDER = EntityDataKey.<Boolean>builder(HappyGhastDataKeys.class)
            .addVersion(ClientVersion.V_1_21_6, 17, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_9, 17, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_11, 17, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_26_1, 18, EntityDataTypes.BOOLEAN)
            .build();

    /**
     * Supported versions: 1.21.6+
     */
    public static final EntityDataKey<Boolean> STAYS_STILL = EntityDataKey.<Boolean>builder(HappyGhastDataKeys.class)
            .addVersion(ClientVersion.V_1_21_6, 18, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_9, 18, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_11, 18, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_26_1, 19, EntityDataTypes.BOOLEAN)
            .build();

}
