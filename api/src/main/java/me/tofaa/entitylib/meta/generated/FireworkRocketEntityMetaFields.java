package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Firework Rocket Entity.
 */
public final class FireworkRocketEntityMetaFields {
    public static final MetaField<Object> FIREWORKS_ITEM = MetaField.builder("FIREWORKS_ITEM")
    .versionRange(498, 751, 7, EntityDataTypes.ITEMSTACK)
    .versionRange(755, 2147483647, 8, EntityDataTypes.ITEMSTACK)
    .build();

    public static final MetaField<Object> ATTACHED_TO_TARGET = MetaField.builder("ATTACHED_TO_TARGET")
    .versionRange(498, 751, 8, EntityDataTypes.OPTIONAL_INT)
    .versionRange(755, 2147483647, 9, EntityDataTypes.OPTIONAL_INT)
    .build();

    public static final MetaField<Boolean> SHOT_AT_ANGLE = MetaField.booleanBuilder("SHOT_AT_ANGLE")
    .defaultValue(false)
    .versionRange(498, 751, 9, EntityDataTypes.BOOLEAN)
    .versionRange(755, 2147483647, 10, EntityDataTypes.BOOLEAN)
    .build();

    private FireworkRocketEntityMetaFields() {
    }
}
