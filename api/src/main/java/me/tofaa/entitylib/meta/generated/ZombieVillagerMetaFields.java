package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Zombie Villager.
 */
public final class ZombieVillagerMetaFields {
    public static final MetaField<Boolean> CONVERTING = MetaField.booleanBuilder("CONVERTING")
    .defaultValue(false)
    .versionRange(498, 498, 17, EntityDataTypes.BOOLEAN)
    .versionRange(573, 751, 18, EntityDataTypes.BOOLEAN)
    .versionRange(755, 2147483647, 19, EntityDataTypes.BOOLEAN)
    .build();

    public static final MetaField<Object> VILLAGER_DATA = MetaField.builder("VILLAGER_DATA")
    .versionRange(498, 498, 18, EntityDataTypes.BYTE)
    .versionRange(573, 751, 19, EntityDataTypes.BYTE)
    .versionRange(755, 2147483647, 20, EntityDataTypes.BYTE)
    .build();

    public static final MetaField<Boolean> VILLAGER_FINALIZED = MetaField.booleanBuilder("VILLAGER_FINALIZED")
    .defaultValue(false)
    .versionRange(774, 2147483647, 21, EntityDataTypes.BOOLEAN)
    .build();

    private ZombieVillagerMetaFields() {
    }
}
