// Auto-generated file. Do not edit manually.
package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.EntityDataKey;

/**
 * Supported versions: 1.21.11+
 */
public class AbstractNautilusDataKeys extends TamableAnimalDataKeys {

    /**
     * Supported versions: 1.21.11+
     */
    public static final EntityDataKey<Boolean> DASH = EntityDataKey.<Boolean>builder(AbstractNautilusDataKeys.class)
            .addVersion(ClientVersion.V_1_21_11, 19, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_26_1, 20, EntityDataTypes.BOOLEAN)
            .build();

}
