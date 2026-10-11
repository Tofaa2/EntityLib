package me.tofaa.entitylib.codegen.schema;

public final class SchemaFlag {

    public String name;
    public int mask;
    public String since;
    public String removed;

    public SchemaFlag copy() {
        SchemaFlag copy = new SchemaFlag();
        copy.name = name;
        copy.mask = mask;
        copy.since = since;
        copy.removed = removed;
        return copy;
    }
}
