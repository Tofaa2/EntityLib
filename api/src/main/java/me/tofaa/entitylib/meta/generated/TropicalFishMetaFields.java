package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Tropical Fish.
 */
public final class TropicalFishMetaFields {
    public static final MetaField<Integer> TYPE_VARIANT = MetaField.intBuilder("TYPE_VARIANT")
    .defaultValue(0)
    .versionRange(498, 498, 15, EntityDataTypes.INT)
    .versionRange(573, 751, 16, EntityDataTypes.INT)
    .versionRange(755, 2147483647, 17, EntityDataTypes.INT)
    .build();

    private TropicalFishMetaFields() {
    }
}
