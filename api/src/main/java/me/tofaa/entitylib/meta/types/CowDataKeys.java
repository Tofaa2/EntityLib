// Auto-generated file. Do not edit manually.
package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.cow.CowSoundVariant;
import com.github.retrooper.packetevents.protocol.entity.cow.CowVariant;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.EntityDataKey;

/**
 * Supported versions: All versions
 */
public class CowDataKeys extends AnimalDataKeys {

    /**
     * Supported versions: 26.1+
     */
    public static final EntityDataKey<CowSoundVariant> SOUND_VARIANT = EntityDataKey.<CowSoundVariant>builder(CowDataKeys.class)
            .addVersion(ClientVersion.V_26_1, 19, EntityDataTypes.COW_SOUND_VARIANT)
            .build();

    /**
     * Supported versions: 1.21.5+
     */
    public static final EntityDataKey<CowVariant> VARIANT = EntityDataKey.<CowVariant>builder(CowDataKeys.class)
            .addVersion(ClientVersion.V_1_21_5, 17, EntityDataTypes.COW_VARIANT)
            .addVersion(ClientVersion.V_1_21_6, 17, EntityDataTypes.COW_VARIANT)
            .addVersion(ClientVersion.V_1_21_9, 17, EntityDataTypes.COW_VARIANT)
            .addVersion(ClientVersion.V_1_21_11, 17, EntityDataTypes.COW_VARIANT)
            .addVersion(ClientVersion.V_26_1, 18, EntityDataTypes.COW_VARIANT)
            .build();

}
