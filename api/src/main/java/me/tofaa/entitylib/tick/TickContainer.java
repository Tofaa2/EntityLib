package me.tofaa.entitylib.tick;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents a storage/container for {@link Tickable}s.
 * @param <T> The type of {@link Tickable} to store.
 * @param <H> If a platform enforces a specific method of ticking, this type represents the handler for that method.
 */
public abstract class TickContainer<T extends Tickable, H> {

    private final Set<T> tickables = new HashSet<>();
    private H handle;

    /**
     * @return The {@link Tickable}s stored in this container. This collection is immutable
     */
    public @NotNull Collection<T> getTickables() {
        return Collections.unmodifiableCollection(tickables);
    }

    /**
     * Adds a {@link Tickable} to this container.
     * @param tickable The {@link Tickable} to add.
     * @return {@code true} if the {@link Tickable} was added, {@code false} otherwise.
     */
    public boolean addTickable(@NotNull T tickable) {
        return tickables.add(tickable);
    }

    /**
     * Removes a {@link Tickable} from this container.
     * @param tickable The {@link Tickable} to remove.
     * @return {@code true} if the {@link Tickable} was removed, {@code false} otherwise.
     */
    public boolean removeTickable(T tickable) {
        return tickables.remove(tickable);
    }

    /**
     * Ticks all {@link Tickable}s in this container, this method can be overriden to provide a custom implementation.
     * @param time The current time in milliseconds, incase the {@link Tickable} needs to know the current time.
     */
    public void tick(long time) {
        for (T tickable : tickables) {
            tickable.tick(time);
        }
    }

    /**
     * @return The handler for this container.
     */
    public @NotNull H getHandle() {
        return handle;
    }

    /**
     * Sets the handler for this container. This method is only used internally.
     * @param handle The handler to set.
     */
    @ApiStatus.Internal
    public void setHandle(@NotNull H handle) {
        this.handle = handle;
    }

}
