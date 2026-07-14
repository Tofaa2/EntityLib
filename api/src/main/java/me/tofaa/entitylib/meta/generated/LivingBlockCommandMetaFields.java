package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Living Block Command.
 */
public final class LivingBlockCommandMetaFields {
    public static final MetaField<Integer> TYPE = MetaField.intBuilder("TYPE")
    .defaultValue(0)
    .versionRange(774, 2147483647, 8, EntityDataTypes.INT)
    .build();

    public static final MetaField<Long> SPAWNTIME = MetaField.longBuilder("SPAWNTIME")
    .defaultValue(0L)
    .versionRange(774, 2147483647, 9, EntityDataTypes.LONG)
    .build();

    private LivingBlockCommandMetaFields() {
    }
}
