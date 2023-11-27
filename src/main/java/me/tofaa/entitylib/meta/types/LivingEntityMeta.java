package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.manager.server.ServerVersion;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.HumanoidArm;
import com.github.retrooper.packetevents.util.Vector3i;
import me.tofaa.entitylib.meta.EntityMeta;
import me.tofaa.entitylib.meta.Metadata;

import java.util.Optional;

public class LivingEntityMeta extends EntityMeta {
    public static final byte OFFSET = EntityMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 7;

    private final static byte IS_HAND_ACTIVE_BIT = 0x01;
    private final static byte ACTIVE_HAND_BIT = 0x02;
    private final static byte IS_IN_SPIN_ATTACK_BIT = 0x04;

    public LivingEntityMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }


    public float getHealth() {
        return super.metadata.getIndex(offset(1), 1F);
    }


    public int getPotionEffectColor() {
        isVersionNewer(ServerVersion.V_1_9);
        return super.metadata.getIndex(offset(2), 0);
    }

    public void setPotionEffectColor(int value) {
        isVersionNewer(ServerVersion.V_1_9);
        super.metadata.setIndex(offset(2), EntityDataTypes.INT, value);
    }

    public void setPotionEffectColor(int red, int green, int blue) {
        isVersionNewer(ServerVersion.V_1_9);
        setPotionEffectColor(red << 16 + green << 8 + blue);
    }

    public boolean isPotionEffectAmbient() {
        isVersionNewer(ServerVersion.V_1_9);
        return super.metadata.getIndex(offset(3), false);
    }

    public void setPotionEffectAmbient(boolean value) {
        isVersionNewer(ServerVersion.V_1_9);
        super.metadata.setIndex(offset(3), EntityDataTypes.BOOLEAN, value);
    }

    public int getArrowCount() {
        isVersionNewer(ServerVersion.V_1_9);
        return super.metadata.getIndex(offset(4), 0);
    }

    public void setArrowCount(int value) {
        isVersionNewer(ServerVersion.V_1_9);
        super.metadata.setIndex(offset(4), EntityDataTypes.INT, value);
    }

    public void setHealth(float value) {
        super.metadata.setIndex(offset(1), EntityDataTypes.FLOAT, value);
    }

    public HumanoidArm getActiveHand() {
        isVersionNewer(ServerVersion.V_1_9);
        return getMaskBit(OFFSET, ACTIVE_HAND_BIT) ? HumanoidArm.LEFT : HumanoidArm.RIGHT;
    }

    public void setActiveHand(HumanoidArm value) {
        isVersionNewer(ServerVersion.V_1_9);
        setMaskBit(OFFSET, ACTIVE_HAND_BIT, value == HumanoidArm.LEFT);
    }

    public boolean isInRiptideSpinAttack() {
        isVersionNewer(ServerVersion.V_1_13);
        return getMaskBit(OFFSET, IS_IN_SPIN_ATTACK_BIT);
    }

    public void setInRiptideSpinAttack(boolean value) {
        isVersionNewer(ServerVersion.V_1_13);
        setMaskBit(OFFSET, IS_IN_SPIN_ATTACK_BIT, value);
    }

    public Optional<Vector3i> getBedPosition() {
        isVersionNewer(ServerVersion.V_1_14);
        return super.metadata.getIndex(offset(6), Optional.empty());
    }

    public void setBedPosition(Vector3i value) {
        isVersionNewer(ServerVersion.V_1_14);
        super.metadata.setIndex(offset(6), EntityDataTypes.OPTIONAL_BLOCK_POSITION, value == null ? Optional.empty() : Optional.of(value));
    }

    public int getBeeStingerCount() {
        isVersionNewer(ServerVersion.V_1_15);
        return super.metadata.getIndex(offset(5), 0);
    }

    public void setBeeStingerCount(int value) {
        isVersionNewer(ServerVersion.V_1_15);
        super.metadata.setIndex(offset(5), EntityDataTypes.INT, value);
    }

    public boolean isHandActive() {
        isVersionNewer(ServerVersion.V_1_15);
        return getMaskBit(OFFSET, IS_HAND_ACTIVE_BIT);
    }

    public void setHandActive(boolean value) {
        isVersionNewer(ServerVersion.V_1_15);
        setMaskBit(OFFSET, IS_HAND_ACTIVE_BIT, value);
    }

}
