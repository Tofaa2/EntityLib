package me.tofaa.entitylib;

import com.github.retrooper.packetevents.PacketEventsAPI;
import me.tofaa.entitylib.tick.TickContainer;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

/**
 * Represents the API for EntityLib.
 * Handles the loading, enabling, and disabling of the API. And handles platform specific creation of EntityLib content.
 * @param <W> The {@link WorldWrapper}'s param type for the platform specific World.
 * @param <T> The {@link TickContainer}'s param type for the platform specific TickContainer.
 */
public interface EntityLibAPI<W, T> {



    /**
     * @return The {@link PacketEventsAPI} that EntityLib uses.
     */
    PacketEventsAPI<?> getPacketEvents();

    void onLoad();

    void onEnable();

    /**
     * Attempts to search and find an entity across all wrapped worlds. This only works on EntityLib entities.
     * @param entityId the entity id of the entity
     * @return the entity if one is found, null otherwise.
     */
    @Nullable WrapperEntity findEntity(int entityId);

    /**
     * Mainly internal method to register the {@link WrapperEntity} to EntitLib cache, all {@link WorldWrapper}'s do this automatically
     * @param entity
     */
    @ApiStatus.Internal
    void globalRegisterEntity(@NotNull WrapperEntity entity);

    /**
     * Mainly internal method to unregister the {@link WrapperEntity} to EntitLib cache, all {@link WorldWrapper}'s do this automatically
     * @param entity
     */
    void globalUnregisterEntity(@NotNull WrapperEntity entity);


    /**
     * Creates a wrapped world for the platform specific world.
     * @param world The platform specific world handle.
     * @return A wrapped world.
     */
    @NotNull WorldWrapper<W> wrapWorld(W world);

    /**
     * @return The {@link APIConfig} for the API.
     */
    @NotNull APIConfig getSettings();

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
