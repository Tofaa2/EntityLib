package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Copper Golem.
 */
public final class CopperGolemMetaFields {
    public static final MetaField<Object> WEATHER_STATE = MetaField.builder("WEATHER_STATE")
    .versionRange(772, 2147483647, 16, EntityDataTypes.BYTE)
    .build();

    public static final MetaField<Object> COPPER_GOLEM_STATE = MetaField.builder("COPPER_GOLEM_STATE")
    .versionRange(772, 2147483647, 17, EntityDataTypes.BYTE)
    .build();

    private CopperGolemMetaFields() {
    }
}
