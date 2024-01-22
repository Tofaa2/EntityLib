package me.tofaa.entitylib;

import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.protocol.world.Location;
import io.github.retrooper.packetevents.util.SpigotConversionUtil;
import me.tofaa.entitylib.entity.WrapperEntity;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class TestCommand implements CommandExecutor {

    private WrapperEntity base, passenger;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) return false;
        Player player = (Player) sender;

        if (base != null) {
            if (base.hasPassenger(passenger)) {
                base.removePassenger(passenger);
                player.sendMessage("Removed");
                return true;
            }
        }

        base = EntityLib.createEntity(UUID.randomUUID(), EntityTypes.SHEEP);
        passenger = EntityLib.createEntity(UUID.randomUUID(), EntityTypes.SKELETON);

        Location location = SpigotConversionUtil.fromBukkitLocation(player.getLocation());
        Location pass = new Location(location.getX() + 1, location.getY(), location.getZ(), location.getYaw(), location.getPitch());

        base.spawn(location);
        passenger.spawn(pass);
        player.sendMessage("Spawned");

        return true;
    }

}
