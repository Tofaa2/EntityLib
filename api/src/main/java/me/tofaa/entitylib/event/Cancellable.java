package me.tofaa.entitylib.event;

public interface Cancellable {

    boolean isCancelled();

    void setCancelled(boolean cancelled);

}
