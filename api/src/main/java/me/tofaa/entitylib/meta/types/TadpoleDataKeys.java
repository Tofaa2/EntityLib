// Auto-generated file. Do not edit manually.
package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.EntityDataKey;

/**
 * Supported versions: 1.19+
 */
public class TadpoleDataKeys extends AbstractFishDataKeys {

    /**
     * Supported versions: 26.1+
     */
    public static final EntityDataKey<Boolean> AGE_LOCKED = EntityDataKey.<Boolean>builder(TadpoleDataKeys.class)
            .addVersion(ClientVersion.V_26_1, 17, EntityDataTypes.BOOLEAN)
            .build();

}
