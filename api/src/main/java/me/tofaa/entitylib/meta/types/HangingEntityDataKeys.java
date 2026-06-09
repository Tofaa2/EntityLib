package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import com.github.retrooper.packetevents.protocol.world.BlockFace;
import me.tofaa.entitylib.meta.VersionedMetadataKey;

/**
 * Supported versions: All versions
 */
public class HangingEntityDataKeys extends EntityDataKeys {

    /**
     * Supported versions: 1.21.6+
     */
    public static final VersionedMetadataKey<BlockFace> DIRECTION = VersionedMetadataKey.<BlockFace>builder()
            .add(ClientVersion.V_1_21_6, 8, EntityDataTypes.BLOCK_FACE)
            .add(ClientVersion.V_1_21_9, 8, EntityDataTypes.BLOCK_FACE)
            .add(ClientVersion.V_1_21_11, 8, EntityDataTypes.BLOCK_FACE)
            .add(ClientVersion.V_26_1, 8, EntityDataTypes.BLOCK_FACE)
            .build();

}
