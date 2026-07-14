package me.tofaa.entitylib.codegen.model;

public record FieldDef(
        int index,
        String dataType,
        String fieldName,
        String defaultValue
) {}
