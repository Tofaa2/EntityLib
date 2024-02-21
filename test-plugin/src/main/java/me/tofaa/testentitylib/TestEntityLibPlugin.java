package me.tofaa.testentitylib;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.protocol.player.UserProfile;
import io.github.retrooper.packetevents.util.SpigotConversionUtil;
import me.tofaa.entitylib.APIConfig;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.meta.mobs.passive.ChickenMeta;
import me.tofaa.entitylib.spigot.SpigotEntityLibAPI;
import me.tofaa.entitylib.spigot.SpigotEntityLibPlatform;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import me.tofaa.entitylib.event.types.*;
import me.tofaa.entitylib.wrapper.WrapperPlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class TestEntityLibPlugin extends JavaPlugin implements CommandExecutor {


    private SpigotEntityLibAPI api;
    private WrapperPlayer e;

    @Override
    public void onEnable() {

        SpigotEntityLibPlatform platform = new SpigotEntityLibPlatform(this);
        APIConfig settings = new APIConfig(PacketEvents.getAPI())
                .debugMode()
                .tickTickables()
                .trackPlatformEntities()
                .usePlatformLogger();

        EntityLib.init(platform, settings);
        api = platform.getAPI();
        getCommand("testapi").setExecutor(this);
        platform.getEventHandler().addEventCallback(UserTrackingEntityEvent.class, event -> {
            event.getUser().sendMessage("Tracking: " + event.getEntity().getEntityId());
            event.getUser().sendMessage("Size: " + platform.queryPlatformEntities().toArray().length);
        });
        platform.getEventHandler().addEventCallback(UserStopTrackingEntityEvent.class, event -> {
            event.getUser().sendMessage("Stop Tracking: " + event.getEntity().getEntityId());
            event.getUser().sendMessage("Size: " + platform.queryPlatformEntities().toArray().length);
        });
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) return false;
        Player player = (Player) sender;
        if (e != null) {
            e.remove();
            player.sendMessage("Removed");
            e = null;
            return true;
        }
        UUID uuid = UUID.randomUUID();
        UserProfile profile = new UserProfile(uuid, "RandomGoon");
        e = new WrapperPlayer(profile, EntityLib.getPlatform().getEntityIdProvider().provide(uuid, EntityTypes.PLAYER));
        e.addViewer(player.getUniqueId());
        api.spawnEntity(e, SpigotConversionUtil.fromBukkitLocation(player.getLocation()));
        player.sendMessage("Spawned");
        return true;
    }

}
