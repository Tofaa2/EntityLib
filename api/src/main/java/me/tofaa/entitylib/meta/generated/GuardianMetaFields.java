package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Guardian.
 */
public final class GuardianMetaFields {
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

    private GuardianMetaFields() {
    }
}
