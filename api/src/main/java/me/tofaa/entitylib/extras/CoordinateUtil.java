package me.tofaa.entitylib.extras;

import com.github.retrooper.packetevents.protocol.world.Location;
import com.github.retrooper.packetevents.util.Vector3d;

public final class CoordinateUtil {

    private CoordinateUtil() {}

    public static Location withDirection(Location location, Vector3d direction) {
        /*
         * Sin = Opp / Hyp
         * Cos = Adj / Hyp
         * Tan = Opp / Adj
         *
         * x = -Opp
         * z = Adj
         */
        final double x = direction.getX();
        final double z = direction.getZ();
        if (x == 0 && z == 0) {
            float pitch = direction.getY() > 0 ? -90f : 90f;
            return new Location(location.getX(), location.getY(), location.getZ(), location.getYaw(), pitch);
        }
        final double theta = Math.atan2(-x, z);
        final double xz = Math.sqrt(square(x) + square(z));
        final double _2PI = 2 * Math.PI;

        return new Location(location.getX(), location.getY(), location.getZ(),
                (float) Math.toDegrees((theta + _2PI) % _2PI),
                (float) Math.toDegrees(Math.atan(-direction.getY() / xz)));
    }

    public static double square(double in) {
        return in * in;
    }

}
