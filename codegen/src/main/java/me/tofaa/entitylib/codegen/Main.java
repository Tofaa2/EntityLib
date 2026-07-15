package me.tofaa.entitylib.codegen;

import me.tofaa.entitylib.codegen.model.CrossVersionField;
import me.tofaa.entitylib.codegen.model.VersionData;

import java.nio.file.Path;
import java.util.List;

public final class Main {

    private Main() {}

    public static void main(String[] args) throws Exception {
        Path cacheDir = Path.of("codegen", "build", "schema-cache");
        Path outputDir = Path.of("api", "src", "main", "java");

        System.out.println("--- EntityLib v4 MetaField Codegen ---");
        System.out.println("Cache: " + cacheDir.toAbsolutePath());
        System.out.println("Output: " + outputDir.toAbsolutePath());

        SchemaLoader loader = new SchemaLoader(cacheDir);
        List<VersionData> versions = loader.loadAll();
        System.out.println("Loaded " + versions.size() + " versions");

        FieldAnalyzer analyzer = new FieldAnalyzer();
        List<CrossVersionField> fields = analyzer.analyze(versions);
        System.out.println("Found " + fields.size() + " cross-version fields");

        Generator generator = new Generator(outputDir);
        generator.generate(fields, versions);
        System.out.println("Done! Generated meta field classes in " + outputDir.toAbsolutePath());
    }
}
