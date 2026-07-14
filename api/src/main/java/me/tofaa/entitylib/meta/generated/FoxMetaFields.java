package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Fox.
 */
public final class FoxMetaFields {
    public static final MetaField<Integer> TYPE = MetaField.intBuilder("TYPE")
    .defaultValue(0)
    .versionRange(498, 498, 15, EntityDataTypes.INT)
    .versionRange(573, 751, 16, EntityDataTypes.INT)
    .versionRange(755, 773, 17, EntityDataTypes.INT)
    .versionRange(774, 2147483647, 18, EntityDataTypes.INT)
    .build();

    public static final MetaField<Byte> FLAGS = MetaField.byteBuilder("FLAGS")
    .defaultValue((byte) 0)
    .versionRange(498, 498, 16, EntityDataTypes.BYTE)
    .versionRange(573, 751, 17, EntityDataTypes.BYTE)
    .versionRange(755, 773, 18, EntityDataTypes.BYTE)
    .versionRange(774, 2147483647, 19, EntityDataTypes.BYTE)
    .build();

    public static final MetaField<Object> TRUSTED_0 = MetaField.builder("TRUSTED_0")
    .versionRange(498, 498, 17, EntityDataTypes.OPTIONAL_UUID)
    .versionRange(573, 751, 18, EntityDataTypes.OPTIONAL_UUID)
    .versionRange(755, 769, 19, EntityDataTypes.OPTIONAL_UUID)
    .versionRange(770, 773, 19, EntityDataTypes.INT)
    .versionRange(774, 2147483647, 20, EntityDataTypes.INT)
    .build();

    public static final MetaField<Object> TRUSTED_1 = MetaField.builder("TRUSTED_1")
    .versionRange(498, 498, 18, EntityDataTypes.OPTIONAL_UUID)
    .versionRange(573, 751, 19, EntityDataTypes.OPTIONAL_UUID)
    .versionRange(755, 769, 20, EntityDataTypes.OPTIONAL_UUID)
    .versionRange(770, 773, 20, EntityDataTypes.INT)
    .versionRange(774, 2147483647, 21, EntityDataTypes.INT)
    .build();

    private FoxMetaFields() {
    }
}
