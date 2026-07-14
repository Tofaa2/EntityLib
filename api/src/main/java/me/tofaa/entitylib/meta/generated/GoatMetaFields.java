package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Goat.
 */
public final class GoatMetaFields {
    public static final MetaField<Boolean> IS_SCREAMING_GOAT = MetaField.booleanBuilder("IS_SCREAMING_GOAT")
    .defaultValue(false)
    .versionRange(755, 773, 17, EntityDataTypes.BOOLEAN)
    .versionRange(774, 2147483647, 18, EntityDataTypes.BOOLEAN)
    .build();

    public static final MetaField<Boolean> HAS_LEFT_HORN = MetaField.booleanBuilder("HAS_LEFT_HORN")
    .defaultValue(false)
    .versionRange(759, 773, 18, EntityDataTypes.BOOLEAN)
    .versionRange(774, 2147483647, 19, EntityDataTypes.BOOLEAN)
    .build();

    public static final MetaField<Boolean> HAS_RIGHT_HORN = MetaField.booleanBuilder("HAS_RIGHT_HORN")
    .defaultValue(false)
    .versionRange(759, 773, 19, EntityDataTypes.BOOLEAN)
    .versionRange(774, 2147483647, 20, EntityDataTypes.BOOLEAN)
    .build();

    private GoatMetaFields() {
    }
}
