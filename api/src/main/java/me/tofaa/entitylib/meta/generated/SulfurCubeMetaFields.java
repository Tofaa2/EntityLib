package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Sulfur Cube.
 */
public final class SulfurCubeMetaFields {
    public static final MetaField<Integer> MAX_FUSE = MetaField.intBuilder("MAX_FUSE")
    .defaultValue(0)
    .versionRange(776, 2147483647, 19, EntityDataTypes.INT)
    .build();

    public static final MetaField<Boolean> FROM_BUCKET = MetaField.booleanBuilder("FROM_BUCKET")
    .defaultValue(false)
    .versionRange(776, 2147483647, 20, EntityDataTypes.BOOLEAN)
    .build();

    private SulfurCubeMetaFields() {
    }
}
