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
    private final String currentVersion;

    public GithubUpdater(String org, String repo, String currentVersion) {
        this.org = org;
        this.repo = repo;
        this.currentVersion = currentVersion;
    }

    @Blocking
    public boolean isLatestVersion() {
        String latest = getLatestVersion();
        return latest != null && latest.equals(currentVersion);
    }


    @Blocking
    public String getLatestVersion() {
        try {
            URL url = new URL("https://api.github.com/repos/" + org + "/" + repo + "/releases/latest");
            URLConnection connection = url.openConnection();
            connection.addRequestProperty("User-Agent", "Mozilla/5.0");
            InputStreamReader isr = new InputStreamReader(connection.getInputStream());
            BufferedReader reader = new BufferedReader(isr);
            String response = reader.readLine();
            JsonObject json = AdventureSerializer.getGsonSerializer().serializer().fromJson(response, JsonObject.class);
            reader.close();
            isr.close();
            if (json.has("name")) {
                return json.get("name").getAsString();
            }
            throw new IOException("Could not find name attribute in github api fetch");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getCurrentVersion() {
        return currentVersion;
    }

    public String getOrg() {
        return org;
    }

    public String getRepo() {
        return repo;
    }
}
