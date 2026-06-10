// Auto-generated file. Do not edit manually.
package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.property.MetadataProperty;
import me.tofaa.entitylib.meta.property.SimpleProperty;

/**
 * Supported versions: 1.21.2+
 */
public class AbstractBoatMetaProperties extends VehicleEntityMetaProperties {

    /**
     * Supported versions: 1.21.2+
     */
    public static final SimpleProperty<Integer> BUBBLE_TIME = MetadataProperty.<Integer>builder(AbstractBoatMetaProperties.class)
            .addVersion(ClientVersion.V_1_21_2, 13, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_4, 13, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_5, 13, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_6, 13, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_9, 13, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_11, 13, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_26_1, 13, EntityDataTypes.INT)
            .build();

    /**
     * Supported versions: 1.21.2+
     */
    public static final SimpleProperty<Boolean> PADDLE_LEFT = MetadataProperty.<Boolean>builder(AbstractBoatMetaProperties.class)
            .addVersion(ClientVersion.V_1_21_2, 11, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_4, 11, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_5, 11, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_6, 11, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_9, 11, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_11, 11, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_26_1, 11, EntityDataTypes.BOOLEAN)
            .build();

    /**
     * Supported versions: 1.21.2+
     */
    public static final SimpleProperty<Boolean> PADDLE_RIGHT = MetadataProperty.<Boolean>builder(AbstractBoatMetaProperties.class)
            .addVersion(ClientVersion.V_1_21_2, 12, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_4, 12, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_5, 12, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_6, 12, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_9, 12, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_11, 12, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_26_1, 12, EntityDataTypes.BOOLEAN)
            .build();

}
