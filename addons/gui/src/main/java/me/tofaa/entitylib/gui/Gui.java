package me.tofaa.entitylib.gui;

import com.github.retrooper.packetevents.protocol.world.Location;
import me.tofaa.entitylib.display.DisplayGroup;
import me.tofaa.entitylib.display.math.Quat;
import me.tofaa.entitylib.display.math.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Gui {

    private final DisplayGroup group = new DisplayGroup();
    private final List<GuiElement> elements = new CopyOnWriteArrayList<>();
    private final Map<UUID, GuiElement> hovered = new ConcurrentHashMap<>();
    private volatile double reach = 6;

    public static @NotNull Location inFrontOf(@NotNull Location eye, double distance) {
        double yaw = Math.toRadians(eye.getYaw());
        return new Location(eye.getX() - Math.sin(yaw) * distance, eye.getY(), eye.getZ() + Math.cos(yaw) * distance,
            eye.getYaw() + 180, 0);
    }

    public @NotNull DisplayGroup group() {
        return group;
    }

    public @NotNull List<GuiElement> elements() {
        return Collections.unmodifiableList(elements);
    }

    public @NotNull Set<UUID> getViewers() {
        return group.getViewers();
    }

    public double reach() {
        return reach;
    }

    public @NotNull Gui reach(double reach) {
        this.reach = reach;
        return this;
    }

    public @NotNull Gui add(@NotNull GuiElement element) {
        elements.add(element);
        element.attach(this);
        return this;
    }

    public @NotNull Gui add(@NotNull GuiElement... elements) {
        for (GuiElement element : elements) {
            add(element);
        }
        return this;
    }

    public @NotNull Gui remove(@NotNull GuiElement element) {
        if (elements.remove(element)) {
            hovered.values().removeIf(current -> current == element);
            element.detach(this);
        }
        return this;
    }

    public void spawn(@NotNull Location location) {
        group.spawn(location);
        GuiInput.register(this);
    }

    public void teleport(@NotNull Location location) {
        group.teleport(location);
    }

    public void open(@NotNull UUID viewer) {
        group.addViewer(viewer);
    }

    public void close(@NotNull UUID viewer) {
        GuiElement previous = hovered.remove(viewer);
        if (previous != null) {
            previous.onHover(viewer, false);
        }
        group.removeViewer(viewer);
    }

    public void remove() {
        GuiInput.unregister(this);
        hovered.clear();
        group.remove();
    }

    public @Nullable GuiElement hovered(@NotNull UUID viewer) {
        return hovered.get(viewer);
    }

    void forget(UUID viewer) {
        hovered.remove(viewer);
    }

    void look(UUID viewer, Vec3 eye, Vec3 direction) {
        GuiElement target = pick(eye, direction);
        GuiElement previous = target == null ? hovered.remove(viewer) : hovered.put(viewer, target);
        if (previous == target) {
            return;
        }
        if (previous != null) {
            previous.onHover(viewer, false);
        }
        if (target != null) {
            target.onHover(viewer, true);
        }
    }

    void click(UUID viewer, GuiClick click) {
        GuiElement target = hovered.get(viewer);
        if (target != null) {
            target.onClick(viewer, click);
        }
    }

    private GuiElement pick(Vec3 eye, Vec3 direction) {
        if (!group.isSpawned()) {
            return null;
        }
        Location location = group.getLocation();
        Vec3 origin = new Vec3(location.getX(), location.getY(), location.getZ());
        Quat rotation = group.worldRotation();
        Vec3 normal = rotation.rotate(new Vec3(0, 0, 1));
        double facing = direction.dot(normal);
        if (facing >= 0) {
            return null;
        }
        double distance = origin.sub(eye).dot(normal) / facing;
        if (distance <= 0 || distance > reach) {
            return null;
        }
        Vec3 hit = eye.add(direction.scale(distance)).sub(origin);
        double scale = group.getScale();
        double pointX = hit.dot(rotation.rotate(new Vec3(1, 0, 0))) / scale;
        double pointY = hit.dot(rotation.rotate(new Vec3(0, 1, 0))) / scale;
        GuiElement best = null;
        for (GuiElement element : elements) {
            if (element.interactive() && element.contains(pointX, pointY) && (best == null || element.layer() >= best.layer())) {
                best = element;
            }
        }
        return best;
    }

}
