package me.tofaa.entitylib.ve;

import com.github.retrooper.packetevents.protocol.player.User;
import com.github.retrooper.packetevents.protocol.world.Location;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.extras.collections.WeakLinkedHashSet;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnmodifiableView;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@ApiStatus.Experimental
public class ViewerEngine {
    private final List<ViewerRule> globalRules;
    private final Set<WrapperEntity> tracked;
    private final ViewerEngineListener listener;
    private volatile Executor executor;
    private volatile boolean enabled = false;

    public ViewerEngine() {
        this(Executors.newSingleThreadExecutor());
    }

    public ViewerEngine(Executor executor) {
        this.globalRules = new CopyOnWriteArrayList<>();
        this.tracked = new WeakLinkedHashSet<>();
        this.executor = executor;
        this.listener = new ViewerEngineListener(this);
    }

    public void enable() {
        if (enabled) {
            return;
        }
        enabled = true;
        EntityLib.get().getConfig().getPacketEvents().getEventManager().registerListener(listener);
    }

    public void disable() {
        if (!enabled) {
            return;
        }
        enabled = false;
        EntityLib.get().getConfig().getPacketEvents().getEventManager().unregisterListener(listener);
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
        synchronized (tracked) {
            tracked.add(entity);
        }
    }

    public void untrack(@NotNull WrapperEntity entity) {
        synchronized (tracked) {
            tracked.remove(entity);
        }
    }

    public void clearTracked() {
        synchronized (tracked) {
            tracked.clear();
        }
    }

    public boolean canSpawnFor(User user, WrapperEntity entity) {
        String world = entity.getWorld();
        if (world != null && user.getUUID() != null) {
            String userWorld = EntityLib.get().getPlatform().getWorld(user.getUUID());
            if (userWorld != null && !world.equals(userWorld)) {
                return false;
            }
        }
        for (ViewerRule rule : entity.getViewerRules()) {
            if (!rule.shouldSee(user)) {
                return false;
            }
        }

        for (ViewerRule rule : this.globalRules) {
            if (!rule.shouldSee(user)) {
                return false;
            }
        }

        return true;
    }

    public boolean canSpawnFor(UUID userId, WrapperEntity entity) {
        User user = EntityLib.get().getConfig().getPacketEvents().getProtocolManager().getUser(
                EntityLib.get().getConfig().getPacketEvents().getProtocolManager().getChannel(userId)
        );
        if (user == null) return false;
        return canSpawnFor(user, entity);
    }

    public @UnmodifiableView Collection<WrapperEntity> getTracked() {
        return Collections.unmodifiableCollection(getTracked0());
    }

    List<WrapperEntity> getTracked0() {
        synchronized (tracked) {
            return new ArrayList<>(tracked);
        }
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
        if (index < 0 || index >= this.globalRules.size()) return null;
        return globalRules.get(index);
    }

}
