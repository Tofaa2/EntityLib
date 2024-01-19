package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.manager.server.ServerVersion;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.util.Quaternion4f;
import com.github.retrooper.packetevents.util.Vector3f;
import me.tofaa.entitylib.meta.EntityMeta;
import me.tofaa.entitylib.meta.Metadata;

public class DisplayMeta extends EntityMeta {

    public static final byte OFFSET = EntityMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 15;

    public DisplayMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
        isVersionNewer(ServerVersion.V_1_19_3);
    }

    public int getInterpolationDelay() {
        return super.metadata.getIndex(OFFSET, 0);
    }

    public void setInterpolationDelay(int value) {
        super.metadata.setIndex(OFFSET, EntityDataTypes.INT, value);
    }

    public int getTransformationInterpolationDuration() {
        return super.metadata.getIndex(offset(OFFSET, 1), 0);
    }

    public void setTransformationInterpolationDuration(int value) {
        super.metadata.setIndex(offset(OFFSET, 1), EntityDataTypes.INT, value);
    }

    public int getPositionRotationInterpolationDuration() {
        return super.metadata.getIndex(offset(OFFSET, 2), 0);
    }

    public void setPositionRotationInterpolationDuration(int value) {
        super.metadata.setIndex(offset(OFFSET, 2), EntityDataTypes.INT, value);
    }

    public Vector3f getTranslation() {
        return super.metadata.getIndex(offset(OFFSET, 3), Vector3f.zero());
    }

    public void setTranslation(Vector3f value) {
        super.metadata.setIndex(offset(OFFSET, 3), EntityDataTypes.VECTOR3F, value);
    }

    public Vector3f getScale() {
        return super.metadata.getIndex(offset(OFFSET, 4), new Vector3f(1.0f, 1.0f, 1.0f));
    }

    public void setScale(Vector3f value) {
        super.metadata.setIndex(offset(OFFSET, 4), EntityDataTypes.VECTOR3F, value);
    }

    public Quaternion4f getLeftRotation() {
        return super.metadata.getIndex(offset(OFFSET, 5), new Quaternion4f(0.0f, 0.0f, 0.0f, 1.0f));
    }

    public void setLeftRotation(Quaternion4f value) {
        super.metadata.setIndex(offset(OFFSET, 5), EntityDataTypes.QUATERNION, value);
    }

    public Quaternion4f getRightRotation() {
        return super.metadata.getIndex(offset(OFFSET, 6), new Quaternion4f(0.0f, 0.0f, 0.0f, 1.0f));
    }

    public void setRightRotation(Quaternion4f value) {
        super.metadata.setIndex(offset(OFFSET, 6), EntityDataTypes.QUATERNION, value);
    }

    public BillboardConstraints getBillboardConstraints() {
        return BillboardConstraints.VALUES[super.metadata.getIndex(offset(OFFSET, 7), (byte) 0)];
    }

    public void setBillboardConstraints(BillboardConstraints value) {
        super.metadata.setIndex(offset(OFFSET, 7), EntityDataTypes.BYTE, (byte) value.ordinal());
    }

    //(blockLight << 4 | skyLight << 20)
    public int getBrightnessOverride() {
        return super.metadata.getIndex(offset(OFFSET, 8), -1);
    }

    public void setBrightnessOverride(int value) {
        super.metadata.setIndex(offset(OFFSET, 8), EntityDataTypes.INT, value);
    }

    public float getViewRange() {
        return super.metadata.getIndex(offset(OFFSET, 9), 1.0f);
    }

    public void setViewRange(float value) {
        super.metadata.setIndex(offset(OFFSET, 9), EntityDataTypes.FLOAT, value);
    }

    public float getShadowRadius() {
        return super.metadata.getIndex(offset(OFFSET, 10), 0.0f);
    }

    public void setShadowRadius(float value) {
        super.metadata.setIndex(offset(OFFSET, 10), EntityDataTypes.FLOAT, value);
    }

    public float getShadowStrength() {
        return super.metadata.getIndex(offset(OFFSET, 11), 1.0f);
    }

    public void setShadowStrength(float value) {
        super.metadata.setIndex(offset(OFFSET, 11), EntityDataTypes.FLOAT, value);
    }

    public float getWidth() {
        return super.metadata.getIndex(offset(OFFSET, 12), 0.0f);
    }

    public void setWidth(float value) {
        super.metadata.setIndex(offset(OFFSET, 12), EntityDataTypes.FLOAT, value);
    }

    public float getHeight() {
        return super.metadata.getIndex(offset(OFFSET, 13), 0.0f);
    }

    public void setHeight(float value) {
        super.metadata.setIndex(offset(OFFSET, 13), EntityDataTypes.FLOAT, value);
    }

    public int getGlowColorOverride() {
        return super.metadata.getIndex(offset(OFFSET, 14), -1);
    }

    public void setGlowColorOverride(int value) {
        super.metadata.setIndex(offset(OFFSET, 14), EntityDataTypes.INT, value);
    }

    public enum BillboardConstraints {
        FIXED,
        VERTICAL,
        HORIZONTAL,
        CENTER;

        private static final BillboardConstraints[] VALUES = values();
    }

}
