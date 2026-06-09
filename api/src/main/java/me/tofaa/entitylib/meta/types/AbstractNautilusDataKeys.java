package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.VersionedMetadataKey;

/**
 * Supported versions: 1.21.11+
 */
public class AbstractNautilusDataKeys extends TamableAnimalDataKeys {

    /**
     * Supported versions: 1.21.11+
     */
    public static final VersionedMetadataKey<Boolean> DASH = VersionedMetadataKey.<Boolean>builder()
            .add(ClientVersion.V_1_21_11, 19, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_26_1, 20, EntityDataTypes.BOOLEAN)
            .build();

}
