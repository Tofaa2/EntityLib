// Auto-generated file. Do not edit manually.
package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.property.MetadataProperty;
import me.tofaa.entitylib.meta.property.SimpleProperty;
import net.kyori.adventure.text.Component;

/**
 * Supported versions: 1.19.4+
 */
public class TextDisplayMetaProperties extends DisplayMetaProperties {

    /**
     * Supported versions: 1.19.4+
     */
    public static final SimpleProperty<Integer> BACKGROUND_COLOR = MetadataProperty.<Integer>builder(TextDisplayMetaProperties.class)
            .addVersion(ClientVersion.V_1_19_4, 24, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_20_2, 25, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_20_3, 25, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_20_5, 25, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21, 25, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_2, 25, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_4, 25, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_5, 25, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_6, 25, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_9, 25, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_11, 25, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_26_1, 25, EntityDataTypes.INT)
            .build();

    /**
     * Supported versions: 1.19.4+
     */
    public static final SimpleProperty<Integer> LINE_WIDTH = MetadataProperty.<Integer>builder(TextDisplayMetaProperties.class)
            .addVersion(ClientVersion.V_1_19_4, 23, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_20_2, 24, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_20_3, 24, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_20_5, 24, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21, 24, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_2, 24, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_4, 24, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_5, 24, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_6, 24, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_9, 24, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_1_21_11, 24, EntityDataTypes.INT)
            .addVersion(ClientVersion.V_26_1, 24, EntityDataTypes.INT)
            .build();

    /**
     * Supported versions: 1.19.4+
     */
    public static final SimpleProperty<Byte> STYLE_FLAGS = MetadataProperty.<Byte>builder(TextDisplayMetaProperties.class)
            .addVersion(ClientVersion.V_1_19_4, 26, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_20_2, 27, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_20_3, 27, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_20_5, 27, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21, 27, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_2, 27, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_4, 27, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_5, 27, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_6, 27, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_9, 27, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_11, 27, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_26_1, 27, EntityDataTypes.BYTE)
            .build();

    /**
     * Supported versions: 1.19.4+
     */
    public static final SimpleProperty<Component> TEXT = MetadataProperty.<Component>builder(TextDisplayMetaProperties.class)
            .addVersion(ClientVersion.V_1_19_4, 22, EntityDataTypes.ADV_COMPONENT)
            .addVersion(ClientVersion.V_1_20_2, 23, EntityDataTypes.ADV_COMPONENT)
            .addVersion(ClientVersion.V_1_20_3, 23, EntityDataTypes.ADV_COMPONENT)
            .addVersion(ClientVersion.V_1_20_5, 23, EntityDataTypes.ADV_COMPONENT)
            .addVersion(ClientVersion.V_1_21, 23, EntityDataTypes.ADV_COMPONENT)
            .addVersion(ClientVersion.V_1_21_2, 23, EntityDataTypes.ADV_COMPONENT)
            .addVersion(ClientVersion.V_1_21_4, 23, EntityDataTypes.ADV_COMPONENT)
            .addVersion(ClientVersion.V_1_21_5, 23, EntityDataTypes.ADV_COMPONENT)
            .addVersion(ClientVersion.V_1_21_6, 23, EntityDataTypes.ADV_COMPONENT)
            .addVersion(ClientVersion.V_1_21_9, 23, EntityDataTypes.ADV_COMPONENT)
            .addVersion(ClientVersion.V_1_21_11, 23, EntityDataTypes.ADV_COMPONENT)
            .addVersion(ClientVersion.V_26_1, 23, EntityDataTypes.ADV_COMPONENT)
            .build();

    /**
     * Supported versions: 1.19.4+
     */
    public static final SimpleProperty<Byte> TEXT_OPACITY = MetadataProperty.<Byte>builder(TextDisplayMetaProperties.class)
            .addVersion(ClientVersion.V_1_19_4, 25, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_20_2, 26, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_20_3, 26, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_20_5, 26, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21, 26, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_2, 26, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_4, 26, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_5, 26, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_6, 26, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_9, 26, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_1_21_11, 26, EntityDataTypes.BYTE)
            .addVersion(ClientVersion.V_26_1, 26, EntityDataTypes.BYTE)
            .build();

}
