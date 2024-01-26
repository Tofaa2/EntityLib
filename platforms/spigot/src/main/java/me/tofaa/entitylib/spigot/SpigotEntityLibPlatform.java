package me.tofaa.entitylib.spigot;

import me.tofaa.entitylib.APISettings;
import me.tofaa.entitylib.EntityLibAPI;
import me.tofaa.entitylib.Platform;
import me.tofaa.entitylib.event.EntityLibEvent;
import me.tofaa.entitylib.tick.TickContainer;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SpigotEntityLibPlatform implements Platform<JavaPlugin> {

    private final JavaPlugin plugin;
    private SpigotEntityLibAPI api;
    private Logger logger;

    public SpigotEntityLibPlatform(@NotNull JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void setupApi(@NotNull APISettings settings) {
        this.logger = settings.shouldUsePlatformLogger() ? plugin.getLogger() : Logger.getLogger("EntityLib");
        this.api = new SpigotEntityLibAPI(this, settings);
        this.api.onLoad();
        this.api.onEnable();
    }

    @Override
    public @NotNull Logger getLogger() {
        return logger;
    }

    @Override
    public void sendEvent(EntityLibEvent event) {

    }

    @Override
    public <T extends EntityLibEvent> void registerListener(Class<T> eventClass, Consumer<T> handle) {

    }

    @Override
    public EntityLibAPI getAPI() {
        return api;
    }

    @Override
    public @NotNull JavaPlugin getHandle() {
        return plugin;
    }

    @Override
    public String getName() {
        return "Spigot";
    }
}
