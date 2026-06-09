package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.cow.CowSoundVariant;
import com.github.retrooper.packetevents.protocol.entity.cow.CowVariant;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.VersionedMetadataKey;

/**
 * Supported versions: All versions
 */
public class CowDataKeys extends AnimalDataKeys {

    /**
     * Supported versions: 26.1+
     */
    public static final VersionedMetadataKey<CowSoundVariant> SOUND_VARIANT = VersionedMetadataKey.<CowSoundVariant>builder()
            .add(ClientVersion.V_26_1, 19, EntityDataTypes.COW_SOUND_VARIANT)
            .build();

    /**
     * Supported versions: 1.21.5+
     */
    public static final VersionedMetadataKey<CowVariant> VARIANT = VersionedMetadataKey.<CowVariant>builder()
            .add(ClientVersion.V_1_21_5, 17, EntityDataTypes.COW_VARIANT)
            .add(ClientVersion.V_1_21_6, 17, EntityDataTypes.COW_VARIANT)
            .add(ClientVersion.V_1_21_9, 17, EntityDataTypes.COW_VARIANT)
            .add(ClientVersion.V_1_21_11, 17, EntityDataTypes.COW_VARIANT)
            .add(ClientVersion.V_26_1, 18, EntityDataTypes.COW_VARIANT)
            .build();

}
