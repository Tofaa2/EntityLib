package me.tofaa.testentitylib;

import io.github.retrooper.packetevents.util.SpigotConversionUtil;
import me.tofaa.entitylib.spigot.SpigotEntityLibPlatform;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class TestCloneCommand extends BukkitCommand {

    private final SpigotEntityLibPlatform platform;

    public TestCloneCommand(SpigotEntityLibPlatform platform) {
        super("testclone");
        this.platform = platform;
    }

    @Override
    public boolean execute(@NotNull CommandSender commandSender, @NotNull String s, @NotNull String[] strings) {
        if (!(commandSender instanceof Player)) return true;
        Player player = (Player) commandSender;
        Entity target = player;
        for (Entity nearby : player.getNearbyEntities(5, 5, 5)) {
            target = nearby;
            break;
        }
        WrapperEntity clone = platform.cloneEntity(target);
        clone.addViewer(player.getUniqueId());
        clone.spawn(SpigotConversionUtil.fromBukkitLocation(player.getLocation().add(2, 0, 0)));
        player.sendMessage("Cloned " + target.getType());
        return true;
    }

}
