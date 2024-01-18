package me.tofaa.entitylib;

/**
 * A container that can hold and tick {@link Tickable}s.
 * This is for specific users to extend if they want ticking functionality.
 *
 */
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
