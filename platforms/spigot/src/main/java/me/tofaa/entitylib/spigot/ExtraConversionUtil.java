package me.tofaa.entitylib.spigot;

import com.github.retrooper.packetevents.protocol.entity.pose.EntityPose;
import com.github.retrooper.packetevents.protocol.player.HumanoidArm;
import com.github.retrooper.packetevents.protocol.player.TextureProperty;
import com.github.retrooper.packetevents.protocol.player.UserProfile;
import com.google.common.collect.Multimap;
import io.github.retrooper.packetevents.util.SpigotConversionUtil;
import io.github.retrooper.packetevents.util.SpigotReflectionUtil;
import org.bukkit.entity.Player;
import org.bukkit.entity.Pose;
import org.bukkit.inventory.MainHand;
import org.bukkit.profile.PlayerProfile;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public final class ExtraConversionUtil {

    private static Method PLAYER_PROFILE_METHOD;
    private static Class<?> PROFILE_CLASS;
    private static Method GET_PROPERTIES_METHOD;
    static {
        try {
            PLAYER_PROFILE_METHOD = SpigotReflectionUtil.CRAFT_PLAYER_CLASS.getMethod("getProfile");
            PLAYER_PROFILE_METHOD.setAccessible(true); // Dont care :D
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    private ExtraConversionUtil() {

    }

    public static @Nullable UserProfile getProfileFromBukkitPlayer(Player player) {

        try {
            Object profile = PLAYER_PROFILE_METHOD.invoke(player); // GameProfile
            if (PROFILE_CLASS == null) {
                PROFILE_CLASS = profile.getClass();
                GET_PROPERTIES_METHOD = PROFILE_CLASS.getMethod("getProperties");
                GET_PROPERTIES_METHOD.setAccessible(true); // Again dont care;
            }
            Multimap properties = (Multimap) GET_PROPERTIES_METHOD.invoke(profile);
            Collection<?> textures = properties.get("textures");
            if (textures == null || textures.isEmpty()) return new UserProfile(player.getUniqueId(), player.getName());
            Object texture = textures.iterator().next();

            String value = (String) texture.getClass().getDeclaredMethod("value").invoke(texture);
            String signature = (String) texture.getClass().getDeclaredMethod("signature").invoke(texture);

            ArrayList<TextureProperty> t = new ArrayList<>();
            t.add(new TextureProperty("textures", value, signature));
            return new UserProfile(player.getUniqueId(), player.getName(), t);
        } catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public static EntityPose fromBukkitPose(Pose pose) {
        return EntityPose.values()[pose.ordinal()];
    }

    public static HumanoidArm fromBukkitHand(MainHand hand) {
        if (hand == MainHand.RIGHT) return HumanoidArm.RIGHT;
        return HumanoidArm.LEFT;
    }

}
