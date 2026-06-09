// Auto-generated file. Do not edit manually.
package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import com.github.retrooper.packetevents.protocol.player.HumanoidArm;
import me.tofaa.entitylib.meta.EntityDataKey;

/**
 * Supported versions: 1.21.9+
 */
public class AvatarDataKeys extends LivingEntityDataKeys {

    /**
     * Supported versions: 1.21.9+
     */
    public static final EntityDataKey<HumanoidArm> PLAYER_MAIN_HAND = EntityDataKey.<HumanoidArm>builder(AvatarDataKeys.class)
            // TODO type changed from 'Byte' to 'HumanoidArm', converter required
            .addVersion(ClientVersion.V_1_21_11, 15, EntityDataTypes.HUMANOID_ARM)
            .addVersion(ClientVersion.V_26_1, 15, EntityDataTypes.HUMANOID_ARM)
            .build();

    /**
     * Supported versions: 1.21.9+
     */
    public static final EntityDataKey<Byte> PLAYER_MODE_CUSTOMISATION = EntityDataKey.<Byte>builder(AvatarDataKeys.class)
            .addVersion(ClientVersion.V_1_21_9, 16, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_11, 16, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_26_1, 16, EntityDataTypes.BYTE)
            .build();

}
