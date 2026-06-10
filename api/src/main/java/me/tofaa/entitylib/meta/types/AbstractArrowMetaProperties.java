// Auto-generated file. Do not edit manually.
package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.property.MetadataProperty;
import me.tofaa.entitylib.meta.property.SimpleProperty;

import java.util.Optional;
import java.util.UUID;

/**
 * Supported versions: All versions
 */
public class AbstractArrowMetaProperties extends EntityMetaProperties {

    /**
     * Supported versions: All versions
     */
    public static final SimpleProperty<Byte> ID_FLAGS = MetadataProperty.<Byte>builder(AbstractArrowMetaProperties.class)
            .addVersion(ClientVersion.V_1_14_4, 7, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_15, 7, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_16, 7, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_16_2, 7, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_17, 8, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_19, 8, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_19_1, 8, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_19_3, 8, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_19_4, 8, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_20_2, 8, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_20_3, 8, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_20_5, 8, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21, 8, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_2, 8, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_4, 8, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_5, 8, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_6, 8, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_9, 8, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_11, 8, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_26_1, 8, EntityDataTypes.BYTE)
            .build();

    /**
     * Supported versions: 1.21.2+
     */
    public static final SimpleProperty<Boolean> IN_GROUND = MetadataProperty.<Boolean>builder(AbstractArrowMetaProperties.class)
            .addVersion(ClientVersion.V_1_21_2, 10, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_4, 10, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_5, 10, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_6, 10, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_9, 10, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_11, 10, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_26_1, 10, EntityDataTypes.BOOLEAN)
            .build();

    /**
     * Supported versions: 1.15-
     */
    public static final SimpleProperty<Optional<UUID>> OWNERUUID = MetadataProperty.<Optional<UUID>>builder(AbstractArrowMetaProperties.class)
            .addVersion(ClientVersion.V_1_14_4, 8, EntityDataTypes.OPTIONAL_UUID)
            .addVersion(ClientVersion.V_1_15, 8, EntityDataTypes.OPTIONAL_UUID)
            .build();

    /**
     * Supported versions: All versions
     */
    public static final SimpleProperty<Byte> PIERCE_LEVEL = MetadataProperty.<Byte>builder(AbstractArrowMetaProperties.class)
            .addVersion(ClientVersion.V_1_14_4, 9, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_15, 9, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_16, 8, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_16_2, 8, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_17, 9, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_19, 9, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_19_1, 9, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_19_3, 9, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_19_4, 9, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_20_2, 9, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_20_3, 9, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_20_5, 9, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21, 9, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_2, 9, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_4, 9, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_5, 9, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_6, 9, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_9, 9, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_11, 9, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_26_1, 9, EntityDataTypes.BYTE)
            .build();

}
