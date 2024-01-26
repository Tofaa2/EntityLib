package me.tofaa.entitylib;

public final class EntityLib {

    private EntityLib() {}

    private static String version = "1.2.0-SNAPSHOT";
    private static Platform platform;
    private static EntityLibAPI api;

    public static void init(Platform<?> platform, APISettings settings) {
        EntityLib.platform = platform;
        platform.setupApi(settings);
        api = platform.getAPI();
    }

    public static EntityLibAPI<?, ?> getApi() {
        return api;
    }

    public static Platform<?> getPlatform() {
        return platform;
    }

    public static String getVersion() {
        return version;
    }
}
