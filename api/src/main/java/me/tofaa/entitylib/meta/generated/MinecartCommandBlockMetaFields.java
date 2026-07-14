package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Minecart Command Block.
 */
public final class MinecartCommandBlockMetaFields {
    public static final MetaField<String> COMMAND_NAME = MetaField.stringBuilder("COMMAND_NAME")
    .defaultValue("")
    .versionRange(498, 751, 13, EntityDataTypes.STRING)
    .versionRange(755, 769, 14, EntityDataTypes.STRING)
    .versionRange(770, 2147483647, 13, EntityDataTypes.STRING)
    .build();

    public static final MetaField<Object> LAST_OUTPUT = MetaField.builder("LAST_OUTPUT")
    .versionRange(498, 751, 14, EntityDataTypes.ADV_COMPONENT)
    .versionRange(755, 769, 15, EntityDataTypes.ADV_COMPONENT)
    .versionRange(770, 2147483647, 14, EntityDataTypes.ADV_COMPONENT)
    .build();

    private MinecartCommandBlockMetaFields() {
    }
}
