// Auto-generated file. Do not edit manually.
package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.property.MetadataProperty;
import me.tofaa.entitylib.meta.property.SimpleProperty;

/**
 * Supported versions: All versions
 */
public class WitherSkullMetaProperties extends AbstractHurtingProjectileMetaProperties {

    /**
     * Supported versions: All versions
     */
    public static final SimpleProperty<Boolean> DANGEROUS = MetadataProperty.<Boolean>builder(WitherSkullMetaProperties.class)
            .addVersion(ClientVersion.V_1_14_4, 7, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_15, 7, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_16, 7, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_16_2, 7, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_17, 8, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_19, 8, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_19_1, 8, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_19_3, 8, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_19_4, 8, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_20_2, 8, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_20_3, 8, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_20_5, 8, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21, 8, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_2, 8, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_4, 8, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_5, 8, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_6, 8, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_9, 8, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_11, 8, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_26_1, 8, EntityDataTypes.BOOLEAN)
            .build();

}
