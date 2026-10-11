package me.tofaa.entitylib.bb.math;

public record Vec3(double x, double y, double z) {

    public static final Vec3 ZERO = new Vec3(0, 0, 0);
    public static final Vec3 ONE = new Vec3(1, 1, 1);

    public Vec3 add(Vec3 other) {
        return new Vec3(x + other.x, y + other.y, z + other.z);
    }

    public Vec3 sub(Vec3 other) {
        return new Vec3(x - other.x, y - other.y, z - other.z);
    }

    public Vec3 mul(Vec3 other) {
        return new Vec3(x * other.x, y * other.y, z * other.z);
    }

    public Vec3 scale(double factor) {
        return new Vec3(x * factor, y * factor, z * factor);
    }

    public Vec3 lerp(Vec3 other, double t) {
        return new Vec3(x + (other.x - x) * t, y + (other.y - y) * t, z + (other.z - z) * t);
    }

}
