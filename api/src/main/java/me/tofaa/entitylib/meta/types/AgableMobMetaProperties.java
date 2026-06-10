// Auto-generated file. Do not edit manually.
package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.property.MetadataProperty;
import me.tofaa.entitylib.meta.property.SimpleProperty;

/**
 * Supported versions: 1.16.2-
 */
public class AgableMobMetaProperties extends PathfinderMobMetaProperties {

    /**
     * Supported versions: 1.16.2-
     */
    public static final SimpleProperty<Boolean> BABY = MetadataProperty.<Boolean>builder(AgableMobMetaProperties.class)
            .addVersion(ClientVersion.V_1_14_4, 14, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_15, 15, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_16, 15, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_16_2, 15, EntityDataTypes.BOOLEAN)
            .build();

}
