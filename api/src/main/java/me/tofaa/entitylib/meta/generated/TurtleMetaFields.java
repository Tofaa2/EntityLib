package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Turtle.
 */
public final class TurtleMetaFields {
    public static final MetaField<Object> HOME_POS = MetaField.builder("HOME_POS")
    .versionRange(498, 498, 15, EntityDataTypes.BLOCK_POSITION)
    .versionRange(573, 751, 16, EntityDataTypes.BLOCK_POSITION)
    .versionRange(755, 2147483647, 17, EntityDataTypes.BLOCK_POSITION)
    .build();

    public static final MetaField<Boolean> HAS_EGG = MetaField.booleanBuilder("HAS_EGG")
    .defaultValue(false)
    .versionRange(498, 498, 16, EntityDataTypes.BOOLEAN)
    .versionRange(573, 751, 17, EntityDataTypes.BOOLEAN)
    .versionRange(755, 769, 18, EntityDataTypes.BOOLEAN)
    .versionRange(770, 773, 17, EntityDataTypes.BOOLEAN)
    .versionRange(774, 2147483647, 18, EntityDataTypes.BOOLEAN)
    .build();

    public static final MetaField<Boolean> LAYING_EGG = MetaField.booleanBuilder("LAYING_EGG")
    .defaultValue(false)
    .versionRange(498, 498, 17, EntityDataTypes.BOOLEAN)
    .versionRange(573, 751, 18, EntityDataTypes.BOOLEAN)
    .versionRange(755, 769, 19, EntityDataTypes.BOOLEAN)
    .versionRange(770, 773, 18, EntityDataTypes.BOOLEAN)
    .versionRange(774, 2147483647, 19, EntityDataTypes.BOOLEAN)
    .build();

    public static final MetaField<Object> TRAVEL_POS = MetaField.builder("TRAVEL_POS")
    .versionRange(498, 498, 18, EntityDataTypes.BLOCK_POSITION)
    .versionRange(573, 751, 19, EntityDataTypes.BLOCK_POSITION)
    .versionRange(755, 2147483647, 20, EntityDataTypes.BLOCK_POSITION)
    .build();

    public static final MetaField<Boolean> GOING_HOME = MetaField.booleanBuilder("GOING_HOME")
    .defaultValue(false)
    .versionRange(498, 498, 19, EntityDataTypes.BOOLEAN)
    .versionRange(573, 751, 20, EntityDataTypes.BOOLEAN)
    .versionRange(755, 2147483647, 21, EntityDataTypes.BOOLEAN)
    .build();

    public static final MetaField<Boolean> TRAVELLING = MetaField.booleanBuilder("TRAVELLING")
    .defaultValue(false)
    .versionRange(498, 498, 20, EntityDataTypes.BOOLEAN)
    .versionRange(573, 751, 21, EntityDataTypes.BOOLEAN)
    .versionRange(755, 2147483647, 22, EntityDataTypes.BOOLEAN)
    .build();

    private TurtleMetaFields() {
    }
}
