package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Abstract Horse.
 */
public final class AbstractHorseMetaFields {
    public static final MetaField<Byte> FLAGS = MetaField.byteBuilder("FLAGS")
    .defaultValue((byte) 0)
    .versionRange(498, 498, 15, EntityDataTypes.BYTE)
    .versionRange(573, 751, 16, EntityDataTypes.BYTE)
    .versionRange(755, 773, 17, EntityDataTypes.BYTE)
    .versionRange(774, 2147483647, 18, EntityDataTypes.BYTE)
    .build();

    public static final MetaField<Object> OWNER_UUID = MetaField.builder("OWNER_UUID")
    .versionRange(498, 498, 16, EntityDataTypes.OPTIONAL_UUID)
    .versionRange(573, 751, 17, EntityDataTypes.OPTIONAL_UUID)
    .versionRange(755, 2147483647, 18, EntityDataTypes.OPTIONAL_UUID)
    .build();

    private AbstractHorseMetaFields() {
    }
}
