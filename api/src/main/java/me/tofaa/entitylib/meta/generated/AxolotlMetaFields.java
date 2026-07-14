package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Axolotl.
 */
public final class AxolotlMetaFields {
    public static final MetaField<Integer> VARIANT = MetaField.intBuilder("VARIANT")
    .defaultValue(0)
    .versionRange(755, 773, 17, EntityDataTypes.INT)
    .versionRange(774, 2147483647, 18, EntityDataTypes.INT)
    .build();

    public static final MetaField<Boolean> PLAYING_DEAD = MetaField.booleanBuilder("PLAYING_DEAD")
    .defaultValue(false)
    .versionRange(755, 773, 18, EntityDataTypes.BOOLEAN)
    .versionRange(774, 2147483647, 19, EntityDataTypes.BOOLEAN)
    .build();

    public static final MetaField<Boolean> FROM_BUCKET = MetaField.booleanBuilder("FROM_BUCKET")
    .defaultValue(false)
    .versionRange(755, 773, 19, EntityDataTypes.BOOLEAN)
    .versionRange(774, 2147483647, 20, EntityDataTypes.BOOLEAN)
    .build();

    private AxolotlMetaFields() {
    }
}
