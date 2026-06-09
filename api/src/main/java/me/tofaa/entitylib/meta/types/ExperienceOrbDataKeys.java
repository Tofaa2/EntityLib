// Auto-generated file. Do not edit manually.
package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.EntityDataKey;

/**
 * Supported versions: All versions
 */
public class ExperienceOrbDataKeys extends EntityDataKeys {

    /**
     * Supported versions: 1.21.5+
     */
    public static final EntityDataKey<Integer> VALUE = EntityDataKey.<Integer>builder(ExperienceOrbDataKeys.class)
            .addVersion(ClientVersion.V_1_21_5, 8, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_6, 8, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_9, 8, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_11, 8, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_26_1, 8, EntityDataTypes.INT)
            .build();

}
