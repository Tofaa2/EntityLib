package me.tofaa.entitylib.meta.mobs.tameable;

import com.github.retrooper.packetevents.protocol.entity.cat.CatVariant;
import com.github.retrooper.packetevents.protocol.entity.cat.CatVariants;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.extras.DyeColor;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.TameableMeta;

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
        final CatVariant catVariant = super.metadata.getIndex(OFFSET, CatVariants.BLACK);
        return Variant.fromCatVariant(catVariant);
    }

    public void setVariant(@NotNull CatMeta.Variant value) {
        super.metadata.setIndex(OFFSET, EntityDataTypes.TYPED_CAT_VARIANT, value.getCatVariant());
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
        ALL_BLACK(CatVariants.ALL_BLACK),
        BLACK(CatVariants.BLACK),
        BRITISH_SHORTHAIR(CatVariants.BRITISH_SHORTHAIR),
        CALICO(CatVariants.CALICO),
        JELLIE(CatVariants.JELLIE),
        PERSIAN(CatVariants.PERSIAN),
        RAGDOLL(CatVariants.RAGDOLL),
        RED(CatVariants.RED),
        SIAMESE(CatVariants.SIAMESE),
        TABBY(CatVariants.TABBY),
        WHITE(CatVariants.WHITE);

        private final CatVariant catVariant;

        Variant(final CatVariant catVariant) {
            this.catVariant = catVariant;
        }

        private static final Variant[] VALUES = values();

        public CatVariant getCatVariant() {
            return catVariant;
        }

        @NotNull
        public static Variant fromCatVariant(@NotNull final CatVariant catVariant) {
            for (final Variant variant : VALUES) {
                if (variant.getCatVariant().equals(catVariant)) {
                    return variant;
                }
            }
            return BLACK;
        }
    }

}
