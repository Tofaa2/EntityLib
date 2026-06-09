// Auto-generated file. Do not edit manually.
package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.item.ItemStack;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.EntityDataKey;

/**
 * Supported versions: All versions
 */
public class ItemFrameDataKeys extends HangingEntityDataKeys {

    /**
     * Supported versions: All versions
     */
    public static final EntityDataKey<ItemStack> ITEM = EntityDataKey.<ItemStack>builder(ItemFrameDataKeys.class)
            .addVersion(ClientVersion.V_1_14_4, 7, EntityDataTypes.ITEMSTACK)
            .addVersion(ClientVersion.V_1_15, 7, EntityDataTypes.ITEMSTACK)
            .addVersion(ClientVersion.V_1_16, 7, EntityDataTypes.ITEMSTACK)
            .addVersion(ClientVersion.V_1_16_2, 7, EntityDataTypes.ITEMSTACK)
            .addVersion(ClientVersion.V_1_17, 8, EntityDataTypes.ITEMSTACK)
            .addVersion(ClientVersion.V_1_19, 8, EntityDataTypes.ITEMSTACK)
            .addVersion(ClientVersion.V_1_19_1, 8, EntityDataTypes.ITEMSTACK)
            .addVersion(ClientVersion.V_1_19_3, 8, EntityDataTypes.ITEMSTACK)
            .addVersion(ClientVersion.V_1_19_4, 8, EntityDataTypes.ITEMSTACK)
            .addVersion(ClientVersion.V_1_20_2, 8, EntityDataTypes.ITEMSTACK)
            .addVersion(ClientVersion.V_1_20_3, 8, EntityDataTypes.ITEMSTACK)
            .addVersion(ClientVersion.V_1_20_5, 8, EntityDataTypes.ITEMSTACK)
            .addVersion(ClientVersion.V_1_21, 8, EntityDataTypes.ITEMSTACK)
            .addVersion(ClientVersion.V_1_21_2, 8, EntityDataTypes.ITEMSTACK)
            .addVersion(ClientVersion.V_1_21_4, 8, EntityDataTypes.ITEMSTACK)
            .addVersion(ClientVersion.V_1_21_5, 8, EntityDataTypes.ITEMSTACK)
            .addVersion(ClientVersion.V_1_21_6, 9, EntityDataTypes.ITEMSTACK)
            .addVersion(ClientVersion.V_1_21_9, 9, EntityDataTypes.ITEMSTACK)
            .addVersion(ClientVersion.V_1_21_11, 9, EntityDataTypes.ITEMSTACK)
            .addVersion(ClientVersion.V_26_1, 9, EntityDataTypes.ITEMSTACK)
            .build();

    /**
     * Supported versions: All versions
     */
    public static final EntityDataKey<Integer> ROTATION = EntityDataKey.<Integer>builder(ItemFrameDataKeys.class)
            .addVersion(ClientVersion.V_1_14_4, 8, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_15, 8, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_16, 8, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_16_2, 8, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_17, 9, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_19, 9, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_19_1, 9, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_19_3, 9, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_19_4, 9, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_20_2, 9, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_20_3, 9, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_20_5, 9, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21, 9, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_2, 9, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_4, 9, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_5, 9, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_6, 10, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_9, 10, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_11, 10, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_26_1, 10, EntityDataTypes.INT)
            .build();

}
