package me.tofaa.entitylib.bb.model;

import java.util.Map;
import java.util.UUID;

public record BBAnimation(UUID uuid, String name, Loop loop, double length, Map<UUID, BBAnimator> animators) {

    public enum Loop {
        ONCE, HOLD, LOOP
    }

    public double resolveTime(double seconds) {
        if (length <= 0) {
            return 0;
        }
        if (loop == Loop.LOOP) {
            double time = seconds % length;
            return time < 0 ? time + length : time;
        }
        return Math.max(0, Math.min(length, seconds));
    }

    public boolean isFinished(double seconds) {
        return loop != Loop.LOOP && seconds >= length;
    }

}
