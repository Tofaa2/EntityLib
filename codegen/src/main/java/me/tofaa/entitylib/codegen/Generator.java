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

    private static final String BASE_PACKAGE = "me.tofaa.entitylib.meta.generated";
    private static final ClassName EDT = ClassName.get(EntityDataTypes.class);

    private final Path outputDir;
    private final TypeMapper typeMapper;

    public Generator(Path outputDir) {
        this.outputDir = outputDir;
        this.typeMapper = new TypeMapper();
    }

    public void generate(List<CrossVersionField> fields, List<VersionData> versions) throws IOException {
        Map<String, List<CrossVersionField>> byEntity = new LinkedHashMap<>();
        for (CrossVersionField field : fields) {
            byEntity.computeIfAbsent(field.entityName(), k -> new ArrayList<>()).add(field);
        }

        for (Map.Entry<String, List<CrossVersionField>> entry : byEntity.entrySet()) {
            String entityName = entry.getKey();
            List<CrossVersionField> entityFields = entry.getValue();
            if (entityFields.isEmpty()) continue;

            generateEntityClass(entityName, entityFields);
        }
    }

    private void generateEntityClass(
            String entityName,
            List<CrossVersionField> fields
    ) throws IOException {
        String className = sanitizeClassName(entityName) + "MetaFields";

        TypeSpec.Builder classBuilder = TypeSpec.classBuilder(className)
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addJavadoc("Generated meta field constants for $L.\n", entityName);

        for (CrossVersionField field : fields) {
            classBuilder.addField(generateField(field));
        }

        classBuilder.addMethod(MethodSpec.constructorBuilder()
                .addModifiers(Modifier.PRIVATE)
                .build());

        TypeSpec typeSpec = classBuilder.build();
        JavaFile javaFile = JavaFile.builder(BASE_PACKAGE, typeSpec)
                .indent("    ")
                .skipJavaLangImports(true)
                .build();

        javaFile.writeTo(outputDir);
    }

    private FieldSpec generateField(CrossVersionField field) {
        TypeName effectiveType = determineFieldType(field.ranges());
        TypeInfo firstTypeInfo = typeMapper.map(firstType(field.ranges()));

        TypeName metaFieldType = ParameterizedTypeName.get(
                ClassName.get(MetaField.class),
                effectiveType
        );

        String builderMethod = builderMethodForType(effectiveType);
        CodeBlock.Builder init = CodeBlock.builder()
                .add("$L(\"$L\")", builderMethod, field.fieldName());

        String defaultValue = sanitizeDefaultValue(firstType(field.ranges()));
        if (defaultValue != null && isWellKnownType(effectiveType)) {
            init.add("\n.defaultValue($L)", defaultValue);
        }

        for (VersionRange range : field.ranges()) {
            TypeInfo rangeType = typeMapper.map(range.dataType());
            init.add("\n.versionRange($L, $L, $L, $T.$L)",
                    range.minProtocol(),
                    range.maxProtocol(),
                    range.index(),
                    EDT,
                    rangeType.dataTypeField());
        }

        init.add("\n.build()");

        return FieldSpec.builder(metaFieldType, field.fieldName(), Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                .initializer(init.build())
                .build();
    }

    private TypeName determineFieldType(List<VersionRange> ranges) {
        Set<TypeName> types = ranges.stream()
                .map(r -> typeMapper.map(r.dataType()).javaType())
                .collect(Collectors.toSet());
        if (types.size() == 1) {
            return types.iterator().next();
        }
        return TypeName.OBJECT;
    }

    private boolean isWellKnownType(TypeName type) {
        return type.equals(ClassName.get(Byte.class))
                || type.equals(ClassName.get(Integer.class))
                || type.equals(ClassName.get(Boolean.class))
                || type.equals(ClassName.get(Float.class))
                || type.equals(ClassName.get(String.class))
                || type.equals(ClassName.get(Long.class));
    }

    private String builderMethodForType(TypeName type) {
        if (type.equals(ClassName.get(Byte.class))) return "MetaField.byteBuilder";
        if (type.equals(ClassName.get(Integer.class))) return "MetaField.intBuilder";
        if (type.equals(ClassName.get(Boolean.class))) return "MetaField.booleanBuilder";
        if (type.equals(ClassName.get(Float.class))) return "MetaField.floatBuilder";
        if (type.equals(ClassName.get(String.class))) return "MetaField.stringBuilder";
        if (type.equals(ClassName.get(Long.class))) return "MetaField.longBuilder";
        return "MetaField.builder";
    }

    private String firstType(List<VersionRange> ranges) {
        return ranges.iterator().next().dataType();
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
