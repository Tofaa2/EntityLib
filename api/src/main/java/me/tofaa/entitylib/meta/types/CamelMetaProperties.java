// Auto-generated file. Do not edit manually.
package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.property.MetadataProperty;
import me.tofaa.entitylib.meta.property.SimpleProperty;

/**
 * Supported versions: 1.19.3+
 */
public class CamelMetaProperties extends AbstractHorseMetaProperties {

    /**
     * Supported versions: 1.19.3+
     */
    public static final SimpleProperty<Boolean> DASH = MetadataProperty.<Boolean>builder(CamelMetaProperties.class)
            .addVersion(ClientVersion.V_1_19_3, 19, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_19_4, 18, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_20_2, 18, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_20_3, 18, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_20_5, 18, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21, 18, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_2, 18, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_4, 18, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_5, 18, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_6, 18, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_9, 18, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_11, 18, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_26_1, 19, EntityDataTypes.BOOLEAN)
            .build();

    /**
     * Supported versions: 1.19.3+
     */
    public static final SimpleProperty<Long> LAST_POSE_CHANGE_TICK = MetadataProperty.<Long>builder(CamelMetaProperties.class)
            .addVersion(ClientVersion.V_1_19_3, 20, EntityDataTypes.LONG)
            .addVersion(ClientVersion.V_1_19_4, 19, EntityDataTypes.LONG)
            .addVersion(ClientVersion.V_1_20_2, 19, EntityDataTypes.LONG)
            .addVersion(ClientVersion.V_1_20_3, 19, EntityDataTypes.LONG)
            .addVersion(ClientVersion.V_1_20_5, 19, EntityDataTypes.LONG)
            .addVersion(ClientVersion.V_1_21, 19, EntityDataTypes.LONG)
            .addVersion(ClientVersion.V_1_21_2, 19, EntityDataTypes.LONG)
            .addVersion(ClientVersion.V_1_21_4, 19, EntityDataTypes.LONG)
            .addVersion(ClientVersion.V_1_21_5, 19, EntityDataTypes.LONG)
            .addVersion(ClientVersion.V_1_21_6, 19, EntityDataTypes.LONG)
            .addVersion(ClientVersion.V_1_21_9, 19, EntityDataTypes.LONG)
            .addVersion(ClientVersion.V_1_21_11, 19, EntityDataTypes.LONG)
            .addVersion(ClientVersion.V_26_1, 20, EntityDataTypes.LONG)
            .build();

}
