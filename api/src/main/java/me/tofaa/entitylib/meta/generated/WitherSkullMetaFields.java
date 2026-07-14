package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Wither Skull.
 */
public final class WitherSkullMetaFields {
    public static final MetaField<Boolean> DANGEROUS = MetaField.booleanBuilder("DANGEROUS")
    .defaultValue(false)
    .versionRange(498, 751, 7, EntityDataTypes.BOOLEAN)
    .versionRange(755, 2147483647, 8, EntityDataTypes.BOOLEAN)
    .build();

    private WitherSkullMetaFields() {
    }
}
