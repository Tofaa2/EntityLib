// Auto-generated file. Do not edit manually.
package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.EntityDataKey;

/**
 * Supported versions: 1.16.2+
 */
public class AbstractPiglinDataKeys extends MonsterDataKeys {

    /**
     * Supported versions: 1.16.2+
     */
    public static final EntityDataKey<Boolean> IMMUNE_TO_ZOMBIFICATION = EntityDataKey.<Boolean>builder(AbstractPiglinDataKeys.class)
            .addVersion(ClientVersion.V_1_16_2, 15, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_17, 16, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_19, 16, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_19_1, 16, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_19_3, 16, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_19_4, 16, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_20_2, 16, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_20_3, 16, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_20_5, 16, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21, 16, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_2, 16, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_4, 16, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_5, 16, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_6, 16, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_9, 16, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_11, 16, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_26_1, 16, EntityDataTypes.BOOLEAN)
            .build();

}
