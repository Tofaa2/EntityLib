package me.tofaa.entitylib.codegen.gen;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import me.tofaa.entitylib.codegen.schema.Layouts;
import me.tofaa.entitylib.codegen.schema.Schema;
import me.tofaa.entitylib.codegen.schema.SchemaClass;
import me.tofaa.entitylib.codegen.schema.SchemaFlag;
import me.tofaa.entitylib.codegen.schema.Versions;

import javax.lang.model.element.Modifier;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class WrappersGenerator {

    private final Model model;
    private final Schema schema;
    private final Layouts layouts;
    private final Map<String, Map<String, String>> accessorNames = new HashMap<>();

    public WrappersGenerator(Model model) {
        this.model = model;
        this.schema = model.schema();
        this.layouts = model.layouts();
    }

    public int generate(Path outputDir, Set<String> only) throws IOException {
        int count = 0;
        for (Versions.Version version : schema.versions().list()) {
            if (!only.isEmpty() && !only.contains(version.name())) {
                continue;
            }
            if (schema.classes().stream().noneMatch(schemaClass -> schema.alive(schemaClass, version))) {
                continue;
            }
            String packageName = Names.META_PACKAGE + "." + version.identifier();
            JavaFile.builder(packageName, factory(version, packageName))
                    .indent("    ")
                    .skipJavaLangImports(true)
                    .build()
                    .writeTo(outputDir);
            for (SchemaClass schemaClass : schema.classes()) {
                if (!schema.alive(schemaClass, version)) {
                    continue;
                }
                JavaFile.builder(packageName, wrapper(schemaClass, version, packageName))
                        .indent("    ")
                        .skipJavaLangImports(true)
                        .build()
                        .writeTo(outputDir);
                count++;
            }
        }
        return count;
    }

    private TypeSpec factory(Versions.Version version, String packageName) {
        SchemaClass root = null;
        com.squareup.javapoet.CodeBlock.Builder init = com.squareup.javapoet.CodeBlock.builder();
        for (SchemaClass schemaClass : schema.classes()) {
            if (!schema.alive(schemaClass, version)) {
                continue;
            }
            if (schema.parent(schemaClass, version) == null) {
                root = schemaClass;
            }
            init.addStatement("FACTORIES.put($T.META_CLASS, $T::new)", Names.META_FIELDS.nestedClass(schemaClass.name),
                    ClassName.get(packageName, schemaClass.name + "Meta"));
        }
        ClassName rootMeta = ClassName.get(packageName, root.name + "Meta");
        TypeName function = com.squareup.javapoet.ParameterizedTypeName.get(ClassName.get("java.util.function", "Function"),
                Names.METADATA, rootMeta);
        TypeName factories = com.squareup.javapoet.ParameterizedTypeName.get(ClassName.get("java.util", "Map"),
                Names.META_CLASS, function);
        return TypeSpec.classBuilder(ClassName.get(packageName, "EntityMetas"))
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addField(com.squareup.javapoet.FieldSpec.builder(int.class, "PROTOCOL_VERSION", Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                        .initializer("$L", version.protocol()).build())
                .addField(com.squareup.javapoet.FieldSpec.builder(factories, "FACTORIES", Modifier.PRIVATE, Modifier.STATIC, Modifier.FINAL)
                        .initializer("new $T<>()", ClassName.get("java.util", "HashMap")).build())
                .addStaticBlock(init.build())
                .addMethod(MethodSpec.constructorBuilder().addModifiers(Modifier.PRIVATE).build())
                .addMethod(MethodSpec.methodBuilder("create")
                        .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                        .addAnnotation(Names.NULLABLE)
                        .returns(rootMeta)
                        .addParameter(com.squareup.javapoet.ParameterSpec.builder(Names.ENTITY_TYPE, "entityType").addAnnotation(Names.NOT_NULL).build())
                        .addParameter(com.squareup.javapoet.ParameterSpec.builder(Names.METADATA, "metadata").addAnnotation(Names.NOT_NULL).build())
                        .addStatement("$T metaClass = $T.metaClass(entityType, PROTOCOL_VERSION)", Names.META_CLASS, Names.META_FIELDS)
                        .addStatement("$T factory = metaClass == null ? null : FACTORIES.get(metaClass)", function)
                        .addStatement("return factory == null ? null : factory.apply(metadata)")
                        .build())
                .addMethod(MethodSpec.methodBuilder("create")
                        .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                        .addAnnotation(Names.NULLABLE)
                        .returns(rootMeta)
                        .addParameter(com.squareup.javapoet.ParameterSpec.builder(Names.ENTITY_TYPE, "entityType").addAnnotation(Names.NOT_NULL).build())
                        .addStatement("return create(entityType, new $T())", Names.METADATA)
                        .build())
                .build();
    }

    private TypeSpec wrapper(SchemaClass schemaClass, Versions.Version version, String packageName) {
        ClassName self = ClassName.get(packageName, schemaClass.name + "Meta");
        SchemaClass parent = schema.parent(schemaClass, version);
        ClassName fieldsHolder = Names.META_FIELDS.nestedClass(schemaClass.name);
        TypeSpec.Builder type = TypeSpec.classBuilder(self)
                .addModifiers(Modifier.PUBLIC)
                .superclass(parent == null ? Names.META_VIEW : ClassName.get(packageName, parent.name + "Meta"))
                .addMethod(MethodSpec.constructorBuilder()
                        .addModifiers(Modifier.PUBLIC)
                        .addParameter(com.squareup.javapoet.ParameterSpec.builder(Names.METADATA, "metadata")
                                .addAnnotation(Names.NOT_NULL).build())
                        .addStatement("super(metadata)")
                        .build())
                .addMethod(MethodSpec.constructorBuilder()
                        .addModifiers(Modifier.PUBLIC)
                        .addStatement("this(new $T())", Names.METADATA)
                        .build());
        if (parent == null) {
            type.addMethod(MethodSpec.methodBuilder("protocolVersion")
                    .addAnnotation(Override.class)
                    .addModifiers(Modifier.PUBLIC)
                    .returns(int.class)
                    .addStatement("return $L", version.protocol())
                    .build());
        }
        type.addMethod(MethodSpec.methodBuilder("metaClass")
                .addAnnotation(Override.class)
                .addModifiers(Modifier.PUBLIC)
                .returns(Names.META_CLASS)
                .addAnnotation(Names.NOT_NULL)
                .addStatement("return $T.META_CLASS", fieldsHolder)
                .build());

        Map<String, String> names = accessorNames(schemaClass, version);
        for (Model.Field field : model.fields(schemaClass)) {
            if (!field.aliveIn(version)) {
                continue;
            }
            TypeName valueType = Names.valueType(field);
            String accessor = names.get(schemaClass.name + "." + field.name());
            type.addMethod(MethodSpec.methodBuilder("get" + accessor)
                    .addModifiers(Modifier.PUBLIC)
                    .returns(valueType)
                    .addAnnotation(Names.NULLABLE)
                    .addStatement("return metadata.get($T.$L)", fieldsHolder, field.name())
                    .build());
            type.addMethod(MethodSpec.methodBuilder("set" + accessor)
                    .addModifiers(Modifier.PUBLIC)
                    .addParameter(com.squareup.javapoet.ParameterSpec.builder(valueType, "value")
                            .addAnnotation(Names.NULLABLE).build())
                    .addStatement("metadata.set($T.$L, value)", fieldsHolder, field.name())
                    .build());
            for (Model.Flag flag : field.flags()) {
                if (!flag.aliveIn(version)) {
                    continue;
                }
                String flagAccessor = names.get(schemaClass.name + "." + field.name() + "#" + flag.name());
                type.addMethod(MethodSpec.methodBuilder("is" + flagAccessor)
                        .addModifiers(Modifier.PUBLIC)
                        .returns(boolean.class)
                        .addStatement("return metadata.getFlag($T.$L)", fieldsHolder, flag.constant())
                        .build());
                type.addMethod(MethodSpec.methodBuilder("set" + flagAccessor)
                        .addModifiers(Modifier.PUBLIC)
                        .addParameter(boolean.class, "value")
                        .addStatement("metadata.setFlag($T.$L, value)", fieldsHolder, flag.constant())
                        .build());
            }
        }
        return type.build();
    }

    private Map<String, String> accessorNames(SchemaClass schemaClass, Versions.Version version) {
        String key = schemaClass.name + "@" + version.name();
        Map<String, String> cached = accessorNames.get(key);
        if (cached != null) {
            return cached;
        }
        Map<String, String> names = new LinkedHashMap<>();
        SchemaClass parent = schema.parent(schemaClass, version);
        if (parent != null) {
            names.putAll(accessorNames(parent, version));
        }
        Set<String> taken = new HashSet<>(names.values());
        for (Model.Field field : model.fields(schemaClass)) {
            if (!field.aliveIn(version)) {
                continue;
            }
            names.put(schemaClass.name + "." + field.name(), unique(taken, Names.camel(field.name()), schemaClass.name));
            for (Model.Flag flag : field.flags()) {
                if (flag.aliveIn(version)) {
                    names.put(schemaClass.name + "." + field.name() + "#" + flag.name(),
                            unique(taken, Names.camel(flag.name()), schemaClass.name));
                }
            }
        }
        accessorNames.put(key, names);
        return names;
    }

    private static String unique(Set<String> taken, String name, String className) {
        String candidate = name;
        if (!taken.add(candidate)) {
            candidate = className + name;
            int suffix = 2;
            while (!taken.add(candidate)) {
                candidate = className + name + suffix++;
            }
        }
        return candidate;
    }
}
