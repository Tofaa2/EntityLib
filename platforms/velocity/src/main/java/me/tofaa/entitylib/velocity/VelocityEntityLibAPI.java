package me.tofaa.entitylib.velocity;

import com.github.retrooper.packetevents.protocol.world.Location;
import com.velocitypowered.api.proxy.ProxyServer;
import com.velocitypowered.api.scheduler.ScheduledTask;
import me.tofaa.entitylib.APIConfig;
import me.tofaa.entitylib.Platform;
import me.tofaa.entitylib.common.AbstractEntityLibAPI;
import me.tofaa.entitylib.tick.TickContainer;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class VelocityEntityLibAPI extends AbstractEntityLibAPI<ProxyServer, ScheduledTask> {


    public VelocityEntityLibAPI(VelocityEntityLibPlatform platform, APIConfig settings) {
        super(platform, settings);
    }

    @Override
    public void onLoad() {

    }

    @Override
    public void onEnable() {

    }

    @Override
    public void addTickContainer(@NotNull TickContainer tickContainer) {
        if (!settings.shouldTickTickables()) {
            if (settings.isDebugMode()) {
                platform.getLogger().log(Level.WARNING, "Tried to add a TickContainer when ticking tickables is disabled!");
            }
            return;
        }
        tickContainers.add(tickContainer);
        if (settings.isDebugMode()) {
            platform.getLogger().log(Level.CONFIG, "Registering new tick container...");
        }
        getTickContainers().add(tickContainer);
        Object plugin = ((VelocityEntityLibPlatform)platform).getPlugin();
        ScheduledTask task = platform.getHandle().getScheduler().buildTask(plugin, () -> tickContainer.tick(System.currentTimeMillis())).repeat(50L, TimeUnit.MILLISECONDS).schedule();
        tickContainer.setHandle(task);
    }

    @NotNull
    @Override
    public WrapperEntity cloneEntity(@NotNull Object platformEntity, @NotNull Location location) {
        throw new UnsupportedOperationException("No support for cloning entities on Velocity");
    }
}
