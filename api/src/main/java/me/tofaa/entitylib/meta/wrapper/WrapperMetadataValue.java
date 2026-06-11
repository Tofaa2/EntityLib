package me.tofaa.entitylib.meta.wrapper;

import com.github.retrooper.packetevents.protocol.entity.data.EntityData;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.EntityMetadata;
import me.tofaa.entitylib.meta.property.WrapperProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class WrapperMetadataValue<R> {

    private final EntityMetadata store;
    private final WrapperProperty<R, ? extends WrapperMetadataValue<R>> property;

    protected WrapperMetadataValue(@NotNull EntityMetadata store, @NotNull WrapperProperty<R, ? extends WrapperMetadataValue<R>> property) {
        this.store = store;
        this.property = property;
    }

    public final @NotNull R getRaw() {
        R value = this.store.getRawValue(this.property);
        return value != null ? value : defaultRaw();
    }

    public final void setRaw(@NotNull R raw) {
        this.store.setRawValue(this.property, raw);
    }

    public @Nullable EntityData<?> toEntityData(@NotNull ClientVersion version) {
        return this.property.createData(version, getRaw());
    }

    protected abstract @NotNull R defaultRaw();

    protected final @NotNull EntityMetadata store() {
        return this.store;
    }

    protected final @NotNull WrapperProperty<R, ? extends WrapperMetadataValue<R>> property() {
        return this.property;
    }

}
