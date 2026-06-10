// Auto-generated file. Do not edit manually.
package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.property.MetadataProperty;
import me.tofaa.entitylib.meta.property.SimpleProperty;

/**
 * Supported versions: All versions
 */
public class MinecartFurnaceMetaProperties extends AbstractMinecartMetaProperties {

    /**
     * Supported versions: All versions
     */
    public static final SimpleProperty<Boolean> FUEL = MetadataProperty.<Boolean>builder(MinecartFurnaceMetaProperties.class)
            .addVersion(ClientVersion.V_1_14_4, 13, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_15, 13, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_16, 13, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_16_2, 13, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_17, 14, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_19, 14, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_19_1, 14, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_19_3, 14, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_19_4, 14, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_20_2, 14, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_20_3, 14, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_20_5, 14, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21, 14, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_2, 14, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_4, 14, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_5, 13, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_6, 13, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_9, 13, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_11, 13, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_26_1, 13, EntityDataTypes.BOOLEAN)
            .build();

}
