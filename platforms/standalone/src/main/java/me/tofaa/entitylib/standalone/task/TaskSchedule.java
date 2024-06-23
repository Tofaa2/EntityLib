package me.tofaa.entitylib.standalone.task;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public interface TaskSchedule {

    static TaskSchedule duration(Duration duration) {
        return new DurationSchedule(duration);
    }

    static TaskSchedule duration(long duration) {
        return new DurationSchedule(Duration.ofMillis(duration));
    }

    static TaskSchedule duration(long duration, TimeUnit unit) {
        return new DurationSchedule(Duration.ofMillis(unit.toMillis(duration)));
    }

    static TaskSchedule seconds(long seconds) {
        return new DurationSchedule(Duration.ofSeconds(seconds));
    }

    static TaskSchedule minutes(long minutes) {
        return new DurationSchedule(Duration.ofMinutes(minutes));
    }

    static TaskSchedule hours(long hours) {
        return new DurationSchedule(Duration.ofHours(hours));
    }

    static TaskSchedule milliseconds(long milliseconds) {
        return new DurationSchedule(Duration.ofMillis(milliseconds));
    }

    static TaskSchedule future(CompletableFuture<?> future) {
        return new FutureSchedule(future);
    }

    static TaskSchedule park() {
        return ParkSchedule.INSTANCE;
    }

    static TaskSchedule stop() {
        return StopSchedule.INSTANCE;
    }

    static TaskSchedule immediate() {
        return ImmediateSchedule.INSTANCE;
    }

    class DurationSchedule implements TaskSchedule {
        Duration duration;
        DurationSchedule(Duration duration) {
            this.duration = duration;
        }
    }

    class FutureSchedule implements TaskSchedule {
        CompletableFuture<?> future;
        FutureSchedule(CompletableFuture<?> future) {
            this.future = future;
        }
    }
    class ParkSchedule implements TaskSchedule {
        private static final ParkSchedule INSTANCE = new ParkSchedule();
        ParkSchedule() {}
    }
    class StopSchedule implements TaskSchedule {
        private static final StopSchedule INSTANCE = new StopSchedule();
        StopSchedule() {}
    }
    class ImmediateSchedule implements TaskSchedule {
        private static final ImmediateSchedule INSTANCE = new ImmediateSchedule();
        ImmediateSchedule() {}
    }

}
