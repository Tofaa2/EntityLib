package me.tofaa.entitylib.movement;

import com.github.retrooper.packetevents.protocol.world.Location;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SpigotMovementEngine extends DefaultMovementEngine {

    private final Map<Integer, ActiveMovement> activeMovements;

    public SpigotMovementEngine() {
        super();
        this.activeMovements = new ConcurrentHashMap<>();
    }

    public SpigotMovementEngine(Executor pathfindingExecutor) {
        super(pathfindingExecutor);
        this.activeMovements = new ConcurrentHashMap<>();
    }

    public SpigotMovementEngine(Executor pathfindingExecutor, int maxCacheSize) {
        super(pathfindingExecutor, maxCacheSize);
        this.activeMovements = new ConcurrentHashMap<>();
    }

    public SpigotMovementEngine(WorldAccessor worldAccessor, Executor pathfindingExecutor, int maxCacheSize) {
        super(worldAccessor, pathfindingExecutor, maxCacheSize);
        this.activeMovements = new ConcurrentHashMap<>();
    }

    @Override
    public @NotNull CompletableFuture<@Nullable Path> findPath(
            @NotNull WrapperEntity entity,
            @NotNull Location to,
            @NotNull PathfindSettings settings
    ) {
        return super.findPath(entity, to, settings);
    }

    @Override
    public void moveToPath(@NotNull WrapperEntity entity, @NotNull Path path, @NotNull MovementSettings settings) {
        if (path.getPoints().isEmpty()) {
            return;
        }

        ActiveMovement movement = new ActiveMovement(entity, path, settings);
        activeMovements.put(entity.getEntityId(), movement);
    }

    @Override
    public void stopMovement(@NotNull WrapperEntity entity) {
        ActiveMovement movement = activeMovements.remove(entity.getEntityId());
    }

    @Override
    public boolean isMoving(@NotNull WrapperEntity entity) {
        return activeMovements.containsKey(entity.getEntityId());
    }

    public @Nullable ActiveMovement getActiveMovement(@NotNull WrapperEntity entity) {
        return activeMovements.get(entity.getEntityId());
    }

    public void tick() {
        for (ActiveMovement movement : activeMovements.values()) {
            if (movement.isPaused()) continue;
            if (movement.isFinished()) {
                activeMovements.remove(movement.getEntity().getEntityId());
                continue;
            }

            processMovementTick(movement);
        }
    }

    private void processMovementTick(ActiveMovement movement) {
        Location target = movement.getCurrentTarget();
        if (target == null) return;

        WrapperEntity entity = movement.getEntity();
        Location current = entity.getLocation();

        double dist = distance(current, target);
        double speed = movement.getSettings().getSpeed() * movement.getSettings().getSpeedModifier();

        if (dist <= movement.getSettings().getFollowDistance()) {
            movement.setCurrentPointIndex(movement.getCurrentPointIndex() + 1);
            return;
        }

        double dx = target.getX() - current.getX();
        double dy = target.getY() - current.getY();
        double dz = target.getZ() - current.getZ();

        double length = Math.sqrt(dx * dx + dy * dy + dz * dz);
        dx /= length;
        dy /= length;
        dz /= length;

        double moveX = dx * speed * movement.getSettings().getTickRate();
        double moveY = dy * speed * movement.getSettings().getTickRate();
        double moveZ = dz * speed * movement.getSettings().getTickRate();

        Location newLocation = new Location(
                current.getX() + moveX,
                current.getY() + moveY,
                current.getZ() + moveZ,
                (float) Math.toDegrees(Math.atan2(dz, dx)),
                0
        );

        if (movement.getSettings().isUpdatingViewers()) {
            entity.teleport(newLocation);
        } else {
            entity.setLocation(newLocation);
        }
    }

    private double distance(Location a, Location b) {
        double dx = b.getX() - a.getX();
        double dy = b.getY() - a.getY();
        double dz = b.getZ() - a.getZ();
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    public static class ActiveMovement {
        private final WrapperEntity entity;
        private final Path path;
        private final MovementSettings settings;
        private int currentPointIndex;
        private boolean paused;

        public ActiveMovement(WrapperEntity entity, Path path, MovementSettings settings) {
            this.entity = entity;
            this.path = path;
            this.settings = settings;
            this.currentPointIndex = 0;
            this.paused = false;
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

        public int getCurrentPointIndex() {
            return currentPointIndex;
        }

        public void setCurrentPointIndex(int index) {
            this.currentPointIndex = index;
        }

        public boolean isPaused() {
            return paused;
        }

        public void setPaused(boolean paused) {
            this.paused = paused;
        }

        public boolean isFinished() {
            return currentPointIndex >= path.getPoints().size() - 1;
        }

        public @Nullable Location getCurrentTarget() {
            if (isFinished()) {
                return null;
            }
            return path.getPoints().get(currentPointIndex);
        }
    }
}
