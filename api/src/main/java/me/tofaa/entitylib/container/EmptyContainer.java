package me.tofaa.entitylib.container;

import me.tofaa.entitylib.wrapper.WrapperEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.UUID;

final class EmptyContainer implements EntityContainer {

    static EmptyContainer INSTANCE = new EmptyContainer();

    @Override public void addEntity(WrapperEntity entity) {}
    @Override public void removeEntity(WrapperEntity entity, boolean despawn) {}
    @Override public void removeEntity(int entityId, boolean despawn) {}
    @Override public void removeEntity(UUID uuid, boolean despawn) {}
    @Override public void clearEntities(boolean despawn) {}
    @Override public void tick() {}
    @Override public Collection<WrapperEntity> getEntities() {return Collections.emptyList();}
    @Override
    public @Nullable WrapperEntity getEntity(UUID uuid) {
        return null;
    }
    @Override
    public @Nullable WrapperEntity getEntity(int entityId) {
        return null;
    }
    @Override
    public boolean containsEntity(UUID uuid) {
        return false;
    }

    @Override
    public boolean containsEntity(int entityId) {
        return false;
    }

    @Override
    public boolean containsEntity(WrapperEntity entity) {
        return false;
    }

    @Override
    public @NotNull Iterator<WrapperEntity> iterator() {
        return getEntities().iterator();
    }

}
