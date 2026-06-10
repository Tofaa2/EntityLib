// Auto-generated file. Do not edit manually.
package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.property.MetadataProperty;
import me.tofaa.entitylib.meta.property.SimpleProperty;

/**
 * Supported versions: 1.21.6+
 */
public class HappyGhastMetaProperties extends AnimalMetaProperties {

    /**
     * Supported versions: 1.21.6+
     */
    public static final SimpleProperty<Boolean> IS_LEASH_HOLDER = MetadataProperty.<Boolean>builder(HappyGhastMetaProperties.class)
            .addVersion(ClientVersion.V_1_21_6, 17, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_9, 17, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_11, 17, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_26_1, 18, EntityDataTypes.BOOLEAN)
            .build();

    /**
     * Supported versions: 1.21.6+
     */
    public static final SimpleProperty<Boolean> STAYS_STILL = MetadataProperty.<Boolean>builder(HappyGhastMetaProperties.class)
            .addVersion(ClientVersion.V_1_21_6, 18, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_9, 18, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_11, 18, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_26_1, 19, EntityDataTypes.BOOLEAN)
            .build();

}
