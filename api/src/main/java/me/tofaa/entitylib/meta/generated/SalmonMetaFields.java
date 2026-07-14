package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Salmon.
 */
public final class SalmonMetaFields {
    public static final MetaField<Object> TYPE = MetaField.builder("TYPE")
    .versionRange(768, 768, 17, EntityDataTypes.STRING)
    .versionRange(769, 2147483647, 17, EntityDataTypes.INT)
    .build();

    private SalmonMetaFields() {
    }
}
