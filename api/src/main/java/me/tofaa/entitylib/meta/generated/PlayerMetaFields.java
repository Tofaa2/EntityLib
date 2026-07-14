package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Player.
 */
public final class PlayerMetaFields {
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

    private PlayerMetaFields() {
    }
}
