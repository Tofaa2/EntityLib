package me.tofaa.entitylib.standalone.task;

import java.util.Queue;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

class SchedulerImpl implements Scheduler {

    private static final AtomicInteger TASK_COUNTER = new AtomicInteger(0);
    private static final ScheduledExecutorService SCHEDULED_EXECUTOR = Executors.newSingleThreadScheduledExecutor((e) -> {
        Thread thread = new Thread(e);
        thread.setDaemon(true);
        return thread;
    });
    private static final ForkJoinPool FORK_JOIN_POOL = new ForkJoinPool();
    private static final Queue<TaskImpl> TASKS = new ConcurrentLinkedDeque<>();

    private Thread thread;


    @Override
    public void process() {
        thread = new Thread(() -> {
            while (true) {
                process();
            }
        });
        thread.start();
    }

    @Override
    public void shutdown() {
        thread.interrupt();
        thread = null;
    }

    @Override
    public Task submitTask(Supplier<TaskSchedule> supplier, ExecutionType type) {
        TaskImpl task = new TaskImpl(TASK_COUNTER.getAndIncrement(), supplier, type, this);
        handleTask(task);
        return task;
    }

    private void handleTask(TaskImpl task) {
        TaskSchedule schedule = task.task.get();
        if (schedule instanceof TaskSchedule.DurationSchedule) {
            TaskSchedule.DurationSchedule d = (TaskSchedule.DurationSchedule) schedule;
            SCHEDULED_EXECUTOR.schedule(() -> {
                safeExecute(task);
            }, d.duration.toMillis(), TimeUnit.MILLISECONDS);
        }
        else if (schedule instanceof TaskSchedule.FutureSchedule) {
            TaskSchedule.FutureSchedule f = (TaskSchedule.FutureSchedule) schedule;
            f.future.thenRun(() -> {
                safeExecute(task);
            });
        }
        else if (schedule instanceof TaskSchedule.ParkSchedule) {
            task.parked = 1;
        }
        else if (schedule instanceof TaskSchedule.StopSchedule) {
            task.cancel();
        }
        else if (schedule instanceof TaskSchedule.ImmediateSchedule) {
            TASKS.offer(task);
        }
    }

    void unparkTask(TaskImpl task) {
        task.tryUnpark();
        TASKS.offer(task);
    }

    private void safeExecute(TaskImpl task) {
        if (task.executionType() == ExecutionType.BLOCKING) {
            TASKS.offer(task);
        }
        else {
            FORK_JOIN_POOL.submit(() -> {
                if (task.alive) {
                    handleTask(task);
                }
            });
        }
    }
}
