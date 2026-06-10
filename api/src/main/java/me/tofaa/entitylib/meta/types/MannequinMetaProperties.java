// Auto-generated file. Do not edit manually.
package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.component.builtin.item.ItemProfile;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.property.MetadataProperty;
import me.tofaa.entitylib.meta.property.SimpleProperty;
import net.kyori.adventure.text.Component;

import java.util.Optional;

/**
 * Supported versions: 1.21.9+
 */
public class MannequinMetaProperties extends AvatarMetaProperties {

    /**
     * Supported versions: 1.21.9+
     */
    public static final SimpleProperty<Optional<Component>> DESCRIPTION = MetadataProperty.<Optional<Component>>builder(MannequinMetaProperties.class)
            .addVersion(ClientVersion.V_1_21_9, 19, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
            .addVersion(ClientVersion.V_1_21_11, 19, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
            .addVersion(ClientVersion.V_26_1, 19, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
            .build();

    /**
     * Supported versions: 1.21.9+
     */
    public static final SimpleProperty<Boolean> IMMOVABLE = MetadataProperty.<Boolean>builder(MannequinMetaProperties.class)
            .addVersion(ClientVersion.V_1_21_9, 18, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_11, 18, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_26_1, 18, EntityDataTypes.BOOLEAN)
            .build();

    /**
     * Supported versions: 1.21.9+
     */
    public static final SimpleProperty<ItemProfile> PROFILE = MetadataProperty.<ItemProfile>builder(MannequinMetaProperties.class)
            .addVersion(ClientVersion.V_1_21_9, 17, EntityDataTypes.RESOLVABLE_PROFILE)
            .addVersion(ClientVersion.V_1_21_11, 17, EntityDataTypes.RESOLVABLE_PROFILE)
            .addVersion(ClientVersion.V_26_1, 17, EntityDataTypes.RESOLVABLE_PROFILE)
            .build();

}
