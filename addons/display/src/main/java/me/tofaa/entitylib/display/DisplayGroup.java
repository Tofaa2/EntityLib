package me.tofaa.entitylib.display;

import com.github.retrooper.packetevents.protocol.world.Location;
import com.github.retrooper.packetevents.util.Quaternion4f;
import com.github.retrooper.packetevents.util.Vector3f;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import me.tofaa.entitylib.display.math.Quat;
import me.tofaa.entitylib.display.math.Vec3;
import me.tofaa.entitylib.meta.MetaField;
import me.tofaa.entitylib.meta.MetaFields;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.utils.PacketBundles;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class DisplayGroup {

    private final List<DisplayElement> elements = new CopyOnWriteArrayList<>();
    private final Set<UUID> viewers = ConcurrentHashMap.newKeySet();
    private volatile Location location = new Location(0, 0, 0, 0, 0);
    private volatile Quat rotation = Quat.IDENTITY;
    private volatile double scale = 1;
    private volatile int interpolationTicks;
    private volatile boolean spawned;

    public @NotNull List<DisplayElement> elements() {
        return Collections.unmodifiableList(elements);
    }

    public synchronized @NotNull DisplayGroup add(@NotNull DisplayElement element) {
        elements.add(element);
        for (UUID viewer : viewers) {
            element.entity().addViewer(viewer);
        }
        if (spawned) {
            apply(element);
            element.entity().getMetadata().takeDirty();
            element.entity().spawn(anchor());
        }
        return this;
    }

    public synchronized @NotNull DisplayGroup remove(@NotNull DisplayElement element) {
        if (elements.remove(element)) {
            element.entity().remove();
        }
        return this;
    }

    public synchronized void clear() {
        for (DisplayElement element : elements) {
            element.entity().remove();
        }
        elements.clear();
    }

    public @NotNull Set<UUID> getViewers() {
        return Collections.unmodifiableSet(viewers);
    }

    public synchronized void addViewer(@NotNull UUID viewer) {
        viewers.add(viewer);
        for (DisplayElement element : elements) {
            element.entity().addViewer(viewer);
        }
    }

    public synchronized void removeViewer(@NotNull UUID viewer) {
        viewers.remove(viewer);
        for (DisplayElement element : elements) {
            element.entity().removeViewer(viewer);
        }
    }

    public boolean isSpawned() {
        return spawned;
    }

    public @NotNull Location getLocation() {
        return location;
    }

    public synchronized void spawn(@NotNull Location location) {
        this.location = location;
        Location anchor = anchor();
        for (DisplayElement element : elements) {
            apply(element);
            element.entity().spawn(anchor);
        }
        spawned = true;
    }

    public synchronized void despawn() {
        for (DisplayElement element : elements) {
            element.entity().despawn();
        }
        spawned = false;
    }

    public synchronized void remove() {
        for (DisplayElement element : elements) {
            element.entity().remove();
        }
        viewers.clear();
        spawned = false;
    }

    public synchronized void teleport(@NotNull Location location) {
        boolean rotated = location.getYaw() != this.location.getYaw();
        this.location = location;
        if (!spawned) {
            return;
        }
        Location anchor = anchor();
        for (DisplayElement element : elements) {
            element.entity().teleport(anchor);
        }
        if (rotated) {
            update();
        }
    }

    public @NotNull Quat getRotation() {
        return rotation;
    }

    public @NotNull DisplayGroup setRotation(@NotNull Quat rotation) {
        this.rotation = rotation;
        return this;
    }

    public double getScale() {
        return scale;
    }

    public @NotNull DisplayGroup setScale(double scale) {
        this.scale = scale;
        return this;
    }

    public int getInterpolationTicks() {
        return interpolationTicks;
    }

    public @NotNull DisplayGroup setInterpolationTicks(int interpolationTicks) {
        this.interpolationTicks = Math.max(0, interpolationTicks);
        return this;
    }

    public @NotNull Quat worldRotation() {
        return Quat.axisAngle(0, 1, 0, Math.toRadians(-location.getYaw())).mul(rotation);
    }

    public @NotNull Vec3 toWorld(@NotNull Vec3 local) {
        Vec3 rotated = worldRotation().rotate(local.scale(scale));
        return new Vec3(location.getX() + rotated.x(), location.getY() + rotated.y(), location.getZ() + rotated.z());
    }

    public synchronized void update() {
        if (!spawned) {
            for (DisplayElement element : elements) {
                apply(element);
            }
            return;
        }
        Map<DisplayElement, Set<MetaField<?>>> changed = new LinkedHashMap<>();
        for (DisplayElement element : elements) {
            apply(element);
            Metadata metadata = element.entity().getMetadata();
            if (metadata.hasDirty()) {
                changed.put(element, metadata.takeDirty());
            }
        }
        if (changed.isEmpty()) {
            return;
        }
        for (UUID viewer : viewers) {
            List<PacketWrapper<?>> packets = new ArrayList<>(changed.size());
            for (Map.Entry<DisplayElement, Set<MetaField<?>>> entry : changed.entrySet()) {
                if (!entry.getKey().entity().hasViewer(viewer)) {
                    continue;
                }
                PacketWrapper<?> packet = entry.getKey().entity().createMetadataPacket(viewer, entry.getValue());
                if (packet != null) {
                    packets.add(packet);
                }
            }
            PacketBundles.send(viewer, packets);
        }
    }

    private Location anchor() {
        return new Location(location.getX(), location.getY(), location.getZ(), 0, 0);
    }

    private void apply(DisplayElement element) {
        Quat groupRotation = worldRotation();
        Quat leftRotation = groupRotation.mul(element.rotation());
        Vec3 size = element.visible() ? element.scale().scale(scale) : Vec3.ZERO;
        Vec3 translation = groupRotation.rotate(element.position().scale(scale))
            .sub(leftRotation.rotate(element.pivot().mul(size)));
        Metadata metadata = element.entity().getMetadata();
        metadata.set(MetaFields.Display.TRANSLATION,
            new Vector3f((float) translation.x(), (float) translation.y(), (float) translation.z()));
        metadata.set(MetaFields.Display.SCALE, new Vector3f((float) size.x(), (float) size.y(), (float) size.z()));
        metadata.set(MetaFields.Display.LEFT_ROTATION, new Quaternion4f((float) leftRotation.x(), (float) leftRotation.y(),
            (float) leftRotation.z(), (float) leftRotation.w()));
        metadata.set(MetaFields.Display.TRANSFORMATION_INTERPOLATION_DURATION, interpolationTicks);
        if (metadata.hasDirty()) {
            metadata.set(MetaFields.Display.TRANSFORMATION_INTERPOLATION_START_DELTA_TICKS, 0);
            metadata.markDirty(MetaFields.Display.TRANSFORMATION_INTERPOLATION_START_DELTA_TICKS);
        }
    }

}
