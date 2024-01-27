package me.tofaa.entitylib.wrapper.ai;


import java.util.ArrayList;
import java.util.Collection;
import java.util.function.UnaryOperator;

final class GoalSelectorList extends ArrayList<GoalSelector> {

    final AIGroup aiGroup;

    GoalSelectorList(AIGroup aiGroup) {
        this.aiGroup = aiGroup;
    }

    @Override
    public GoalSelector set(int index, GoalSelector element) {
        element.setAIGroup(aiGroup);
        return super.set(index, element);
    }

    @Override
    public boolean add(GoalSelector element) {
        element.setAIGroup(aiGroup);
        return super.add(element);
    }

    @Override
    public void add(int index, GoalSelector element) {
        element.setAIGroup(aiGroup);
        super.add(index, element);
    }

    @Override
    public boolean addAll(Collection<? extends GoalSelector> c) {
        c.forEach(goalSelector -> goalSelector.setAIGroup(aiGroup));
        return super.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends GoalSelector> c) {
        c.forEach(goalSelector -> goalSelector.setAIGroup(aiGroup));
        return super.addAll(index, c);
    }

    @Override
    public void replaceAll(UnaryOperator<GoalSelector> operator) {
        super.replaceAll(goalSelector -> {
            goalSelector = operator.apply(goalSelector);
            goalSelector.setAIGroup(aiGroup);
            return goalSelector;
        });
    }

}