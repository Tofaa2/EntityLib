package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Avatar.
 */
public final class AvatarMetaFields {
    public static final MetaField<Object> PLAYER_MAIN_HAND = MetaField.builder("PLAYER_MAIN_HAND")
    .versionRange(772, 772, 15, EntityDataTypes.BYTE)
    .versionRange(773, 2147483647, 15, EntityDataTypes.BYTE)
    .build();

    public static final MetaField<Byte> PLAYER_MODE_CUSTOMISATION = MetaField.byteBuilder("PLAYER_MODE_CUSTOMISATION")
    .defaultValue((byte) 0)
    .versionRange(772, 2147483647, 16, EntityDataTypes.BYTE)
    .build();

    private AvatarMetaFields() {
    }
}
