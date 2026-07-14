package me.tofaa.entitylib.codegen.model;

import java.util.List;

public record CrossVersionField(
        String entityName,
        String fieldName,
        List<VersionRange> ranges
) {}
