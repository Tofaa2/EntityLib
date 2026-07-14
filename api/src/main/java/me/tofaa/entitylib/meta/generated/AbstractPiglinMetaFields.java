package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Abstract Piglin.
 */
public final class AbstractPiglinMetaFields {
    public static final MetaField<Boolean> IMMUNE_TO_ZOMBIFICATION = MetaField.booleanBuilder("IMMUNE_TO_ZOMBIFICATION")
    .defaultValue(false)
    .versionRange(751, 751, 15, EntityDataTypes.BOOLEAN)
    .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
    .build();

    private AbstractPiglinMetaFields() {
    }
}
