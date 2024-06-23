package me.tofaa.entitylib.standalone.task;

import java.util.function.Supplier;

public interface Scheduler {

    static Scheduler newScheduler() {
        return new SchedulerImpl();
    }

    void process();

    void shutdown();

    Task submitTask(Supplier<TaskSchedule> supplier, ExecutionType type);

    default Task scheduleTask(Runnable task, TaskSchedule delay, TaskSchedule repeat, ExecutionType type) {
        return buildTask(task)
                .delay(delay)
                .repeat(repeat)
                .executionType(type)
                .schedule();
    }

    default Task.Builder buildTask(Runnable task) {
        return new Task.Builder(task, this);
    }

}
