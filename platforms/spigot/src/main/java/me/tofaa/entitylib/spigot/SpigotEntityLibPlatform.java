package me.tofaa.entitylib.spigot;

import me.tofaa.entitylib.APISettings;
import me.tofaa.entitylib.EntityIdProvider;
import me.tofaa.entitylib.EntityLibAPI;
import me.tofaa.entitylib.Platform;
import me.tofaa.entitylib.common.AbstractPlatform;
import me.tofaa.entitylib.event.EventBus;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import java.util.logging.Logger;

public class SpigotEntityLibPlatform extends AbstractPlatform<JavaPlugin> {

    private SpigotEntityLibAPI api;
    public SpigotEntityLibPlatform(@NotNull JavaPlugin plugin) {
        super(plugin);
    }

    @Override
    public void setupApi(@NotNull APISettings settings) {
        super.setupApi(settings);
        this.logger = settings.shouldUsePlatformLogger() ? handle.getLogger() : Logger.getLogger("EntityLib");
        this.api = new SpigotEntityLibAPI(this, settings);
        this.api.onLoad();
        this.api.onEnable();
    }


    @Override
    public EntityLibAPI<?, ?> getAPI() {
        return api;
    }

    @Override
    public String getName() {
        return "Spigot";
    }
}
