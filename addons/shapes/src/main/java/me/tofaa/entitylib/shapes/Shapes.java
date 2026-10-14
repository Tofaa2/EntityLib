package me.tofaa.entitylib.shapes;

import me.tofaa.entitylib.display.DisplayElement;
import me.tofaa.entitylib.display.DisplayGroup;
import me.tofaa.entitylib.display.math.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public final class Shapes {

    private Shapes() {
    }

    public static @NotNull List<Vec3> line(@NotNull Vec3 from, @NotNull Vec3 to, int points) {
        List<Vec3> result = new ArrayList<>(points);
        for (int i = 0; i < points; i++) {
            result.add(from.lerp(to, points == 1 ? 0 : i / (double) (points - 1)));
        }
        return result;
    }

    public static @NotNull List<Vec3> ring(double radius, int points) {
        List<Vec3> result = new ArrayList<>(points);
        for (int i = 0; i < points; i++) {
            double angle = 2 * Math.PI * i / points;
            result.add(new Vec3(Math.cos(angle) * radius, 0, Math.sin(angle) * radius));
        }
        return result;
    }

    public static @NotNull List<Vec3> sphere(double radius, int points) {
        List<Vec3> result = new ArrayList<>(points);
        double golden = Math.PI * (3 - Math.sqrt(5));
        for (int i = 0; i < points; i++) {
            double y = points == 1 ? 0 : 1 - 2.0 * i / (points - 1);
            double ring = Math.sqrt(Math.max(0, 1 - y * y));
            double angle = golden * i;
            result.add(new Vec3(Math.cos(angle) * ring * radius, y * radius, Math.sin(angle) * ring * radius));
        }
        return result;
    }

    public static @NotNull List<Vec3> helix(double radius, double height, double turns, int points) {
        List<Vec3> result = new ArrayList<>(points);
        for (int i = 0; i < points; i++) {
            double progress = points == 1 ? 0 : i / (double) (points - 1);
            double angle = 2 * Math.PI * turns * progress;
            result.add(new Vec3(Math.cos(angle) * radius, progress * height, Math.sin(angle) * radius));
        }
        return result;
    }

    public static @NotNull List<Vec3> path(@NotNull List<Vec3> waypoints, int points) {
        if (waypoints.isEmpty() || points <= 0) {
            return new ArrayList<>();
        }
        if (waypoints.size() == 1) {
            return new ArrayList<>(List.of(waypoints.get(0)));
        }
        double total = 0;
        for (int i = 1; i < waypoints.size(); i++) {
            total += waypoints.get(i).sub(waypoints.get(i - 1)).length();
        }
        List<Vec3> result = new ArrayList<>(points);
        for (int i = 0; i < points; i++) {
            double target = points == 1 ? 0 : total * i / (points - 1);
            double walked = 0;
            Vec3 point = waypoints.get(waypoints.size() - 1);
            for (int segment = 1; segment < waypoints.size(); segment++) {
                Vec3 from = waypoints.get(segment - 1);
                Vec3 to = waypoints.get(segment);
                double length = to.sub(from).length();
                if (walked + length >= target) {
                    point = length == 0 ? from : from.lerp(to, (target - walked) / length);
                    break;
                }
                walked += length;
            }
            result.add(point);
        }
        return result;
    }

    public static @NotNull DisplayGroup display(@NotNull List<Vec3> points, @NotNull ParticleMaterial material, double size) {
        DisplayGroup group = new DisplayGroup();
        for (Vec3 point : points) {
            DisplayElement element = material.create().position(point).scale(size);
            group.add(element);
        }
        return group;
    }

}
