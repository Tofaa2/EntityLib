package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import com.github.retrooper.packetevents.protocol.player.HumanoidArm;
import me.tofaa.entitylib.meta.VersionedMetadataKey;

/**
 * Supported versions: 1.21.9+
 */
public class AvatarDataKeys extends LivingEntityDataKeys {

    /**
     * Supported versions: 1.21.9+
     */
    public static final VersionedMetadataKey<HumanoidArm> PLAYER_MAIN_HAND = VersionedMetadataKey.<HumanoidArm>builder()
            .add(ClientVersion.V_1_21_9, 15, EntityDataTypes.HUMANOID_ARM)
            .add(ClientVersion.V_1_21_11, 15, EntityDataTypes.HUMANOID_ARM)
            .add(ClientVersion.V_26_1, 15, EntityDataTypes.HUMANOID_ARM)
            .build();

    /**
     * Supported versions: 1.21.9+
     */
    public static final VersionedMetadataKey<Byte> PLAYER_MODE_CUSTOMISATION = VersionedMetadataKey.<Byte>builder()
            .add(ClientVersion.V_1_21_9, 16, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21_11, 16, EntityDataTypes.BYTE)
            .add(ClientVersion.V_26_1, 16, EntityDataTypes.BYTE)
            .build();

}
