package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Minecart Furnace.
 */
public final class MinecartFurnaceMetaFields {
    public static final MetaField<Boolean> FUEL = MetaField.booleanBuilder("FUEL")
    .defaultValue(false)
    .versionRange(498, 751, 13, EntityDataTypes.BOOLEAN)
    .versionRange(755, 769, 14, EntityDataTypes.BOOLEAN)
    .versionRange(770, 2147483647, 13, EntityDataTypes.BOOLEAN)
    .build();

    private MinecartFurnaceMetaFields() {
    }
}
