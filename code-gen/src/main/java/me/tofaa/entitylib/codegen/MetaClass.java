package me.tofaa.entitylib.codegen;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.TypeSpec;

import java.util.List;

import static me.tofaa.entitylib.codegen.Main.builder;

public record MetaClass(
        String name,
        String extendsClass,
        List<MetaMethod> methods
) {


    public TypeSpec create() {
        String split[] = name.split(":");
        String packageName = split[0];
        String className = split[1];

        TypeSpec.Builder builder = builder(packageName, className);
        if (extendsClass != null) {
            String[] extendsSplit = extendsClass.split(":");
            builder.superclass(ClassName.get(extendsSplit[0], extendsSplit[1]));

            builder.addField(int.class, "entityId");
            builder.addField(ClassName.get("me.tofaa.entitylib.meta", "Metadata"), "metadata");

        }
        for (MetaMethod method : methods) {
            builder.addMethods(method.create());
        }
        return builder.build();
    }


}
