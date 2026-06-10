// Auto-generated file. Do not edit manually.
package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.property.MetadataProperty;
import me.tofaa.entitylib.meta.property.SimpleProperty;

/**
 * Supported versions: 1.20.3+
 */
public class VehicleEntityMetaProperties extends EntityMetaProperties {

    /**
     * Supported versions: 1.20.3+
     */
    public static final SimpleProperty<Float> DAMAGE = MetadataProperty.<Float>builder(VehicleEntityMetaProperties.class)
            .addVersion(ClientVersion.V_1_20_3, 10, EntityDataTypes.FLOAT)
            .addVersion(ClientVersion.V_1_20_5, 10, EntityDataTypes.FLOAT)
            .addVersion(ClientVersion.V_1_21, 10, EntityDataTypes.FLOAT)
            .addVersion(ClientVersion.V_1_21_2, 10, EntityDataTypes.FLOAT)
            .addVersion(ClientVersion.V_1_21_4, 10, EntityDataTypes.FLOAT)
            .addVersion(ClientVersion.V_1_21_5, 10, EntityDataTypes.FLOAT)
            .addVersion(ClientVersion.V_1_21_6, 10, EntityDataTypes.FLOAT)
            .addVersion(ClientVersion.V_1_21_9, 10, EntityDataTypes.FLOAT)
            .addVersion(ClientVersion.V_1_21_11, 10, EntityDataTypes.FLOAT)
            .addVersion(ClientVersion.V_26_1, 10, EntityDataTypes.FLOAT)
            .build();

    /**
     * Supported versions: 1.20.3+
     */
    public static final SimpleProperty<Integer> HURT = MetadataProperty.<Integer>builder(VehicleEntityMetaProperties.class)
            .addVersion(ClientVersion.V_1_20_3, 8, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_20_5, 8, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21, 8, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_2, 8, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_4, 8, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_5, 8, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_6, 8, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_9, 8, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_11, 8, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_26_1, 8, EntityDataTypes.INT)
            .build();

    /**
     * Supported versions: 1.20.3+
     */
    public static final SimpleProperty<Integer> HURTDIR = MetadataProperty.<Integer>builder(VehicleEntityMetaProperties.class)
            .addVersion(ClientVersion.V_1_20_3, 9, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_20_5, 9, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21, 9, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_2, 9, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_4, 9, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_5, 9, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_6, 9, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_9, 9, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_11, 9, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_26_1, 9, EntityDataTypes.INT)
            .build();

}
