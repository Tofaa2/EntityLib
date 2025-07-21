package me.tofaa.entitylib.spigot;

import com.github.retrooper.packetevents.PacketEventsAPI;
import io.github.retrooper.packetevents.bstats.bukkit.Metrics;
import io.github.retrooper.packetevents.bstats.charts.SimplePie;
import me.tofaa.entitylib.APIConfig;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.UserLocaleProvider;
import me.tofaa.entitylib.common.AbstractPlatform;
import java.util.logging.Logger;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class SpigotEntityLibPlatform extends AbstractPlatform<JavaPlugin> {

    private SpigotEntityLibAPI api;
    private UserLocaleProvider userLocaleProvider = new SpigotPlayerLocaleProvider();

    public SpigotEntityLibPlatform(@NotNull JavaPlugin plugin) {
        super(plugin);
    }

    @Override
    public void setupApi(@NotNull APIConfig settings) {
        super.setupApi(settings);
        this.logger = settings.shouldUsePlatformLogger() ? handle.getLogger() : Logger.getLogger("EntityLib");
        this.api = new SpigotEntityLibAPI(this, settings);
        this.setEntityIdProvider(new SpigotEntityIdProvider(this));
        this.api.onLoad();
        this.api.onEnable();
        if (settings.shouldUseBstats()) {
            PacketEventsAPI<Plugin> pe = (PacketEventsAPI<Plugin>) api.getPacketEvents();
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

    @Override
    public @NotNull UserLocaleProvider getUserLocaleProvider() {
        return userLocaleProvider;
    }

    @Override
    public void setUserLocaleProvider(@NotNull final UserLocaleProvider provider) {
        this.userLocaleProvider = provider;
    }
}
