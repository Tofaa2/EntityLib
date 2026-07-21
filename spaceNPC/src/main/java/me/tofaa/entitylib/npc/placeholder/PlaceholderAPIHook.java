package me.tofaa.entitylib.npc.placeholder;

import java.lang.reflect.Method;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PlaceholderAPIHook {

    private static Method setPlaceholdersMethod;
    private static boolean checked;

    private PlaceholderAPIHook() {}

    public static boolean isAvailable() {
        if (!checked) {
            try {
                Class<?> clazz = Class.forName("me.clip.placeholderapi.PlaceholderAPI");
                setPlaceholdersMethod = clazz.getMethod("setPlaceholders", org.bukkit.OfflinePlayer.class, String.class);
                checked = true;
            } catch (Exception e) {
                checked = true;
            }
        }
        return setPlaceholdersMethod != null;
    }

    public static @NotNull String setPlaceholders(@Nullable Player player, @NotNull String text) {
        if (!isAvailable()) return text;
        try {
            return (String) setPlaceholdersMethod.invoke(null, (org.bukkit.OfflinePlayer) player, text);
        } catch (Exception e) {
            return text;
        }
    }

    public static @NotNull Component setPlaceholders(@Nullable Player player, @NotNull Component component) {
        if (!isAvailable()) return component;
        MiniMessage mm = MiniMessage.miniMessage();
        String serialized = mm.serialize(component);
        String parsed = setPlaceholders(player, serialized);
        return mm.deserialize(parsed);
    }

    public static @NotNull Component setPlaceholders(@NotNull Component component) {
        Player player = null;
        for (Player online : Bukkit.getOnlinePlayers()) {
            player = online;
            break;
        }
        return setPlaceholders(player, component);
    }

    public static @NotNull String setPlaceholders(@NotNull String text) {
        Player player = null;
        for (Player online : Bukkit.getOnlinePlayers()) {
            player = online;
            break;
        }
        return setPlaceholders(player, text);
    }
}
