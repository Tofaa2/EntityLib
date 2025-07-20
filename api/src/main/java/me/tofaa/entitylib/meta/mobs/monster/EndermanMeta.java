package me.tofaa.entitylib.meta.mobs.monster;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.world.states.WrappedBlockState;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.MobMeta;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class EndermanMeta extends MobMeta {

    public static final byte OFFSET = MobMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 3;

    public EndermanMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    public Integer getCarriedBlockID() {
        return super.metadata.getIndex(OFFSET, null);
    }

    public void setCarriedBlockID(@Nullable Integer value) {
        super.metadata.setIndex(OFFSET, EntityDataTypes.OPTIONAL_INT, Optional.ofNullable(value));
    }

    public WrappedBlockState getCarriedBlockState() {
        Integer carriedBlockID = getCarriedBlockID();
        if (carriedBlockID == null) return null;
        return WrappedBlockState.getByGlobalId(PacketEvents.getAPI().getServerManager().getVersion().toClientVersion(), carriedBlockID);
    }

    public void setCarriedBlockState(WrappedBlockState blockState) {
        setCarriedBlockID(blockState.getGlobalId());
    }

    public boolean isScreaming() {
        return super.metadata.getIndex(offset(OFFSET, 1), false);
    }

    public void setScreaming(boolean value) {
        super.metadata.setIndex(offset(OFFSET, 1), EntityDataTypes.BOOLEAN, value);
    }

    public boolean isStaring() {
        return super.metadata.getIndex(offset(OFFSET, 2), false);
    }

    public void setStaring(boolean value) {
        super.metadata.setIndex(offset(OFFSET, 2), EntityDataTypes.BOOLEAN, value);
    }


}
