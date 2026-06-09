package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.VersionedMetadataKey;

import java.util.Optional;
import java.util.UUID;

/**
 * Supported versions: All versions
 */
public class AbstractHorseDataKeys extends AnimalDataKeys {

    /**
     * Supported versions: All versions
     */
    public static final VersionedMetadataKey<Byte> FLAGS = VersionedMetadataKey.<Byte>builder()
            .add(ClientVersion.V_1_14_4, 15, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_15, 16, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_16, 16, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_16_2, 16, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_17, 17, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_19, 17, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_19_1, 17, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_19_3, 17, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_19_4, 17, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_20_2, 17, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_20_3, 17, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_20_5, 17, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21, 17, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21_2, 17, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21_4, 17, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21_5, 17, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21_6, 17, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21_9, 17, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21_11, 17, EntityDataTypes.BYTE)
            .add(ClientVersion.V_26_1, 18, EntityDataTypes.BYTE)
            .build();

    /**
     * Supported versions: 1.19.3-
     */
    public static final VersionedMetadataKey<Optional<UUID>> OWNER_UUID = VersionedMetadataKey.<Optional<UUID>>builder()
            .add(ClientVersion.V_1_14_4, 16, EntityDataTypes.OPTIONAL_UUID)
            .add(ClientVersion.V_1_15, 17, EntityDataTypes.OPTIONAL_UUID)
            .add(ClientVersion.V_1_16, 17, EntityDataTypes.OPTIONAL_UUID)
            .add(ClientVersion.V_1_16_2, 17, EntityDataTypes.OPTIONAL_UUID)
            .add(ClientVersion.V_1_17, 18, EntityDataTypes.OPTIONAL_UUID)
            .add(ClientVersion.V_1_19, 18, EntityDataTypes.OPTIONAL_UUID)
            .add(ClientVersion.V_1_19_1, 18, EntityDataTypes.OPTIONAL_UUID)
            .add(ClientVersion.V_1_19_3, 18, EntityDataTypes.OPTIONAL_UUID)
            .build();

}
