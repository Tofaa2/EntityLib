package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Mob.
 */
public final class MobMetaFields {
    public static final MetaField<Byte> MOB_FLAGS = MetaField.byteBuilder("MOB_FLAGS")
    .defaultValue((byte) 0)
    .versionRange(498, 498, 13, EntityDataTypes.BYTE)
    .versionRange(573, 751, 14, EntityDataTypes.BYTE)
    .versionRange(755, 2147483647, 15, EntityDataTypes.BYTE)
    .build();

    private MobMetaFields() {
    }
}
