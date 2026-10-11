package me.tofaa.entitylib.meta;

import com.github.retrooper.packetevents.protocol.entity.data.EntityData;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public abstract class MetaView {

    protected final Metadata metadata;

    protected MetaView(@NotNull Metadata metadata) {
        this.metadata = metadata;
    }

    public final @NotNull Metadata metadata() {
        return metadata;
    }

    public abstract int protocolVersion();

    public abstract @NotNull MetaClass metaClass();

    public @NotNull List<EntityData<?>> encode() {
        return metadata.encode(protocolVersion());
    }
}
