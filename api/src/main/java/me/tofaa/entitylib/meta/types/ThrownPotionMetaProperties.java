// Auto-generated file. Do not edit manually.
package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.item.ItemStack;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.property.MetadataProperty;
import me.tofaa.entitylib.meta.property.SimpleProperty;

/**
 * Supported versions: 1.21.4-
 */
public class ThrownPotionMetaProperties extends ThrowableProjectileMetaProperties {

    /**
     * Supported versions: 1.15-
     */
    public static final SimpleProperty<ItemStack> ITEM_STACK = MetadataProperty.<ItemStack>builder(ThrownPotionMetaProperties.class)
            .addVersion(ClientVersion.V_1_14_4, 7, EntityDataTypes.ITEMSTACK)
            .addVersion(ClientVersion.V_1_15, 7, EntityDataTypes.ITEMSTACK)
            .build();

}
