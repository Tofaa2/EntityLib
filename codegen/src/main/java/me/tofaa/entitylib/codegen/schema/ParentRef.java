package me.tofaa.entitylib.codegen.schema;

public final class ParentRef {

    public String parent;
    public String since;
    public String removed;

    public ParentRef(String parent, String since, String removed) {
        this.parent = parent;
        this.since = since;
        this.removed = removed;
    }
}
