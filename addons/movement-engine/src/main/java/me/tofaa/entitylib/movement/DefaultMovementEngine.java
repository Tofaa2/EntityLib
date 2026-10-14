package me.tofaa.entitylib.movement;

import com.github.retrooper.packetevents.protocol.world.Location;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

public class DefaultMovementEngine implements MovementEngine {

    private static final long CACHE_LIFETIME_NANOS = 30_000_000_000L;
    private static final double MAX_TICK_SECONDS = 0.25;
    private static final long REPATH_INTERVAL_NANOS = 250_000_000L;
    private static final long VALIDATE_INTERVAL_NANOS = 500_000_000L;
    private static final long RETRY_INTERVAL_NANOS = 1_000_000_000L;
    private static final double TARGET_MOVE_THRESHOLD = 1.0;
    private static final double ARRIVAL_TOLERANCE = 1.0;
    private static final int VALIDATE_POINTS = 3;

    private record CacheKey(long from, long to, PathfindSettings settings) {
    }

    private record CacheEntry(Optional<Path> path, long created) {
    }

    private final WorldAccessor worldAccessor;
    private final Executor pathfindingExecutor;
    private final int maxCacheSize;
    private final Map<CacheKey, CacheEntry> pathCache;
    private final Map<Integer, ActiveMovement> activeMovements = new ConcurrentHashMap<>();
    private final Map<Integer, Navigation> navigations = new ConcurrentHashMap<>();
    private volatile long lastTick;

    public DefaultMovementEngine(@NotNull WorldAccessor worldAccessor) {
        this(worldAccessor, defaultExecutor(), 100);
    }

    public DefaultMovementEngine(@NotNull WorldAccessor worldAccessor, @NotNull Executor pathfindingExecutor) {
        this(worldAccessor, pathfindingExecutor, 100);
    }

