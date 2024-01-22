package me.tofaa.entitylib;

import com.github.retrooper.packetevents.PacketEventsAPI;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public interface EntityLibPlatform<W> {

    @NotNull PacketEventsAPI<?> getPacketEvents();

    @NotNull WrapperWorld<W> createWorld(UUID uuid, String name);


}
