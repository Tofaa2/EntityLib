package me.tofaa.entitylib.movement;

import com.github.retrooper.packetevents.protocol.world.Location;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;

public class DefaultMovementEngine implements MovementEngine {

    private static final double DEFAULT_COST = 1.0;
    private static final double DIAGONAL_COST = 1.414;
    private static final double VERTICAL_COST = 1.0;

    private final WorldAccessor worldAccessor;
    private final Executor pathfindingExecutor;
    private final Map<String, Path> pathCache;
    private final int maxCacheSize;

    public DefaultMovementEngine() {
        this(ForkJoinPool.commonPool(), 100);
    }

    public DefaultMovementEngine(Executor pathfindingExecutor) {
        this(pathfindingExecutor, 100);
    }

    public DefaultMovementEngine(Executor pathfindingExecutor, int maxCacheSize) {
        this.worldAccessor = new SpigotWorldAccessor();
        this.pathfindingExecutor = pathfindingExecutor;
        this.pathCache = new HashMap<>();
        this.maxCacheSize = maxCacheSize;
    }

    public DefaultMovementEngine(WorldAccessor worldAccessor, Executor pathfindingExecutor, int maxCacheSize) {
        this.worldAccessor = worldAccessor;
        this.pathfindingExecutor = pathfindingExecutor;
        this.pathCache = new HashMap<>();
        this.maxCacheSize = maxCacheSize;
    }

    @Override
    public @NotNull Executor getPathfindingExecutor() {
        return pathfindingExecutor;
    }

    @Override
    public @NotNull CompletableFuture<@Nullable Path> findPath(
            @NotNull Location from,
            @NotNull Location to,
            @NotNull PathfindSettings settings
    ) {
        return CompletableFuture.supplyAsync(() -> {
            String cacheKey = createCacheKey(from, to);
            Path cached = pathCache.get(cacheKey);
            if (cached != null) {
                return cached;
            }

            return calculatePath(from, to, settings);
        }, pathfindingExecutor);
    }

    @Override
    public @NotNull CompletableFuture<@Nullable Path> findPath(
            @NotNull WrapperEntity entity,
            @NotNull Location to,
            @NotNull PathfindSettings settings
    ) {
        return findPath(entity.getLocation(), to, settings);
    }

    private @Nullable Path calculatePath(Location from, Location to, PathfindSettings settings) {
        double directDistance = distance(from, to);
        if (directDistance > settings.getSearchRange()) {
            return null;
        }

        if (directDistance > settings.getDistanceCutoff()) {
            return null;
        }

        Node startNode = new Node(from);
        Node goalNode = new Node(to);

        Map<String, Node> openSet = new HashMap<>();
        Map<String, Node> closedSet = new HashMap<>();

        openSet.put(createNodeKey(startNode), startNode);

        int nodesSearched = 0;
        int maxNodes = settings.getMaxSearchNodes();

        while (!openSet.isEmpty() && nodesSearched < maxNodes) {
            Node current = getLowestFCostNode(openSet);

            if (distance(current.getPosition(), to) <= 1.0) {
                List<Location> path = reconstructPath(current);
                PathImpl pathImpl = new PathImpl(path, from, to);

                if (pathCache.size() >= maxCacheSize) {
                    pathCache.clear();
                }
                pathCache.put(createCacheKey(from, to), pathImpl);

                return pathImpl;
            }

            openSet.remove(createNodeKey(current));
            closedSet.put(createNodeKey(current), current);
            nodesSearched++;

            List<Node> neighbors = getNeighbors(current, settings);
            for (Node neighbor : neighbors) {
                String neighborKey = createNodeKey(neighbor);

                if (closedSet.containsKey(neighborKey)) {
                    continue;
                }

                double tentativeGCost = current.getGCost() + getMovementCost(current.getPosition(), neighbor.getPosition());

                Node existing = openSet.get(neighborKey);
                if (existing == null) {
                    neighbor.setGCost(tentativeGCost);
                    neighbor.setHCost(distance(neighbor.getPosition(), to));
                    neighbor.setParent(current);
                    openSet.put(neighborKey, neighbor);
                } else if (tentativeGCost < existing.getGCost()) {
                    existing.setGCost(tentativeGCost);
                    existing.setParent(current);
                }
            }
        }

        return null;
    }

    private Node getLowestFCostNode(Map<String, Node> openSet) {
        Node lowest = null;
        for (Node node : openSet.values()) {
            if (lowest == null || node.getFCost() < lowest.getFCost()) {
                lowest = node;
            }
        }
        return lowest;
    }

