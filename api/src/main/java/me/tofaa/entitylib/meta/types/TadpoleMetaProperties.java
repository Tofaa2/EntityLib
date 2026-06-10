// Auto-generated file. Do not edit manually.
package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.property.MetadataProperty;
import me.tofaa.entitylib.meta.property.SimpleProperty;

/**
 * Supported versions: 1.19+
 */
public class TadpoleMetaProperties extends AbstractFishMetaProperties {

    /**
     * Supported versions: 26.1+
     */
    public static final SimpleProperty<Boolean> AGE_LOCKED = MetadataProperty.<Boolean>builder(TadpoleMetaProperties.class)
            .addVersion(ClientVersion.V_26_1, 17, EntityDataTypes.BOOLEAN)
            .build();

}
