package me.tofaa.entitylib.display;

import me.tofaa.entitylib.display.math.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public final class Timeline {

    public interface Interpolator<T> {
        T interpolate(T from, T to, double progress);
    }

    public static final class Track<T> {

        private record Key<T>(double time, T value) {
        }

        private final Consumer<T> target;
        private final Interpolator<T> interpolator;
        private final List<Key<T>> keys = new ArrayList<>();

        private Track(Consumer<T> target, Interpolator<T> interpolator) {
            this.target = target;
            this.interpolator = interpolator;
        }

        public @NotNull Track<T> key(double seconds, @NotNull T value) {
            keys.add(new Key<>(seconds, value));
            keys.sort(Comparator.comparingDouble(Key::time));
            return this;
        }

        private double end() {
            return keys.isEmpty() ? 0 : keys.get(keys.size() - 1).time();
        }

        private void apply(double time) {
            if (keys.isEmpty()) {
                return;
            }
            Key<T> previous = keys.get(0);
            if (time <= previous.time()) {
                target.accept(previous.value());
                return;
            }
            for (int i = 1; i < keys.size(); i++) {
                Key<T> next = keys.get(i);
                if (time < next.time()) {
                    double span = next.time() - previous.time();
                    double progress = span <= 0 ? 1 : (time - previous.time()) / span;
                    target.accept(interpolator.interpolate(previous.value(), next.value(), progress));
                    return;
                }
                previous = next;
            }
            target.accept(previous.value());
        }

    }

    private final List<Track<?>> tracks = new ArrayList<>();
    private boolean loop;

    public <T> @NotNull Track<T> track(@NotNull Consumer<T> target, @NotNull Interpolator<T> interpolator) {
        Track<T> track = new Track<>(target, interpolator);
        tracks.add(track);
        return track;
    }

    public @NotNull Track<Vec3> vector(@NotNull Consumer<Vec3> target) {
        return track(target, Vec3::lerp);
    }

    public @NotNull Track<Double> number(@NotNull Consumer<Double> target) {
        return track(target, (from, to, progress) -> from + (to - from) * progress);
    }

    public @NotNull Timeline loop(boolean loop) {
        this.loop = loop;
        return this;
    }

    public double length() {
        double length = 0;
        for (Track<?> track : tracks) {
            length = Math.max(length, track.end());
        }
        return length;
    }

    public boolean isFinished(double seconds) {
        return !loop && seconds >= length();
    }

    public void apply(double seconds) {
        double length = length();
        double time = seconds;
        if (length > 0 && loop) {
            time = seconds % length;
            if (time < 0) {
                time += length;
            }
        }
        for (Track<?> track : tracks) {
            track.apply(time);
        }
    }

}
