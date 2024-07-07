package me.tofaa.entitylib.utils;

import com.github.retrooper.packetevents.util.adventure.AdventureSerializer;
import com.google.gson.JsonObject;
import org.jetbrains.annotations.Blocking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public final class GithubUpdater {

    private final String org;
    private final String repo;
    private final ELVersion currentVersion;

    public GithubUpdater(String org, String repo) {
        this.org = org;
        this.repo = repo;
        this.currentVersion = ELVersions.CURRENT;
    }

    @Blocking
    public boolean isLatestVersion() throws IOException {
        ELVersion latest = getLatestVersion();
        return currentVersion.isNewerThan(latest);
    }

    @Blocking
    public ELVersion getLatestVersion() throws IOException {
        URL url = new URL("https://api.github.com/repos/" + org + "/" + repo + "/releases/latest");
        URLConnection connection = url.openConnection();
        connection.addRequestProperty("User-Agent", "Mozilla/5.0");
        InputStreamReader isr = new InputStreamReader(connection.getInputStream());
        BufferedReader reader = new BufferedReader(isr);
        String response = reader.readLine();
        JsonObject json = AdventureSerializer.getGsonSerializer().serializer().fromJson(response, JsonObject.class);

        if (json.has("tag_name")) {
            return ELVersion.fromString(json.get("tag_name").getAsString().replaceFirst("^[vV]", ""));
        }
        throw new IOException("Could not find name attribute in github api fetch");
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
