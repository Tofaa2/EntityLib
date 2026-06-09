package me.tofaa.entitylib.codegen;

import java.util.Map;
import java.util.TreeMap;

public class PropertyNode {

    private final String name;
    private final Map<String, FieldData> versions = new TreeMap<>(EntityFieldsCodeGen.VERSION_COMPARATOR);
    private TypeMapping typeMapping;

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

    public boolean hasTypeChanges() {
        if (this.versions.size() < 2) return false;
        String canonical = null;
        for (FieldData fd : this.versions.values()) {
            if (canonical == null) {
                canonical = fd.rawDataType();
            } else if (!canonical.equals(fd.rawDataType())) {
                return true;
            }
        }
        return false;
    }

}
