package me.tofaa.entitylib;

import com.github.retrooper.packetevents.PacketEventsAPI;
import me.tofaa.entitylib.meta.OwnershipCheck;
import org.jetbrains.annotations.NotNull;

public final class APIConfig {

    private final PacketEventsAPI<?> packetEvents;
    private final EntityLibPlatform platform;
    private boolean debugMode;
    private boolean strictVersionCheck;
    private boolean useBstats = true;
    private OwnershipCheck ownershipCheck = OwnershipCheck.WARN;

    public APIConfig(@NotNull PacketEventsAPI<?> packetEvents, @NotNull EntityLibPlatform platform) {
        this.packetEvents = packetEvents;
        this.platform = platform;
    }

    public @NotNull APIConfig debugMode() {
        this.debugMode = true;
        return this;
    }

    public @NotNull APIConfig strictVersionCheck() {
        this.strictVersionCheck = true;
        return this;
    }

    public @NotNull APIConfig ownershipCheck(@NotNull OwnershipCheck ownershipCheck) {
        this.ownershipCheck = ownershipCheck;
        return this;
    }

    public @NotNull OwnershipCheck getOwnershipCheck() {
        return ownershipCheck;
    }

    public @NotNull APIConfig useBstats() {
        this.useBstats = true;
        return this;
    }

    public @NotNull APIConfig disableBStats() {
        this.useBstats = false;
        return this;
    }

    public boolean shouldUseBstats() {
        return useBstats;
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

    public boolean isStrictVersionCheck() {
        return strictVersionCheck;
    }

}
