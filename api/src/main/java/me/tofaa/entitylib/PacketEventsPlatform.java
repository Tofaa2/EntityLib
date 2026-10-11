package me.tofaa.entitylib;

import com.github.retrooper.packetevents.PacketEventsAPI;
import com.github.retrooper.packetevents.protocol.player.User;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public class PacketEventsPlatform implements EntityLibPlatform {

    protected final PacketEventsAPI<?> packetEvents;
    protected final Logger logger;
    private final AtomicInteger entityIds = new AtomicInteger(100000);
    private UserLocaleProvider userLocaleProvider = user -> Locale.US;

    public PacketEventsPlatform(@NotNull PacketEventsAPI<?> packetEvents, @NotNull Logger logger) {
        this.packetEvents = packetEvents;
        this.logger = logger;
    }

    @Override
    public @NotNull PacketEventsAPI<?> getPacketEvents() {
        return packetEvents;
    }

    @Override
    public @NotNull Logger getLogger() {
        return logger;
    }

    @Override
    public void sendPacket(@NotNull UUID user, @NotNull PacketWrapper<?> packet) {
        Object channel = packetEvents.getProtocolManager().getChannel(user);
        if (channel != null) {
            packetEvents.getProtocolManager().sendPacket(channel, packet);
        }
    }

    @Override
    public int getProtocolVersion(@NotNull UUID user) {
        Object channel = packetEvents.getProtocolManager().getChannel(user);
        User packetUser = channel == null ? null : packetEvents.getProtocolManager().getUser(channel);
        if (packetUser == null) {
            return getServerProtocolVersion();
        }
        return packetUser.getClientVersion().getProtocolVersion();
    }

    @Override
    public int nextEntityId() {
        return entityIds.incrementAndGet();
    }

    @Override
    public @NotNull UserLocaleProvider getUserLocaleProvider() {
        return userLocaleProvider;
    }

    @Override
    public void setUserLocaleProvider(@NotNull UserLocaleProvider provider) {
        this.userLocaleProvider = provider;
    }

    protected int getServerProtocolVersion() {
        return packetEvents.getServerManager().getVersion().getProtocolVersion();
    }

}
