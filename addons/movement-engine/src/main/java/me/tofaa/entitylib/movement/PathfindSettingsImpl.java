package me.tofaa.entitylib.movement;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class PathfindSettingsImpl implements MovementEngine.PathfindSettings {
    private final int maxSearchNodes;
    private final double distanceCutoff;
    private final boolean allowingJump;
    private final boolean allowingSwimming;
    private final double searchRange;
    private final boolean flying;
    private final int entityHeight;
    private final int maxDropHeight;
    private final boolean smoothing;
    private final boolean avoidingWater;

    private PathfindSettingsImpl(Builder builder) {
        this.maxSearchNodes = builder.maxSearchNodes;
        this.distanceCutoff = builder.distanceCutoff;
        this.allowingJump = builder.allowingJump;
        this.allowingSwimming = builder.allowingSwimming;
        this.searchRange = builder.searchRange;
        this.flying = builder.flying;
        this.entityHeight = builder.entityHeight;
        this.maxDropHeight = builder.maxDropHeight;
        this.smoothing = builder.smoothing;
        this.avoidingWater = builder.avoidingWater;
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

    @Override
    public boolean isFlying() {
        return flying;
    }

    @Override
    public int getEntityHeight() {
        return entityHeight;
    }

    @Override
    public int getMaxDropHeight() {
        return maxDropHeight;
    }

    @Override
    public boolean isSmoothing() {
        return smoothing;
    }

    @Override
    public boolean isAvoidingWater() {
        return avoidingWater;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PathfindSettingsImpl)) return false;
        PathfindSettingsImpl other = (PathfindSettingsImpl) o;
        return maxSearchNodes == other.maxSearchNodes && Double.compare(distanceCutoff, other.distanceCutoff) == 0
            && allowingJump == other.allowingJump && allowingSwimming == other.allowingSwimming
            && Double.compare(searchRange, other.searchRange) == 0 && flying == other.flying
            && entityHeight == other.entityHeight && maxDropHeight == other.maxDropHeight && smoothing == other.smoothing
            && avoidingWater == other.avoidingWater;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxSearchNodes, distanceCutoff, allowingJump, allowingSwimming, searchRange, flying,
            entityHeight, maxDropHeight, smoothing, avoidingWater);
    }

    public static class Builder implements MovementEngine.PathfindSettings.Builder {
        private int maxSearchNodes = 10000;
        private double distanceCutoff = 100.0;
        private boolean allowingJump = true;
        private boolean allowingSwimming = false;
        private double searchRange = 50.0;
        private boolean flying = false;
        private int entityHeight = 2;
        private int maxDropHeight = 3;
        private boolean smoothing = true;
        private boolean avoidingWater = false;

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
        public @NotNull Builder flying(boolean flying) {
            this.flying = flying;
            return this;
        }

        @Override
        public @NotNull Builder entityHeight(int blocks) {
            this.entityHeight = Math.max(1, blocks);
            return this;
        }

        @Override
        public @NotNull Builder maxDropHeight(int blocks) {
            this.maxDropHeight = Math.max(0, blocks);
            return this;
        }

        @Override
        public @NotNull Builder smoothing(boolean smoothing) {
            this.smoothing = smoothing;
            return this;
        }

        @Override
        public @NotNull Builder avoidingWater(boolean avoid) {
            this.avoidingWater = avoid;
            return this;
        }

        @Override
        public @NotNull MovementEngine.PathfindSettings build() {
            return new PathfindSettingsImpl(this);
        }
    }
}
