package me.tofaa.entitylib.meta.mobs.monster;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.MobMeta;

public class GuardianMeta extends MobMeta {

    public static final byte OFFSET = MobMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 2;

    private int target = -1;

    public GuardianMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    public boolean isRetractingSpikes() {
        return super.metadata.getIndex(OFFSET, false);
    }

    public void setRetractingSpikes(boolean retractingSpikes) {
        super.metadata.setIndex(OFFSET, EntityDataTypes.BOOLEAN, retractingSpikes);
    }

    public int getTarget() {
        return this.target;
    }

    public void setTarget(int target) {
        this.target = target;
        super.metadata.setIndex(offset(OFFSET, 1), EntityDataTypes.INT, target == -1 ? 0 : target);
    }


}
