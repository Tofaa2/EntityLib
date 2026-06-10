package me.tofaa.entitylib.meta.property;

import me.tofaa.entitylib.meta.EntityMetadata;
import me.tofaa.entitylib.meta.wrapper.WrapperMetadataValue;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import java.util.NavigableMap;
import java.util.function.Function;

// TODO override the builder instead of manually constructing in base MetadataProperty
public final class WrapperProperty<R, W extends WrapperMetadataValue<R>> extends MetadataProperty<R, W> {

    private final Function<EntityMetadata, W> wrapperFactory;

    WrapperProperty(Class<? extends IMetaProperties> metaPropertiesClass, NavigableMap<ClientVersion, ? extends VersionedMapping<R, ?>> versions, Function<EntityMetadata, W> wrapperProperty) {
        super(metaPropertiesClass, versions);
        this.wrapperFactory = wrapperProperty;
    }

    @Override
    public boolean isWrapper() {
        return true;
    }

    public W createWrapper(EntityMetadata store) {
        if (this.wrapperFactory == null) {
            throw new UnsupportedOperationException("This property does not have a wrapper factory.");
        }
        return this.wrapperFactory.apply(store);
    }

}
