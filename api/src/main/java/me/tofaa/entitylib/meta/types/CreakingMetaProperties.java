// Auto-generated file. Do not edit manually.
package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import com.github.retrooper.packetevents.util.Vector3i;
import me.tofaa.entitylib.meta.property.MetadataProperty;
import me.tofaa.entitylib.meta.property.SimpleProperty;

import java.util.Optional;

/**
 * Supported versions: 1.21.2+
 */
public class CreakingMetaProperties extends MonsterMetaProperties {

    /**
     * Supported versions: 1.21.2+
     */
    public static final SimpleProperty<Boolean> CAN_MOVE = MetadataProperty.<Boolean>builder(CreakingMetaProperties.class)
            .addVersion(ClientVersion.V_1_21_2, 16, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_4, 16, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_5, 16, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_6, 16, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_9, 16, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_11, 16, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_26_1, 16, EntityDataTypes.BOOLEAN)
            .build();

    /**
     * Supported versions: 1.21.4+
     */
    public static final SimpleProperty<Optional<Vector3i>> HOME_POS = MetadataProperty.<Optional<Vector3i>>builder(CreakingMetaProperties.class)
            .addVersion(ClientVersion.V_1_21_4, 19, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
            .addVersion(ClientVersion.V_1_21_5, 19, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
            .addVersion(ClientVersion.V_1_21_6, 19, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
            .addVersion(ClientVersion.V_1_21_9, 19, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
            .addVersion(ClientVersion.V_1_21_11, 19, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
            .addVersion(ClientVersion.V_26_1, 19, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
            .build();

    /**
     * Supported versions: 1.21.2+
     */
    public static final SimpleProperty<Boolean> IS_ACTIVE = MetadataProperty.<Boolean>builder(CreakingMetaProperties.class)
            .addVersion(ClientVersion.V_1_21_2, 17, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_4, 17, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_5, 17, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_6, 17, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_9, 17, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_11, 17, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_26_1, 17, EntityDataTypes.BOOLEAN)
            .build();

    /**
     * Supported versions: 1.21.4+
     */
    public static final SimpleProperty<Boolean> IS_TEARING_DOWN = MetadataProperty.<Boolean>builder(CreakingMetaProperties.class)
            .addVersion(ClientVersion.V_1_21_4, 18, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_5, 18, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_6, 18, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_9, 18, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_11, 18, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_26_1, 18, EntityDataTypes.BOOLEAN)
            .build();

}
