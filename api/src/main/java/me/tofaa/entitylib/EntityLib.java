package me.tofaa.entitylib;

import com.github.retrooper.packetevents.util.PEVersion;
import me.tofaa.entitylib.utils.ELVersions;
import me.tofaa.entitylib.utils.GithubUpdater;

import java.util.Optional;
import java.util.logging.Level;

public final class EntityLib {

    private EntityLib() {}

    private static Platform platform;
    private static EntityLibAPI api;

    public static void init(Platform<?> platform, APIConfig settings) {
        EntityLib.platform = platform;
        platform.setupApi(settings);
        api = platform.getAPI();

        if (api.getSettings().shouldCheckForUpdate()) {
            if (api.getSettings().isDebugMode()) {
                platform.getLogger().log(Level.INFO, "Checking for updates...");
            }

            new GithubUpdater("Tofaa2", "EntityLib").checkForUpdates();
        }
    }

    public static Optional<EntityLibAPI<?>> getOptionalApi() {
        return Optional.ofNullable(api);
    }

    public static <T> EntityLibAPI<T> getApi() {
        return api;
    }

    public static Platform<?> getPlatform() {
        return platform;
    }

    public static PEVersion getVersion() {
        return ELVersions.CURRENT;
    }
}
