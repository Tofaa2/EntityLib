package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.manager.server.ServerVersion;
import com.github.retrooper.packetevents.manager.server.VersionComparison;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.util.Quaternion4f;
import com.github.retrooper.packetevents.util.Vector3f;
import me.tofaa.entitylib.meta.EntityMeta;
import me.tofaa.entitylib.meta.Metadata;

public class DisplayMeta extends EntityMeta {

    public static final byte OFFSET = EntityMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET;
    static {
        if (isVersion(ServerVersion.V_1_20_2, VersionComparison.NEWER_THAN_OR_EQUALS)) {
            MAX_OFFSET =  OFFSET + 15;
        }
        else {
            MAX_OFFSET = OFFSET + 14;
        }
    }

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
        byte offset = offset(OFFSET, 3);
        if (isVersion(ServerVersion.V_1_20_2, VersionComparison.OLDER_THAN)) {
            offset = offset(OFFSET, 2);
        }
        return super.metadata.getIndex(offset, Vector3f.zero());
    }

    public void setTranslation(Vector3f value) {
        byte offset = offset(OFFSET, 3);
        if (isVersion(ServerVersion.V_1_20_2, VersionComparison.OLDER_THAN)) {
            offset = offset(OFFSET, 2);
        }
        super.metadata.setIndex(offset, EntityDataTypes.VECTOR3F, value);
    }

    public Vector3f getScale() {
        byte offset = offset(OFFSET, 4);
        if (isVersion(ServerVersion.V_1_20_2, VersionComparison.OLDER_THAN)) {
            offset = offset(OFFSET, 3);
        }
        return super.metadata.getIndex(offset, new Vector3f(1.0f, 1.0f, 1.0f));
    }

    public void setScale(Vector3f value) {
        byte offset = offset(OFFSET, 4);
        if (isVersion(ServerVersion.V_1_20_2, VersionComparison.OLDER_THAN)) {
            offset = offset(OFFSET, 3);
        }
        super.metadata.setIndex(offset, EntityDataTypes.VECTOR3F, value);
    }

    public Quaternion4f getLeftRotation() {
        byte offset = offset(OFFSET, 5);
        if (isVersion(ServerVersion.V_1_20_2, VersionComparison.OLDER_THAN)) {
            offset = offset(OFFSET, 4);
        }
        return super.metadata.getIndex(offset, new Quaternion4f(0.0f, 0.0f, 0.0f, 1.0f));
    }

    public void setLeftRotation(Quaternion4f value) {
        byte offset = offset(OFFSET, 5);
        if (isVersion(ServerVersion.V_1_20_2, VersionComparison.OLDER_THAN)) {
            offset = offset(OFFSET, 4);
        }
        super.metadata.setIndex(offset, EntityDataTypes.QUATERNION, value);
    }

    public Quaternion4f getRightRotation() {
        byte offset = offset(OFFSET, 6);
        if (isVersion(ServerVersion.V_1_20_2, VersionComparison.OLDER_THAN)) {
            offset = offset(OFFSET, 5);
        }
        return super.metadata.getIndex(offset, new Quaternion4f(0.0f, 0.0f, 0.0f, 1.0f));
    }

    public void setRightRotation(Quaternion4f value) {
        byte offset = offset(OFFSET, 6);
        if (isVersion(ServerVersion.V_1_20_2, VersionComparison.OLDER_THAN)) {
            offset = offset(OFFSET, 5);
        }
        super.metadata.setIndex(offset, EntityDataTypes.QUATERNION, value);
    }

    public BillboardConstraints getBillboardConstraints() {
        byte offset = offset(OFFSET, 7);
        if (isVersion(ServerVersion.V_1_20_2, VersionComparison.OLDER_THAN)) {
            offset = offset(OFFSET, 6);
        }
        return BillboardConstraints.VALUES[super.metadata.getIndex(offset, (byte) 0)];
    }

    public void setBillboardConstraints(BillboardConstraints value) {
        byte offset = offset(OFFSET, 7);
        if (isVersion(ServerVersion.V_1_20_2, VersionComparison.OLDER_THAN)) {
            offset = offset(OFFSET, 6);
        }
        super.metadata.setIndex(offset, EntityDataTypes.BYTE, (byte) value.ordinal());
    }

    //(blockLight << 4 | skyLight << 20)
    public int getBrightnessOverride() {
        byte offset = offset(OFFSET, 8);
        if (isVersion(ServerVersion.V_1_20_2, VersionComparison.OLDER_THAN)) {
            offset = offset(OFFSET, 7);
        }
        return super.metadata.getIndex(offset, -1);
    }

    public void setBrightnessOverride(int value) {
        byte offset = offset(OFFSET, 8);
        if (isVersion(ServerVersion.V_1_20_2, VersionComparison.OLDER_THAN)) {
            offset = offset(OFFSET, 7);
        }
        super.metadata.setIndex(offset, EntityDataTypes.INT, value);
    }

    public float getViewRange() {
        byte offset = offset(OFFSET, 9);
        if (isVersion(ServerVersion.V_1_20_2, VersionComparison.OLDER_THAN)) {
            offset = offset(OFFSET, 8);
        }
        return super.metadata.getIndex(offset, 1.0f);
    }

    public void setViewRange(float value) {
        byte offset = offset(OFFSET, 9);
        if (isVersion(ServerVersion.V_1_20_2, VersionComparison.OLDER_THAN)) {
            offset = offset(OFFSET, 8);
        }
        super.metadata.setIndex(offset, EntityDataTypes.FLOAT, value);
    }

    public float getShadowRadius() {
        byte offset = offset(OFFSET, 10);
        if (isVersion(ServerVersion.V_1_20_2, VersionComparison.OLDER_THAN)) {
            offset = offset(OFFSET, 9);
        }
        return super.metadata.getIndex(offset, 0.0f);
    }

    public void setShadowRadius(float value) {
        byte offset = offset(OFFSET, 10);
        if (isVersion(ServerVersion.V_1_20_2, VersionComparison.OLDER_THAN)) {
            offset = offset(OFFSET, 9);
        }
        super.metadata.setIndex(offset, EntityDataTypes.FLOAT, value);
    }

    public float getShadowStrength() {
        byte offset = offset(OFFSET, 11);
        if (isVersion(ServerVersion.V_1_20_2, VersionComparison.OLDER_THAN)) {
            offset = offset(OFFSET, 10);
        }
        return super.metadata.getIndex(offset, 1.0f);
    }

    public void setShadowStrength(float value) {
        byte offset = offset(OFFSET, 11);
        if (isVersion(ServerVersion.V_1_20_2, VersionComparison.OLDER_THAN)) {
            offset = offset(OFFSET, 10);
        }
        super.metadata.setIndex(offset, EntityDataTypes.FLOAT, value);
    }

    public float getWidth() {
        byte offset = offset(OFFSET, 12);
        if (isVersion(ServerVersion.V_1_20_2, VersionComparison.OLDER_THAN)) {
            offset = offset(OFFSET, 11);
        }
        return super.metadata.getIndex(offset, 0.0f);
    }

    public void setWidth(float value) {
        byte offset = offset(OFFSET, 12);
        if (isVersion(ServerVersion.V_1_20_2, VersionComparison.OLDER_THAN)) {
            offset = offset(OFFSET, 11);
        }
        super.metadata.setIndex(offset, EntityDataTypes.FLOAT, value);
    }

    public float getHeight() {
        byte offset = offset(OFFSET, 13);
        if (isVersion(ServerVersion.V_1_20_2, VersionComparison.OLDER_THAN)) {
            offset = offset(OFFSET, 12);
        }
        return super.metadata.getIndex(offset, 0.0f);
    }

    public void setHeight(float value) {
        byte offset = offset(OFFSET, 13);
        if (isVersion(ServerVersion.V_1_20_2, VersionComparison.OLDER_THAN)) {
            offset = offset(OFFSET, 12);
        }
        super.metadata.setIndex(offset, EntityDataTypes.FLOAT, value);
    }

    public int getGlowColorOverride() {
        byte offset = offset(OFFSET, 14);
        if (isVersion(ServerVersion.V_1_20_2, VersionComparison.OLDER_THAN)) {
            offset = offset(OFFSET, 13);
        }
        return super.metadata.getIndex(offset, -1);
    }

    public void setGlowColorOverride(int value) {
        byte offset = offset(OFFSET, 14);
        if (isVersion(ServerVersion.V_1_20_2, VersionComparison.OLDER_THAN)) {
            offset = offset(OFFSET, 13);
        }
        super.metadata.setIndex(offset, EntityDataTypes.INT, value);
    }

    public enum BillboardConstraints {
        FIXED,
        VERTICAL,
        HORIZONTAL,
        CENTER;

        private static final BillboardConstraints[] VALUES = values();
    }

}
