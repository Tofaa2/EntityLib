package me.tofaa.entitylib.movement;

import org.jetbrains.annotations.NotNull;

public class MovementSettingsImpl implements MovementEngine.MovementSettings {
    private final double speed;
    private final double speedModifier;
    private final boolean flying;
    private final double followDistance;
    private final double tickRate;
    private final boolean updatingViewers;
    private final boolean avoidingWater;
    private final boolean clampToGround;

    private MovementSettingsImpl(double speed, double speedModifier, boolean flying, double followDistance, double tickRate, boolean updatingViewers, boolean avoidingWater, boolean clampToGround) {
        this.speed = speed;
        this.speedModifier = speedModifier;
        this.flying = flying;
        this.followDistance = followDistance;
        this.tickRate = tickRate;
        this.updatingViewers = updatingViewers;
        this.avoidingWater = avoidingWater;
        this.clampToGround = clampToGround;
    }

    @Override
    public double getSpeed() {
        return speed;
    }

    @Override
    public double getSpeedModifier() {
        return speedModifier;
    }

    @Override
    public boolean isFlying() {
        return flying;
    }

    @Override
    public double getFollowDistance() {
        return followDistance;
    }

    @Override
    public double getTickRate() {
        return tickRate;
    }

    @Override
    public boolean isUpdatingViewers() {
        return updatingViewers;
    }

    @Override
    public boolean isAvoidingWater() {
        return avoidingWater;
    }

    @Override
    public boolean isClampToGround() {
        return clampToGround;
    }

    public static class Builder implements MovementEngine.MovementSettings.Builder {
        private double speed = 4.0;
        private double speedModifier = 1.0;
        private boolean flying = false;
        private double followDistance = 0.5;
        private double tickRate = 1.0;
        private boolean updatingViewers = true;
        private boolean avoidingWater = false;
        private boolean clampToGround = true;

        @Override
        public @NotNull Builder speed(double speed) {
            this.speed = speed;
            return this;
        }

        @Override
        public @NotNull Builder speedModifier(double modifier) {
            this.speedModifier = modifier;
            return this;
        }

        @Override
        public @NotNull Builder flying(boolean flying) {
            this.flying = flying;
            return this;
        }

        @Override
        public @NotNull Builder followDistance(double distance) {
            this.followDistance = distance;
            return this;
        }

        @Override
        public @NotNull Builder tickRate(double rate) {
            this.tickRate = rate;
            return this;
        }

        @Override
        public @NotNull Builder updatingViewers(boolean update) {
            this.updatingViewers = update;
            return this;
        }

        @Override
        public @NotNull Builder avoidingWater(boolean avoid) {
            this.avoidingWater = avoid;
            return this;
        }

        @Override
        public @NotNull Builder clampToGround(boolean clamp) {
            this.clampToGround = clamp;
            return this;
        }

        @Override
        public @NotNull MovementSettingsImpl build() {
            return new MovementSettingsImpl(speed, speedModifier, flying, followDistance, tickRate, updatingViewers, avoidingWater, clampToGround);
        }
    }
}
