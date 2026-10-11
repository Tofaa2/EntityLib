package me.tofaa.entitylib;

import com.github.retrooper.packetevents.util.PEVersion;
import me.tofaa.entitylib.utils.ELVersions;
import org.jetbrains.annotations.NotNull;

public final class EntityLib {

    private static EntityLib instance;
    private final APIConfig config;

    private EntityLib(@NotNull APIConfig config) {
        this.config = config;
    }

    public static void init(@NotNull APIConfig config) {
        instance = new EntityLib(config);
        config.getPlatform().setup(config);
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

    public @NotNull EntityLibPlatform getPlatform() {
        return config.getPlatform();
    }

    public static @NotNull PEVersion getVersion() {
        return ELVersions.CURRENT;
    }

}
