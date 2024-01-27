package me.tofaa.entitylib.meta.projectile;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.Metadata;

public class ThrownTridentMeta extends BaseArrowMeta{

    public static final byte OFFSET = BaseArrowMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 2;

    public ThrownTridentMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    public int getLoyaltyLevel() {
        return super.metadata.getIndex(OFFSET, 0);
    }

    public void setLoyaltyLevel(int value) {
        super.metadata.setIndex(OFFSET, EntityDataTypes.INT, value);
    }

    public boolean isHasEnchantmentGlint() {
        return super.metadata.getIndex(offset(OFFSET,1), false);
    }

    public void setHasEnchantmentGlint(boolean value) {
        super.metadata.setIndex(offset(OFFSET,1), EntityDataTypes.BOOLEAN, value);
    }

}
