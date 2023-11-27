package me.tofaa.entitylib.meta.mobs.tameable;

import com.github.retrooper.packetevents.manager.server.ServerVersion;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.TameableMeta;
import org.jetbrains.annotations.NotNull;

public class ParrotMeta extends TameableMeta {

    public static final byte OFFSET = TameableMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 1;

    public ParrotMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
        isVersionNewer(ServerVersion.V_1_14);
    }

    @NotNull
    public Color getColor() {
        return Color.VALUES[super.metadata.getIndex(OFFSET, 0)];
    }

    public void setColor(@NotNull Color value) {
        super.metadata.setIndex(OFFSET, EntityDataTypes.INT, value.ordinal());
    }

    public enum Color {
        RED_BLUE,
        BLUE,
        GREEN,
        YELLOW_BLUE,
        GREY;

        private final static Color[] VALUES = values();
    }

}
