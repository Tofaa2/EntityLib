package me.tofaa.entitylib.shapes;

import com.github.retrooper.packetevents.protocol.world.Location;
import me.tofaa.entitylib.display.DisplayElement;
import me.tofaa.entitylib.display.DisplayGroup;
import me.tofaa.entitylib.display.math.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.UUID;

public final class Trail {

    private static final double REANCHOR_DISTANCE = 48;

    private final DisplayGroup group = new DisplayGroup();
    private final List<DisplayElement> elements = new ArrayList<>();
    private final Deque<Vec3> history = new ArrayDeque<>();
    private final double size;
    private Vec3 anchor = Vec3.ZERO;

    public Trail(@NotNull ParticleMaterial material, int length, double size) {
        this.size = size;
        for (int i = 0; i < length; i++) {
            DisplayElement element = material.create().visible(false);
            elements.add(element);
            group.add(element);
        }
    }

    public @NotNull DisplayGroup group() {
        return group;
    }

    public @NotNull Trail interpolationTicks(int ticks) {
        group.setInterpolationTicks(ticks);
        return this;
    }

    public void addViewer(@NotNull UUID viewer) {
        group.addViewer(viewer);
    }

    public void removeViewer(@NotNull UUID viewer) {
        group.removeViewer(viewer);
    }

    public synchronized void spawn(@NotNull Location head) {
        anchor = new Vec3(head.getX(), head.getY(), head.getZ());
        history.clear();
        group.spawn(new Location(head.getX(), head.getY(), head.getZ(), 0, 0));
        advance(head);
    }

    public synchronized void advance(@NotNull Location head) {
        Vec3 position = new Vec3(head.getX(), head.getY(), head.getZ());
        if (position.sub(anchor).length() > REANCHOR_DISTANCE) {
            anchor = position;
            group.teleport(new Location(head.getX(), head.getY(), head.getZ(), 0, 0));
        }
        history.addFirst(position);
        while (history.size() > elements.size()) {
            history.removeLast();
        }
        int index = 0;
        for (Vec3 point : history) {
            double fade = 1 - index / (double) elements.size();
            elements.get(index).position(point.sub(anchor)).scale(size * fade).visible(true);
            index++;
        }
        group.update();
    }

    public synchronized void remove() {
        history.clear();
        group.remove();
    }

}
