package me.tofaa.entitylib.extras;

import com.github.retrooper.packetevents.manager.server.ServerVersion;
import me.tofaa.entitylib.EntityLib;

public final class VersionChecker {

    private VersionChecker() {}


    public static void verifyVersion(ServerVersion version, String message) {
        if (!version.isNewerThanOrEquals(EntityLib.getApi().getPacketEvents().getServerManager().getVersion())) {
            throw new InvalidVersionException(message);
        }
    }

}
