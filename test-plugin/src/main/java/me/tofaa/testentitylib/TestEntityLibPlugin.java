package me.tofaa.testentitylib;

import com.github.retrooper.packetevents.PacketEvents;
import me.tofaa.entitylib.APIConfig;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.spigot.SpigotEntityLibPlatform;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.InvocationTargetException;

public class TestEntityLibPlugin extends JavaPlugin {

    @Override
    public void onEnable() {

        SpigotEntityLibPlatform platform = new SpigotEntityLibPlatform(this);
        APIConfig settings = new APIConfig(PacketEvents.getAPI())
                .debugMode()
                .checkForUpdates()
                .tickTickables()
                .useBstats()
                .usePlatformLogger();

        EntityLib.init(platform, settings);

        CommandMap commandMap;
        try {
            commandMap = (CommandMap) Bukkit.getServer().getClass().getMethod("getCommandMap").invoke(Bukkit.getServer());
            commandMap.register("testapi", new TestTextDisplayCommand());
            commandMap.register("testplayer", new TestPlayerCommand());
            commandMap.register("testholo", new TestHologramsCommand());
            commandMap.register("testmassivepig", new TestMassivePigCommand());
        }
        catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }



    }


}
