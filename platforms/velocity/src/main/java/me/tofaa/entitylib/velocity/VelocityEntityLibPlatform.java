package me.tofaa.entitylib.velocity;

import com.github.retrooper.packetevents.PacketEventsAPI;
import com.velocitypowered.api.proxy.ProxyServer;
import me.tofaa.entitylib.PacketEventsPlatform;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Logger;

public class VelocityEntityLibPlatform extends PacketEventsPlatform {

    private final Object plugin;
    private final ProxyServer proxy;

    public VelocityEntityLibPlatform(@NotNull Object plugin, @NotNull ProxyServer proxy, @NotNull PacketEventsAPI<?> packetEvents) {
        super(packetEvents, Logger.getLogger("EntityLib"));
        this.plugin = plugin;
        this.proxy = proxy;
    }

    public @NotNull Object getPlugin() {
        return plugin;
    }

    public @NotNull ProxyServer getProxy() {
        return proxy;
    }

}
