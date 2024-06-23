package me.tofaa.entitylib.container;

import me.tofaa.entitylib.wrapper.WrapperEntity;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractEntityContainer implements EntityContainer {

    private final Map<UUID, WrapperEntity> entities = new ConcurrentHashMap<>();
    private final Map<Integer, WrapperEntity> entitiesById = new ConcurrentHashMap<>();


    @Override
    public void addEntity(WrapperEntity entity) {
        entities.put(entity.getUuid(), entity);
        entitiesById.put(entity.getEntityId(), entity);
    }

    @Override
    public void removeEntity(WrapperEntity entity, boolean despawn) {
        entities.remove(entity.getUuid());
        entitiesById.remove(entity.getEntityId());
        if (despawn) {
            entity.despawn();
        }
    }

    @Override
    public void removeEntity(int entityId, boolean despawn) {
        WrapperEntity entity = entitiesById.get(entityId);
        if (entity != null) {
            removeEntity(entity, despawn);
        }
    }

    @Override
    public void removeEntity(UUID uuid, boolean despawn) {
        WrapperEntity entity = entities.get(uuid);
        if (entity != null) {
            removeEntity(entity, despawn);
        }
    }

    @Override
    public void clearEntities(boolean despawn) {
        entities.values().forEach(entity -> removeEntity(entity, despawn));
    }


    @Override
    public void tick() {

    }

    public @NotNull Iterator<WrapperEntity> iterator() {
        return entities.values().iterator();
    }

    @Override
    public Collection<WrapperEntity> getEntities() {
        return Collections.unmodifiableCollection(entities.values());
    }

    @Override
    public WrapperEntity getEntity(UUID uuid) {
        return entities.get(uuid);
    }

    @Override
    public WrapperEntity getEntity(int entityId) {
        return entitiesById.get(entityId);
    }

    @Override
    public boolean containsEntity(UUID uuid) {
        return entities.containsKey(uuid);
    }

    @Override
    public boolean containsEntity(int entityId) {
        return entitiesById.containsKey(entityId);
    }

    @Override
    public boolean containsEntity(WrapperEntity entity) {
        return entities.containsValue(entity);
    }
}
