package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Mannequin.
 */
public final class MannequinMetaFields {
    public static final MetaField<Object> PROFILE = MetaField.builder("PROFILE")
    .versionRange(772, 2147483647, 17, EntityDataTypes.BYTE)
    .build();

    public static final MetaField<Boolean> IMMOVABLE = MetaField.booleanBuilder("IMMOVABLE")
    .defaultValue(false)
    .versionRange(772, 2147483647, 18, EntityDataTypes.BOOLEAN)
    .build();

    public static final MetaField<Object> DESCRIPTION = MetaField.builder("DESCRIPTION")
    .versionRange(772, 2147483647, 19, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
    .build();

    private MannequinMetaFields() {
    }
}
