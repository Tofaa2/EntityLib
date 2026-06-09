package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.VersionedMetadataKey;
import net.kyori.adventure.text.Component;

/**
 * Supported versions: 1.19.4+
 */
public class TextDisplayDataKeys extends DisplayDataKeys {

    /**
     * Supported versions: 1.19.4+
     */
    public static final VersionedMetadataKey<Integer> BACKGROUND_COLOR = VersionedMetadataKey.<Integer>builder()
            .add(ClientVersion.V_1_19_4, 24, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_2, 25, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_3, 25, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_5, 25, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21, 25, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_2, 25, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_4, 25, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_5, 25, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_6, 25, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_9, 25, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_11, 25, EntityDataTypes.INT)
            .add(ClientVersion.V_26_1, 25, EntityDataTypes.INT)
            .build();

    /**
     * Supported versions: 1.19.4+
     */
    public static final VersionedMetadataKey<Integer> LINE_WIDTH = VersionedMetadataKey.<Integer>builder()
            .add(ClientVersion.V_1_19_4, 23, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_2, 24, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_3, 24, EntityDataTypes.INT)
            .add(ClientVersion.V_1_20_5, 24, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21, 24, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_2, 24, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_4, 24, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_5, 24, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_6, 24, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_9, 24, EntityDataTypes.INT)
            .add(ClientVersion.V_1_21_11, 24, EntityDataTypes.INT)
            .add(ClientVersion.V_26_1, 24, EntityDataTypes.INT)
            .build();

    /**
     * Supported versions: 1.19.4+
     */
    public static final VersionedMetadataKey<Byte> STYLE_FLAGS = VersionedMetadataKey.<Byte>builder()
            .add(ClientVersion.V_1_19_4, 26, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_20_2, 27, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_20_3, 27, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_20_5, 27, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21, 27, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21_2, 27, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21_4, 27, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21_5, 27, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21_6, 27, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21_9, 27, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21_11, 27, EntityDataTypes.BYTE)
            .add(ClientVersion.V_26_1, 27, EntityDataTypes.BYTE)
            .build();

    /**
     * Supported versions: 1.19.4+
     */
    public static final VersionedMetadataKey<Component> TEXT = VersionedMetadataKey.<Component>builder()
            .add(ClientVersion.V_1_19_4, 22, EntityDataTypes.ADV_COMPONENT)
            .add(ClientVersion.V_1_20_2, 23, EntityDataTypes.ADV_COMPONENT)
            .add(ClientVersion.V_1_20_3, 23, EntityDataTypes.ADV_COMPONENT)
            .add(ClientVersion.V_1_20_5, 23, EntityDataTypes.ADV_COMPONENT)
            .add(ClientVersion.V_1_21, 23, EntityDataTypes.ADV_COMPONENT)
            .add(ClientVersion.V_1_21_2, 23, EntityDataTypes.ADV_COMPONENT)
            .add(ClientVersion.V_1_21_4, 23, EntityDataTypes.ADV_COMPONENT)
            .add(ClientVersion.V_1_21_5, 23, EntityDataTypes.ADV_COMPONENT)
            .add(ClientVersion.V_1_21_6, 23, EntityDataTypes.ADV_COMPONENT)
            .add(ClientVersion.V_1_21_9, 23, EntityDataTypes.ADV_COMPONENT)
            .add(ClientVersion.V_1_21_11, 23, EntityDataTypes.ADV_COMPONENT)
            .add(ClientVersion.V_26_1, 23, EntityDataTypes.ADV_COMPONENT)
            .build();

    /**
     * Supported versions: 1.19.4+
     */
    public static final VersionedMetadataKey<Byte> TEXT_OPACITY = VersionedMetadataKey.<Byte>builder()
            .add(ClientVersion.V_1_19_4, 25, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_20_2, 26, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_20_3, 26, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_20_5, 26, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21, 26, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21_2, 26, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21_4, 26, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21_5, 26, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21_6, 26, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21_9, 26, EntityDataTypes.BYTE)
            .add(ClientVersion.V_1_21_11, 26, EntityDataTypes.BYTE)
            .add(ClientVersion.V_26_1, 26, EntityDataTypes.BYTE)
            .build();

}
