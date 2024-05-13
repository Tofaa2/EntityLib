package me.tofaa.entitylib.velocity;

import com.github.retrooper.packetevents.PacketEventsAPI;
import com.github.retrooper.packetevents.protocol.packettype.PacketType;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerBlockAction;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerBlockChange;
import com.velocitypowered.api.plugin.PluginContainer;
import com.velocitypowered.api.proxy.ProxyServer;
import io.github.retrooper.packetevents.bstats.Metrics;
import io.github.retrooper.packetevents.velocity.factory.VelocityPacketEventsBuilder;
import me.tofaa.entitylib.APIConfig;
import me.tofaa.entitylib.EntityLibAPI;
import me.tofaa.entitylib.common.AbstractPlatform;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Logger;

public class VelocityEntityLibPlatform extends AbstractPlatform<ProxyServer> {
    private VelocityEntityLibAPI api;
    private Object plugin;

    public VelocityEntityLibPlatform(Object plugin, ProxyServer handle) {
        super(handle);
        this.plugin = plugin;
    }

    @Override
    public void setupApi(@NotNull APIConfig settings) {
        super.setupApi(settings);
        this.logger = Logger.getLogger("EntityLib"); // Velocity does not have a logger by default.
        this.api = new VelocityEntityLibAPI(this, settings);
        this.api.onLoad();
        this.api.onEnable();
//        if (settings.shouldUseBstats()) {
//            VelocityPacketEventsBuilder
//            PacketEventsAPI<PluginContainer> pe = (PacketEventsAPI<PluginContainer>) api.getPacketEvents();
//            Metrics metrics = Metrics.createInstance(
//                    plugin,
//                    handle,
//                    logger,
//                    pe.getSettings().
//        }
    }

    public Object getPlugin() {
        return plugin;
    }

    @Override
    public EntityLibAPI<?> getAPI() {
        return api;
    }

    @Override
    public String getName() {
        return "Velocity";
    }
}
