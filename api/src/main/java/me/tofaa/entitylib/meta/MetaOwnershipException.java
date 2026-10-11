package me.tofaa.entitylib.meta;

import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import org.jetbrains.annotations.NotNull;

public class MetaOwnershipException extends IllegalArgumentException {

    private final transient MetaField<?> field;
    private final transient EntityType entityType;

    public MetaOwnershipException(@NotNull MetaField<?> field, @NotNull EntityType entityType) {
        super("Metadata field " + field + " does not belong to entity type " + entityType.getName());
        this.field = field;
        this.entityType = entityType;
    }

    public @NotNull MetaField<?> field() {
        return field;
    }

    public @NotNull EntityType entityType() {
        return entityType;
    }

}
