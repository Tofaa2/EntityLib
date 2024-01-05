package me.tofaa.entitylib.entity;

import java.util.concurrent.atomic.AtomicInteger;

@FunctionalInterface
public interface EntityIdProvider {

    static EntityIdProvider simple() {
        return new EntityIdProvider() {
            private final AtomicInteger atomicInteger = new AtomicInteger(0);
            @Override
            public int provide() {
                return atomicInteger.incrementAndGet();
            }
        };
    }


    int provide();
}
