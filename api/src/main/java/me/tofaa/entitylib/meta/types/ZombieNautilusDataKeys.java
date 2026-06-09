package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.entity.nautilus.ZombieNautilusVariant;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.VersionedMetadataKey;

/**
 * Supported versions: 1.21.11+
 */
public class ZombieNautilusDataKeys extends AbstractNautilusDataKeys {

    /**
     * Supported versions: 1.21.11+
     */
    public static final VersionedMetadataKey<ZombieNautilusVariant> VARIANT = VersionedMetadataKey.<ZombieNautilusVariant>builder()
            .add(ClientVersion.V_1_21_11, 20, EntityDataTypes.ZOMBIE_NAUTILUS_VARIANT)
            .add(ClientVersion.V_26_1, 21, EntityDataTypes.ZOMBIE_NAUTILUS_VARIANT)
            .build();

}
