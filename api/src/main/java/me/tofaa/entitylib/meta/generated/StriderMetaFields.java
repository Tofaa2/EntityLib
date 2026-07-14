package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Strider.
 */
public final class StriderMetaFields {
    public static final MetaField<Integer> BOOST_TIME = MetaField.intBuilder("BOOST_TIME")
    .defaultValue(0)
    .versionRange(735, 751, 16, EntityDataTypes.INT)
    .versionRange(755, 773, 17, EntityDataTypes.INT)
    .versionRange(774, 2147483647, 18, EntityDataTypes.INT)
    .build();

    public static final MetaField<Boolean> SUFFOCATING = MetaField.booleanBuilder("SUFFOCATING")
    .defaultValue(false)
    .versionRange(735, 751, 17, EntityDataTypes.BOOLEAN)
    .versionRange(755, 773, 18, EntityDataTypes.BOOLEAN)
    .versionRange(774, 2147483647, 19, EntityDataTypes.BOOLEAN)
    .build();

    public static final MetaField<Boolean> SADDLE = MetaField.booleanBuilder("SADDLE")
    .defaultValue(false)
    .versionRange(735, 751, 18, EntityDataTypes.BOOLEAN)
    .versionRange(755, 2147483647, 19, EntityDataTypes.BOOLEAN)
    .build();

    private StriderMetaFields() {
    }
}
