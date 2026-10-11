package me.tofaa.entitylib.codegen;

import me.tofaa.entitylib.codegen.gen.FieldsGenerator;
import me.tofaa.entitylib.codegen.gen.Model;
import me.tofaa.entitylib.codegen.gen.WrappersGenerator;
import me.tofaa.entitylib.codegen.schema.Layouts;
import me.tofaa.entitylib.codegen.schema.Schema;
import me.tofaa.entitylib.codegen.schema.SchemaClass;
import me.tofaa.entitylib.codegen.schema.SchemaException;
import me.tofaa.entitylib.codegen.schema.SchemaIO;
import me.tofaa.entitylib.codegen.schema.Versions;
import me.tofaa.entitylib.codegen.snapshot.Snapshot;
import me.tofaa.entitylib.codegen.snapshot.SnapshotStore;
import me.tofaa.entitylib.codegen.snapshot.Upstream;
import me.tofaa.entitylib.codegen.tool.Checker;
import me.tofaa.entitylib.codegen.tool.Importer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public final class Main {

    private Main() {
    }

    public static void main(String[] args) throws Exception {
        List<String> positional = new ArrayList<>();
        Map<String, String> options = new HashMap<>();
        for (int i = 0; i < args.length; i++) {
            if (args[i].startsWith("--")) {
                if (i + 1 >= args.length) {
                    fail("Missing value for " + args[i]);
                }
                options.put(args[i].substring(2), args[++i]);
            } else {
                positional.add(args[i]);
            }
        }
        if (positional.isEmpty()) {
            fail("Missing command; see the documentation of " + Main.class.getName());
        }
        Path schemaDir = Path.of(options.getOrDefault("schema", "codegen/schema"));
        SnapshotStore snapshots = new SnapshotStore(Path.of(options.getOrDefault("snapshots", "codegen/snapshots")));
        List<String> arguments = positional.subList(1, positional.size());
        try {
            switch (positional.get(0)) {
                case "check" -> check(schemaDir, snapshots);
                case "layout" -> layout(schemaDir, arguments);
                case "fetch" -> fetch(snapshots, arguments);
                case "import" -> importSnapshots(schemaDir, snapshots);
                case "update" -> {
                    fetch(snapshots, arguments);
                    importSnapshots(schemaDir, snapshots);
                }
                case "generate-fields" -> {
                    Path out = output(options);
                    clean(out);
                    new FieldsGenerator(new Model(checked(schemaDir))).generate(out);
                }
                case "generate-wrappers" -> {
                    Path out = output(options);
                    clean(out);
                    Set<String> only = new HashSet<>();
                    for (String version : options.getOrDefault("versions", "").split(",")) {
                        if (!version.isBlank()) {
                            only.add(version.trim());
                        }
                    }
                    WrappersGenerator generator = new WrappersGenerator(new Model(checked(schemaDir)));
                    int count = generator.generate(out, only);
                    System.out.println("Generated " + count + " wrapper classes");
                }
                default -> fail("Unknown command " + positional.get(0));
            }
        } catch (SchemaException e) {
            fail(e.getMessage());
        }
    }

    private static Path output(Map<String, String> options) {
        String out = options.get("out");
        if (out == null) {
            fail("Missing --out");
        }
        return Path.of(out);
    }

    private static void fail(String message) {
        System.err.println(message);
        System.exit(1);
    }

    private static Schema checked(Path schemaDir) {
        Schema schema = SchemaIO.read(schemaDir);
        Checker checker = new Checker(schema);
        checker.validate();
        report(checker.problems());
        return schema;
    }

    private static void report(List<String> problems) {
        if (problems.isEmpty()) {
            return;
        }
        StringBuilder message = new StringBuilder(problems.size() + " problem(s) in the schema:");
        for (String problem : problems) {
            message.append("\n  ").append(problem);
        }
        throw new SchemaException(message.toString());
    }

    private static void check(Path schemaDir, SnapshotStore store) {
        Schema schema = checked(schemaDir);
        List<Snapshot> snapshots = store.load(schema, Upstream.read(schemaDir.resolve("upstream.yml")));
        Checker checker = new Checker(schema);
        for (Snapshot snapshot : snapshots) {
            checker.verify(snapshot);
        }
        report(checker.problems());
        new Model(schema);
        System.out.println("Schema OK: " + schema.classes().size() + " classes, verified against "
                + snapshots.size() + " snapshots (" + snapshots.get(0).version() + " .. "
                + snapshots.get(snapshots.size() - 1).version() + ")");
    }

    private static void layout(Path schemaDir, List<String> arguments) {
        if (arguments.isEmpty()) {
            fail("Usage: layout <version> [class]");
        }
        Schema schema = checked(schemaDir);
        Layouts layouts = new Layouts(schema);
        Versions.Version version = schema.versions().get(arguments.get(0));
        for (SchemaClass schemaClass : schema.classes()) {
            if (!schema.alive(schemaClass, version) || (arguments.size() > 1 && !schemaClass.name.equals(arguments.get(1)))) {
                continue;
            }
            SchemaClass parent = schema.parent(schemaClass, version);
            System.out.println(schemaClass.name + (parent == null ? "" : " extends " + parent.name));
            for (Layouts.Slot slot : arguments.size() > 1 ? layouts.all(schemaClass, version) : layouts.own(schemaClass, version)) {
                System.out.printf("  %3d  %-45s %s%n", slot.index(), slot.owner().name + "." + slot.field().name, slot.field().type);
            }
        }
    }

    private static void fetch(SnapshotStore store, List<String> versions) throws IOException, InterruptedException {
        if (versions.isEmpty()) {
            fail("Name at least one version to fetch");
        }
        for (String version : versions) {
            System.out.println("Fetched " + store.fetch(version));
        }
    }

    private static void importSnapshots(Path schemaDir, SnapshotStore store) {
        Schema existing = SchemaIO.read(schemaDir);
        List<Snapshot> snapshots = store.load(existing, Upstream.read(schemaDir.resolve("upstream.yml")));
        Schema imported = new Importer(existing).run(snapshots);
        Checker checker = new Checker(imported);
        checker.validate();
        for (Snapshot snapshot : snapshots) {
            checker.verify(snapshot);
        }
        report(checker.problems());
        List<String> changes = Importer.describeChanges(existing, imported);
        SchemaIO.writeClasses(schemaDir, imported);
        if (changes.isEmpty()) {
            System.out.println("The schema already matches all " + snapshots.size() + " snapshots; nothing changed.");
            return;
        }
        System.out.println(changes.size() + " change(s) written to " + schemaDir.resolve("entities") + ":");
        changes.forEach(change -> System.out.println("  " + change));
        System.out.println("Review them with git diff. New fields may need flags or a converter added by hand.");
    }

    private static void clean(Path directory) throws IOException {
        if (!Files.isDirectory(directory)) {
            return;
        }
        try (Stream<Path> paths = Files.walk(directory)) {
            for (Path path : paths.sorted(Comparator.reverseOrder()).toList()) {
                if (!path.equals(directory)) {
                    Files.delete(path);
                }
            }
        }
    }
}
