package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.manager.server.ServerVersion;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.nbt.NBTCompound;
import me.tofaa.entitylib.meta.Metadata;
import org.jetbrains.annotations.Nullable;

public class PlayerMeta extends AvatarMeta {

    public static final byte OFFSET = AvatarMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 4;

    public PlayerMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    public float getAdditionalHearts() {
        return super.metadata.getIndex(OFFSET, 0F);
    }

    public void setAdditionalHearts(float value) {
        super.metadata.setIndex(OFFSET, EntityDataTypes.FLOAT, value);
    }

    public int getScore() {
        return super.metadata.getIndex(offset(OFFSET, 1), 0);
    }

    public void setScore(int value) {
        super.metadata.setIndex(offset(OFFSET, 1), EntityDataTypes.INT, value);
    }

    public @Nullable NBTCompound getLeftShoulderData() {
        isVersionNewer(ServerVersion.V_1_11);
        return super.metadata.getIndex(offset(OFFSET, 2), null);
    }

    public void setLeftShoulderData(@Nullable NBTCompound value) {
        isVersionNewer(ServerVersion.V_1_11);
        super.metadata.setIndex(offset(OFFSET, 2), EntityDataTypes.NBT, value);
    }

    public @Nullable NBTCompound getRightShoulderData() {
        isVersionNewer(ServerVersion.V_1_11);
        return super.metadata.getIndex(offset(OFFSET, 3), null);
    }

    public void setRightShoulderData(@Nullable NBTCompound value) {
        isVersionNewer(ServerVersion.V_1_11);
        if (value == null) value = new NBTCompound();
        super.metadata.setIndex(offset(OFFSET, 3), EntityDataTypes.NBT, value);
    }
}
