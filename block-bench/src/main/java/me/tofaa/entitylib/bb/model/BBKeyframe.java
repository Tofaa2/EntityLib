package me.tofaa.entitylib.bb.model;

import me.tofaa.entitylib.bb.math.Vec3;

public record BBKeyframe(double time, Vec3 value, Interpolation interpolation) {

    public enum Interpolation {
        LINEAR, STEP
    }

}
