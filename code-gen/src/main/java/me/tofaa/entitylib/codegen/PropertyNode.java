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
        return this.name;
    }

    public TypeMapping getTypeMapping() {
        return this.typeMapping;
    }

    public void setTypeMapping(TypeMapping typeMapping) {
        this.typeMapping = typeMapping;
    }

    public Map<String, FieldData> getVersions() {
        return this.versions;
    }

}
