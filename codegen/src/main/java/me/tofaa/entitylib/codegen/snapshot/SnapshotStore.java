package me.tofaa.entitylib.codegen.snapshot;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import me.tofaa.entitylib.codegen.schema.Schema;
import me.tofaa.entitylib.codegen.schema.SchemaException;
import me.tofaa.entitylib.codegen.schema.Versions;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public final class SnapshotStore {

    private static final String KENNYTV_URL = "https://kennytv.eu/entity-data/%s.json";

    private final Path directory;

    public SnapshotStore(Path directory) {
        this.directory = directory;
    }

    public List<Snapshot> load(Schema schema, Upstream upstream) {
        List<Snapshot> snapshots = new ArrayList<>();
        if (!Files.isDirectory(directory)) {
            return snapshots;
        }
        try (Stream<Path> files = Files.list(directory)) {
            for (Path file : files.sorted().toList()) {
                String fileName = file.getFileName().toString();
                if (!fileName.endsWith(".json")) {
                    continue;
                }
                String versionName = fileName.substring(0, fileName.length() - ".json".length());
                if (upstream.ignores(versionName)) {
                    continue;
                }
                if (!schema.versions().contains(versionName)) {
                    throw new SchemaException("Snapshot " + fileName + " is for a version that is not in versions.yml; "
                            + "add the version there or list it under ignoredVersions in upstream.yml");
                }
                snapshots.add(parse(file, schema.versions().get(versionName), schema, upstream));
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        snapshots.sort(Comparator.comparingInt(snapshot -> snapshot.version().ordinal()));
        return snapshots;
    }

    private Snapshot parse(Path file, Versions.Version version, Schema schema, Upstream upstream) throws IOException {
        JsonObject root = JsonParser.parseString(Files.readString(file)).getAsJsonObject();
        Map<String, Snapshot.SnapClass> classes = new LinkedHashMap<>();
        boolean omitsEmptyClasses = false;
        boolean explicitIndexes = false;
        for (Map.Entry<String, JsonElement> entry : root.entrySet()) {
            if (entry.getKey().startsWith("_")) {
                JsonElement omits = entry.getValue().getAsJsonObject().get("omitsEmptyClasses");
                omitsEmptyClasses |= omits != null && omits.getAsBoolean();
                JsonElement explicit = entry.getValue().getAsJsonObject().get("explicitIndexes");
                explicitIndexes |= explicit != null && explicit.getAsBoolean();
                continue;
            }
            JsonObject raw = entry.getValue().getAsJsonObject();
            String name = upstream.className(entry.getKey());
            JsonElement parent = raw.get("superClass");
            List<Snapshot.SnapField> fields = new ArrayList<>();
            for (JsonElement element : raw.getAsJsonArray("fields")) {
                JsonObject field = element.getAsJsonObject();
                String type;
                try {
                    type = schema.upstreamType(field.get("dataType").getAsString(), version).name();
                } catch (SchemaException e) {
                    throw new SchemaException(file.getFileName() + ", " + entry.getKey() + "."
                            + field.get("fieldName").getAsString() + ": " + e.getMessage());
                }
                fields.add(new Snapshot.SnapField(field.get("index").getAsInt(),
                        upstream.fieldName(name, field.get("fieldName").getAsString(), field.get("dataType").getAsString()), type));
            }
            Snapshot.SnapClass previous = classes.put(name, new Snapshot.SnapClass(name,
                    parent == null || parent.isJsonNull() ? null : upstream.className(parent.getAsString()), fields));
            if (previous != null) {
                throw new SchemaException(file.getFileName() + ": two classes normalize to " + name);
            }
        }
        return new Snapshot(version, classes, omitsEmptyClasses, explicitIndexes);
    }

    public Path fetch(String version) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10))
                .followRedirects(HttpClient.Redirect.NORMAL).build();
        String url = KENNYTV_URL.formatted(version);
        HttpResponse<String> response = client.send(
                HttpRequest.newBuilder().uri(URI.create(url)).timeout(Duration.ofSeconds(30)).GET().build(),
                HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != 200) {
            throw new IOException("Fetching " + url + " failed with status " + response.statusCode());
        }
        JsonParser.parseString(response.body()).getAsJsonObject();
        Files.createDirectories(directory);
        Path file = directory.resolve(version + ".json");
        Files.writeString(file, response.body());
        return file;
    }
}
