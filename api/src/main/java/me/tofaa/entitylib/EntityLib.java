package me.tofaa.entitylib;

import org.jetbrains.annotations.NotNull;

public final class EntityLib {

    private static EntityLib instance;
    private final APIConfig config;

    private EntityLib(@NotNull APIConfig config) {
        this.config = config;
    }

    public static void init(@NotNull APIConfig config) {
        instance = new EntityLib(config);
    }

    public static @NotNull EntityLib get() {
        if (instance == null) {
            throw new IllegalStateException("EntityLib not initialized");
        }
        return instance;
    }

    public @NotNull APIConfig getConfig() {
        return config;
    }

}
