package me.tofaa.entitylib.meta.mobs.water;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.WaterMobMeta;

public class AxolotlMeta extends WaterMobMeta {

    public static final byte OFFSET = WaterMobMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 3;

    public AxolotlMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    public Variant getVariant() {
        return Variant.VALUES[super.metadata.getIndex(OFFSET, 0)];
    }

    public void setVariant(Variant variant) {
        metadata.setIndex(OFFSET, EntityDataTypes.INT, variant.ordinal());
    }

    public boolean isPlayingDead() {
        return metadata.getIndex(offset(OFFSET, 1), false);
    }

    public void setPlayingDead(boolean playingDead) {
        metadata.setIndex(offset(OFFSET, 1), EntityDataTypes.BOOLEAN, playingDead);
    }

    public boolean isFromBucket() {
        return metadata.getIndex(offset(OFFSET, 2), false);
    }

    public void setFromBucket(boolean fromBucket) {
        metadata.setIndex(offset(OFFSET, 2), EntityDataTypes.BOOLEAN, fromBucket);
    }

    public enum Variant {
        LUCY,
        WILD,
        GOLD,
        CYAN,
        BLUE;

        private final static AxolotlMeta.Variant[] VALUES = values();
    }

}
