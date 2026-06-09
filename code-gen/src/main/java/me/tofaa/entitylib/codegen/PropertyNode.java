package me.tofaa.entitylib.codegen;

import java.util.Map;
import java.util.TreeMap;

public class PropertyNode {

    private final String name;
    private TypeMapping typeMapping;
    private final Map<String, FieldData> versions = new TreeMap<>(EntityFieldsCodeGen.VERSION_COMPARATOR);

    public PropertyNode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public TypeMapping getTypeMapping() {
        return typeMapping;
    }

    public void setTypeMapping(TypeMapping typeMapping) {
        this.typeMapping = typeMapping;
    }

    public Map<String, FieldData> getVersions() {
        return versions;
    }

}
