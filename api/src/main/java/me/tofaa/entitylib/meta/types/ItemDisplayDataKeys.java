// Auto-generated file. Do not edit manually.
package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.item.ItemStack;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.EntityDataKey;

/**
 * Supported versions: 1.19.4+
 */
public class ItemDisplayDataKeys extends DisplayDataKeys {

    /**
     * Supported versions: 1.19.4+
     */
    public static final EntityDataKey<Byte> ITEM_DISPLAY = EntityDataKey.<Byte>builder(ItemDisplayDataKeys.class)
            .addVersion(ClientVersion.V_1_19_4, 23, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_20_2, 24, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_20_3, 24, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_20_5, 24, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21, 24, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_2, 24, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_4, 24, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_5, 24, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_6, 24, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_9, 24, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_11, 24, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_26_1, 24, EntityDataTypes.BYTE)
            .build();

    /**
     * Supported versions: 1.19.4+
     */
    public static final EntityDataKey<ItemStack> ITEM_STACK = EntityDataKey.<ItemStack>builder(ItemDisplayDataKeys.class)
            .addVersion(ClientVersion.V_1_19_4, 22, EntityDataTypes.ITEMSTACK)
            .addVersion(ClientVersion.V_1_20_2, 23, EntityDataTypes.ITEMSTACK)
            .addVersion(ClientVersion.V_1_20_3, 23, EntityDataTypes.ITEMSTACK)
            .addVersion(ClientVersion.V_1_20_5, 23, EntityDataTypes.ITEMSTACK)
            .addVersion(ClientVersion.V_1_21, 23, EntityDataTypes.ITEMSTACK)
            .addVersion(ClientVersion.V_1_21_2, 23, EntityDataTypes.ITEMSTACK)
            .addVersion(ClientVersion.V_1_21_4, 23, EntityDataTypes.ITEMSTACK)
            .addVersion(ClientVersion.V_1_21_5, 23, EntityDataTypes.ITEMSTACK)
            .addVersion(ClientVersion.V_1_21_6, 23, EntityDataTypes.ITEMSTACK)
            .addVersion(ClientVersion.V_1_21_9, 23, EntityDataTypes.ITEMSTACK)
            .addVersion(ClientVersion.V_1_21_11, 23, EntityDataTypes.ITEMSTACK)
            .addVersion(ClientVersion.V_26_1, 23, EntityDataTypes.ITEMSTACK)
            .build();

}
