// Auto-generated file. Do not edit manually.
package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.cow.CowSoundVariant;
import com.github.retrooper.packetevents.protocol.entity.cow.CowVariant;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.property.MetadataProperty;
import me.tofaa.entitylib.meta.property.SimpleProperty;

/**
 * Supported versions: All versions
 */
public class CowMetaProperties extends AnimalMetaProperties {

    /**
     * Supported versions: 26.1+
     */
    public static final SimpleProperty<CowSoundVariant> SOUND_VARIANT = MetadataProperty.<CowSoundVariant>builder(CowMetaProperties.class)
            .addVersion(ClientVersion.V_26_1, 19, EntityDataTypes.COW_SOUND_VARIANT)
            .build();

    /**
     * Supported versions: 1.21.5+
     */
    public static final SimpleProperty<CowVariant> VARIANT = MetadataProperty.<CowVariant>builder(CowMetaProperties.class)
            .addVersion(ClientVersion.V_1_21_5, 17, EntityDataTypes.COW_VARIANT)
            .addVersion(ClientVersion.V_1_21_6, 17, EntityDataTypes.COW_VARIANT)
            .addVersion(ClientVersion.V_1_21_9, 17, EntityDataTypes.COW_VARIANT)
            .addVersion(ClientVersion.V_1_21_11, 17, EntityDataTypes.COW_VARIANT)
            .addVersion(ClientVersion.V_26_1, 18, EntityDataTypes.COW_VARIANT)
            .build();

}
