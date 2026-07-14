package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Dolphin.
 */
public final class DolphinMetaFields {
    public static final MetaField<Object> TREASURE_POS = MetaField.builder("TREASURE_POS")
    .versionRange(498, 498, 14, EntityDataTypes.BLOCK_POSITION)
    .versionRange(573, 751, 15, EntityDataTypes.BLOCK_POSITION)
    .versionRange(755, 767, 16, EntityDataTypes.BLOCK_POSITION)
    .versionRange(768, 2147483647, 17, EntityDataTypes.BLOCK_POSITION)
    .build();

    public static final MetaField<Boolean> GOT_FISH = MetaField.booleanBuilder("GOT_FISH")
    .defaultValue(false)
    .versionRange(498, 498, 15, EntityDataTypes.BOOLEAN)
    .versionRange(573, 751, 16, EntityDataTypes.BOOLEAN)
    .versionRange(755, 767, 17, EntityDataTypes.BOOLEAN)
    .versionRange(768, 769, 18, EntityDataTypes.BOOLEAN)
    .versionRange(770, 773, 17, EntityDataTypes.BOOLEAN)
    .versionRange(774, 2147483647, 18, EntityDataTypes.BOOLEAN)
    .build();

    public static final MetaField<Integer> MOISNTESS_LEVEL = MetaField.intBuilder("MOISNTESS_LEVEL")
    .defaultValue(0)
    .versionRange(498, 498, 16, EntityDataTypes.INT)
    .versionRange(573, 2147483647, 17, EntityDataTypes.INT)
    .build();

    public static final MetaField<Integer> MOISTNESS_LEVEL = MetaField.intBuilder("MOISTNESS_LEVEL")
    .defaultValue(0)
    .versionRange(735, 751, 17, EntityDataTypes.INT)
    .versionRange(755, 767, 18, EntityDataTypes.INT)
    .versionRange(768, 769, 19, EntityDataTypes.INT)
    .versionRange(770, 773, 18, EntityDataTypes.INT)
    .versionRange(774, 2147483647, 19, EntityDataTypes.INT)
    .build();

    private DolphinMetaFields() {
    }
}
