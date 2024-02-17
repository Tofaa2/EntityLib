package me.tofaa.entitylib.wrapper.ai;

import me.tofaa.entitylib.wrapper.WrapperEntityCreature;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.ref.WeakReference;

/**
 * Goals represent tasks that a {@link me.tofaa.entitylib.wrapper.WrapperEntityCreature} can perform.
 */
public abstract class GoalSelector {

    private WeakReference<AIGroup> aiGroupRef;
    protected WrapperEntityCreature entity;

    public GoalSelector(WrapperEntityCreature entity) {
        this.entity = entity;
    }

    /**
     * Whether this {@link GoalSelector} should start.
     *
     * @return true to start
     */
    public abstract boolean shouldStart();

    /**
     * Starts this {@link GoalSelector}.
     */
    public abstract void start();

    /**
     * Called every tick when this {@link GoalSelector} is running.
     *
     * @param time the time of the update in milliseconds
     */
    public abstract void tick(long time);

    /**
     * Whether this {@link GoalSelector} should end.
     *
     * @return true to end
     */
    public abstract boolean shouldEnd();

    /**
     * Ends this {@link GoalSelector}.
     */
    public abstract void end();


    /**
     * Gets the entity behind the goal selector.
     *
     * @return the entity
     */
    @NotNull
    public WrapperEntityCreature getEntityCreature() {
        return entity;
    }

    /**
     * Changes the entity affected by the goal selector.
     * <p>
     * WARNING: this does not add the goal selector to {@code entityCreature},
     * this only change the internal entity AI group's field. Be sure to remove the goal from
     * the previous entity AI group and add it to the new one using {@link AIGroup#getGoalSelectors()}.
     *
     * @param entity the new affected entity
     */
    public void setEntityCreature(@NotNull WrapperEntityCreature entity) {
        this.entity = entity;
    }

    void setAIGroup(@NotNull AIGroup group) {
        this.aiGroupRef = new WeakReference<>(group);
    }

    @Nullable
    protected AIGroup getAIGroup() {
        return this.aiGroupRef.get();
    }

}
