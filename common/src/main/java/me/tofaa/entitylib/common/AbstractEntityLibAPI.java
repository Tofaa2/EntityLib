package me.tofaa.entitylib.common;

import com.github.retrooper.packetevents.PacketEventsAPI;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import me.tofaa.entitylib.APIConfig;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.EntityLibAPI;
import me.tofaa.entitylib.Platform;
import me.tofaa.entitylib.container.EntityContainer;
import me.tofaa.entitylib.tick.TickContainer;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.UUID;
import java.util.function.BiConsumer;


public abstract class AbstractEntityLibAPI<P, T> implements EntityLibAPI<T> {
    protected final Platform<P> platform;
    protected final PacketEventsAPI<?> packetEvents;
    protected final APIConfig settings;
    protected final Collection<TickContainer<?, T>> tickContainers;
    protected final EntityContainer defaultEntityContainer = EntityContainer.basic();
    protected final BiConsumer<UUID, PacketWrapper<?>> packetDispatcher;

    protected AbstractEntityLibAPI(Platform<P> platform, APIConfig settings) {
        this.platform = platform;
        this.packetEvents = settings.getPacketEvents();
        this.settings = settings;
        this.tickContainers = settings.shouldTickTickables() ? new HashSet<>() : Collections.emptyList();
        this.packetDispatcher = (user, wrapper) -> {
            Object channel = EntityLib.getApi().getPacketEvents().getProtocolManager().getChannel(user);
            if (channel == null) {
                if (EntityLib.getApi().getSettings().isDebugMode()) {
                    EntityLib.getPlatform().getLogger().warning("Failed to send packet to " + user + " because the channel was null. They may be disconnected/not online.");
                }

                return;
            }

            EntityLib.getApi().getPacketEvents().getProtocolManager().sendPacket(channel, wrapper);
        };
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

    @Override
    public @NotNull APIConfig getSettings() {
        return settings;
    }

    @Override
    public PacketEventsAPI<?> getPacketEvents() {
        return packetEvents;
    }

    @Override
    public @NotNull BiConsumer<UUID, PacketWrapper<?>> getPacketDispatcher() {
        return packetDispatcher;
    }

    @Override
    public @NotNull Collection<TickContainer<?, T>> getTickContainers() {
        return tickContainers;
    }
}
