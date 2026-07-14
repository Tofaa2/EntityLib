package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Vehicle Entity.
 */
public final class VehicleEntityMetaFields {
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

    private VehicleEntityMetaFields() {
    }
}
