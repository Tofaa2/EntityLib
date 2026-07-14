package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Thrown Trident.
 */
public final class ThrownTridentMetaFields {
    public static final MetaField<Byte> ID_LOYALTY = MetaField.byteBuilder("ID_LOYALTY")
    .defaultValue((byte) 0)
    .versionRange(498, 573, 10, EntityDataTypes.BYTE)
    .versionRange(735, 751, 9, EntityDataTypes.BYTE)
    .versionRange(755, 767, 10, EntityDataTypes.BYTE)
    .versionRange(768, 2147483647, 11, EntityDataTypes.BYTE)
    .build();

    public static final MetaField<Boolean> ID_FOIL = MetaField.booleanBuilder("ID_FOIL")
    .defaultValue(false)
    .versionRange(573, 573, 11, EntityDataTypes.BOOLEAN)
    .versionRange(735, 751, 10, EntityDataTypes.BOOLEAN)
    .versionRange(755, 767, 11, EntityDataTypes.BOOLEAN)
    .versionRange(768, 2147483647, 12, EntityDataTypes.BOOLEAN)
    .build();

    private ThrownTridentMetaFields() {
    }
}
