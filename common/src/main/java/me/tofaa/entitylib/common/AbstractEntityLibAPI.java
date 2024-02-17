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

    protected AbstractEntityLibAPI(Platform<P> platform, APIConfig settings) {
        this.platform = platform;
        this.packetEvents = settings.getPacketEvents();
        this.settings = settings;
        this.tickContainers = settings.shouldTickTickables() ? new HashSet<>() : Collections.emptyList();
    }


    @Override
    public @NotNull WrapperPlayer spawnPlayer(UserProfile profile, Location location) {
        if (getEntity(profile.getUUID()) != null) {
            throw new IllegalArgumentException("Entity with UUID " + profile.getUUID() + " already exists in this world.");
        }

        int id = EntityLib.getPlatform().getEntityIdProvider().provide(profile.getUUID(), EntityTypes.PLAYER);
        while (entitiesById.containsKey(id)) {
            id = EntityLib.getPlatform().getEntityIdProvider().provide(profile.getUUID(), EntityTypes.PLAYER);
        }
        WrapperPlayer player = new WrapperPlayer(profile, id);
        player.spawn(location);
        entities.put(player.getUuid(), player);
        entitiesById.put(player.getEntityId(), player);
        return player;
    }

    @Override
    public <T1 extends WrapperEntity> @NotNull T1 spawnEntity(@NotNull T1 entity, @NotNull Location location) {
        entity.spawn(location);
        entities.put(entity.getUuid(), entity);
        entitiesById.put(entity.getEntityId(), entity);
        return entity;
    }

    @Override
    public void removeEntity(WrapperEntity entity) {
        entity.despawn();
        this.entities.remove(entity.getUuid());
        this.entitiesById.remove(entity.getEntityId());
    }

    @Override
    public <T1 extends WrapperEntity> @NotNull T1 spawnEntity(@NotNull Class<T1> wrapperClass, @NotNull EntityType entityType, @NotNull Location location) {
        UUID uuid = EntityLib.getPlatform().getEntityUuidProvider().provide(entityType);
        while (entities.containsKey(uuid)) {
            uuid = EntityLib.getPlatform().getEntityUuidProvider().provide(entityType);
        }
        int entityId = EntityLib.getPlatform().getEntityIdProvider().provide(uuid, entityType);
        while (entitiesById.containsKey(entityId)) {
            entityId = EntityLib.getPlatform().getEntityIdProvider().provide(uuid, entityType);
        }
        EntityMeta meta = EntityMeta.createMeta(entityId, entityType);
        WrapperEntity e;
        if (meta instanceof LivingEntityMeta) {
            e = new WrapperLivingEntity(entityId, uuid, entityType, meta);
        }
        else if (meta instanceof ThrownExpBottleMeta) {
            e = new WrapperExperienceOrbEntity(entityId, uuid, entityType, meta);
        }
        else {
            e = new WrapperEntity(entityId, uuid, entityType, meta);
        }
        return spawnEntity(wrapperClass.cast(e), location);
    }

    @Override
    public @NotNull WrapperEntity spawnEntity(@NotNull EntityType entityType, @NotNull Location location) {
        return spawnEntity(WrapperEntity.class, entityType, location);
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
