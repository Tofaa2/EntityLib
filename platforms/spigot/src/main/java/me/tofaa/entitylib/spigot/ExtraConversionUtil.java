package me.tofaa.entitylib.spigot;

import com.github.retrooper.packetevents.protocol.entity.pose.EntityPose;
import com.github.retrooper.packetevents.protocol.player.HumanoidArm;
import com.github.retrooper.packetevents.protocol.player.TextureProperty;
import com.github.retrooper.packetevents.protocol.player.UserProfile;
import org.bukkit.entity.Player;
import org.bukkit.entity.Pose;
import org.bukkit.inventory.MainHand;
import org.bukkit.profile.PlayerProfile;
import org.bukkit.profile.PlayerTextures;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

public final class ExtraConversionUtil {

    private ExtraConversionUtil() {

    }

    public static UserProfile fromBukkitPlayerProfile(PlayerProfile player) {
        UUID uuid = player.getUniqueId();
        String name = player.getName();
        // TODO: Textures
        return new UserProfile(uuid, name, Collections.emptyList());
    }

    public static EntityPose fromBukkitPose(Pose pose) {
        return EntityPose.values()[pose.ordinal()];
    }

    public static HumanoidArm fromBukkitHand(MainHand hand) {
        if (hand == MainHand.RIGHT) return HumanoidArm.RIGHT;
        return HumanoidArm.LEFT;
    }

}
