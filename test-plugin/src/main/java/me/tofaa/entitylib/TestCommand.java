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
            base.removePassenger(passenger);
            player.sendMessage("Removed");
            return true;
        }

        base = EntityLib.createEntity(UUID.randomUUID(), EntityTypes.SHEEP);
        passenger = EntityLib.createEntity(UUID.randomUUID(), EntityTypes.SKELETON);

        Location location = SpigotConversionUtil.fromBukkitLocation(player.getLocation());
        Location pass = location.clone();
        pass.setPosition(location.getPosition().add(1, 0, 1));
        base.spawn(location);
        passenger.spawn(pass);
        base.addPassenger(passenger);

        player.sendMessage("Spawned");

        return true;
    }

}
