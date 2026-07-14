package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Armor Stand.
 */
public final class ArmorStandMetaFields {
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

    private ArmorStandMetaFields() {
    }
}
