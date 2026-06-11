// Auto-generated file. Do not edit manually.
package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import com.github.retrooper.packetevents.protocol.player.HumanoidArm;
import me.tofaa.entitylib.meta.property.MetadataProperty;
import me.tofaa.entitylib.meta.property.SimpleProperty;
import me.tofaa.entitylib.meta.property.WrapperProperty;
import me.tofaa.entitylib.meta.wrapper.impl.WrapperAvatarPlayerModeCustomizationFlags;

/**
 * Supported versions: 1.21.9+
 */
public class AvatarMetaProperties extends LivingEntityMetaProperties {

    /**
     * Supported versions: 1.21.9+
     */
    public static final SimpleProperty<HumanoidArm> PLAYER_MAIN_HAND = MetadataProperty.<HumanoidArm>builder(AvatarMetaProperties.class)
            // TODO type changed from 'Byte' to 'HumanoidArm', converter required
            .addVersion(ClientVersion.V_1_21_11, 15, EntityDataTypes.HUMANOID_ARM)
            .addVersion(ClientVersion.V_26_1, 15, EntityDataTypes.HUMANOID_ARM)
            .build();

    /**
     * Supported versions: 1.21.9+
     */
    public static final WrapperProperty<Byte, WrapperAvatarPlayerModeCustomizationFlags> PLAYER_MODE_CUSTOMISATION = MetadataProperty.<Byte>builder(AvatarMetaProperties.class)
            .addVersion(ClientVersion.V_1_21_9, 16, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_11, 16, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_26_1, 16, EntityDataTypes.BYTE)
            .wrapped(WrapperAvatarPlayerModeCustomizationFlags::new)
            .build();

}
