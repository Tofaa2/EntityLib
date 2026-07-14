package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Shulker.
 */
public final class ShulkerMetaFields {
    public static final MetaField<Object> ATTACH_FACE = MetaField.builder("ATTACH_FACE")
    .versionRange(498, 498, 14, EntityDataTypes.INT)
    .versionRange(573, 751, 15, EntityDataTypes.INT)
    .versionRange(755, 2147483647, 16, EntityDataTypes.INT)
    .build();

    public static final MetaField<Object> ATTACH_POS = MetaField.builder("ATTACH_POS")
    .versionRange(498, 498, 15, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
    .versionRange(573, 2147483647, 16, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
    .build();

    public static final MetaField<Byte> PEEK = MetaField.byteBuilder("PEEK")
    .defaultValue((byte) 0)
    .versionRange(498, 498, 16, EntityDataTypes.BYTE)
    .versionRange(573, 2147483647, 17, EntityDataTypes.BYTE)
    .build();

    public static final MetaField<Byte> COLOR = MetaField.byteBuilder("COLOR")
    .defaultValue((byte) 0)
    .versionRange(498, 498, 17, EntityDataTypes.BYTE)
    .versionRange(573, 2147483647, 18, EntityDataTypes.BYTE)
    .build();

    private ShulkerMetaFields() {
    }
}
