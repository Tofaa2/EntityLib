package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Crafting Grid.
 */
public final class CraftingGridMetaFields {
    public static final MetaField<Integer> SIZE = MetaField.intBuilder("SIZE")
    .defaultValue(0)
    .versionRange(774, 2147483647, 8, EntityDataTypes.INT)
    .build();

    private CraftingGridMetaFields() {
    }
}
