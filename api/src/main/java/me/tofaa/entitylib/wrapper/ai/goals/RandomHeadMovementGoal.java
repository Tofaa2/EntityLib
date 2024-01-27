package me.tofaa.entitylib.wrapper.ai.goals;

import com.github.retrooper.packetevents.util.Vector3d;
import me.tofaa.entitylib.extras.CoordinateUtil;
import me.tofaa.entitylib.wrapper.WrapperEntityCreature;
import me.tofaa.entitylib.wrapper.ai.GoalSelector;
import org.jetbrains.annotations.NotNull;

import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;

public class RandomHeadMovementGoal extends GoalSelector {

    private static final Random RANDOM = new Random();
    private final int chancePerTick;
    private final Supplier<Integer> minimalLookTimeSupplier;
    private final Function<WrapperEntityCreature, Vector3d> randomDirectionFunction;
    private Vector3d lookDirection;
    private int lookTime = 0;

    public RandomHeadMovementGoal(WrapperEntityCreature entityCreature, int chancePerTick) {
        this(entityCreature, chancePerTick,
                // These two functions act similarly enough to how MC randomly looks around.
                // Look in one direction for at most 40 ticks and at minimum 20 ticks.
                () -> 20 + RANDOM.nextInt(20),
                // Look at a random block
                (creature) -> {
                    final double n = Math.PI * 2 * RANDOM.nextDouble();
                    return new Vector3d(
                            (float) Math.cos(n),
                            0,
                            (float) Math.sin(n)
                    );
                });
    }

    /**
     * @param entityCreature          Creature that should randomly look around.
     * @param chancePerTick           The chance (per tick) that the entity looks around. Setting this to N would mean there is a 1 in N chance.
     * @param minimalLookTimeSupplier A supplier that returns the minimal amount of time an entity looks in a direction.
     * @param randomDirectionFunction A function that returns a random vector that the entity will look in/at.
     */
    public RandomHeadMovementGoal(
            WrapperEntityCreature entityCreature,
            int chancePerTick,
            @NotNull Supplier<Integer> minimalLookTimeSupplier,
            @NotNull Function<WrapperEntityCreature, Vector3d> randomDirectionFunction) {
        super(entityCreature);
        this.chancePerTick = chancePerTick;
        this.minimalLookTimeSupplier = minimalLookTimeSupplier;
        this.randomDirectionFunction = randomDirectionFunction;
    }

    @Override
    public boolean shouldStart() {
        return RANDOM.nextInt(chancePerTick) == 0;
    }

    @Override
    public void start() {
        lookTime = minimalLookTimeSupplier.get();
        lookDirection = randomDirectionFunction.apply(entity);
    }

    @Override
    public void tick(long time) {
        --lookTime;
        entity.teleport(CoordinateUtil.withDirection(entity.getLocation(), lookDirection));
    }

    @Override
    public boolean shouldEnd() {
        return this.lookTime < 0;
    }

    @Override
    public void end() {

    }
}
