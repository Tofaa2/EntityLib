package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Interaction.
 */
public final class InteractionMetaFields {
    public static final MetaField<Float> WIDTH = MetaField.floatBuilder("WIDTH")
    .defaultValue(0.0f)
    .versionRange(762, 2147483647, 8, EntityDataTypes.FLOAT)
    .build();

    public static final MetaField<Float> HEIGHT = MetaField.floatBuilder("HEIGHT")
    .defaultValue(0.0f)
    .versionRange(762, 2147483647, 9, EntityDataTypes.FLOAT)
    .build();

    public static final MetaField<Boolean> RESPONSE = MetaField.booleanBuilder("RESPONSE")
    .defaultValue(false)
    .versionRange(762, 2147483647, 10, EntityDataTypes.BOOLEAN)
    .build();

    private InteractionMetaFields() {
    }
}
