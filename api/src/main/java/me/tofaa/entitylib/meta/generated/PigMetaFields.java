package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Pig.
 */
public final class PigMetaFields {
    public static final MetaField<Boolean> SADDLE = MetaField.booleanBuilder("SADDLE")
    .defaultValue(false)
    .versionRange(498, 498, 15, EntityDataTypes.BOOLEAN)
    .versionRange(573, 751, 16, EntityDataTypes.BOOLEAN)
    .versionRange(755, 2147483647, 17, EntityDataTypes.BOOLEAN)
    .build();

    public static final MetaField<Integer> BOOST_TIME = MetaField.intBuilder("BOOST_TIME")
    .defaultValue(0)
    .versionRange(498, 498, 16, EntityDataTypes.INT)
    .versionRange(573, 751, 17, EntityDataTypes.INT)
    .versionRange(755, 769, 18, EntityDataTypes.INT)
    .versionRange(770, 773, 17, EntityDataTypes.INT)
    .versionRange(774, 2147483647, 18, EntityDataTypes.INT)
    .build();

    public static final MetaField<Object> VARIANT = MetaField.builder("VARIANT")
    .versionRange(770, 773, 18, EntityDataTypes.INT)
    .versionRange(774, 2147483647, 19, EntityDataTypes.INT)
    .build();

    public static final MetaField<Object> SOUND_VARIANT = MetaField.builder("SOUND_VARIANT")
    .versionRange(774, 2147483647, 20, EntityDataTypes.INT)
    .build();

    private PigMetaFields() {
    }
}
