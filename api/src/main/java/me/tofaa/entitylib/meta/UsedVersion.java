package me.tofaa.entitylib.meta;

import com.github.retrooper.packetevents.manager.server.ServerVersion;

public @interface UsedVersion {

    ServerVersion[] value();

}
