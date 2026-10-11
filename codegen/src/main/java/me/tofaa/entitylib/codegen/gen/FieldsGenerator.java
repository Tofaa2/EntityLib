package me.tofaa.entitylib.codegen.gen;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import me.tofaa.entitylib.codegen.schema.ParentRef;
import me.tofaa.entitylib.codegen.schema.Schema;
import me.tofaa.entitylib.codegen.schema.SchemaClass;

import javax.lang.model.element.Modifier;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class FieldsGenerator {

    private final Model model;
    private final Schema schema;

    public FieldsGenerator(Model model) {
        this.model = model;
        this.schema = model.schema();
    }

    public void generate(Path outputDir) throws IOException {
        TypeSpec.Builder root = TypeSpec.classBuilder(Names.META_FIELDS)
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addMethod(MethodSpec.constructorBuilder().addModifiers(Modifier.PRIVATE).build());

        List<SchemaClass> classes = new ArrayList<>(schema.classes());
        classes.sort(Comparator.comparing(schemaClass -> schemaClass.name));
        CodeBlock.Builder all = CodeBlock.builder().add("$T.unmodifiableList($T.asList(\n$>$>",
                ClassName.get("java.util", "Collections"), ClassName.get("java.util", "Arrays"));
        for (int i = 0; i < classes.size(); i++) {
            root.addType(nested(classes.get(i)));
            all.add("$L.META_CLASS$L", classes.get(i).name, i + 1 < classes.size() ? ",\n" : "\n");
        }
        all.add("$<$<))");
        TypeName classList = ParameterizedTypeName.get(ClassName.get("java.util", "List"), Names.META_CLASS);
        root.addField(FieldSpec.builder(classList, "CLASSES", Modifier.PRIVATE, Modifier.STATIC, Modifier.FINAL)
                .initializer(all.build()).build());
        root.addMethod(MethodSpec.methodBuilder("classes")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .returns(classList)
                .addStatement("return CLASSES")
                .build());

        TypeName index = ParameterizedTypeName.get(ClassName.get("java.util", "Map"), Names.ENTITY_TYPE, classList);
        root.addField(FieldSpec.builder(index, "BY_ENTITY_TYPE", Modifier.PRIVATE, Modifier.STATIC, Modifier.FINAL)
                .initializer("$T.indexByEntityType(CLASSES)", Names.META_CLASS).build());
        root.addField(FieldSpec.builder(int.class, "LATEST_PROTOCOL", Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                .initializer("$L", schema.versions().latest().protocol()).build());
        root.addMethod(MethodSpec.methodBuilder("metaClasses")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .addAnnotation(Names.NOT_NULL)
                .returns(classList)
                .addParameter(com.squareup.javapoet.ParameterSpec.builder(Names.ENTITY_TYPE, "entityType").addAnnotation(Names.NOT_NULL).build())
                .addStatement("return $T.findAll(BY_ENTITY_TYPE, entityType)", Names.META_CLASS)
                .build());
        root.addMethod(MethodSpec.methodBuilder("owns")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .returns(boolean.class)
                .addParameter(com.squareup.javapoet.ParameterSpec.builder(Names.ENTITY_TYPE, "entityType").addAnnotation(Names.NOT_NULL).build())
                .addParameter(com.squareup.javapoet.ParameterSpec.builder(com.squareup.javapoet.ParameterizedTypeName.get(Names.META_FIELD, com.squareup.javapoet.WildcardTypeName.subtypeOf(Object.class)), "field").addAnnotation(Names.NOT_NULL).build())
                .addStatement("$T classes = metaClasses(entityType)", classList)
                .beginControlFlow("if (classes.isEmpty())")
                .addStatement("return true")
                .endControlFlow()
                .beginControlFlow("for ($T metaClass : classes)", Names.META_CLASS)
                .beginControlFlow("if (metaClass.owns(field))")
                .addStatement("return true")
                .endControlFlow()
                .endControlFlow()
                .addStatement("return false")
                .build());
        root.addMethod(MethodSpec.methodBuilder("metaClass")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .addAnnotation(Names.NULLABLE)
                .returns(Names.META_CLASS)
                .addParameter(com.squareup.javapoet.ParameterSpec.builder(Names.ENTITY_TYPE, "entityType").addAnnotation(Names.NOT_NULL).build())
                .addParameter(int.class, "protocolVersion")
                .addStatement("return $T.find(BY_ENTITY_TYPE, entityType, protocolVersion)", Names.META_CLASS)
                .build());
        root.addMethod(MethodSpec.methodBuilder("metaClass")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .addAnnotation(Names.NULLABLE)
                .returns(Names.META_CLASS)
                .addParameter(com.squareup.javapoet.ParameterSpec.builder(Names.ENTITY_TYPE, "entityType").addAnnotation(Names.NOT_NULL).build())
                .addStatement("return metaClass(entityType, LATEST_PROTOCOL)")
                .build());

        JavaFile.builder(Names.META_PACKAGE, root.build())
                .indent("    ")
                .skipJavaLangImports(true)
                .build()
                .writeTo(outputDir);
    }

    private TypeSpec nested(SchemaClass schemaClass) {
        TypeSpec.Builder type = TypeSpec.classBuilder(schemaClass.name)
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .addMethod(MethodSpec.constructorBuilder().addModifiers(Modifier.PROTECTED).build());
        SchemaClass javaParent = model.javaParent(schemaClass);
        if (javaParent != null) {
            type.superclass(Names.META_FIELDS.nestedClass(javaParent.name));
        }

        List<Model.Field> fields = model.fields(schemaClass);
        for (Model.Field field : fields) {
            TypeName valueType = Names.type(field.valueType().java());
            CodeBlock.Builder init = CodeBlock.builder()
                    .add("$T.<$T>builder($S, $S)\n$>$>", Names.META_FIELD, valueType, schemaClass.name, field.name());
            for (Model.Binding binding : field.bindings()) {
                init.add(".bind($L, $L, $L, $T.$L", binding.from().protocol(), protocol(binding.toProtocol()),
                        binding.index(), Names.DATA_TYPES, binding.type().wire());
                if (binding.convert() != null) {
                    init.add(", $T.$L", Names.META_CONVERTERS, binding.convert());
                }
                init.add(")\n");
            }
            for (Model.Flag flag : field.flags()) {
                for (Model.FlagRange range : flag.ranges()) {
                    init.add(".flag($S, $L, $L, $L)\n", flag.name(), range.from().protocol(), protocol(range.toProtocol()),
                            String.format("0x%02X", range.mask()));
                }
            }
            init.add(".build()$<$<");
            type.addField(FieldSpec.builder(ParameterizedTypeName.get(Names.META_FIELD, valueType), field.name(),
                            Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                    .initializer(init.build())
                    .build());
            for (Model.Flag flag : field.flags()) {
                type.addField(FieldSpec.builder(Names.META_FLAG, flag.constant(), Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                        .initializer("$L.flag($S)", field.name(), flag.name())
                        .build());
            }
        }

        CodeBlock.Builder metaClass = CodeBlock.builder().add("$T.builder($S)\n$>$>", Names.META_CLASS, schemaClass.name);
        metaClass.add(".lifetime($L, $L)\n", schema.versions().get(schemaClass.since).protocol(),
                protocol(schema.versions().endProtocol(schemaClass.removed)));
        for (ParentRef parent : schemaClass.parents) {
            metaClass.add(".parent($L, $L, $L.META_CLASS)\n", schema.versions().get(parent.since).protocol(),
                    protocol(schema.versions().endProtocol(parent.removed)), parent.parent);
        }
        if (!fields.isEmpty()) {
            metaClass.add(".fields(");
            for (int i = 0; i < fields.size(); i++) {
                metaClass.add(i == 0 ? "$L" : ", $L", fields.get(i).name());
            }
            metaClass.add(")\n");
        }
        if (!schemaClass.entities.isEmpty()) {
            metaClass.add(".entityTypes(");
            for (int i = 0; i < schemaClass.entities.size(); i++) {
                metaClass.add(i == 0 ? "$T.$L" : ", $T.$L", Names.ENTITY_TYPES, schemaClass.entities.get(i).toUpperCase(java.util.Locale.ROOT));
            }
            metaClass.add(")\n");
        }
        metaClass.add(".build()$<$<");
        type.addField(FieldSpec.builder(Names.META_CLASS, "META_CLASS", Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                .initializer(metaClass.build())
                .build());
        return type.build();
    }

    private static String protocol(int protocol) {
        return protocol == Integer.MAX_VALUE ? "Integer.MAX_VALUE" : String.valueOf(protocol);
    }
}
