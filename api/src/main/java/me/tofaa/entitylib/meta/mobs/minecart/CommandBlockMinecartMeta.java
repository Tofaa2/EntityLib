package me.tofaa.entitylib.meta.mobs.minecart;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.Metadata;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import org.jetbrains.annotations.NotNull;

public class CommandBlockMinecartMeta extends BaseMinecartMeta{

    public static final byte OFFSET = BaseMinecartMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 2;

    public CommandBlockMinecartMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    public @NotNull String getCommand() {
        return super.metadata.getIndex(OFFSET, "");
    }

    public void setCommand(@NotNull String value) {
        super.metadata.setIndex(OFFSET, EntityDataTypes.STRING, value);
    }

    public @NotNull Component getLastOutput() {
        return super.metadata.getIndex(offset(OFFSET, 1), Component.empty());
    }

    public void setLastOutput(@NotNull Component value) {
        super.metadata.setIndex(offset(OFFSET, 1), EntityDataTypes.COMPONENT, GsonComponentSerializer.gson().serialize(value));
    }

    @Override
    public int getObjectData() {
        return 6;
    }
}
