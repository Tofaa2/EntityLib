package me.tofaa.entitylib.meta.other;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.util.Vector3i;
import me.tofaa.entitylib.meta.EntityMeta;
import me.tofaa.entitylib.meta.Metadata;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class EndCrystalMeta extends EntityMeta {

    public static final byte OFFSET = EntityMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 2;

    public EndCrystalMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    public @Nullable Optional<Vector3i> getBeamTarget() {
        return super.metadata.getIndex(OFFSET, Optional.empty());
    }

    public void setBeamTarget(@Nullable Vector3i value) {
        super.metadata.setIndex(OFFSET, EntityDataTypes.OPTIONAL_BLOCK_POSITION, Optional.ofNullable(value));
    }

    public boolean isShowingBottom() {
        return super.metadata.getIndex(offset(OFFSET, 1), true);
    }

    public void setShowingBottom(boolean value) {
        super.metadata.setIndex(offset(OFFSET, 1), EntityDataTypes.BOOLEAN, value);
    }

}
