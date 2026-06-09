// Auto-generated file. Do not edit manually.
package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.item.ItemStack;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.EntityDataKey;

/**
 * Supported versions: 1.20.5+
 */
public class OminousItemSpawnerDataKeys extends EntityDataKeys {

    /**
     * Supported versions: 1.20.5+
     */
    public static final EntityDataKey<ItemStack> ITEM = EntityDataKey.<ItemStack>builder(OminousItemSpawnerDataKeys.class)
            .addVersion(ClientVersion.V_1_20_5, 8, EntityDataTypes.ITEMSTACK)
            .addVersion(ClientVersion.V_1_21, 8, EntityDataTypes.ITEMSTACK)
            .addVersion(ClientVersion.V_1_21_2, 8, EntityDataTypes.ITEMSTACK)
            .addVersion(ClientVersion.V_1_21_4, 8, EntityDataTypes.ITEMSTACK)
            .addVersion(ClientVersion.V_1_21_5, 8, EntityDataTypes.ITEMSTACK)
            .addVersion(ClientVersion.V_1_21_6, 8, EntityDataTypes.ITEMSTACK)
            .addVersion(ClientVersion.V_1_21_9, 8, EntityDataTypes.ITEMSTACK)
            .addVersion(ClientVersion.V_1_21_11, 8, EntityDataTypes.ITEMSTACK)
            .addVersion(ClientVersion.V_26_1, 8, EntityDataTypes.ITEMSTACK)
            .build();

}
