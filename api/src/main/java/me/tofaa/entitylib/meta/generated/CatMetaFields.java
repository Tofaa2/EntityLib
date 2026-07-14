package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Cat.
 */
public final class CatMetaFields {
    public static final MetaField<Integer> TYPE = MetaField.intBuilder("TYPE")
    .defaultValue(0)
    .versionRange(498, 498, 17, EntityDataTypes.INT)
    .versionRange(573, 751, 18, EntityDataTypes.INT)
    .versionRange(755, 2147483647, 19, EntityDataTypes.INT)
    .build();

    public static final MetaField<Boolean> IS_LYING = MetaField.booleanBuilder("IS_LYING")
    .defaultValue(false)
    .versionRange(498, 498, 18, EntityDataTypes.BOOLEAN)
    .versionRange(573, 751, 19, EntityDataTypes.BOOLEAN)
    .versionRange(755, 773, 20, EntityDataTypes.BOOLEAN)
    .versionRange(774, 2147483647, 21, EntityDataTypes.BOOLEAN)
    .build();

    public static final MetaField<Boolean> RELAX_STATE_ONE = MetaField.booleanBuilder("RELAX_STATE_ONE")
    .defaultValue(false)
    .versionRange(498, 498, 19, EntityDataTypes.BOOLEAN)
    .versionRange(573, 751, 20, EntityDataTypes.BOOLEAN)
    .versionRange(755, 773, 21, EntityDataTypes.BOOLEAN)
    .versionRange(774, 2147483647, 22, EntityDataTypes.BOOLEAN)
    .build();

    public static final MetaField<Integer> COLLAR_COLOR = MetaField.intBuilder("COLLAR_COLOR")
    .defaultValue(0)
    .versionRange(498, 498, 20, EntityDataTypes.INT)
    .versionRange(573, 751, 21, EntityDataTypes.INT)
    .versionRange(755, 773, 22, EntityDataTypes.INT)
    .versionRange(774, 2147483647, 23, EntityDataTypes.INT)
    .build();

    public static final MetaField<Object> VARIANT = MetaField.builder("VARIANT")
    .versionRange(759, 765, 19, EntityDataTypes.BYTE)
    .versionRange(766, 773, 19, EntityDataTypes.INT)
    .versionRange(774, 2147483647, 20, EntityDataTypes.INT)
    .build();

    public static final MetaField<Object> SOUND_VARIANT = MetaField.builder("SOUND_VARIANT")
    .versionRange(774, 2147483647, 24, EntityDataTypes.INT)
    .build();

    private CatMetaFields() {
    }
}
