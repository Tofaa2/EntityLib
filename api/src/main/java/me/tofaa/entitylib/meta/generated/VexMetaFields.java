package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Vex.
 */
public final class VexMetaFields {
    public static final MetaField<Byte> FLAGS = MetaField.byteBuilder("FLAGS")
    .defaultValue((byte) 0)
    .versionRange(498, 498, 14, EntityDataTypes.BYTE)
    .versionRange(573, 751, 15, EntityDataTypes.BYTE)
    .versionRange(755, 2147483647, 16, EntityDataTypes.BYTE)
    .build();

    private VexMetaFields() {
    }
}
