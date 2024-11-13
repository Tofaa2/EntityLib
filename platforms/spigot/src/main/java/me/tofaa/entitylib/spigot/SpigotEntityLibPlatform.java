package me.tofaa.entitylib.spigot;

import com.github.retrooper.packetevents.PacketEventsAPI;
import io.github.retrooper.packetevents.bstats.bukkit.Metrics;
import io.github.retrooper.packetevents.bstats.charts.SimplePie;
import me.tofaa.entitylib.APIConfig;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.common.AbstractPlatform;
import me.tofaa.entitylib.utils.ConcurrentWeakIdentityHashMap;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class SpigotEntityLibPlatform extends AbstractPlatform<JavaPlugin> {

    private SpigotEntityLibAPI api;

    public SpigotEntityLibPlatform(@NotNull JavaPlugin plugin) {
        super(plugin);
    }

    @Override
    public void setupApi(@NotNull APIConfig settings) {
        super.setupApi(settings);
        this.logger = settings.shouldUsePlatformLogger() ? handle.getLogger() : Logger.getLogger("EntityLib");
        this.api = new SpigotEntityLibAPI(this, settings);
        this.api.onLoad();
        this.api.onEnable();
        if (settings.shouldUseBstats()) {
            PacketEventsAPI<Plugin> pe = (PacketEventsAPI<Plugin>)api.getPacketEvents();
            Metrics metrics = new Metrics(pe.getPlugin(), 21916);
            metrics.addCustomChart(new SimplePie("entitylib-version", () -> EntityLib.getVersion().toString()));
        }

    }

    @Override
    public SpigotEntityLibAPI getAPI() {
        return api;
    }

    @Override
    public String getName() {
        return "Spigot";
    }
}
