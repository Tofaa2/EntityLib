package me.tofaa.entitylib.meta.display;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.Metadata;
import net.kyori.adventure.text.Component;

public class TextDisplayMeta extends AbstractDisplayMeta {

    public static final byte OFFSET = AbstractDisplayMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = offset(OFFSET, 5);

    private static final byte SHADOW = 1;
    private static final byte SEE_THROUGH = 2;
    private static final byte USE_DEFAULT_BACKGROUND = 4;
    private static final byte ALIGN_LEFT = 8;
    private static final byte ALIGN_RIGHT = 16;

    public TextDisplayMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }


    public Component getText() {
        return metadata.getIndex(OFFSET, Component.empty());
    }

    public void setText(Component component) {
        metadata.setIndex(OFFSET, EntityDataTypes.ADV_COMPONENT, component);
    }

    public int getLineWidth() {
        return metadata.getIndex(offset(OFFSET, 1), 200);
    }

    public void setLineWidth(int value) {
        metadata.setIndex(offset(OFFSET, 1), EntityDataTypes.INT, value);
    }

    public int getBackgroundColor() {
        return metadata.getIndex(offset(OFFSET, 2), 0);
    }

    public void setBackgroundColor(int value) {
        metadata.setIndex(offset(OFFSET, 2), EntityDataTypes.INT, value);
    }

    public byte getTextOpacity() {
        return metadata.getIndex(offset(OFFSET, 3), (byte) -1);
    }

    public void setTextOpacity(byte value) {
        metadata.setIndex(offset(OFFSET, 3), EntityDataTypes.BYTE, value);
    }

    public boolean isShadow() {
        return getMaskBit(offset(OFFSET, 4), SHADOW);
    }

    public void setShadow(boolean value) {
        setMaskBit(offset(OFFSET, 4), SHADOW, value);
    }

    public boolean isSeeThrough() {
        return getMaskBit(offset(OFFSET, 4), SEE_THROUGH);
    }

    public void setSeeThrough(boolean value) {
        setMaskBit(offset(OFFSET, 4), SEE_THROUGH, value);
    }

    public boolean isUseDefaultBackground() {
        return getMaskBit(offset(OFFSET, 4), USE_DEFAULT_BACKGROUND);
    }

    public void setUseDefaultBackground(boolean value) {
        setMaskBit(offset(OFFSET, 4), USE_DEFAULT_BACKGROUND, value);
    }

    public boolean isAlignLeft() {
        return getMaskBit(offset(OFFSET, 4), ALIGN_LEFT);
    }

    public void setAlignLeft(boolean value) {
        setMaskBit(OFFSET + 4, ALIGN_LEFT, value);
    }

    public boolean isAlignRight() {
        return getMaskBit(offset(OFFSET, 4), ALIGN_RIGHT);
    }

    public void setAlignRight(boolean value) {
        setMaskBit(offset(OFFSET, 4), ALIGN_RIGHT, value);
    }
}
