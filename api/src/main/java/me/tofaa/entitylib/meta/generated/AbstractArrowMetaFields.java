package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Abstract Arrow.
 */
public final class AbstractArrowMetaFields {
    public static final MetaField<Byte> ID_FLAGS = MetaField.byteBuilder("ID_FLAGS")
    .defaultValue((byte) 0)
    .versionRange(498, 751, 7, EntityDataTypes.BYTE)
    .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
    .build();

    public static final MetaField<Object> OWNERUUID = MetaField.builder("OWNERUUID")
    .versionRange(498, 2147483647, 8, EntityDataTypes.OPTIONAL_UUID)
    .build();

    public static final MetaField<Byte> PIERCE_LEVEL = MetaField.byteBuilder("PIERCE_LEVEL")
    .defaultValue((byte) 0)
    .versionRange(498, 573, 9, EntityDataTypes.BYTE)
    .versionRange(735, 751, 8, EntityDataTypes.BYTE)
    .versionRange(755, 2147483647, 9, EntityDataTypes.BYTE)
    .build();

    public static final MetaField<Boolean> IN_GROUND = MetaField.booleanBuilder("IN_GROUND")
    .defaultValue(false)
    .versionRange(768, 2147483647, 10, EntityDataTypes.BOOLEAN)
    .build();

    private AbstractArrowMetaFields() {
    }
}
