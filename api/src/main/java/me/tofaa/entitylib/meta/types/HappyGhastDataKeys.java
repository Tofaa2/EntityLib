package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.VersionedMetadataKey;

/**
 * Supported versions: 1.21.6+
 */
public class HappyGhastDataKeys extends AnimalDataKeys {

    /**
     * Supported versions: 1.21.6+
     */
    public static final VersionedMetadataKey<Boolean> IS_LEASH_HOLDER = VersionedMetadataKey.<Boolean>builder()
            .add(ClientVersion.V_1_21_6, 17, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_9, 17, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_11, 17, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_26_1, 18, EntityDataTypes.BOOLEAN)
            .build();

    /**
     * Supported versions: 1.21.6+
     */
    public static final VersionedMetadataKey<Boolean> STAYS_STILL = VersionedMetadataKey.<Boolean>builder()
            .add(ClientVersion.V_1_21_6, 18, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_9, 18, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_11, 18, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_26_1, 19, EntityDataTypes.BOOLEAN)
            .build();

}
