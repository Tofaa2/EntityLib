package me.tofaa.entitylib;

import com.github.retrooper.packetevents.PacketEventsAPI;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import me.tofaa.entitylib.utils.GithubUpdater;
import org.jetbrains.annotations.Blocking;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public final class APIConfig {

    private final PacketEventsAPI<?> packetEvents;
    private boolean debugMode = false;
    private boolean checkForUpdates = false;
    private boolean tickTickables = false;
    private boolean platformLogger = false;
    private boolean defaultCommands = false;
    private boolean platformTracking = false;
    private boolean bstats = false;

    public APIConfig(PacketEventsAPI<?> packetEvents) {
        this.packetEvents = packetEvents;
    }

    @Blocking
    public boolean requiresUpdate() throws IOException {
        if (!checkForUpdates) return false;
        GithubUpdater updater = new GithubUpdater("Tofaa2", "EntityLib", EntityLib.getVersion());
        return !updater.isLatestVersion();
    }

    public @NotNull APIConfig useBstats() {
        this.bstats = true;
        return this;
    }

    public @NotNull APIConfig usePlatformLogger() {
        this.platformLogger = true;
        return this;
    }

    public @NotNull APIConfig trackPlatformEntities() {
        this.platformTracking = true;
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

    public @NotNull APIConfig registerDefaultCommands() {
        this.defaultCommands = true;
        return this;
    }

    public boolean shouldRegisterDefaultCommands() {
        return defaultCommands;
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

    public boolean shouldTrackPlatformEntities() {
        return platformTracking;
    }

    public boolean shouldUseBstats() {
        return bstats;
    }

}
