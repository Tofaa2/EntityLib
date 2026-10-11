package me.tofaa.entitylib.codegen.snapshot;

import me.tofaa.entitylib.codegen.schema.Versions;

import java.util.List;
import java.util.Map;

public record Snapshot(Versions.Version version, Map<String, SnapClass> classes, boolean omitsEmptyClasses,
                       boolean explicitIndexes) {
    public record SnapClass(String name, String parent, List<SnapField> fields) {
    }

    public record SnapField(int index, String name, String type) {
    }
}
