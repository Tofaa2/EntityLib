package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import com.github.retrooper.packetevents.util.Vector3i;
import me.tofaa.entitylib.meta.VersionedMetadataKey;

import java.util.Optional;

/**
 * Supported versions: 1.21.2+
 */
public class CreakingDataKeys extends MonsterDataKeys {

    /**
     * Supported versions: 1.21.2+
     */
    public static final VersionedMetadataKey<Boolean> CAN_MOVE = VersionedMetadataKey.<Boolean>builder()
            .add(ClientVersion.V_1_21_2, 16, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_4, 16, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_5, 16, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_6, 16, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_9, 16, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_11, 16, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_26_1, 16, EntityDataTypes.BOOLEAN)
            .build();

    /**
     * Supported versions: 1.21.4+
     */
    public static final VersionedMetadataKey<Optional<Vector3i>> HOME_POS = VersionedMetadataKey.<Optional<Vector3i>>builder()
            .add(ClientVersion.V_1_21_4, 19, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
            .add(ClientVersion.V_1_21_5, 19, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
            .add(ClientVersion.V_1_21_6, 19, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
            .add(ClientVersion.V_1_21_9, 19, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
            .add(ClientVersion.V_1_21_11, 19, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
            .add(ClientVersion.V_26_1, 19, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
            .build();

    /**
     * Supported versions: 1.21.2+
     */
    public static final VersionedMetadataKey<Boolean> IS_ACTIVE = VersionedMetadataKey.<Boolean>builder()
            .add(ClientVersion.V_1_21_2, 17, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_4, 17, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_5, 17, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_6, 17, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_9, 17, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_11, 17, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_26_1, 17, EntityDataTypes.BOOLEAN)
            .build();

    /**
     * Supported versions: 1.21.4+
     */
    public static final VersionedMetadataKey<Boolean> IS_TEARING_DOWN = VersionedMetadataKey.<Boolean>builder()
            .add(ClientVersion.V_1_21_4, 18, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_5, 18, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_6, 18, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_9, 18, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_11, 18, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_26_1, 18, EntityDataTypes.BOOLEAN)
            .build();

}
