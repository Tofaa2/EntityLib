package me.tofaa.testentitylib;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import io.github.retrooper.packetevents.util.SpigotConversionUtil;
import me.tofaa.entitylib.APIConfig;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.EntityLibAPI;
import me.tofaa.entitylib.WorldWrapper;
import me.tofaa.entitylib.meta.mobs.passive.ChickenMeta;
import me.tofaa.entitylib.spigot.SpigotEntityLibPlatform;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public class TestEntityLibPlugin extends JavaPlugin implements Listener {


    private EntityLibAPI<World, BukkitTask> api;
    private WrapperEntity e;
    private WorldWrapper<World> world;

    @Override
    public void onEnable() {

        SpigotEntityLibPlatform platform = new SpigotEntityLibPlatform(this);
        APIConfig settings = new APIConfig(PacketEvents.getAPI())
                .debugMode()
                .tickTickables()
                .usePlatformLogger();

        EntityLib.init(platform, settings);
        api = EntityLib.getApi();
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onCrouch(PlayerToggleSneakEvent event) {
        Player player = event.getPlayer();
        if (e != null) {
            e.remove();
            e = null;
        }
        world = api.wrapWorld(player.getWorld());
        e = world.spawnEntity(EntityTypes.CHICKEN, SpigotConversionUtil.fromBukkitLocation(player.getLocation()));
        ChickenMeta meta = (ChickenMeta) e.getEntityMeta();
        meta.setBaby(!meta.isBaby());
        meta.setHasGlowingEffect(!meta.hasGlowingEffect());
    }

}
