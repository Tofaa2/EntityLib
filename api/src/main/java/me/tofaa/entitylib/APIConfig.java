package me.tofaa.entitylib;

import com.github.retrooper.packetevents.PacketEventsAPI;
import com.github.retrooper.packetevents.manager.server.ServerVersion;
import org.jetbrains.annotations.NotNull;

public final class APIConfig {

    private final PacketEventsAPI<?> packetEvents;
    private boolean debugMode = false;
    private boolean checkForUpdates = false;
    private boolean tickTickables = false;
    private boolean platformLogger = false;
    private boolean bstats = true;
    private boolean forceBundle = false;

    public APIConfig(PacketEventsAPI<?> packetEvents) {
        this.packetEvents = packetEvents;
    }

    public @NotNull APIConfig useBstats() {
        this.bstats = true;
        return this;
    }

    public @NotNull APIConfig disableBStats() {
        this.bstats = false;
        return this;
    }

    public @NotNull APIConfig forceBundles() {
        this.forceBundle = true;
        return this;
    }

    public @NotNull APIConfig usePlatformLogger() {
        this.platformLogger = true;
        return this;
    }

    public @NotNull APIConfig checkForUpdates() {
        this.checkForUpdates = true;
        return this;
    }

    public @NotNull APIConfig tickTickables() {
        this.tickTickables = true;
        return this;
    }

    public @NotNull APIConfig debugMode() {
        this.debugMode = true;
        return this;
    }

    public boolean isDebugMode() {
        return debugMode;
    }

    public boolean shouldCheckForUpdate() {
        return checkForUpdates;
    }

    public boolean shouldTickTickables() {
        return tickTickables;
    }

    public PacketEventsAPI<?> getPacketEvents() {
        return packetEvents;
    }

    public boolean shouldUsePlatformLogger() {
        return platformLogger;
    }

    public boolean shouldUseBstats() {
        return bstats;
    }

    public boolean shouldForceBundles() {
        return this.forceBundle
                && EntityLib.getOptionalApi().isPresent()
                && EntityLib.getOptionalApi().get().getPacketEvents().getServerManager().getVersion().isNewerThanOrEquals(ServerVersion.V_1_19_4);
    }

}
