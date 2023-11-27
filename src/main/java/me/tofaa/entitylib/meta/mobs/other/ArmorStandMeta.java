package me.tofaa.entitylib.meta.mobs.other;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.util.Vector3f;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.LivingEntityMeta;
import org.jetbrains.annotations.NotNull;

public class ArmorStandMeta extends LivingEntityMeta {

    public static final byte OFFSET = LivingEntityMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 7;

    private final static byte IS_SMALL_BIT = 0x01;
    private final static byte HAS_ARMS_BIT = 0x04;
    private final static byte HAS_NO_BASE_PLATE_BIT = 0x08;
    private final static byte IS_MARKER_BIT = 0x10;

    public ArmorStandMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    public boolean isSmall() {
        return getMaskBit(OFFSET, IS_SMALL_BIT);
    }

    public void setSmall(boolean value) {
        setMaskBit(OFFSET, IS_SMALL_BIT, value);
    }

    public boolean isHasArms() {
        return getMaskBit(OFFSET, HAS_ARMS_BIT);
    }

    public void setHasArms(boolean value) {
        setMaskBit(OFFSET, HAS_ARMS_BIT, value);
    }

    public boolean isHasNoBasePlate() {
        return getMaskBit(OFFSET, HAS_NO_BASE_PLATE_BIT);
    }

    public void setHasNoBasePlate(boolean value) {
        setMaskBit(OFFSET, HAS_NO_BASE_PLATE_BIT, value);
    }

    public boolean isMarker() {
        return getMaskBit(OFFSET, IS_MARKER_BIT);
    }

    public void setMarker(boolean value) {
        setMaskBit(OFFSET, IS_MARKER_BIT, value);
    }

    @NotNull
    public Vector3f getHeadRotation() {
        return super.metadata.getIndex(offset(OFFSET, 1), Vector3f.zero());
    }

    public void setHeadRotation(@NotNull Vector3f value) {
        super.metadata.setIndex(offset(OFFSET, 1), EntityDataTypes.ROTATION, value);
    }

    @NotNull
    public Vector3f getBodyRotation() {
        return super.metadata.getIndex(offset(OFFSET, 2), Vector3f.zero());
    }

    public void setBodyRotation(@NotNull Vector3f value) {
        super.metadata.setIndex(offset(OFFSET, 2), EntityDataTypes.ROTATION, value);
    }

    @NotNull
    public Vector3f getLeftArmRotation() {
        return super.metadata.getIndex(offset(OFFSET, 3), new Vector3f(-10f, 0f, -10f));
    }

    public void setLeftArmRotation(@NotNull Vector3f value) {
        super.metadata.setIndex(offset(OFFSET, 3), EntityDataTypes.ROTATION, value);
    }

    @NotNull
    public Vector3f getRightArmRotation() {
        return super.metadata.getIndex(offset(OFFSET, 4), new Vector3f(-15f, 0f, 10f));
    }

    public void setRightArmRotation(@NotNull Vector3f value) {
        super.metadata.setIndex(offset(OFFSET, 4), EntityDataTypes.ROTATION, value);
    }

    @NotNull
    public Vector3f getLeftLegRotation() {
        return super.metadata.getIndex(offset(OFFSET, 5), new Vector3f(-1f, 0f, -1f));
    }

    public void setLeftLegRotation(@NotNull Vector3f value) {
        super.metadata.setIndex(offset(OFFSET, 5), EntityDataTypes.ROTATION, value);
    }

    @NotNull
    public Vector3f getRightLegRotation() {
        return super.metadata.getIndex(offset(OFFSET, 6), new Vector3f(1f, 0f, 1f));
    }

    public void setRightLegRotation(@NotNull Vector3f value) {
        super.metadata.setIndex(offset(OFFSET, 6), EntityDataTypes.ROTATION, value);
    }


}
