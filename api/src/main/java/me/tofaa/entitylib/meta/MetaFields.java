package me.tofaa.entitylib.meta;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;

/**
 * Generated meta field constants organized by entity type.
 */
public final class MetaFields {
    private MetaFields() {
    }

    /**
     * Meta field constants for Entity.
     */
    public static final class Entity {
        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Entity() {
        }
    }

    /**
     * Meta field constants for Abstract Arrow.
     */
    public static final class AbstractArrow {
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

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private AbstractArrow() {
        }
    }

    /**
     * Meta field constants for Abstract Minecart.
     */
    public static final class AbstractMinecart {
        public static final MetaField<Integer> HURT = MetaField.intBuilder("HURT")
        .defaultValue(0)
        .versionRange(498, 751, 7, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 8, EntityDataTypes.INT)
        .build();

        public static final MetaField<Integer> HURTDIR = MetaField.intBuilder("HURTDIR")
        .defaultValue(0)
        .versionRange(498, 751, 8, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.INT)
        .build();

        public static final MetaField<Float> DAMAGE = MetaField.floatBuilder("DAMAGE")
        .defaultValue(0.0f)
        .versionRange(498, 751, 9, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> DISPLAY_BLOCK = MetaField.intBuilder("DISPLAY_BLOCK")
        .defaultValue(0)
        .versionRange(498, 751, 10, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 11, EntityDataTypes.INT)
        .build();

        public static final MetaField<Integer> DISPLAY_OFFSET = MetaField.intBuilder("DISPLAY_OFFSET")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> CUSTOM_DISPLAY = MetaField.booleanBuilder("CUSTOM_DISPLAY")
        .defaultValue(false)
        .versionRange(498, 751, 12, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 13, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> CUSTOM_DISPLAY_BLOCK = MetaField.builder("CUSTOM_DISPLAY_BLOCK")
        .versionRange(770, 2147483647, 11, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private AbstractMinecart() {
        }
    }

    /**
     * Meta field constants for Area Effect Cloud.
     */
    public static final class AreaEffectCloud {
        public static final MetaField<Float> RADIUS = MetaField.floatBuilder("RADIUS")
        .defaultValue(0.0f)
        .versionRange(498, 751, 7, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 8, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> COLOR = MetaField.intBuilder("COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 8, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> WAITING = MetaField.booleanBuilder("WAITING")
        .defaultValue(false)
        .versionRange(498, 751, 9, EntityDataTypes.BOOLEAN)
        .versionRange(755, 765, 10, EntityDataTypes.BOOLEAN)
        .versionRange(766, 2147483647, 9, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> PARTICLE = MetaField.builder("PARTICLE")
        .versionRange(498, 751, 10, EntityDataTypes.INT)
        .versionRange(755, 765, 11, EntityDataTypes.INT)
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private AreaEffectCloud() {
        }
    }

    /**
     * Meta field constants for Boat.
     */
    public static final class Boat {
        public static final MetaField<Integer> HURT = MetaField.intBuilder("HURT")
        .defaultValue(0)
        .versionRange(498, 751, 7, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 8, EntityDataTypes.INT)
        .build();

        public static final MetaField<Integer> HURTDIR = MetaField.intBuilder("HURTDIR")
        .defaultValue(0)
        .versionRange(498, 751, 8, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.INT)
        .build();

        public static final MetaField<Float> DAMAGE = MetaField.floatBuilder("DAMAGE")
        .defaultValue(0.0f)
        .versionRange(498, 751, 9, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> TYPE = MetaField.intBuilder("TYPE")
        .defaultValue(0)
        .versionRange(498, 751, 10, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 11, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> PADDLE_LEFT = MetaField.booleanBuilder("PADDLE_LEFT")
        .defaultValue(false)
        .versionRange(498, 751, 11, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 12, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> PADDLE_RIGHT = MetaField.booleanBuilder("PADDLE_RIGHT")
        .defaultValue(false)
        .versionRange(498, 751, 12, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 13, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> BUBBLE_TIME = MetaField.intBuilder("BUBBLE_TIME")
        .defaultValue(0)
        .versionRange(498, 751, 13, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 14, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Boat() {
        }
    }

    /**
     * Meta field constants for End Crystal.
     */
    public static final class EndCrystal {
        public static final MetaField<Object> BEAM_TARGET = MetaField.builder("BEAM_TARGET")
        .versionRange(498, 751, 7, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 8, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Boolean> SHOW_BOTTOM = MetaField.booleanBuilder("SHOW_BOTTOM")
        .defaultValue(false)
        .versionRange(498, 751, 8, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 9, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private EndCrystal() {
        }
    }

    /**
     * Meta field constants for Eye Of Ender.
     */
    public static final class EyeOfEnder {
        public static final MetaField<Object> ITEM_STACK = MetaField.builder("ITEM_STACK")
        .versionRange(498, 751, 7, EntityDataTypes.ITEMSTACK)
        .versionRange(755, 2147483647, 8, EntityDataTypes.ITEMSTACK)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private EyeOfEnder() {
        }
    }

    /**
     * Meta field constants for Falling Block Entity.
     */
    public static final class FallingBlockEntity {
        public static final MetaField<Object> START_POS = MetaField.builder("START_POS")
        .versionRange(498, 751, 7, EntityDataTypes.BLOCK_POSITION)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BLOCK_POSITION)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private FallingBlockEntity() {
        }
    }

    /**
     * Meta field constants for Firework Rocket Entity.
     */
    public static final class FireworkRocketEntity {
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

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private FireworkRocketEntity() {
        }
    }

    /**
     * Meta field constants for Fishing Hook.
     */
    public static final class FishingHook {
        public static final MetaField<Integer> HOOKED_ENTITY = MetaField.intBuilder("HOOKED_ENTITY")
        .defaultValue(0)
        .versionRange(498, 751, 7, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 8, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> BITING = MetaField.booleanBuilder("BITING")
        .defaultValue(false)
        .versionRange(735, 751, 8, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 9, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private FishingHook() {
        }
    }

    /**
     * Meta field constants for Item Entity.
     */
    public static final class ItemEntity {
        public static final MetaField<Object> ITEM = MetaField.builder("ITEM")
        .versionRange(498, 751, 7, EntityDataTypes.ITEMSTACK)
        .versionRange(755, 2147483647, 8, EntityDataTypes.ITEMSTACK)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private ItemEntity() {
        }
    }

    /**
     * Meta field constants for Living Entity.
     */
    public static final class LivingEntity {
        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private LivingEntity() {
        }
    }

    /**
     * Meta field constants for Primed Tnt.
     */
    public static final class PrimedTnt {
        public static final MetaField<Integer> FUSE = MetaField.intBuilder("FUSE")
        .defaultValue(0)
        .versionRange(498, 751, 7, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 8, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> BLOCK_STATE = MetaField.builder("BLOCK_STATE")
        .versionRange(765, 2147483647, 9, EntityDataTypes.BLOCK_STATE)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private PrimedTnt() {
        }
    }

    /**
     * Meta field constants for Armor Stand.
     */
    public static final class ArmorStand {
        public static final MetaField<Byte> CLIENT_FLAGS = MetaField.byteBuilder("CLIENT_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Object> HEAD_POSE = MetaField.builder("HEAD_POSE")
        .versionRange(498, 498, 14, EntityDataTypes.ROTATION)
        .versionRange(573, 751, 15, EntityDataTypes.ROTATION)
        .versionRange(755, 2147483647, 16, EntityDataTypes.ROTATION)
        .build();

        public static final MetaField<Object> BODY_POSE = MetaField.builder("BODY_POSE")
        .versionRange(498, 498, 15, EntityDataTypes.ROTATION)
        .versionRange(573, 751, 16, EntityDataTypes.ROTATION)
        .versionRange(755, 2147483647, 17, EntityDataTypes.ROTATION)
        .build();

        public static final MetaField<Object> LEFT_ARM_POSE = MetaField.builder("LEFT_ARM_POSE")
        .versionRange(498, 498, 16, EntityDataTypes.ROTATION)
        .versionRange(573, 751, 17, EntityDataTypes.ROTATION)
        .versionRange(755, 2147483647, 18, EntityDataTypes.ROTATION)
        .build();

        public static final MetaField<Object> RIGHT_ARM_POSE = MetaField.builder("RIGHT_ARM_POSE")
        .versionRange(498, 498, 17, EntityDataTypes.ROTATION)
        .versionRange(573, 751, 18, EntityDataTypes.ROTATION)
        .versionRange(755, 2147483647, 19, EntityDataTypes.ROTATION)
        .build();

        public static final MetaField<Object> LEFT_LEG_POSE = MetaField.builder("LEFT_LEG_POSE")
        .versionRange(498, 498, 18, EntityDataTypes.ROTATION)
        .versionRange(573, 751, 19, EntityDataTypes.ROTATION)
        .versionRange(755, 2147483647, 20, EntityDataTypes.ROTATION)
        .build();

        public static final MetaField<Object> RIGHT_LEG_POSE = MetaField.builder("RIGHT_LEG_POSE")
        .versionRange(498, 498, 19, EntityDataTypes.ROTATION)
        .versionRange(573, 751, 20, EntityDataTypes.ROTATION)
        .versionRange(755, 2147483647, 21, EntityDataTypes.ROTATION)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private ArmorStand() {
        }
    }

    /**
     * Meta field constants for Arrow.
     */
    public static final class Arrow {
        public static final MetaField<Integer> ID_EFFECT_COLOR = MetaField.intBuilder("ID_EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 573, 10, EntityDataTypes.INT)
        .versionRange(735, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 767, 10, EntityDataTypes.INT)
        .versionRange(768, 2147483647, 11, EntityDataTypes.INT)
        .build();

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

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Arrow() {
        }
    }

    /**
     * Meta field constants for Fireball.
     */
    public static final class Fireball {
        public static final MetaField<Object> ITEM_STACK = MetaField.builder("ITEM_STACK")
        .versionRange(498, 751, 7, EntityDataTypes.ITEMSTACK)
        .versionRange(755, 2147483647, 8, EntityDataTypes.ITEMSTACK)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Fireball() {
        }
    }

    /**
     * Meta field constants for Item Frame.
     */
    public static final class ItemFrame {
        public static final MetaField<Object> ITEM = MetaField.builder("ITEM")
        .versionRange(498, 751, 7, EntityDataTypes.ITEMSTACK)
        .versionRange(755, 770, 8, EntityDataTypes.ITEMSTACK)
        .versionRange(771, 2147483647, 9, EntityDataTypes.ITEMSTACK)
        .build();

        public static final MetaField<Integer> ROTATION = MetaField.intBuilder("ROTATION")
        .defaultValue(0)
        .versionRange(498, 751, 8, EntityDataTypes.INT)
        .versionRange(755, 770, 9, EntityDataTypes.INT)
        .versionRange(771, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> DIRECTION = MetaField.builder("DIRECTION")
        .versionRange(771, 2147483647, 8, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private ItemFrame() {
        }
    }

    /**
     * Meta field constants for Minecart Command Block.
     */
    public static final class MinecartCommandBlock {
        public static final MetaField<String> COMMAND_NAME = MetaField.stringBuilder("COMMAND_NAME")
        .defaultValue("")
        .versionRange(498, 751, 13, EntityDataTypes.STRING)
        .versionRange(755, 769, 14, EntityDataTypes.STRING)
        .versionRange(770, 2147483647, 13, EntityDataTypes.STRING)
        .build();

        public static final MetaField<Object> LAST_OUTPUT = MetaField.builder("LAST_OUTPUT")
        .versionRange(498, 751, 14, EntityDataTypes.ADV_COMPONENT)
        .versionRange(755, 769, 15, EntityDataTypes.ADV_COMPONENT)
        .versionRange(770, 2147483647, 14, EntityDataTypes.ADV_COMPONENT)
        .build();

        public static final MetaField<Integer> HURT = MetaField.intBuilder("HURT")
        .defaultValue(0)
        .versionRange(498, 751, 7, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 8, EntityDataTypes.INT)
        .build();

        public static final MetaField<Integer> HURTDIR = MetaField.intBuilder("HURTDIR")
        .defaultValue(0)
        .versionRange(498, 751, 8, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.INT)
        .build();

        public static final MetaField<Float> DAMAGE = MetaField.floatBuilder("DAMAGE")
        .defaultValue(0.0f)
        .versionRange(498, 751, 9, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> DISPLAY_BLOCK = MetaField.intBuilder("DISPLAY_BLOCK")
        .defaultValue(0)
        .versionRange(498, 751, 10, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 11, EntityDataTypes.INT)
        .build();

        public static final MetaField<Integer> DISPLAY_OFFSET = MetaField.intBuilder("DISPLAY_OFFSET")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> CUSTOM_DISPLAY = MetaField.booleanBuilder("CUSTOM_DISPLAY")
        .defaultValue(false)
        .versionRange(498, 751, 12, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 13, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> CUSTOM_DISPLAY_BLOCK = MetaField.builder("CUSTOM_DISPLAY_BLOCK")
        .versionRange(770, 2147483647, 11, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private MinecartCommandBlock() {
        }
    }

    /**
     * Meta field constants for Minecart Furnace.
     */
    public static final class MinecartFurnace {
        public static final MetaField<Boolean> FUEL = MetaField.booleanBuilder("FUEL")
        .defaultValue(false)
        .versionRange(498, 751, 13, EntityDataTypes.BOOLEAN)
        .versionRange(755, 769, 14, EntityDataTypes.BOOLEAN)
        .versionRange(770, 2147483647, 13, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> HURT = MetaField.intBuilder("HURT")
        .defaultValue(0)
        .versionRange(498, 751, 7, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 8, EntityDataTypes.INT)
        .build();

        public static final MetaField<Integer> HURTDIR = MetaField.intBuilder("HURTDIR")
        .defaultValue(0)
        .versionRange(498, 751, 8, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.INT)
        .build();

        public static final MetaField<Float> DAMAGE = MetaField.floatBuilder("DAMAGE")
        .defaultValue(0.0f)
        .versionRange(498, 751, 9, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> DISPLAY_BLOCK = MetaField.intBuilder("DISPLAY_BLOCK")
        .defaultValue(0)
        .versionRange(498, 751, 10, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 11, EntityDataTypes.INT)
        .build();

        public static final MetaField<Integer> DISPLAY_OFFSET = MetaField.intBuilder("DISPLAY_OFFSET")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> CUSTOM_DISPLAY = MetaField.booleanBuilder("CUSTOM_DISPLAY")
        .defaultValue(false)
        .versionRange(498, 751, 12, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 13, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> CUSTOM_DISPLAY_BLOCK = MetaField.builder("CUSTOM_DISPLAY_BLOCK")
        .versionRange(770, 2147483647, 11, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private MinecartFurnace() {
        }
    }

    /**
     * Meta field constants for Mob.
     */
    public static final class Mob {
        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Mob() {
        }
    }

    /**
     * Meta field constants for Player.
     */
    public static final class Player {
        public static final MetaField<Float> PLAYER_ABSORPTION = MetaField.floatBuilder("PLAYER_ABSORPTION")
        .defaultValue(0.0f)
        .versionRange(498, 498, 13, EntityDataTypes.FLOAT)
        .versionRange(573, 751, 14, EntityDataTypes.FLOAT)
        .versionRange(755, 771, 15, EntityDataTypes.FLOAT)
        .versionRange(772, 2147483647, 17, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> SCORE = MetaField.intBuilder("SCORE")
        .defaultValue(0)
        .versionRange(498, 498, 14, EntityDataTypes.INT)
        .versionRange(573, 751, 15, EntityDataTypes.INT)
        .versionRange(755, 771, 16, EntityDataTypes.INT)
        .versionRange(772, 2147483647, 18, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> PLAYER_MODE_CUSTOMISATION = MetaField.byteBuilder("PLAYER_MODE_CUSTOMISATION")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 15, EntityDataTypes.BYTE)
        .versionRange(573, 751, 16, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 17, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> PLAYER_MAIN_HAND = MetaField.byteBuilder("PLAYER_MAIN_HAND")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 16, EntityDataTypes.BYTE)
        .versionRange(573, 751, 17, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 18, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Object> SHOULDER_LEFT = MetaField.builder("SHOULDER_LEFT")
        .versionRange(498, 498, 17, EntityDataTypes.NBT)
        .versionRange(573, 751, 18, EntityDataTypes.NBT)
        .versionRange(755, 2147483647, 19, EntityDataTypes.NBT)
        .build();

        public static final MetaField<Object> SHOULDER_RIGHT = MetaField.builder("SHOULDER_RIGHT")
        .versionRange(498, 498, 18, EntityDataTypes.NBT)
        .versionRange(573, 751, 19, EntityDataTypes.NBT)
        .versionRange(755, 2147483647, 20, EntityDataTypes.NBT)
        .build();

        public static final MetaField<Object> SHOULDER_PARROT_LEFT = MetaField.builder("SHOULDER_PARROT_LEFT")
        .versionRange(772, 773, 19, EntityDataTypes.OPTIONAL_INT)
        .versionRange(774, 774, 20, EntityDataTypes.OPTIONAL_INT)
        .versionRange(775, 2147483647, 19, EntityDataTypes.OPTIONAL_INT)
        .build();

        public static final MetaField<Object> SHOULDER_PARROT_RIGHT = MetaField.builder("SHOULDER_PARROT_RIGHT")
        .versionRange(772, 773, 20, EntityDataTypes.OPTIONAL_INT)
        .versionRange(774, 774, 21, EntityDataTypes.OPTIONAL_INT)
        .versionRange(775, 2147483647, 20, EntityDataTypes.OPTIONAL_INT)
        .build();

        public static final MetaField<Integer> SELECTED_GROUP = MetaField.intBuilder("SELECTED_GROUP")
        .defaultValue(0)
        .versionRange(774, 2147483647, 19, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Player() {
        }
    }

    /**
     * Meta field constants for Throwable Item Projectile.
     */
    public static final class ThrowableItemProjectile {
        public static final MetaField<Object> ITEM_STACK = MetaField.builder("ITEM_STACK")
        .versionRange(498, 751, 7, EntityDataTypes.ITEMSTACK)
        .versionRange(755, 2147483647, 8, EntityDataTypes.ITEMSTACK)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private ThrowableItemProjectile() {
        }
    }

    /**
     * Meta field constants for Thrown Potion.
     */
    public static final class ThrownPotion {
        public static final MetaField<Object> ITEM_STACK = MetaField.builder("ITEM_STACK")
        .versionRange(498, 2147483647, 7, EntityDataTypes.ITEMSTACK)
        .build();

        private ThrownPotion() {
        }
    }

    /**
     * Meta field constants for Thrown Trident.
     */
    public static final class ThrownTrident {
        public static final MetaField<Byte> ID_LOYALTY = MetaField.byteBuilder("ID_LOYALTY")
        .defaultValue((byte) 0)
        .versionRange(498, 573, 10, EntityDataTypes.BYTE)
        .versionRange(735, 751, 9, EntityDataTypes.BYTE)
        .versionRange(755, 767, 10, EntityDataTypes.BYTE)
        .versionRange(768, 2147483647, 11, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Boolean> ID_FOIL = MetaField.booleanBuilder("ID_FOIL")
        .defaultValue(false)
        .versionRange(573, 573, 11, EntityDataTypes.BOOLEAN)
        .versionRange(735, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 767, 11, EntityDataTypes.BOOLEAN)
        .versionRange(768, 2147483647, 12, EntityDataTypes.BOOLEAN)
        .build();

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

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private ThrownTrident() {
        }
    }

    /**
     * Meta field constants for Wither Skull.
     */
    public static final class WitherSkull {
        public static final MetaField<Boolean> DANGEROUS = MetaField.booleanBuilder("DANGEROUS")
        .defaultValue(false)
        .versionRange(498, 751, 7, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private WitherSkull() {
        }
    }

    /**
     * Meta field constants for Ender Dragon.
     */
    public static final class EnderDragon {
        public static final MetaField<Integer> PHASE = MetaField.intBuilder("PHASE")
        .defaultValue(0)
        .versionRange(498, 498, 14, EntityDataTypes.INT)
        .versionRange(573, 751, 15, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 16, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private EnderDragon() {
        }
    }

    /**
     * Meta field constants for Slime.
     */
    public static final class Slime {
        public static final MetaField<Integer> ID_SIZE = MetaField.intBuilder("ID_SIZE")
        .defaultValue(0)
        .versionRange(498, 498, 14, EntityDataTypes.INT)
        .versionRange(573, 751, 15, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 16, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> BABY = MetaField.booleanBuilder("BABY")
        .defaultValue(false)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> AGE_LOCKED = MetaField.booleanBuilder("AGE_LOCKED")
        .defaultValue(false)
        .versionRange(774, 2147483647, 17, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Slime() {
        }
    }

    /**
     * Meta field constants for Agable Mob.
     */
    public static final class AgableMob {
        public static final MetaField<Boolean> BABY = MetaField.booleanBuilder("BABY")
        .defaultValue(false)
        .versionRange(498, 498, 14, EntityDataTypes.BOOLEAN)
        .versionRange(573, 2147483647, 15, EntityDataTypes.BOOLEAN)
        .build();

        private AgableMob() {
        }
    }

    /**
     * Meta field constants for Bat.
     */
    public static final class Bat {
        public static final MetaField<Byte> FLAGS = MetaField.byteBuilder("FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 14, EntityDataTypes.BYTE)
        .versionRange(573, 751, 15, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Bat() {
        }
    }

    /**
     * Meta field constants for Ghast.
     */
    public static final class Ghast {
        public static final MetaField<Boolean> IS_CHARGING = MetaField.booleanBuilder("IS_CHARGING")
        .defaultValue(false)
        .versionRange(498, 498, 14, EntityDataTypes.BOOLEAN)
        .versionRange(573, 751, 15, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Ghast() {
        }
    }

    /**
     * Meta field constants for Phantom.
     */
    public static final class Phantom {
        public static final MetaField<Integer> ID_SIZE = MetaField.intBuilder("ID_SIZE")
        .defaultValue(0)
        .versionRange(498, 498, 14, EntityDataTypes.INT)
        .versionRange(573, 751, 15, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 16, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Phantom() {
        }
    }

    /**
     * Meta field constants for Abstract Fish.
     */
    public static final class AbstractFish {
        public static final MetaField<Boolean> FROM_BUCKET = MetaField.booleanBuilder("FROM_BUCKET")
        .defaultValue(false)
        .versionRange(498, 498, 14, EntityDataTypes.BOOLEAN)
        .versionRange(573, 751, 15, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private AbstractFish() {
        }
    }

    /**
     * Meta field constants for Abstract Villager.
     */
    public static final class AbstractVillager {
        public static final MetaField<Integer> UNHAPPY_COUNTER = MetaField.intBuilder("UNHAPPY_COUNTER")
        .defaultValue(0)
        .versionRange(498, 498, 15, EntityDataTypes.INT)
        .versionRange(573, 751, 16, EntityDataTypes.INT)
        .versionRange(755, 773, 17, EntityDataTypes.INT)
        .versionRange(774, 2147483647, 18, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> BABY = MetaField.booleanBuilder("BABY")
        .defaultValue(false)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> AGE_LOCKED = MetaField.booleanBuilder("AGE_LOCKED")
        .defaultValue(false)
        .versionRange(774, 2147483647, 17, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private AbstractVillager() {
        }
    }

    /**
     * Meta field constants for Blaze.
     */
    public static final class Blaze {
        public static final MetaField<Byte> FLAGS = MetaField.byteBuilder("FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 14, EntityDataTypes.BYTE)
        .versionRange(573, 751, 15, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Blaze() {
        }
    }

    /**
     * Meta field constants for Creeper.
     */
    public static final class Creeper {
        public static final MetaField<Integer> SWELL_DIR = MetaField.intBuilder("SWELL_DIR")
        .defaultValue(0)
        .versionRange(498, 498, 14, EntityDataTypes.INT)
        .versionRange(573, 751, 15, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 16, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> IS_POWERED = MetaField.booleanBuilder("IS_POWERED")
        .defaultValue(false)
        .versionRange(498, 498, 15, EntityDataTypes.BOOLEAN)
        .versionRange(573, 751, 16, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 17, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> IS_IGNITED = MetaField.booleanBuilder("IS_IGNITED")
        .defaultValue(false)
        .versionRange(498, 498, 16, EntityDataTypes.BOOLEAN)
        .versionRange(573, 751, 17, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 18, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Creeper() {
        }
    }

    /**
     * Meta field constants for Dolphin.
     */
    public static final class Dolphin {
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

        public static final MetaField<Boolean> BABY = MetaField.booleanBuilder("BABY")
        .defaultValue(false)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> AGE_LOCKED = MetaField.booleanBuilder("AGE_LOCKED")
        .defaultValue(false)
        .versionRange(774, 2147483647, 17, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Dolphin() {
        }
    }

    /**
     * Meta field constants for Ender Man.
     */
    public static final class EnderMan {
        public static final MetaField<Object> CARRY_STATE = MetaField.builder("CARRY_STATE")
        .versionRange(498, 498, 14, EntityDataTypes.INT)
        .versionRange(573, 751, 15, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 16, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> CREEPY = MetaField.booleanBuilder("CREEPY")
        .defaultValue(false)
        .versionRange(498, 498, 15, EntityDataTypes.BOOLEAN)
        .versionRange(573, 751, 16, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 17, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> STARED_AT = MetaField.booleanBuilder("STARED_AT")
        .defaultValue(false)
        .versionRange(573, 751, 17, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 18, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private EnderMan() {
        }
    }

    /**
     * Meta field constants for Guardian.
     */
    public static final class Guardian {
        public static final MetaField<Boolean> MOVING = MetaField.booleanBuilder("MOVING")
        .defaultValue(false)
        .versionRange(498, 498, 14, EntityDataTypes.BOOLEAN)
        .versionRange(573, 751, 15, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ATTACK_TARGET = MetaField.intBuilder("ATTACK_TARGET")
        .defaultValue(0)
        .versionRange(498, 498, 15, EntityDataTypes.INT)
        .versionRange(573, 751, 16, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 17, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Guardian() {
        }
    }

    /**
     * Meta field constants for Iron Golem.
     */
    public static final class IronGolem {
        public static final MetaField<Byte> FLAGS = MetaField.byteBuilder("FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 14, EntityDataTypes.BYTE)
        .versionRange(573, 751, 15, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private IronGolem() {
        }
    }

    /**
     * Meta field constants for Shulker.
     */
    public static final class Shulker {
        public static final MetaField<Object> ATTACH_FACE = MetaField.builder("ATTACH_FACE")
        .versionRange(498, 498, 14, EntityDataTypes.INT)
        .versionRange(573, 751, 15, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 16, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> ATTACH_POS = MetaField.builder("ATTACH_POS")
        .versionRange(498, 498, 15, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 2147483647, 16, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Byte> PEEK = MetaField.byteBuilder("PEEK")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 16, EntityDataTypes.BYTE)
        .versionRange(573, 2147483647, 17, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> COLOR = MetaField.byteBuilder("COLOR")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 17, EntityDataTypes.BYTE)
        .versionRange(573, 2147483647, 18, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Shulker() {
        }
    }

    /**
     * Meta field constants for Snow Golem.
     */
    public static final class SnowGolem {
        public static final MetaField<Byte> PUMPKIN = MetaField.byteBuilder("PUMPKIN")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 14, EntityDataTypes.BYTE)
        .versionRange(573, 751, 15, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private SnowGolem() {
        }
    }

    /**
     * Meta field constants for Spider.
     */
    public static final class Spider {
        public static final MetaField<Byte> FLAGS = MetaField.byteBuilder("FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 14, EntityDataTypes.BYTE)
        .versionRange(573, 751, 15, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Spider() {
        }
    }

    /**
     * Meta field constants for Vex.
     */
    public static final class Vex {
        public static final MetaField<Byte> FLAGS = MetaField.byteBuilder("FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 14, EntityDataTypes.BYTE)
        .versionRange(573, 751, 15, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Vex() {
        }
    }

    /**
     * Meta field constants for Wither Boss.
     */
    public static final class WitherBoss {
        public static final MetaField<Integer> TARGET_A = MetaField.intBuilder("TARGET_A")
        .defaultValue(0)
        .versionRange(498, 498, 14, EntityDataTypes.INT)
        .versionRange(573, 751, 15, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 16, EntityDataTypes.INT)
        .build();

        public static final MetaField<Integer> TARGET_B = MetaField.intBuilder("TARGET_B")
        .defaultValue(0)
        .versionRange(498, 498, 15, EntityDataTypes.INT)
        .versionRange(573, 751, 16, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 17, EntityDataTypes.INT)
        .build();

        public static final MetaField<Integer> TARGET_C = MetaField.intBuilder("TARGET_C")
        .defaultValue(0)
        .versionRange(498, 498, 16, EntityDataTypes.INT)
        .versionRange(573, 751, 17, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 18, EntityDataTypes.INT)
        .build();

        public static final MetaField<Integer> INV = MetaField.intBuilder("INV")
        .defaultValue(0)
        .versionRange(498, 498, 17, EntityDataTypes.INT)
        .versionRange(573, 751, 18, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 19, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private WitherBoss() {
        }
    }

    /**
     * Meta field constants for Zombie.
     */
    public static final class Zombie {
        public static final MetaField<Boolean> BABY = MetaField.booleanBuilder("BABY")
        .defaultValue(false)
        .versionRange(498, 498, 14, EntityDataTypes.BOOLEAN)
        .versionRange(573, 751, 15, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> SPECIAL_TYPE = MetaField.intBuilder("SPECIAL_TYPE")
        .defaultValue(0)
        .versionRange(498, 498, 15, EntityDataTypes.INT)
        .versionRange(573, 751, 16, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 17, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> DROWNED_CONVERSION = MetaField.booleanBuilder("DROWNED_CONVERSION")
        .defaultValue(false)
        .versionRange(498, 498, 16, EntityDataTypes.BOOLEAN)
        .versionRange(573, 751, 17, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 18, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Zombie() {
        }
    }

    /**
     * Meta field constants for Abstract Horse.
     */
    public static final class AbstractHorse {
        public static final MetaField<Byte> FLAGS = MetaField.byteBuilder("FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 15, EntityDataTypes.BYTE)
        .versionRange(573, 751, 16, EntityDataTypes.BYTE)
        .versionRange(755, 773, 17, EntityDataTypes.BYTE)
        .versionRange(774, 2147483647, 18, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Object> OWNER_UUID = MetaField.builder("OWNER_UUID")
        .versionRange(498, 498, 16, EntityDataTypes.OPTIONAL_UUID)
        .versionRange(573, 751, 17, EntityDataTypes.OPTIONAL_UUID)
        .versionRange(755, 2147483647, 18, EntityDataTypes.OPTIONAL_UUID)
        .build();

        public static final MetaField<Boolean> BABY = MetaField.booleanBuilder("BABY")
        .defaultValue(false)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> AGE_LOCKED = MetaField.booleanBuilder("AGE_LOCKED")
        .defaultValue(false)
        .versionRange(774, 2147483647, 17, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private AbstractHorse() {
        }
    }

    /**
     * Meta field constants for Fox.
     */
    public static final class Fox {
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

        public static final MetaField<Boolean> BABY = MetaField.booleanBuilder("BABY")
        .defaultValue(false)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> AGE_LOCKED = MetaField.booleanBuilder("AGE_LOCKED")
        .defaultValue(false)
        .versionRange(774, 2147483647, 17, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Fox() {
        }
    }

    /**
     * Meta field constants for Ocelot.
     */
    public static final class Ocelot {
        public static final MetaField<Boolean> TRUSTING = MetaField.booleanBuilder("TRUSTING")
        .defaultValue(false)
        .versionRange(498, 498, 15, EntityDataTypes.BOOLEAN)
        .versionRange(573, 751, 16, EntityDataTypes.BOOLEAN)
        .versionRange(755, 773, 17, EntityDataTypes.BOOLEAN)
        .versionRange(774, 2147483647, 18, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> BABY = MetaField.booleanBuilder("BABY")
        .defaultValue(false)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> AGE_LOCKED = MetaField.booleanBuilder("AGE_LOCKED")
        .defaultValue(false)
        .versionRange(774, 2147483647, 17, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Ocelot() {
        }
    }

    /**
     * Meta field constants for Panda.
     */
    public static final class Panda {
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

        public static final MetaField<Boolean> BABY = MetaField.booleanBuilder("BABY")
        .defaultValue(false)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> AGE_LOCKED = MetaField.booleanBuilder("AGE_LOCKED")
        .defaultValue(false)
        .versionRange(774, 2147483647, 17, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Panda() {
        }
    }

    /**
     * Meta field constants for Pig.
     */
    public static final class Pig {
        public static final MetaField<Boolean> SADDLE = MetaField.booleanBuilder("SADDLE")
        .defaultValue(false)
        .versionRange(498, 498, 15, EntityDataTypes.BOOLEAN)
        .versionRange(573, 751, 16, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 17, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> BOOST_TIME = MetaField.intBuilder("BOOST_TIME")
        .defaultValue(0)
        .versionRange(498, 498, 16, EntityDataTypes.INT)
        .versionRange(573, 751, 17, EntityDataTypes.INT)
        .versionRange(755, 769, 18, EntityDataTypes.INT)
        .versionRange(770, 773, 17, EntityDataTypes.INT)
        .versionRange(774, 2147483647, 18, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> VARIANT = MetaField.builder("VARIANT")
        .versionRange(770, 773, 18, EntityDataTypes.INT)
        .versionRange(774, 2147483647, 19, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SOUND_VARIANT = MetaField.builder("SOUND_VARIANT")
        .versionRange(774, 2147483647, 20, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> BABY = MetaField.booleanBuilder("BABY")
        .defaultValue(false)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> AGE_LOCKED = MetaField.booleanBuilder("AGE_LOCKED")
        .defaultValue(false)
        .versionRange(774, 2147483647, 17, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Pig() {
        }
    }

    /**
     * Meta field constants for Polar Bear.
     */
    public static final class PolarBear {
        public static final MetaField<Boolean> STANDING = MetaField.booleanBuilder("STANDING")
        .defaultValue(false)
        .versionRange(498, 498, 15, EntityDataTypes.BOOLEAN)
        .versionRange(573, 751, 16, EntityDataTypes.BOOLEAN)
        .versionRange(755, 773, 17, EntityDataTypes.BOOLEAN)
        .versionRange(774, 2147483647, 18, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> BABY = MetaField.booleanBuilder("BABY")
        .defaultValue(false)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> AGE_LOCKED = MetaField.booleanBuilder("AGE_LOCKED")
        .defaultValue(false)
        .versionRange(774, 2147483647, 17, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private PolarBear() {
        }
    }

    /**
     * Meta field constants for Pufferfish.
     */
    public static final class Pufferfish {
        public static final MetaField<Integer> PUFF_STATE = MetaField.intBuilder("PUFF_STATE")
        .defaultValue(0)
        .versionRange(498, 498, 15, EntityDataTypes.INT)
        .versionRange(573, 751, 16, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 17, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> FROM_BUCKET = MetaField.booleanBuilder("FROM_BUCKET")
        .defaultValue(false)
        .versionRange(498, 498, 14, EntityDataTypes.BOOLEAN)
        .versionRange(573, 751, 15, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Pufferfish() {
        }
    }

    /**
     * Meta field constants for Rabbit.
     */
    public static final class Rabbit {
        public static final MetaField<Integer> TYPE = MetaField.intBuilder("TYPE")
        .defaultValue(0)
        .versionRange(498, 498, 15, EntityDataTypes.INT)
        .versionRange(573, 751, 16, EntityDataTypes.INT)
        .versionRange(755, 773, 17, EntityDataTypes.INT)
        .versionRange(774, 2147483647, 18, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> BABY = MetaField.booleanBuilder("BABY")
        .defaultValue(false)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> AGE_LOCKED = MetaField.booleanBuilder("AGE_LOCKED")
        .defaultValue(false)
        .versionRange(774, 2147483647, 17, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Rabbit() {
        }
    }

    /**
     * Meta field constants for Raider.
     */
    public static final class Raider {
        public static final MetaField<Boolean> IS_CELEBRATING = MetaField.booleanBuilder("IS_CELEBRATING")
        .defaultValue(false)
        .versionRange(498, 498, 14, EntityDataTypes.BOOLEAN)
        .versionRange(573, 751, 15, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Raider() {
        }
    }

    /**
     * Meta field constants for Sheep.
     */
    public static final class Sheep {
        public static final MetaField<Byte> WOOL = MetaField.byteBuilder("WOOL")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 15, EntityDataTypes.BYTE)
        .versionRange(573, 751, 16, EntityDataTypes.BYTE)
        .versionRange(755, 773, 17, EntityDataTypes.BYTE)
        .versionRange(774, 2147483647, 18, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Boolean> BABY = MetaField.booleanBuilder("BABY")
        .defaultValue(false)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> AGE_LOCKED = MetaField.booleanBuilder("AGE_LOCKED")
        .defaultValue(false)
        .versionRange(774, 2147483647, 17, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Sheep() {
        }
    }

    /**
     * Meta field constants for Tamable Animal.
     */
    public static final class TamableAnimal {
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

        public static final MetaField<Boolean> BABY = MetaField.booleanBuilder("BABY")
        .defaultValue(false)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> AGE_LOCKED = MetaField.booleanBuilder("AGE_LOCKED")
        .defaultValue(false)
        .versionRange(774, 2147483647, 17, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private TamableAnimal() {
        }
    }

    /**
     * Meta field constants for Turtle.
     */
    public static final class Turtle {
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

        public static final MetaField<Boolean> BABY = MetaField.booleanBuilder("BABY")
        .defaultValue(false)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> AGE_LOCKED = MetaField.booleanBuilder("AGE_LOCKED")
        .defaultValue(false)
        .versionRange(774, 2147483647, 17, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Turtle() {
        }
    }

    /**
     * Meta field constants for Villager.
     */
    public static final class Villager {
        public static final MetaField<Object> VILLAGER_DATA = MetaField.builder("VILLAGER_DATA")
        .versionRange(498, 498, 16, EntityDataTypes.BYTE)
        .versionRange(573, 751, 17, EntityDataTypes.BYTE)
        .versionRange(755, 773, 18, EntityDataTypes.BYTE)
        .versionRange(774, 2147483647, 19, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Boolean> VILLAGER_FINALIZED = MetaField.booleanBuilder("VILLAGER_FINALIZED")
        .defaultValue(false)
        .versionRange(774, 2147483647, 20, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> UNHAPPY_COUNTER = MetaField.intBuilder("UNHAPPY_COUNTER")
        .defaultValue(0)
        .versionRange(498, 498, 15, EntityDataTypes.INT)
        .versionRange(573, 751, 16, EntityDataTypes.INT)
        .versionRange(755, 773, 17, EntityDataTypes.INT)
        .versionRange(774, 2147483647, 18, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> BABY = MetaField.booleanBuilder("BABY")
        .defaultValue(false)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> AGE_LOCKED = MetaField.booleanBuilder("AGE_LOCKED")
        .defaultValue(false)
        .versionRange(774, 2147483647, 17, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Villager() {
        }
    }

    /**
     * Meta field constants for Zombie Villager.
     */
    public static final class ZombieVillager {
        public static final MetaField<Boolean> CONVERTING = MetaField.booleanBuilder("CONVERTING")
        .defaultValue(false)
        .versionRange(498, 498, 17, EntityDataTypes.BOOLEAN)
        .versionRange(573, 751, 18, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 19, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> VILLAGER_DATA = MetaField.builder("VILLAGER_DATA")
        .versionRange(498, 498, 18, EntityDataTypes.BYTE)
        .versionRange(573, 751, 19, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 20, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Boolean> VILLAGER_FINALIZED = MetaField.booleanBuilder("VILLAGER_FINALIZED")
        .defaultValue(false)
        .versionRange(774, 2147483647, 21, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> BABY = MetaField.booleanBuilder("BABY")
        .defaultValue(false)
        .versionRange(498, 498, 14, EntityDataTypes.BOOLEAN)
        .versionRange(573, 751, 15, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> SPECIAL_TYPE = MetaField.intBuilder("SPECIAL_TYPE")
        .defaultValue(0)
        .versionRange(498, 498, 15, EntityDataTypes.INT)
        .versionRange(573, 751, 16, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 17, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> DROWNED_CONVERSION = MetaField.booleanBuilder("DROWNED_CONVERSION")
        .defaultValue(false)
        .versionRange(498, 498, 16, EntityDataTypes.BOOLEAN)
        .versionRange(573, 751, 17, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 18, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private ZombieVillager() {
        }
    }

    /**
     * Meta field constants for Abstract Chested Horse.
     */
    public static final class AbstractChestedHorse {
        public static final MetaField<Boolean> CHEST = MetaField.booleanBuilder("CHEST")
        .defaultValue(false)
        .versionRange(498, 498, 17, EntityDataTypes.BOOLEAN)
        .versionRange(573, 751, 18, EntityDataTypes.BOOLEAN)
        .versionRange(755, 761, 19, EntityDataTypes.BOOLEAN)
        .versionRange(762, 773, 18, EntityDataTypes.BOOLEAN)
        .versionRange(774, 2147483647, 19, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> FLAGS = MetaField.byteBuilder("FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 15, EntityDataTypes.BYTE)
        .versionRange(573, 751, 16, EntityDataTypes.BYTE)
        .versionRange(755, 773, 17, EntityDataTypes.BYTE)
        .versionRange(774, 2147483647, 18, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Object> OWNER_UUID = MetaField.builder("OWNER_UUID")
        .versionRange(498, 498, 16, EntityDataTypes.OPTIONAL_UUID)
        .versionRange(573, 751, 17, EntityDataTypes.OPTIONAL_UUID)
        .versionRange(755, 2147483647, 18, EntityDataTypes.OPTIONAL_UUID)
        .build();

        public static final MetaField<Boolean> BABY = MetaField.booleanBuilder("BABY")
        .defaultValue(false)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> AGE_LOCKED = MetaField.booleanBuilder("AGE_LOCKED")
        .defaultValue(false)
        .versionRange(774, 2147483647, 17, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private AbstractChestedHorse() {
        }
    }

    /**
     * Meta field constants for Cat.
     */
    public static final class Cat {
        public static final MetaField<Integer> TYPE = MetaField.intBuilder("TYPE")
        .defaultValue(0)
        .versionRange(498, 498, 17, EntityDataTypes.INT)
        .versionRange(573, 751, 18, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 19, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> IS_LYING = MetaField.booleanBuilder("IS_LYING")
        .defaultValue(false)
        .versionRange(498, 498, 18, EntityDataTypes.BOOLEAN)
        .versionRange(573, 751, 19, EntityDataTypes.BOOLEAN)
        .versionRange(755, 773, 20, EntityDataTypes.BOOLEAN)
        .versionRange(774, 2147483647, 21, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> RELAX_STATE_ONE = MetaField.booleanBuilder("RELAX_STATE_ONE")
        .defaultValue(false)
        .versionRange(498, 498, 19, EntityDataTypes.BOOLEAN)
        .versionRange(573, 751, 20, EntityDataTypes.BOOLEAN)
        .versionRange(755, 773, 21, EntityDataTypes.BOOLEAN)
        .versionRange(774, 2147483647, 22, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> COLLAR_COLOR = MetaField.intBuilder("COLLAR_COLOR")
        .defaultValue(0)
        .versionRange(498, 498, 20, EntityDataTypes.INT)
        .versionRange(573, 751, 21, EntityDataTypes.INT)
        .versionRange(755, 773, 22, EntityDataTypes.INT)
        .versionRange(774, 2147483647, 23, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> VARIANT = MetaField.builder("VARIANT")
        .versionRange(759, 765, 19, EntityDataTypes.BYTE)
        .versionRange(766, 773, 19, EntityDataTypes.INT)
        .versionRange(774, 2147483647, 20, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SOUND_VARIANT = MetaField.builder("SOUND_VARIANT")
        .versionRange(774, 2147483647, 24, EntityDataTypes.INT)
        .build();

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

        public static final MetaField<Boolean> BABY = MetaField.booleanBuilder("BABY")
        .defaultValue(false)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> AGE_LOCKED = MetaField.booleanBuilder("AGE_LOCKED")
        .defaultValue(false)
        .versionRange(774, 2147483647, 17, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Cat() {
        }
    }

    /**
     * Meta field constants for Horse.
     */
    public static final class Horse {
        public static final MetaField<Integer> TYPE_VARIANT = MetaField.intBuilder("TYPE_VARIANT")
        .defaultValue(0)
        .versionRange(498, 498, 17, EntityDataTypes.INT)
        .versionRange(573, 751, 18, EntityDataTypes.INT)
        .versionRange(755, 761, 19, EntityDataTypes.INT)
        .versionRange(762, 773, 18, EntityDataTypes.INT)
        .versionRange(774, 2147483647, 19, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> FLAGS = MetaField.byteBuilder("FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 15, EntityDataTypes.BYTE)
        .versionRange(573, 751, 16, EntityDataTypes.BYTE)
        .versionRange(755, 773, 17, EntityDataTypes.BYTE)
        .versionRange(774, 2147483647, 18, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Object> OWNER_UUID = MetaField.builder("OWNER_UUID")
        .versionRange(498, 498, 16, EntityDataTypes.OPTIONAL_UUID)
        .versionRange(573, 751, 17, EntityDataTypes.OPTIONAL_UUID)
        .versionRange(755, 2147483647, 18, EntityDataTypes.OPTIONAL_UUID)
        .build();

        public static final MetaField<Boolean> BABY = MetaField.booleanBuilder("BABY")
        .defaultValue(false)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> AGE_LOCKED = MetaField.booleanBuilder("AGE_LOCKED")
        .defaultValue(false)
        .versionRange(774, 2147483647, 17, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Horse() {
        }
    }

    /**
     * Meta field constants for Mushroom Cow.
     */
    public static final class MushroomCow {
        public static final MetaField<Integer> TYPE = MetaField.intBuilder("TYPE")
        .defaultValue(0)
        .versionRange(498, 498, 15, EntityDataTypes.STRING)
        .versionRange(573, 751, 16, EntityDataTypes.STRING)
        .versionRange(755, 769, 17, EntityDataTypes.STRING)
        .versionRange(770, 773, 17, EntityDataTypes.INT)
        .versionRange(774, 2147483647, 18, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> BABY = MetaField.booleanBuilder("BABY")
        .defaultValue(false)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> AGE_LOCKED = MetaField.booleanBuilder("AGE_LOCKED")
        .defaultValue(false)
        .versionRange(774, 2147483647, 17, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private MushroomCow() {
        }
    }

    /**
     * Meta field constants for Tropical Fish.
     */
    public static final class TropicalFish {
        public static final MetaField<Integer> TYPE_VARIANT = MetaField.intBuilder("TYPE_VARIANT")
        .defaultValue(0)
        .versionRange(498, 498, 15, EntityDataTypes.INT)
        .versionRange(573, 751, 16, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 17, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> FROM_BUCKET = MetaField.booleanBuilder("FROM_BUCKET")
        .defaultValue(false)
        .versionRange(498, 498, 14, EntityDataTypes.BOOLEAN)
        .versionRange(573, 751, 15, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private TropicalFish() {
        }
    }

    /**
     * Meta field constants for Witch.
     */
    public static final class Witch {
        public static final MetaField<Boolean> USING_ITEM = MetaField.booleanBuilder("USING_ITEM")
        .defaultValue(false)
        .versionRange(498, 498, 15, EntityDataTypes.BOOLEAN)
        .versionRange(573, 751, 16, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 17, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> IS_CELEBRATING = MetaField.booleanBuilder("IS_CELEBRATING")
        .defaultValue(false)
        .versionRange(498, 498, 14, EntityDataTypes.BOOLEAN)
        .versionRange(573, 751, 15, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Witch() {
        }
    }

    /**
     * Meta field constants for Wolf.
     */
    public static final class Wolf {
        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 2147483647, 17, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Boolean> INTERESTED = MetaField.booleanBuilder("INTERESTED")
        .defaultValue(false)
        .versionRange(498, 751, 18, EntityDataTypes.BOOLEAN)
        .versionRange(755, 773, 19, EntityDataTypes.BOOLEAN)
        .versionRange(774, 2147483647, 20, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> COLLAR_COLOR = MetaField.intBuilder("COLLAR_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 19, EntityDataTypes.INT)
        .versionRange(755, 773, 20, EntityDataTypes.INT)
        .versionRange(774, 2147483647, 21, EntityDataTypes.INT)
        .build();

        public static final MetaField<Integer> REMAINING_ANGER_TIME = MetaField.intBuilder("REMAINING_ANGER_TIME")
        .defaultValue(0)
        .versionRange(735, 751, 20, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 21, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> VARIANT = MetaField.builder("VARIANT")
        .versionRange(766, 773, 22, EntityDataTypes.INT)
        .versionRange(774, 2147483647, 23, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SOUND_VARIANT = MetaField.builder("SOUND_VARIANT")
        .versionRange(770, 773, 23, EntityDataTypes.INT)
        .versionRange(774, 2147483647, 24, EntityDataTypes.INT)
        .build();

        public static final MetaField<Long> ANGER_END_TIME = MetaField.longBuilder("ANGER_END_TIME")
        .defaultValue(0L)
        .versionRange(773, 773, 21, EntityDataTypes.LONG)
        .versionRange(774, 2147483647, 22, EntityDataTypes.LONG)
        .build();

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

        public static final MetaField<Boolean> BABY = MetaField.booleanBuilder("BABY")
        .defaultValue(false)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> AGE_LOCKED = MetaField.booleanBuilder("AGE_LOCKED")
        .defaultValue(false)
        .versionRange(774, 2147483647, 17, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Wolf() {
        }
    }

    /**
     * Meta field constants for Llama.
     */
    public static final class Llama {
        public static final MetaField<Integer> STRENGTH = MetaField.intBuilder("STRENGTH")
        .defaultValue(0)
        .versionRange(498, 498, 18, EntityDataTypes.INT)
        .versionRange(573, 751, 19, EntityDataTypes.INT)
        .versionRange(755, 761, 20, EntityDataTypes.INT)
        .versionRange(762, 773, 19, EntityDataTypes.INT)
        .versionRange(774, 2147483647, 20, EntityDataTypes.INT)
        .build();

        public static final MetaField<Integer> SWAG = MetaField.intBuilder("SWAG")
        .defaultValue(0)
        .versionRange(498, 498, 19, EntityDataTypes.INT)
        .versionRange(573, 751, 20, EntityDataTypes.INT)
        .versionRange(755, 761, 21, EntityDataTypes.INT)
        .versionRange(762, 2147483647, 20, EntityDataTypes.INT)
        .build();

        public static final MetaField<Integer> VARIANT = MetaField.intBuilder("VARIANT")
        .defaultValue(0)
        .versionRange(498, 498, 20, EntityDataTypes.INT)
        .versionRange(573, 751, 21, EntityDataTypes.INT)
        .versionRange(755, 761, 22, EntityDataTypes.INT)
        .versionRange(762, 765, 21, EntityDataTypes.INT)
        .versionRange(766, 773, 20, EntityDataTypes.INT)
        .versionRange(774, 2147483647, 21, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> CHEST = MetaField.booleanBuilder("CHEST")
        .defaultValue(false)
        .versionRange(498, 498, 17, EntityDataTypes.BOOLEAN)
        .versionRange(573, 751, 18, EntityDataTypes.BOOLEAN)
        .versionRange(755, 761, 19, EntityDataTypes.BOOLEAN)
        .versionRange(762, 773, 18, EntityDataTypes.BOOLEAN)
        .versionRange(774, 2147483647, 19, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> FLAGS = MetaField.byteBuilder("FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 15, EntityDataTypes.BYTE)
        .versionRange(573, 751, 16, EntityDataTypes.BYTE)
        .versionRange(755, 773, 17, EntityDataTypes.BYTE)
        .versionRange(774, 2147483647, 18, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Object> OWNER_UUID = MetaField.builder("OWNER_UUID")
        .versionRange(498, 498, 16, EntityDataTypes.OPTIONAL_UUID)
        .versionRange(573, 751, 17, EntityDataTypes.OPTIONAL_UUID)
        .versionRange(755, 2147483647, 18, EntityDataTypes.OPTIONAL_UUID)
        .build();

        public static final MetaField<Boolean> BABY = MetaField.booleanBuilder("BABY")
        .defaultValue(false)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> AGE_LOCKED = MetaField.booleanBuilder("AGE_LOCKED")
        .defaultValue(false)
        .versionRange(774, 2147483647, 17, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Llama() {
        }
    }

    /**
     * Meta field constants for Parrot.
     */
    public static final class Parrot {
        public static final MetaField<Integer> VARIANT = MetaField.intBuilder("VARIANT")
        .defaultValue(0)
        .versionRange(498, 498, 17, EntityDataTypes.INT)
        .versionRange(573, 751, 18, EntityDataTypes.INT)
        .versionRange(755, 773, 19, EntityDataTypes.INT)
        .versionRange(774, 2147483647, 20, EntityDataTypes.INT)
        .build();

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

        public static final MetaField<Boolean> BABY = MetaField.booleanBuilder("BABY")
        .defaultValue(false)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> AGE_LOCKED = MetaField.booleanBuilder("AGE_LOCKED")
        .defaultValue(false)
        .versionRange(774, 2147483647, 17, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Parrot() {
        }
    }

    /**
     * Meta field constants for Pillager.
     */
    public static final class Pillager {
        public static final MetaField<Boolean> IS_CHARGING_CROSSBOW = MetaField.booleanBuilder("IS_CHARGING_CROSSBOW")
        .defaultValue(false)
        .versionRange(498, 498, 15, EntityDataTypes.BOOLEAN)
        .versionRange(573, 751, 16, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 17, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> IS_CELEBRATING = MetaField.booleanBuilder("IS_CELEBRATING")
        .defaultValue(false)
        .versionRange(498, 498, 14, EntityDataTypes.BOOLEAN)
        .versionRange(573, 751, 15, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Pillager() {
        }
    }

    /**
     * Meta field constants for Spellcaster Illager.
     */
    public static final class SpellcasterIllager {
        public static final MetaField<Byte> SPELL_CASTING = MetaField.byteBuilder("SPELL_CASTING")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 15, EntityDataTypes.BYTE)
        .versionRange(573, 751, 16, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 17, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Boolean> IS_CELEBRATING = MetaField.booleanBuilder("IS_CELEBRATING")
        .defaultValue(false)
        .versionRange(498, 498, 14, EntityDataTypes.BOOLEAN)
        .versionRange(573, 751, 15, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private SpellcasterIllager() {
        }
    }

    /**
     * Meta field constants for Bee.
     */
    public static final class Bee {
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

        public static final MetaField<Boolean> BABY = MetaField.booleanBuilder("BABY")
        .defaultValue(false)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> AGE_LOCKED = MetaField.booleanBuilder("AGE_LOCKED")
        .defaultValue(false)
        .versionRange(774, 2147483647, 17, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Bee() {
        }
    }

    /**
     * Meta field constants for Piglin.
     */
    public static final class Piglin {
        public static final MetaField<Boolean> BABY = MetaField.booleanBuilder("BABY")
        .defaultValue(false)
        .versionRange(735, 735, 15, EntityDataTypes.BOOLEAN)
        .versionRange(751, 751, 16, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 17, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> IMMUNE_TO_ZOMBIFICATION = MetaField.booleanBuilder("IMMUNE_TO_ZOMBIFICATION")
        .defaultValue(false)
        .versionRange(735, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> IS_CHARGING_CROSSBOW = MetaField.booleanBuilder("IS_CHARGING_CROSSBOW")
        .defaultValue(false)
        .versionRange(735, 751, 17, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 18, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> IS_DANCING = MetaField.booleanBuilder("IS_DANCING")
        .defaultValue(false)
        .versionRange(735, 751, 18, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 19, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Piglin() {
        }
    }

    /**
     * Meta field constants for Zoglin.
     */
    public static final class Zoglin {
        public static final MetaField<Boolean> BABY = MetaField.booleanBuilder("BABY")
        .defaultValue(false)
        .versionRange(735, 751, 15, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Zoglin() {
        }
    }

    /**
     * Meta field constants for Hoglin.
     */
    public static final class Hoglin {
        public static final MetaField<Boolean> IMMUNE_TO_ZOMBIFICATION = MetaField.booleanBuilder("IMMUNE_TO_ZOMBIFICATION")
        .defaultValue(false)
        .versionRange(735, 751, 16, EntityDataTypes.BOOLEAN)
        .versionRange(755, 773, 17, EntityDataTypes.BOOLEAN)
        .versionRange(774, 2147483647, 18, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> BABY = MetaField.booleanBuilder("BABY")
        .defaultValue(false)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> AGE_LOCKED = MetaField.booleanBuilder("AGE_LOCKED")
        .defaultValue(false)
        .versionRange(774, 2147483647, 17, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Hoglin() {
        }
    }

    /**
     * Meta field constants for Strider.
     */
    public static final class Strider {
        public static final MetaField<Integer> BOOST_TIME = MetaField.intBuilder("BOOST_TIME")
        .defaultValue(0)
        .versionRange(735, 751, 16, EntityDataTypes.INT)
        .versionRange(755, 773, 17, EntityDataTypes.INT)
        .versionRange(774, 2147483647, 18, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> SUFFOCATING = MetaField.booleanBuilder("SUFFOCATING")
        .defaultValue(false)
        .versionRange(735, 751, 17, EntityDataTypes.BOOLEAN)
        .versionRange(755, 773, 18, EntityDataTypes.BOOLEAN)
        .versionRange(774, 2147483647, 19, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SADDLE = MetaField.booleanBuilder("SADDLE")
        .defaultValue(false)
        .versionRange(735, 751, 18, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 19, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> BABY = MetaField.booleanBuilder("BABY")
        .defaultValue(false)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> AGE_LOCKED = MetaField.booleanBuilder("AGE_LOCKED")
        .defaultValue(false)
        .versionRange(774, 2147483647, 17, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Strider() {
        }
    }

    /**
     * Meta field constants for Abstract Piglin.
     */
    public static final class AbstractPiglin {
        public static final MetaField<Boolean> IMMUNE_TO_ZOMBIFICATION = MetaField.booleanBuilder("IMMUNE_TO_ZOMBIFICATION")
        .defaultValue(false)
        .versionRange(751, 751, 15, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private AbstractPiglin() {
        }
    }

    /**
     * Meta field constants for Ageable Mob.
     */
    public static final class AgeableMob {
        public static final MetaField<Boolean> BABY = MetaField.booleanBuilder("BABY")
        .defaultValue(false)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> AGE_LOCKED = MetaField.booleanBuilder("AGE_LOCKED")
        .defaultValue(false)
        .versionRange(774, 2147483647, 17, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private AgeableMob() {
        }
    }

    /**
     * Meta field constants for Axolotl.
     */
    public static final class Axolotl {
        public static final MetaField<Integer> VARIANT = MetaField.intBuilder("VARIANT")
        .defaultValue(0)
        .versionRange(755, 773, 17, EntityDataTypes.INT)
        .versionRange(774, 2147483647, 18, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> PLAYING_DEAD = MetaField.booleanBuilder("PLAYING_DEAD")
        .defaultValue(false)
        .versionRange(755, 773, 18, EntityDataTypes.BOOLEAN)
        .versionRange(774, 2147483647, 19, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> FROM_BUCKET = MetaField.booleanBuilder("FROM_BUCKET")
        .defaultValue(false)
        .versionRange(755, 773, 19, EntityDataTypes.BOOLEAN)
        .versionRange(774, 2147483647, 20, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> BABY = MetaField.booleanBuilder("BABY")
        .defaultValue(false)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> AGE_LOCKED = MetaField.booleanBuilder("AGE_LOCKED")
        .defaultValue(false)
        .versionRange(774, 2147483647, 17, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Axolotl() {
        }
    }

    /**
     * Meta field constants for Glow Squid.
     */
    public static final class GlowSquid {
        public static final MetaField<Integer> DARK_TICKS_REMAINING = MetaField.intBuilder("DARK_TICKS_REMAINING")
        .defaultValue(0)
        .versionRange(755, 767, 16, EntityDataTypes.INT)
        .versionRange(768, 773, 17, EntityDataTypes.INT)
        .versionRange(774, 2147483647, 18, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> BABY = MetaField.booleanBuilder("BABY")
        .defaultValue(false)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> AGE_LOCKED = MetaField.booleanBuilder("AGE_LOCKED")
        .defaultValue(false)
        .versionRange(774, 2147483647, 17, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private GlowSquid() {
        }
    }

    /**
     * Meta field constants for Goat.
     */
    public static final class Goat {
        public static final MetaField<Boolean> IS_SCREAMING_GOAT = MetaField.booleanBuilder("IS_SCREAMING_GOAT")
        .defaultValue(false)
        .versionRange(755, 773, 17, EntityDataTypes.BOOLEAN)
        .versionRange(774, 2147483647, 18, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> HAS_LEFT_HORN = MetaField.booleanBuilder("HAS_LEFT_HORN")
        .defaultValue(false)
        .versionRange(759, 773, 18, EntityDataTypes.BOOLEAN)
        .versionRange(774, 2147483647, 19, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> HAS_RIGHT_HORN = MetaField.booleanBuilder("HAS_RIGHT_HORN")
        .defaultValue(false)
        .versionRange(759, 773, 19, EntityDataTypes.BOOLEAN)
        .versionRange(774, 2147483647, 20, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> BABY = MetaField.booleanBuilder("BABY")
        .defaultValue(false)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> AGE_LOCKED = MetaField.booleanBuilder("AGE_LOCKED")
        .defaultValue(false)
        .versionRange(774, 2147483647, 17, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Goat() {
        }
    }

    /**
     * Meta field constants for Skeleton.
     */
    public static final class Skeleton {
        public static final MetaField<Boolean> STRAY_CONVERSION = MetaField.booleanBuilder("STRAY_CONVERSION")
        .defaultValue(false)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Skeleton() {
        }
    }

    /**
     * Meta field constants for Painting.
     */
    public static final class Painting {
        public static final MetaField<Object> PAINTING_VARIANT = MetaField.builder("PAINTING_VARIANT")
        .versionRange(759, 770, 8, EntityDataTypes.INT)
        .versionRange(771, 2147483647, 9, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> DIRECTION = MetaField.builder("DIRECTION")
        .versionRange(771, 2147483647, 8, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Painting() {
        }
    }

    /**
     * Meta field constants for Warden.
     */
    public static final class Warden {
        public static final MetaField<Integer> CLIENT_ANGER_LEVEL = MetaField.intBuilder("CLIENT_ANGER_LEVEL")
        .defaultValue(0)
        .versionRange(759, 2147483647, 16, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Warden() {
        }
    }

    /**
     * Meta field constants for Frog.
     */
    public static final class Frog {
        public static final MetaField<Object> VARIANT = MetaField.builder("VARIANT")
        .versionRange(759, 765, 17, EntityDataTypes.BYTE)
        .versionRange(766, 773, 17, EntityDataTypes.INT)
        .versionRange(774, 2147483647, 18, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> TONGUE_TARGET = MetaField.builder("TONGUE_TARGET")
        .versionRange(759, 773, 18, EntityDataTypes.OPTIONAL_INT)
        .versionRange(774, 2147483647, 19, EntityDataTypes.OPTIONAL_INT)
        .build();

        public static final MetaField<Boolean> BABY = MetaField.booleanBuilder("BABY")
        .defaultValue(false)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> AGE_LOCKED = MetaField.booleanBuilder("AGE_LOCKED")
        .defaultValue(false)
        .versionRange(774, 2147483647, 17, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Frog() {
        }
    }

    /**
     * Meta field constants for Allay.
     */
    public static final class Allay {
        public static final MetaField<Boolean> DANCING = MetaField.booleanBuilder("DANCING")
        .defaultValue(false)
        .versionRange(760, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> CAN_DUPLICATE = MetaField.booleanBuilder("CAN_DUPLICATE")
        .defaultValue(false)
        .versionRange(760, 2147483647, 17, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Allay() {
        }
    }

    /**
     * Meta field constants for Camel.
     */
    public static final class Camel {
        public static final MetaField<Boolean> DASH = MetaField.booleanBuilder("DASH")
        .defaultValue(false)
        .versionRange(761, 761, 19, EntityDataTypes.BOOLEAN)
        .versionRange(762, 773, 18, EntityDataTypes.BOOLEAN)
        .versionRange(774, 2147483647, 19, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Long> LAST_POSE_CHANGE_TICK = MetaField.longBuilder("LAST_POSE_CHANGE_TICK")
        .defaultValue(0L)
        .versionRange(761, 761, 20, EntityDataTypes.LONG)
        .versionRange(762, 773, 19, EntityDataTypes.LONG)
        .versionRange(774, 2147483647, 20, EntityDataTypes.LONG)
        .build();

        public static final MetaField<Byte> FLAGS = MetaField.byteBuilder("FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 15, EntityDataTypes.BYTE)
        .versionRange(573, 751, 16, EntityDataTypes.BYTE)
        .versionRange(755, 773, 17, EntityDataTypes.BYTE)
        .versionRange(774, 2147483647, 18, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Object> OWNER_UUID = MetaField.builder("OWNER_UUID")
        .versionRange(498, 498, 16, EntityDataTypes.OPTIONAL_UUID)
        .versionRange(573, 751, 17, EntityDataTypes.OPTIONAL_UUID)
        .versionRange(755, 2147483647, 18, EntityDataTypes.OPTIONAL_UUID)
        .build();

        public static final MetaField<Boolean> BABY = MetaField.booleanBuilder("BABY")
        .defaultValue(false)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> AGE_LOCKED = MetaField.booleanBuilder("AGE_LOCKED")
        .defaultValue(false)
        .versionRange(774, 2147483647, 17, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Camel() {
        }
    }

    /**
     * Meta field constants for Display.
     */
    public static final class Display {
        public static final MetaField<Integer> INTERPOLATION_START_DELTA_TICKS = MetaField.intBuilder("INTERPOLATION_START_DELTA_TICKS")
        .defaultValue(0)
        .versionRange(762, 2147483647, 8, EntityDataTypes.INT)
        .build();

        public static final MetaField<Integer> INTERPOLATION_DURATION = MetaField.intBuilder("INTERPOLATION_DURATION")
        .defaultValue(0)
        .versionRange(762, 2147483647, 9, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> TRANSLATION = MetaField.builder("TRANSLATION")
        .versionRange(762, 762, 10, EntityDataTypes.VECTOR3F)
        .versionRange(764, 772, 11, EntityDataTypes.VECTOR3F)
        .versionRange(773, 2147483647, 11, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Object> SCALE = MetaField.builder("SCALE")
        .versionRange(762, 762, 11, EntityDataTypes.VECTOR3F)
        .versionRange(764, 772, 12, EntityDataTypes.VECTOR3F)
        .versionRange(773, 2147483647, 12, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Object> LEFT_ROTATION = MetaField.builder("LEFT_ROTATION")
        .versionRange(762, 762, 12, EntityDataTypes.QUATERNION)
        .versionRange(764, 772, 13, EntityDataTypes.QUATERNION)
        .versionRange(773, 2147483647, 13, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Object> RIGHT_ROTATION = MetaField.builder("RIGHT_ROTATION")
        .versionRange(762, 762, 13, EntityDataTypes.QUATERNION)
        .versionRange(764, 772, 14, EntityDataTypes.QUATERNION)
        .versionRange(773, 2147483647, 14, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> BILLBOARD_RENDER_CONSTRAINTS = MetaField.byteBuilder("BILLBOARD_RENDER_CONSTRAINTS")
        .defaultValue((byte) 0)
        .versionRange(762, 762, 14, EntityDataTypes.BYTE)
        .versionRange(764, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> BRIGHTNESS_OVERRIDE = MetaField.intBuilder("BRIGHTNESS_OVERRIDE")
        .defaultValue(0)
        .versionRange(762, 762, 15, EntityDataTypes.INT)
        .versionRange(764, 2147483647, 16, EntityDataTypes.INT)
        .build();

        public static final MetaField<Float> VIEW_RANGE = MetaField.floatBuilder("VIEW_RANGE")
        .defaultValue(0.0f)
        .versionRange(762, 762, 16, EntityDataTypes.FLOAT)
        .versionRange(764, 2147483647, 17, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Float> SHADOW_RADIUS = MetaField.floatBuilder("SHADOW_RADIUS")
        .defaultValue(0.0f)
        .versionRange(762, 762, 17, EntityDataTypes.FLOAT)
        .versionRange(764, 2147483647, 18, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Float> SHADOW_STRENGTH = MetaField.floatBuilder("SHADOW_STRENGTH")
        .defaultValue(0.0f)
        .versionRange(762, 762, 18, EntityDataTypes.FLOAT)
        .versionRange(764, 2147483647, 19, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Float> WIDTH = MetaField.floatBuilder("WIDTH")
        .defaultValue(0.0f)
        .versionRange(762, 762, 19, EntityDataTypes.FLOAT)
        .versionRange(764, 2147483647, 20, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Float> HEIGHT = MetaField.floatBuilder("HEIGHT")
        .defaultValue(0.0f)
        .versionRange(762, 762, 20, EntityDataTypes.FLOAT)
        .versionRange(764, 2147483647, 21, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> GLOW_COLOR_OVERRIDE = MetaField.intBuilder("GLOW_COLOR_OVERRIDE")
        .defaultValue(0)
        .versionRange(762, 762, 21, EntityDataTypes.INT)
        .versionRange(764, 2147483647, 22, EntityDataTypes.INT)
        .build();

        public static final MetaField<Integer> TRANSFORMATION_INTERPOLATION_START_DELTA_TICKS = MetaField.intBuilder("TRANSFORMATION_INTERPOLATION_START_DELTA_TICKS")
        .defaultValue(0)
        .versionRange(764, 2147483647, 8, EntityDataTypes.INT)
        .build();

        public static final MetaField<Integer> TRANSFORMATION_INTERPOLATION_DURATION = MetaField.intBuilder("TRANSFORMATION_INTERPOLATION_DURATION")
        .defaultValue(0)
        .versionRange(764, 2147483647, 9, EntityDataTypes.INT)
        .build();

        public static final MetaField<Integer> POS_ROT_INTERPOLATION_DURATION = MetaField.intBuilder("POS_ROT_INTERPOLATION_DURATION")
        .defaultValue(0)
        .versionRange(764, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Display() {
        }
    }

    /**
     * Meta field constants for Interaction.
     */
    public static final class Interaction {
        public static final MetaField<Float> WIDTH = MetaField.floatBuilder("WIDTH")
        .defaultValue(0.0f)
        .versionRange(762, 2147483647, 8, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Float> HEIGHT = MetaField.floatBuilder("HEIGHT")
        .defaultValue(0.0f)
        .versionRange(762, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Boolean> RESPONSE = MetaField.booleanBuilder("RESPONSE")
        .defaultValue(false)
        .versionRange(762, 2147483647, 10, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Interaction() {
        }
    }

    /**
     * Meta field constants for Block Display.
     */
    public static final class BlockDisplay {
        public static final MetaField<Object> BLOCK_STATE = MetaField.builder("BLOCK_STATE")
        .versionRange(762, 762, 22, EntityDataTypes.BLOCK_STATE)
        .versionRange(764, 2147483647, 23, EntityDataTypes.BLOCK_STATE)
        .build();

        public static final MetaField<Integer> INTERPOLATION_START_DELTA_TICKS = MetaField.intBuilder("INTERPOLATION_START_DELTA_TICKS")
        .defaultValue(0)
        .versionRange(762, 2147483647, 8, EntityDataTypes.INT)
        .build();

        public static final MetaField<Integer> INTERPOLATION_DURATION = MetaField.intBuilder("INTERPOLATION_DURATION")
        .defaultValue(0)
        .versionRange(762, 2147483647, 9, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> TRANSLATION = MetaField.builder("TRANSLATION")
        .versionRange(762, 762, 10, EntityDataTypes.VECTOR3F)
        .versionRange(764, 772, 11, EntityDataTypes.VECTOR3F)
        .versionRange(773, 2147483647, 11, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Object> SCALE = MetaField.builder("SCALE")
        .versionRange(762, 762, 11, EntityDataTypes.VECTOR3F)
        .versionRange(764, 772, 12, EntityDataTypes.VECTOR3F)
        .versionRange(773, 2147483647, 12, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Object> LEFT_ROTATION = MetaField.builder("LEFT_ROTATION")
        .versionRange(762, 762, 12, EntityDataTypes.QUATERNION)
        .versionRange(764, 772, 13, EntityDataTypes.QUATERNION)
        .versionRange(773, 2147483647, 13, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Object> RIGHT_ROTATION = MetaField.builder("RIGHT_ROTATION")
        .versionRange(762, 762, 13, EntityDataTypes.QUATERNION)
        .versionRange(764, 772, 14, EntityDataTypes.QUATERNION)
        .versionRange(773, 2147483647, 14, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> BILLBOARD_RENDER_CONSTRAINTS = MetaField.byteBuilder("BILLBOARD_RENDER_CONSTRAINTS")
        .defaultValue((byte) 0)
        .versionRange(762, 762, 14, EntityDataTypes.BYTE)
        .versionRange(764, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> BRIGHTNESS_OVERRIDE = MetaField.intBuilder("BRIGHTNESS_OVERRIDE")
        .defaultValue(0)
        .versionRange(762, 762, 15, EntityDataTypes.INT)
        .versionRange(764, 2147483647, 16, EntityDataTypes.INT)
        .build();

        public static final MetaField<Float> VIEW_RANGE = MetaField.floatBuilder("VIEW_RANGE")
        .defaultValue(0.0f)
        .versionRange(762, 762, 16, EntityDataTypes.FLOAT)
        .versionRange(764, 2147483647, 17, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Float> SHADOW_RADIUS = MetaField.floatBuilder("SHADOW_RADIUS")
        .defaultValue(0.0f)
        .versionRange(762, 762, 17, EntityDataTypes.FLOAT)
        .versionRange(764, 2147483647, 18, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Float> SHADOW_STRENGTH = MetaField.floatBuilder("SHADOW_STRENGTH")
        .defaultValue(0.0f)
        .versionRange(762, 762, 18, EntityDataTypes.FLOAT)
        .versionRange(764, 2147483647, 19, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Float> WIDTH = MetaField.floatBuilder("WIDTH")
        .defaultValue(0.0f)
        .versionRange(762, 762, 19, EntityDataTypes.FLOAT)
        .versionRange(764, 2147483647, 20, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Float> HEIGHT = MetaField.floatBuilder("HEIGHT")
        .defaultValue(0.0f)
        .versionRange(762, 762, 20, EntityDataTypes.FLOAT)
        .versionRange(764, 2147483647, 21, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> GLOW_COLOR_OVERRIDE = MetaField.intBuilder("GLOW_COLOR_OVERRIDE")
        .defaultValue(0)
        .versionRange(762, 762, 21, EntityDataTypes.INT)
        .versionRange(764, 2147483647, 22, EntityDataTypes.INT)
        .build();

        public static final MetaField<Integer> TRANSFORMATION_INTERPOLATION_START_DELTA_TICKS = MetaField.intBuilder("TRANSFORMATION_INTERPOLATION_START_DELTA_TICKS")
        .defaultValue(0)
        .versionRange(764, 2147483647, 8, EntityDataTypes.INT)
        .build();

        public static final MetaField<Integer> TRANSFORMATION_INTERPOLATION_DURATION = MetaField.intBuilder("TRANSFORMATION_INTERPOLATION_DURATION")
        .defaultValue(0)
        .versionRange(764, 2147483647, 9, EntityDataTypes.INT)
        .build();

        public static final MetaField<Integer> POS_ROT_INTERPOLATION_DURATION = MetaField.intBuilder("POS_ROT_INTERPOLATION_DURATION")
        .defaultValue(0)
        .versionRange(764, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private BlockDisplay() {
        }
    }

    /**
     * Meta field constants for Item Display.
     */
    public static final class ItemDisplay {
        public static final MetaField<Object> ITEM_STACK = MetaField.builder("ITEM_STACK")
        .versionRange(762, 762, 22, EntityDataTypes.ITEMSTACK)
        .versionRange(764, 2147483647, 23, EntityDataTypes.ITEMSTACK)
        .build();

        public static final MetaField<Byte> ITEM_DISPLAY = MetaField.byteBuilder("ITEM_DISPLAY")
        .defaultValue((byte) 0)
        .versionRange(762, 762, 23, EntityDataTypes.BYTE)
        .versionRange(764, 2147483647, 24, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> INTERPOLATION_START_DELTA_TICKS = MetaField.intBuilder("INTERPOLATION_START_DELTA_TICKS")
        .defaultValue(0)
        .versionRange(762, 2147483647, 8, EntityDataTypes.INT)
        .build();

        public static final MetaField<Integer> INTERPOLATION_DURATION = MetaField.intBuilder("INTERPOLATION_DURATION")
        .defaultValue(0)
        .versionRange(762, 2147483647, 9, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> TRANSLATION = MetaField.builder("TRANSLATION")
        .versionRange(762, 762, 10, EntityDataTypes.VECTOR3F)
        .versionRange(764, 772, 11, EntityDataTypes.VECTOR3F)
        .versionRange(773, 2147483647, 11, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Object> SCALE = MetaField.builder("SCALE")
        .versionRange(762, 762, 11, EntityDataTypes.VECTOR3F)
        .versionRange(764, 772, 12, EntityDataTypes.VECTOR3F)
        .versionRange(773, 2147483647, 12, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Object> LEFT_ROTATION = MetaField.builder("LEFT_ROTATION")
        .versionRange(762, 762, 12, EntityDataTypes.QUATERNION)
        .versionRange(764, 772, 13, EntityDataTypes.QUATERNION)
        .versionRange(773, 2147483647, 13, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Object> RIGHT_ROTATION = MetaField.builder("RIGHT_ROTATION")
        .versionRange(762, 762, 13, EntityDataTypes.QUATERNION)
        .versionRange(764, 772, 14, EntityDataTypes.QUATERNION)
        .versionRange(773, 2147483647, 14, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> BILLBOARD_RENDER_CONSTRAINTS = MetaField.byteBuilder("BILLBOARD_RENDER_CONSTRAINTS")
        .defaultValue((byte) 0)
        .versionRange(762, 762, 14, EntityDataTypes.BYTE)
        .versionRange(764, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> BRIGHTNESS_OVERRIDE = MetaField.intBuilder("BRIGHTNESS_OVERRIDE")
        .defaultValue(0)
        .versionRange(762, 762, 15, EntityDataTypes.INT)
        .versionRange(764, 2147483647, 16, EntityDataTypes.INT)
        .build();

        public static final MetaField<Float> VIEW_RANGE = MetaField.floatBuilder("VIEW_RANGE")
        .defaultValue(0.0f)
        .versionRange(762, 762, 16, EntityDataTypes.FLOAT)
        .versionRange(764, 2147483647, 17, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Float> SHADOW_RADIUS = MetaField.floatBuilder("SHADOW_RADIUS")
        .defaultValue(0.0f)
        .versionRange(762, 762, 17, EntityDataTypes.FLOAT)
        .versionRange(764, 2147483647, 18, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Float> SHADOW_STRENGTH = MetaField.floatBuilder("SHADOW_STRENGTH")
        .defaultValue(0.0f)
        .versionRange(762, 762, 18, EntityDataTypes.FLOAT)
        .versionRange(764, 2147483647, 19, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Float> WIDTH = MetaField.floatBuilder("WIDTH")
        .defaultValue(0.0f)
        .versionRange(762, 762, 19, EntityDataTypes.FLOAT)
        .versionRange(764, 2147483647, 20, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Float> HEIGHT = MetaField.floatBuilder("HEIGHT")
        .defaultValue(0.0f)
        .versionRange(762, 762, 20, EntityDataTypes.FLOAT)
        .versionRange(764, 2147483647, 21, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> GLOW_COLOR_OVERRIDE = MetaField.intBuilder("GLOW_COLOR_OVERRIDE")
        .defaultValue(0)
        .versionRange(762, 762, 21, EntityDataTypes.INT)
        .versionRange(764, 2147483647, 22, EntityDataTypes.INT)
        .build();

        public static final MetaField<Integer> TRANSFORMATION_INTERPOLATION_START_DELTA_TICKS = MetaField.intBuilder("TRANSFORMATION_INTERPOLATION_START_DELTA_TICKS")
        .defaultValue(0)
        .versionRange(764, 2147483647, 8, EntityDataTypes.INT)
        .build();

        public static final MetaField<Integer> TRANSFORMATION_INTERPOLATION_DURATION = MetaField.intBuilder("TRANSFORMATION_INTERPOLATION_DURATION")
        .defaultValue(0)
        .versionRange(764, 2147483647, 9, EntityDataTypes.INT)
        .build();

        public static final MetaField<Integer> POS_ROT_INTERPOLATION_DURATION = MetaField.intBuilder("POS_ROT_INTERPOLATION_DURATION")
        .defaultValue(0)
        .versionRange(764, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private ItemDisplay() {
        }
    }

    /**
     * Meta field constants for Text Display.
     */
    public static final class TextDisplay {
        public static final MetaField<Object> TEXT = MetaField.builder("TEXT")
        .versionRange(762, 762, 22, EntityDataTypes.ADV_COMPONENT)
        .versionRange(764, 2147483647, 23, EntityDataTypes.ADV_COMPONENT)
        .build();

        public static final MetaField<Integer> LINE_WIDTH = MetaField.intBuilder("LINE_WIDTH")
        .defaultValue(0)
        .versionRange(762, 762, 23, EntityDataTypes.INT)
        .versionRange(764, 2147483647, 24, EntityDataTypes.INT)
        .build();

        public static final MetaField<Integer> BACKGROUND_COLOR = MetaField.intBuilder("BACKGROUND_COLOR")
        .defaultValue(0)
        .versionRange(762, 762, 24, EntityDataTypes.INT)
        .versionRange(764, 2147483647, 25, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> TEXT_OPACITY = MetaField.byteBuilder("TEXT_OPACITY")
        .defaultValue((byte) 0)
        .versionRange(762, 762, 25, EntityDataTypes.BYTE)
        .versionRange(764, 2147483647, 26, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> STYLE_FLAGS = MetaField.byteBuilder("STYLE_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(762, 762, 26, EntityDataTypes.BYTE)
        .versionRange(764, 2147483647, 27, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> INTERPOLATION_START_DELTA_TICKS = MetaField.intBuilder("INTERPOLATION_START_DELTA_TICKS")
        .defaultValue(0)
        .versionRange(762, 2147483647, 8, EntityDataTypes.INT)
        .build();

        public static final MetaField<Integer> INTERPOLATION_DURATION = MetaField.intBuilder("INTERPOLATION_DURATION")
        .defaultValue(0)
        .versionRange(762, 2147483647, 9, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> TRANSLATION = MetaField.builder("TRANSLATION")
        .versionRange(762, 762, 10, EntityDataTypes.VECTOR3F)
        .versionRange(764, 772, 11, EntityDataTypes.VECTOR3F)
        .versionRange(773, 2147483647, 11, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Object> SCALE = MetaField.builder("SCALE")
        .versionRange(762, 762, 11, EntityDataTypes.VECTOR3F)
        .versionRange(764, 772, 12, EntityDataTypes.VECTOR3F)
        .versionRange(773, 2147483647, 12, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Object> LEFT_ROTATION = MetaField.builder("LEFT_ROTATION")
        .versionRange(762, 762, 12, EntityDataTypes.QUATERNION)
        .versionRange(764, 772, 13, EntityDataTypes.QUATERNION)
        .versionRange(773, 2147483647, 13, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Object> RIGHT_ROTATION = MetaField.builder("RIGHT_ROTATION")
        .versionRange(762, 762, 13, EntityDataTypes.QUATERNION)
        .versionRange(764, 772, 14, EntityDataTypes.QUATERNION)
        .versionRange(773, 2147483647, 14, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> BILLBOARD_RENDER_CONSTRAINTS = MetaField.byteBuilder("BILLBOARD_RENDER_CONSTRAINTS")
        .defaultValue((byte) 0)
        .versionRange(762, 762, 14, EntityDataTypes.BYTE)
        .versionRange(764, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> BRIGHTNESS_OVERRIDE = MetaField.intBuilder("BRIGHTNESS_OVERRIDE")
        .defaultValue(0)
        .versionRange(762, 762, 15, EntityDataTypes.INT)
        .versionRange(764, 2147483647, 16, EntityDataTypes.INT)
        .build();

        public static final MetaField<Float> VIEW_RANGE = MetaField.floatBuilder("VIEW_RANGE")
        .defaultValue(0.0f)
        .versionRange(762, 762, 16, EntityDataTypes.FLOAT)
        .versionRange(764, 2147483647, 17, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Float> SHADOW_RADIUS = MetaField.floatBuilder("SHADOW_RADIUS")
        .defaultValue(0.0f)
        .versionRange(762, 762, 17, EntityDataTypes.FLOAT)
        .versionRange(764, 2147483647, 18, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Float> SHADOW_STRENGTH = MetaField.floatBuilder("SHADOW_STRENGTH")
        .defaultValue(0.0f)
        .versionRange(762, 762, 18, EntityDataTypes.FLOAT)
        .versionRange(764, 2147483647, 19, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Float> WIDTH = MetaField.floatBuilder("WIDTH")
        .defaultValue(0.0f)
        .versionRange(762, 762, 19, EntityDataTypes.FLOAT)
        .versionRange(764, 2147483647, 20, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Float> HEIGHT = MetaField.floatBuilder("HEIGHT")
        .defaultValue(0.0f)
        .versionRange(762, 762, 20, EntityDataTypes.FLOAT)
        .versionRange(764, 2147483647, 21, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> GLOW_COLOR_OVERRIDE = MetaField.intBuilder("GLOW_COLOR_OVERRIDE")
        .defaultValue(0)
        .versionRange(762, 762, 21, EntityDataTypes.INT)
        .versionRange(764, 2147483647, 22, EntityDataTypes.INT)
        .build();

        public static final MetaField<Integer> TRANSFORMATION_INTERPOLATION_START_DELTA_TICKS = MetaField.intBuilder("TRANSFORMATION_INTERPOLATION_START_DELTA_TICKS")
        .defaultValue(0)
        .versionRange(764, 2147483647, 8, EntityDataTypes.INT)
        .build();

        public static final MetaField<Integer> TRANSFORMATION_INTERPOLATION_DURATION = MetaField.intBuilder("TRANSFORMATION_INTERPOLATION_DURATION")
        .defaultValue(0)
        .versionRange(764, 2147483647, 9, EntityDataTypes.INT)
        .build();

        public static final MetaField<Integer> POS_ROT_INTERPOLATION_DURATION = MetaField.intBuilder("POS_ROT_INTERPOLATION_DURATION")
        .defaultValue(0)
        .versionRange(764, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private TextDisplay() {
        }
    }

    /**
     * Meta field constants for Sniffer.
     */
    public static final class Sniffer {
        public static final MetaField<Object> STATE = MetaField.builder("STATE")
        .versionRange(762, 773, 17, EntityDataTypes.INT)
        .versionRange(774, 2147483647, 18, EntityDataTypes.INT)
        .build();

        public static final MetaField<Integer> DROP_SEED_AT_TICK = MetaField.intBuilder("DROP_SEED_AT_TICK")
        .defaultValue(0)
        .versionRange(762, 773, 18, EntityDataTypes.INT)
        .versionRange(774, 2147483647, 19, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> BABY = MetaField.booleanBuilder("BABY")
        .defaultValue(false)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> AGE_LOCKED = MetaField.booleanBuilder("AGE_LOCKED")
        .defaultValue(false)
        .versionRange(774, 2147483647, 17, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Sniffer() {
        }
    }

    /**
     * Meta field constants for Vehicle Entity.
     */
    public static final class VehicleEntity {
        public static final MetaField<Integer> HURT = MetaField.intBuilder("HURT")
        .defaultValue(0)
        .versionRange(765, 2147483647, 8, EntityDataTypes.INT)
        .build();

        public static final MetaField<Integer> HURTDIR = MetaField.intBuilder("HURTDIR")
        .defaultValue(0)
        .versionRange(765, 2147483647, 9, EntityDataTypes.INT)
        .build();

        public static final MetaField<Float> DAMAGE = MetaField.floatBuilder("DAMAGE")
        .defaultValue(0.0f)
        .versionRange(765, 2147483647, 10, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private VehicleEntity() {
        }
    }

    /**
     * Meta field constants for Ominous Item Spawner.
     */
    public static final class OminousItemSpawner {
        public static final MetaField<Object> ITEM = MetaField.builder("ITEM")
        .versionRange(766, 2147483647, 8, EntityDataTypes.ITEMSTACK)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private OminousItemSpawner() {
        }
    }

    /**
     * Meta field constants for Armadillo.
     */
    public static final class Armadillo {
        public static final MetaField<Object> ARMADILLO_STATE = MetaField.builder("ARMADILLO_STATE")
        .versionRange(766, 773, 17, EntityDataTypes.INT)
        .versionRange(774, 2147483647, 18, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> BABY = MetaField.booleanBuilder("BABY")
        .defaultValue(false)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> AGE_LOCKED = MetaField.booleanBuilder("AGE_LOCKED")
        .defaultValue(false)
        .versionRange(774, 2147483647, 17, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Armadillo() {
        }
    }

    /**
     * Meta field constants for Bogged.
     */
    public static final class Bogged {
        public static final MetaField<Boolean> SHEARED = MetaField.booleanBuilder("SHEARED")
        .defaultValue(false)
        .versionRange(766, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Bogged() {
        }
    }

    /**
     * Meta field constants for Abstract Boat.
     */
    public static final class AbstractBoat {
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

        public static final MetaField<Integer> HURT = MetaField.intBuilder("HURT")
        .defaultValue(0)
        .versionRange(765, 2147483647, 8, EntityDataTypes.INT)
        .build();

        public static final MetaField<Integer> HURTDIR = MetaField.intBuilder("HURTDIR")
        .defaultValue(0)
        .versionRange(765, 2147483647, 9, EntityDataTypes.INT)
        .build();

        public static final MetaField<Float> DAMAGE = MetaField.floatBuilder("DAMAGE")
        .defaultValue(0.0f)
        .versionRange(765, 2147483647, 10, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private AbstractBoat() {
        }
    }

    /**
     * Meta field constants for Creaking.
     */
    public static final class Creaking {
        public static final MetaField<Boolean> CAN_MOVE = MetaField.booleanBuilder("CAN_MOVE")
        .defaultValue(false)
        .versionRange(768, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> IS_ACTIVE = MetaField.booleanBuilder("IS_ACTIVE")
        .defaultValue(false)
        .versionRange(768, 2147483647, 17, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> IS_TEARING_DOWN = MetaField.booleanBuilder("IS_TEARING_DOWN")
        .defaultValue(false)
        .versionRange(769, 2147483647, 18, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> HOME_POS = MetaField.builder("HOME_POS")
        .versionRange(769, 2147483647, 19, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Creaking() {
        }
    }

    /**
     * Meta field constants for Salmon.
     */
    public static final class Salmon {
        public static final MetaField<Integer> TYPE = MetaField.intBuilder("TYPE")
        .defaultValue(0)
        .versionRange(768, 768, 17, EntityDataTypes.STRING)
        .versionRange(769, 2147483647, 17, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> FROM_BUCKET = MetaField.booleanBuilder("FROM_BUCKET")
        .defaultValue(false)
        .versionRange(498, 498, 14, EntityDataTypes.BOOLEAN)
        .versionRange(573, 751, 15, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Salmon() {
        }
    }

    /**
     * Meta field constants for Experience Orb.
     */
    public static final class ExperienceOrb {
        public static final MetaField<Integer> VALUE = MetaField.intBuilder("VALUE")
        .defaultValue(0)
        .versionRange(770, 2147483647, 8, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private ExperienceOrb() {
        }
    }

    /**
     * Meta field constants for Chicken.
     */
    public static final class Chicken {
        public static final MetaField<Object> VARIANT = MetaField.builder("VARIANT")
        .versionRange(770, 773, 17, EntityDataTypes.INT)
        .versionRange(774, 2147483647, 18, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SOUND_VARIANT = MetaField.builder("SOUND_VARIANT")
        .versionRange(774, 2147483647, 19, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> BABY = MetaField.booleanBuilder("BABY")
        .defaultValue(false)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> AGE_LOCKED = MetaField.booleanBuilder("AGE_LOCKED")
        .defaultValue(false)
        .versionRange(774, 2147483647, 17, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Chicken() {
        }
    }

    /**
     * Meta field constants for Cow.
     */
    public static final class Cow {
        public static final MetaField<Object> VARIANT = MetaField.builder("VARIANT")
        .versionRange(770, 773, 17, EntityDataTypes.INT)
        .versionRange(774, 2147483647, 18, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SOUND_VARIANT = MetaField.builder("SOUND_VARIANT")
        .versionRange(774, 2147483647, 19, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> BABY = MetaField.booleanBuilder("BABY")
        .defaultValue(false)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> AGE_LOCKED = MetaField.booleanBuilder("AGE_LOCKED")
        .defaultValue(false)
        .versionRange(774, 2147483647, 17, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Cow() {
        }
    }

    /**
     * Meta field constants for Hanging Entity.
     */
    public static final class HangingEntity {
        public static final MetaField<Object> DIRECTION = MetaField.builder("DIRECTION")
        .versionRange(771, 2147483647, 8, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private HangingEntity() {
        }
    }

    /**
     * Meta field constants for Happy Ghast.
     */
    public static final class HappyGhast {
        public static final MetaField<Boolean> IS_LEASH_HOLDER = MetaField.booleanBuilder("IS_LEASH_HOLDER")
        .defaultValue(false)
        .versionRange(771, 773, 17, EntityDataTypes.BOOLEAN)
        .versionRange(774, 2147483647, 18, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> STAYS_STILL = MetaField.booleanBuilder("STAYS_STILL")
        .defaultValue(false)
        .versionRange(771, 773, 18, EntityDataTypes.BOOLEAN)
        .versionRange(774, 2147483647, 19, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> BABY = MetaField.booleanBuilder("BABY")
        .defaultValue(false)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> AGE_LOCKED = MetaField.booleanBuilder("AGE_LOCKED")
        .defaultValue(false)
        .versionRange(774, 2147483647, 17, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private HappyGhast() {
        }
    }

    /**
     * Meta field constants for Avatar.
     */
    public static final class Avatar {
        public static final MetaField<Object> PLAYER_MAIN_HAND = MetaField.builder("PLAYER_MAIN_HAND")
        .versionRange(772, 772, 15, EntityDataTypes.BYTE)
        .versionRange(773, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> PLAYER_MODE_CUSTOMISATION = MetaField.byteBuilder("PLAYER_MODE_CUSTOMISATION")
        .defaultValue((byte) 0)
        .versionRange(772, 2147483647, 16, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Avatar() {
        }
    }

    /**
     * Meta field constants for Mannequin.
     */
    public static final class Mannequin {
        public static final MetaField<Object> PROFILE = MetaField.builder("PROFILE")
        .versionRange(772, 2147483647, 17, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Boolean> IMMOVABLE = MetaField.booleanBuilder("IMMOVABLE")
        .defaultValue(false)
        .versionRange(772, 2147483647, 18, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> DESCRIPTION = MetaField.builder("DESCRIPTION")
        .versionRange(772, 2147483647, 19, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Object> PLAYER_MAIN_HAND = MetaField.builder("PLAYER_MAIN_HAND")
        .versionRange(772, 772, 15, EntityDataTypes.BYTE)
        .versionRange(773, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> PLAYER_MODE_CUSTOMISATION = MetaField.byteBuilder("PLAYER_MODE_CUSTOMISATION")
        .defaultValue((byte) 0)
        .versionRange(772, 2147483647, 16, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Mannequin() {
        }
    }

    /**
     * Meta field constants for Copper Golem.
     */
    public static final class CopperGolem {
        public static final MetaField<Object> WEATHER_STATE = MetaField.builder("WEATHER_STATE")
        .versionRange(772, 2147483647, 16, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Object> COPPER_GOLEM_STATE = MetaField.builder("COPPER_GOLEM_STATE")
        .versionRange(772, 2147483647, 17, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private CopperGolem() {
        }
    }

    /**
     * Meta field constants for Abstract Nautilus.
     */
    public static final class AbstractNautilus {
        public static final MetaField<Boolean> DASH = MetaField.booleanBuilder("DASH")
        .defaultValue(false)
        .versionRange(773, 773, 19, EntityDataTypes.BOOLEAN)
        .versionRange(774, 2147483647, 20, EntityDataTypes.BOOLEAN)
        .build();

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

        public static final MetaField<Boolean> BABY = MetaField.booleanBuilder("BABY")
        .defaultValue(false)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> AGE_LOCKED = MetaField.booleanBuilder("AGE_LOCKED")
        .defaultValue(false)
        .versionRange(774, 2147483647, 17, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private AbstractNautilus() {
        }
    }

    /**
     * Meta field constants for Zombie Nautilus.
     */
    public static final class ZombieNautilus {
        public static final MetaField<Object> VARIANT = MetaField.builder("VARIANT")
        .versionRange(773, 773, 20, EntityDataTypes.INT)
        .versionRange(774, 2147483647, 21, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> DASH = MetaField.booleanBuilder("DASH")
        .defaultValue(false)
        .versionRange(773, 773, 19, EntityDataTypes.BOOLEAN)
        .versionRange(774, 2147483647, 20, EntityDataTypes.BOOLEAN)
        .build();

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

        public static final MetaField<Boolean> BABY = MetaField.booleanBuilder("BABY")
        .defaultValue(false)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> AGE_LOCKED = MetaField.booleanBuilder("AGE_LOCKED")
        .defaultValue(false)
        .versionRange(774, 2147483647, 17, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private ZombieNautilus() {
        }
    }

    /**
     * Meta field constants for Crafting Grid.
     */
    public static final class CraftingGrid {
        public static final MetaField<Integer> SIZE = MetaField.intBuilder("SIZE")
        .defaultValue(0)
        .versionRange(774, 2147483647, 8, EntityDataTypes.INT)
        .build();

        private CraftingGrid() {
        }
    }

    /**
     * Meta field constants for Hovering Item.
     */
    public static final class HoveringItem {
        public static final MetaField<Object> ITEM = MetaField.builder("ITEM")
        .versionRange(774, 2147483647, 8, EntityDataTypes.ITEMSTACK)
        .build();

        private HoveringItem() {
        }
    }

    /**
     * Meta field constants for Living Block.
     */
    public static final class LivingBlock {
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

        private LivingBlock() {
        }
    }

    /**
     * Meta field constants for Living Block Command.
     */
    public static final class LivingBlockCommand {
        public static final MetaField<Integer> TYPE = MetaField.intBuilder("TYPE")
        .defaultValue(0)
        .versionRange(774, 2147483647, 8, EntityDataTypes.INT)
        .build();

        public static final MetaField<Long> SPAWNTIME = MetaField.longBuilder("SPAWNTIME")
        .defaultValue(0L)
        .versionRange(774, 2147483647, 9, EntityDataTypes.LONG)
        .build();

        private LivingBlockCommand() {
        }
    }

    /**
     * Meta field constants for Tadpole.
     */
    public static final class Tadpole {
        public static final MetaField<Boolean> AGE_LOCKED = MetaField.booleanBuilder("AGE_LOCKED")
        .defaultValue(false)
        .versionRange(774, 2147483647, 17, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> FROM_BUCKET = MetaField.booleanBuilder("FROM_BUCKET")
        .defaultValue(false)
        .versionRange(498, 498, 14, EntityDataTypes.BOOLEAN)
        .versionRange(573, 751, 15, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private Tadpole() {
        }
    }

    /**
     * Meta field constants for Abstract Cube Mob.
     */
    public static final class AbstractCubeMob {
        public static final MetaField<Integer> ID_SIZE = MetaField.intBuilder("ID_SIZE")
        .defaultValue(0)
        .versionRange(776, 2147483647, 18, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> BABY = MetaField.booleanBuilder("BABY")
        .defaultValue(false)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> AGE_LOCKED = MetaField.booleanBuilder("AGE_LOCKED")
        .defaultValue(false)
        .versionRange(774, 2147483647, 17, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private AbstractCubeMob() {
        }
    }

    /**
     * Meta field constants for Sulfur Cube.
     */
    public static final class SulfurCube {
        public static final MetaField<Integer> MAX_FUSE = MetaField.intBuilder("MAX_FUSE")
        .defaultValue(0)
        .versionRange(776, 2147483647, 19, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> FROM_BUCKET = MetaField.booleanBuilder("FROM_BUCKET")
        .defaultValue(false)
        .versionRange(776, 2147483647, 20, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ID_SIZE = MetaField.intBuilder("ID_SIZE")
        .defaultValue(0)
        .versionRange(776, 2147483647, 18, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> BABY = MetaField.booleanBuilder("BABY")
        .defaultValue(false)
        .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> AGE_LOCKED = MetaField.booleanBuilder("AGE_LOCKED")
        .defaultValue(false)
        .versionRange(774, 2147483647, 17, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 498, 13, EntityDataTypes.BYTE)
        .versionRange(573, 751, 14, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Byte> LIVING_ENTITY_FLAGS = MetaField.byteBuilder("LIVING_ENTITY_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 751, 7, EntityDataTypes.BYTE)
        .versionRange(755, 2147483647, 8, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Float> HEALTH = MetaField.floatBuilder("HEALTH")
        .defaultValue(0.0f)
        .versionRange(498, 751, 8, EntityDataTypes.FLOAT)
        .versionRange(755, 2147483647, 9, EntityDataTypes.FLOAT)
        .build();

        public static final MetaField<Integer> EFFECT_COLOR = MetaField.intBuilder("EFFECT_COLOR")
        .defaultValue(0)
        .versionRange(498, 751, 9, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Boolean> EFFECT_AMBIENCE = MetaField.booleanBuilder("EFFECT_AMBIENCE")
        .defaultValue(false)
        .versionRange(498, 751, 10, EntityDataTypes.BOOLEAN)
        .versionRange(755, 2147483647, 11, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Integer> ARROW_COUNT = MetaField.intBuilder("ARROW_COUNT")
        .defaultValue(0)
        .versionRange(498, 751, 11, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 12, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> SLEEPING_POS = MetaField.builder("SLEEPING_POS")
        .versionRange(498, 498, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(573, 751, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .versionRange(755, 2147483647, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
        .build();

        public static final MetaField<Integer> STINGER_COUNT = MetaField.intBuilder("STINGER_COUNT")
        .defaultValue(0)
        .versionRange(573, 751, 12, EntityDataTypes.INT)
        .versionRange(755, 2147483647, 13, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> EFFECT_PARTICLES = MetaField.builder("EFFECT_PARTICLES")
        .versionRange(766, 2147483647, 10, EntityDataTypes.INT)
        .build();

        public static final MetaField<Byte> SHARED_FLAGS = MetaField.byteBuilder("SHARED_FLAGS")
        .defaultValue((byte) 0)
        .versionRange(498, 2147483647, 0, EntityDataTypes.BYTE)
        .build();

        public static final MetaField<Integer> AIR_SUPPLY = MetaField.intBuilder("AIR_SUPPLY")
        .defaultValue(0)
        .versionRange(498, 2147483647, 1, EntityDataTypes.INT)
        .build();

        public static final MetaField<Object> CUSTOM_NAME = MetaField.builder("CUSTOM_NAME")
        .versionRange(498, 2147483647, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
        .build();

        public static final MetaField<Boolean> CUSTOM_NAME_VISIBLE = MetaField.booleanBuilder("CUSTOM_NAME_VISIBLE")
        .defaultValue(false)
        .versionRange(498, 2147483647, 3, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> SILENT = MetaField.booleanBuilder("SILENT")
        .defaultValue(false)
        .versionRange(498, 2147483647, 4, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Boolean> NO_GRAVITY = MetaField.booleanBuilder("NO_GRAVITY")
        .defaultValue(false)
        .versionRange(498, 2147483647, 5, EntityDataTypes.BOOLEAN)
        .build();

        public static final MetaField<Object> POSE = MetaField.builder("POSE")
        .versionRange(498, 2147483647, 6, EntityDataTypes.ENTITY_POSE)
        .build();

        public static final MetaField<Integer> TICKS_FROZEN = MetaField.intBuilder("TICKS_FROZEN")
        .defaultValue(0)
        .versionRange(755, 2147483647, 7, EntityDataTypes.INT)
        .build();

        private SulfurCube() {
        }
    }
}
