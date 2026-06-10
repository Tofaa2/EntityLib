// Auto-generated file. Do not edit manually.
package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.property.MetadataProperty;
import me.tofaa.entitylib.meta.property.SimpleProperty;

/**
 * Supported versions: All versions
 */
public class SalmonMetaProperties extends AbstractSchoolingFishMetaProperties {

    /**
     * Supported versions: 1.21.2+
     */
    public static final SimpleProperty<Integer> TYPE = MetadataProperty.<Integer>builder(SalmonMetaProperties.class)
            // TODO type changed from 'String' to 'Integer', converter required
            .addVersion(ClientVersion.V_1_21_4, 17, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_5, 17, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_6, 17, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_9, 17, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_11, 17, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_26_1, 17, EntityDataTypes.INT)
            .build();

}
