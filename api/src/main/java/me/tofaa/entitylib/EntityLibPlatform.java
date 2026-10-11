package me.tofaa.entitylib;

import com.github.retrooper.packetevents.PacketEventsAPI;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;
import java.util.logging.Logger;

public interface EntityLibPlatform {

    @NotNull PacketEventsAPI<?> getPacketEvents();

    @NotNull Logger getLogger();

    void sendPacket(@NotNull UUID user, @NotNull PacketWrapper<?> packet);

    int getProtocolVersion(@NotNull UUID user);

    int nextEntityId();

    @NotNull UserLocaleProvider getUserLocaleProvider();

    void setUserLocaleProvider(@NotNull UserLocaleProvider provider);

    default void setup(@NotNull APIConfig config) {
    }

}
