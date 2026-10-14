package me.tofaa.entitylib.bb;

import com.github.retrooper.packetevents.protocol.world.Location;
import com.github.retrooper.packetevents.util.Quaternion4f;
import com.github.retrooper.packetevents.util.Vector3f;
import me.tofaa.entitylib.display.math.Quat;
import me.tofaa.entitylib.display.math.Vec3;
import me.tofaa.entitylib.bb.model.BBAnimation;
import me.tofaa.entitylib.bb.model.BBAnimator;
import me.tofaa.entitylib.bb.model.BBCube;
import me.tofaa.entitylib.bb.model.BBGroup;
import me.tofaa.entitylib.bb.model.BBModel;
import me.tofaa.entitylib.bb.render.BBMaterial;
import me.tofaa.entitylib.bb.render.BBSkin;
import me.tofaa.entitylib.meta.MetaFields;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class BBModelEntity {

    private static final double UNITS_PER_BLOCK = 16.0;

    public record BonePose(Vec3 rotation, Vec3 position, Vec3 scale) {

        public static final BonePose IDENTITY = new BonePose(Vec3.ZERO, Vec3.ZERO, Vec3.ONE);

    }

    private record Part(@Nullable BBCube cube, @Nullable BBGroup bone, List<BBGroup> bones, BBMaterial material,
                        WrapperEntity entity) {

        UUID uuid() {
            return cube != null ? cube.uuid() : bone.uuid();
        }

        String name() {
            return cube != null ? cube.name() : bone.name();
        }

    }

    private final BBModel model;
    private final List<Part> parts = new ArrayList<>();
    private final List<WrapperEntity> entities = new ArrayList<>();
    private final Set<UUID> viewers = ConcurrentHashMap.newKeySet();
    private final Map<UUID, BonePose> poses = new ConcurrentHashMap<>();
    private Location location = new Location(0, 0, 0, 0, 0);
    private float scale = 1f;
    private int interpolationTicks;
    private boolean spawned;

    public BBModelEntity(@NotNull BBModel model, @NotNull BBSkin skin) {
        this.model = model;
        collect(model.root(), new ArrayList<>(), skin);
    }

    public static @NotNull BBModelEntity create(@NotNull BBModel model) {
        return new BBModelEntity(model, BBSkin.palette());
    }

    public static @NotNull BBModelEntity create(@NotNull BBModel model, @NotNull BBSkin skin) {
        return new BBModelEntity(model, skin);
    }

    private void collect(BBGroup group, List<BBGroup> chain, BBSkin skin) {
        if (!group.visible()) {
            return;
        }
        chain.add(group);
        BBMaterial boneMaterial = skin.bone(group);
        if (boneMaterial != null) {
            add(null, group, chain, boneMaterial);
        } else {
            for (BBCube cube : group.cubes()) {
                if (cube.visible()) {
                    add(cube, null, chain, skin.cube(model, cube));
                }
            }
        }
        for (BBGroup child : group.groups()) {
            collect(child, chain, skin);
        }
        chain.remove(chain.size() - 1);
    }

    private void add(BBCube cube, BBGroup bone, List<BBGroup> chain, BBMaterial material) {
        WrapperEntity entity = material.create(model, cube);
        if (entity == null) {
            return;
        }
        parts.add(new Part(cube, bone, List.copyOf(chain), material, entity));
        entities.add(entity);
    }

    public @NotNull BBModel getModel() {
        return model;
    }

    public @NotNull List<WrapperEntity> getParts() {
        return Collections.unmodifiableList(entities);
    }

    public @Nullable WrapperEntity getPart(@NotNull UUID uuid) {
        for (Part part : parts) {
            if (part.uuid().equals(uuid)) {
                return part.entity;
            }
        }
        return null;
    }

    public @Nullable WrapperEntity getPart(@NotNull String name) {
        for (Part part : parts) {
            if (part.name().equals(name)) {
                return part.entity;
            }
        }
        return null;
    }

    public @NotNull Location getLocation() {
        return location;
    }

    public boolean isSpawned() {
        return spawned;
    }

    public @NotNull Set<UUID> getViewers() {
        return Collections.unmodifiableSet(viewers);
    }

    public synchronized void addViewer(@NotNull UUID viewer) {
        viewers.add(viewer);
        for (WrapperEntity entity : entities) {
            entity.addViewer(viewer);
        }
    }

    public synchronized void removeViewer(@NotNull UUID viewer) {
        viewers.remove(viewer);
        for (WrapperEntity entity : entities) {
            entity.removeViewer(viewer);
        }
    }

    public synchronized void spawn(@NotNull Location location) {
        this.location = location;
        applyTransforms(false);
        Location anchor = anchor();
        for (WrapperEntity entity : entities) {
            entity.spawn(anchor);
        }
        spawned = true;
    }

    public synchronized void despawn() {
        for (WrapperEntity entity : entities) {
            entity.despawn();
        }
        spawned = false;
    }

    public synchronized void remove() {
        for (WrapperEntity entity : entities) {
            entity.remove();
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
        for (WrapperEntity entity : entities) {
            entity.teleport(anchor);
        }
        if (rotated) {
            update();
        }
    }

    public float getScale() {
        return scale;
    }

    public synchronized void setScale(float scale) {
        this.scale = scale;
        update();
    }

    public int getInterpolationTicks() {
        return interpolationTicks;
    }

    public synchronized void setInterpolationTicks(int interpolationTicks) {
        this.interpolationTicks = Math.max(0, interpolationTicks);
    }

    public synchronized void setBonePose(@NotNull UUID bone, @Nullable BonePose pose) {
        if (pose == null) {
            poses.remove(bone);
        } else {
            poses.put(bone, pose);
        }
    }

    public synchronized void resetPose() {
        poses.clear();
        update();
    }

    public synchronized void setPose(@NotNull BBAnimation animation, double seconds) {
        double time = animation.resolveTime(seconds);
        poses.clear();
        for (Map.Entry<UUID, BBAnimator> entry : animation.animators().entrySet()) {
            BBAnimator animator = entry.getValue();
            Vec3 rotation = animator.rotationAt(time);
            Vec3 position = animator.positionAt(time);
            poses.put(entry.getKey(), new BonePose(
                new Vec3(-rotation.x(), -rotation.y(), rotation.z()),
                new Vec3(-position.x(), position.y(), position.z()),
                animator.scaleAt(time)
            ));
        }
        update();
    }

    public synchronized void update() {
        applyTransforms(spawned);
    }

    private Location anchor() {
        return new Location(location.getX(), location.getY(), location.getZ(), 0, 0);
    }

    private void applyTransforms(boolean broadcast) {
        Quat rootRotation = Quat.axisAngle(0, 1, 0, Math.toRadians(180 - location.getYaw()));
        double unit = scale / UNITS_PER_BLOCK;
        for (Part part : parts) {
            BBMaterial material = part.material;
            Vec3 size;
            Vec3 point;
            Quat rotation;
            if (part.cube != null) {
                BBCube cube = part.cube;
                rotation = Quat.eulerZYX(cube.rotation());
                size = cube.size().scale(material.scale());
                point = material.centered() ? cube.min().add(cube.size().scale(0.5)) : cube.min();
                point = cube.origin().add(rotation.rotate(point.add(material.offset()).sub(cube.origin())));
            } else {
                double side = UNITS_PER_BLOCK * material.scale();
                size = new Vec3(side, side, side);
                point = part.bone.origin().add(material.offset());
                if (!material.centered()) {
                    point = point.sub(size.scale(0.5));
                }
                rotation = Quat.IDENTITY;
            }

            for (int i = part.bones.size() - 1; i >= 0; i--) {
                BBGroup bone = part.bones.get(i);
                BonePose pose = poses.getOrDefault(bone.uuid(), BonePose.IDENTITY);
                Quat boneRotation = Quat.eulerZYX(bone.rotation().add(pose.rotation()));
                point = bone.origin().add(pose.position()).add(boneRotation.rotate(point.sub(bone.origin()).mul(pose.scale())));
                rotation = boneRotation.mul(rotation);
                size = size.mul(pose.scale());
            }

            Vec3 translation = rootRotation.rotate(point.scale(unit));
            Quat leftRotation = rootRotation.mul(rotation);
            Metadata metadata = part.entity.getMetadata();
            metadata.set(MetaFields.Display.TRANSLATION,
                new Vector3f((float) translation.x(), (float) translation.y(), (float) translation.z()));
            metadata.set(MetaFields.Display.SCALE,
                new Vector3f((float) (size.x() * unit), (float) (size.y() * unit), (float) (size.z() * unit)));
            metadata.set(MetaFields.Display.LEFT_ROTATION,
                new Quaternion4f((float) leftRotation.x(), (float) leftRotation.y(), (float) leftRotation.z(), (float) leftRotation.w()));
            metadata.set(MetaFields.Display.TRANSFORMATION_INTERPOLATION_DURATION, interpolationTicks);
            if (metadata.hasDirty()) {
                metadata.set(MetaFields.Display.TRANSFORMATION_INTERPOLATION_START_DELTA_TICKS, 0);
                metadata.markDirty(MetaFields.Display.TRANSFORMATION_INTERPOLATION_START_DELTA_TICKS);
            }
            if (broadcast) {
                part.entity.flushMetadata();
            }
        }
    }

}
