package me.tofaa.entitylib.bb.model;

import me.tofaa.entitylib.display.math.Vec3;

public record BBKeyframe(double time, Vec3 value, Interpolation interpolation) {

    public enum Interpolation {
        LINEAR, STEP
    }

}
