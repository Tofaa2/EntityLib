// Auto-generated file. Do not edit manually.
package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.nbt.NBTCompound;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.EntityDataKey;

import java.util.Optional;

/**
 * Supported versions: All versions
 */
public class PlayerDataKeys extends LivingEntityDataKeys {

    /**
     * Supported versions: All versions
     */
    public static final EntityDataKey<Float> PLAYER_ABSORPTION = EntityDataKey.<Float>builder(PlayerDataKeys.class)
            .addVersion(ClientVersion.V_1_14_4, 13, EntityDataTypes.FLOAT)
            .addVersion(ClientVersion.V_1_15, 14, EntityDataTypes.FLOAT)
            .addVersion(ClientVersion.V_1_16, 14, EntityDataTypes.FLOAT)
            .addVersion(ClientVersion.V_1_16_2, 14, EntityDataTypes.FLOAT)
            .addVersion(ClientVersion.V_1_17, 15, EntityDataTypes.FLOAT)
            .addVersion(ClientVersion.V_1_19, 15, EntityDataTypes.FLOAT)
            .addVersion(ClientVersion.V_1_19_1, 15, EntityDataTypes.FLOAT)
            .addVersion(ClientVersion.V_1_19_3, 15, EntityDataTypes.FLOAT)
            .addVersion(ClientVersion.V_1_19_4, 15, EntityDataTypes.FLOAT)
            .addVersion(ClientVersion.V_1_20_2, 15, EntityDataTypes.FLOAT)
            .addVersion(ClientVersion.V_1_20_3, 15, EntityDataTypes.FLOAT)
            .addVersion(ClientVersion.V_1_20_5, 15, EntityDataTypes.FLOAT)
            .addVersion(ClientVersion.V_1_21, 15, EntityDataTypes.FLOAT)
            .addVersion(ClientVersion.V_1_21_2, 15, EntityDataTypes.FLOAT)
            .addVersion(ClientVersion.V_1_21_4, 15, EntityDataTypes.FLOAT)
            .addVersion(ClientVersion.V_1_21_5, 15, EntityDataTypes.FLOAT)
            .addVersion(ClientVersion.V_1_21_6, 15, EntityDataTypes.FLOAT)
            .addVersion(ClientVersion.V_1_21_9, 17, EntityDataTypes.FLOAT)
            .addVersion(ClientVersion.V_1_21_11, 17, EntityDataTypes.FLOAT)
            .addVersion(ClientVersion.V_26_1, 17, EntityDataTypes.FLOAT)
            .build();

    /**
     * Supported versions: 1.21.6-
     */
    public static final EntityDataKey<Byte> PLAYER_MAIN_HAND = EntityDataKey.<Byte>builder(PlayerDataKeys.class)
            .addVersion(ClientVersion.V_1_14_4, 16, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_15, 17, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_16, 17, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_16_2, 17, EntityDataTypes.BYTE)
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
            .build();

    /**
     * Supported versions: 1.21.6-
     */
    public static final EntityDataKey<Byte> PLAYER_MODE_CUSTOMISATION = EntityDataKey.<Byte>builder(PlayerDataKeys.class)
            .addVersion(ClientVersion.V_1_14_4, 15, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_15, 16, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_16, 16, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_16_2, 16, EntityDataTypes.BYTE)
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
            .build();

    /**
     * Supported versions: All versions
     */
    public static final EntityDataKey<Integer> SCORE = EntityDataKey.<Integer>builder(PlayerDataKeys.class)
            .addVersion(ClientVersion.V_1_14_4, 14, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_15, 15, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_16, 15, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_16_2, 15, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_17, 16, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_19, 16, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_19_1, 16, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_19_3, 16, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_19_4, 16, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_20_2, 16, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_20_3, 16, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_20_5, 16, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21, 16, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_2, 16, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_4, 16, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_5, 16, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_6, 16, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_9, 18, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_11, 18, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_26_1, 18, EntityDataTypes.INT)
            .build();

