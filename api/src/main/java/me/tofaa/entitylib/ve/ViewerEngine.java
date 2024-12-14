package me.tofaa.entitylib.ve;


import com.github.retrooper.packetevents.protocol.player.User;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnmodifiableView;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * A basic viewer manipulation engine.
 * Allows for a set of rules to be applied as to show and hide an entity from viewers.
 */
@ApiStatus.Experimental
public class ViewerEngine {

    private final List<ViewerRule> globalRules;
    private final Set<WrapperEntity> tracked;
    private final ViewerEngineListener listener;
    private Executor executor;

    public ViewerEngine() {
        this.globalRules = new CopyOnWriteArrayList<>();
        this.tracked = Collections.newSetFromMap(new WeakHashMap<>());
        this.executor = Executors.newSingleThreadExecutor();
        this.listener = new ViewerEngineListener(this);
    }

    public void enable() {
        EntityLib.getApi().getPacketEvents().getEventManager().registerListener(listener);
    }
    public void disable() {
        EntityLib.getApi().getPacketEvents().getEventManager().unregisterListener(listener);
    }

    public void refresh() {
        getTracked0().forEach(entity -> {
            for (UUID viewer : entity.getViewers()) {
                if (!canSpawnFor(viewer, entity)) {
                    entity.removeViewer(viewer); 
                }
            }
        });
    }

    public Executor getExecutor() {
        return executor;
    }

    public void setExecutor(Executor executor) {
        this.executor = executor;
    }

    public void track(@NotNull WrapperEntity entity) {
        tracked.add(entity);
    }

    public void clearTracked() {
        tracked.clear();
    }

    public boolean canSpawnFor(User user, WrapperEntity entity) {
        if (entity.getViewerRules().stream().anyMatch(rule -> rule.shouldSee(user))) return true;
        return globalRules.stream().anyMatch(rule -> rule.shouldSee(user));
    }

    public boolean canSpawnFor(UUID userId, WrapperEntity entity) {
        User user = EntityLib.getApi().getPacketEvents().getProtocolManager().getUser(
                EntityLib.getApi().getPacketEvents().getProtocolManager().getChannel(userId)
        );
        if (user == null) return false;
        return canSpawnFor(user, entity);
    }

    public @UnmodifiableView Collection<WrapperEntity> getTracked() {
        return Collections.unmodifiableCollection(tracked);
    }

    Set<WrapperEntity> getTracked0() {
        return tracked;
    }

    public void addViewerRule(@NotNull ViewerRule rule) {
        this.globalRules.add(rule);
    }

    public void removeViewerRule(@NotNull ViewerRule rule) {
        this.globalRules.remove(rule);
    }

    public void removeViewerRule(int index) {
        this.globalRules.remove(index);
    }

    public void clearViewerRules() {
        this.globalRules.clear();
    }

    public @UnmodifiableView Collection<ViewerRule> getViewerRules() {
        return Collections.unmodifiableCollection(globalRules);
    }

    public @Nullable ViewerRule getViewerRule(int index) {
        if (this.globalRules.size() >= index - 1) return null;
        if (index < 0) return null;
        return globalRules.get(index);
    }

}
