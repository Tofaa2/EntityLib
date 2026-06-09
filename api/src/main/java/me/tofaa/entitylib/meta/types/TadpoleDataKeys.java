package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.VersionedMetadataKey;

/**
 * Supported versions: 1.19+
 */
public class TadpoleDataKeys extends AbstractFishDataKeys {

    /**
     * Supported versions: 26.1+
     */
    public static final VersionedMetadataKey<Boolean> AGE_LOCKED = VersionedMetadataKey.<Boolean>builder()
            .add(ClientVersion.V_26_1, 17, EntityDataTypes.BOOLEAN)
            .build();

}
