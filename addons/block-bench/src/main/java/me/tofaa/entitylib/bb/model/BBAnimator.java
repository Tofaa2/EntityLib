package me.tofaa.entitylib.bb.model;

import me.tofaa.entitylib.display.math.Vec3;

import java.util.List;

public record BBAnimator(String name, List<BBKeyframe> rotation, List<BBKeyframe> position, List<BBKeyframe> scale) {

    public Vec3 rotationAt(double time) {
        return sample(rotation, time, Vec3.ZERO);
    }

    public Vec3 positionAt(double time) {
        return sample(position, time, Vec3.ZERO);
    }

    public Vec3 scaleAt(double time) {
        return sample(scale, time, Vec3.ONE);
    }

    private static Vec3 sample(List<BBKeyframe> keyframes, double time, Vec3 fallback) {
        if (keyframes.isEmpty()) {
            return fallback;
        }
        BBKeyframe previous = keyframes.get(0);
        if (time <= previous.time()) {
            return previous.value();
        }
        for (int i = 1; i < keyframes.size(); i++) {
            BBKeyframe next = keyframes.get(i);
            if (time < next.time()) {
                if (previous.interpolation() == BBKeyframe.Interpolation.STEP) {
                    return previous.value();
                }
                double span = next.time() - previous.time();
                return span <= 0 ? next.value() : previous.value().lerp(next.value(), (time - previous.time()) / span);
            }
            previous = next;
        }
        return previous.value();
    }

}
