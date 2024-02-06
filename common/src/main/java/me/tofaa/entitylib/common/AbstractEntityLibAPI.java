package me.tofaa.entitylib.common;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.PacketEventsAPI;
import me.tofaa.entitylib.APIConfig;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.EntityLibAPI;
import me.tofaa.entitylib.Platform;
import me.tofaa.entitylib.tick.TickContainer;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractEntityLibAPI<P, W, T> implements EntityLibAPI<W, T> {

    protected final Platform<P> platform;
    protected final PacketEventsAPI<?> packetEvents;
    protected final APIConfig settings;
    protected final Collection<TickContainer<?, T>> tickContainers;
    protected final Map<Integer, WrapperEntity> globalEntityMap = new ConcurrentHashMap<>();

    protected AbstractEntityLibAPI(Platform<P> platform, APIConfig settings) {
        this.platform = platform;
        this.packetEvents = settings.getPacketEvents();
        this.settings = settings;
        this.tickContainers = settings.shouldTickTickables() ? new HashSet<>() : Collections.emptyList();
    }

    @Override
    public @Nullable WrapperEntity findEntity(int entityId) {
        return globalEntityMap.get(entityId);
    }

    @Override
    public void globalRegisterEntity(WrapperEntity entity) {
        if (globalEntityMap.containsKey(entity.getEntityId())) throw new IllegalArgumentException("Entity with that Id is already registered and present");
        globalEntityMap.put(entity.getEntityId(), entity);
    }

    @Override
    public void globalUnregisterEntity(@NotNull WrapperEntity entity) {
        globalEntityMap.remove(entity.getEntityId());
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
