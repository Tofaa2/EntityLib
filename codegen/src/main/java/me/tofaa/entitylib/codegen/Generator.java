package me.tofaa.entitylib.codegen;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.squareup.javapoet.*;
import me.tofaa.entitylib.codegen.TypeMapper.TypeInfo;
import me.tofaa.entitylib.codegen.model.*;
import me.tofaa.entitylib.meta.MetaField;

import javax.lang.model.element.Modifier;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public final class Generator {

    private static final String BASE_PACKAGE = "me.tofaa.entitylib.meta";
    private static final ClassName EDT = ClassName.get(EntityDataTypes.class);

    private final Path outputDir;
    private final TypeMapper typeMapper;

    public Generator(Path outputDir) {
        this.outputDir = outputDir;
        this.typeMapper = new TypeMapper();
    }

    public void generate(List<CrossVersionField> fields, List<VersionData> versions) throws IOException {
        Map<String, List<CrossVersionField>> ownFields = new LinkedHashMap<>();
        for (CrossVersionField field : fields) {
            ownFields.computeIfAbsent(field.entityName(), k -> new ArrayList<>()).add(field);
        }

        Map<String, String> superClass = buildHierarchy(versions);

        TypeSpec.Builder metaFields = TypeSpec.classBuilder("MetaFields")
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addJavadoc("Generated meta field constants organized by entity type.\n");

        for (String entityName : ownFields.keySet()) {
            List<CrossVersionField> allFields = resolveAllFields(entityName, ownFields, superClass);
            if (allFields.isEmpty()) continue;
            metaFields.addType(generateEntityClass(entityName, allFields));
        }

        metaFields.addMethod(MethodSpec.constructorBuilder()
                .addModifiers(Modifier.PRIVATE)
                .build());

        JavaFile.builder(BASE_PACKAGE, metaFields.build())
                .indent("    ")
                .skipJavaLangImports(true)
                .build()
                .writeTo(outputDir);
    }

    private Map<String, String> buildHierarchy(List<VersionData> versions) {
        if (versions.isEmpty()) return Map.of();
        VersionData latest = versions.get(versions.size() - 1);
        Map<String, String> hierarchy = new HashMap<>();
        for (Map.Entry<String, EntitySchema> e : latest.entities().entrySet()) {
            String sc = e.getValue().superClass();
            if (sc != null && !sc.isEmpty()) {
                hierarchy.put(e.getKey(), sc);
            }
        }
        return hierarchy;
    }

    private List<CrossVersionField> resolveAllFields(
            String entityName,
            Map<String, List<CrossVersionField>> ownFields,
            Map<String, String> superClass
    ) {
        Set<String> seen = new LinkedHashSet<>();
        List<CrossVersionField> result = new ArrayList<>();

        List<CrossVersionField> own = ownFields.get(entityName);
        if (own != null) {
            for (CrossVersionField f : own) {
                seen.add(f.fieldName());
                result.add(f);
            }
        }

        String current = entityName;
        while (superClass.containsKey(current)) {
            current = superClass.get(current);
            List<CrossVersionField> inherited = ownFields.get(current);
            if (inherited != null) {
                for (CrossVersionField f : inherited) {
                    if (!seen.contains(f.fieldName())) {
                        seen.add(f.fieldName());
                        result.add(f);
                    }
                }
            }
        }

        return result;
    }

    private TypeSpec generateEntityClass(String entityName, List<CrossVersionField> fields) {
        String className = sanitizeClassName(entityName);

        TypeSpec.Builder classBuilder = TypeSpec.classBuilder(className)
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                .addJavadoc("Meta field constants for $L.\n", entityName);

        for (CrossVersionField field : fields) {
            classBuilder.addField(generateField(field));
        }

        classBuilder.addMethod(MethodSpec.constructorBuilder()
                .addModifiers(Modifier.PRIVATE)
                .build());

        return classBuilder.build();
    }

    private FieldSpec generateField(CrossVersionField field) {
        TypeName canonicalType = determineCanonicalType(field.ranges());
        String builderMethod = builderMethodFor(canonicalType);

        CodeBlock.Builder init = CodeBlock.builder()
                .add("$L(\"$L\")", builderMethod, field.fieldName());

        String defaultValue = sanitizeDefaultValue(field.ranges().get(field.ranges().size() - 1).dataType());
        if (defaultValue != null) {
            init.add("\n.defaultValue($L)", defaultValue);
        }

        for (VersionRange range : field.ranges()) {
            TypeInfo rangeType = typeMapper.map(range.dataType());
            init.add("\n.versionRange($L, $L, $L, $T.$L)",
                    range.minProtocol(), range.maxProtocol(), range.index(),
                    EDT, rangeType.dataTypeField());
        }

        init.add("\n.build()");

        TypeName fieldType = ParameterizedTypeName.get(ClassName.get(MetaField.class), canonicalType);
        return FieldSpec.builder(fieldType, field.fieldName(), Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                .initializer(init.build())
                .build();
    }

    private TypeName determineCanonicalType(List<VersionRange> ranges) {
        return typeMapper.map(ranges.get(ranges.size() - 1).dataType()).javaType();
    }

    private String builderMethodFor(TypeName type) {
        if (type.equals(ClassName.get(Byte.class))) return "MetaField.byteBuilder";
        if (type.equals(ClassName.get(Integer.class))) return "MetaField.intBuilder";
        if (type.equals(ClassName.get(Boolean.class))) return "MetaField.booleanBuilder";
        if (type.equals(ClassName.get(Float.class))) return "MetaField.floatBuilder";
        if (type.equals(ClassName.get(Long.class))) return "MetaField.longBuilder";
        if (type.equals(ClassName.get(String.class))) return "MetaField.stringBuilder";
        return "MetaField.builder";
    }

    private String sanitizeDefaultValue(String dataType) {
        return switch (dataType) {
            case "Byte" -> "(byte) 0";
            case "Integer" -> "0";
            case "Boolean" -> "false";
            case "Float" -> "0.0f";
            case "Short" -> "(short) 0";
            case "String" -> "\"\"";
            case "Long" -> "0L";
            default -> null;
        };
    }

    private String sanitizeClassName(String name) {
        return name.replace(" ", "")
                .replace("'", "")
                .replace(".", "")
                .replace("-", "");
    }
}
