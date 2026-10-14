package me.tofaa.entitylib.display.math;

public record Quat(double x, double y, double z, double w) {

    public static final Quat IDENTITY = new Quat(0, 0, 0, 1);

    public static Quat axisAngle(double ax, double ay, double az, double radians) {
        double half = radians / 2;
        double sin = Math.sin(half);
        return new Quat(ax * sin, ay * sin, az * sin, Math.cos(half));
    }

    public static Quat eulerZYX(Vec3 degrees) {
        Quat qx = axisAngle(1, 0, 0, Math.toRadians(degrees.x()));
        Quat qy = axisAngle(0, 1, 0, Math.toRadians(degrees.y()));
        Quat qz = axisAngle(0, 0, 1, Math.toRadians(degrees.z()));
        return qz.mul(qy).mul(qx);
    }

    public Quat mul(Quat o) {
        return new Quat(
            w * o.x + x * o.w + y * o.z - z * o.y,
            w * o.y - x * o.z + y * o.w + z * o.x,
            w * o.z + x * o.y - y * o.x + z * o.w,
            w * o.w - x * o.x - y * o.y - z * o.z
        );
    }

    public Vec3 rotate(Vec3 v) {
        double tx = 2 * (y * v.z() - z * v.y());
        double ty = 2 * (z * v.x() - x * v.z());
        double tz = 2 * (x * v.y() - y * v.x());
        return new Vec3(
            v.x() + w * tx + (y * tz - z * ty),
            v.y() + w * ty + (z * tx - x * tz),
            v.z() + w * tz + (x * ty - y * tx)
        );
    }

}
