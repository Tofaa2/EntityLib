package me.tofaa.entitylib.common;

import com.github.retrooper.packetevents.PacketEventsAPI;
import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.protocol.player.UserProfile;
import com.github.retrooper.packetevents.protocol.world.Location;
import me.tofaa.entitylib.APIConfig;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.EntityLibAPI;
import me.tofaa.entitylib.Platform;
import me.tofaa.entitylib.container.EntityContainer;
import me.tofaa.entitylib.meta.EntityMeta;
import me.tofaa.entitylib.meta.projectile.ThrownExpBottleMeta;
import me.tofaa.entitylib.meta.types.LivingEntityMeta;
import me.tofaa.entitylib.tick.TickContainer;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import me.tofaa.entitylib.wrapper.WrapperExperienceOrbEntity;
import me.tofaa.entitylib.wrapper.WrapperLivingEntity;
import me.tofaa.entitylib.wrapper.WrapperPlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractEntityLibAPI<P, T> implements EntityLibAPI<T> {

    protected final Platform<P> platform;
    protected final PacketEventsAPI<?> packetEvents;
    protected final APIConfig settings;
    protected final Collection<TickContainer<?, T>> tickContainers;
    protected final Map<Integer, WrapperEntity> globalEntityMap = new ConcurrentHashMap<>();
    protected final Map<Integer, WrapperEntity> entitiesById = new ConcurrentHashMap<>();
    protected final Map<UUID, WrapperEntity> entities = new ConcurrentHashMap<>();

    protected final Set<EntityContainer> entityContainers = ConcurrentHashMap.newKeySet();
    protected final EntityContainer defaultEntityContainer = EntityContainer.basic();

    protected AbstractEntityLibAPI(Platform<P> platform, APIConfig settings) {
        this.platform = platform;
        this.packetEvents = settings.getPacketEvents();
        this.settings = settings;
        this.tickContainers = settings.shouldTickTickables() ? new HashSet<>() : Collections.emptyList();
    }

    @Override
    public @Nullable WrapperEntity getEntity(int id) {
        return entitiesById.get(id);
    }

    @Override
    public @Nullable WrapperEntity getEntity(@NotNull UUID uuid) {
        return entities.get(uuid);
    }

    @Override
    public @NotNull Collection<WrapperEntity> getAllEntities() {
        return Collections.unmodifiableCollection(entities.values());
    }

    @Override
    public void addContainer(EntityContainer container) {
        entityContainers.add(container);
    }

    @Override
    public void removeContainer(EntityContainer container) {
        entityContainers.remove(container);
    }

    @Override
    public @NotNull EntityContainer getDefaultContainer() {
        return defaultEntityContainer;
    }

    @NotNull
    @Override
    public Set<EntityContainer> getEntityContainers() {
        return entityContainers;
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
