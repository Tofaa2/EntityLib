package me.tofaa.entitylib.spigot;

import com.github.retrooper.packetevents.protocol.entity.pose.EntityPose;
import com.github.retrooper.packetevents.protocol.player.HumanoidArm;
import org.bukkit.entity.Pose;
import org.bukkit.inventory.MainHand;

public final class ExtraConversionUtil {

    private ExtraConversionUtil() {

    }

    public static EntityPose fromBukkitPose(Pose pose) {
        return EntityPose.values()[pose.ordinal()];
    }

    public static HumanoidArm fromBukkitHand(MainHand hand) {
        if (hand == MainHand.RIGHT) return HumanoidArm.RIGHT;
        return HumanoidArm.LEFT;
    }

}
