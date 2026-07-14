package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Text Display.
 */
public final class TextDisplayMetaFields {
    public static final MetaField<Object> TEXT = MetaField.builder("TEXT")
    .versionRange(762, 762, 22, EntityDataTypes.ADV_COMPONENT)
    .versionRange(764, 2147483647, 23, EntityDataTypes.ADV_COMPONENT)
    .build();

    public static final MetaField<Integer> LINE_WIDTH = MetaField.intBuilder("LINE_WIDTH")
    .defaultValue(0)
    .versionRange(762, 762, 23, EntityDataTypes.INT)
    .versionRange(764, 2147483647, 24, EntityDataTypes.INT)
    .build();

    public static final MetaField<Integer> BACKGROUND_COLOR = MetaField.intBuilder("BACKGROUND_COLOR")
    .defaultValue(0)
    .versionRange(762, 762, 24, EntityDataTypes.INT)
    .versionRange(764, 2147483647, 25, EntityDataTypes.INT)
    .build();

    public static final MetaField<Byte> TEXT_OPACITY = MetaField.byteBuilder("TEXT_OPACITY")
    .defaultValue((byte) 0)
    .versionRange(762, 762, 25, EntityDataTypes.BYTE)
    .versionRange(764, 2147483647, 26, EntityDataTypes.BYTE)
    .build();

    public static final MetaField<Byte> STYLE_FLAGS = MetaField.byteBuilder("STYLE_FLAGS")
    .defaultValue((byte) 0)
    .versionRange(762, 762, 26, EntityDataTypes.BYTE)
    .versionRange(764, 2147483647, 27, EntityDataTypes.BYTE)
    .build();

    private TextDisplayMetaFields() {
    }
}
