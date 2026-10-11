package me.tofaa.entitylib.codegen.snapshot;

import me.tofaa.entitylib.codegen.schema.SchemaIO;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class Upstream {

    private final Set<String> ignoredVersions = new HashSet<>();
    private final Map<String, String> classRenames = new HashMap<>();
    private final Map<String, String> fieldRenames = new HashMap<>();

    public static Upstream read(Path file) {
        Upstream upstream = new Upstream();
        if (!Files.exists(file)) {
            return upstream;
        }
        Map<String, Object> root = SchemaIO.map(SchemaIO.load(file));
        for (Object version : SchemaIO.list(root.get("ignoredVersions"))) {
            upstream.ignoredVersions.add(String.valueOf(version));
        }
        for (Map.Entry<String, Object> entry : SchemaIO.map(root.get("classes")).entrySet()) {
            upstream.classRenames.put(entry.getKey(), String.valueOf(entry.getValue()));
        }
        for (Object entry : SchemaIO.list(root.get("fields"))) {
            Map<String, Object> rename = SchemaIO.map(entry);
            String type = SchemaIO.optional(rename, "type");
            upstream.fieldRenames.put(SchemaIO.string(rename, "class") + "." + SchemaIO.string(rename, "from")
                    + (type == null ? "" : ":" + type), SchemaIO.string(rename, "to"));
        }
        return upstream;
    }

    public boolean ignores(String version) {
        return ignoredVersions.contains(version);
    }

    public String className(String upstreamName) {
        if (upstreamName == null) {
            return null;
        }
        String name = upstreamName.replace(" ", "");
        return classRenames.getOrDefault(name, name);
    }

    public String fieldName(String className, String upstreamName, String upstreamType) {
        String typed = fieldRenames.get(className + "." + upstreamName + ":" + upstreamType);
        return typed != null ? typed : fieldRenames.getOrDefault(className + "." + upstreamName, upstreamName);
    }
}
