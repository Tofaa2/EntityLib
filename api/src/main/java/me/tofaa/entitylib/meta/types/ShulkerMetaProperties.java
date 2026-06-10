// Auto-generated file. Do not edit manually.
package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import com.github.retrooper.packetevents.protocol.world.BlockFace;
import com.github.retrooper.packetevents.util.Vector3i;
import me.tofaa.entitylib.meta.property.MetadataProperty;
import me.tofaa.entitylib.meta.property.SimpleProperty;

import java.util.Optional;

/**
 * Supported versions: All versions
 */
public class ShulkerMetaProperties extends AbstractGolemMetaProperties {

    /**
     * Supported versions: All versions
     */
    public static final SimpleProperty<BlockFace> ATTACH_FACE = MetadataProperty.<BlockFace>builder(ShulkerMetaProperties.class)
            .addVersion(ClientVersion.V_1_14_4, 14, EntityDataTypes.BLOCK_FACE)
            .addVersion(ClientVersion.V_1_15, 15, EntityDataTypes.BLOCK_FACE)
            .addVersion(ClientVersion.V_1_16, 15, EntityDataTypes.BLOCK_FACE)
            .addVersion(ClientVersion.V_1_16_2, 15, EntityDataTypes.BLOCK_FACE)
            .addVersion(ClientVersion.V_1_17, 16, EntityDataTypes.BLOCK_FACE)
            .addVersion(ClientVersion.V_1_19, 16, EntityDataTypes.BLOCK_FACE)
            .addVersion(ClientVersion.V_1_19_1, 16, EntityDataTypes.BLOCK_FACE)
            .addVersion(ClientVersion.V_1_19_3, 16, EntityDataTypes.BLOCK_FACE)
            .addVersion(ClientVersion.V_1_19_4, 16, EntityDataTypes.BLOCK_FACE)
            .addVersion(ClientVersion.V_1_20_2, 16, EntityDataTypes.BLOCK_FACE)
            .addVersion(ClientVersion.V_1_20_3, 16, EntityDataTypes.BLOCK_FACE)
            .addVersion(ClientVersion.V_1_20_5, 16, EntityDataTypes.BLOCK_FACE)
            .addVersion(ClientVersion.V_1_21, 16, EntityDataTypes.BLOCK_FACE)
            .addVersion(ClientVersion.V_1_21_2, 16, EntityDataTypes.BLOCK_FACE)
            .addVersion(ClientVersion.V_1_21_4, 16, EntityDataTypes.BLOCK_FACE)
            .addVersion(ClientVersion.V_1_21_5, 16, EntityDataTypes.BLOCK_FACE)
            .addVersion(ClientVersion.V_1_21_6, 16, EntityDataTypes.BLOCK_FACE)
            .addVersion(ClientVersion.V_1_21_9, 16, EntityDataTypes.BLOCK_FACE)
            .addVersion(ClientVersion.V_1_21_11, 16, EntityDataTypes.BLOCK_FACE)
            .addVersion(ClientVersion.V_26_1, 16, EntityDataTypes.BLOCK_FACE)
            .build();

    /**
     * Supported versions: 1.16.2-
     */
    public static final SimpleProperty<Optional<Vector3i>> ATTACH_POS = MetadataProperty.<Optional<Vector3i>>builder(ShulkerMetaProperties.class)
            .addVersion(ClientVersion.V_1_14_4, 15, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
            .addVersion(ClientVersion.V_1_15, 16, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
            .addVersion(ClientVersion.V_1_16, 16, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
            .addVersion(ClientVersion.V_1_16_2, 16, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
            .build();

    /**
     * Supported versions: All versions
     */
    public static final SimpleProperty<Byte> COLOR = MetadataProperty.<Byte>builder(ShulkerMetaProperties.class)
            .addVersion(ClientVersion.V_1_14_4, 17, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_15, 18, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_16, 18, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_16_2, 18, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_17, 18, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_19, 18, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_19_1, 18, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_19_3, 18, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_19_4, 18, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_20_2, 18, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_20_3, 18, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_20_5, 18, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21, 18, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_2, 18, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_4, 18, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_5, 18, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_6, 18, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_9, 18, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_11, 18, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_26_1, 18, EntityDataTypes.BYTE)
            .build();

    /**
     * Supported versions: All versions
     */
    public static final SimpleProperty<Byte> PEEK = MetadataProperty.<Byte>builder(ShulkerMetaProperties.class)
            .addVersion(ClientVersion.V_1_14_4, 16, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_15, 17, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_16, 17, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_16_2, 17, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_17, 17, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_19, 17, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_19_1, 17, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_19_3, 17, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_19_4, 17, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_20_2, 17, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_20_3, 17, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_20_5, 17, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21, 17, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_2, 17, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_4, 17, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_5, 17, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_6, 17, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_9, 17, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_11, 17, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_26_1, 17, EntityDataTypes.BYTE)
            .build();

}
