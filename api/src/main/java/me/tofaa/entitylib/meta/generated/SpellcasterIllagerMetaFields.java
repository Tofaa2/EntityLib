package me.tofaa.entitylib.meta.generated;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.MetaField;

/**
 * Generated meta field constants for Spellcaster Illager.
 */
public final class SpellcasterIllagerMetaFields {
    public static final MetaField<Byte> SPELL_CASTING = MetaField.byteBuilder("SPELL_CASTING")
    .defaultValue((byte) 0)
    .versionRange(498, 498, 15, EntityDataTypes.BYTE)
    .versionRange(573, 751, 16, EntityDataTypes.BYTE)
    .versionRange(755, 2147483647, 17, EntityDataTypes.BYTE)
    .build();

    private SpellcasterIllagerMetaFields() {
    }
}
