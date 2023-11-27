package me.tofaa.entitylib.meta.mobs.horse;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.Metadata;

public class LlamaMeta extends ChestedHorseMeta{

    public static final byte OFFSET = ChestedHorseMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 3;

    public LlamaMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    public int getStrength() {
        return super.metadata.getIndex(OFFSET, 0);
    }

    public void setStrength(int value) {
        super.metadata.setIndex(OFFSET, EntityDataTypes.INT, value);
    }

    public int getCarpetColor() {
        return super.metadata.getIndex(offset(OFFSET, 1), -1);
    }

    public void setCarpetColor(int value) {
        super.metadata.setIndex(offset(OFFSET, 1), EntityDataTypes.INT, value);
    }

    public Variant getVariant() {
        return Variant.VALUES[super.metadata.getIndex(offset(OFFSET, 2), 0)];
    }

    public void setVariant(Variant value) {
        super.metadata.setIndex(offset(OFFSET, 2), EntityDataTypes.INT, value.ordinal());
    }

    public enum Variant {
        CREAMY,
        WHITE,
        BROWN,
        GRAY;

        private final static Variant[] VALUES = values();
    }

}
