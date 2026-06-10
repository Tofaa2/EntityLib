// Auto-generated file. Do not edit manually.
package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.property.MetadataProperty;
import me.tofaa.entitylib.meta.property.SimpleProperty;

/**
 * Supported versions: 1.20.5+
 */
public class BoggedMetaProperties extends AbstractSkeletonMetaProperties {

    /**
     * Supported versions: 1.20.5+
     */
    public static final SimpleProperty<Boolean> SHEARED = MetadataProperty.<Boolean>builder(BoggedMetaProperties.class)
            .addVersion(ClientVersion.V_1_20_5, 16, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21, 16, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_2, 16, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_4, 16, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_5, 16, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_6, 16, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_9, 16, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_11, 16, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_26_1, 16, EntityDataTypes.BOOLEAN)
            .build();

}
