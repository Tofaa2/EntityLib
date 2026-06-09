package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.particle.Particle;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import com.github.retrooper.packetevents.util.Vector3i;
import me.tofaa.entitylib.meta.VersionedMetadataKey;

import java.util.List;
import java.util.Optional;

/**
 * Supported versions: All versions
 */
public class LivingEntityDataKeys extends EntityDataKeys {

    /**
     * Supported versions: All versions
     */
    public static final VersionedMetadataKey<Integer> ARROW_COUNT = VersionedMetadataKey.<Integer>builder()
            .add(ClientVersion.V_1_14_4, 11, EntityDataTypes.INT)
            .add(ClientVersion.V_1_15, 11, EntityDataTypes.INT)
            .add(ClientVersion.V_1_16, 11, EntityDataTypes.INT)
            .add(ClientVersion.V_1_16_2, 11, EntityDataTypes.INT)
            .add(ClientVersion.V_1_17, 12, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19, 12, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19_1, 12, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19_3, 12, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19_4, 12, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_2, 12, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_3, 12, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_5, 12, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21, 12, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_2, 12, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_4, 12, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_5, 12, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_6, 12, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_9, 12, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_11, 12, EntityDataTypes.INT)
            .add(ClientVersion.V_26_1, 12, EntityDataTypes.INT)
            .build();

    /**
     * Supported versions: All versions
     */
    public static final VersionedMetadataKey<Boolean> EFFECT_AMBIENCE = VersionedMetadataKey.<Boolean>builder()
            .add(ClientVersion.V_1_14_4, 10, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_15, 10, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_16, 10, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_16_2, 10, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_17, 11, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_19, 11, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_19_1, 11, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_19_3, 11, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_19_4, 11, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_20_2, 11, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_20_3, 11, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_20_5, 11, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21, 11, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_2, 11, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_4, 11, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_5, 11, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_6, 11, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_9, 11, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_11, 11, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_26_1, 11, EntityDataTypes.BOOLEAN)
            .build();

    /**
     * Supported versions: 1.20.3-
     */
    public static final VersionedMetadataKey<Integer> EFFECT_COLOR = VersionedMetadataKey.<Integer>builder()
            .add(ClientVersion.V_1_14_4, 9, EntityDataTypes.INT)
            .add(ClientVersion.V_1_15, 9, EntityDataTypes.INT)
            .add(ClientVersion.V_1_16, 9, EntityDataTypes.INT)
            .add(ClientVersion.V_1_16_2, 9, EntityDataTypes.INT)
            .add(ClientVersion.V_1_17, 10, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19, 10, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19_1, 10, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19_3, 10, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19_4, 10, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_2, 10, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_3, 10, EntityDataTypes.INT)
            .build();

    /**
     * Supported versions: 1.20.5+
     */
    public static final VersionedMetadataKey<List<Particle<?>>> EFFECT_PARTICLES = VersionedMetadataKey.<List<Particle<?>>>builder()
            .add(ClientVersion.V_1_20_5, 10, EntityDataTypes.PARTICLES)
            .add(ClientVersion.V_1_21, 10, EntityDataTypes.PARTICLES)
            .add(ClientVersion.V_1_21_2, 10, EntityDataTypes.PARTICLES)
            .add(ClientVersion.V_1_21_4, 10, EntityDataTypes.PARTICLES)
            .add(ClientVersion.V_1_21_5, 10, EntityDataTypes.PARTICLES)
            .add(ClientVersion.V_1_21_6, 10, EntityDataTypes.PARTICLES)
            .add(ClientVersion.V_1_21_9, 10, EntityDataTypes.PARTICLES)
            .add(ClientVersion.V_1_21_11, 10, EntityDataTypes.PARTICLES)
            .add(ClientVersion.V_26_1, 10, EntityDataTypes.PARTICLES)
            .build();

    /**
     * Supported versions: All versions
     */
    public static final VersionedMetadataKey<Float> HEALTH = VersionedMetadataKey.<Float>builder()
            .add(ClientVersion.V_1_14_4, 8, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_15, 8, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_16, 8, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_16_2, 8, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_17, 9, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_19, 9, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_19_1, 9, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_19_3, 9, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_19_4, 9, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_20_2, 9, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_20_3, 9, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_20_5, 9, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21, 9, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_2, 9, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_4, 9, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_5, 9, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_6, 9, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_9, 9, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_1_21_11, 9, EntityDataTypes.FLOAT)
            .add(ClientVersion.V_26_1, 9, EntityDataTypes.FLOAT)
            .build();

    /**
     * Supported versions: All versions
     */
    public static final VersionedMetadataKey<Byte> LIVING_ENTITY_FLAGS = VersionedMetadataKey.<Byte>builder()
            .add(ClientVersion.V_1_14_4, 7, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_15, 7, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_16, 7, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_16_2, 7, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_17, 8, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_19, 8, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_19_1, 8, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_19_3, 8, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_19_4, 8, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_20_2, 8, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_20_3, 8, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_20_5, 8, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21, 8, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21_2, 8, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21_4, 8, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21_5, 8, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21_6, 8, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21_9, 8, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21_11, 8, EntityDataTypes.BYTE)
            .add(ClientVersion.V_26_1, 8, EntityDataTypes.BYTE)
            .build();

    /**
     * Supported versions: All versions
     */
    public static final VersionedMetadataKey<Optional<Vector3i>> SLEEPING_POS = VersionedMetadataKey.<Optional<Vector3i>>builder()
            .add(ClientVersion.V_1_14_4, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
            .add(ClientVersion.V_1_15, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
            .add(ClientVersion.V_1_16, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
            .add(ClientVersion.V_1_16_2, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
            .add(ClientVersion.V_1_17, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
            .add(ClientVersion.V_1_19, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
            .add(ClientVersion.V_1_19_1, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
            .add(ClientVersion.V_1_19_3, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
            .add(ClientVersion.V_1_19_4, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
            .add(ClientVersion.V_1_20_2, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
            .add(ClientVersion.V_1_20_3, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
            .add(ClientVersion.V_1_20_5, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
            .add(ClientVersion.V_1_21, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
            .add(ClientVersion.V_1_21_2, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
            .add(ClientVersion.V_1_21_4, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
            .add(ClientVersion.V_1_21_5, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
            .add(ClientVersion.V_1_21_6, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
            .add(ClientVersion.V_1_21_9, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
            .add(ClientVersion.V_1_21_11, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
            .add(ClientVersion.V_26_1, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
            .build();

    /**
     * Supported versions: 1.15+
     */
    public static final VersionedMetadataKey<Integer> STINGER_COUNT = VersionedMetadataKey.<Integer>builder()
            .add(ClientVersion.V_1_15, 12, EntityDataTypes.INT)
            .add(ClientVersion.V_1_16, 12, EntityDataTypes.INT)
            .add(ClientVersion.V_1_16_2, 12, EntityDataTypes.INT)
            .add(ClientVersion.V_1_17, 13, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19, 13, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19_1, 13, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19_3, 13, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19_4, 13, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_2, 13, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_3, 13, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_5, 13, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21, 13, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_2, 13, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_4, 13, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_5, 13, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_6, 13, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_9, 13, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_11, 13, EntityDataTypes.INT)
            .add(ClientVersion.V_26_1, 13, EntityDataTypes.INT)
            .build();

}
