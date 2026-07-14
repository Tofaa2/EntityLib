package me.tofaa.entitylib;

import com.github.retrooper.packetevents.PacketEventsAPI;
import org.jetbrains.annotations.NotNull;

public final class APIConfig {

    private final PacketEventsAPI<?> packetEvents;
    private final EntityLibPlatform platform;
    private boolean debugMode;

    public APIConfig(@NotNull PacketEventsAPI<?> packetEvents, @NotNull EntityLibPlatform platform) {
        this.packetEvents = packetEvents;
        this.platform = platform;
    }

    public @NotNull APIConfig debugMode() {
        this.debugMode = true;
        return this;
    }

    public @NotNull PacketEventsAPI<?> getPacketEvents() {
        return packetEvents;
    }

    public @NotNull EntityLibPlatform getPlatform() {
        return platform;
    }

    public boolean isDebugMode() {
        return debugMode;
    }

}
