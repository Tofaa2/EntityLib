package me.tofaa.entitylib;

import java.io.IOException;
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
            try {
                if (api.getSettings().isDebugMode()) {
                    platform.getLogger().log(Level.CONFIG, "Checking for updates...");
                }
                if (api.getSettings().requiresUpdate()) {
                    platform.getLogger().log(Level.WARNING, "You are using an outdated version of EntityLib. Please take a look at the Github releases page.");
                }

            }
            catch (IOException e) {
                platform.getLogger().log(Level.WARNING, e, () -> "EntityLib failed to check for updates.");
            }
        }
    }

    public static <W, T> EntityLibAPI<W, T> getApi() {
        return api;
    }

    public static Platform<?> getPlatform() {
        return platform;
    }

    public static String getVersion() {
        return "1.2.0-SNAPSHOT";
    }
}