    public DefaultMovementEngine(@NotNull WorldAccessor worldAccessor, @NotNull Executor pathfindingExecutor, int maxCacheSize) {
        this.worldAccessor = worldAccessor;
        this.pathfindingExecutor = pathfindingExecutor;
        this.maxCacheSize = maxCacheSize;
        this.pathCache = new LinkedHashMap<CacheKey, CacheEntry>(16, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<CacheKey, CacheEntry> eldest) {
                return size() > DefaultMovementEngine.this.maxCacheSize;
            }
        };
    }

    private static Executor defaultExecutor() {
        AtomicInteger counter = new AtomicInteger();
        return Executors.newFixedThreadPool(Math.max(1, Runtime.getRuntime().availableProcessors() / 4), runnable -> {
            Thread thread = new Thread(runnable, "EntityLib-Pathfinding-" + counter.incrementAndGet());
            thread.setDaemon(true);
            return thread;
        });
    }

    public @NotNull WorldAccessor getWorldAccessor() {
        return worldAccessor;
    }

    @Override
    public @NotNull Executor getPathfindingExecutor() {
        return pathfindingExecutor;
    }

    @Override
    public @NotNull CompletableFuture<@Nullable Path> findPath(@NotNull Location from, @NotNull Location to,
                                                              @NotNull PathfindSettings settings) {
        CacheKey key = key(from, to, settings);
        CacheEntry cached = cached(key);
        if (cached != null) {
            return CompletableFuture.completedFuture(cached.path().orElse(null));
        }
        return CompletableFuture.supplyAsync(() -> {
            List<Location> points = Pathfinder.find(worldAccessor, from, to, settings);
            Path path = points == null ? null : new PathImpl(points, from, to);
            store(key, path);
            return path;
        }, pathfindingExecutor);
    }

    @Override
    public @NotNull CompletableFuture<@Nullable Path> findPath(@NotNull WrapperEntity entity, @NotNull Location to,
                                                              @NotNull PathfindSettings settings) {
        return findPath(entity.getLocation(), to, settings);
    }

    @Override
    public @NotNull CompletableFuture<Boolean> moveToPath(@NotNull WrapperEntity entity, @NotNull Path path,
                                                         @NotNull MovementSettings settings) {
        cancelNavigation(entity);
        ActiveMovement movement = new ActiveMovement(entity, path, settings);
        if (path.getPoints().size() < 2) {
            movement.completion.complete(true);
            return movement.completion;
        }
        ActiveMovement previous = activeMovements.put(entity.getEntityId(), movement);
        if (previous != null) {
            previous.completion.complete(false);
        }
        return movement.completion;
    }

    @Override
    public @NotNull CompletableFuture<Boolean> navigate(@NotNull WrapperEntity entity, @NotNull Location target,
                                                       @NotNull PathfindSettings pathfindSettings,
                                                       @NotNull MovementSettings movementSettings) {
        return startNavigation(entity, () -> target, pathfindSettings, movementSettings, false);
    }

    @Override
    public @NotNull CompletableFuture<Boolean> follow(@NotNull WrapperEntity entity, @NotNull Supplier<Location> target,
                                                     @NotNull PathfindSettings pathfindSettings,
                                                     @NotNull MovementSettings movementSettings) {
        return startNavigation(entity, target, pathfindSettings, movementSettings, true);
    }

    private CompletableFuture<Boolean> startNavigation(WrapperEntity entity, Supplier<Location> target,
                                                       PathfindSettings pathfindSettings, MovementSettings movementSettings,
                                                       boolean continuous) {
        stopMovement(entity);
        Navigation navigation = new Navigation(entity, target, pathfindSettings, movementSettings, continuous);
        navigations.put(entity.getEntityId(), navigation);
        return navigation.completion;
    }

    private void cancelNavigation(WrapperEntity entity) {
        Navigation navigation = navigations.remove(entity.getEntityId());
        if (navigation != null) {
            navigation.completion.complete(false);
        }
    }

    @Override
    public void stopMovement(@NotNull WrapperEntity entity) {
        cancelNavigation(entity);
        ActiveMovement movement = activeMovements.remove(entity.getEntityId());
        if (movement != null) {
            movement.completion.complete(false);
        }
    }

    @Override
    public boolean isMoving(@NotNull WrapperEntity entity) {
        return activeMovements.containsKey(entity.getEntityId()) || navigations.containsKey(entity.getEntityId());
    }

    public @Nullable ActiveMovement getActiveMovement(@NotNull WrapperEntity entity) {
        return activeMovements.get(entity.getEntityId());
    }

    @Override
    public void tick() {
        long now = System.nanoTime();
        long previous = lastTick;
        lastTick = now;
        if (previous != 0 && !activeMovements.isEmpty()) {
            double seconds = Math.min(MAX_TICK_SECONDS, (now - previous) / 1_000_000_000.0);
            for (ActiveMovement movement : activeMovements.values()) {
                if (movement.paused) {
                    continue;
                }
                if (movement.advance(seconds)) {
                    activeMovements.remove(movement.entity.getEntityId(), movement);
                    movement.completion.complete(true);
                }
            }
        }
        for (Navigation navigation : navigations.values()) {
            navigation.update(now);
        }
    }

    @Override
    public void clearCache() {
        synchronized (pathCache) {
            pathCache.clear();
        }
    }

    @Override
    public @Nullable Path getCachedPath(@NotNull Location from, @NotNull Location to) {
        long fromKey = blockKey(from);
        long toKey = blockKey(to);
        long now = System.nanoTime();
        synchronized (pathCache) {
            for (Map.Entry<CacheKey, CacheEntry> entry : pathCache.entrySet()) {
                if (entry.getKey().from() == fromKey && entry.getKey().to() == toKey
                    && now - entry.getValue().created() < CACHE_LIFETIME_NANOS) {
                    return entry.getValue().path().orElse(null);
                }
            }
        }
        return null;
    }

    @Override
    public void cachePath(@NotNull Path path) {
        store(key(path.getStart(), path.getEnd(), PathfindSettings.builder().build()), path);
    }

    private CacheEntry cached(CacheKey key) {
        if (maxCacheSize <= 0) {
            return null;
        }
        synchronized (pathCache) {
            CacheEntry entry = pathCache.get(key);
            if (entry != null && System.nanoTime() - entry.created() >= CACHE_LIFETIME_NANOS) {
                pathCache.remove(key);
                return null;
            }
            return entry;
        }
    }

    private void store(CacheKey key, Path path) {
        if (maxCacheSize <= 0) {
            return;
        }
        synchronized (pathCache) {
            pathCache.put(key, new CacheEntry(Optional.ofNullable(path), System.nanoTime()));
        }
    }

    private static CacheKey key(Location from, Location to, PathfindSettings settings) {
        return new CacheKey(blockKey(from), blockKey(to), settings);
    }

    private static long blockKey(Location location) {
        return Pathfinder.pack(Pathfinder.floor(location.getX()), Pathfinder.floor(location.getY()),
            Pathfinder.floor(location.getZ()));
    }

    private final class Navigation {

        private final WrapperEntity entity;
        private final Supplier<Location> target;
        private final PathfindSettings pathfindSettings;
        private final MovementSettings movementSettings;
        private final boolean continuous;
        private final CompletableFuture<Boolean> completion = new CompletableFuture<>();
        private volatile boolean searching;
        private volatile ActiveMovement current;
        private volatile Location pathTarget;
        private volatile long lastSearch;
        private volatile long lastValidation;
        private volatile long retryAt;
        private volatile boolean settled;

        private Navigation(WrapperEntity entity, Supplier<Location> target, PathfindSettings pathfindSettings,
                           MovementSettings movementSettings, boolean continuous) {
            this.entity = entity;
            this.target = target;
            this.pathfindSettings = pathfindSettings;
            this.movementSettings = movementSettings;
            this.continuous = continuous;
        }

        private void update(long now) {
            if (searching) {
                return;
            }
            Location goal = target.get();
            if (goal == null) {
                finish(false);
                return;
            }
            ActiveMovement movement = current;
            boolean moving = movement != null && activeMovements.get(entity.getEntityId()) == movement;
            if (!moving) {
                if (movement != null) {
                    current = null;
                    if (movement.completion.getNow(false)) {
                        if (!continuous) {
                            finish(true);
                            return;
                        }
                        settled = true;
                    }
                }
                double tolerance = Math.max(ARRIVAL_TOLERANCE, movementSettings.getFollowDistance());
                if (PathImpl.distance(entity.getLocation(), goal) <= tolerance) {
                    if (!continuous) {
                        finish(true);
                    }
                    return;
                }
                Location reached = pathTarget;
                if (settled && reached != null && PathImpl.distance(reached, goal) <= TARGET_MOVE_THRESHOLD) {
                    return;
                }
                if (now >= retryAt) {
                    search(goal, now);
                }
                return;
            }
            Location previousGoal = pathTarget;
            if (previousGoal != null && PathImpl.distance(previousGoal, goal) > TARGET_MOVE_THRESHOLD
                && now - lastSearch > REPATH_INTERVAL_NANOS) {
                search(goal, now);
                return;
            }
            if (now - lastValidation > VALIDATE_INTERVAL_NANOS) {
                lastValidation = now;
                if (blockedAhead(movement)) {
                    search(goal, now);
                }
            }
        }

        private boolean blockedAhead(ActiveMovement movement) {
            List<Location> points = movement.path.getPoints();
            int last = Math.min(points.size() - 1, movement.segment + VALIDATE_POINTS);
            for (int index = movement.segment + 1; index <= last; index++) {
                if (!Pathfinder.isTraversable(worldAccessor, points.get(index - 1), points.get(index), pathfindSettings)) {
                    return true;
                }
            }
            return false;
        }

        private void search(Location goal, long now) {
            searching = true;
            lastSearch = now;
            Location from = entity.getLocation();
            CompletableFuture.supplyAsync(() -> Pathfinder.find(worldAccessor, from, goal, pathfindSettings), pathfindingExecutor)
                .whenComplete((points, error) -> {
                    try {
                        if (navigations.get(entity.getEntityId()) != this) {
                            return;
                        }
                        if (points == null || error != null) {
                            halt();
                            if (continuous) {
                                retryAt = System.nanoTime() + RETRY_INTERVAL_NANOS;
                            } else {
                                finish(false);
                            }
                            return;
                        }
                        if (points.size() < 2) {
                            halt();
                            if (continuous) {
                                pathTarget = goal;
                                settled = true;
                            } else {
                                finish(true);
                            }
                            return;
                        }
                        pathTarget = goal;
                        settled = false;
                        ActiveMovement next = new ActiveMovement(entity, new PathImpl(points, from, goal), movementSettings);
                        current = next;
                        ActiveMovement replaced = activeMovements.put(entity.getEntityId(), next);
                        if (replaced != null) {
                            replaced.completion.complete(false);
                        }
                    } finally {
                        searching = false;
                    }
                });
        }

        private void halt() {
            ActiveMovement movement = current;
            current = null;
            if (movement != null && activeMovements.remove(entity.getEntityId(), movement)) {
                movement.completion.complete(false);
            }
        }

        private void finish(boolean arrived) {
            navigations.remove(entity.getEntityId(), this);
            halt();
            completion.complete(arrived);
        }

    }

    public static final class ActiveMovement {

        private final WrapperEntity entity;
        private final Path path;
        private final MovementSettings settings;
        private final CompletableFuture<Boolean> completion = new CompletableFuture<>();
        private volatile int segment;
        private double travelled;
        private volatile boolean paused;

        private ActiveMovement(WrapperEntity entity, Path path, MovementSettings settings) {
            this.entity = entity;
            this.path = path;
            this.settings = settings;
        }

        public @NotNull WrapperEntity getEntity() {
            return entity;
        }

        public @NotNull Path getPath() {
            return path;
        }

        public @NotNull MovementSettings getSettings() {
            return settings;
        }

        public @NotNull CompletableFuture<Boolean> getCompletion() {
            return completion;
        }

        public boolean isPaused() {
            return paused;
        }

        public void setPaused(boolean paused) {
            this.paused = paused;
        }

        private boolean advance(double seconds) {
            List<Location> points = path.getPoints();
            double remaining = settings.getSpeed() * settings.getSpeedModifier() * settings.getTickRate() * seconds;
            if (remaining <= 0) {
                return false;
            }
            Location from = points.get(segment);
            Location to = points.get(segment + 1);
            double length = PathImpl.distance(from, to);
            while (travelled + remaining >= length) {
                remaining -= length - travelled;
                travelled = 0;
                segment++;
                if (segment >= points.size() - 1) {
                    apply(points.get(points.size() - 2), points.get(points.size() - 1), 1);
                    return true;
                }
                from = points.get(segment);
                to = points.get(segment + 1);
                length = PathImpl.distance(from, to);
            }
            travelled += remaining;
            if (remainingDistance(points) <= settings.getFollowDistance() && segment == points.size() - 2) {
                apply(from, to, length == 0 ? 1 : travelled / length);
                return true;
            }
            apply(from, to, length == 0 ? 1 : travelled / length);
            return false;
        }

        private double remainingDistance(List<Location> points) {
            return PathImpl.distance(points.get(segment), points.get(segment + 1)) - travelled;
        }

        private void apply(Location from, Location to, double progress) {
            double x = from.getX() + (to.getX() - from.getX()) * progress;
            double z = from.getZ() + (to.getZ() - from.getZ()) * progress;
            double y;
            if (settings.isFlying() || !settings.isClampToGround()) {
                y = from.getY() + (to.getY() - from.getY()) * progress;
            } else if (progress >= 1) {
                y = to.getY();
            } else {
                y = Math.max(from.getY(), to.getY());
            }
            double dx = to.getX() - from.getX();
            double dz = to.getZ() - from.getZ();
            Location current = entity.getLocation();
            float yaw = dx == 0 && dz == 0 ? current.getYaw() : (float) Math.toDegrees(Math.atan2(-dx, dz));
            Location next = new Location(x, y, z, yaw, 0);
            if (settings.isUpdatingViewers()) {
                entity.move(next);
            } else {
                entity.setLocationSilently(next);
            }
        }

    }

}
