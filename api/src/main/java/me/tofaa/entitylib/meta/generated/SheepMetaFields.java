package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Sheep.
 */
public final class SheepMetaFields {
    public static final MetaField<Byte> WOOL = MetaField.byteBuilder("WOOL")
    .defaultValue((byte) 0)
    .versionRange(498, 498, 15, EntityDataTypes.BYTE)
    .versionRange(573, 751, 16, EntityDataTypes.BYTE)
    .versionRange(755, 773, 17, EntityDataTypes.BYTE)
    .versionRange(774, 2147483647, 18, EntityDataTypes.BYTE)
    .build();

    private SheepMetaFields() {
    }
}
