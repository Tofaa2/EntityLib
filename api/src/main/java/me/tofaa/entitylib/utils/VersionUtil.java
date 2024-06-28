package me.tofaa.entitylib.utils;

import com.github.retrooper.packetevents.manager.server.ServerVersion;
import com.github.retrooper.packetevents.manager.server.VersionComparison;
import me.tofaa.entitylib.EntityLib;

public final class VersionUtil {

    private VersionUtil () {}


    public static boolean isNewerThanOrEqual(ServerVersion version) {
        return EntityLib.getApi().getPacketEvents().getServerManager().getVersion().isNewerThanOrEquals(version);
    }

    public static boolean isNewerThan(ServerVersion version) {
        return EntityLib.getApi().getPacketEvents().getServerManager().getVersion().isNewerThan(version);
    }

    public static boolean isOlderThanOrEqual(ServerVersion version) {
        return EntityLib.getApi().getPacketEvents().getServerManager().getVersion().isOlderThanOrEquals(version);
    }

    public static boolean isOlderThan(ServerVersion version) {
        return EntityLib.getApi().getPacketEvents().getServerManager().getVersion().isOlderThan(version);
    }

    public static boolean is(ServerVersion version) {
        return EntityLib.getApi().getPacketEvents().getServerManager().getVersion().is(VersionComparison.EQUALS, version);
    }

}
