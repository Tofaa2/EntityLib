package me.tofaa.entitylib.meta;

import com.github.retrooper.packetevents.manager.server.ServerVersion;
import com.github.retrooper.packetevents.manager.server.VersionComparison;
import me.tofaa.entitylib.EntityLib;

public final class VersionCompatCheck  {

    private VersionCompatCheck() {}

    static boolean isVersion(ServerVersion version) {
        return version.is(VersionComparison.EQUALS, EntityLib.getApi().getPacketEvents().getServerManager().getVersion());
    }

}
