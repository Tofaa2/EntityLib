// Auto-generated file. Do not edit manually.
package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import com.github.retrooper.packetevents.util.Vector3i;
import me.tofaa.entitylib.meta.EntityDataKey;

/**
 * Supported versions: All versions
 */
public class DolphinDataKeys extends WaterAnimalDataKeys {

    /**
     * Supported versions: All versions
     */
    public static final EntityDataKey<Boolean> GOT_FISH = EntityDataKey.<Boolean>builder(DolphinDataKeys.class)
            .addVersion(ClientVersion.V_1_14_4, 15, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_15, 16, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_16, 16, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_16_2, 16, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_17, 17, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_19, 17, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_19_1, 17, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_19_3, 17, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_19_4, 17, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_20_2, 17, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_20_3, 17, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_20_5, 17, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21, 17, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_2, 18, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_4, 18, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_5, 17, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_6, 17, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_9, 17, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_11, 17, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_26_1, 18, EntityDataTypes.BOOLEAN)
            .build();

    /**
     * Supported versions: 1.15-
     */
    public static final EntityDataKey<Integer> MOISNTESS_LEVEL = EntityDataKey.<Integer>builder(DolphinDataKeys.class)
            .addVersion(ClientVersion.V_1_14_4, 16, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_15, 17, EntityDataTypes.INT)
            .build();

    /**
     * Supported versions: 1.16+
     */
    public static final EntityDataKey<Integer> MOISTNESS_LEVEL = EntityDataKey.<Integer>builder(DolphinDataKeys.class)
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
            .addVersion(ClientVersion.V_1_21_2, 19, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_4, 19, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_5, 18, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_6, 18, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_9, 18, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_11, 18, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_26_1, 19, EntityDataTypes.INT)
            .build();

    /**
     * Supported versions: 1.21.4-
     */
    public static final EntityDataKey<Vector3i> TREASURE_POS = EntityDataKey.<Vector3i>builder(DolphinDataKeys.class)
            .addVersion(ClientVersion.V_1_14_4, 14, EntityDataTypes.BLOCK_POSITION)
            .addVersion(ClientVersion.V_1_15, 15, EntityDataTypes.BLOCK_POSITION)
            .addVersion(ClientVersion.V_1_16, 15, EntityDataTypes.BLOCK_POSITION)
            .addVersion(ClientVersion.V_1_16_2, 15, EntityDataTypes.BLOCK_POSITION)
            .addVersion(ClientVersion.V_1_17, 16, EntityDataTypes.BLOCK_POSITION)
            .addVersion(ClientVersion.V_1_19, 16, EntityDataTypes.BLOCK_POSITION)
            .addVersion(ClientVersion.V_1_19_1, 16, EntityDataTypes.BLOCK_POSITION)
            .addVersion(ClientVersion.V_1_19_3, 16, EntityDataTypes.BLOCK_POSITION)
            .addVersion(ClientVersion.V_1_19_4, 16, EntityDataTypes.BLOCK_POSITION)
            .addVersion(ClientVersion.V_1_20_2, 16, EntityDataTypes.BLOCK_POSITION)
            .addVersion(ClientVersion.V_1_20_3, 16, EntityDataTypes.BLOCK_POSITION)
            .addVersion(ClientVersion.V_1_20_5, 16, EntityDataTypes.BLOCK_POSITION)
            .addVersion(ClientVersion.V_1_21, 16, EntityDataTypes.BLOCK_POSITION)
            .addVersion(ClientVersion.V_1_21_2, 17, EntityDataTypes.BLOCK_POSITION)
            .addVersion(ClientVersion.V_1_21_4, 17, EntityDataTypes.BLOCK_POSITION)
            .build();

}
