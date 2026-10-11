package me.tofaa.entitylib.codegen.schema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class Versions {

    public record Version(String name, int protocol, int ordinal) {
        public String identifier() {
            return "v" + name.replace('.', '_');
        }

        @Override
        public String toString() {
            return name;
        }
    }

    private final List<Version> list = new ArrayList<>();
    private final Map<String, Version> byName = new LinkedHashMap<>();

    public void add(String name, int protocol) {
        if (byName.containsKey(name)) {
            throw new SchemaException("Duplicate version " + name);
        }
        if (!list.isEmpty() && list.get(list.size() - 1).protocol() >= protocol) {
            throw new SchemaException("Version " + name + " must have a higher protocol than the version before it");
        }
        Version version = new Version(name, protocol, list.size());
        list.add(version);
        byName.put(name, version);
    }

    public List<Version> list() {
        return Collections.unmodifiableList(list);
    }

    public boolean contains(String name) {
        return byName.containsKey(name);
    }

    public Version get(String name) {
        Version version = byName.get(name);
        if (version == null) {
            throw new SchemaException("Unknown version '" + name + "' (not listed in versions.yml)");
        }
        return version;
    }

    public Version first() {
        return list.get(0);
    }

    public Version latest() {
        return list.get(list.size() - 1);
    }

    public boolean alive(String since, String removed, Version version) {
        if (since != null && version.ordinal() < get(since).ordinal()) {
            return false;
        }
        return removed == null || version.ordinal() < get(removed).ordinal();
    }

    public int endProtocol(String removed) {
        return removed == null ? Integer.MAX_VALUE : get(removed).protocol();
    }
}
