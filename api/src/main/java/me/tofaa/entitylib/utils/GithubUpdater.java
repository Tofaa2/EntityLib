package me.tofaa.entitylib.utils;

import com.github.retrooper.packetevents.util.PEVersion;
import com.github.retrooper.packetevents.util.adventure.AdventureSerializer;
import com.google.gson.JsonObject;
import me.tofaa.entitylib.EntityLib;
import org.jetbrains.annotations.Blocking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class GithubUpdater {

    private final String org;
    private final String repo;
    private final PEVersion currentVersion;
    private final Logger logger;

    public GithubUpdater(String org, String repo) {
        this.org = org;
        this.repo = repo;
        this.currentVersion = ELVersions.CURRENT;
        this.logger = EntityLib.getPlatform().getLogger();

        if (EntityLib.getApi().getSettings().shouldCheckForUpdate()) {
            if (EntityLib.getApi().getSettings().isDebugMode()) {
                logger.log(Level.INFO, "Checking for updates...");
            }

            checkForUpdates();
        }
    }

    private void checkForUpdates() {
        CompletableFuture.runAsync(() -> {
            try {
                PEVersion latestVersion = getLatestVersion();
                if (currentVersion.isOlderThan(latestVersion)) {
                    logger.log(Level.WARNING, "You are using an outdated version of EntityLib. Version: " + latestVersion + " is now available.");
                } else if (currentVersion.equals(latestVersion)) {
                    logger.log(Level.INFO, "No EntityLib updates found.");
                }
            } catch (Exception ex) {
                logger.warning("Failed to check for updates: " + ex.getMessage());
            }
        });
    }

    @Blocking
    private PEVersion getLatestVersion() throws IOException {
        URL url = new URL("https://api.github.com/repos/" + org + "/" + repo + "/releases/latest");
        URLConnection connection = url.openConnection();
        connection.addRequestProperty("User-Agent", "Mozilla/5.0");

        try (
                InputStreamReader isr = new InputStreamReader(connection.getInputStream());
                BufferedReader reader = new BufferedReader(isr)
        ) {
            String response = reader.readLine();
            JsonObject json = AdventureSerializer.getGsonSerializer().serializer().fromJson(response, JsonObject.class);

            if (json.has("tag_name")) {
                return PEVersion.fromString(json.get("tag_name").getAsString().replaceFirst("^[vV]", ""));
            }
            throw new IOException("Could not find name attribute in github api fetch");
        }
    }

    @Deprecated
    public String getCurrentVersion() {
        return currentVersion.toString();
    }

    public String getOrg() {
        return org;
    }

    public String getRepo() {
        return repo;
    }
}
