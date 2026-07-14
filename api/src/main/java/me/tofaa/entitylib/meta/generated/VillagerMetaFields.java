package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Villager.
 */
public final class VillagerMetaFields {
    public static final MetaField<Object> VILLAGER_DATA = MetaField.builder("VILLAGER_DATA")
    .versionRange(498, 498, 16, EntityDataTypes.BYTE)
    .versionRange(573, 751, 17, EntityDataTypes.BYTE)
    .versionRange(755, 773, 18, EntityDataTypes.BYTE)
    .versionRange(774, 2147483647, 19, EntityDataTypes.BYTE)
    .build();

    public static final MetaField<Boolean> VILLAGER_FINALIZED = MetaField.booleanBuilder("VILLAGER_FINALIZED")
    .defaultValue(false)
    .versionRange(774, 2147483647, 20, EntityDataTypes.BOOLEAN)
    .build();

    private VillagerMetaFields() {
    }
}
