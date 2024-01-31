package me.tofaa.entitylib.common;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.PacketEventsAPI;
import me.tofaa.entitylib.APIConfig;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.EntityLibAPI;
import me.tofaa.entitylib.Platform;
import me.tofaa.entitylib.tick.TickContainer;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public abstract class AbstractEntityLibAPI<P, W, T> implements EntityLibAPI<W, T> {

    protected final Platform<P> platform;
    protected final PacketEventsAPI<?> packetEvents;
    protected final APIConfig settings;
    protected final Collection<TickContainer<?, T>> tickContainers;

    protected AbstractEntityLibAPI(Platform<P> platform, APIConfig settings) {
        this.platform = platform;
        this.packetEvents = settings.getPacketEvents();
        this.settings = settings;
        this.tickContainers = settings.shouldTickTickables() ? new HashSet<>() : Collections.emptyList();
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
