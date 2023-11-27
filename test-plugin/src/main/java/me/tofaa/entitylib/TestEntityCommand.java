package me.tofaa.entitylib;

import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.protocol.world.Location;
import me.tofaa.entitylib.entity.WrapperEntity;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class TestEntityCommand implements CommandExecutor {

    private WrapperEntity entity;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) return false;
        Player player = (Player) sender;

        if (entity == null) {
            entity = EntityLib.createEntity(UUID.randomUUID(), EntityTypes.PIG);
            if (entity == null) {
                player.sendMessage("idk");
                return false;
            }
        }

        if (entity.hasSpawned()) {
            entity.remove();
            player.sendMessage("removed");
        }
        else {
            entity.addViewer(player.getUniqueId());
            entity.spawn(fromBukkit(player.getLocation()));
            player.sendMessage("spawned");
        }

        return false;
    }

    public static Location fromBukkit(org.bukkit.Location location) {
        return new Location(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
    }

}
