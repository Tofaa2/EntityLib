package me.tofaa.entitylib.meta.other;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.item.ItemStack;
import me.tofaa.entitylib.extras.Rotation;
import me.tofaa.entitylib.meta.EntityMeta;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.ObjectData;
import org.jetbrains.annotations.NotNull;

public class ItemFrameMeta extends EntityMeta implements ObjectData {

    public static final byte OFFSET = EntityMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 2;

    private Orientation orientation = Orientation.DOWN;

    public ItemFrameMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    @NotNull
    public ItemStack getItem() {
        return super.metadata.getIndex(OFFSET, ItemStack.EMPTY);
    }

    public void setItem(@NotNull ItemStack value) {
        super.metadata.setIndex(OFFSET, EntityDataTypes.ITEMSTACK, value);
    }

    @NotNull
    public Rotation getRotation() {
        return Rotation.values()[super.metadata.getIndex(offset(OFFSET, 1), 0)];
    }

    public void setRotation(@NotNull Rotation value) {
        super.metadata.setIndex(offset(OFFSET, 1), EntityDataTypes.INT, value.ordinal());
    }

    @NotNull
    public Orientation getOrientation() {
        return this.orientation;
    }

    /**
     * Sets orientation of the item frame.
     * This is possible only before spawn packet is sent.
     *
     * @param orientation the orientation of the item frame.
     */
    public void setOrientation(@NotNull Orientation orientation) {
        this.orientation = orientation;
    }

    @Override
    public int getObjectData() {
        return this.orientation.ordinal();
    }

    @Override
    public boolean requiresVelocityPacketAtSpawn() {
        return false;
    }

    public enum Orientation {
        DOWN,
        UP,
        NORTH,
        SOUTH,
        WEST,
        EAST
    }

}
