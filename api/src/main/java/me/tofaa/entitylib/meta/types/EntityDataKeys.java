// Auto-generated file. Do not edit manually.
package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.entity.pose.EntityPose;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.EntityDataKey;
import net.kyori.adventure.text.Component;

import java.util.Optional;

/**
 * Supported versions: All versions
 */
public class EntityDataKeys {

    /**
     * Supported versions: All versions
     */
    public static final EntityDataKey<Integer> AIR_SUPPLY = EntityDataKey.<Integer>builder(EntityDataKeys.class)
            .addVersion(ClientVersion.V_1_14_4, 1, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_15, 1, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_16, 1, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_16_2, 1, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_17, 1, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_19, 1, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_19_1, 1, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_19_3, 1, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_19_4, 1, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_20_2, 1, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_20_3, 1, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_20_5, 1, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21, 1, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_2, 1, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_4, 1, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_5, 1, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_6, 1, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_9, 1, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_11, 1, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_26_1, 1, EntityDataTypes.INT)
            .build();

    /**
     * Supported versions: All versions
     */
    public static final EntityDataKey<Optional<Component>> CUSTOM_NAME = EntityDataKey.<Optional<Component>>builder(EntityDataKeys.class)
            .addVersion(ClientVersion.V_1_14_4, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
            .addVersion(ClientVersion.V_1_15, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
            .addVersion(ClientVersion.V_1_16, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
            .addVersion(ClientVersion.V_1_16_2, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
            .addVersion(ClientVersion.V_1_17, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
            .addVersion(ClientVersion.V_1_19, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
            .addVersion(ClientVersion.V_1_19_1, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
            .addVersion(ClientVersion.V_1_19_3, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
            .addVersion(ClientVersion.V_1_19_4, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
            .addVersion(ClientVersion.V_1_20_2, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
            .addVersion(ClientVersion.V_1_20_3, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
            .addVersion(ClientVersion.V_1_20_5, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
            .addVersion(ClientVersion.V_1_21, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
            .addVersion(ClientVersion.V_1_21_2, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
            .addVersion(ClientVersion.V_1_21_4, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
            .addVersion(ClientVersion.V_1_21_5, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
            .addVersion(ClientVersion.V_1_21_6, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
            .addVersion(ClientVersion.V_1_21_9, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
            .addVersion(ClientVersion.V_1_21_11, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
            .addVersion(ClientVersion.V_26_1, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
            .build();

    /**
     * Supported versions: All versions
     */
    public static final EntityDataKey<Boolean> CUSTOM_NAME_VISIBLE = EntityDataKey.<Boolean>builder(EntityDataKeys.class)
            .addVersion(ClientVersion.V_1_14_4, 3, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_15, 3, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_16, 3, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_16_2, 3, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_17, 3, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_19, 3, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_19_1, 3, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_19_3, 3, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_19_4, 3, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_20_2, 3, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_20_3, 3, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_20_5, 3, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21, 3, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_2, 3, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_4, 3, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_5, 3, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_6, 3, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_9, 3, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_11, 3, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_26_1, 3, EntityDataTypes.BOOLEAN)
            .build();

    /**
     * Supported versions: All versions
     */
    public static final EntityDataKey<Boolean> NO_GRAVITY = EntityDataKey.<Boolean>builder(EntityDataKeys.class)
            .addVersion(ClientVersion.V_1_14_4, 5, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_15, 5, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_16, 5, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_16_2, 5, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_17, 5, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_19, 5, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_19_1, 5, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_19_3, 5, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_19_4, 5, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_20_2, 5, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_20_3, 5, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_20_5, 5, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21, 5, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_2, 5, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_4, 5, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_5, 5, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_6, 5, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_9, 5, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_11, 5, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_26_1, 5, EntityDataTypes.BOOLEAN)
            .build();

    /**
     * Supported versions: All versions
     */
    public static final EntityDataKey<EntityPose> POSE = EntityDataKey.<EntityPose>builder(EntityDataKeys.class)
            .addVersion(ClientVersion.V_1_14_4, 6, EntityDataTypes.ENTITY_POSE)
            .addVersion(ClientVersion.V_1_15, 6, EntityDataTypes.ENTITY_POSE)
            .addVersion(ClientVersion.V_1_16, 6, EntityDataTypes.ENTITY_POSE)
            .addVersion(ClientVersion.V_1_16_2, 6, EntityDataTypes.ENTITY_POSE)
            .addVersion(ClientVersion.V_1_17, 6, EntityDataTypes.ENTITY_POSE)
            .addVersion(ClientVersion.V_1_19, 6, EntityDataTypes.ENTITY_POSE)
            .addVersion(ClientVersion.V_1_19_1, 6, EntityDataTypes.ENTITY_POSE)
            .addVersion(ClientVersion.V_1_19_3, 6, EntityDataTypes.ENTITY_POSE)
            .addVersion(ClientVersion.V_1_19_4, 6, EntityDataTypes.ENTITY_POSE)
            .addVersion(ClientVersion.V_1_20_2, 6, EntityDataTypes.ENTITY_POSE)
            .addVersion(ClientVersion.V_1_20_3, 6, EntityDataTypes.ENTITY_POSE)
            .addVersion(ClientVersion.V_1_20_5, 6, EntityDataTypes.ENTITY_POSE)
            .addVersion(ClientVersion.V_1_21, 6, EntityDataTypes.ENTITY_POSE)
            .addVersion(ClientVersion.V_1_21_2, 6, EntityDataTypes.ENTITY_POSE)
            .addVersion(ClientVersion.V_1_21_4, 6, EntityDataTypes.ENTITY_POSE)
            .addVersion(ClientVersion.V_1_21_5, 6, EntityDataTypes.ENTITY_POSE)
            .addVersion(ClientVersion.V_1_21_6, 6, EntityDataTypes.ENTITY_POSE)
            .addVersion(ClientVersion.V_1_21_9, 6, EntityDataTypes.ENTITY_POSE)
            .addVersion(ClientVersion.V_1_21_11, 6, EntityDataTypes.ENTITY_POSE)
            .addVersion(ClientVersion.V_26_1, 6, EntityDataTypes.ENTITY_POSE)
            .build();

    /**
     * Supported versions: All versions
     */
    public static final EntityDataKey<Byte> SHARED_FLAGS = EntityDataKey.<Byte>builder(EntityDataKeys.class)
            .addVersion(ClientVersion.V_1_14_4, 0, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_15, 0, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_16, 0, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_16_2, 0, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_17, 0, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_19, 0, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_19_1, 0, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_19_3, 0, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_19_4, 0, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_20_2, 0, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_20_3, 0, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_20_5, 0, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21, 0, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_2, 0, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_4, 0, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_5, 0, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_6, 0, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_9, 0, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_11, 0, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_26_1, 0, EntityDataTypes.BYTE)
            .build();

    /**
     * Supported versions: All versions
     */
    public static final EntityDataKey<Boolean> SILENT = EntityDataKey.<Boolean>builder(EntityDataKeys.class)
            .addVersion(ClientVersion.V_1_14_4, 4, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_15, 4, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_16, 4, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_16_2, 4, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_17, 4, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_19, 4, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_19_1, 4, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_19_3, 4, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_19_4, 4, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_20_2, 4, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_20_3, 4, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_20_5, 4, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21, 4, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_2, 4, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_4, 4, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_5, 4, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_6, 4, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_9, 4, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_1_21_11, 4, EntityDataTypes.BOOLEAN)
            .addVersion(ClientVersion.V_26_1, 4, EntityDataTypes.BOOLEAN)
            .build();

    /**
     * Supported versions: 1.17+
     */
    public static final EntityDataKey<Integer> TICKS_FROZEN = EntityDataKey.<Integer>builder(EntityDataKeys.class)
            .addVersion(ClientVersion.V_1_17, 7, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_19, 7, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_19_1, 7, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_19_3, 7, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_19_4, 7, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_20_2, 7, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_20_3, 7, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_20_5, 7, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21, 7, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_2, 7, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_4, 7, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_5, 7, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_6, 7, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_9, 7, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_11, 7, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_26_1, 7, EntityDataTypes.INT)
            .build();

}
