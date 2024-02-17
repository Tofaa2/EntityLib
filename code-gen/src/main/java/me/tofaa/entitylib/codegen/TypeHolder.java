package me.tofaa.entitylib.codegen;

public final class TypeHolder {

    private String className;
    private MetaOffset[] offsets;

    public TypeHolder(String className, MetaOffset[] offsets) {
        this.className = className;
        this.offsets = offsets;
    }


    public String className() {
        return className;
    }

    public MetaOffset[] offsets() {
        return offsets;
    }
}
