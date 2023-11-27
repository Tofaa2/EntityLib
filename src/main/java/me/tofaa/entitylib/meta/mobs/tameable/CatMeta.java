package me.tofaa.entitylib.meta.mobs.tameable;

import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.TameableMeta;
import net.kyori.adventure.text.format.NamedTextColor;

public class CatMeta extends TameableMeta {

    public static final byte OFFSET = TameableMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 4;

    private static final NamedTextColor[] COLORS = new NamedTextColor[] {
        NamedTextColor.BLACK, NamedTextColor.RED, NamedTextColor.WHITE, NamedTextColor.YELLOW, NamedTextColor.GRAY,
        NamedTextColor.WHITE, 
    };

    public CatMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }


    public enum Variant {
        TABBY,
        BLACK,
        RED,
        SIAMESE,
        BRITISH_SHORTHAIR,
        CALICO,
        PERSIAN,
        RAGDOLL,
        WHITE,
        JELLIE,
        ALL_BLACK;

        private static final Variant[] VALUES = values();
    }

}
