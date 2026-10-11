package me.tofaa.entitylib.bb.model;

import me.tofaa.entitylib.bb.math.Vec3;

import java.util.List;
import java.util.UUID;

public record BBCube(UUID uuid, String name, Vec3 from, Vec3 to, Vec3 origin, Vec3 rotation, double inflate,
                     boolean visible, List<BBFace> faces) {

    public Vec3 min() {
        return from.sub(new Vec3(inflate, inflate, inflate));
    }

    public Vec3 size() {
        return to.sub(from).add(new Vec3(inflate * 2, inflate * 2, inflate * 2));
    }

}
