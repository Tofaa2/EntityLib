package me.tofaa.entitylib.codegen;

public final class MetaOffset {

    private String name;
    private VersionCheck[] checks;

    public MetaOffset(String name, VersionCheck[] checks) {
        this.name = name;
        this.checks = checks;
    }

    public String name() {
        return name;
    }

    public VersionCheck[] checks() {
        return checks;
    }
}
