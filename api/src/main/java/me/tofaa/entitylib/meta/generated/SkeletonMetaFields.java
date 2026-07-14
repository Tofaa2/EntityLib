package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Skeleton.
 */
public final class SkeletonMetaFields {
    public static final MetaField<Boolean> STRAY_CONVERSION = MetaField.booleanBuilder("STRAY_CONVERSION")
    .defaultValue(false)
    .versionRange(755, 2147483647, 16, EntityDataTypes.BOOLEAN)
    .build();

    private SkeletonMetaFields() {
    }
}
