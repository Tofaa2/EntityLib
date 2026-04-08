package me.tofaa.entitylib.movement;

import org.jetbrains.annotations.NotNull;

public class PathfindSettingsImpl implements MovementEngine.PathfindSettings {
    private final int maxSearchNodes;
    private final double distanceCutoff;
    private final boolean allowingJump;
    private final boolean allowingSwimming;
    private final double searchRange;

    private PathfindSettingsImpl(int maxSearchNodes, double distanceCutoff, boolean allowingJump, boolean allowingSwimming, double searchRange) {
        this.maxSearchNodes = maxSearchNodes;
        this.distanceCutoff = distanceCutoff;
        this.allowingJump = allowingJump;
        this.allowingSwimming = allowingSwimming;
        this.searchRange = searchRange;
    }

    @Override
    public int getMaxSearchNodes() {
        return maxSearchNodes;
    }

    @Override
    public double getDistanceCutoff() {
        return distanceCutoff;
    }

    @Override
    public boolean isAllowingJump() {
        return allowingJump;
    }

    @Override
    public boolean isAllowingSwimming() {
        return allowingSwimming;
    }

    @Override
    public double getSearchRange() {
        return searchRange;
    }

    public static class Builder implements MovementEngine.PathfindSettings.Builder {
        private int maxSearchNodes = 10000;
        private double distanceCutoff = 100.0;
        private boolean allowingJump = true;
        private boolean allowingSwimming = false;
        private double searchRange = 50.0;

        @Override
        public @NotNull Builder maxSearchNodes(int nodes) {
            this.maxSearchNodes = nodes;
            return this;
        }

        @Override
        public @NotNull Builder distanceCutoff(double distance) {
            this.distanceCutoff = distance;
            return this;
        }

        @Override
        public @NotNull Builder allowingJump(boolean jump) {
            this.allowingJump = jump;
            return this;
        }

        @Override
        public @NotNull Builder allowingSwimming(boolean swim) {
            this.allowingSwimming = swim;
            return this;
        }

        @Override
        public @NotNull Builder searchRange(double range) {
            this.searchRange = range;
            return this;
        }

        @Override
        public @NotNull PathfindSettingsImpl build() {
            return new PathfindSettingsImpl(maxSearchNodes, distanceCutoff, allowingJump, allowingSwimming, searchRange);
        }
    }
}
