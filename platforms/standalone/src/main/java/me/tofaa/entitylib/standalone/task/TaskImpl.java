package me.tofaa.entitylib.standalone.task;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.function.Supplier;

class TaskImpl implements Task {

    // thread safe way to set the parked value of any task, Like VarHandle but for older java versions
    private static final AtomicIntegerFieldUpdater<TaskImpl> PARKED_UPDATER = AtomicIntegerFieldUpdater.newUpdater(TaskImpl.class, "parked");

    volatile boolean alive = true;
    volatile int parked = 1; // 1 is true, 0 is false

    final int id;
    final Supplier<TaskSchedule> task;
    final ExecutionType type;
    final SchedulerImpl owner;

    TaskImpl(int id, Supplier<TaskSchedule> task, ExecutionType type, SchedulerImpl owner) {
        this.id = id;
        this.task = task;
        this.type = type;
        this.owner = owner;
    }


    @Override
    public int id() {
        return id;
    }

    @Override
    public ExecutionType executionType() {
        return type;
    }

    @Override
    public void unpark() {
        this.owner.unparkTask(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        return this.id == ((TaskImpl) obj).id;
    }

    @Override
    public int hashCode() {
        // murmur hash 3
        int h = id;
        h ^= h >>> 16;
        h *= 0x85ebca6b;
        h ^= h >>> 13;
        h *= 0xc2b2ae35;
        h ^= h >>> 16;
        return h;
    }

    @Override
    public String toString() {
        return "SimpleTask(id=" + id + ", task=" + task + ", executionType=" + type + ", owner=" + owner + ", alive=" + alive + ", parked=" + parked + ")";
    }

    void tryUnpark() {
        PARKED_UPDATER.compareAndSet(this, 1, 0);
    }

    @Override
    public boolean isParked() {
        return parked == 1;
    }

    @Override
    public void cancel() {
        alive = false;
    }
}
