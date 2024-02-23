package me.tofaa.entitylib.velocity;

import com.velocitypowered.api.proxy.ProxyServer;
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
