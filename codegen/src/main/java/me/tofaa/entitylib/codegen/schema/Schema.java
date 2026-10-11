package me.tofaa.entitylib.codegen.schema;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class Schema {

    private final Versions versions;
    private final Map<String, TypeDef> types;
    private final Map<String, SchemaClass> classes = new LinkedHashMap<>();
    private final Map<String, String> conversions = new LinkedHashMap<>();

    public Schema(Versions versions, Map<String, TypeDef> types) {
        this.versions = versions;
        this.types = types;
    }

    public Versions versions() {
        return versions;
    }

    public Map<String, TypeDef> types() {
        return types;
    }

    public TypeDef type(String name) {
        TypeDef type = types.get(name);
        if (type == null) {
            throw new SchemaException("Unknown type '" + name + "' (not listed in types.yml)");
        }
        return type;
    }

    public TypeDef upstreamType(String upstreamName, Versions.Version version) {
        List<TypeDef> matches = new ArrayList<>();
        for (TypeDef type : types.values()) {
            if (type.upstream().contains(upstreamName) && versions.alive(type.since(), type.removed(), version)) {
                matches.add(type);
            }
        }
        if (matches.size() != 1) {
            throw new SchemaException("Upstream type '" + upstreamName + "' in " + version + " maps to "
                    + (matches.isEmpty() ? "no type" : "several types " + matches.stream().map(TypeDef::name).toList())
                    + "; fix the upstream lists in types.yml");
        }
        return matches.get(0);
    }

    public void addConversion(String valueType, String wireType, String converter) {
        type(valueType);
        type(wireType);
        conversions.put(valueType + "<-" + wireType, converter);
    }

    public String conversion(String valueType, String wireType) {
        return conversions.get(valueType + "<-" + wireType);
    }

    public void add(SchemaClass schemaClass) {
        if (classes.put(schemaClass.name, schemaClass) != null) {
            throw new SchemaException("Duplicate class " + schemaClass.name);
        }
    }

    public Collection<SchemaClass> classes() {
        return classes.values();
    }

    public SchemaClass get(String name) {
        return classes.get(name);
    }

    public boolean alive(SchemaClass schemaClass, Versions.Version version) {
        return versions.alive(schemaClass.since, schemaClass.removed, version);
    }

    public boolean alive(SchemaField field, Versions.Version version) {
        return versions.alive(field.since, field.removed, version);
    }

    public SchemaClass parent(SchemaClass schemaClass, Versions.Version version) {
        for (ParentRef ref : schemaClass.parents) {
            if (versions.alive(ref.since, ref.removed, version)) {
                SchemaClass parent = classes.get(ref.parent);
                if (parent == null) {
                    throw new SchemaException(schemaClass.name + " extends unknown class " + ref.parent);
                }
                return parent;
            }
        }
        return null;
    }
}
