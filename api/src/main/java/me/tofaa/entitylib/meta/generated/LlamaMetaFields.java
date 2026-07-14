package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Llama.
 */
public final class LlamaMetaFields {
    public static final MetaField<Integer> STRENGTH = MetaField.intBuilder("STRENGTH")
    .defaultValue(0)
    .versionRange(498, 498, 18, EntityDataTypes.INT)
    .versionRange(573, 751, 19, EntityDataTypes.INT)
    .versionRange(755, 761, 20, EntityDataTypes.INT)
    .versionRange(762, 773, 19, EntityDataTypes.INT)
    .versionRange(774, 2147483647, 20, EntityDataTypes.INT)
    .build();

    public static final MetaField<Integer> SWAG = MetaField.intBuilder("SWAG")
    .defaultValue(0)
    .versionRange(498, 498, 19, EntityDataTypes.INT)
    .versionRange(573, 751, 20, EntityDataTypes.INT)
    .versionRange(755, 761, 21, EntityDataTypes.INT)
    .versionRange(762, 2147483647, 20, EntityDataTypes.INT)
    .build();

    public static final MetaField<Integer> VARIANT = MetaField.intBuilder("VARIANT")
    .defaultValue(0)
    .versionRange(498, 498, 20, EntityDataTypes.INT)
    .versionRange(573, 751, 21, EntityDataTypes.INT)
    .versionRange(755, 761, 22, EntityDataTypes.INT)
    .versionRange(762, 765, 21, EntityDataTypes.INT)
    .versionRange(766, 773, 20, EntityDataTypes.INT)
    .versionRange(774, 2147483647, 21, EntityDataTypes.INT)
    .build();

    private LlamaMetaFields() {
    }
}
