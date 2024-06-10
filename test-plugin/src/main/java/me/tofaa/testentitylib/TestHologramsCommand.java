package me.tofaa.testentitylib;

import io.github.retrooper.packetevents.util.SpigotConversionUtil;
import me.tofaa.entitylib.wrapper.hologram.Hologram;
import net.kyori.adventure.text.Component;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class TestHologramsCommand extends BukkitCommand {


    TestHologramsCommand () {
        super("testholo");
    }

    @Override
    public boolean execute(@NotNull CommandSender commandSender, @NotNull String s, @NotNull String[] strings) {
        if (strings.length == 0) {
            commandSender.sendMessage("Usage: /testholo <legacy|modern>");
            return true;
        }
        Player player = (Player) commandSender;
        if (strings[0].equalsIgnoreCase("modern")) {
             Hologram.Modern holo =Hologram.modern(SpigotConversionUtil.fromBukkitLocation(player.getLocation()));
            holo.addLine(Component.text("Hello, World!"));
            holo.show();
            holo.addViewer(player.getUniqueId());
        }
        if (strings[0].equalsIgnoreCase("legacy")) {
            Hologram.Legacy holo = Hologram.legacy(SpigotConversionUtil.fromBukkitLocation(player.getLocation()));
            holo.addLine(Component.text("Hello, World!"));
            holo.show();
            holo.addViewer(player.getUniqueId());
        }
        return true;
    }

    @NotNull
    @Override
    public List<String> tabComplete(@NotNull CommandSender sender, @NotNull String alias, @NotNull String[] args) throws IllegalArgumentException {
        return Arrays.asList("legacy", "modern");
    }
}
