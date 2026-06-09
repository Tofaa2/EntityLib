package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.VersionedMetadataKey;

import java.util.Optional;
import java.util.UUID;

/**
 * Supported versions: All versions
 */
public class FoxDataKeys extends AnimalDataKeys {

    /**
     * Supported versions: All versions
     */
    public static final VersionedMetadataKey<Byte> FLAGS = VersionedMetadataKey.<Byte>builder()
            .add(ClientVersion.V_1_14_4, 16, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_15, 17, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_16, 17, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_16_2, 17, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_17, 18, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_19, 18, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_19_1, 18, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_19_3, 18, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_19_4, 18, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_20_2, 18, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_20_3, 18, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_20_5, 18, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21, 18, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21_2, 18, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21_4, 18, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21_5, 18, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21_6, 18, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21_9, 18, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21_11, 18, EntityDataTypes.BYTE)
            .add(ClientVersion.V_26_1, 19, EntityDataTypes.BYTE)
            .build();

    /**
     * Supported versions: All versions
     */
    public static final VersionedMetadataKey<Optional<UUID>> TRUSTED_0 = VersionedMetadataKey.<Optional<UUID>>builder()
            .add(ClientVersion.V_1_14_4, 17, EntityDataTypes.OPTIONAL_UUID)
            .add(ClientVersion.V_1_15, 18, EntityDataTypes.OPTIONAL_UUID)
            .add(ClientVersion.V_1_16, 18, EntityDataTypes.OPTIONAL_UUID)
            .add(ClientVersion.V_1_16_2, 18, EntityDataTypes.OPTIONAL_UUID)
            .add(ClientVersion.V_1_17, 19, EntityDataTypes.OPTIONAL_UUID)
            .add(ClientVersion.V_1_19, 19, EntityDataTypes.OPTIONAL_UUID)
            .add(ClientVersion.V_1_19_1, 19, EntityDataTypes.OPTIONAL_UUID)
            .add(ClientVersion.V_1_19_3, 19, EntityDataTypes.OPTIONAL_UUID)
            .add(ClientVersion.V_1_19_4, 19, EntityDataTypes.OPTIONAL_UUID)
            .add(ClientVersion.V_1_20_2, 19, EntityDataTypes.OPTIONAL_UUID)
            .add(ClientVersion.V_1_20_3, 19, EntityDataTypes.OPTIONAL_UUID)
            .add(ClientVersion.V_1_20_5, 19, EntityDataTypes.OPTIONAL_UUID)
            .add(ClientVersion.V_1_21, 19, EntityDataTypes.OPTIONAL_UUID)
            .add(ClientVersion.V_1_21_2, 19, EntityDataTypes.OPTIONAL_UUID)
            .add(ClientVersion.V_1_21_4, 19, EntityDataTypes.OPTIONAL_UUID)
            .add(ClientVersion.V_1_21_5, 19, EntityDataTypes.OPTIONAL_UUID)
            .add(ClientVersion.V_1_21_6, 19, EntityDataTypes.OPTIONAL_UUID)
            .add(ClientVersion.V_1_21_9, 19, EntityDataTypes.OPTIONAL_UUID)
            .add(ClientVersion.V_1_21_11, 19, EntityDataTypes.OPTIONAL_UUID)
            .add(ClientVersion.V_26_1, 20, EntityDataTypes.OPTIONAL_UUID)
            .build();

    /**
     * Supported versions: All versions
     */
    public static final VersionedMetadataKey<Optional<UUID>> TRUSTED_1 = VersionedMetadataKey.<Optional<UUID>>builder()
            .add(ClientVersion.V_1_14_4, 18, EntityDataTypes.OPTIONAL_UUID)
            .add(ClientVersion.V_1_15, 19, EntityDataTypes.OPTIONAL_UUID)
            .add(ClientVersion.V_1_16, 19, EntityDataTypes.OPTIONAL_UUID)
            .add(ClientVersion.V_1_16_2, 19, EntityDataTypes.OPTIONAL_UUID)
            .add(ClientVersion.V_1_17, 20, EntityDataTypes.OPTIONAL_UUID)
            .add(ClientVersion.V_1_19, 20, EntityDataTypes.OPTIONAL_UUID)
            .add(ClientVersion.V_1_19_1, 20, EntityDataTypes.OPTIONAL_UUID)
            .add(ClientVersion.V_1_19_3, 20, EntityDataTypes.OPTIONAL_UUID)
            .add(ClientVersion.V_1_19_4, 20, EntityDataTypes.OPTIONAL_UUID)
            .add(ClientVersion.V_1_20_2, 20, EntityDataTypes.OPTIONAL_UUID)
            .add(ClientVersion.V_1_20_3, 20, EntityDataTypes.OPTIONAL_UUID)
            .add(ClientVersion.V_1_20_5, 20, EntityDataTypes.OPTIONAL_UUID)
            .add(ClientVersion.V_1_21, 20, EntityDataTypes.OPTIONAL_UUID)
            .add(ClientVersion.V_1_21_2, 20, EntityDataTypes.OPTIONAL_UUID)
            .add(ClientVersion.V_1_21_4, 20, EntityDataTypes.OPTIONAL_UUID)
            .add(ClientVersion.V_1_21_5, 20, EntityDataTypes.OPTIONAL_UUID)
            .add(ClientVersion.V_1_21_6, 20, EntityDataTypes.OPTIONAL_UUID)
            .add(ClientVersion.V_1_21_9, 20, EntityDataTypes.OPTIONAL_UUID)
            .add(ClientVersion.V_1_21_11, 20, EntityDataTypes.OPTIONAL_UUID)
            .add(ClientVersion.V_26_1, 21, EntityDataTypes.OPTIONAL_UUID)
            .build();

    /**
     * Supported versions: All versions
     */
    public static final VersionedMetadataKey<Integer> TYPE = VersionedMetadataKey.<Integer>builder()
            .add(ClientVersion.V_1_14_4, 15, EntityDataTypes.INT)
            .add(ClientVersion.V_1_15, 16, EntityDataTypes.INT)
            .add(ClientVersion.V_1_16, 16, EntityDataTypes.INT)
            .add(ClientVersion.V_1_16_2, 16, EntityDataTypes.INT)
            .add(ClientVersion.V_1_17, 17, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19, 17, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19_1, 17, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19_3, 17, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19_4, 17, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_2, 17, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_3, 17, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_5, 17, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21, 17, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_2, 17, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_4, 17, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_5, 17, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_6, 17, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_9, 17, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_11, 17, EntityDataTypes.INT)
            .add(ClientVersion.V_26_1, 18, EntityDataTypes.INT)
            .build();

}
