package me.tofaa.entitylib.codegen.schema;

import java.util.ArrayList;
import java.util.List;

public final class SchemaField {

    public String name;
    public String type;
    public String since;
    public String removed;
    public Integer index;
    public String convert;
    public List<SchemaFlag> flags = new ArrayList<>();

    @Override
    public String toString() {
        return name + ":" + type;
    }
}
