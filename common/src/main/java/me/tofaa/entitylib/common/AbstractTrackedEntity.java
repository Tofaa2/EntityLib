package me.tofaa.entitylib.common;

import me.tofaa.entitylib.TrackedEntity;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractTrackedEntity<E> implements TrackedEntity {

    private final E platformEntity;

    protected AbstractTrackedEntity(@NotNull E platformEntity) {
        this.platformEntity = platformEntity;
    }

    @NotNull
    public E getPlatformEntity() {
        return platformEntity;
    }

}
