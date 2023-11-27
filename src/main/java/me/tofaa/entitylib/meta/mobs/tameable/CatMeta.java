package me.tofaa.entitylib.meta.mobs.tameable;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import me.tofaa.entitylib.extras.DyeColor;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.TameableMeta;
import net.kyori.adventure.text.format.NamedTextColor;
import org.jetbrains.annotations.NotNull;

public class CatMeta extends TameableMeta {

    public static final byte OFFSET = TameableMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 4;

    private static final DyeColor[] COLORS = DyeColor.values();

    public CatMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    @NotNull
    public CatMeta.Variant getVariant() {
        return super.metadata.getIndex(OFFSET, Variant.BLACK);
    }

    public void setVariant(@NotNull CatMeta.Variant value) {
        super.metadata.setIndex(OFFSET, EntityDataTypes.CAT_VARIANT, value.ordinal());
    }

    public boolean isLying() {
        return super.metadata.getIndex(offset(OFFSET, 1), false);
    }

    public void setLying(boolean value) {
        super.metadata.setIndex(offset(OFFSET, 1), EntityDataTypes.BOOLEAN, value);
    }

    public boolean isRelaxed() {
        return super.metadata.getIndex(offset(OFFSET, 2), false);
    }

    public void setRelaxed(boolean value) {
        super.metadata.setIndex(offset(OFFSET, 2), EntityDataTypes.BOOLEAN, value);
    }

    public @NotNull DyeColor getCollarColor() {
        return COLORS[super.metadata.getIndex(offset(OFFSET, 3), DyeColor.RED.ordinal())];
    }

    public void setCollarColor(@NotNull DyeColor value) {
        super.metadata.setIndex(offset(OFFSET, 3), EntityDataTypes.INT, value.ordinal());
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
