package me.tofaa.entitylib.meta.mobs;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.AgeableMeta;
import org.jetbrains.annotations.NotNull;

public class RabbitMeta extends AgeableMeta {

    public static final byte OFFSET = AgeableMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 1;


    public RabbitMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    public @NotNull Type getType() {
        int id = super.metadata.getIndex(OFFSET, 0);
        if (id == 99) {
            return Type.KILLER_BUNNY;
        }
        return Type.VALUES[id];
    }

    public void setType(@NotNull Type value) {
        int id = value == Type.KILLER_BUNNY ? 99 : value.ordinal();
        super.metadata.setIndex(OFFSET, EntityDataTypes.INT, id);
    }


    public enum Type {
        BROWN,
        WHITE,
        BLACK,
        BLACK_AND_WHITE,
        GOLD,
        SALT_AND_PEPPER,
        KILLER_BUNNY;

        private final static Type[] VALUES = values();
    }



}
