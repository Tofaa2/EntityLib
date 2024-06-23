package me.tofaa.entitylib.standalone;

import com.github.retrooper.packetevents.protocol.world.Location;
import me.tofaa.entitylib.APIConfig;
import me.tofaa.entitylib.Platform;
import me.tofaa.entitylib.common.AbstractEntityLibAPI;
import me.tofaa.entitylib.standalone.task.ExecutionType;
import me.tofaa.entitylib.standalone.task.Scheduler;
import me.tofaa.entitylib.standalone.task.Task;
import me.tofaa.entitylib.standalone.task.TaskSchedule;
import me.tofaa.entitylib.tick.TickContainer;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Level;

public class StandaloneEntityLibApi extends AbstractEntityLibAPI<Object, Task> {

    private final Scheduler scheduler = Scheduler.newScheduler();

    protected StandaloneEntityLibApi(Platform<Object> platform, APIConfig settings) {
        super(platform, settings);
    }

    @Override
    public void onLoad() {

    }

    @Override
    public void onEnable() {

    }


    @Override
    public <P extends WrapperEntity> @NotNull P cloneEntity(@NotNull Object platformEntity) {
        throw new UnsupportedOperationException("Not supported in standalone mode");
    }

    @Override
    public void addTickContainer(@NotNull TickContainer<?, Task> tickContainer) {
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
        Task task = scheduler.scheduleTask(() -> tickContainer.tick(System.currentTimeMillis()), TaskSchedule.duration(50L), TaskSchedule.duration(50L), ExecutionType.ASYNC);
        tickContainer.setHandle(task);
    }
}
