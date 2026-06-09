// Auto-generated file. Do not edit manually.
package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.entity.wolfvariant.WolfSoundVariant;
import com.github.retrooper.packetevents.protocol.entity.wolfvariant.WolfVariant;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.EntityDataKey;

/**
 * Supported versions: All versions
 */
public class WolfDataKeys extends TamableAnimalDataKeys {

    /**
     * Supported versions: 1.21.11+
     */
    public static final EntityDataKey<Long> ANGER_END_TIME = EntityDataKey.<Long>builder(WolfDataKeys.class)
            .addVersion(ClientVersion.V_1_21_11, 21, EntityDataTypes.LONG)
            .addVersion(ClientVersion.V_26_1, 22, EntityDataTypes.LONG)
            .build();

    /**
     * Supported versions: All versions
     */
    public static final EntityDataKey<Integer> COLLAR_COLOR = EntityDataKey.<Integer>builder(WolfDataKeys.class)
            .addVersion(ClientVersion.V_1_14_4, 19, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_15, 19, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_16, 19, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_16_2, 19, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_17, 20, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_19, 20, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_19_1, 20, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_19_3, 20, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_19_4, 20, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_20_2, 20, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_20_3, 20, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_20_5, 20, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21, 20, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_2, 20, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_4, 20, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_5, 20, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_6, 20, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_9, 20, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_11, 20, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_26_1, 21, EntityDataTypes.INT)
            .build();

    /**
     * Supported versions: 1.14.4-
     */
    public static final EntityDataKey<Float> HEALTH = EntityDataKey.<Float>builder(WolfDataKeys.class)
            .addVersion(ClientVersion.V_1_14_4, 17, EntityDataTypes.FLOAT)
            .build();

    /**
     * Supported versions: All versions
     */
    public static final EntityDataKey<Boolean> INTERESTED = EntityDataKey.<Boolean>builder(WolfDataKeys.class)
            .addVersion(ClientVersion.V_1_14_4, 18, EntityDataTypes.BOOLEAN)
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
            .addVersion(ClientVersion.V_1_21_5, 19, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_6, 19, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_9, 19, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_11, 19, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_26_1, 20, EntityDataTypes.BOOLEAN)
            .build();

    /**
     * Supported versions: 1.16 - 1.21.9
     */
    public static final EntityDataKey<Integer> REMAINING_ANGER_TIME = EntityDataKey.<Integer>builder(WolfDataKeys.class)
            .addVersion(ClientVersion.V_1_16, 20, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_16_2, 20, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_17, 21, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_19, 21, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_19_1, 21, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_19_3, 21, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_19_4, 21, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_20_2, 21, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_20_3, 21, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_20_5, 21, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21, 21, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_2, 21, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_4, 21, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_5, 21, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_6, 21, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_9, 21, EntityDataTypes.INT)
            .build();

    /**
     * Supported versions: 1.21.5+
     */
    public static final EntityDataKey<WolfSoundVariant> SOUND_VARIANT = EntityDataKey.<WolfSoundVariant>builder(WolfDataKeys.class)
            .addVersion(ClientVersion.V_1_21_5, 23, EntityDataTypes.WOLF_SOUND_VARIANT)
            .addVersion(ClientVersion.V_1_21_6, 23, EntityDataTypes.WOLF_SOUND_VARIANT)
            .addVersion(ClientVersion.V_1_21_9, 23, EntityDataTypes.WOLF_SOUND_VARIANT)
            .addVersion(ClientVersion.V_1_21_11, 23, EntityDataTypes.WOLF_SOUND_VARIANT)
            .addVersion(ClientVersion.V_26_1, 24, EntityDataTypes.WOLF_SOUND_VARIANT)
            .build();

    /**
     * Supported versions: 1.20.5+
     */
    public static final EntityDataKey<WolfVariant> VARIANT = EntityDataKey.<WolfVariant>builder(WolfDataKeys.class)
            .addVersion(ClientVersion.V_1_20_5, 22, EntityDataTypes.TYPED_WOLF_VARIANT)
            .addVersion(ClientVersion.V_1_21, 22, EntityDataTypes.TYPED_WOLF_VARIANT)
            .addVersion(ClientVersion.V_1_21_2, 22, EntityDataTypes.TYPED_WOLF_VARIANT)
            .addVersion(ClientVersion.V_1_21_4, 22, EntityDataTypes.TYPED_WOLF_VARIANT)
            .addVersion(ClientVersion.V_1_21_5, 22, EntityDataTypes.TYPED_WOLF_VARIANT)
            .addVersion(ClientVersion.V_1_21_6, 22, EntityDataTypes.TYPED_WOLF_VARIANT)
            .addVersion(ClientVersion.V_1_21_9, 22, EntityDataTypes.TYPED_WOLF_VARIANT)
            .addVersion(ClientVersion.V_1_21_11, 22, EntityDataTypes.TYPED_WOLF_VARIANT)
            .addVersion(ClientVersion.V_26_1, 23, EntityDataTypes.TYPED_WOLF_VARIANT)
            .build();

}
