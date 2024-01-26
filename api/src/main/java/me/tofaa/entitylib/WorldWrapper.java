package me.tofaa.entitylib;

import com.github.retrooper.packetevents.protocol.world.states.WrappedBlockState;
import com.github.retrooper.packetevents.resources.ResourceLocation;

/**
 * Represents a platform specific world.
 * These are not needed at all times, and should exclusively be used when an Entity needs to be
 * aware of its surroundings.
 * @param <W> The platform specific World type.
 */
public interface WorldWrapper<W> {

    ResourceLocation getPacketEventsWorld();

    WrappedBlockState getBlock(int x, int y, int z);

    W getHandle();
}
