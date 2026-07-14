package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Living Block.
 */
public final class LivingBlockMetaFields {
    public static final MetaField<Object> ITEM_STACK = MetaField.builder("ITEM_STACK")
    .versionRange(774, 2147483647, 8, EntityDataTypes.ITEMSTACK)
    .build();

    public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
    .defaultValue(0.0f)
    .versionRange(774, 2147483647, 9, EntityDataTypes.FLOAT)
    .build();

    public static final MetaField<Float> MAX_HEALTH = MetaField.floatBuilder("MAX_HEALTH")
    .defaultValue(0.0f)
    .versionRange(774, 2147483647, 10, EntityDataTypes.FLOAT)
    .build();

    public static final MetaField<Integer> GROUP = MetaField.intBuilder("GROUP")
    .defaultValue(0)
    .versionRange(774, 2147483647, 11, EntityDataTypes.INT)
    .build();

    public static final MetaField<Object> COMMANDER = MetaField.builder("COMMANDER")
    .versionRange(774, 2147483647, 12, EntityDataTypes.INT)
    .build();

    public static final MetaField<Object> OWNER = MetaField.builder("OWNER")
    .versionRange(774, 2147483647, 13, EntityDataTypes.INT)
    .build();

    public static final MetaField<Boolean> PLAYER_INTERACTED = MetaField.booleanBuilder("PLAYER_INTERACTED")
    .defaultValue(false)
    .versionRange(774, 2147483647, 14, EntityDataTypes.BOOLEAN)
    .build();

    public static final MetaField<Boolean> PINNED = MetaField.booleanBuilder("PINNED")
    .defaultValue(false)
    .versionRange(774, 2147483647, 15, EntityDataTypes.BOOLEAN)
    .build();

    public static final MetaField<Boolean> SELECTED = MetaField.booleanBuilder("SELECTED")
    .defaultValue(false)
    .versionRange(774, 2147483647, 16, EntityDataTypes.BOOLEAN)
    .build();

    public static final MetaField<Object> MOVEMENT_DATA = MetaField.builder("MOVEMENT_DATA")
    .versionRange(774, 2147483647, 17, EntityDataTypes.BYTE)
    .build();

    public static final MetaField<Object> MOVEMENT_TARGET = MetaField.builder("MOVEMENT_TARGET")
    .versionRange(774, 2147483647, 18, EntityDataTypes.BYTE)
    .build();

    public static final MetaField<Object> CLIMBING_DIRECTION = MetaField.builder("CLIMBING_DIRECTION")
    .versionRange(774, 2147483647, 19, EntityDataTypes.INT)
    .build();

    private LivingBlockMetaFields() {
    }
}
