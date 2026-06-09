package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.VersionedMetadataKey;

/**
 * Supported versions: All versions
 */
public class ExperienceOrbDataKeys extends EntityDataKeys {

    /**
     * Supported versions: 1.21.5+
     */
    public static final VersionedMetadataKey<Integer> VALUE = VersionedMetadataKey.<Integer>builder()
            .add(ClientVersion.V_1_21_5, 8, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_6, 8, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_9, 8, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_11, 8, EntityDataTypes.INT)
            .add(ClientVersion.V_26_1, 8, EntityDataTypes.INT)
            .build();

}
