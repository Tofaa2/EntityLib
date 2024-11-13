package me.tofaa.entitylib.wrapper;


import com.github.retrooper.packetevents.protocol.player.User;
import com.github.retrooper.packetevents.protocol.world.Location;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Generic utility for per player wrapper entities.
 * These spawn in the same spot for everyone.
 */
public class WrapperPerPlayerEntity {

    private final Map<UUID, WrapperEntity> entities = new ConcurrentHashMap<>();
    private Function<User, WrapperEntity> baseSupplier;

    public WrapperPerPlayerEntity(Function<User, WrapperEntity> baseSupplier) {
        this.baseSupplier = baseSupplier;
    }

    public void setBaseSupplier(Function<User, WrapperEntity> baseSupplier) {
        this.baseSupplier = baseSupplier;
    }

    public Function<User, WrapperEntity> getBaseSupplier() {
        return baseSupplier;
    }

    public void spawn(Location location) {
        if (check(WrapperEntity::isSpawned)) {
            return;
        }
        execute(e -> e.spawn(location));
    }

    public void addViewer(User user) {
        getEntityOf(user).addViewer(user);
    }

    public void removeViewer(User user) {
        getEntityOf(user).removeViewer(user);
    }

    public void execute(Consumer<WrapperEntity> consumer) {
        entities.values().forEach(consumer);
    }

    public boolean check(Predicate<WrapperEntity> predicate) {
        if (entities.isEmpty()) return false;
        WrapperEntity  e= entities.values().stream().findFirst().get();
        return predicate.test(e);
    }

    public void modify(User user, Consumer<WrapperEntity> consumer) {
        consumer.accept(getEntityOf(user));
    }

    public WrapperEntity getEntityOf(User user) {
        if (this.entities.containsKey(user.getUUID())) {
            return this.entities.get(user.getUUID());
        }
        else {
            WrapperEntity e = baseSupplier.apply(user);
            this.entities.put(user.getUUID(), e);
            return e;
        }
    }

}
