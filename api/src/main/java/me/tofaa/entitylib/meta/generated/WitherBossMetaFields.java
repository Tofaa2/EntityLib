package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Wither Boss.
 */
public final class WitherBossMetaFields {
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

    private WitherBossMetaFields() {
    }
}
