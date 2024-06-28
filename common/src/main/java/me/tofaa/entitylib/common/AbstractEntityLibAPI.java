package me.tofaa.entitylib.common;

import com.github.retrooper.packetevents.PacketEventsAPI;
import me.tofaa.entitylib.APIConfig;
import me.tofaa.entitylib.EntityLibAPI;
import me.tofaa.entitylib.Platform;
import me.tofaa.entitylib.container.EntityContainer;
import me.tofaa.entitylib.tick.TickContainer;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;


public abstract class AbstractEntityLibAPI<P, T> implements EntityLibAPI<T> {

    protected final Platform<P> platform;
    protected final PacketEventsAPI<?> packetEvents;
    protected final APIConfig settings;
    protected final Collection<TickContainer<?, T>> tickContainers;
    protected final EntityContainer defaultEntityContainer = EntityContainer.basic();

    protected AbstractEntityLibAPI(Platform<P> platform, APIConfig settings) {
        this.platform = platform;
        this.packetEvents = settings.getPacketEvents();
        this.settings = settings;
        this.tickContainers = settings.shouldTickTickables() ? new HashSet<>() : Collections.emptyList();
    }

    @Override
    public @Nullable WrapperEntity getEntity(int id) {
        return defaultEntityContainer.getEntity(id);
    }

    @Override
    public @Nullable WrapperEntity getEntity(@NotNull UUID uuid) {
        return defaultEntityContainer.getEntity(uuid);

    }

    @Override
    public @NotNull Collection<WrapperEntity> getAllEntities() {
        return defaultEntityContainer.getEntities();
    }

    @Override
    public @NotNull EntityContainer getDefaultContainer() {
        return defaultEntityContainer;
    }

    @NotNull
    @Override
    public APIConfig getSettings() {
        return settings;
    }

    @Override
    public PacketEventsAPI<?> getPacketEvents() {
        return packetEvents;
    }

    @NotNull
    @Override
    public Collection<TickContainer<?, T>> getTickContainers() {
        return tickContainers;
    }
}
