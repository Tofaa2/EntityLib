package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Cow.
 */
public final class CowMetaFields {
    public static final MetaField<Object> VARIANT = MetaField.builder("VARIANT")
    .versionRange(770, 773, 17, EntityDataTypes.INT)
    .versionRange(774, 2147483647, 18, EntityDataTypes.INT)
    .build();

    public static final MetaField<Object> SOUND_VARIANT = MetaField.builder("SOUND_VARIANT")
    .versionRange(774, 2147483647, 19, EntityDataTypes.INT)
    .build();

    private CowMetaFields() {
    }
}
