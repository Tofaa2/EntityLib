// Auto-generated file. Do not edit manually.
package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import com.github.retrooper.packetevents.protocol.world.BlockFace;
import me.tofaa.entitylib.meta.EntityDataKey;

/**
 * Supported versions: All versions
 */
public class HangingEntityDataKeys extends EntityDataKeys {

    /**
     * Supported versions: 1.21.6+
     */
    public static final EntityDataKey<BlockFace> DIRECTION = EntityDataKey.<BlockFace>builder(HangingEntityDataKeys.class)
            .addVersion(ClientVersion.V_1_21_6, 8, EntityDataTypes.BLOCK_FACE)
            .addVersion(ClientVersion.V_1_21_9, 8, EntityDataTypes.BLOCK_FACE)
            .addVersion(ClientVersion.V_1_21_11, 8, EntityDataTypes.BLOCK_FACE)
            .addVersion(ClientVersion.V_26_1, 8, EntityDataTypes.BLOCK_FACE)
            .build();

}
