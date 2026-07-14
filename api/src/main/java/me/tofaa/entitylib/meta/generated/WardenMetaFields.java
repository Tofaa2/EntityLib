package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Warden.
 */
public final class WardenMetaFields {
    public static final MetaField<Integer> CLIENT_ANGER_LEVEL = MetaField.intBuilder("CLIENT_ANGER_LEVEL")
    .defaultValue(0)
    .versionRange(759, 2147483647, 16, EntityDataTypes.INT)
    .build();

    private WardenMetaFields() {
    }
}
