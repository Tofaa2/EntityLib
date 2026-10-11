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

    public PathImpl(@NotNull List<Location> points, @NotNull Location start, @NotNull Location end) {
        this.points = new ArrayList<>(points);
        this.start = start;
        this.end = end;
    }

    @Override
    public @NotNull List<Location> getPoints() {
        return Collections.unmodifiableList(points);
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
        double distance = 0;
        for (int i = 0; i < points.size() - 1; i++) {
            distance += distance(points.get(i), points.get(i + 1));
        }
        return distance;
    }

    @Override
    public int getSize() {
        return points.size();
    }

    private double distance(Location a, Location b) {
        double dx = b.getX() - a.getX();
        double dy = b.getY() - a.getY();
        double dz = b.getZ() - a.getZ();
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }
}
