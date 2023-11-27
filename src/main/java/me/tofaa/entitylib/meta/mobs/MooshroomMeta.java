package me.tofaa.entitylib.meta.mobs;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.Metadata;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;

public class MooshroomMeta extends CowMeta{

    public static final byte OFFSET = CowMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 1;

    public MooshroomMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    @NotNull
    public Variant getVariant() {
        return Variant.valueOf(super.metadata.getIndex(OFFSET, "red").toUpperCase(Locale.ROOT));
    }

    public void setVariant(@NotNull Variant value) {
        super.metadata.setIndex(OFFSET, EntityDataTypes.STRING, value.name().toLowerCase(Locale.ROOT));
    }

    public enum Variant {
        RED,
        BROWN
    }


}
