package me.tofaa.entitylib.entity.ai;

import me.tofaa.entitylib.Tickable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;

public class AIGroup implements Tickable {

    private final List<GoalSelector> goalSelectors = new GoalSelectorList(this);
    private GoalSelector currentGoalSelector;

    public @NotNull Collection<GoalSelector> getGoalSelectors() {
        return goalSelectors;
    }

    public @Nullable GoalSelector getCurrentGoal() {
        return currentGoalSelector;
    }

    /**
     * Adds a goal selector to the end of the list. Might be potentially unsafe to use after the entity has been spawned.
     *
     * @param goalSelector the goal selector to add
     */
    public void addGoalSelector(@NotNull GoalSelector goalSelector) {
        this.goalSelectors.add(goalSelector);
    }

    public void setCurrentGoal(@Nullable GoalSelector goalSelector) {
        if (goalSelector != null && goalSelector.getAIGroup() != this) {
            throw new IllegalArgumentException("GoalSelector is not in this AIGroup");
        }
        currentGoalSelector = goalSelector;
    }

    @Override
    public void update(long time) {
        GoalSelector currentGoalSelector = getCurrentGoal();

        if (currentGoalSelector != null && currentGoalSelector.shouldEnd()) {
            currentGoalSelector.end();
            currentGoalSelector = null;
            setCurrentGoal(null);
        }

        for (GoalSelector selector : getGoalSelectors()) {
            if (selector == currentGoalSelector) {
                break;
            }
            if (selector.shouldStart()) {
                if (currentGoalSelector != null) {
                    currentGoalSelector.end();
                }
                currentGoalSelector = selector;
                setCurrentGoal(currentGoalSelector);
                currentGoalSelector.start();
                break;
            }
        }

        if (currentGoalSelector != null) {
            currentGoalSelector.tick(time);
        }
    }

}
