package me.tofaa.entitylib.meta.mobs;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.AgeableMeta;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class FrogMeta extends AgeableMeta {

    public static final byte OFFSET = AgeableMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 2;


    public FrogMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }


    public @NotNull Variant getVariant() {
        return super.metadata.getIndex(OFFSET, Variant.TEMPERATE);
    }

    public void setVariant(@NotNull Variant value) {
        super.metadata.setIndex(OFFSET, EntityDataTypes.FROG_VARIANT, value.ordinal());
    }

    public Optional<Integer> getTongueTarget() {
        return super.metadata.getIndex(offset(OFFSET, 1), Optional.empty());
    }

    public void setTongueTarget(int value) {
        super.metadata.setIndex(offset(OFFSET, 1), EntityDataTypes.OPTIONAL_INT, Optional.of(value));
    }


    public enum Variant {
        TEMPERATE,
        WARM,
        COLD;

        private final static FrogMeta.Variant[] VALUES = values();
    }

}
