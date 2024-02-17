package me.tofaa.entitylib.common;

import me.tofaa.entitylib.APIConfig;
import me.tofaa.entitylib.EntityIdProvider;
import me.tofaa.entitylib.EntityUuidProvider;
import me.tofaa.entitylib.Platform;
import me.tofaa.entitylib.event.EventBus;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Logger;

public abstract class AbstractPlatform<P> implements Platform<P> {


    protected final P handle;
    protected Logger logger;
    private EventBus eventBus;
    private EntityIdProvider entityIdProvider;
    private EntityUuidProvider entityUuidProvider;

    public AbstractPlatform(P handle) {
        this.handle = handle;
        this.entityIdProvider = new EntityIdProvider.DefaultEntityIdProvider();
        this.entityUuidProvider = new EntityUuidProvider.DefaultEntityUuidProvider();
    }


    @Override
    public void setupApi(@NotNull APIConfig settings) {
        this.eventBus = EventBus.newBus(settings.shouldUseAsyncEvents());
        this.entityIdProvider = new EntityIdProvider.DefaultEntityIdProvider();
        this.entityUuidProvider = new EntityUuidProvider.DefaultEntityUuidProvider();


    }

    @NotNull
    @Override
    public Logger getLogger() {
        return logger;
    }

    @NotNull
    @Override
    public EntityIdProvider getEntityIdProvider() {
        return entityIdProvider;
    }

    @NotNull
    @Override
    public EntityUuidProvider getEntityUuidProvider() {
        return entityUuidProvider;
    }

    @Override
    public void setEntityIdProvider(EntityIdProvider entityIdProvider) {
        this.entityIdProvider = entityIdProvider;
    }

    @Override
    public void setEntityUuidProvider(EntityUuidProvider entityUuidProvider) {
        this.entityUuidProvider = entityUuidProvider;
    }

    @NotNull
    @Override
    public EventBus getEventBus() {
        return eventBus;
    }

    @NotNull
    @Override
    public P getHandle() {
        return handle;
    }
}
