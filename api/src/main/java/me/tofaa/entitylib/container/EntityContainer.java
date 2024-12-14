package me.tofaa.entitylib.container;

import me.tofaa.entitylib.wrapper.WrapperEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;


/**
 * Containers are basic iterable classes that hold entities. These containers can be extended to provide more functionality, and this allows for seperation of logic between certain entities.
 * <p>
 *     To access a specific {@link WrapperEntity}'s container you can use {@link WrapperEntity#getParentContainer()}.
 * </p>
 */
public interface EntityContainer extends Iterable<WrapperEntity> {

    static EntityContainer basic() {
        return new ContainerImpl();
    }

    static EntityContainer empty() {
        return EmptyContainer.INSTANCE;
    }


    void addEntity(WrapperEntity entity);

    void removeEntity(WrapperEntity entity, boolean despawn);

    default void removeEntity(WrapperEntity entity) {
        removeEntity(entity, false);
    }

    void removeEntity(int entityId, boolean despawn);

    default void removeEntity(int entityId) {
        removeEntity(entityId, false);
    }

    void removeEntity(UUID uuid, boolean despawn);

    default void removeEntity(UUID entity) {
        removeEntity(entity, false);
    }

    void clearEntities(boolean despawn);

    default void clearEntities() {
        clearEntities(false);
    }

    void tick();

    Collection<WrapperEntity> getEntities();

    @Nullable WrapperEntity getEntity(UUID uuid);

    @Nullable WrapperEntity getEntity(int entityId);

    boolean containsEntity(UUID uuid);

    boolean containsEntity(int entityId);

    /** Value based contains, not reference based */
    boolean containsEntity(WrapperEntity entity);

}
