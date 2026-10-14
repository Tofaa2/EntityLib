package me.tofaa.entitylib.movement;

import com.github.retrooper.packetevents.protocol.world.Location;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Supplier;

public interface MovementEngine {
    @NotNull Executor getPathfindingExecutor();

    @NotNull CompletableFuture<@Nullable Path> findPath(
            @NotNull Location from,
            @NotNull Location to,
            @NotNull PathfindSettings settings
    );

    @NotNull CompletableFuture<@Nullable Path> findPath(
            @NotNull WrapperEntity entity,
            @NotNull Location to,
            @NotNull PathfindSettings settings
    );

    @NotNull CompletableFuture<Boolean> moveToPath(
            @NotNull WrapperEntity entity,
            @NotNull Path path,
            @NotNull MovementSettings settings
    );

    @NotNull CompletableFuture<Boolean> navigate(
            @NotNull WrapperEntity entity,
            @NotNull Location target,
            @NotNull PathfindSettings pathfindSettings,
            @NotNull MovementSettings movementSettings
    );

    @NotNull CompletableFuture<Boolean> follow(
            @NotNull WrapperEntity entity,
            @NotNull Supplier<Location> target,
            @NotNull PathfindSettings pathfindSettings,
            @NotNull MovementSettings movementSettings
    );

    void tick();

    void stopMovement(@NotNull WrapperEntity entity);

    boolean isMoving(@NotNull WrapperEntity entity);

    void clearCache();

    @Nullable Path getCachedPath(@NotNull Location from, @NotNull Location to);

    void cachePath(@NotNull Path path);

    interface Path {
        @NotNull List<Location> getPoints();

        @NotNull Location getStart();

        @NotNull Location getEnd();

        double getTotalDistance();

        int getSize();
    }

    interface PathfindSettings {
        static PathfindSettings.Builder builder() {
            return new PathfindSettingsImpl.Builder();
        }

        int getMaxSearchNodes();

        double getDistanceCutoff();

        boolean isAllowingJump();

        boolean isAllowingSwimming();

        double getSearchRange();

        boolean isFlying();

        int getEntityHeight();

        int getMaxDropHeight();

        boolean isSmoothing();

        boolean isAvoidingWater();

        interface Builder {
            @NotNull Builder maxSearchNodes(int nodes);

            @NotNull Builder distanceCutoff(double distance);

            @NotNull Builder allowingJump(boolean jump);

            @NotNull Builder allowingSwimming(boolean swim);

            @NotNull Builder searchRange(double range);

            @NotNull Builder flying(boolean flying);

            @NotNull Builder entityHeight(int blocks);

            @NotNull Builder maxDropHeight(int blocks);

            @NotNull Builder smoothing(boolean smoothing);

            @NotNull Builder avoidingWater(boolean avoid);

            @NotNull PathfindSettings build();
        }
    }

    interface MovementSettings {
        static MovementSettings.Builder builder() {
            return new MovementSettingsImpl.Builder();
        }

        double getSpeed();

        double getSpeedModifier();

        boolean isFlying();

        double getFollowDistance();

        double getTickRate();

        boolean isUpdatingViewers();

        boolean isClampToGround();

        interface Builder {
            @NotNull Builder speed(double speed);

            @NotNull Builder speedModifier(double modifier);

            @NotNull Builder flying(boolean flying);

            @NotNull Builder followDistance(double distance);

            @NotNull Builder tickRate(double rate);

            @NotNull Builder updatingViewers(boolean update);

            @NotNull Builder clampToGround(boolean clamp);

            @NotNull MovementSettings build();
        }
    }
}
