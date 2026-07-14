package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Glow Squid.
 */
public final class GlowSquidMetaFields {
    public static final MetaField<Integer> DARK_TICKS_REMAINING = MetaField.intBuilder("DARK_TICKS_REMAINING")
    .defaultValue(0)
    .versionRange(755, 767, 16, EntityDataTypes.INT)
    .versionRange(768, 773, 17, EntityDataTypes.INT)
    .versionRange(774, 2147483647, 18, EntityDataTypes.INT)
    .build();

    private GlowSquidMetaFields() {
    }
}
