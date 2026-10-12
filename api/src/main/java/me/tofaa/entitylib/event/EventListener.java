package me.tofaa.entitylib.event;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Predicate;

public interface EventListener<E extends EntityLibEvent> {

    enum Result {
        SUCCESS,
        SKIPPED,
        EXPIRED
    }

    @NotNull Class<E> eventType();

    @NotNull Result run(@NotNull E event);

    default int priority() {
        return 0;
    }

    static <E extends EntityLibEvent> @NotNull EventListener<E> of(@NotNull Class<E> eventType, @NotNull Consumer<E> handler) {
        return builder(eventType).handler(handler).build();
    }

    static <E extends EntityLibEvent> @NotNull Builder<E> builder(@NotNull Class<E> eventType) {
        return new Builder<>(eventType);
    }

    final class Builder<E extends EntityLibEvent> {

        private final Class<E> eventType;
        private final List<Predicate<E>> filters = new ArrayList<>();
        private boolean ignoreCancelled;
        private int expireCount;
        private Predicate<E> expireWhen;
        private int priority;
        private Consumer<E> handler = event -> {
        };

        private Builder(Class<E> eventType) {
            this.eventType = eventType;
        }

        public @NotNull Builder<E> filter(@NotNull Predicate<E> filter) {
            filters.add(filter);
            return this;
        }

        public @NotNull Builder<E> ignoreCancelled(boolean ignoreCancelled) {
            this.ignoreCancelled = ignoreCancelled;
            return this;
        }

        public @NotNull Builder<E> expireCount(int expireCount) {
            this.expireCount = expireCount;
            return this;
        }

        public @NotNull Builder<E> expireWhen(@NotNull Predicate<E> expireWhen) {
            this.expireWhen = expireWhen;
            return this;
        }

        public @NotNull Builder<E> priority(int priority) {
            this.priority = priority;
            return this;
        }

        public @NotNull Builder<E> handler(@NotNull Consumer<E> handler) {
            this.handler = handler;
            return this;
        }

        @SuppressWarnings("unchecked")
        public @NotNull EventListener<E> build() {
            Class<E> eventType = this.eventType;
            Predicate<E>[] filters = this.filters.toArray(new Predicate[0]);
            boolean ignoreCancelled = this.ignoreCancelled;
            AtomicInteger remaining = expireCount > 0 ? new AtomicInteger(expireCount) : null;
            Predicate<E> expireWhen = this.expireWhen;
            int priority = this.priority;
            Consumer<E> handler = this.handler;
            return new EventListener<E>() {
                @Override
                public @NotNull Class<E> eventType() {
                    return eventType;
                }

                @Override
                public int priority() {
                    return priority;
                }

                @Override
                public @NotNull Result run(@NotNull E event) {
                    if (ignoreCancelled && event instanceof Cancellable && ((Cancellable) event).isCancelled()) {
                        return Result.SKIPPED;
                    }
                    if (expireWhen != null && expireWhen.test(event)) {
                        return Result.EXPIRED;
                    }
                    for (Predicate<E> filter : filters) {
                        if (!filter.test(event)) {
                            return Result.SKIPPED;
                        }
                    }
                    handler.accept(event);
                    if (remaining != null && remaining.decrementAndGet() <= 0) {
                        return Result.EXPIRED;
                    }
                    return Result.SUCCESS;
                }
            };
        }

    }

}
