package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.VersionedMetadataKey;

/**
 * Supported versions: All versions
 */
public class SalmonDataKeys extends AbstractSchoolingFishDataKeys {

    /**
     * Supported versions: 1.21.2+
     */
    public static final VersionedMetadataKey<Integer> TYPE = VersionedMetadataKey.<Integer>builder()
            .add(ClientVersion.V_1_21_2, 17, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_4, 17, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_5, 17, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_6, 17, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_9, 17, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_11, 17, EntityDataTypes.INT)
            .add(ClientVersion.V_26_1, 17, EntityDataTypes.INT)
            .build();

}
