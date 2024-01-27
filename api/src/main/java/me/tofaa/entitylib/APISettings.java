package me.tofaa.entitylib;

import com.github.retrooper.packetevents.PacketEventsAPI;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public final class APISettings {

    private final PacketEventsAPI<?> packetEvents;
    private boolean debugMode = false;
    private boolean checkForUpdates = false;
    private boolean tickTickables = false;
    private boolean platformLogger = false;
    private boolean useAsyncEvents = false;
    private boolean defaultCommands = false;

    public APISettings(PacketEventsAPI<?> packetEvents) {
        this.packetEvents = packetEvents;
    }

    public boolean requiresUpdate() throws IOException {
        if (!checkForUpdates) return false;
        String urlString = "https://api.github.com/repos/Tofaa2/EntityLib/releases/latest";
        String version = EntityLib.getVersion();

        URL url = new URL(urlString);
        JsonParser json = new JsonParser();
        InputStream stream = url.openStream();
        JsonArray array = json.parse(new InputStreamReader(stream)).getAsJsonArray();
        String latest = array.get(0).getAsJsonObject().get("tag_name").getAsString();

        stream.close();
        return !version.equalsIgnoreCase(latest);
    }

    public @NotNull APISettings usePlatformLogger() {
        this.platformLogger = true;
        return this;
    }

    public @NotNull APISettings checkForUpdates() {
        this.checkForUpdates = true;
        return this;
    }

    public @NotNull APISettings tickTickables() {
        this.tickTickables = true;
        return this;
    }

    public @NotNull APISettings debugMode() {
        this.debugMode = true;
        return this;
    }

    public @NotNull APISettings registerDefaultCommands() {
        this.defaultCommands = true;
        return this;
    }

    public @NotNull APISettings useAsyncEvents() {
        this.useAsyncEvents = true;
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

    public boolean shouldUseAsyncEvents() {
        return useAsyncEvents;
    }

}