    private List<Node> getNeighbors(Node node, PathfindSettings settings) {
        List<Node> neighbors = new ArrayList<>();
        Location pos = node.getPosition();

        int[][] directions;
        if (settings.isAllowingJump()) {
            directions = new int[][]{
                    {1, 0, 0}, {-1, 0, 0}, {0, 0, 1}, {0, 0, -1},
                    {1, 0, 1}, {1, 0, -1}, {-1, 0, 1}, {-1, 0, -1},
                    {0, 1, 0}, {0, -1, 0}, {1, 1, 0}, {-1, 1, 0},
                    {0, 1, 1}, {0, 1, -1}, {1, 1, 1}, {1, 1, -1},
                    {-1, 1, 1}, {-1, 1, -1}, {0, -1, 0}
            };
        } else {
            directions = new int[][]{
                    {1, 0, 0}, {-1, 0, 0}, {0, 0, 1}, {0, 0, -1},
                    {1, 0, 1}, {1, 0, -1}, {-1, 0, 1}, {-1, 0, -1}
            };
        }

        for (int[] dir : directions) {
            double newX = pos.getX() + dir[0];
            double newY = pos.getY() + dir[1];
            double newZ = pos.getZ() + dir[2];

            Location newPos = new Location(newX, newY, newZ, pos.getYaw(), pos.getPitch());

            if (isValidPosition(newPos, settings)) {
                neighbors.add(new Node(newPos, node, node.getGCost(), 0));
            }
        }

        return neighbors;
    }

    private boolean isValidPosition(Location location, PathfindSettings settings) {
        int x = (int) Math.floor(location.getX());
        int y = (int) Math.floor(location.getY());
        int z = (int) Math.floor(location.getZ());

        if (!worldAccessor.isChunkLoaded(x, z)) {
            return false;
        }

        if (!worldAccessor.isWalkable(x, y, z)) {
            return false;
        }

        if (!settings.isAllowingSwimming() && !worldAccessor.isWalkable(x, y + 1, z)) {
            return !worldAccessor.isLiquid(x, y + 1, z);
        }

        return true;
    }

    private double getMovementCost(Location from, Location to) {
        double dx = Math.abs(to.getX() - from.getX());
        double dy = Math.abs(to.getY() - from.getY());
        double dz = Math.abs(to.getZ() - from.getZ());

        if (dy > 0) {
            return VERTICAL_COST;
        }

        if (dx > 0 && dz > 0) {
            return DIAGONAL_COST;
        }

        return DEFAULT_COST;
    }

    private List<Location> reconstructPath(Node endNode) {
        List<Location> path = new ArrayList<>();
        Node current = endNode;

        while (current != null) {
            path.add(current.getPosition());
            current = current.getParent();
        }

        Collections.reverse(path);
        return path;
    }

    private String createNodeKey(Node node) {
        Location pos = node.getPosition();
        return String.format("%d,%d,%d",
                (int) Math.floor(pos.getX()),
                (int) Math.floor(pos.getY()),
                (int) Math.floor(pos.getZ()));
    }

    private String createCacheKey(Location from, Location to) {
        return String.format("%s->%s", createNodeKey(new Node(from)), createNodeKey(new Node(to)));
    }

    private double distance(Location a, Location b) {
        double dx = b.getX() - a.getX();
        double dy = b.getY() - a.getY();
        double dz = b.getZ() - a.getZ();
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    @Override
    public void moveToPath(me.tofaa.entitylib.wrapper.WrapperEntity entity, Path path, MovementSettings settings) {
    }

    @Override
    public void stopMovement(me.tofaa.entitylib.wrapper.WrapperEntity entity) {
    }

    @Override
    public boolean isMoving(me.tofaa.entitylib.wrapper.WrapperEntity entity) {
        return false;
    }

    @Override
    public void clearCache() {
        pathCache.clear();
    }

    @Override
    public @NotNull Path getCachedPath(Location from, Location to) {
        return pathCache.get(createCacheKey(from, to));
    }

    @Override
    public void cachePath(Path path) {
        String key = createCacheKey(path.getStart(), path.getEnd());
        if (pathCache.size() >= maxCacheSize) {
            pathCache.clear();
        }
        pathCache.put(key, path);
    }

    public interface WorldAccessor {
        boolean isChunkLoaded(int x, int z);

        boolean isWalkable(int x, int y, int z);

        boolean isLiquid(int x, int y, int z);
    }

    private static class SpigotWorldAccessor implements WorldAccessor {
        @Override
        public boolean isChunkLoaded(int x, int z) {
            return true;
        }

        @Override
        public boolean isWalkable(int x, int y, int z) {
            return true;
        }

        @Override
        public boolean isLiquid(int x, int y, int z) {
            return false;
        }
    }
}
