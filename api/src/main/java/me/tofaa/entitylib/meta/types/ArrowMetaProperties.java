// Auto-generated file. Do not edit manually.
package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.property.MetadataProperty;
import me.tofaa.entitylib.meta.property.SimpleProperty;

/**
 * Supported versions: All versions
 */
public class ArrowMetaProperties extends AbstractArrowMetaProperties {

    /**
     * Supported versions: All versions
     */
    public static final SimpleProperty<Integer> ID_EFFECT_COLOR = MetadataProperty.<Integer>builder(ArrowMetaProperties.class)
            .addVersion(ClientVersion.V_1_14_4, 10, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_15, 10, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_16, 9, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_16_2, 9, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_17, 10, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_19, 10, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_19_1, 10, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_19_3, 10, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_19_4, 10, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_20_2, 10, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_20_3, 10, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_20_5, 10, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21, 10, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_2, 11, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_4, 11, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_5, 11, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_6, 11, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_9, 11, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_11, 11, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_26_1, 11, EntityDataTypes.INT)
            .build();

}
