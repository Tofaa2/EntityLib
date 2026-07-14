package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Abstract Nautilus.
 */
public final class AbstractNautilusMetaFields {
    public static final MetaField<Boolean> DASH = MetaField.booleanBuilder("DASH")
    .defaultValue(false)
    .versionRange(773, 773, 19, EntityDataTypes.BOOLEAN)
    .versionRange(774, 2147483647, 20, EntityDataTypes.BOOLEAN)
    .build();

    private AbstractNautilusMetaFields() {
    }
}
