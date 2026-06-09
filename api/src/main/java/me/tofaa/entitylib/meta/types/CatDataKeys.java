package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.cat.CatSoundVariant;
import com.github.retrooper.packetevents.protocol.entity.cat.CatVariant;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.VersionedMetadataKey;

/**
 * Supported versions: All versions
 */
public class CatDataKeys extends TamableAnimalDataKeys {

    /**
     * Supported versions: All versions
     */
    public static final VersionedMetadataKey<Integer> COLLAR_COLOR = VersionedMetadataKey.<Integer>builder()
            .add(ClientVersion.V_1_14_4, 20, EntityDataTypes.INT)
            .add(ClientVersion.V_1_15, 21, EntityDataTypes.INT)
            .add(ClientVersion.V_1_16, 21, EntityDataTypes.INT)
            .add(ClientVersion.V_1_16_2, 21, EntityDataTypes.INT)
            .add(ClientVersion.V_1_17, 22, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19, 22, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19_1, 22, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19_3, 22, EntityDataTypes.INT)
            .add(ClientVersion.V_1_19_4, 22, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_2, 22, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_3, 22, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_5, 22, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21, 22, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_2, 22, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_4, 22, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_5, 22, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_6, 22, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_9, 22, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_11, 22, EntityDataTypes.INT)
            .add(ClientVersion.V_26_1, 23, EntityDataTypes.INT)
            .build();

    /**
     * Supported versions: All versions
     */
    public static final VersionedMetadataKey<Boolean> IS_LYING = VersionedMetadataKey.<Boolean>builder()
            .add(ClientVersion.V_1_14_4, 18, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_15, 19, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_16, 19, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_16_2, 19, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_17, 20, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_19, 20, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_19_1, 20, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_19_3, 20, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_19_4, 20, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_20_2, 20, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_20_3, 20, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_20_5, 20, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21, 20, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_2, 20, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_4, 20, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_5, 20, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_6, 20, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_9, 20, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_11, 20, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_26_1, 21, EntityDataTypes.BOOLEAN)
            .build();

    /**
     * Supported versions: All versions
     */
    public static final VersionedMetadataKey<Boolean> RELAX_STATE_ONE = VersionedMetadataKey.<Boolean>builder()
            .add(ClientVersion.V_1_14_4, 19, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_15, 20, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_16, 20, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_16_2, 20, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_17, 21, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_19, 21, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_19_1, 21, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_19_3, 21, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_19_4, 21, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_20_2, 21, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_20_3, 21, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_20_5, 21, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21, 21, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_2, 21, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_4, 21, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_5, 21, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_6, 21, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_9, 21, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_11, 21, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_26_1, 22, EntityDataTypes.BOOLEAN)
            .build();

    /**
     * Supported versions: 26.1+
     */
    public static final VersionedMetadataKey<CatSoundVariant> SOUND_VARIANT = VersionedMetadataKey.<CatSoundVariant>builder()
            .add(ClientVersion.V_26_1, 24, EntityDataTypes.CAT_SOUND_VARIANT)
            .build();

    /**
     * Supported versions: 1.17-
     */
    public static final VersionedMetadataKey<Integer> TYPE = VersionedMetadataKey.<Integer>builder()
            .add(ClientVersion.V_1_14_4, 17, EntityDataTypes.INT)
            .add(ClientVersion.V_1_15, 18, EntityDataTypes.INT)
            .add(ClientVersion.V_1_16, 18, EntityDataTypes.INT)
            .add(ClientVersion.V_1_16_2, 18, EntityDataTypes.INT)
            .add(ClientVersion.V_1_17, 19, EntityDataTypes.INT)
            .build();

    /**
     * Supported versions: 1.19+
     */
    public static final VersionedMetadataKey<CatVariant> VARIANT = VersionedMetadataKey.<CatVariant>builder()
            .add(ClientVersion.V_1_19, 19, EntityDataTypes.TYPED_CAT_VARIANT)
            .add(ClientVersion.V_1_19_1, 19, EntityDataTypes.TYPED_CAT_VARIANT)
            .add(ClientVersion.V_1_19_3, 19, EntityDataTypes.TYPED_CAT_VARIANT)
            .add(ClientVersion.V_1_19_4, 19, EntityDataTypes.TYPED_CAT_VARIANT)
            .add(ClientVersion.V_1_20_2, 19, EntityDataTypes.TYPED_CAT_VARIANT)
            .add(ClientVersion.V_1_20_3, 19, EntityDataTypes.TYPED_CAT_VARIANT)
            .add(ClientVersion.V_1_20_5, 19, EntityDataTypes.TYPED_CAT_VARIANT)
            .add(ClientVersion.V_1_21, 19, EntityDataTypes.TYPED_CAT_VARIANT)
            .add(ClientVersion.V_1_21_2, 19, EntityDataTypes.TYPED_CAT_VARIANT)
            .add(ClientVersion.V_1_21_4, 19, EntityDataTypes.TYPED_CAT_VARIANT)
            .add(ClientVersion.V_1_21_5, 19, EntityDataTypes.TYPED_CAT_VARIANT)
            .add(ClientVersion.V_1_21_6, 19, EntityDataTypes.TYPED_CAT_VARIANT)
            .add(ClientVersion.V_1_21_9, 19, EntityDataTypes.TYPED_CAT_VARIANT)
            .add(ClientVersion.V_1_21_11, 19, EntityDataTypes.TYPED_CAT_VARIANT)
            .add(ClientVersion.V_26_1, 20, EntityDataTypes.TYPED_CAT_VARIANT)
            .build();

}
