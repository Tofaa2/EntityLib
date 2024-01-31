package me.tofaa.entitylib.common;

import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.protocol.world.Dimension;
import com.github.retrooper.packetevents.protocol.world.Location;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.WorldWrapper;
import me.tofaa.entitylib.meta.EntityMeta;
import me.tofaa.entitylib.meta.types.LivingEntityMeta;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import me.tofaa.entitylib.wrapper.WrapperLivingEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractWorldWrapper<W> implements WorldWrapper<W> {

    private final Map<UUID, WrapperEntity> entities;
    private final Map<Integer, WrapperEntity> entitiesById;
    private final Dimension dimension;
    private final UUID worldId;
    private final W handle;

    public AbstractWorldWrapper(UUID worldId, W handle, Dimension dimension) {
        this.worldId = worldId;
        this.handle = handle;
        this.dimension = dimension;
        this.entities = new ConcurrentHashMap<>();
        this.entitiesById = Collections.emptyMap();
    }


    @Override
    public <T extends WrapperEntity> @NotNull T spawnEntity(@NotNull T entity, @NotNull Location location) {
        entity.spawn(this, location);
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
    public <T extends WrapperEntity> @NotNull T spawnEntity(Class<T> wrapperClass, @NotNull EntityType entityType, @NotNull Location location) {
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
        else {
            e = new WrapperEntity(entityId, uuid, entityType, meta);
        }
        return spawnEntity(wrapperClass.cast(e), location);
    }

    @Override
    public @NotNull WrapperEntity spawnEntity(@NotNull EntityType entityType, @NotNull Location location) {
        return spawnEntity(WrapperEntity.class, entityType, location);
    }

    @Override @Nullable
    public WrapperEntity getEntity(@NotNull UUID uuid) {
        return entities.get(uuid);
    }

    @Override @Nullable
    public WrapperEntity getEntity(int id) {
        return entitiesById.get(id);
    }

    @Override @NotNull
    public Collection<WrapperEntity> getEntities() {
        return Collections.unmodifiableCollection(entities.values());
    }

    @NotNull @Override
    public Dimension getDimension() {
        return dimension;
    }

    @Override @NotNull
    public UUID getUuid() {
        return worldId;
    }

    @NotNull @Override
    public W getHandle() {
        return handle;
    }
}
