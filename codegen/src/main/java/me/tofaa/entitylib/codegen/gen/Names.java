package me.tofaa.entitylib.codegen.gen;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.WildcardTypeName;

import java.util.ArrayList;
import java.util.List;

final class Names {

    static final String META_PACKAGE = "me.tofaa.entitylib.meta";
    static final ClassName META_FIELD = ClassName.get(META_PACKAGE, "MetaField");
    static final ClassName META_FLAG = ClassName.get(META_PACKAGE, "MetaFlag");
    static final ClassName META_CLASS = ClassName.get(META_PACKAGE, "MetaClass");
    static final ClassName META_VIEW = ClassName.get(META_PACKAGE, "MetaView");
    static final ClassName METADATA = ClassName.get(META_PACKAGE, "Metadata");
    static final ClassName META_FIELDS = ClassName.get(META_PACKAGE, "MetaFields");
    static final ClassName META_CONVERTERS = ClassName.get(META_PACKAGE, "MetaConverters");
    static final ClassName DATA_TYPES =
            ClassName.get("com.github.retrooper.packetevents.protocol.entity.data", "EntityDataTypes");
    static final ClassName ENTITY_TYPE =
            ClassName.get("com.github.retrooper.packetevents.protocol.entity.type", "EntityType");
    static final ClassName ENTITY_TYPES =
            ClassName.get("com.github.retrooper.packetevents.protocol.entity.type", "EntityTypes");
    static final String ENUMS_PACKAGE = META_PACKAGE + ".enums";

    static TypeName valueType(Model.Field field) {
        return field.enumName() != null ? ClassName.get(ENUMS_PACKAGE, field.enumName()) : type(field.valueType().valueJava());
    }

    static final ClassName NOT_NULL = ClassName.get("org.jetbrains.annotations", "NotNull");
    static final ClassName NULLABLE = ClassName.get("org.jetbrains.annotations", "Nullable");

    private Names() {
    }

    static String camel(String upperSnake) {
        StringBuilder out = new StringBuilder();
        for (String part : upperSnake.split("_")) {
            if (part.isEmpty()) {
                continue;
            }
            out.append(Character.toUpperCase(part.charAt(0))).append(part.substring(1).toLowerCase());
        }
        return out.toString();
    }

    static TypeName type(String java) {
        String text = java.trim();
        if (text.equals("?")) {
            return WildcardTypeName.subtypeOf(Object.class);
        }
        int open = text.indexOf('<');
        if (open < 0) {
            return ClassName.bestGuess(text);
        }
        ClassName raw = ClassName.bestGuess(text.substring(0, open));
        String inner = text.substring(open + 1, text.lastIndexOf('>'));
        List<TypeName> arguments = new ArrayList<>();
        int depth = 0;
        int start = 0;
        for (int i = 0; i < inner.length(); i++) {
            char c = inner.charAt(i);
            if (c == '<') depth++;
            if (c == '>') depth--;
            if (c == ',' && depth == 0) {
                arguments.add(type(inner.substring(start, i)));
                start = i + 1;
            }
        }
        arguments.add(type(inner.substring(start)));
        return ParameterizedTypeName.get(raw, arguments.toArray(new TypeName[0]));
    }
}
