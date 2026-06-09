package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.entity.villager.VillagerData;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.VersionedMetadataKey;

/**
 * Supported versions: All versions
 */
public class VillagerDataKeys extends AbstractVillagerDataKeys {

    /**
     * Supported versions: All versions
     */
    public static final VersionedMetadataKey<VillagerData> VILLAGER_DATA = VersionedMetadataKey.<VillagerData>builder()
            .add(ClientVersion.V_1_14_4, 16, EntityDataTypes.VILLAGER_DATA)
            .add(ClientVersion.V_1_15, 17, EntityDataTypes.VILLAGER_DATA)
            .add(ClientVersion.V_1_16, 17, EntityDataTypes.VILLAGER_DATA)
            .add(ClientVersion.V_1_16_2, 17, EntityDataTypes.VILLAGER_DATA)
            .add(ClientVersion.V_1_17, 18, EntityDataTypes.VILLAGER_DATA)
            .add(ClientVersion.V_1_19, 18, EntityDataTypes.VILLAGER_DATA)
            .add(ClientVersion.V_1_19_1, 18, EntityDataTypes.VILLAGER_DATA)
            .add(ClientVersion.V_1_19_3, 18, EntityDataTypes.VILLAGER_DATA)
            .add(ClientVersion.V_1_19_4, 18, EntityDataTypes.VILLAGER_DATA)
            .add(ClientVersion.V_1_20_2, 18, EntityDataTypes.VILLAGER_DATA)
            .add(ClientVersion.V_1_20_3, 18, EntityDataTypes.VILLAGER_DATA)
            .add(ClientVersion.V_1_20_5, 18, EntityDataTypes.VILLAGER_DATA)
            .add(ClientVersion.V_1_21, 18, EntityDataTypes.VILLAGER_DATA)
            .add(ClientVersion.V_1_21_2, 18, EntityDataTypes.VILLAGER_DATA)
            .add(ClientVersion.V_1_21_4, 18, EntityDataTypes.VILLAGER_DATA)
            .add(ClientVersion.V_1_21_5, 18, EntityDataTypes.VILLAGER_DATA)
            .add(ClientVersion.V_1_21_6, 18, EntityDataTypes.VILLAGER_DATA)
            .add(ClientVersion.V_1_21_9, 18, EntityDataTypes.VILLAGER_DATA)
            .add(ClientVersion.V_1_21_11, 18, EntityDataTypes.VILLAGER_DATA)
            .add(ClientVersion.V_26_1, 19, EntityDataTypes.VILLAGER_DATA)
            .build();

    /**
     * Supported versions: 26.1+
     */
    public static final VersionedMetadataKey<Boolean> VILLAGER_FINALIZED = VersionedMetadataKey.<Boolean>builder()
            .add(ClientVersion.V_26_1, 20, EntityDataTypes.BOOLEAN)
            .build();

}
