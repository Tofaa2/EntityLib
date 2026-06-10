package me.tofaa.entitylib.meta.property;

import com.github.retrooper.packetevents.protocol.player.ClientVersion;

import java.util.NavigableMap;

// TODO override the builder instead of manually constructing in base MetadataProperty
public class SimpleProperty<R> extends MetadataProperty<R, R> {

    SimpleProperty(Class<? extends IMetaProperties> metaPropertiesClass, NavigableMap<ClientVersion, ? extends VersionedMapping<R, ?>> versions) {
        super(metaPropertiesClass, versions);
    }

    @Override
    public boolean isWrapper() {
        return false;
    }

}
