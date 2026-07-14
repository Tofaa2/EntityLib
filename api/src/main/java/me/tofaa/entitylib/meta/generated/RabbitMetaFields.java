package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Rabbit.
 */
public final class RabbitMetaFields {
    public static final MetaField<Integer> TYPE = MetaField.intBuilder("TYPE")
    .defaultValue(0)
    .versionRange(498, 498, 15, EntityDataTypes.INT)
    .versionRange(573, 751, 16, EntityDataTypes.INT)
    .versionRange(755, 773, 17, EntityDataTypes.INT)
    .versionRange(774, 2147483647, 18, EntityDataTypes.INT)
    .build();

    private RabbitMetaFields() {
    }
}
