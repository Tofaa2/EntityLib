// Auto-generated file. Do not edit manually.
package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.entity.nautilus.ZombieNautilusVariant;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.property.MetadataProperty;
import me.tofaa.entitylib.meta.property.SimpleProperty;

/**
 * Supported versions: 1.21.11+
 */
public class ZombieNautilusMetaProperties extends AbstractNautilusMetaProperties {

    /**
     * Supported versions: 1.21.11+
     */
    public static final SimpleProperty<ZombieNautilusVariant> VARIANT = MetadataProperty.<ZombieNautilusVariant>builder(ZombieNautilusMetaProperties.class)
            .addVersion(ClientVersion.V_1_21_11, 20, EntityDataTypes.ZOMBIE_NAUTILUS_VARIANT)
            .addVersion(ClientVersion.V_26_1, 21, EntityDataTypes.ZOMBIE_NAUTILUS_VARIANT)
            .build();

}
