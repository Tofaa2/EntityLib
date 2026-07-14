package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Abstract Villager.
 */
public final class AbstractVillagerMetaFields {
    public static final MetaField<Integer> UNHAPPY_COUNTER = MetaField.intBuilder("UNHAPPY_COUNTER")
    .defaultValue(0)
    .versionRange(498, 498, 15, EntityDataTypes.INT)
    .versionRange(573, 751, 16, EntityDataTypes.INT)
    .versionRange(755, 773, 17, EntityDataTypes.INT)
    .versionRange(774, 2147483647, 18, EntityDataTypes.INT)
    .build();

    private AbstractVillagerMetaFields() {
    }
}
