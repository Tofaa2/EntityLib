// Auto-generated file. Do not edit manually.
package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.entity.villager.VillagerData;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.EntityDataKey;

/**
 * Supported versions: All versions
 */
public class ZombieVillagerDataKeys extends ZombieDataKeys {

    /**
     * Supported versions: All versions
     */
    public static final EntityDataKey<Boolean> CONVERTING = EntityDataKey.<Boolean>builder(ZombieVillagerDataKeys.class)
            .addVersion(ClientVersion.V_1_14_4, 17, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_15, 18, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_16, 18, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_16_2, 18, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_17, 19, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_19, 19, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_19_1, 19, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_19_3, 19, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_19_4, 19, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_20_2, 19, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_20_3, 19, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_20_5, 19, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21, 19, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_2, 19, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_4, 19, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_5, 19, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_6, 19, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_9, 19, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_11, 19, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_26_1, 19, EntityDataTypes.BOOLEAN)
            .build();

    /**
     * Supported versions: All versions
     */
    public static final EntityDataKey<VillagerData> VILLAGER_DATA = EntityDataKey.<VillagerData>builder(ZombieVillagerDataKeys.class)
            .addVersion(ClientVersion.V_1_14_4, 18, EntityDataTypes.VILLAGER_DATA)
            .addVersion(ClientVersion.V_1_15, 19, EntityDataTypes.VILLAGER_DATA)
            .addVersion(ClientVersion.V_1_16, 19, EntityDataTypes.VILLAGER_DATA)
            .addVersion(ClientVersion.V_1_16_2, 19, EntityDataTypes.VILLAGER_DATA)
            .addVersion(ClientVersion.V_1_17, 20, EntityDataTypes.VILLAGER_DATA)
            .addVersion(ClientVersion.V_1_19, 20, EntityDataTypes.VILLAGER_DATA)
            .addVersion(ClientVersion.V_1_19_1, 20, EntityDataTypes.VILLAGER_DATA)
            .addVersion(ClientVersion.V_1_19_3, 20, EntityDataTypes.VILLAGER_DATA)
            .addVersion(ClientVersion.V_1_19_4, 20, EntityDataTypes.VILLAGER_DATA)
            .addVersion(ClientVersion.V_1_20_2, 20, EntityDataTypes.VILLAGER_DATA)
            .addVersion(ClientVersion.V_1_20_3, 20, EntityDataTypes.VILLAGER_DATA)
            .addVersion(ClientVersion.V_1_20_5, 20, EntityDataTypes.VILLAGER_DATA)
            .addVersion(ClientVersion.V_1_21, 20, EntityDataTypes.VILLAGER_DATA)
            .addVersion(ClientVersion.V_1_21_2, 20, EntityDataTypes.VILLAGER_DATA)
            .addVersion(ClientVersion.V_1_21_4, 20, EntityDataTypes.VILLAGER_DATA)
            .addVersion(ClientVersion.V_1_21_5, 20, EntityDataTypes.VILLAGER_DATA)
            .addVersion(ClientVersion.V_1_21_6, 20, EntityDataTypes.VILLAGER_DATA)
            .addVersion(ClientVersion.V_1_21_9, 20, EntityDataTypes.VILLAGER_DATA)
            .addVersion(ClientVersion.V_1_21_11, 20, EntityDataTypes.VILLAGER_DATA)
            .addVersion(ClientVersion.V_26_1, 20, EntityDataTypes.VILLAGER_DATA)
            .build();

    /**
     * Supported versions: 26.1+
     */
    public static final EntityDataKey<Boolean> VILLAGER_FINALIZED = EntityDataKey.<Boolean>builder(ZombieVillagerDataKeys.class)
            .addVersion(ClientVersion.V_26_1, 21, EntityDataTypes.BOOLEAN)
            .build();

}
