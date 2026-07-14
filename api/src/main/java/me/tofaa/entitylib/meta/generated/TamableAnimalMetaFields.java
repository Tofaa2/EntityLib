package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Tamable Animal.
 */
public final class TamableAnimalMetaFields {
    public static final MetaField<Byte> FLAGS = MetaField.byteBuilder("FLAGS")
    .defaultValue((byte) 0)
    .versionRange(498, 498, 15, EntityDataTypes.BYTE)
    .versionRange(573, 751, 16, EntityDataTypes.BYTE)
    .versionRange(755, 773, 17, EntityDataTypes.BYTE)
    .versionRange(774, 2147483647, 18, EntityDataTypes.BYTE)
    .build();

    public static final MetaField<Object> OWNERUUID = MetaField.builder("OWNERUUID")
    .versionRange(498, 498, 16, EntityDataTypes.OPTIONAL_UUID)
    .versionRange(573, 751, 17, EntityDataTypes.OPTIONAL_UUID)
    .versionRange(755, 769, 18, EntityDataTypes.OPTIONAL_UUID)
    .versionRange(770, 773, 18, EntityDataTypes.INT)
    .versionRange(774, 2147483647, 19, EntityDataTypes.INT)
    .build();

    private TamableAnimalMetaFields() {
    }
}
