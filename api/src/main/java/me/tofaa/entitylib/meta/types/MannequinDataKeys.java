package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.component.builtin.item.ItemProfile;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.VersionedMetadataKey;
import net.kyori.adventure.text.Component;

import java.util.Optional;

/**
 * Supported versions: 1.21.9+
 */
public class MannequinDataKeys extends AvatarDataKeys {

    /**
     * Supported versions: 1.21.9+
     */
    public static final VersionedMetadataKey<Optional<Component>> DESCRIPTION = VersionedMetadataKey.<Optional<Component>>builder()
            .add(ClientVersion.V_1_21_9, 19, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
            .add(ClientVersion.V_1_21_11, 19, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
            .add(ClientVersion.V_26_1, 19, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
            .build();

    /**
     * Supported versions: 1.21.9+
     */
    public static final VersionedMetadataKey<Boolean> IMMOVABLE = VersionedMetadataKey.<Boolean>builder()
            .add(ClientVersion.V_1_21_9, 18, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_1_21_11, 18, EntityDataTypes.BOOLEAN)
            .add(ClientVersion.V_26_1, 18, EntityDataTypes.BOOLEAN)
            .build();

    /**
     * Supported versions: 1.21.9+
     */
    public static final VersionedMetadataKey<ItemProfile> PROFILE = VersionedMetadataKey.<ItemProfile>builder()
            .add(ClientVersion.V_1_21_9, 17, EntityDataTypes.RESOLVABLE_PROFILE)
            .add(ClientVersion.V_1_21_11, 17, EntityDataTypes.RESOLVABLE_PROFILE)
            .add(ClientVersion.V_26_1, 17, EntityDataTypes.RESOLVABLE_PROFILE)
            .build();

}
