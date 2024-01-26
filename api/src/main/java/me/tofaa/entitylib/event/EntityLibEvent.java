package me.tofaa.entitylib.event;

public interface EntityLibEvent {

    boolean isCancelled();

    void setCancelled(boolean cancelled);

    default boolean isAsync() {
        return false;
    }

}
