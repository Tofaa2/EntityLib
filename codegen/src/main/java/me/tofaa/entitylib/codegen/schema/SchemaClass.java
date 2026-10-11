package me.tofaa.entitylib.codegen.schema;

import java.util.ArrayList;
import java.util.List;

public final class SchemaClass {

    public String name;
    public String since;
    public String removed;
    public List<ParentRef> parents = new ArrayList<>();
    public List<String> entities = new ArrayList<>();
    public List<SchemaField> fields = new ArrayList<>();

    @Override
    public String toString() {
        return name;
    }
}
