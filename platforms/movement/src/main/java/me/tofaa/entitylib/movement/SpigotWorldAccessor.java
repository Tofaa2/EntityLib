package me.tofaa.entitylib.movement;

import org.bukkit.Bukkit;
import org.bukkit.ChunkSnapshot;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class SpigotWorldAccessor implements WorldAccessor {

    private static final long SNAPSHOT_TIMEOUT_MILLIS = 2000;

    private static final class Entry {
        final ChunkSnapshot snapshot;
        final long created;

        Entry(ChunkSnapshot snapshot, long created) {
            this.snapshot = snapshot;
            this.created = created;
        }
    }

    private static final Entry UNLOADED = new Entry(null, 0);

    private final Plugin plugin;
    private final World world;
    private final int minY;
    private final int maxY;
    private final Map<Long, Entry> snapshots = new ConcurrentHashMap<>();
    private volatile long lifetimeNanos = TimeUnit.SECONDS.toNanos(5);

    public SpigotWorldAccessor(@NotNull Plugin plugin, @NotNull World world) {
        this.plugin = plugin;
        this.world = world;
        int min = 0;
        try {
            min = world.getMinHeight();
        } catch (NoSuchMethodError legacy) {
            min = 0;
        }
        this.minY = min;
        this.maxY = world.getMaxHeight();
    }

    public @NotNull World getWorld() {
        return world;
    }

    public void setSnapshotLifetime(long duration, @NotNull TimeUnit unit) {
        this.lifetimeNanos = unit.toNanos(duration);
    }

    public void invalidate(int chunkX, int chunkZ) {
        snapshots.remove(key(chunkX, chunkZ));
    }

    public void invalidateAll() {
        snapshots.clear();
    }

    @Override
    public boolean isLoaded(int x, int z) {
        return snapshot(x >> 4, z >> 4) != null;
    }

    @Override
    public boolean isSolid(int x, int y, int z) {
        Material type = type(x, y, z);
        return type != null && type.isSolid();
    }

    @Override
    public boolean isLiquid(int x, int y, int z) {
        Material type = type(x, y, z);
        return type == Material.WATER || type == Material.LAVA;
    }

    private Material type(int x, int y, int z) {
        if (y < minY || y >= maxY) {
            return null;
        }
        ChunkSnapshot snapshot = snapshot(x >> 4, z >> 4);
        return snapshot == null ? null : snapshot.getBlockType(x & 15, y, z & 15);
    }

    private ChunkSnapshot snapshot(int chunkX, int chunkZ) {
        long key = key(chunkX, chunkZ);
        long now = System.nanoTime();
        Entry entry = snapshots.get(key);
        if (entry != null && now - entry.created < lifetimeNanos) {
            return entry.snapshot;
        }
        Entry captured = capture(chunkX, chunkZ, now);
        snapshots.put(key, captured);
        return captured.snapshot;
    }

    private Entry capture(int chunkX, int chunkZ, long now) {
        if (Bukkit.isPrimaryThread()) {
            return captureNow(chunkX, chunkZ, now);
        }
        try {
            return Bukkit.getScheduler().callSyncMethod(plugin, () -> captureNow(chunkX, chunkZ, now))
                .get(SNAPSHOT_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
        } catch (InterruptedException interrupted) {
            Thread.currentThread().interrupt();
            return new Entry(null, now);
        } catch (ExecutionException | TimeoutException | RuntimeException failed) {
            return new Entry(null, now);
        }
    }

    private Entry captureNow(int chunkX, int chunkZ, long now) {
        if (!world.isChunkLoaded(chunkX, chunkZ)) {
            return new Entry(null, now);
        }
        return new Entry(world.getChunkAt(chunkX, chunkZ).getChunkSnapshot(), now);
    }

    private static long key(int chunkX, int chunkZ) {
        return ((long) chunkX << 32) | (chunkZ & 0xFFFFFFFFL);
    }

}
