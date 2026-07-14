package me.tofaa.entitylib.codegen.model;

import java.util.List;

public record EntitySchema(
        String superClass,
        List<FieldDef> fields
) {}