    /**
     * Supported versions: 1.21.6-
     */
    public static final EntityDataKey<NBTCompound> SHOULDER_LEFT = EntityDataKey.<NBTCompound>builder(PlayerDataKeys.class)
            .addVersion(ClientVersion.V_1_14_4, 17, EntityDataTypes.NBT)
            .addVersion(ClientVersion.V_1_15, 18, EntityDataTypes.NBT)
            .addVersion(ClientVersion.V_1_16, 18, EntityDataTypes.NBT)
            .addVersion(ClientVersion.V_1_16_2, 18, EntityDataTypes.NBT)
            .addVersion(ClientVersion.V_1_17, 19, EntityDataTypes.NBT)
            .addVersion(ClientVersion.V_1_19, 19, EntityDataTypes.NBT)
            .addVersion(ClientVersion.V_1_19_1, 19, EntityDataTypes.NBT)
            .addVersion(ClientVersion.V_1_19_3, 19, EntityDataTypes.NBT)
            .addVersion(ClientVersion.V_1_19_4, 19, EntityDataTypes.NBT)
            .addVersion(ClientVersion.V_1_20_2, 19, EntityDataTypes.NBT)
            .addVersion(ClientVersion.V_1_20_3, 19, EntityDataTypes.NBT)
            .addVersion(ClientVersion.V_1_20_5, 19, EntityDataTypes.NBT)
            .addVersion(ClientVersion.V_1_21, 19, EntityDataTypes.NBT)
            .addVersion(ClientVersion.V_1_21_2, 19, EntityDataTypes.NBT)
            .addVersion(ClientVersion.V_1_21_4, 19, EntityDataTypes.NBT)
            .addVersion(ClientVersion.V_1_21_5, 19, EntityDataTypes.NBT)
            .addVersion(ClientVersion.V_1_21_6, 19, EntityDataTypes.NBT)
            .build();

    /**
     * Supported versions: 1.21.9+
     */
    public static final EntityDataKey<Optional<Integer>> SHOULDER_PARROT_LEFT = EntityDataKey.<Optional<Integer>>builder(PlayerDataKeys.class)
            .addVersion(ClientVersion.V_1_21_9, 19, EntityDataTypes.OPTIONAL_INT)
            .addVersion(ClientVersion.V_1_21_11, 19, EntityDataTypes.OPTIONAL_INT)
            .addVersion(ClientVersion.V_26_1, 19, EntityDataTypes.OPTIONAL_INT)
            .build();

    /**
     * Supported versions: 1.21.9+
     */
    public static final EntityDataKey<Optional<Integer>> SHOULDER_PARROT_RIGHT = EntityDataKey.<Optional<Integer>>builder(PlayerDataKeys.class)
            .addVersion(ClientVersion.V_1_21_9, 20, EntityDataTypes.OPTIONAL_INT)
            .addVersion(ClientVersion.V_1_21_11, 20, EntityDataTypes.OPTIONAL_INT)
            .addVersion(ClientVersion.V_26_1, 20, EntityDataTypes.OPTIONAL_INT)
            .build();

    /**
     * Supported versions: 1.21.6-
     */
    public static final EntityDataKey<NBTCompound> SHOULDER_RIGHT = EntityDataKey.<NBTCompound>builder(PlayerDataKeys.class)
            .addVersion(ClientVersion.V_1_14_4, 18, EntityDataTypes.NBT)
            .addVersion(ClientVersion.V_1_15, 19, EntityDataTypes.NBT)
            .addVersion(ClientVersion.V_1_16, 19, EntityDataTypes.NBT)
            .addVersion(ClientVersion.V_1_16_2, 19, EntityDataTypes.NBT)
            .addVersion(ClientVersion.V_1_17, 20, EntityDataTypes.NBT)
            .addVersion(ClientVersion.V_1_19, 20, EntityDataTypes.NBT)
            .addVersion(ClientVersion.V_1_19_1, 20, EntityDataTypes.NBT)
            .addVersion(ClientVersion.V_1_19_3, 20, EntityDataTypes.NBT)
            .addVersion(ClientVersion.V_1_19_4, 20, EntityDataTypes.NBT)
            .addVersion(ClientVersion.V_1_20_2, 20, EntityDataTypes.NBT)
            .addVersion(ClientVersion.V_1_20_3, 20, EntityDataTypes.NBT)
            .addVersion(ClientVersion.V_1_20_5, 20, EntityDataTypes.NBT)
            .addVersion(ClientVersion.V_1_21, 20, EntityDataTypes.NBT)
            .addVersion(ClientVersion.V_1_21_2, 20, EntityDataTypes.NBT)
            .addVersion(ClientVersion.V_1_21_4, 20, EntityDataTypes.NBT)
            .addVersion(ClientVersion.V_1_21_5, 20, EntityDataTypes.NBT)
            .addVersion(ClientVersion.V_1_21_6, 20, EntityDataTypes.NBT)
            .build();

}
