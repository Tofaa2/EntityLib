package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.VersionedMetadataKey;

/**
 * Supported versions: 1.17+
 */
public class AgeableMobDataKeys extends PathfinderMobDataKeys {

    /**
     * Supported versions: 26.1+
     */
    public static final VersionedMetadataKey<Boolean> AGE_LOCKED = VersionedMetadataKey.<Boolean>builder()
            .add(ClientVersion.V_26_1, 17, EntityDataTypes.BOOLEAN)
            .build();

    /**
     * Supported versions: 1.17+
     */
    public static final VersionedMetadataKey<Boolean> BABY = VersionedMetadataKey.<Boolean>builder()
            .add(ClientVersion.V_1_17, 16, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_19, 16, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_19_1, 16, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_19_3, 16, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_19_4, 16, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_20_2, 16, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_20_3, 16, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_20_5, 16, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21, 16, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_2, 16, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_4, 16, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_5, 16, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_6, 16, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_9, 16, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_11, 16, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_26_1, 16, EntityDataTypes.BOOLEAN)
            .build();

}
