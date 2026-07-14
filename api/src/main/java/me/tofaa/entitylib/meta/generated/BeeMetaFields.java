package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Bee.
 */
public final class BeeMetaFields {
    public static final MetaField<Byte> FLAGS = MetaField.byteBuilder("FLAGS")
    .defaultValue((byte) 0)
    .versionRange(573, 751, 16, EntityDataTypes.BYTE)
    .versionRange(755, 773, 17, EntityDataTypes.BYTE)
    .versionRange(774, 2147483647, 18, EntityDataTypes.BYTE)
    .build();

    public static final MetaField<Integer> ANGER_TIME = MetaField.intBuilder("ANGER_TIME")
    .defaultValue(0)
    .versionRange(573, 2147483647, 17, EntityDataTypes.INT)
    .build();

    public static final MetaField<Integer> REMAINING_ANGER_TIME = MetaField.intBuilder("REMAINING_ANGER_TIME")
    .defaultValue(0)
    .versionRange(735, 751, 17, EntityDataTypes.INT)
    .versionRange(755, 2147483647, 18, EntityDataTypes.INT)
    .build();

    public static final MetaField<Long> ANGER_END_TIME = MetaField.longBuilder("ANGER_END_TIME")
    .defaultValue(0L)
    .versionRange(773, 773, 18, EntityDataTypes.LONG)
    .versionRange(774, 2147483647, 19, EntityDataTypes.LONG)
    .build();

    private BeeMetaFields() {
    }
}
