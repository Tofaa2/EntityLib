package me.tofaa.entitylib.movement;

import com.github.retrooper.packetevents.protocol.world.Location;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathImpl implements MovementEngine.Path {
    private final List<Location> points;
    private final Location start;
    private final Location end;
    private final double totalDistance;

    public PathImpl(@NotNull List<Location> points, @NotNull Location start, @NotNull Location end) {
        this.points = Collections.unmodifiableList(new ArrayList<>(points));
        this.start = start;
        this.end = end;
        double distance = 0;
        for (int i = 0; i < this.points.size() - 1; i++) {
            distance += distance(this.points.get(i), this.points.get(i + 1));
        }
        this.totalDistance = distance;
    }

    @Override
    public @NotNull List<Location> getPoints() {
        return points;
    }

    @Override
    public @NotNull Location getStart() {
        return start;
    }

    @Override
    public @NotNull Location getEnd() {
        return end;
    }

    @Override
    public double getTotalDistance() {
        return totalDistance;
    }

    @Override
    public int getSize() {
        return points.size();
    }

    static double distance(Location a, Location b) {
        double dx = b.getX() - a.getX();
        double dy = b.getY() - a.getY();
        double dz = b.getZ() - a.getZ();
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }
}
