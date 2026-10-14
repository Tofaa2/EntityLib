package me.tofaa.entitylib.movement;

import me.tofaa.entitylib.wrapper.WrapperEntity;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class SpigotMovementEngine extends DefaultMovementEngine {

    private final Plugin plugin;
    private volatile BukkitTask task;

    public SpigotMovementEngine(@NotNull Plugin plugin, @NotNull World world) {
        super(new SpigotWorldAccessor(plugin, world));
        this.plugin = plugin;
    }

    public SpigotMovementEngine(@NotNull Plugin plugin, @NotNull World world, @NotNull Executor pathfindingExecutor) {
        super(new SpigotWorldAccessor(plugin, world), pathfindingExecutor);
        this.plugin = plugin;
    }

    public SpigotMovementEngine(@NotNull Plugin plugin, @NotNull WorldAccessor worldAccessor,
                                @NotNull Executor pathfindingExecutor, int maxCacheSize) {
        super(worldAccessor, pathfindingExecutor, maxCacheSize);
        this.plugin = plugin;
    }

    @Override
    public @NotNull CompletableFuture<Boolean> moveToPath(@NotNull WrapperEntity entity, @NotNull Path path,
                                                         @NotNull MovementSettings settings) {
        start();
        return super.moveToPath(entity, path, settings);
    }

    public @NotNull Plugin getPlugin() {
        return plugin;
    }

    public synchronized void start() {
        if (task == null) {
            task = Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, this::tick, 1L, 1L);
        }
    }

    public synchronized void stop() {
        if (task != null) {
            task.cancel();
            task = null;
        }
    }

    public boolean isRunning() {
        return task != null;
    }

}
