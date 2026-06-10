// Auto-generated file. Do not edit manually.
package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.property.MetadataProperty;
import me.tofaa.entitylib.meta.property.SimpleProperty;

/**
 * Supported versions: All versions
 */
public class PandaMetaProperties extends AnimalMetaProperties {

    /**
     * Supported versions: All versions
     */
    public static final SimpleProperty<Integer> EAT_COUNTER = MetadataProperty.<Integer>builder(PandaMetaProperties.class)
            .addVersion(ClientVersion.V_1_14_4, 17, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_15, 18, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_16, 18, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_16_2, 18, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_17, 19, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_19, 19, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_19_1, 19, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_19_3, 19, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_19_4, 19, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_20_2, 19, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_20_3, 19, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_20_5, 19, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21, 19, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_2, 19, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_4, 19, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_5, 19, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_6, 19, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_9, 19, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_11, 19, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_26_1, 20, EntityDataTypes.INT)
            .build();

    /**
     * Supported versions: All versions
     */
    public static final SimpleProperty<Byte> FLAGS = MetadataProperty.<Byte>builder(PandaMetaProperties.class)
            .addVersion(ClientVersion.V_1_14_4, 20, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_15, 21, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_16, 21, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_16_2, 21, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_17, 22, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_19, 22, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_19_1, 22, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_19_3, 22, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_19_4, 22, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_20_2, 22, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_20_3, 22, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_20_5, 22, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21, 22, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_2, 22, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_4, 22, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_5, 22, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_6, 22, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_9, 22, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_11, 22, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_26_1, 23, EntityDataTypes.BYTE)
            .build();

    /**
     * Supported versions: All versions
     */
    public static final SimpleProperty<Byte> HIDDEN_GENE = MetadataProperty.<Byte>builder(PandaMetaProperties.class)
            .addVersion(ClientVersion.V_1_14_4, 19, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_15, 20, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_16, 20, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_16_2, 20, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_17, 21, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_19, 21, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_19_1, 21, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_19_3, 21, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_19_4, 21, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_20_2, 21, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_20_3, 21, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_20_5, 21, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21, 21, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_2, 21, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_4, 21, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_5, 21, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_6, 21, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_9, 21, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_11, 21, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_26_1, 22, EntityDataTypes.BYTE)
            .build();

    /**
     * Supported versions: All versions
     */
    public static final SimpleProperty<Byte> MAIN_GENE = MetadataProperty.<Byte>builder(PandaMetaProperties.class)
            .addVersion(ClientVersion.V_1_14_4, 18, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_15, 19, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_16, 19, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_16_2, 19, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_17, 20, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_19, 20, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_19_1, 20, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_19_3, 20, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_19_4, 20, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_20_2, 20, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_20_3, 20, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_20_5, 20, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21, 20, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_2, 20, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_4, 20, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_5, 20, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_6, 20, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_9, 20, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_11, 20, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_26_1, 21, EntityDataTypes.BYTE)
            .build();

    /**
     * Supported versions: All versions
     */
    public static final SimpleProperty<Integer> SNEEZE_COUNTER = MetadataProperty.<Integer>builder(PandaMetaProperties.class)
            .addVersion(ClientVersion.V_1_14_4, 16, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_15, 17, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_16, 17, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_16_2, 17, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_17, 18, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_19, 18, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_19_1, 18, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_19_3, 18, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_19_4, 18, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_20_2, 18, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_20_3, 18, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_20_5, 18, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21, 18, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_2, 18, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_4, 18, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_5, 18, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_6, 18, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_9, 18, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_11, 18, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_26_1, 19, EntityDataTypes.INT)
            .build();

    /**
     * Supported versions: All versions
     */
    public static final SimpleProperty<Integer> UNHAPPY_COUNTER = MetadataProperty.<Integer>builder(PandaMetaProperties.class)
            .addVersion(ClientVersion.V_1_14_4, 15, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_15, 16, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_16, 16, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_16_2, 16, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_17, 17, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_19, 17, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_19_1, 17, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_19_3, 17, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_19_4, 17, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_20_2, 17, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_20_3, 17, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_20_5, 17, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21, 17, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_2, 17, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_4, 17, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_5, 17, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_6, 17, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_9, 17, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_11, 17, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_26_1, 18, EntityDataTypes.INT)
            .build();

}
