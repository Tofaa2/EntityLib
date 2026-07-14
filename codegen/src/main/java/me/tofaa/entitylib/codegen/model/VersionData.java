package me.tofaa.entitylib.codegen.model;

import java.util.Map;

public record VersionData(
        String version,
        int protocolVersion,
        Map<String, EntitySchema> entities
) {}
