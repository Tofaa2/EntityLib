package me.tofaa.entitylib.spigot;

import com.github.retrooper.packetevents.PacketEventsAPI;
import me.tofaa.entitylib.APISettings;
import me.tofaa.entitylib.EntityLibAPI;
import me.tofaa.entitylib.tick.TickContainer;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.logging.Level;

public class SpigotEntityLibAPI implements EntityLibAPI<World, BukkitTask> {

    private final SpigotEntityLibPlatform platform;
    private final PacketEventsAPI<?> packetEvents;
    private final APISettings settings;
    private Collection<TickContainer<?, BukkitTask>> tickContainers;

    SpigotEntityLibAPI(SpigotEntityLibPlatform platform, APISettings settings) {
        this.platform = platform;
        this.packetEvents = settings.getPacketEvents();
        this.settings = settings;
    }

    @Override
    public void onLoad() {
        this.tickContainers = settings.shouldTickTickables() ? new HashSet<>() : Collections.EMPTY_SET;
    }

    @Override
    public void onEnable() {

    }

    @NotNull @Override
    public APISettings getSettings() {
        return settings;
    }

    @Override
    public void setupTickingContainers() {
        if (!getSettings().shouldTickTickables()) {
            if (getSettings().isDebugMode()) {
                platform.getLogger().log(Level.CONFIG, "Skipping ticking containers as it is disabled in the settings.");
            }
            return;
        }

        if (getSettings().isDebugMode()) {
            platform.getLogger().log(Level.CONFIG, "Setting up ticking containers...");
        }
        if (tickContainers.isEmpty()) {
            if (getSettings().isDebugMode()) {
                platform.getLogger().log(Level.CONFIG, "No tick containers found.");
            }
            return;
        }

        if (getSettings().isDebugMode()) {
            platform.getLogger().log(Level.CONFIG, "Found " + tickContainers.size() + " tick containers.");
        }

        tickContainers.forEach(this::registerNewTickContainer);
    }

    @Override
    public PacketEventsAPI<?> getPacketEvents() {
        return packetEvents;
    }

    @Override
    public Collection<TickContainer<?, BukkitTask>> getTickContainers() {
        return tickContainers;
    }

    @Override
    public void addTickContainer(@NotNull TickContainer<?, BukkitTask> tickContainer) {
        tickContainers.add(tickContainer);
        registerNewTickContainer(tickContainer);
    }

    public void registerNewTickContainer(TickContainer<?, BukkitTask> tickContainer) {

        if (getSettings().isDebugMode()) {
            platform.getLogger().log(Level.CONFIG, "Registering new tick container...");
        }
        getTickContainers().add(tickContainer);
        BukkitTask task = Bukkit.getScheduler().runTaskTimerAsynchronously(platform.getHandle(), () -> tickContainer.tick(System.currentTimeMillis()), 1L, 1L);
        tickContainer.setHandle(task);
    }


}
