package me.tofaa.entitylib;

import com.github.retrooper.packetevents.PacketEventsAPI;
import me.tofaa.entitylib.tick.TickContainer;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

/**
 * Represents the API for EntityLib.
 * Handles the loading, enabling, and disabling of the API. And handles platform specific creation of EntityLib content.
 * @param <W> The {@link WorldWrapper}'s param type for the platform specific World.
 * @param <T> The {@link TickContainer}'s param type for the platform specific TickContainer.
 */
public interface EntityLibAPI<W, T> {

    PacketEventsAPI<?> getPacketEvents();

    void onLoad();

    void onEnable();

    @NotNull APISettings getSettings();


    /**
     * If a platform supports ticking
     * this method should be responsible for setting up the {@link me.tofaa.entitylib.tick.TickContainer}'s.
     */
    void setupTickingContainers();


    /**
     * @return An unmodifiable collection of TickContainers.
     */
    @NotNull Collection<TickContainer<?, T>> getTickContainers();

    /**
     * Adds a TickContainer to the API. Automatically starts ticking it.
     * @param tickContainer the TickContainer to add.
     */
    void addTickContainer(@NotNull TickContainer<?, T> tickContainer);
}
