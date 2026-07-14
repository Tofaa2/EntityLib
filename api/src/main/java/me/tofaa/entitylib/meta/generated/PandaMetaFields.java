package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Panda.
 */
public final class PandaMetaFields {
    public static final MetaField<Integer> UNHAPPY_COUNTER = MetaField.intBuilder("UNHAPPY_COUNTER")
    .defaultValue(0)
    .versionRange(498, 498, 15, EntityDataTypes.INT)
    .versionRange(573, 751, 16, EntityDataTypes.INT)
    .versionRange(755, 773, 17, EntityDataTypes.INT)
    .versionRange(774, 2147483647, 18, EntityDataTypes.INT)
    .build();

    public static final MetaField<Integer> SNEEZE_COUNTER = MetaField.intBuilder("SNEEZE_COUNTER")
    .defaultValue(0)
    .versionRange(498, 498, 16, EntityDataTypes.INT)
    .versionRange(573, 751, 17, EntityDataTypes.INT)
    .versionRange(755, 773, 18, EntityDataTypes.INT)
    .versionRange(774, 2147483647, 19, EntityDataTypes.INT)
    .build();

    public static final MetaField<Integer> EAT_COUNTER = MetaField.intBuilder("EAT_COUNTER")
    .defaultValue(0)
    .versionRange(498, 498, 17, EntityDataTypes.INT)
    .versionRange(573, 751, 18, EntityDataTypes.INT)
    .versionRange(755, 773, 19, EntityDataTypes.INT)
    .versionRange(774, 2147483647, 20, EntityDataTypes.INT)
    .build();

    public static final MetaField<Byte> MAIN_GENE = MetaField.byteBuilder("MAIN_GENE")
    .defaultValue((byte) 0)
    .versionRange(498, 498, 18, EntityDataTypes.BYTE)
    .versionRange(573, 751, 19, EntityDataTypes.BYTE)
    .versionRange(755, 773, 20, EntityDataTypes.BYTE)
    .versionRange(774, 2147483647, 21, EntityDataTypes.BYTE)
    .build();

    public static final MetaField<Byte> HIDDEN_GENE = MetaField.byteBuilder("HIDDEN_GENE")
    .defaultValue((byte) 0)
    .versionRange(498, 498, 19, EntityDataTypes.BYTE)
    .versionRange(573, 751, 20, EntityDataTypes.BYTE)
    .versionRange(755, 773, 21, EntityDataTypes.BYTE)
    .versionRange(774, 2147483647, 22, EntityDataTypes.BYTE)
    .build();

    public static final MetaField<Byte> FLAGS = MetaField.byteBuilder("FLAGS")
    .defaultValue((byte) 0)
    .versionRange(498, 498, 20, EntityDataTypes.BYTE)
    .versionRange(573, 751, 21, EntityDataTypes.BYTE)
    .versionRange(755, 773, 22, EntityDataTypes.BYTE)
    .versionRange(774, 2147483647, 23, EntityDataTypes.BYTE)
    .build();

    private PandaMetaFields() {
    }
}
