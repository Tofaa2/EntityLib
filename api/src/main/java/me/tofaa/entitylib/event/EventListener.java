package me.tofaa.entitylib.event;

import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public interface EventListener<E extends EntityLibEvent> {

    @NotNull Class<E> getEventClass();

    void handle(@NotNull E event);

    static <T extends EntityLibEvent> EventListener<T> generateListener(Class<T> eventClass, Consumer<T> consumer) {
        return new EventListener<T>() {
            @Override
            public @NotNull Class<T> getEventClass() {
                return eventClass;
            }

            @Override
            public void handle(@NotNull T event) {
                consumer.accept(event);
            }
        };
    }

}
