package me.tofaa.entitylib.codegen;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class EntityNode {

    private final String className;
    private String superClass;
    private final Map<String, PropertyNode> properties = new TreeMap<>();
    private final Set<String> supportedVersions = new TreeSet<>(EntityFieldsCodeGen.VERSION_COMPARATOR);

    public EntityNode(String className) {
        this.className = className;
    }

    public String getClassName() {
        return this.className;
    }

    public String getSuperClass() {
        return this.superClass;
    }

    public void setSuperClass(String superClass) {
        this.superClass = superClass;
    }

    public Map<String, PropertyNode> getProperties() {
        return this.properties;
    }

    public Set<String> getSupportedVersions() {
        return this.supportedVersions;
    }

}
