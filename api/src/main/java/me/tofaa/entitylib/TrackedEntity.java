package me.tofaa.entitylib;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public interface TrackedEntity {

    int getEntityId();

    @NotNull UUID getUuid();

}
