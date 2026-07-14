package me.tofaa.testentitylib;

import com.github.retrooper.packetevents.protocol.attribute.Attributes;
import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerUpdateAttributes;
import io.github.retrooper.packetevents.util.SpigotConversionUtil;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import me.tofaa.entitylib.wrapper.WrapperLivingEntity;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class TestMassivePigCommand extends BukkitCommand {

    private WrapperEntity pig;

    public TestMassivePigCommand() {
        super("testmassivepig");
    }

    @Override
    public boolean execute(@NotNull CommandSender commandSender, @NotNull String s, @NotNull String[] strings) {
        if (!(commandSender instanceof Player)) return false;
        Player player = (Player) commandSender;
        if (pig != null) {
            pig.remove();
            pig = null;
            player.sendMessage("Large pig removed");
            return true;
        }
        pig = new WrapperEntity(EntityTypes.TNT);
        pig.addViewer(player.getUniqueId());
        pig.spawn(SpigotConversionUtil.fromBukkitLocation(player.getLocation()));
        player.sendMessage("Large pig spawned");
        return true;
    }
}
