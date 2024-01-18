package me.tofaa.entitylib;

public interface TickingContainer {

    void addTickable(Tickable tickable);

    void removeTickable(Tickable tickable);

    default void update(long time) {
        for (Tickable tickable : getTickables()) {
            tickable.update(time);
        }
    }

    Iterable<Tickable> getTickables();

}
