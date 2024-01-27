package me.tofaa.entitylib.meta.mobs.monster;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.MobMeta;
import org.jetbrains.annotations.NotNull;

public class CreeperMeta extends MobMeta {

    public static final byte OFFSET = MobMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 3;

    public CreeperMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    @NotNull
    public State getState() {
        int id = super.metadata.getIndex(OFFSET, -1);
        return id == -1 ? State.IDLE : State.FUSE;
    }

    public void setState(@NotNull State value) {
        super.metadata.setIndex(OFFSET, EntityDataTypes.INT, value == State.IDLE ? -1 : 1);
    }

    public boolean isCharged() {
        return super.metadata.getIndex(offset(OFFSET, 1), false);
    }

    public void setCharged(boolean value) {
        super.metadata.setIndex(offset(OFFSET, 1), EntityDataTypes.BOOLEAN, value);
    }

    public boolean isIgnited() {
        return super.metadata.getIndex(offset(OFFSET, 2), false);
    }

    public void setIgnited(boolean value) {
        super.metadata.setIndex(offset(OFFSET, 2), EntityDataTypes.BOOLEAN, value);
    }

    public enum State {
        IDLE,
        FUSE
    }


}
