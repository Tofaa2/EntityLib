// Auto-generated file. Do not edit manually.
package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.chicken.ChickenSoundVariant;
import com.github.retrooper.packetevents.protocol.entity.chicken.ChickenVariant;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.property.MetadataProperty;
import me.tofaa.entitylib.meta.property.SimpleProperty;

/**
 * Supported versions: All versions
 */
public class ChickenMetaProperties extends AnimalMetaProperties {

    /**
     * Supported versions: 26.1+
     */
    public static final SimpleProperty<ChickenSoundVariant> SOUND_VARIANT = MetadataProperty.<ChickenSoundVariant>builder(ChickenMetaProperties.class)
            .addVersion(ClientVersion.V_26_1, 19, EntityDataTypes.CHICKEN_SOUND_VARIANT)
            .build();

    /**
     * Supported versions: 1.21.5+
     */
    public static final SimpleProperty<ChickenVariant> VARIANT = MetadataProperty.<ChickenVariant>builder(ChickenMetaProperties.class)
            .addVersion(ClientVersion.V_1_21_5, 17, EntityDataTypes.CHICKEN_VARIANT)
            .addVersion(ClientVersion.V_1_21_6, 17, EntityDataTypes.CHICKEN_VARIANT)
            .addVersion(ClientVersion.V_1_21_9, 17, EntityDataTypes.CHICKEN_VARIANT)
            .addVersion(ClientVersion.V_1_21_11, 17, EntityDataTypes.CHICKEN_VARIANT)
            .addVersion(ClientVersion.V_26_1, 18, EntityDataTypes.CHICKEN_VARIANT)
            .build();

}
