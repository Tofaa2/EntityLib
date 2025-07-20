package me.tofaa.entitylib.meta.display;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.world.states.WrappedBlockState;
import me.tofaa.entitylib.meta.Metadata;

public class BlockDisplayMeta extends AbstractDisplayMeta {

    public static final byte OFFSET = AbstractDisplayMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = offset(OFFSET, 1);

    public BlockDisplayMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    public int getBlockId() {
        return super.metadata.getIndex(OFFSET, 0);
    }

    public void setBlockId(int blockId) {
        super.metadata.setIndex(OFFSET, EntityDataTypes.BLOCK_STATE, blockId);
    }

    public WrappedBlockState getBlockState() {
        return WrappedBlockState.getByGlobalId(PacketEvents.getAPI().getServerManager().getVersion().toClientVersion(), getBlockId());
    }

    public void setBlockState(WrappedBlockState blockState) {
        setBlockId(blockState.getGlobalId());
    }
}
