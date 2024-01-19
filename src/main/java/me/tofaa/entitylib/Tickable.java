package me.tofaa.entitylib;

public interface Tickable {

    /** Internal method for actual logic ticking, if you want to add custom logic to your entity, override {@link #tick(long)} instead. */
    default void update(long time) {

    }

    void tick(long time);

}
