package me.tofaa.entitylib.codegen;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import me.tofaa.entitylib.codegen.model.EntitySchema;
import me.tofaa.entitylib.codegen.model.VersionData;

import java.io.*;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.*;
import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

public final class SchemaLoader {

    private static final String VERSIONS_URL = "https://kennytv.eu/entity-data/versions.json";
    private static final String DATA_URL_FORMAT = "https://kennytv.eu/entity-data/%s.json";

    private static final Map<String, Integer> PROTOCOL_VERSIONS = new LinkedHashMap<>();
    static {
        PROTOCOL_VERSIONS.put("1.14.4", 498);
        PROTOCOL_VERSIONS.put("1.15", 573);
        PROTOCOL_VERSIONS.put("1.16", 735);
        PROTOCOL_VERSIONS.put("1.16.2", 751);
        PROTOCOL_VERSIONS.put("1.17", 755);
        PROTOCOL_VERSIONS.put("1.19", 759);
        PROTOCOL_VERSIONS.put("1.19.1", 760);
        PROTOCOL_VERSIONS.put("1.19.3", 761);
        PROTOCOL_VERSIONS.put("1.19.4", 762);
        PROTOCOL_VERSIONS.put("1.20.2", 764);
        PROTOCOL_VERSIONS.put("1.20.3", 765);
        PROTOCOL_VERSIONS.put("1.20.5", 766);
        PROTOCOL_VERSIONS.put("1.21", 767);
        PROTOCOL_VERSIONS.put("1.21.2", 768);
        PROTOCOL_VERSIONS.put("1.21.4", 769);
        PROTOCOL_VERSIONS.put("1.21.5", 770);
        PROTOCOL_VERSIONS.put("1.21.6", 771);
        PROTOCOL_VERSIONS.put("1.21.9", 772);
        PROTOCOL_VERSIONS.put("1.21.11", 773);
        PROTOCOL_VERSIONS.put("26w14a", 774);
        PROTOCOL_VERSIONS.put("26.1", 775);
        PROTOCOL_VERSIONS.put("26.2", 776);
    }

    private final Gson gson;
    private final HttpClient client;
    private final Path cacheDir;

    public SchemaLoader(Path cacheDir) {
        this.gson = new GsonBuilder().setLenient().create();
        this.client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();
        this.cacheDir = cacheDir;
    }

    public List<VersionData> loadAll() throws IOException, InterruptedException {
        List<String> versions = fetchVersions();
        System.out.println("Found " + versions.size() + " versions: " + versions);

        List<VersionData> result = new ArrayList<>();
        for (String version : versions) {
            System.out.println("Loading version " + version + "...");
            VersionData data = loadVersion(version);
            if (data != null) {
                result.add(data);
            }
        }
        result.sort(Comparator.comparingInt(VersionData::protocolVersion));
        return result;
    }

    private List<String> fetchVersions() throws IOException, InterruptedException {
        Path cacheFile = cacheDir.resolve("versions.json");
        String json;
        if (Files.exists(cacheFile)) {
            json = Files.readString(cacheFile);
        } else {
            System.out.println("Fetching versions list from " + VERSIONS_URL);
            json = fetch(VERSIONS_URL);
            Files.createDirectories(cacheDir);
            Files.writeString(cacheFile, json);
        }
        Type listType = new TypeToken<List<String>>() {}.getType();
        return gson.fromJson(json, listType);
    }

    private VersionData loadVersion(String version) throws IOException, InterruptedException {
        Integer protocol = PROTOCOL_VERSIONS.get(version);
        if (protocol == null) {
            System.out.println("WARNING: Unknown protocol version for " + version + ", skipping");
            return null;
        }

        Path cacheFile = cacheDir.resolve(version + ".json");
        String json;
        if (Files.exists(cacheFile)) {
            json = Files.readString(cacheFile);
        } else {
            String url = DATA_URL_FORMAT.formatted(version);
            System.out.println("Fetching " + url);
            json = fetch(url);
            Files.createDirectories(cacheDir);
            Files.writeString(cacheFile, json);
        }

        Type mapType = new TypeToken<Map<String, EntitySchema>>() {}.getType();
        Map<String, EntitySchema> entities = gson.fromJson(json, mapType);
        return new VersionData(version, protocol, entities);
    }

    private String fetch(String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .timeout(Duration.ofSeconds(15))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != 200) {
            throw new IOException("Failed to fetch " + url + ": " + response.statusCode());
        }
        return response.body();
    }
}
