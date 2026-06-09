package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.VersionedMetadataKey;

/**
 * Supported versions: All versions
 */
public class PhantomDataKeys extends FlyingMobDataKeys {

    /**
     * Supported versions: All versions
     */
    public static final VersionedMetadataKey<Integer> ID_SIZE = VersionedMetadataKey.<Integer>builder()
            .add(ClientVersion.V_1_14_4, 14, EntityDataTypes.INT)
            .add(ClientVersion.V_1_15, 15, EntityDataTypes.INT)
            .add(ClientVersion.V_1_16, 15, EntityDataTypes.INT)
            .add(ClientVersion.V_1_16_2, 15, EntityDataTypes.INT)
            .add(ClientVersion.V_1_17, 16, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19, 16, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19_1, 16, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19_3, 16, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19_4, 16, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_2, 16, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_3, 16, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_5, 16, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21, 16, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_2, 16, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_4, 16, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_5, 16, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_6, 16, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_9, 16, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_11, 16, EntityDataTypes.INT)
            .add(ClientVersion.V_26_1, 16, EntityDataTypes.INT)
            .build();

}
