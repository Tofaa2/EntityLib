package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.VersionedMetadataKey;

/**
 * Supported versions: All versions
 */
public class MobDataKeys extends LivingEntityDataKeys {

    /**
     * Supported versions: All versions
     */
    public static final VersionedMetadataKey<Byte> MOB_FLAGS = VersionedMetadataKey.<Byte>builder()
            .add(ClientVersion.V_1_14_4, 13, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_15, 14, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_16, 14, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_16_2, 14, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_17, 15, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_19, 15, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_19_1, 15, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_19_3, 15, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_19_4, 15, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_20_2, 15, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_20_3, 15, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_20_5, 15, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21, 15, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21_2, 15, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21_4, 15, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21_5, 15, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21_6, 15, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21_9, 15, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21_11, 15, EntityDataTypes.BYTE)
            .add(ClientVersion.V_26_1, 15, EntityDataTypes.BYTE)
            .build();

}
