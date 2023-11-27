package me.tofaa.entitylib;

import com.github.retrooper.packetevents.PacketEvents;
import org.bukkit.plugin.java.JavaPlugin;

public final class EntityLibPlugin extends JavaPlugin {

    static EntityLibPlugin instance;

    @Override
    public void onEnable() {
        EntityLib.init(PacketEvents.getAPI());
        getCommand("testapi").setExecutor(new TestCommand());
        instance = this;
    }
}
