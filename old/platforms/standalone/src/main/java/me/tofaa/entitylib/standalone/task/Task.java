package me.tofaa.entitylib.standalone.task;

import java.util.concurrent.atomic.AtomicBoolean;

public interface Task {


    int id();

    ExecutionType executionType();

    void unpark();
    boolean isParked();

    void cancel();


    class Builder {

        private final Runnable runnable;
        private final Scheduler scheduler;

        private ExecutionType executionType = ExecutionType.BLOCKING;//default
        private TaskSchedule delay = TaskSchedule.immediate();
        private TaskSchedule repeat = TaskSchedule.stop();

        Builder(Runnable runnable, Scheduler scheduler) {
            this.runnable = runnable;
            this.scheduler = scheduler;
        }

        public Builder executionType(ExecutionType executionType) {
            this.executionType = executionType;
            return this;
        }

        public Builder delay(TaskSchedule delay) {
            this.delay = delay;
            return this;
        }

        public Builder repeat(TaskSchedule repeat) {
            this.repeat = repeat;
            return this;
        }

        public Task schedule() {
            AtomicBoolean first = new AtomicBoolean();
            return scheduler.submitTask(() -> {
                if (first.get()) {
                    first.set(false);
                    return delay;
                }
                runnable.run();
                return repeat;
            }, executionType);
        }


    }

}
