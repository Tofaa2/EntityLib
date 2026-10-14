package me.tofaa.entitylib.movement;

import com.github.retrooper.packetevents.protocol.world.Location;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Pathfinder {

    private static final double SQRT2 = Math.sqrt(2);
    private static final double SQRT3 = Math.sqrt(3);
    private static final double STEP_UP_COST = 0.5;
    private static final double STEP_DOWN_COST = 0.25;
    private static final double WATER_COST = 6;
    private static final double TIE_BREAK = 1.001;
    private static final double SAMPLE_STEP = 0.2;
    private static final double HALF_WIDTH = 0.3;
    private static final int[][] HORIZONTAL = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
    };
    private static final int[][] SPATIAL = spatialDirections();

    private final WorldAccessor world;
    private final boolean flying;
    private final boolean jump;
    private final boolean swim;
    private final int height;
    private final int maxDrop;
    private final int maxNodes;
    private final boolean avoidWater;

    private long[] keys = new long[256];
    private float[] cost = new float[256];
    private float[] score = new float[256];
    private int[] parent = new int[256];
    private int[] heapPosition = new int[256];
    private boolean[] closed = new boolean[256];
    private int count;

    private long[] tableKeys = new long[1024];
    private int[] tableValues = new int[1024];
    private int tableSize;

    private int[] heap = new int[256];
    private int heapSize;

    private int goalX;
    private int goalY;
    private int goalZ;

    private Pathfinder(WorldAccessor world, MovementEngine.PathfindSettings settings) {
        this.world = world;
        this.flying = settings.isFlying();
        this.jump = settings.isAllowingJump();
        this.swim = settings.isAllowingSwimming();
        this.height = Math.max(1, settings.getEntityHeight());
        this.maxDrop = Math.max(0, settings.getMaxDropHeight());
        this.maxNodes = Math.max(1, settings.getMaxSearchNodes());
        this.avoidWater = settings.isAvoidingWater();
    }

    public static boolean isStandable(@NotNull WorldAccessor world, @NotNull Location location,
                                      @NotNull MovementEngine.PathfindSettings settings) {
        Pathfinder finder = new Pathfinder(world, settings);
        int x = floor(location.getX());
        int y = floor(location.getY());
        int z = floor(location.getZ());
        return finder.standable(x, y, z);
    }

    public static boolean isTraversable(@NotNull WorldAccessor world, @NotNull Location from, @NotNull Location to,
                                        @NotNull MovementEngine.PathfindSettings settings) {
        Pathfinder finder = new Pathfinder(world, settings);
        int y = floor(Math.max(from.getY(), to.getY()));
        int steps = (int) Math.ceil(PathImpl.distance(from, to) / 0.5);
        for (int step = 1; step < steps; step++) {
            double progress = step / (double) steps;
            int x = floor(from.getX() + (to.getX() - from.getX()) * progress);
            int z = floor(from.getZ() + (to.getZ() - from.getZ()) * progress);
            if (!world.isLoaded(x, z) || !finder.clear(x, y, z)) {
                return false;
            }
        }
        return finder.standable(floor(to.getX()), floor(to.getY()), floor(to.getZ()));
    }

    public static @Nullable List<Location> find(@NotNull WorldAccessor world, @NotNull Location from, @NotNull Location to,
                                                @NotNull MovementEngine.PathfindSettings settings) {
        double range = Math.min(settings.getSearchRange(), settings.getDistanceCutoff());
        if (PathImpl.distance(from, to) > range) {
            return null;
        }
        Pathfinder finder = new Pathfinder(world, settings);
        return finder.search(from, to, settings.isSmoothing());
    }

    private List<Location> search(Location from, Location to, boolean smooth) {
        int startX = floor(from.getX());
        int startY = floor(from.getY());
        int startZ = floor(from.getZ());
        if (!flying && !standable(startX, startY, startZ)) {
            startY = settle(startX, startY, startZ);
        }
        goalX = floor(to.getX());
        goalY = floor(to.getY());
        goalZ = floor(to.getZ());
        if (!standable(goalX, goalY, goalZ)) {
            if (flying) {
                return null;
            }
            int settled = settle(goalX, goalY, goalZ);
            if (!standable(goalX, settled, goalZ)) {
                return null;
            }
            goalY = settled;
        }

        long goalKey = pack(goalX, goalY, goalZ);
        int start = create(pack(startX, startY, startZ), 0, -1, startX, startY, startZ);
        push(start);

        while (heapSize > 0) {
            int current = pop();
            if (closed[current]) {
                continue;
            }
            closed[current] = true;
            long key = keys[current];
            if (key == goalKey) {
                List<Location> points = reconstruct(current, from, to);
                return smooth ? smooth(points) : points;
            }
            int x = unpackX(key);
            int y = unpackY(key);
            int z = unpackZ(key);
            if (flying) {
                expandFlying(current, x, y, z);
            } else {
                expandGround(current, x, y, z);
            }
        }
        return null;
    }

    private void expandGround(int current, int x, int y, int z) {
        for (int[] direction : HORIZONTAL) {
            int dx = direction[0];
            int dz = direction[1];
            boolean diagonal = dx != 0 && dz != 0;
            if (diagonal && (!clear(x + dx, y, z) || !clear(x, y, z + dz))) {
                continue;
            }
            int nx = x + dx;
            int nz = z + dz;
            if (!world.isLoaded(nx, nz)) {
                continue;
            }
            int ny;
            if (standable(nx, y, nz)) {
                ny = y;
            } else if (clear(nx, y, nz)) {
                ny = Integer.MIN_VALUE;
                for (int drop = 1; drop <= maxDrop; drop++) {
                    if (world.isSolid(nx, y - drop, nz)) {
                        break;
                    }
                    if (standable(nx, y - drop, nz)) {
                        ny = y - drop;
                        break;
                    }
                }
                if (ny == Integer.MIN_VALUE) {
                    continue;
                }
            } else if (jump && !diagonal && !world.isSolid(x, y + height, z) && standable(nx, y + 1, nz)) {
                ny = y + 1;
            } else {
                continue;
            }
            double step = diagonal ? SQRT2 : 1;
            if (ny > y) {
                step += STEP_UP_COST * (ny - y);
            } else if (ny < y) {
                step += STEP_DOWN_COST * (y - ny);
            }
            relax(current, nx, ny, nz, step);
        }
    }

    private void expandFlying(int current, int x, int y, int z) {
        for (int[] direction : SPATIAL) {
            int dx = direction[0];
            int dy = direction[1];
            int dz = direction[2];
            int nx = x + dx;
            int ny = y + dy;
            int nz = z + dz;
            if (!world.isLoaded(nx, nz) || !clear(nx, ny, nz)) {
                continue;
            }
            int axes = Math.abs(dx) + Math.abs(dy) + Math.abs(dz);
            if (axes > 1 && ((dx != 0 && !clear(x + dx, y, z)) || (dy != 0 && !clear(x, y + dy, z))
                || (dz != 0 && !clear(x, y, z + dz)))) {
                continue;
            }
            relax(current, nx, ny, nz, axes == 1 ? 1 : axes == 2 ? SQRT2 : SQRT3);
        }
    }

    private void relax(int current, int x, int y, int z, double step) {
        if (avoidWater && world.isLiquid(x, y, z)) {
            step += WATER_COST;
        }
        long key = pack(x, y, z);
        float tentative = (float) (cost[current] + step);
        int index = lookup(key);
        if (index < 0) {
            if (count >= maxNodes) {
                return;
            }
            index = create(key, tentative, current, x, y, z);
            push(index);
            return;
        }
        if (closed[index] || tentative >= cost[index]) {
            return;
        }
        score[index] = score[index] - cost[index] + tentative;
        cost[index] = tentative;
        parent[index] = current;
        if (heapPosition[index] >= 0) {
            siftUp(heapPosition[index]);
        } else {
            push(index);
        }
    }

    private double heuristic(int x, int y, int z) {
        int dx = Math.abs(goalX - x);
        int dy = Math.abs(goalY - y);
        int dz = Math.abs(goalZ - z);
        if (flying) {
            int max = Math.max(dx, Math.max(dy, dz));
            int min = Math.min(dx, Math.min(dy, dz));
            int mid = dx + dy + dz - max - min;
            return ((SQRT3 - SQRT2) * min + (SQRT2 - 1) * mid + max) * TIE_BREAK;
        }
        return (Math.max(dx, dz) + (SQRT2 - 1) * Math.min(dx, dz) + STEP_DOWN_COST * dy) * TIE_BREAK;
    }

    private boolean clear(int x, int y, int z) {
        for (int offset = 0; offset < height; offset++) {
            if (world.isSolid(x, y + offset, z)) {
                return false;
            }
        }
        return true;
    }

    private boolean standable(int x, int y, int z) {
        if (!world.isLoaded(x, z) || !clear(x, y, z)) {
            return false;
        }
        if (flying) {
            return true;
        }
        boolean liquid = world.isLiquid(x, y, z);
        if (liquid) {
            return swim;
        }
        return world.isSolid(x, y - 1, z);
    }

    private int settle(int x, int y, int z) {
        if (standable(x, y + 1, z)) {
            return y + 1;
        }
        for (int drop = 1; drop <= Math.max(maxDrop, 1); drop++) {
            if (standable(x, y - drop, z)) {
                return y - drop;
            }
        }
        return y;
    }

    private List<Location> reconstruct(int end, Location from, Location to) {
        List<Location> points = new ArrayList<>();
        for (int index = end; index >= 0; index = parent[index]) {
            long key = keys[index];
            points.add(new Location(unpackX(key) + 0.5, unpackY(key), unpackZ(key) + 0.5, 0, 0));
        }
        Collections.reverse(points);
        points.set(0, new Location(from.getX(), points.get(0).getY(), from.getZ(), from.getYaw(), from.getPitch()));
        int last = points.size() - 1;
        Location destination = new Location(to.getX(), flying ? to.getY() : points.get(last).getY(), to.getZ(), 0, 0);
        if (last == 0) {
            points.add(destination);
        } else {
            points.set(last, destination);
        }
        return points;
    }

    private List<Location> smooth(List<Location> points) {
        if (points.size() < 3) {
            return points;
        }
        List<Location> result = new ArrayList<>();
        int index = 0;
        result.add(points.get(0));
        while (index < points.size() - 1) {
            int next = index + 1;
            for (int candidate = points.size() - 1; candidate > index + 1; candidate--) {
                if (direct(points.get(index), points.get(candidate))) {
                    next = candidate;
                    break;
                }
            }
            result.add(points.get(next));
            index = next;
        }
        return result;
    }

    private boolean direct(Location from, Location to) {
        if (!flying && floor(from.getY()) != floor(to.getY())) {
            return false;
        }
        double dx = to.getX() - from.getX();
        double dy = to.getY() - from.getY();
        double dz = to.getZ() - from.getZ();
        double length = Math.sqrt(dx * dx + dy * dy + dz * dz);
        if (length == 0) {
            return true;
        }
        double horizontal = Math.sqrt(dx * dx + dz * dz);
        double sideX = horizontal == 0 ? 0 : -dz / horizontal * HALF_WIDTH;
        double sideZ = horizontal == 0 ? 0 : dx / horizontal * HALF_WIDTH;
        int steps = (int) Math.ceil(length / SAMPLE_STEP);
        for (int step = 0; step <= steps; step++) {
            double progress = step / (double) steps;
            double x = from.getX() + dx * progress;
            double y = from.getY() + dy * progress;
            double z = from.getZ() + dz * progress;
            int blockY = floor(y);
            if (!standable(floor(x + sideX), blockY, floor(z + sideZ)) || !standable(floor(x - sideX), blockY, floor(z - sideZ))) {
                return false;
            }
        }
        return true;
    }

    private int create(long key, float nodeCost, int nodeParent, int x, int y, int z) {
        if (count == keys.length) {
            int capacity = count * 2;
            keys = Arrays.copyOf(keys, capacity);
            cost = Arrays.copyOf(cost, capacity);
            score = Arrays.copyOf(score, capacity);
            parent = Arrays.copyOf(parent, capacity);
            heapPosition = Arrays.copyOf(heapPosition, capacity);
            closed = Arrays.copyOf(closed, capacity);
        }
        int index = count++;
        keys[index] = key;
        cost[index] = nodeCost;
        score[index] = (float) (nodeCost + heuristic(x, y, z));
        parent[index] = nodeParent;
        heapPosition[index] = -1;
        put(key, index);
        return index;
    }

    private int lookup(long key) {
        int mask = tableKeys.length - 1;
        int slot = hash(key) & mask;
        while (tableValues[slot] != 0) {
            if (tableKeys[slot] == key) {
                return tableValues[slot] - 1;
            }
            slot = (slot + 1) & mask;
        }
        return -1;
    }

    private void put(long key, int index) {
        if ((tableSize + 1) * 2 > tableKeys.length) {
            long[] oldKeys = tableKeys;
            int[] oldValues = tableValues;
            tableKeys = new long[oldKeys.length * 2];
            tableValues = new int[oldValues.length * 2];
            tableSize = 0;
            for (int i = 0; i < oldKeys.length; i++) {
                if (oldValues[i] != 0) {
                    insert(oldKeys[i], oldValues[i]);
                }
            }
        }
        insert(key, index + 1);
    }

    private void insert(long key, int value) {
        int mask = tableKeys.length - 1;
        int slot = hash(key) & mask;
        while (tableValues[slot] != 0) {
            slot = (slot + 1) & mask;
        }
        tableKeys[slot] = key;
        tableValues[slot] = value;
        tableSize++;
    }

    private void push(int index) {
        if (heapSize == heap.length) {
            heap = Arrays.copyOf(heap, heapSize * 2);
        }
        heap[heapSize] = index;
        heapPosition[index] = heapSize;
        siftUp(heapSize++);
    }

    private int pop() {
        int top = heap[0];
        heapPosition[top] = -1;
        int last = heap[--heapSize];
        if (heapSize > 0) {
            heap[0] = last;
            heapPosition[last] = 0;
            siftDown(0);
        }
        return top;
    }

    private void siftUp(int position) {
        int index = heap[position];
        float value = score[index];
        while (position > 0) {
            int above = (position - 1) >>> 1;
            int other = heap[above];
            if (score[other] <= value) {
                break;
            }
            heap[position] = other;
            heapPosition[other] = position;
            position = above;
        }
        heap[position] = index;
        heapPosition[index] = position;
    }

    private void siftDown(int position) {
        int index = heap[position];
        float value = score[index];
        int half = heapSize >>> 1;
        while (position < half) {
            int child = 2 * position + 1;
            int right = child + 1;
            if (right < heapSize && score[heap[right]] < score[heap[child]]) {
                child = right;
            }
            int other = heap[child];
            if (value <= score[other]) {
                break;
            }
            heap[position] = other;
            heapPosition[other] = position;
            position = child;
        }
        heap[position] = index;
        heapPosition[index] = position;
    }

    static long pack(int x, int y, int z) {
        return ((long) (x & 0x3FFFFFF) << 38) | ((long) (z & 0x3FFFFFF) << 12) | (y & 0xFFF);
    }

    private static int unpackX(long key) {
        return (int) (key >> 38);
    }

    private static int unpackZ(long key) {
        return (int) (key << 26 >> 38);
    }

    private static int unpackY(long key) {
        return (int) (key << 52 >> 52);
    }

    private static int hash(long key) {
        long mixed = key * 0x9E3779B97F4A7C15L;
        return (int) (mixed ^ (mixed >>> 32));
    }

    static int floor(double value) {
        int truncated = (int) value;
        return value < truncated ? truncated - 1 : truncated;
    }

    private static int[][] spatialDirections() {
        int[][] directions = new int[26][];
        int index = 0;
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                for (int dz = -1; dz <= 1; dz++) {
                    if (dx != 0 || dy != 0 || dz != 0) {
                        directions[index++] = new int[]{dx, dy, dz};
                    }
                }
            }
        }
        return directions;
    }

}
