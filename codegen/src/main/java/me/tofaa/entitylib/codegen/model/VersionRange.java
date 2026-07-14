package me.tofaa.entitylib.codegen.model;

public record VersionRange(
        int minProtocol,
        int maxProtocol,
        int index,
        String dataType
) {}
