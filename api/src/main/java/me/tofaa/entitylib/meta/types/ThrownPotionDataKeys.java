package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.item.ItemStack;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.VersionedMetadataKey;

/**
 * Supported versions: 1.21.4-
 */
public class ThrownPotionDataKeys extends ThrowableProjectileDataKeys {

    /**
     * Supported versions: 1.15-
     */
    public static final VersionedMetadataKey<ItemStack> ITEM_STACK = VersionedMetadataKey.<ItemStack>builder()
            .add(ClientVersion.V_1_14_4, 7, EntityDataTypes.ITEMSTACK)
            .add(ClientVersion.V_1_15, 7, EntityDataTypes.ITEMSTACK)
            .build();

}
