package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Frog.
 */
public final class FrogMetaFields {
    public static final MetaField<Object> VARIANT = MetaField.builder("VARIANT")
    .versionRange(759, 765, 17, EntityDataTypes.BYTE)
    .versionRange(766, 773, 17, EntityDataTypes.INT)
    .versionRange(774, 2147483647, 18, EntityDataTypes.INT)
    .build();

    public static final MetaField<Object> TONGUE_TARGET = MetaField.builder("TONGUE_TARGET")
    .versionRange(759, 773, 18, EntityDataTypes.OPTIONAL_INT)
    .versionRange(774, 2147483647, 19, EntityDataTypes.OPTIONAL_INT)
    .build();

    private FrogMetaFields() {
    }
}
