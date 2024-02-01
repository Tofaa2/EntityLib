package me.tofaa.entitylib.codegen;

import com.github.retrooper.packetevents.protocol.entity.data.EntityData;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataType;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityMetadata;
import com.google.gson.reflect.TypeToken;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import com.squareup.javapoet.TypeVariableName;
import org.jetbrains.annotations.NotNull;

import javax.lang.model.element.Modifier;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static me.tofaa.entitylib.codegen.Main.OUT;
import static me.tofaa.entitylib.codegen.Main.builder;

public final class MetadataClass {

    private MetadataClass() {

    }
    public static void createMetadataClass() {

        TypeSpec.Builder builder = builder("me.tofaa.entitylib.meta", "Metadata");
        builder.addField(int.class, "entityId", Modifier.PRIVATE, Modifier.FINAL);
        builder.addField(TypeToken.getParameterized(Map.class, Byte.class, EntityData.class).getType(), "metadataMap", Modifier.PRIVATE, Modifier.FINAL);
        MethodSpec.Builder constructor = MethodSpec.constructorBuilder()
                .addModifiers(Modifier.PUBLIC)
                .addCode("this.entityId = entityId;\n")
                .addCode("this.metadataMap = new java.util.concurrent.ConcurrentHashMap<>();\n")
                .addParameter(int.class, "entityId");

        MethodSpec.Builder getIndex = MethodSpec.methodBuilder("getIndex")
                .addModifiers(Modifier.PUBLIC)
                .addTypeVariable(TypeVariableName.get("T"))
                .addParameter(byte.class, "index")
                .addParameter(TypeVariableName.get("T"), "defaultValue")
                .returns(TypeVariableName.get("T"))
                .addCode("EntityData entityData = metadataMap.get(index);\n")
                .addCode("if (entityData == null) return defaultValue;\n")
                .addCode("if (entityData.getValue() == null) return defaultValue;\n")
                .addCode("return (T) entityData.getValue();\n");

        MethodSpec.Builder setIndex = MethodSpec.methodBuilder("setIndex")
                .addModifiers(Modifier.PUBLIC)
                .addTypeVariable(TypeVariableName.get("T"))
                .addParameter(byte.class, "index")
                .addParameter(EntityDataType.class, "dataType")
                .addParameter(TypeVariableName.get("T"), "value")
                .addCode("EntityData data = new EntityData(index, dataType, value);\n")
                .addCode("this.metadataMap.put(index, data);\n");

        MethodSpec.Builder getEntries = MethodSpec.methodBuilder("getEntries")
                .addModifiers(Modifier.PUBLIC)
                .returns(TypeToken.getParameterized(List.class, EntityData.class).getType())
                .addCode("return new java.util.ArrayList<>(metadataMap.values());\n")
                .addAnnotation(NotNull.class);

        MethodSpec.Builder createPacket = MethodSpec.methodBuilder("createPacket")
                .addModifiers(Modifier.PUBLIC)
                .returns(WrapperPlayServerEntityMetadata.class)
                .addCode("return new WrapperPlayServerEntityMetadata(entityId, getEntries());\n")
                .addAnnotation(NotNull.class);

        builder.addMethod(constructor.build());
        builder.addMethod(getIndex.build());
        builder.addMethod(setIndex.build());
        builder.addMethod(getEntries.build());
        builder.addMethod(createPacket.build());

        JavaFile javaFile = JavaFile.builder("me.tofaa.entitylib.meta", builder.build()).build();
        try {
            javaFile.writeToPath(OUT.toPath());
        }
        catch (IOException e)  {
            throw new RuntimeException(e);
        }
    }



}
