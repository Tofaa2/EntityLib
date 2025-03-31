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
    private boolean enabled = false;


    /**
     * Creates an instance of ViewerEngine
     * It is recommended to specify explicitly the Executor that should be used.
     */
    public ViewerEngine() {
        this(Executors.newSingleThreadExecutor());
    }

    /**
     * Creates an instance of ViewerEngine with a specific executor. Depending on your rules one thread might not be enough
     * @param executor The executor that is used to process entity tracking.
     */
    public ViewerEngine(Executor executor) {
        this.globalRules = new CopyOnWriteArrayList<>();
        this.tracked = Collections.newSetFromMap(new WeakHashMap<>());
        this.executor = executor;
        this.listener = new ViewerEngineListener(this);
    }

    /**
     * Enables this viewer engine.
     * Registers a viewer engine listener to handle tracking
     */
    public void enable() {
        if (enabled) {
            return;
        }
        enabled = true;
        EntityLib.getApi().getPacketEvents().getEventManager().registerListener(listener);
    }


    /**
     * Disables this viewer engine.
     * Unregisters the viewer engine listener that handles tracking.
     */
    public void disable() {
        if (!enabled) {
            return;
        }
        enabled = false;
        EntityLib.getApi().getPacketEvents().getEventManager().unregisterListener(listener);
    }

    /**
     * Refreshes and updates every tracked by this viewer engine entities viewers to see if they follow the spawning rules.
     * If they do not they will no longer see the entity;
     */
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

    /**
     * Tells this ViewerEngine to begin tracking a specific {@link WrapperEntity}
     * @param entity the entity to begin tracking.
     */
    public void track(@NotNull WrapperEntity entity) {
        tracked.add(entity);
    }

    /**
     * Tells this ViewerEngine to stop tracking a specific {@link WrapperEntity}
     * @param entity the entity to stop tracking.
     */
    public void untrack(@NotNull WrapperEntity entity) {
        tracked.remove(entity);
    }

    public void clearTracked() {
        tracked.clear();
    }

    /**
     * Checks if a viewer/user validates every viewer rule handled by this viewer engine or not.
     * @param user The user to check
     * @param entity The entity that is getting its own viewer rules checked as well as the global defined one with {@link ViewerEngine#addViewerRule(ViewerRule)}
     * @return true if the user passed and did not fail any rules, false otherwise
     */
    public boolean canSpawnFor(User user, WrapperEntity entity) {
        if (entity.getViewerRules().stream().anyMatch(rule -> rule.shouldSee(user))) return true;
        return globalRules.stream().anyMatch(rule -> rule.shouldSee(user));
    }

    /**
     * Same as {@link ViewerEngine#canSpawnFor(User, WrapperEntity)} but with UUID instead of User
     */
    public boolean canSpawnFor(UUID userId, WrapperEntity entity) {
        User user = EntityLib.getApi().getPacketEvents().getProtocolManager().getUser(
                EntityLib.getApi().getPacketEvents().getProtocolManager().getChannel(userId)
        );
        if (user == null) return false;
        return canSpawnFor(user, entity);
    }

    /**
     * @return An unmodifiable view of the entities that are being tracked.
     */
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
