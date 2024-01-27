package me.tofaa.entitylib.spigot;

import com.github.retrooper.packetevents.PacketEventsAPI;
import me.tofaa.entitylib.APISettings;
import me.tofaa.entitylib.EntityLibAPI;
import me.tofaa.entitylib.WorldWrapper;
import me.tofaa.entitylib.common.AbstractEntityLibAPI;
import me.tofaa.entitylib.event.EventBus;
import me.tofaa.entitylib.tick.TickContainer;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.UUID;
import java.util.logging.Level;

public class SpigotEntityLibAPI extends AbstractEntityLibAPI<JavaPlugin, World, BukkitTask> {


    SpigotEntityLibAPI(SpigotEntityLibPlatform platform, APISettings settings) {
        super(platform, settings);
    }

    @Override
    public void onLoad() {
    }

    @Override
    public void onEnable() {

    }

    @Override
    public @NotNull WorldWrapper<World> wrapWorld(World world) {
        return new SpigotWorld(world);
    }


    @Override
    public void addTickContainer(@NotNull TickContainer<?, BukkitTask> tickContainer) {
        if (!settings.shouldTickTickables()) {
            if (settings.isDebugMode()) {
                platform.getLogger().log(Level.WARNING, "Tried to add a TickContainer when ticking tickables is disabled!");
            }
            return;
        }
        tickContainers.add(tickContainer);
        if (settings.isDebugMode()) {
            platform.getLogger().log(Level.CONFIG, "Registering new tick container...");
        }
        getTickContainers().add(tickContainer);
        BukkitTask task = Bukkit.getScheduler().runTaskTimerAsynchronously(platform.getHandle(), () -> tickContainer.tick(System.currentTimeMillis()), 1L, 1L);
        tickContainer.setHandle(task);
    }



}
