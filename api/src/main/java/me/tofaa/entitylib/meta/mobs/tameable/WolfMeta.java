package me.tofaa.entitylib.meta.mobs.tameable;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.entity.wolfvariant.WolfVariant;
import com.github.retrooper.packetevents.protocol.entity.wolfvariant.WolfVariants;
import me.tofaa.entitylib.extras.DyeColor;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.TameableMeta;
import org.jetbrains.annotations.NotNull;

public class WolfMeta extends TameableMeta {

    public static final byte OFFSET = TameableMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 5;

    public WolfMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    @NotNull
    public WolfVariant getVariant() {
        return super.metadata.getIndex(offset(OFFSET, 3), WolfVariants.PALE);
    }

    public void setVariant(@NotNull WolfVariant value) {
        super.metadata.setIndex(offset(OFFSET, 3), EntityDataTypes.TYPED_WOLF_VARIANT, value);
    }

    public boolean isBegging() {
        return super.metadata.getIndex(OFFSET, false);
    }

    public void setBegging(boolean value) {
        super.metadata.setIndex(OFFSET, EntityDataTypes.BOOLEAN, value);
    }

    public int getCollarColor() {
        return super.metadata.getIndex(offset(OFFSET, 1), 14);
    }

    public void setCollarColor(int value) {
        super.metadata.setIndex(offset(OFFSET, 1), EntityDataTypes.INT, value);
    }

    public DyeColor getCollarColorAsDye() {
        return DyeColor.values()[super.metadata.getIndex(offset(OFFSET, 1), DyeColor.RED.ordinal())];
    }

    public void setCollarColor(DyeColor color) {
        super.metadata.setIndex(offset(OFFSET, 1), EntityDataTypes.INT, color.ordinal());
    }

    public int getAngerTime() {
        return super.metadata.getIndex(offset(OFFSET, 2), 0);
    }

    public void setAngerTime(int value) {
        super.metadata.setIndex(offset(OFFSET, 2), EntityDataTypes.INT, value);
    }

}
