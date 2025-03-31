package me.tofaa.entitylib.meta.mobs.golem;

import com.github.retrooper.packetevents.protocol.color.DyeColor;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.world.Direction;
import com.github.retrooper.packetevents.util.Vector3i;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.MobMeta;
import net.kyori.adventure.text.format.NamedTextColor;

import java.util.Optional;

public class ShulkerMeta extends MobMeta {

    public static final byte OFFSET = MobMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 1;

    private static final DyeColor[] DYE_COLORS = DyeColor.values();


    public ShulkerMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    public Direction getAttachFace() {
        return super.metadata.getIndex(OFFSET, Direction.DOWN);
    }

    public void setAttachFace(Direction value) {
        super.metadata.setIndex(OFFSET, EntityDataTypes.INT, value.ordinal());
    }

    public Optional<Vector3i> getAttachmentPosition() {
        return super.metadata.getIndex(offset(OFFSET, 1), Optional.empty());
    }

    public void setAttachmentPosition(Vector3i value) {
        super.metadata.setIndex(offset(OFFSET, 1), EntityDataTypes.OPTIONAL_BLOCK_POSITION, Optional.of(value));
    }

    public byte getShieldHeight() {
        return super.metadata.getIndex(offset(OFFSET, 1), (byte) 0);
    }

    public void setShieldHeight(byte value) {
        super.metadata.setIndex(offset(OFFSET, 1), EntityDataTypes.BYTE, value);
    }

    public byte getColor() {
        return super.metadata.getIndex(offset(OFFSET, 2), (byte) 16);
    }

    public DyeColor getColorEnum() {
        return DYE_COLORS[getColor()];
    }

    public void setColor(byte value) {
        super.metadata.setIndex(offset(OFFSET, 2), EntityDataTypes.BYTE, value);
    }

    public void setColor(DyeColor color) {
        setColor((byte)color.ordinal());
    }

}
