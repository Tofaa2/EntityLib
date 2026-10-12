package me.tofaa.entitylib.codegen.schema;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.SafeConstructor;
import org.yaml.snakeyaml.representer.Representer;
import org.yaml.snakeyaml.resolver.Resolver;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.stream.Stream;

public final class SchemaIO {

    private SchemaIO() {
    }

    public static Schema read(Path schemaDir) {
        Schema schema = readBase(schemaDir);
        Path entities = schemaDir.resolve("entities");
        if (Files.isDirectory(entities)) {
            try (Stream<Path> files = Files.list(entities)) {
                files.filter(file -> file.getFileName().toString().endsWith(".yml")).sorted()
                        .forEach(file -> schema.add(readClass(file, schema)));
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }
        return schema;
    }

    public static Schema readBase(Path schemaDir) {
        Versions versions = new Versions();
        for (Object entry : list(map(load(schemaDir.resolve("versions.yml"))).get("versions"))) {
            Map<String, Object> version = map(entry);
            versions.add(string(version, "name"), Integer.decode(string(version, "protocol")));
        }
        Map<String, TypeDef> types = new LinkedHashMap<>();
        for (Map.Entry<String, Object> entry : map(map(load(schemaDir.resolve("types.yml"))).get("types")).entrySet()) {
            Map<String, Object> type = map(entry.getValue());
            List<String> upstream = new ArrayList<>();
            for (Object name : list(type.get("upstream"))) {
                upstream.add(String.valueOf(name));
            }
            TypeDef def = new TypeDef(entry.getKey(), string(type, "wire"), string(type, "java"), upstream,
                    optional(type, "since"), optional(type, "removed"), optional(type, "value"), optional(type, "convert"));
            if (def.since() != null) versions.get(def.since());
            if (def.removed() != null) versions.get(def.removed());
            types.put(entry.getKey(), def);
        }
        Schema schema = new Schema(versions, types);
        for (Object entry : list(map(load(schemaDir.resolve("types.yml"))).get("conversions"))) {
            Map<String, Object> conversion = map(entry);
            schema.addConversion(string(conversion, "value"), string(conversion, "wire"), string(conversion, "convert"));
        }
        Path enumsFile = schemaDir.resolve("enums.yml");
        if (Files.exists(enumsFile)) {
            for (Map.Entry<String, Object> entry : map(map(load(enumsFile)).get("enums")).entrySet()) {
                Map<String, Integer> constants = new LinkedHashMap<>();
                if (entry.getValue() instanceof List<?> names) {
                    for (Object name : names) {
                        constants.put(String.valueOf(name), constants.size());
                    }
                } else {
                    for (Map.Entry<String, Object> constant : map(entry.getValue()).entrySet()) {
                        constants.put(constant.getKey(), Integer.decode(String.valueOf(constant.getValue())));
                    }
                }
                schema.addEnum(entry.getKey(), constants);
            }
        }
        return schema;
    }

    private static SchemaClass readClass(Path file, Schema schema) {
        try {
            Map<String, Object> root = map(load(file));
            SchemaClass schemaClass = new SchemaClass();
            schemaClass.name = string(root, "class");
            schemaClass.since = optional(root, "since");
            if (schemaClass.since == null) {
                schemaClass.since = schema.versions().first().name();
            }
            schemaClass.removed = optional(root, "removed");
            for (Object entity : list(root.get("entities"))) {
                schemaClass.entities.add(String.valueOf(entity));
            }
            Object parents = root.get("extends");
            if (parents instanceof List<?> segments) {
                for (Object segment : segments) {
                    Map<String, Object> parent = map(segment);
                    String since = optional(parent, "since");
                    schemaClass.parents.add(new ParentRef(string(parent, "class"),
                            since != null ? since : schemaClass.since, optional(parent, "removed")));
                }
            } else if (parents != null) {
                schemaClass.parents.add(new ParentRef(String.valueOf(parents), schemaClass.since, schemaClass.removed));
            }
            for (Object entry : list(root.get("fields"))) {
                Map<String, Object> raw = map(entry);
                SchemaField field = new SchemaField();
                field.name = string(raw, "name");
                field.type = string(raw, "type");
                field.since = optional(raw, "since");
                if (field.since == null) {
                    field.since = schemaClass.since;
                }
                field.removed = optional(raw, "removed");
                if (field.removed == null) {
                    field.removed = schemaClass.removed;
                }
                String index = optional(raw, "index");
                field.index = index == null ? null : Integer.decode(index);
                field.convert = optional(raw, "convert");
                field.enumName = optional(raw, "enum");
                for (Object flagEntry : list(raw.get("flags"))) {
                    Map<String, Object> rawFlag = map(flagEntry);
                    SchemaFlag flag = new SchemaFlag();
                    flag.name = string(rawFlag, "name");
                    flag.mask = Integer.decode(string(rawFlag, "mask"));
                    flag.since = optional(rawFlag, "since");
                    flag.removed = optional(rawFlag, "removed");
                    field.flags.add(flag);
                }
                schemaClass.fields.add(field);
            }
            return schemaClass;
        } catch (SchemaException e) {
            throw new SchemaException(file.getFileName() + ": " + e.getMessage());
        }
    }

    public static Object load(Path file) {
        Resolver stringsOnly = new Resolver() {
            @Override
            protected void addImplicitResolvers() {
            }
        };
        DumperOptions dumperOptions = new DumperOptions();
        Yaml yaml = new Yaml(new SafeConstructor(new LoaderOptions()), new Representer(dumperOptions), dumperOptions,
                new LoaderOptions(), stringsOnly);
        try {
            return yaml.load(Files.readString(file));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public static Map<String, Object> map(Object value) {
        if (value == null) {
            return Map.of();
        }
        if (!(value instanceof Map<?, ?>)) {
            throw new SchemaException("Expected a mapping but found: " + value);
        }
        return (Map<String, Object>) value;
    }

    public static List<?> list(Object value) {
        if (value == null) {
            return List.of();
        }
        if (!(value instanceof List<?> list)) {
            throw new SchemaException("Expected a list but found: " + value);
        }
        return list;
    }

    public static String string(Map<String, Object> map, String key) {
        Object value = map.get(key);
        if (value == null) {
            throw new SchemaException("Missing '" + key + "' in " + map);
        }
        return String.valueOf(value);
    }

    public static String optional(Map<String, Object> map, String key) {
        Object value = map.get(key);
        return value == null ? null : String.valueOf(value);
    }

    public static void writeClasses(Path schemaDir, Schema schema) {
        Path entities = schemaDir.resolve("entities");
        try {
            Files.createDirectories(entities);
            Map<String, String> wanted = new TreeMap<>();
            for (SchemaClass schemaClass : schema.classes()) {
                String previous = wanted.put(fileName(schemaClass.name), render(schemaClass));
                if (previous != null) {
                    throw new SchemaException("Two classes map to the file " + fileName(schemaClass.name));
                }
            }
            try (Stream<Path> files = Files.list(entities)) {
                for (Path file : files.toList()) {
                    if (file.getFileName().toString().endsWith(".yml") && !wanted.containsKey(file.getFileName().toString())) {
                        Files.delete(file);
                    }
                }
            }
            for (Map.Entry<String, String> entry : wanted.entrySet()) {
                Path file = entities.resolve(entry.getKey());
                if (!Files.exists(file) || !Files.readString(file).equals(entry.getValue())) {
                    Files.writeString(file, entry.getValue());
                }
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static String fileName(String className) {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < className.length(); i++) {
            char c = className.charAt(i);
            if (Character.isUpperCase(c) && i > 0) {
                out.append('_');
            }
            out.append(Character.toLowerCase(c));
        }
        return out + ".yml";
    }

    static String render(SchemaClass schemaClass) {
        StringBuilder out = new StringBuilder();
        out.append("class: ").append(schemaClass.name).append('\n');
        out.append("since: ").append(quote(schemaClass.since)).append('\n');
        if (schemaClass.removed != null) {
            out.append("removed: ").append(quote(schemaClass.removed)).append('\n');
        }
        List<ParentRef> parents = schemaClass.parents;
        if (parents.size() == 1 && Objects.equals(parents.get(0).since, schemaClass.since)
                && Objects.equals(parents.get(0).removed, schemaClass.removed)) {
            out.append("extends: ").append(parents.get(0).parent).append('\n');
        } else if (!parents.isEmpty()) {
            out.append("extends:\n");
            for (ParentRef parent : parents) {
                out.append("  - {class: ").append(parent.parent);
                if (!Objects.equals(parent.since, schemaClass.since)) {
                    out.append(", since: ").append(quote(parent.since));
                }
                if (parent.removed != null) {
                    out.append(", removed: ").append(quote(parent.removed));
                }
                out.append("}\n");
            }
        }
        if (!schemaClass.entities.isEmpty()) {
            out.append("entities: [").append(String.join(", ", schemaClass.entities)).append("]\n");
        }
        if (schemaClass.fields.isEmpty()) {
            out.append("fields: []\n");
            return out.toString();
        }
        out.append("fields:\n");
        for (SchemaField field : schemaClass.fields) {
            StringBuilder attributes = new StringBuilder();
            attributes.append("name: ").append(field.name).append(", type: ").append(field.type);
            if (field.index != null) {
                attributes.append(", index: ").append(field.index);
            }
            if (!Objects.equals(field.since, schemaClass.since)) {
                attributes.append(", since: ").append(quote(field.since));
            }
            if (field.removed != null && !Objects.equals(field.removed, schemaClass.removed)) {
                attributes.append(", removed: ").append(quote(field.removed));
            }
            if (field.convert != null) {
                attributes.append(", convert: ").append(field.convert);
            }
            if (field.enumName != null) {
                attributes.append(", enum: ").append(field.enumName);
            }
            if (field.flags.isEmpty()) {
                out.append("  - {").append(attributes).append("}\n");
                continue;
            }
            String[] parts = attributes.toString().split(", ");
            for (int i = 0; i < parts.length; i++) {
                out.append(i == 0 ? "  - " : "    ").append(parts[i]).append('\n');
            }
            out.append("    flags:\n");
            for (SchemaFlag flag : field.flags) {
                out.append("      - {name: ").append(flag.name).append(", mask: ").append(String.format("0x%02X", flag.mask));
                if (flag.since != null) {
                    out.append(", since: ").append(quote(flag.since));
                }
                if (flag.removed != null) {
                    out.append(", removed: ").append(quote(flag.removed));
                }
                out.append("}\n");
            }
        }
        return out.toString();
    }

    private static String quote(String value) {
        return '"' + value + '"';
    }
}
