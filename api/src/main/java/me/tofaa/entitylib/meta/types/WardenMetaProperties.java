// Auto-generated file. Do not edit manually.
package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.property.MetadataProperty;
import me.tofaa.entitylib.meta.property.SimpleProperty;

/**
 * Supported versions: 1.19+
 */
public class WardenMetaProperties extends MonsterMetaProperties {

    /**
     * Supported versions: 1.19+
     */
    public static final SimpleProperty<Integer> CLIENT_ANGER_LEVEL = MetadataProperty.<Integer>builder(WardenMetaProperties.class)
            .addVersion(ClientVersion.V_1_19, 16, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_19_1, 16, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_19_3, 16, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_19_4, 16, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_20_2, 16, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_20_3, 16, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_20_5, 16, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21, 16, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_2, 16, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_4, 16, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_5, 16, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_6, 16, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_9, 16, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_11, 16, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_26_1, 16, EntityDataTypes.INT)
            .build();

}
