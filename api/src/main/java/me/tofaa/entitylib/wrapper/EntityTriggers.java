package me.tofaa.entitylib.wrapper;

import me.tofaa.entitylib.ve.ViewerRule;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;
import java.util.function.Consumer;

public class EntityTriggers {

    private Consumer<WrapperEntity> onSpawn = e -> {};
    private Consumer<WrapperEntity> onRemove = e -> {};
    private Consumer<UUID> onViewerAdd = u -> {};
    private Consumer<UUID> onViewerRemove = u -> {};

    public void onSpawn(@NotNull Consumer<WrapperEntity> callback) {
        this.onSpawn = callback;
    }

    public void onRemove(@NotNull Consumer<WrapperEntity> callback) {
        this.onRemove = callback;
    }

    public void onViewerAdd(@NotNull Consumer<UUID> callback) {
        this.onViewerAdd = callback;
    }

    public void onViewerRemove(@NotNull Consumer<UUID> callback) {
        this.onViewerRemove = callback;
    }

    void fireSpawn(@NotNull WrapperEntity entity) {
        onSpawn.accept(entity);
    }

    void fireRemove(@NotNull WrapperEntity entity) {
        onRemove.accept(entity);
    }

    void fireViewerAdd(@NotNull UUID viewer) {
        onViewerAdd.accept(viewer);
    }

    void fireViewerRemove(@NotNull UUID viewer) {
        onViewerRemove.accept(viewer);
    }

}
