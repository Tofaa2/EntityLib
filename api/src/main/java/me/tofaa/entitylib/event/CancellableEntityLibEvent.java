package me.tofaa.entitylib.event;

public interface CancellableEntityLibEvent extends EntityLibEvent {

    void setCancelled(boolean cancelled);

    boolean isCancelled();

}
