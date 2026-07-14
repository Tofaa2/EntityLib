package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Abstract Boat.
 */
public final class AbstractBoatMetaFields {
    public static final MetaField<Boolean> PADDLE_LEFT = MetaField.booleanBuilder("PADDLE_LEFT")
    .defaultValue(false)
    .versionRange(768, 2147483647, 11, EntityDataTypes.BOOLEAN)
    .build();

    public static final MetaField<Boolean> PADDLE_RIGHT = MetaField.booleanBuilder("PADDLE_RIGHT")
    .defaultValue(false)
    .versionRange(768, 2147483647, 12, EntityDataTypes.BOOLEAN)
    .build();

    public static final MetaField<Integer> BUBBLE_TIME = MetaField.intBuilder("BUBBLE_TIME")
    .defaultValue(0)
    .versionRange(768, 2147483647, 13, EntityDataTypes.INT)
    .build();

    private AbstractBoatMetaFields() {
    }
}
