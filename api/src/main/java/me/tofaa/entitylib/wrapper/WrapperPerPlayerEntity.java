package me.tofaa.entitylib.wrapper;

import com.github.retrooper.packetevents.protocol.world.Location;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class WrapperPerPlayerEntity {

    private final Map<UUID, WrapperEntity> entities = new ConcurrentHashMap<>();
    private Function<UUID, WrapperEntity> entitySupplier;

    public WrapperPerPlayerEntity(@NotNull Function<UUID, WrapperEntity> entitySupplier) {
        this.entitySupplier = entitySupplier;
    }

    public void setEntitySupplier(@NotNull Function<UUID, WrapperEntity> entitySupplier) {
        this.entitySupplier = entitySupplier;
    }

    public @NotNull Function<UUID, WrapperEntity> getEntitySupplier() {
        return entitySupplier;
    }

    public void spawn(@NotNull Location location) {
        if (check(WrapperEntity::isSpawned)) return;
        execute(e -> e.spawn(location));
    }

    public @NotNull Map<UUID, WrapperEntity> getEntities() {
        return entities;
    }

    public void addViewer(@NotNull UUID user) {
        getEntityOf(user).addViewer(user);
    }

    public void removeViewer(@NotNull UUID user) {
        getEntityOf(user).removeViewer(user);
    }

    public void execute(@NotNull Consumer<WrapperEntity> consumer) {
        entities.values().forEach(consumer);
    }

    public boolean check(@NotNull Predicate<WrapperEntity> predicate) {
        if (entities.isEmpty()) return false;
        return predicate.test(entities.values().iterator().next());
    }

    public void modify(@NotNull UUID user, @NotNull Consumer<WrapperEntity> consumer) {
        consumer.accept(getEntityOf(user));
    }

    public @NotNull WrapperEntity getEntityOf(@NotNull UUID user) {
        return entities.computeIfAbsent(user, u -> entitySupplier.apply(u));
    }

}
