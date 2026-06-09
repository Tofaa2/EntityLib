package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.VersionedMetadataKey;

/**
 * Supported versions: 1.16.2-
 */
public class AgableMobDataKeys extends PathfinderMobDataKeys {

    /**
     * Supported versions: 1.16.2-
     */
    public static final VersionedMetadataKey<Boolean> BABY = VersionedMetadataKey.<Boolean>builder()
            .add(ClientVersion.V_1_14_4, 14, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_15, 15, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_16, 15, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_16_2, 15, EntityDataTypes.BOOLEAN)
            .build();

}
