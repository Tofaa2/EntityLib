package me.tofaa.entitylib.event;

import org.jetbrains.annotations.NotNull;

@FunctionalInterface
public interface EventCallback<E extends EntityLibEvent> {

    void run(@NotNull E event);

}