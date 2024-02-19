package me.tofaa.entitylib.spigot;

import me.tofaa.entitylib.APIConfig;
import me.tofaa.entitylib.TrackedEntity;
import me.tofaa.entitylib.common.AbstractPlatform;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class SpigotEntityLibPlatform extends AbstractPlatform<JavaPlugin> {

    private SpigotEntityLibAPI api;
    private Map<Integer, Entity> platformEntities = Collections.synchronizedMap(new WeakHashMap<>()); // Silly

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

        if (settings.shouldTrackPlatformEntities()) {
            InternalRegistryListener listener = new InternalRegistryListener(this);
            handle.getServer().getPluginManager().registerEvents(listener, handle);
            api.getPacketEvents().getEventManager().registerListener(listener);
        }
    }


    Map<Integer, Entity> getPlatformEntities() {
        return platformEntities;
    }

    @Override
    public @NotNull Stream<TrackedEntity> queryPlatformEntities() {
        if (!api.getSettings().shouldTrackPlatformEntities()) return Stream.of();
        return platformEntities.values().stream().map(SpigotEntity::new);
    }

    @Override
    public @Nullable TrackedEntity findPlatformEntity(final int entityId) {
        if (!api.getSettings().shouldTrackPlatformEntities()) return null;
        Entity e = platformEntities.get(entityId);
        if (e == null) return null;
        return new SpigotEntity(e);
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
