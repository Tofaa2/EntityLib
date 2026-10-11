package me.tofaa.entitylib.meta;

import org.jetbrains.annotations.NotNull;

public class MetaVersionException extends RuntimeException {

    private final transient MetaField<?> field;
    private final int protocolVersion;

    public MetaVersionException(@NotNull MetaField<?> field, int protocolVersion) {
        super("Metadata field " + field + " does not exist in protocol version " + protocolVersion);
        this.field = field;
        this.protocolVersion = protocolVersion;
    }

    public @NotNull MetaField<?> field() {
        return field;
    }

    public int protocolVersion() {
        return protocolVersion;
    }
}
