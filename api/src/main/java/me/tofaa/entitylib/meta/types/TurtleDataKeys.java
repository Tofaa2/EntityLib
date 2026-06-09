// Auto-generated file. Do not edit manually.
package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import com.github.retrooper.packetevents.util.Vector3i;
import me.tofaa.entitylib.meta.EntityDataKey;

/**
 * Supported versions: All versions
 */
public class TurtleDataKeys extends AnimalDataKeys {

    /**
     * Supported versions: 1.21.4-
     */
    public static final EntityDataKey<Boolean> GOING_HOME = EntityDataKey.<Boolean>builder(TurtleDataKeys.class)
            .addVersion(ClientVersion.V_1_14_4, 19, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_15, 20, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_16, 20, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_16_2, 20, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_17, 21, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_19, 21, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_19_1, 21, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_19_3, 21, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_19_4, 21, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_20_2, 21, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_20_3, 21, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_20_5, 21, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21, 21, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_2, 21, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_4, 21, EntityDataTypes.BOOLEAN)
            .build();

    /**
     * Supported versions: All versions
     */
    public static final EntityDataKey<Boolean> HAS_EGG = EntityDataKey.<Boolean>builder(TurtleDataKeys.class)
            .addVersion(ClientVersion.V_1_14_4, 16, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_15, 17, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_16, 17, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_16_2, 17, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_17, 18, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_19, 18, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_19_1, 18, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_19_3, 18, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_19_4, 18, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_20_2, 18, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_20_3, 18, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_20_5, 18, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21, 18, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_2, 18, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_4, 18, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_5, 17, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_6, 17, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_9, 17, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_11, 17, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_26_1, 18, EntityDataTypes.BOOLEAN)
            .build();

    /**
     * Supported versions: 1.21.4-
     */
    public static final EntityDataKey<Vector3i> HOME_POS = EntityDataKey.<Vector3i>builder(TurtleDataKeys.class)
            .addVersion(ClientVersion.V_1_14_4, 15, EntityDataTypes.BLOCK_POSITION)
            .addVersion(ClientVersion.V_1_15, 16, EntityDataTypes.BLOCK_POSITION)
            .addVersion(ClientVersion.V_1_16, 16, EntityDataTypes.BLOCK_POSITION)
            .addVersion(ClientVersion.V_1_16_2, 16, EntityDataTypes.BLOCK_POSITION)
            .addVersion(ClientVersion.V_1_17, 17, EntityDataTypes.BLOCK_POSITION)
            .addVersion(ClientVersion.V_1_19, 17, EntityDataTypes.BLOCK_POSITION)
            .addVersion(ClientVersion.V_1_19_1, 17, EntityDataTypes.BLOCK_POSITION)
            .addVersion(ClientVersion.V_1_19_3, 17, EntityDataTypes.BLOCK_POSITION)
            .addVersion(ClientVersion.V_1_19_4, 17, EntityDataTypes.BLOCK_POSITION)
            .addVersion(ClientVersion.V_1_20_2, 17, EntityDataTypes.BLOCK_POSITION)
            .addVersion(ClientVersion.V_1_20_3, 17, EntityDataTypes.BLOCK_POSITION)
            .addVersion(ClientVersion.V_1_20_5, 17, EntityDataTypes.BLOCK_POSITION)
            .addVersion(ClientVersion.V_1_21, 17, EntityDataTypes.BLOCK_POSITION)
            .addVersion(ClientVersion.V_1_21_2, 17, EntityDataTypes.BLOCK_POSITION)
            .addVersion(ClientVersion.V_1_21_4, 17, EntityDataTypes.BLOCK_POSITION)
            .build();

    /**
     * Supported versions: All versions
     */
    public static final EntityDataKey<Boolean> LAYING_EGG = EntityDataKey.<Boolean>builder(TurtleDataKeys.class)
            .addVersion(ClientVersion.V_1_14_4, 17, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_15, 18, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_16, 18, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_16_2, 18, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_17, 19, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_19, 19, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_19_1, 19, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_19_3, 19, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_19_4, 19, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_20_2, 19, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_20_3, 19, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_20_5, 19, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21, 19, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_2, 19, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_4, 19, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_5, 18, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_6, 18, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_9, 18, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_11, 18, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_26_1, 19, EntityDataTypes.BOOLEAN)
            .build();

    /**
     * Supported versions: 1.21.4-
     */
    public static final EntityDataKey<Boolean> TRAVELLING = EntityDataKey.<Boolean>builder(TurtleDataKeys.class)
            .addVersion(ClientVersion.V_1_14_4, 20, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_15, 21, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_16, 21, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_16_2, 21, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_17, 22, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_19, 22, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_19_1, 22, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_19_3, 22, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_19_4, 22, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_20_2, 22, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_20_3, 22, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_20_5, 22, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21, 22, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_2, 22, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_4, 22, EntityDataTypes.BOOLEAN)
            .build();

    /**
     * Supported versions: 1.21.4-
     */
    public static final EntityDataKey<Vector3i> TRAVEL_POS = EntityDataKey.<Vector3i>builder(TurtleDataKeys.class)
            .addVersion(ClientVersion.V_1_14_4, 18, EntityDataTypes.BLOCK_POSITION)
            .addVersion(ClientVersion.V_1_15, 19, EntityDataTypes.BLOCK_POSITION)
            .addVersion(ClientVersion.V_1_16, 19, EntityDataTypes.BLOCK_POSITION)
            .addVersion(ClientVersion.V_1_16_2, 19, EntityDataTypes.BLOCK_POSITION)
            .addVersion(ClientVersion.V_1_17, 20, EntityDataTypes.BLOCK_POSITION)
            .addVersion(ClientVersion.V_1_19, 20, EntityDataTypes.BLOCK_POSITION)
            .addVersion(ClientVersion.V_1_19_1, 20, EntityDataTypes.BLOCK_POSITION)
            .addVersion(ClientVersion.V_1_19_3, 20, EntityDataTypes.BLOCK_POSITION)
            .addVersion(ClientVersion.V_1_19_4, 20, EntityDataTypes.BLOCK_POSITION)
            .addVersion(ClientVersion.V_1_20_2, 20, EntityDataTypes.BLOCK_POSITION)
            .addVersion(ClientVersion.V_1_20_3, 20, EntityDataTypes.BLOCK_POSITION)
            .addVersion(ClientVersion.V_1_20_5, 20, EntityDataTypes.BLOCK_POSITION)
            .addVersion(ClientVersion.V_1_21, 20, EntityDataTypes.BLOCK_POSITION)
            .addVersion(ClientVersion.V_1_21_2, 20, EntityDataTypes.BLOCK_POSITION)
            .addVersion(ClientVersion.V_1_21_4, 20, EntityDataTypes.BLOCK_POSITION)
            .build();

}
