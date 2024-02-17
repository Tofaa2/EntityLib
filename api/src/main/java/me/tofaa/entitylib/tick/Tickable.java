package me.tofaa.entitylib.tick;

public interface Tickable {

    /**
     * @return if the entity is ticking.
     */
    boolean isTicking();

    /**
     * Sets the entities ticking status, incase you want to stop ticking for a moment then continue
     * @param ticking if the entity should tick.
     */
    void setTicking(boolean ticking);

    /**
     * Ticks this entity. This method will not be called if {@link #isTicking()} returns false.
     * @param time the current time in milliseconds.
     */
    void tick(long time);

}
